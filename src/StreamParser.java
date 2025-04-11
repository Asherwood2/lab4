import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//lab4

public class StreamParser {

    //Parsing the list of rows and creating a list of objects
    public List<row_Object> parser(ArrayList<String> lines){
    return lines.stream()

            .skip(1)
            .map(line -> {
                String[] data = line.split(",");
                String type = data[0];
                String country = data[2];
                String country_code = data[3];


                List<Double> gdp_Values = Arrays.stream(Arrays.copyOfRange(data, 4, data.length))
                        .map(value -> {
                            try {
                                // Handle missing or invalid GDP values by defaulting to 0.0
                                if (value.equals("..") || value.trim().isEmpty()) {
                                    return 0.0;
                                }
                                return Double.parseDouble(value); // Parse valid GDP value
                            } catch (NumberFormatException e) {
                                System.out.println("Error parsing value: " + value);
                                return 0.0;
                            }
                        })
                        .collect(Collectors.toList());


                // Returns a row object
                return new row_Object(type, country, country_code, gdp_Values);
            })
            .collect(Collectors.toList());
    }
}
