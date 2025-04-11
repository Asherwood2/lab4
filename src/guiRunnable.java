import java.awt.*;
import javax.swing.*;

//Lab3 Runnable, DO NOT RUN FOR LAB 4, run Main
public class guiRunnable {
    public static void main(String[] args) {

        //Creating frame and settings options
        JFrame frame = new JFrame("GDP Data");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Creating calculation object and calling calculation
        JTableCalculation calculation = new JTableCalculation();
        calculation.calculation();

        //Creating panel object and passing to constructor two getters from the calculation object to create JTable
        TablePanel tablepanel = new TablePanel(calculation.getColumns(), calculation.getData());

        //Creating mainPanel that will link everything else to the frame
        JPanel mainPanel = new JPanel();

        //Creating part2 object to be able to output checkboxes
        Part2Panel part2 = new Part2Panel(calculation.getListOfObjects());

        //Creating WestPanel
        JPanel WestPanel = new JPanel();

        //Creating panels that will go into WestPanel
        JPanel WestTopPanel = new JPanel();
        JPanel WestBottomPanel = new JPanel();


        //Creating EastPanel
        JPanel EastPanel = new JPanel();

        //Creating panels that will go into EastPanel
        JPanel EastTopPanel = new JPanel();
        JPanel EastBottomPanel = new JPanel();


        //Adding the scroll pane (jTable) to the WestTopPanel
        WestTopPanel.setPreferredSize(new Dimension(850, 400));
        WestTopPanel.setLayout(new BorderLayout());
        WestTopPanel.add(tablepanel.getScrollPane(), BorderLayout.CENTER);
        WestTopPanel.add(part2.getFilters(), BorderLayout.NORTH);


        WestBottomPanel.setBackground(Color.WHITE);
        WestBottomPanel.setPreferredSize(new Dimension(850, 400));



        //Adding the Average label for when
        EastTopPanel.setBackground(Color.WHITE);
        EastTopPanel.add(tablepanel.getAverageGDPLabel(), BorderLayout.SOUTH);
        EastTopPanel.setPreferredSize(new Dimension(850, 400));

        EastBottomPanel.setBackground(Color.WHITE);
        EastBottomPanel.setPreferredSize(new Dimension(850, 400));


        //Joining two west panels to the westpanel
        WestPanel.add(WestTopPanel);
        WestPanel.add(WestBottomPanel);
        WestPanel.setPreferredSize(new Dimension(850, 1000));

        //Joining two east panels to the eastpanel
        EastPanel.add(EastTopPanel);
        EastPanel.add(EastBottomPanel);
        EastPanel.setPreferredSize(new Dimension(850, 1000));

        //Adding westpanel to the main panel
        mainPanel.add(WestPanel);

        //Adding eastpanel to the main panel
        mainPanel.add(EastPanel);

        //Adding mainpanel to the frame
        frame.add(mainPanel);

        frame.setVisible(true);
    }
}