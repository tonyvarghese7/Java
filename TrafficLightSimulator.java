import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightSimulator extends JFrame {
    private JRadioButton redButton, yellowButton, greenButton;
    private JLabel statusLabel;

    public TrafficLightSimulator() {
        setTitle("Traffic Light Simulator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        redButton = new JRadioButton("Red");
        yellowButton = new JRadioButton("Yellow");
        greenButton = new JRadioButton("Green");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(redButton);
        buttonGroup.add(yellowButton);
        buttonGroup.add(greenButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(redButton);
        buttonPanel.add(yellowButton);
        buttonPanel.add(greenButton);

        statusLabel = new JLabel("Select a light", JLabel.CENTER);

        add(buttonPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        redButton.addActionListener(new LightButtonListener(Color.RED, "Red Light"));
        yellowButton.addActionListener(new LightButtonListener(Color.YELLOW, "Yellow Light"));
        greenButton.addActionListener(new LightButtonListener(Color.GREEN, "Green Light"));
    }

    private class LightButtonListener implements ActionListener {
        private Color lightColor;
        private String lightStatus;

        public LightButtonListener(Color lightColor, String lightStatus) {
            this.lightColor = lightColor;
            this.lightStatus = lightStatus;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            statusLabel.setText(lightStatus);
            statusLabel.setForeground(lightColor);
        }
    }

    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        TrafficLightSimulator simulator = new TrafficLightSimulator();
        simulator.setVisible(true); // Add the missing closing parenthesis and semicolon
    });
}

}
