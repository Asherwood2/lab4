import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fileReading {
    String filename;
    List<String> list = new ArrayList();
    String line = "";

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
        //return (String)this.list.get(0).replace(",", " ");
        String[] headers = this.list.get(0).split(","); // Split by comma
        StringBuilder formattedHeader = new StringBuilder();

        for (int i = 0; i < headers.length; i++) {
            if (i != 1) { // Skip the second column (index 1)
                if (formattedHeader.length() > 0) {
                    formattedHeader.append(" "); // Add space between headers
                }
                formattedHeader.append(headers[i]);
            }
        }

        return formattedHeader.toString();
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
        return (ArrayList<String>)this.list;
    }
}