import java.util.ArrayList;
import java.util.List;

public class JTableCalculation {
    private final String file_Name = "GDP.csv";
    private String[] columns;
    private Object[][] data;


    void calculation() {
        fileReading file  = new fileReading(file_Name);
        file.process_file();
        List<String> list = file.get_lines();
        StreamParser parser = new StreamParser();
        //Calling parser method and passing in that list, getting a list of objects back
        List<row_Object> list_of_objects = parser.parser((ArrayList<String>) list);


        //Creating columns array for JTable
        this.columns = file.get_header_line().split(",");

        //Creating data array for JTable
        this.data = new Object[list_of_objects.size()][columns.length];

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
            this.data[i] = rowData;
        }
    }
    String[] getColumns() {
        return this.columns;
    }
    Object[][] getData() {
        return this.data;
    }
}



