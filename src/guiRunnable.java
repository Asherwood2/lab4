import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

public class guiRunnable {
    public static void main(String[] args) {

        //File name put into path var
        String path = "GDP.csv";
        //creating file obj to pass in filename to read it
        fileReading file = new fileReading(path);
        file.process_file();
        //getting a list for every row in file
        List<String> list = file.get_lines();

        //Creating Parser object
        StreamParser parser = new StreamParser();
        //Calling parser method and passing in that list, getting a list of objects back
        List<row_Object> list_of_objects = parser.parser((ArrayList<String>) list);


        //Creating columns array for JTable
        String[] columns = file.get_header_line().split(",");

        //Creating data array for JTable
        Object[][] data = new Object[list_of_objects.size()][columns.length];

        for (int i = 0; i < list_of_objects.size(); i++) {
            row_Object obj = list_of_objects.get(i);

            // Assuming the rowObject has get_data_Type(), getCountry(), getCountry_code(), and getGdp_Values() methods
            Object[] rowData = new Object[columns.length];

            //Inserting data into arrays
            rowData[0] = obj.get_data_Type();     // First column
            rowData[1] = obj.getCountry();        // Second column
            rowData[2] = obj.getCountry_code();   // Third column

            List<Double> gdpValues = obj.getGdp_Values();
            if (gdpValues != null) {
                for (int j = 0; j < gdpValues.size(); j++) {
                    rowData[3 + j] = String.valueOf(gdpValues.get(j));
                }
            }
            else {
                for (int j = 3; i < rowData.length; j++) {
                   rowData[j] = "N/A";
                }
            }
            // Assign the row to the data array
            data[i] = rowData;
        }


        JTableCalculation calculation = new JTableCalculation();
        calculation.calculation();

        TablePanel panel = new TablePanel(calculation.getColumns(), calculation.getData());
        JFrame frame = new JFrame("GDP Data");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        frame.add(panel1);



        frame.add(panel);

        JTable jtable = new JTable(data, columns);
        jtable.setRowHeight(30);
        jtable.setPreferredScrollableViewportSize(new Dimension(1000, 750));
        jtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        for (int i = 0; i < columns.length; i++) {
            jtable.getColumnModel().getColumn(i).setPreferredWidth(1000);
        }

        //Creating scroll pane to be able to scroll
        JScrollPane jsp = new JScrollPane(jtable);
        panel.add(jsp, BorderLayout.CENTER);
       panel.add(jsp);

       frame.setSize(frame.getWidth(), frame.getHeight());
       frame.setVisible(true);
    }
}
