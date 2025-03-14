import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {
    private JTable jtable;
    private JScrollPane jsp;


    public TablePanel(String[] columns, Object[][] data) {
        jtable = new JTable(data, columns);
        jtable.setRowHeight(30);
        jtable.setPreferredScrollableViewportSize(new Dimension(1000, 750));
        jtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        for (int i = 0; i < columns.length; i++) {
            jtable.getColumnModel().getColumn(i).setPreferredWidth(1000);
        }

        //Creating scroll pane to be able to scroll
        jsp = new JScrollPane(jtable);
        //this.add(jsp, BorderLayout.CENTER);
        //this.setLayout(new BorderLayout());
        //mainPanel.add(jsp, BorderLayout.SOUTH);
       // frame.setSize(frame.getWidth(), frame.getHeight());
        //frame.setVisible(true);
    }
    public JScrollPane getScrollPane() {
        return jsp;
    }

}
