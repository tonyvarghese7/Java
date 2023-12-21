import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField textField;
    private String operator;
    private double firstOperand;

    public Calculator() {
        setTitle(" Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);

        createUI();

        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    private void createUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            buttonPanel.add(button);
        }

        JButton clearButton = new JButton("C");
        clearButton.addActionListener(new ButtonClickListener());
        clearButton.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonPanel.add(clearButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        add(panel);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String command = source.getText();

            switch (command) {
                case "=":
                    calculateResult();
                    break;
                case "/":
                case "*":
                case "-":
                case "+":
                    setOperator(command);
                    break;
                case "C":
                    clear();
                    break;
                default:
                    appendDigit(command);
                    break;
            }
        }

        private void calculateResult() {
            try {
                double secondOperand = Double.parseDouble(textField.getText());
                double result = 0;

                switch (operator) {
                    case "/":
                        if (secondOperand != 0) {
                            result = firstOperand / secondOperand;
                        } else {
                            showError("Cannot divide by zero.");
                            return;
                        }
                        break;
                    case "*":
                        result = firstOperand * secondOperand;
                        break;
                    case "-":
                        result = firstOperand - secondOperand;
                        break;
                    case "+":
                        result = firstOperand + secondOperand;
                        break;
                    default:
                        result = secondOperand; // When no operator is selected, result is the second operand
                        break;
                }

                textField.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                showError("Invalid input.");
            }
        }

        private void setOperator(String op) {
            operator = op;
            try {
                firstOperand = Double.parseDouble(textField.getText());
                textField.setText("");
            } catch (NumberFormatException ex) {
                showError("Invalid input.");
            }
        }

        private void appendDigit(String digit) {
            textField.setText(textField.getText() + digit);
        }

        private void clear() {
            textField.setText("");
            operator = null;
            firstOperand = 0;
        }

        private void showError(String message) {
            JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}