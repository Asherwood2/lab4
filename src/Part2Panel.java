import javax.swing.*;
import java.awt.event.ItemEvent;
import java.util.List;

public class Part2Panel extends JPanel {
    private List<row_Object> row_objectList;
    private JPanel checkbox;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private ItemEvent e;


    public Part2Panel(List<row_Object> row_objectList) {
        this.row_objectList = row_objectList;
    }

    private void createFilters() {
        JPanel checkbox = new JPanel();
        checkBox1 = new JCheckBox("Filter countries that have GDP data for every year");
        checkBox2 = new JCheckBox("Filter countries that have more than 10 Billion dollars in GDP every year");
        checkBox3 = new JCheckBox("Filter");

        checkbox.add(checkBox1);
        checkbox.add(checkBox2);
        checkbox.add(checkBox3);
    }

    private void implement_check_box() {

    }

    public JPanel getPanel() {
        return checkbox;
    }





}
