import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;

import javax.swing.*;

import static javax.swing.SwingConstants.NORTH;

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
        TablePanel panel = new TablePanel(calculation.getColumns(), calculation.getData());



       //PART 2

       //frame.setSize(frame.getWidth(), frame.getHeight());
        JPanel mainPanel = new JPanel();

        Part2Panel part2 = new Part2Panel(calculation.getListOfObjects());
       //frame.add(part2.getPanel());

        JPanel WestPanel = new JPanel();
        JPanel WestTopPanel = new JPanel();
        //WestTopPanel.add(part2.getPanel());
        JPanel WestBottomPanel = new JPanel();


        JPanel EastPanel = new JPanel();
        JPanel EastTopPanel = new JPanel();
        JPanel EastBottomPanel = new JPanel();

        WestTopPanel.setBackground(Color.BLUE);
        WestTopPanel.setPreferredSize(new Dimension(760, 400));
        WestTopPanel.setLayout(new BorderLayout());
        WestTopPanel.add(panel.getScrollPane(), BorderLayout.CENTER);

        WestBottomPanel.setBackground(Color.MAGENTA);
        WestBottomPanel.setPreferredSize(new Dimension(760, 400));
        //WestBottomPanel.setLayout(new BorderLayout());
        //WestBottomPanel.add(panel.getScrollPane(), BorderLayout.CENTER);



        EastTopPanel.setBackground(Color.yellow);
        EastTopPanel.setPreferredSize(new Dimension(1500, 400));

        EastBottomPanel.setBackground(Color.GREEN);
        EastBottomPanel.setPreferredSize(new Dimension(1500, 400));

        WestPanel.add(WestTopPanel);
        WestPanel.add(WestBottomPanel);
        WestPanel.setPreferredSize(new Dimension(760, 1000));

        EastPanel.add(EastTopPanel);
        EastPanel.add(EastBottomPanel);
        EastPanel.setPreferredSize(new Dimension(760, 1000));

        mainPanel.add(WestPanel);

        mainPanel.add(EastPanel);

        frame.add(mainPanel);

        frame.setVisible(true);


























       //Adding checkbox to main panel


/*
        JPanel mainPanel = new JPanel();

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();

        JPanel NorthWestPanel = new JPanel();
        NorthWestPanel.setBackground(Color.BLUE);
        JPanel NorthEastPanel = new JPanel();
        NorthEastPanel.setBackground(Color.YELLOW);


        NorthWestPanel.add(checkbox);
        //TablePanel nextPanel = new TablePanel(calculation.getColumns(), calculation.getData());
        //NorthEastPanel.add(nextPanel.getScrollPane());


//        topPanel.add(BorderLayout.NORTH);



        JPanel SouthWestPanel = new JPanel();
        SouthWestPanel.setBackground(Color.GREEN);
        JPanel SouthEastPanel = new JPanel();
        SouthEastPanel.setBackground(Color.DARK_GRAY);

        // Add the checkbox to the NorthWestPanel using BorderLayout.WEST
        NorthWestPanel.add(checkbox, BorderLayout.WEST);

// Now add NorthWestPanel to the topPanel (topPanel uses BorderLayout)
        topPanel.add(NorthWestPanel);


        TablePanel nextPanel = new TablePanel(calculation.getColumns(), calculation.getData());
        NorthEastPanel.add(nextPanel.getScrollPane());
        topPanel.add(NorthEastPanel);

//        mainPanel.add(topPanel);
        mainPanel.add(bottomPanel);

*/
        //frame.add(mainPanel);


        //SouthWestPanel.add(panel.getScrollPanel());

        //mainPanel.setLayout(new BorderLayout());
        //mainPanel.add(border)
        //
       //Adding JScrollpanel which contains JTable to the main panel
        //mainPanel.add(panel.getScrollPane());
       // mainPanel.add(checkbox);
        //mainPanel.add(panel.getLabel(), BorderLayout.SOUTH.(BorderLayout.WEST));
       //adding mainPanel to the frame
        //tablePanel.add(panel.getScrollPane(), BorderLayout.WEST);
       // frame.add(mainPanel);
    }
}
