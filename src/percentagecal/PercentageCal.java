/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package percentagecal;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PercentageCal extends JFrame {
   
    private JPanel panel;
    private JTextField input1;
    private JTextField input2;
    private JComboBox<String> calculationType;
    private JButton calculateButton;
    private JLabel resultLabel;

    public PercentageCal() {
        panel = new JPanel();
        input1 = new JTextField(10);
        input2 = new JTextField(10);
        String[] calculations = {"Calculate Percentage", "Percentage Increase", "Percentage Decrease", "Find Whole"};
        calculationType = new JComboBox<>(calculations);
        calculateButton = new JButton("Calculate");
        resultLabel = new JLabel("Result: ");

        panel.add(new JLabel("Input 1:"));
        panel.add(input1);
        panel.add(new JLabel("Input 2:"));
        panel.add(input2);
        panel.add(calculationType);
        panel.add(calculateButton);
        panel.add(resultLabel);

        calculateButton.addActionListener(new CalculateButtonListener());

        this.add(panel);
        this.setTitle("Percentage Calculator");
        this.setSize(500,500);
        this.setLocation(500,200);
       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double value1 = Double.parseDouble(input1.getText());
                double value2 = Double.parseDouble(input2.getText());
                String calculation = (String) calculationType.getSelectedItem();
                double result = 0;

                switch (calculation) {
                    case "Calculate Percentage":
                        result = (value1 / value2) * 100;
                        break;
                    case "Percentage Increase":
                        result = ((value2 - value1) / value1) * 100;
                        break;
                    case "Percentage Decrease":
                        result = ((value1 - value2) / value1) * 100;
                        break;
                    case "Find Whole":
                        result = (value1 / value2) * 100;
                        break;
                }
                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new PercentageCal();
    }
}
