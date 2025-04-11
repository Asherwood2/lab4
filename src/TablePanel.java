import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//lab4
public class TablePanel extends JPanel implements ListSelectionListener {
    private JTable jtable;
    private JScrollPane jsp;
    private JLabel lbl;

    //Creating Jtable by passing in the two arrays made in JTableCalculation
    public TablePanel(String[] columns, Object[][] data) {
        jtable = new JTable(data, columns);
        jtable.setRowHeight(30);

        // jtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int i = 0; i < columns.length; i++) {
            if (i != 2) {
                jtable.getColumnModel().getColumn(i).setPreferredWidth(130);
            }
        }
        jtable.getColumnModel().getColumn(2).setPreferredWidth(100);

        //Creating scroll pane to be able to scroll
        jsp = new JScrollPane(jtable);
        lbl = new JLabel();
        jtable.getSelectionModel().addListSelectionListener(this);
    }

    //Method for outputting info about a row when clicked on
    @Override
    public void valueChanged(ListSelectionEvent e) {

        if (!e.getValueIsAdjusting()) {
            int selectedRow = jtable.getSelectedRow();
            if (selectedRow != -1) {
                // Get the GDP values for the selected row, starting from column 3 onwards
                double sum = 0;
                int count = 0;

                //Starting at the 4th column where GDP starts
                for (int i = 3; i < jtable.getColumnCount(); i++) {
                    Object value = jtable.getValueAt(selectedRow, i);
                    if (value != null && value instanceof String && !((String) value).equals("N/A")) {
                        try {
                            sum += Double.parseDouble((String) value);
                            count++;
                        } catch (NumberFormatException ex) {

                        }
                    }
                }

                // Calculate the average GDP for the selected row
                double average = (count > 0) ? sum / count : 0;

                // Display the average GDP in the JLabel
                showAverageGDP(average);
            }
        }
    }

    // Method to set the average GDP in the JLabel
    private void showAverageGDP(double average) {
        String averageText = "Average GDP: (" + String.format("%.2f", average) + ")";
        lbl.setText(averageText);
    }

    public JScrollPane getScrollPane() {
        return jsp;
    }
    public JLabel getAverageGDPLabel() {
        return lbl;
    }
}


