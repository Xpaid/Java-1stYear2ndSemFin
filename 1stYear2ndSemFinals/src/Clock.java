import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Clock implements ActionListener {
		
	private JTextField hours_textfield, minutes_textfield, seconds_textfield;
	private JLabel colon_1, colon_2, total;
	private JButton back;
	private JButton add, minus, start, end;
		
	private int hour = 0, minute = 0, second = 0;
	
	public void stopwatch () {
		JFrame TimeFrame = new JFrame("Clock");
		TimeFrame.setTitle("Application");
		TimeFrame.setSize(450, 650);
		TimeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TimeFrame.getContentPane().setBackground(new Color(0x000000));
		TimeFrame.setResizable(false);
		TimeFrame.setLayout(null);
		
		back = new JButton("<");
		back.setBounds(3, 6, 40, 40);
		back.setFocusable(false);
		back.setFont(new Font("consolas", Font.BOLD, 20));
		back.setForeground(new Color(0xFD841F));
		back.setBackground(Color.BLACK);
		back.setBorder(BorderFactory.createEmptyBorder());
		back.addActionListener(f -> {
			TimeFrame.dispose();
			new Application();
			return;
		});

		hours_textfield = new JTextField("00");
			hours_textfield.setBounds(35, 147, 100, 70);
			//hours_textfield.setFocusable(false);
			hours_textfield.setHorizontalAlignment(SwingConstants.CENTER);
			hours_textfield.setFont(new Font("Consolas", Font.BOLD, 55));
			hours_textfield.setForeground(new Color(0xffffff));
			hours_textfield.setBackground(Color.BLACK);
			hours_textfield.setBorder(BorderFactory.createEmptyBorder());
		
		minutes_textfield = new JTextField("00");
			minutes_textfield.setBounds(165, 147, 100, 70);
			//minutes_textfield.setFocusable(false);
			minutes_textfield.setHorizontalAlignment(SwingConstants.CENTER);
			minutes_textfield.setFont(new Font("Consolas", Font.BOLD, 55));
			minutes_textfield.setForeground(new Color(0xffffff));
			minutes_textfield.setBackground(Color.BLACK);
			minutes_textfield.setBorder(BorderFactory.createEmptyBorder());
			
		seconds_textfield = new JTextField("00");
			seconds_textfield.setBounds(295, 147, 100, 70);
			//seconds_textfield.setFocusable(false);
			seconds_textfield.setHorizontalAlignment(SwingConstants.CENTER);
			seconds_textfield.setFont(new Font("Consolas", Font.BOLD, 55));
			seconds_textfield.setForeground(new Color(0xffffff));
			seconds_textfield.setBackground(Color.BLACK);
			seconds_textfield.setBorder(BorderFactory.createEmptyBorder());
		
		colon_1 = new JLabel(":");
			colon_1.setBounds(140, 160, 40, 40);
			colon_1.setFont(new Font("Consolas", Font.BOLD, 40));
			colon_1.setForeground(new Color(0xFD841F));
			
		colon_2 = new JLabel(":");
			colon_2.setBounds(270, 160, 40, 40);
			colon_2.setFont(new Font("Consolas", Font.BOLD, 40));
			colon_2.setForeground(new Color(0xFD841F));
		
		total = new JLabel();
			total.setText("Total " + hours_textfield.getText() + " hours " + minutes_textfield.getText() + " minutes " + seconds_textfield.getText() + " seconds");
			total.setBounds(90, 230, 255, 16);
			total.setFont(new Font("Consolas", Font.PLAIN, 13));
			total.setForeground(Color.WHITE);
			total.setBackground(Color.BLACK);
		
		add = new JButton("+");
			add.setBounds(130, 375, 50, 50);
			add.setFocusable(false);
			add.setFont(new Font("Consolas", Font.BOLD, 30));
			add.setForeground(new Color(0xFD841F));
			add.setBackground(Color.BLACK);
			add.setBorder(BorderFactory.createEmptyBorder());
			add.addActionListener(this);
			
		minus = new JButton("-");
			minus.setBounds(240, 375, 50, 50);
			minus.setFocusable(false);
			minus.setFont(new Font("Consolas", Font.BOLD, 30));
			minus.setForeground(new Color(0xFD841F));
			minus.setBackground(Color.BLACK);
			minus.setBorder(BorderFactory.createEmptyBorder());
			minus.addActionListener(this);
		
		start = new JButton("Start");
			start.setBounds(165, 450, 90, 50);
			start.setFocusable(false);
			start.setFont(new Font("Consolas", Font.BOLD, 30));
			start.setForeground(new Color(0xFD841F));
			start.setBackground(Color.BLACK);
			start.setBorder(BorderFactory.createEmptyBorder());
			start.addActionListener(this);
		end = new JButton("End");
			end.setBounds(165, 450, 90, 50);
			end.setFocusable(false);
			end.setFont(new Font("Consolas", Font.BOLD, 30));
			end.setForeground(new Color(0xFD841F));
			end.setBackground(Color.BLACK);
			end.setBorder(BorderFactory.createEmptyBorder());
			end.setVisible(false);
			end.addActionListener(this);

		TimeFrame.add(back);
		TimeFrame.add(hours_textfield);	
		TimeFrame.add(minutes_textfield);
		TimeFrame.add(seconds_textfield);
		TimeFrame.add(colon_1);
		TimeFrame.add(colon_2);
		TimeFrame.add(total);
		TimeFrame.add(add);
		TimeFrame.add(minus);
		TimeFrame.add(start);
		TimeFrame.add(end);

		
		TimeFrame.setVisible(true);
	}
	private Thread timerThread;
	private boolean isRunning = true;
	
	@SuppressWarnings("removal") // for stop()
	@Override
	public void actionPerformed(ActionEvent e) {
		Component focusOwner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
		String actionCommand = e.getActionCommand();
		
		total.setText("Total " + "00 hours " + "00 minutes " + "00 seconds");

		if (hours_textfield.getText().isBlank()) {
			hours_textfield.setText("00"); 
			hour = Integer.parseInt(hours_textfield.getText());
		}
		if (minutes_textfield.getText().isBlank()) {
			minutes_textfield.setText("00");	
			minute = Integer.parseInt(minutes_textfield.getText());
		}
		if (seconds_textfield.getText().isBlank()) {
			seconds_textfield.setText("00");
			second = Integer.parseInt(seconds_textfield.getText());
		}
			
		if (actionCommand.equals("+")) {
			if (focusOwner.equals(hours_textfield) && hour < 99) {
				hour++;
				hours_textfield.setText(String.format("%02d", hour));
			}
			else if (focusOwner.equals(minutes_textfield) && minute < 59) {
				minute++;
				minutes_textfield.setText(String.format("%02d", minute));
			}
			else if (focusOwner.equals(seconds_textfield) && second < 59){
				second++;
				seconds_textfield.setText(String.format("%02d", second));

			} else {
				System.out.println("error encountered or Max number reached");
			}
		} else if (actionCommand.equals("-")) {
			if (focusOwner.equals(hours_textfield) && hour > 0) {
				hour--;
				hours_textfield.setText(String.format("%02d", hour));
			}
			else if (focusOwner.equals(minutes_textfield) && minute > 0) {
				minute--;
				minutes_textfield.setText(String.format("%02d", minute));
			}
			else if (focusOwner.equals(seconds_textfield) && second > 0){
				second--;
				seconds_textfield.setText(String.format("%02d", second));

			} else {
				System.out.println("error encountered or least number reached");
			}
		} else if (actionCommand.equals("Start")) {
		    add.setVisible(false);
		    minus.setVisible(false);
		    start.setVisible(false);
		    end.setVisible(true);
		    hours_textfield.setText("");
		    minutes_textfield.setText("");
		    seconds_textfield.setText("");
		    
			total.setText("Total " + String.format("%02d", hour) + " hours " + String.format("%02d", minute) + " minutes " + String.format("%02d", second) + " seconds");
		    
			timerThread = new Thread(() -> {
		    	
		        while (hour > 0 || minute > 0 || second > 0) {
		        	
		            hours_textfield.setText(String.format("%02d", hour));
		            minutes_textfield.setText(String.format("%02d", minute));
		            seconds_textfield.setText(String.format("%02d", second));
		            try {
		                Thread.sleep(1000); // delay for 1 second
		            } catch (InterruptedException time) {
		                // handle the exception
		            }
		            if (second == 0) {
		                if (minute > 0) {
		                    minute--;
		                    second = 59;
		                } else {
		                    hour--;
		                    minute = 59;
		                    second = 59;
		                }
		            } else {
		                second--;
		            }
		            if (actionCommand.equals("End")){
		        		break;
		        	}
		        }

		        // Set text fields to 00:00:00 after stopwatch finishes
		        hours_textfield.setText("00");
		        minutes_textfield.setText("00");
		        seconds_textfield.setText("00");

		        add.setVisible(true);
		        minus.setVisible(true);
		        start.setVisible(true);
		        isRunning = false;
		    });
		    timerThread.start();
		} else {
			isRunning = false;
			timerThread.stop();
			add.setVisible(true);
	        minus.setVisible(true);
	        start.setVisible(true);
	        hour = 0;
	        minute = 0;
	        second = 0;
		}

		// Inside the loop where you increment/decrement the hours, minutes, or seconds variables
		if (!isRunning) {
		    hours_textfield.setText(String.format("%02d", hour));
		    minutes_textfield.setText(String.format("%02d", minute));
		    seconds_textfield.setText(String.format("%02d", second));
		}
		
	} 
	
}
