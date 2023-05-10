package test.main;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener {

	JTextField inputNum1 = new JTextField();
	JTextField inputNum2 = new JTextField();
	JLabel label = new JLabel();

	public Calculator(String title) {
		super(title);
		setBounds(100, 100, 500, 500); // 창의 위치와 크기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close버튼 누르면 창이 종료

		setLayout(new FlowLayout());

		//버튼 선언
		inputNum1 = new JTextField(10);

		JButton plusBtn = new JButton("+");
		JButton minusBtn = new JButton("-");
		JButton multiBtn = new JButton("*");
		JButton divideBtn = new JButton("/");

		inputNum2 = new JTextField(10);

		JButton resultBtn = new JButton("=");

		label = new JLabel("...");

		//버튼 추가
		add(inputNum1);

		add(plusBtn);
		add(minusBtn);
		add(multiBtn);
		add(divideBtn);

		add(inputNum2);

		add(resultBtn);

		add(label);

		//버튼 동작 추가
		plusBtn.addActionListener(this);
		plusBtn.setActionCommand("plus");

		minusBtn.addActionListener(this);
		minusBtn.setActionCommand("minus");
		
		multiBtn.addActionListener(this);
		
		multiBtn.setActionCommand("multi");
		
		divideBtn.addActionListener(this);
		divideBtn.setActionCommand("div");
		
		resultBtn.addActionListener(this);
		resultBtn.setActionCommand("result");

		setVisible(true); // 프레임이 창에 보이게
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double num1 = Double.parseDouble(inputNum1.getText());
		double num2 = Double.parseDouble(inputNum2.getText());
		String cmd = e.getActionCommand();
		double result = 0;

		switch (cmd) {
			case "plus" :
				result = num1 + num2;
				break;
			case "minus":
				result = num1 - num2;
				break;
			case "multi" :
				result = num1 * num2;
				break;
			case "div" :
				result = num1 / num2;
				break;
		}
		
		label.setText(Double.toString(result));

	}

	public static void main(String[] args) {
		new Calculator("계산기");

		System.out.println("main메소드가 종료 됩니다.");
	}
}
