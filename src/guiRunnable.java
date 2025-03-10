import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class guiRunnable {
    public static void main(String[] args) {



        String path = "GDP.csv";
        fileReading file = new fileReading(path);
        file.process_file();
        List<String> list = file.get_lines();


        StreamParser parser = new StreamParser();

        List<row_Object> list_of_objects = parser.parser((ArrayList<String>) list);
        JFrame frame = new JFrame("GDP Data");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setBackground(Color.magenta);
        frame.add(panel);
        JLabel label = new JLabel(file.get_header_line());
        panel.add(label);


        String[] columns = new String[]{file.get_header_line()};


        JTable jtable = new JTable(, columns);



        frame.setVisible(true);
    }
}
