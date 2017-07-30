
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import java.util.List;


/*

@Author Nizam Özdemir

*/

public class RoomApp extends JFrame {

	private JPanel contentPane;
	private JTextField roomTextField;
	private JButton btnSearchRoom;
	private JScrollPane scrollPane;
	private JTable table;

	private RoomDAO roomDAO;
	private JPanel panel_1;
	private JButton btnAddRoom;
	
	/**
	 * Launch the application.
	 */
	public static void startRoomApp() {
	//public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomApp frame = new RoomApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RoomApp() {
		
		// create the DAO
		try {
			roomDAO = new RoomDAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		
		setTitle("Employee Search App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 920, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblEnterRoom = new JLabel("Enter Room Nr.");
		panel.add(lblEnterRoom);
		
		roomTextField = new JTextField();
		panel.add(roomTextField);
		roomTextField.setColumns(10);
		
		btnSearchRoom = new JButton("Search");
		btnSearchRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get last name from the text field

				// Call DAO and get employees for the Room

				// If last name is empty, then get all Rooms

				// Print out Rooms			
				
				try {
					String room = roomTextField.getText();

					List<Room> roomList = null;

					roomList = roomDAO.getAllRooms();
					
					
					// create the model and update the "table"
					RoomTableModel roomModel = new RoomTableModel(roomList);
					
					table.setModel(roomModel);
					System.out.println(roomList.size());
					
					/*
					for (Employee temp : employees) {
						System.out.println(temp);
					}
					*/
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(RoomApp.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
				}
				
			}
		});
		panel.add(btnSearchRoom);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		/*
		btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create dialog
				AddEmployeeDialog dialog = new AddEmployeeDialog(EmployeeSearchApp.this, employeeDAO);

				// show dialog
				dialog.setVisible(true);
			}
		});
		panel_1.add(btnAddEmployee);
	}

	public void refreshEmployeesView() {

		try {
			List<Employee> employees = employeeDAO.getAllEmployees();

			// create the model and update the "table"
			EmployeeTableModel model = new EmployeeTableModel(employees);

			table.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		*/
		
	}

}