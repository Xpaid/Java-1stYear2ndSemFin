
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Application extends JFrame {

	private static final long serialVersionUID = 1L;
	Calculator calculator = new Calculator();
	Clock timer = new Clock();
	System_apps system_apps = new System_apps();
	
	Application() {
		dispose();
		this.setTitle("Application");
		this.setSize(450, 650);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(0x000000));
		this.setResizable(false);
		this.setLayout(null);
		
		JPanel Title_Panel = new JPanel();
			Title_Panel.setLayout(null);
			Title_Panel.setBounds(40, 30, 355, 100);
			Title_Panel.setBackground(new Color(0x52057B));
		
		JPanel Sub_titlePanel = new JPanel();
			Sub_titlePanel.setBounds(65, 25, 225, 50);
			Sub_titlePanel.setBackground(new Color(0x892CDC));

		JLabel title = new JLabel("Menu");
			title.setBounds(50, 4, 250, 60);
			title.setFont(new Font("consolas", Font.BOLD, 50));
			title.setForeground(new Color(0xE3CCAE));

		JPanel Main_Panel = new JPanel();
			Main_Panel.setLayout(null);
		    Main_Panel.setBounds(80, 175, 275, 400);
			Main_Panel.setBackground(new Color(0x52057B));
			
		JButton calc = new JButton("CALCULATOR");
			calc.setBounds(62, 30, 150, 50);
			calc.setFont(new Font("consolas", Font.BOLD, 18));
			calc.setFocusable(false);
			calc.setBackground(new Color(0x892CDC));
			calc.setForeground(new Color(0xE3CCAE));
			calc.addActionListener(e -> { dispose(); calculator.calculator(); });
			
		JButton clock = new JButton("Stopwatch");
			clock.setBounds(62, 100, 150, 50);
			clock.setFont(new Font("consolas", Font.BOLD, 18));
			clock.setFocusable(false);
			clock.setBackground(new Color(0x892CDC));
			clock.setForeground(new Color(0xE3CCAE));
			clock.addActionListener(e -> { dispose(); timer.stopwatch();  });
			
		JButton notepad = new JButton("NotePad");
			notepad.setBounds(62, 175, 150, 50);
			notepad.setFont(new Font("consolas", Font.BOLD, 18));
			notepad.setFocusable(false);
			notepad.setBackground(new Color(0x892CDC));
			notepad.setForeground(new Color(0xE3CCAE));
			notepad.addActionListener(j -> {
				system_apps.notepad();
			});
		
		JButton Paint = new JButton("Paint");
			Paint.setBounds(62, 250, 150, 50);
			Paint.setFont(new Font("consolas", Font.BOLD, 18));
			Paint.setFocusable(false);
			Paint.setBackground(new Color(0x892CDC));
			Paint.setForeground(new Color(0xE3CCAE));
			Paint.addActionListener(f -> {
				system_apps.mspaint();
			});
		
		JButton Exit_frame = new JButton("Exit");
			Exit_frame.setBounds(62, 325, 150, 50);
			Exit_frame.setFont(new Font("consolas", Font.BOLD, 18));
			Exit_frame.setFocusable(false);
			Exit_frame.setBackground(new Color(0x892CDC));
			Exit_frame.setForeground(new Color(0xE3CCAE));
			Exit_frame.addActionListener(e -> {
				System.exit(0);
			});
		
	    JLabel creator = new JLabel("Created by Jets");
	    	creator.setBounds(325, 595, 230, 16);
	    	creator.setFont(new Font("Consolas", Font.PLAIN, 13));
	    	creator.setForeground(Color.WHITE);
	    	creator.setBackground(Color.BLACK);
	    	
	    //add to Title_Panel
		Title_Panel.add(Sub_titlePanel);
		Sub_titlePanel.add(title);
		
		//add to Main_Pannel
		Main_Panel.add(calc);
		Main_Panel.add(clock);
		Main_Panel.add(notepad);
		Main_Panel.add(Paint);
		Main_Panel.add(Exit_frame);
		
		// add to Application
		this.add(Title_Panel);
		this.add(Main_Panel);
		this.add(creator);
		
		// without this, we're fucked
		this.setVisible(true);
	}
	

	public static void main(String[] args) {
		new Application();
	}

}
