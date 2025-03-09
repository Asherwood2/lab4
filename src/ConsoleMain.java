public class ConsoleMain {
    public ConsoleMain() {
    }

    public static void main(String[] args) {
        String path = "GDP.csv";
        fileReading file = new fileReading(path);
        file.process_file();
        System.out.println(file.get_first_line());
        System.out.println(file.get_tenth_line());
        System.out.println(file.get_num_of_lines());
    }
}