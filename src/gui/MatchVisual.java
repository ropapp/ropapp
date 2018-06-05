package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;
import java.awt.Rectangle;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import businessLogic.Article;
import businessLogic.HSL;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MatchVisual {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchVisual window = new MatchVisual();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MatchVisual() {
		
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(new Rectangle(0, 0, 400, 300));
		frame.getContentPane().setBounds(new Rectangle(0, 0, 200, 100));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		
		panel.setBounds(10, 11, 159, 131);
		frame.getContentPane().add(panel);
		
		JLabel colortext1 = new JLabel("");
		panel.add(colortext1);
		
		
		JPanel panel_1 = new JPanel();
		JLabel colortext2 = new JLabel("");
				
		panel_1.add(colortext2);
		
		panel_1.setBounds(191, 11, 159, 131);
		frame.getContentPane().add(panel_1);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(110, 189, 240, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		JButton btnNewButton = new JButton("Generar\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color c1=HSL.randomColor();
				Color c2=HSL.randomColor();
				
				Article a1= new Article(2, c1);
				Article a2= new Article(3, c2);
				float m = a1.matchColor(a2);
				String str = "";
				str=str+Float.toString(m)+";";
				panel.setBackground(c1);
				panel_1.setBackground(c2);
				lblNewLabel.setText(str);
			}
		});
		
		btnNewButton.setBounds(11, 180, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
