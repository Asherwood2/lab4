import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamParser {


    public List<row_Object> parser(ArrayList<String> lines){
    return lines.stream()
            .skip(1)
            .map(line -> {
                String[] data = line.split(",");
                String type = data[0];
                String country = data[2];
                String country_code = data[3];

                List<Double> gdp_Values = Arrays.stream(data, 4, data.length)
                        .map(Double::parseDouble)
                        .collect(Collectors.toList());

                return new row_Object(type, country, country_code, gdp_Values);
            })
            .collect(Collectors.toList());
    }
}
