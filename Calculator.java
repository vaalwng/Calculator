
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
	
	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[8];
	JButton add, subtract, multiply, divide;
	JButton decimal, equal, delete, clear;
	JPanel panel;
	
	Font myFont = new Font("Times New Roman", Font.BOLD,20);
	
	double num1 = 0;
	double num2 = 0;
	double result = 0;
	char operator;
	
	Calculator() {
		frame = new JFrame("Calculator App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 70);
		textField.setFont(myFont);
		textField.setEditable(false);
		
		add = new JButton("+");
		subtract = new JButton("-");
		multiply = new JButton("*");
		divide = new JButton("/");
		decimal = new JButton(".");
		equal = new JButton("=");
		delete = new JButton("DEL");
		clear = new JButton("CLR");
		
		functionButtons[0] = add;
		functionButtons[1] = subtract;
		functionButtons[2] = multiply;
		functionButtons[3] = divide;
		functionButtons[4] = decimal;
		functionButtons[5] = equal;
		functionButtons[6] = delete;
		functionButtons[7] = clear;
		
		
		for(int i = 0; i < functionButtons.length; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i = 0; i < numberButtons.length; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		delete.setBounds(50, 430, 145, 50);
		clear.setBounds(205, 430, 145, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 310);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBackground(Color.GRAY);
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(add);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subtract);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(multiply);
		panel.add(decimal);
		panel.add(numberButtons[0]);
		panel.add(equal);
		panel.add(divide);

		frame.add(panel);
		frame.add(delete);
		frame.add(clear);
		frame.add(textField);
		frame.setVisible(true);
	}
		
	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decimal) {
			textField.setText(textField.getText().concat("."));
		}
		if(e.getSource()==add) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		if(e.getSource()==subtract) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		if(e.getSource()==multiply) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		if(e.getSource()==divide) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		if(e.getSource()==equal) {
			num2 = Double.parseDouble(textField.getText());
			
			switch(operator) {
				case '+':
					result= num1 + num2;
					break;
				case '-':
					result= num1 - num2;
					break;
				case '*':
					result= num1 * num2;
					break;
				case '/':
					result= num1 / num2;
					break;
			}
			textField.setText(String.valueOf(result));
			num1=result;
		}
	}
	
}