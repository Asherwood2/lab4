import javax.swing.*;
import java.awt.*;

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

        private void creategui() {
            setupFrame();
            buildPanels();
            setPanels();
            finalizegui();
        }

        private void setupFrame() {
            frame = new JFrame("GDP Data");
            frame.setSize(500,500);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        private void buildPanels() {
            mainPanel = new JPanel();

            westPanel = new JPanel();
            JPanel westTopPanel = new JPanel(new BorderLayout());
            JPanel westBottomPanel = new JPanel();

            westTopPanel.setPreferredSize(new Dimension(850, 400));
            westTopPanel.add(tablePanel.getScrollPane(), BorderLayout.CENTER);
            westTopPanel.add(part2.getFilters(), BorderLayout.NORTH);

            westBottomPanel.setPreferredSize(new Dimension(850, 400));
            westBottomPanel.setBackground(Color.WHITE);

            westPanel.setPreferredSize(new Dimension(850, 1000));
            westPanel.add(westTopPanel);
            westPanel.add(westBottomPanel);

            eastPanel = new JPanel();
            JPanel eastTopPanel = new JPanel(new BorderLayout());
            JPanel eastBottomPanel = new JPanel();

            eastTopPanel.setPreferredSize(new Dimension(850, 400));
            eastTopPanel.setBackground(Color.WHITE);
            eastTopPanel.add(tablePanel.getAverageGDPLabel(), BorderLayout.SOUTH);

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
