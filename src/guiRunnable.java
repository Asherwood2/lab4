import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;

import javax.swing.*;

public class guiRunnable {
    public static void main(String[] args) {

        //Creating frame and settings options
        JFrame frame = new JFrame("GDP Data");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creating mainPanel which will house further swing objects
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());


        //Creating calculation object and calling calculation
        JTableCalculation calculation = new JTableCalculation();
        calculation.calculation();
        //Creating panel object and passing to constructor two getters from the calculation object to create JTable
        TablePanel panel = new TablePanel(calculation.getColumns(), calculation.getData());



       //PART 2

        JPanel checkbox = new JPanel();
        JCheckBox checkBox1 = new JCheckBox("Filter countries that have GDP data for every year");
        JCheckBox checkBox2 = new JCheckBox("Filter countries that have more than 10 Billion dollars in GDP every year");
        JCheckBox checkBox3 = new JCheckBox("Filter");

        checkbox.add(checkBox1);
        checkbox.add(checkBox2);
        checkbox.add(checkBox3);


       //frame.setSize(frame.getWidth(), frame.getHeight());
       frame.setVisible(true);


       //Adding checkbox to main panel
       mainPanel.add(checkbox, BorderLayout.NORTH);
        //JPanel tablePanel = new JPanel();
       //Adding JScrollpanel which contains JTable to the main panel
        mainPanel.add(panel.getScrollPane(), BorderLayout.SOUTH);

       //adding mainPanel to the frame
        //tablePanel.add(panel.getScrollPane(), BorderLayout.WEST);
        frame.add(mainPanel);
    }
}
