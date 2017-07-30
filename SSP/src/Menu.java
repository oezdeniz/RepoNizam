import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	EmployeeSearchApp esa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 120, 1200, 800);
		
		// Fullscreen
		/*
		this.setUndecorated(false);
		this.setAlwaysOnTop(true);
		this.setResizable(true);
		this.setVisible(true);
		Toolkit tk = Toolkit.getDefaultToolkit();
			int xsize = (int) tk.getScreenSize().getWidth();
			int ysize = (int) tk.getScreenSize().getHeight();
		this.setSize (xsize, ysize);
		*/
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnStart = new JMenu("Start");
		menuBar.add(mnStart);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnStart.add(mntmQuit);
		
		JMenu mnEmployee = new JMenu("Employee");
		menuBar.add(mnEmployee);
		
		JMenuItem mntmManage = new JMenuItem("Manage");
		mntmManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				esa.startEmployeeSearchApp();
			}
		});
		mnEmployee.add(mntmManage);
		
		JMenu mnCostumers = new JMenu("Costumers");
		menuBar.add(mnCostumers);
		
		JMenuItem mntmManage_1 = new JMenuItem("Manage");
		mnCostumers.add(mntmManage_1);
		
		JMenu mnBookings = new JMenu("Bookings");
		menuBar.add(mnBookings);
		
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
