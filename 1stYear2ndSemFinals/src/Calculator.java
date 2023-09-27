import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener {
			
		private JButton back = new JButton();
	
		private JTextField previous_number;	private JTextField current_number;
		
	 	private JButton one; 	private JButton six;
		private JButton two;	private JButton seven;
		private JButton three;	private JButton eight;
		private JButton four; 	private JButton nine;
		private JButton five; 	private JButton zero;
		
		private JButton plus;	private JButton minus;
		private JButton multi;	private JButton div;
		
		private JButton del; 	private JButton equals;
	
		public void calculator() {
		
		JFrame calculatorFrame = new JFrame("Calculator");
		calculatorFrame.setSize(450, 650);
		calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculatorFrame.getContentPane().setBackground(new Color(0x000000));
		calculatorFrame.setResizable(false);
		calculatorFrame.setLayout(null);
		
		back = new JButton("<");
			back.setBounds(3, 6, 40, 40);
			back.setFocusable(false);
			back.setFont(new Font("consolas", Font.BOLD, 20));
			back.setForeground(new Color(0xFD841F));
			back.setBackground(Color.BLACK);
			back.setBorder(BorderFactory.createEmptyBorder());
			back.addActionListener(e -> {
				calculatorFrame.dispose();
				new Application();
				return;
			});
		
		previous_number = new JTextField();
			previous_number.setBounds(9, 10, 415, 77);
			previous_number.setForeground(new Color(0xF1F6F9));
			previous_number.setBackground(Color.BLACK);
			previous_number.setBorder(BorderFactory.createEmptyBorder());
			previous_number.setFont(new Font("consolas", Font.PLAIN, 18));
			previous_number.setHorizontalAlignment(SwingConstants.RIGHT);
			previous_number.setEditable(false);
		current_number = new JTextField();
			current_number.setBounds(9, 95, 415, 80);
			current_number.setForeground(new Color(0xF1F6F9));
			current_number.setBackground(Color.BLACK);
			current_number.setFont(new Font("consolas", Font.BOLD, 30));
			current_number.setHorizontalAlignment(SwingConstants.RIGHT);
			previous_number.setEditable(false);
			
		one = new JButton("1");
			one.setBounds(9, 185, 100, 100);
			one.setFocusable(false);
			one.setFont(new Font("consolas", Font.BOLD, 35));
			one.setForeground(new Color(0xF1F6F9));
			one.setBackground(Color.BLACK);
			one.setBorder(BorderFactory.createEmptyBorder());
			one.addActionListener(this);
		two = new JButton("2");
			two.setBounds(114, 185, 100, 100);
			two.setFocusable(false);
			two.setFont(new Font("consolas", Font.BOLD, 35));
			two.setForeground(new Color(0xF1F6F9));
			two.setBackground(Color.BLACK);
			two.setBorder(BorderFactory.createEmptyBorder());
			two.addActionListener(this);
		three = new JButton("3");
			three.setBounds(219, 185, 100, 100);
			three.setFocusable(false);
			three.setFont(new Font("consolas", Font.BOLD, 35));
			three.setForeground(new Color(0xF1F6F9));
			three.setBackground(Color.BLACK);
			three.setBorder(BorderFactory.createEmptyBorder());
			three.addActionListener(this);
		four = new JButton("4");
			four.setBounds(9, 290, 100, 100);
			four.setBackground(Color.ORANGE);
			four.setFocusable(false);
			four.setFont(new Font("consolas", Font.BOLD, 35));
			four.setForeground(new Color(0xF1F6F9));
			four.setBackground(Color.BLACK);
			four.setBorder(BorderFactory.createEmptyBorder());
			four.addActionListener(this);
		five = new JButton("5");
			five.setBounds(114, 290, 100, 100);
			five.setFocusable(false);
			five.setFont(new Font("consolas", Font.BOLD, 35));
			five.setForeground(new Color(0xF1F6F9));
			five.setBackground(Color.BLACK);
			five.setBorder(BorderFactory.createEmptyBorder());
			five.addActionListener(this);
		six = new JButton("6");
			six.setBounds(219, 290, 100, 100);
			six.setBackground(Color.ORANGE);
			six.setFocusable(false);
			six.setFont(new Font("consolas", Font.BOLD, 35));
			six.setForeground(new Color(0xF1F6F9));
			six.setBackground(Color.BLACK);
			six.setBorder(BorderFactory.createEmptyBorder());
			six.addActionListener(this);
		seven = new JButton("7");
			seven.setBounds(9, 395, 100, 100);
			seven.setBackground(Color.ORANGE);
			seven.setFocusable(false);
			seven.setFont(new Font("consolas", Font.BOLD, 35));
			seven.setForeground(new Color(0xF1F6F9));
			seven.setBackground(Color.BLACK);
			seven.setBorder(BorderFactory.createEmptyBorder());
			seven.addActionListener(this);
		eight = new JButton("8");
			eight.setBounds(114, 395, 100, 100);
			eight.setBackground(Color.ORANGE);
			eight.setFocusable(false);
			eight.setFont(new Font("consolas", Font.BOLD, 35));
			eight.setForeground(new Color(0xF1F6F9));
			eight.setBackground(Color.BLACK);
			eight.setBorder(BorderFactory.createEmptyBorder());
			eight.addActionListener(this);
		nine = new JButton("9");
			nine.setBounds(219, 395, 100, 100);
			nine.setBackground(Color.ORANGE);
			nine.setFocusable(false);
			nine.setFont(new Font("consolas", Font.BOLD, 35));
			nine.setForeground(new Color(0xF1F6F9));
			nine.setBackground(Color.BLACK);
			nine.setBorder(BorderFactory.createEmptyBorder());
			nine.addActionListener(this);
		zero = new JButton("0");
			zero.setBounds(114, 500, 100, 100);
			zero.setBackground(Color.ORANGE);
			zero.setFocusable(false);
			zero.setFont(new Font("consolas", Font.BOLD, 35));
			zero.setForeground(new Color(0xF1F6F9));
			zero.setBackground(Color.BLACK);
			zero.setBorder(BorderFactory.createEmptyBorder());
			zero.addActionListener(this);
			
		plus = new JButton("+");
			plus.setBounds(325, 185, 100, 100);
			plus.setFocusable(false);
			plus.setFont(new Font("consolas", Font.BOLD, 35));
			plus.setForeground(new Color(0xFD841F));
			plus.setBackground(Color.BLACK);
			plus.setBorder(BorderFactory.createEmptyBorder());
			plus.addActionListener(this);
		minus = new JButton("-");
			minus.setBounds(325, 290, 100, 100);
			minus.setFocusable(false);
			minus.setFont(new Font("consolas", Font.BOLD, 35));
			minus.setForeground(new Color(0xFD841F));
			minus.setBackground(Color.BLACK);
			minus.setBorder(BorderFactory.createEmptyBorder());
			minus.addActionListener(this);
		multi = new JButton("x");
			multi.setBounds(325, 395, 100, 100);
			multi.setFocusable(false);
			multi.setFont(new Font("consolas", Font.BOLD, 35));
			multi.setForeground(new Color(0xFD841F));
			multi.setBackground(Color.BLACK);
			multi.setBorder(BorderFactory.createEmptyBorder());
			multi.addActionListener(this);
		div = new JButton("/");
			div.setBounds(325, 500, 100, 100);
			div.setFocusable(false);
			div.setFont(new Font("consolas", Font.BOLD, 35));
			div.setForeground(new Color(0xFD841F));
			div.setBackground(Color.BLACK);
			div.setBorder(BorderFactory.createEmptyBorder());
			div.addActionListener(this);
		del = new JButton("Del");
			del.setBounds(9, 500, 100, 100);
			del.setFocusable(false);
			del.setFont(new Font("consolas", Font.BOLD, 35));
			del.setForeground(new Color(0xFD841F));
			del.setBackground(Color.BLACK);
			del.setBorder(BorderFactory.createEmptyBorder());
			del.addActionListener(this);
		equals = new JButton("=");
			equals.setBounds(219, 500, 100, 100);
			equals.setFocusable(false);
			equals.setFont(new Font("consolas", Font.BOLD, 35));
			equals.setForeground(new Color(0xFD841F));
			equals.setBackground(Color.BLACK);
			equals.setBorder(BorderFactory.createEmptyBorder());
			equals.addActionListener(this);
		
		calculatorFrame.add(back);
			
		calculatorFrame.add(previous_number);
		calculatorFrame.add(current_number);
	
		calculatorFrame.add(one);
		calculatorFrame.add(two);
		calculatorFrame.add(three);
		
		calculatorFrame.add(four);
		calculatorFrame.add(five);
		calculatorFrame.add(six);
		
		calculatorFrame.add(seven);
		calculatorFrame.add(eight);
		calculatorFrame.add(nine);

		calculatorFrame.add(del);
		calculatorFrame.add(zero);
		calculatorFrame.add(equals);
		
		calculatorFrame.add(plus);
		calculatorFrame.add(minus);
		calculatorFrame.add(multi);
		calculatorFrame.add(div);
		
		calculatorFrame.setVisible(true);
	}
		String inputString = "";
		String outputString;

		private String evaluate(String sequence) {
		    // Split the input string into numbers and operators
		    ArrayList<String> numbersArrayList = new ArrayList<>();
		    ArrayList<String> operatorArrayList = new ArrayList<>();
		    String element = "";

		    if (sequence.startsWith("-")) {
		        sequence = "0" + sequence;
		    }

		    for (int i = 0; i < sequence.length(); i++) {
		        if ("+-x/".contains(String.valueOf(sequence.charAt(i)))) {
		            // Add the current number to numbersArrayList and the current operator to operatorArrayList
		            numbersArrayList.add(element);
		            element = "";
		            operatorArrayList.add(String.valueOf(sequence.charAt(i)));
		        } else {
		            // Build up the current number by appending the current character to the element variable
		            element += sequence.charAt(i);
		        }
		    }

		    // Add the last element to numbersArrayList
		    numbersArrayList.add(element);

		    double answer = Double.parseDouble(numbersArrayList.get(0));

		    // Apply the operators to the numbers in order
		    for (int i = 0; i < operatorArrayList.size(); i++) {
		        switch (operatorArrayList.get(i)) {
		            case "+":
		                answer += Double.parseDouble(numbersArrayList.get(i + 1));
		                break;
		            case "-":
		                answer -= Double.parseDouble(numbersArrayList.get(i + 1));
		                break;
		            case "x":
		                answer *= Double.parseDouble(numbersArrayList.get(i + 1));
		                break;
		            case "/":
		                answer /= Double.parseDouble(numbersArrayList.get(i + 1));
		                break;
		        }
		    }
		    return Double.toString(answer);
		}

		boolean inputIsEmpty = true;
		boolean justEvaluated = false;

		@Override
		public void actionPerformed(ActionEvent e) {
		    current_number.setEditable(false);

		    if (justEvaluated) {
		        previous_number.setText(inputString + " = " + outputString);
		        justEvaluated = false;
		    }

		    String actionCommand = e.getActionCommand();

		    if (current_number.getText().isEmpty() && "+x/=".contains(actionCommand)) {
		        // Do not allow operators to be entered as the first character
		        return;
		    } else if (actionCommand.equals(del.getActionCommand())) {
		        if (!inputString.isBlank()) {
		            inputString = inputString.substring(0, inputString.length() - 1);
		        }
		        current_number.setText(inputString);
		        if (justEvaluated) {
		            current_number.setText("");
		            justEvaluated = false;
		        }
		    } else if (actionCommand.equals(equals.getActionCommand())) {
		        current_number.setText("");
		        previous_number.setText(inputString + "=");
		        // Pre-process the input string to replace any occurrences of "+-" with "-"
		        String processedInput = inputString.replaceAll("\\+-", "-");
		        // Remove all consecutive operations except for the first one
		        processedInput = processedInput.replaceAll("([+x/])-+", "$1");
		        try {
		            outputString = evaluate(processedInput);
		            current_number.setText(outputString);
		            justEvaluated = true;
		        } catch (Exception ex) {
		            current_number.setText("error");
		            justEvaluated = false;
		        }
		    } else {
		        // Check if the last character entered was an operator
		        if (!inputString.isEmpty() && "+x/".contains(Character.toString(inputString.charAt(inputString.length() - 1)))) {
		            // If so, ignore the current character if it's also an operator
		            if ("+x/".contains(actionCommand)) {
		                return;
		            }
		        }
		        inputString += actionCommand;
		        current_number.setText(inputString);
		    }
		}

}