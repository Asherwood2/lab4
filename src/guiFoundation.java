import javax.swing.*;

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
}
