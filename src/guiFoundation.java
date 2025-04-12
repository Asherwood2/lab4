import javax.swing.*;
import java.awt.*;
//Facade pattern
public class guiFoundation {
    private JFrame frame;
    private JTableCalculation calculation;
    private TablePanel tablePanel;
    private Part2Panel part2;
    private JPanel mainPanel, westPanel, eastPanel;

    public guiFoundation() {
        calculation = new JTableCalculation();
        calculation.calculation();

        tablePanel = new TablePanel(calculation.getColumns(), calculation.getData());
        part2 = new Part2Panel(calculation.getListOfObjects());
    }

    public void creategui() {
        setupFrame();
        buildPanels();
        setPanels();
        finalizegui();
    }

    private void setupFrame() {
        frame = new JFrame("GDP Data");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void buildPanels() {
        mainPanel = new JPanel(new GridLayout(1, 2)); // 2 columns: west and east panels

        westPanel = new JPanel(new GridLayout(2, 1)); // 2 rows: top and bottom
        JPanel westTopPanel = new JPanel(new GridLayout(2, 1)); // 2 rows: filter and scroll
        JPanel westBottomPanel = new JPanel();

        westTopPanel.setPreferredSize(new Dimension(850, 400));
        westTopPanel.add(part2.getFilters());                  // was BorderLayout.NORTH
        westTopPanel.add(tablePanel.getScrollPane());         // was BorderLayout.CENTER

        westBottomPanel.setPreferredSize(new Dimension(850, 400));
        westBottomPanel.setBackground(Color.WHITE);

        westPanel.setPreferredSize(new Dimension(850, 1000));
        westPanel.add(westTopPanel);
        westPanel.add(westBottomPanel);

        eastPanel = new JPanel(new GridLayout(2, 1)); // 2 rows: top and bottom
        JPanel eastTopPanel = new JPanel(new GridLayout(1, 1)); // Just label
        JPanel eastBottomPanel = new JPanel();

        eastTopPanel.setPreferredSize(new Dimension(850, 400));
        eastTopPanel.setBackground(Color.WHITE);
        eastTopPanel.add(tablePanel.getAverageGDPLabel());    // was BorderLayout.SOUTH

        eastBottomPanel.setPreferredSize(new Dimension(850, 400));
        eastBottomPanel.setBackground(Color.WHITE);

        eastPanel.setPreferredSize(new Dimension(850, 1000));
        eastPanel.add(eastTopPanel);
        eastPanel.add(eastBottomPanel);
    }

    private void setPanels() {
        mainPanel.add(westPanel);
        mainPanel.add(eastPanel);
    }

    private void finalizegui() {
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
