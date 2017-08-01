
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
	
	public void getRoomDAO(){
		// create the DAO
		try {
			roomDAO = new RoomDAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
	}
	
	public void getRoomTable(){
		try {

			List<Room> roomList = null;

			roomList = roomDAO.getAllRooms();
			
			
			// create the model and update the "table"
			RoomTableModel roomModel = new RoomTableModel(roomList);
			
			table.setModel(roomModel);
			System.out.println(roomList.size());
			
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(RoomApp.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		
	}
	
	

	/**
	 * Create the application.
	 */
	public RoomApp() {
		
		setTitle("Room Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 920, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 892, 26);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel);
		
		JLabel lblRoom = new JLabel("Table");
		panel.add(lblRoom);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 31, 892, 516);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancelButton.setBounds(793, 565, 97, 25);
		contentPane.add(cancelButton);
		
		getRoomDAO();
		getRoomTable();
		
		
		btnAddRoom = new JButton("Add Room");
		btnAddRoom.setBounds(668, 565, 113, 25);
		contentPane.add(btnAddRoom);
		btnAddRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create dialog
				AddRoomDialog dialog = new AddRoomDialog(RoomApp.this, roomDAO);

				// show dialog
				dialog.setVisible(true);
			}
		});
	}

	public void refreshRoomView() {

		try {
			List<Room> roomList = roomDAO.getAllRooms();

			// create the model and update the "table"
			RoomTableModel model = new RoomTableModel(roomList);

			table.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
}