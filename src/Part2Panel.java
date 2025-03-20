import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
        this.checkbox = new JPanel();
        checkBox1 = new JCheckBox("Fully populated countries");
        checkBox2 = new JCheckBox("Countries that have more than 10 Billion dollars in GDP every year");
        checkBox3 = new JCheckBox("Top 20 avg GDP");

        checkbox.add(checkBox1);
        checkbox.add(checkBox2);
        checkbox.add(checkBox3);
    }

    private void implement_check_box() {
        checkBox1.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkBox1.isSelected())
                {

                }
            }
        });

        checkBox2.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkBox2.isSelected())
                {

                }
            }
        });

        checkBox3.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkBox3.isSelected())
                {

                }
            }
        });
    }
    public JPanel getFilters() {
        return checkbox;
    }
}
