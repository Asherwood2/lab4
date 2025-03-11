import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fileReading {
    private String filename;
    private List<String> list = new ArrayList();
    private String line = "";

    public fileReading(String name) {
        this.filename = name;
    }

    public void process_file() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.filename));

            while((this.line = br.readLine()) != null) {
                this.list.add(this.line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String get_header_line() {

        String headerLine = (String) this.list.get(0);
        String[] columns = headerLine.split(",");

        //Creating a column list to remove Series Code as I'm not using that column
        List<String> columnList = new ArrayList<>(Arrays.asList(columns));
        columnList.remove("Series Code");
        return String.join(",", columnList);
    }
    public String get_first_line() {
        return (String)this.list.get(1);
    }

    public String get_tenth_line() {
        return (String)this.list.get(9);
    }

    public int get_num_of_lines() {
        return this.list.size();
    }
    public ArrayList<String> get_lines() {
        return (ArrayList<String>) list;
    }
}