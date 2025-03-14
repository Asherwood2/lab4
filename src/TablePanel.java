import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class TablePanel extends JPanel {
    private JTable jtable;
    private JScrollPane jsp;
    private JLabel lbl;


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


        jtable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Ensure that the change is not caused by the selection model itself
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jtable.getSelectedRow();
                    if (selectedRow != -1) {
                        // Get the GDP values for the selected row, starting from column 3 onwards
                        double sum = 0;
                        int count = 0;

                        // Assuming GDP values start from column 3 onwards (index 3, 4, etc.)
                        for (int i = 3; i < jtable.getColumnCount(); i++) {
                            Object value = jtable.getValueAt(selectedRow, i);
                            if (value != null && value instanceof String && !((String) value).equals("N/A")) {
                                try {
                                    sum += Double.parseDouble((String) value);
                                    count++;
                                } catch (NumberFormatException ex) {
                                    // Handle non-numeric values if any (you can skip or log them)
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
        });


    }
    // Method to set the average GDP in the JLabel
    private void showAverageGDP (double average){
        String averageText = "Average GDP: (" + String.format("%.2f", average) + ")";
        if (lbl == null) {
            lbl = new JLabel();  // Create the JLabel if it doesn't exist
        }
        lbl.setText(averageText);  // Update the JLabel with the new average
    }
    public JScrollPane getScrollPane() {
        return jsp;
    }
}
