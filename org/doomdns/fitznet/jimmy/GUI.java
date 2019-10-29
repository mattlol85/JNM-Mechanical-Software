package org.doomdns.fitznet.jimmy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class GUI {

	private JFrame frmJnmMechanicalWebtool;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmJnmMechanicalWebtool.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJnmMechanicalWebtool = new JFrame();
		frmJnmMechanicalWebtool.setTitle("JNM Mechanical WebTool");
		frmJnmMechanicalWebtool.setBounds(100, 100, 910, 557);
		frmJnmMechanicalWebtool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJnmMechanicalWebtool.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 894, 21);
		frmJnmMechanicalWebtool.getContentPane().add(menuBar);
		
		JMenu settingsMenu = new JMenu("Settings");
		menuBar.add(settingsMenu);
		
		Button button = new Button("Quit");
		settingsMenu.add(button);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		
		/*
		 * Temporary place holders for Data display
		 */
		String[] colNames = {"Name","Address"};
		String[][] testingData = {{"Matthew Fitzgerald", "2013 TestAddress"},{"John TestGuy", "123123 JohnLane"}};
		
		table = new JTable(testingData,colNames);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(510, 53, 374, 455);
		frmJnmMechanicalWebtool.getContentPane().add(table);
		
		JLabel lblAddNewHome = new JLabel("Quick Actions");
		lblAddNewHome.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblAddNewHome.setBounds(10, 32, 97, 14);
		frmJnmMechanicalWebtool.getContentPane().add(lblAddNewHome);
		
		JButton btnNewHome = new JButton("New Home");
		btnNewHome.setBounds(10, 57, 107, 23);
		frmJnmMechanicalWebtool.getContentPane().add(btnNewHome);
		
		JButton btnNewAirSystem = new JButton("New Air System");
		btnNewAirSystem.setBounds(10, 91, 107, 23);
		frmJnmMechanicalWebtool.getContentPane().add(btnNewAirSystem);
		
		JButton btnNewButton = new JButton("Quick Calculate");
		btnNewButton.setToolTipText("Quickly find the BTU required for the room");
		btnNewButton.setBounds(10, 125, 107, 23);
		frmJnmMechanicalWebtool.getContentPane().add(btnNewButton);
		frmJnmMechanicalWebtool.setVisible(true);
	}
}
