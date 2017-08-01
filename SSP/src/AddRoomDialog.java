import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class AddRoomDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField roomNrTextField;
	private JTextField availabletField;
	private JTextField availableFromTextField;
	private JTextField bedTextField;
	
	private RoomDAO roomDAO;

	private RoomApp roomApp;	
	private JTextField rateTextField;
	private JTextField roomTypeTextField;
	private JTextField stageTextField;

	public AddRoomDialog(RoomApp theRoomApp, RoomDAO theRoomDAO) {
		this();
		roomDAO = theRoomDAO;
		roomApp = theRoomApp;
	}

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		try {
			AddRoomDialog dialog = new AddRoomDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public AddRoomDialog() {
		setTitle("Add Room");
		setBounds(730, 350, 461, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblRoomNr = new JLabel("Room Nr");
			lblRoomNr.setBounds(12, 15, 62, 16);
			contentPanel.add(lblRoomNr);
		}
		{
			roomNrTextField = new JTextField();
			roomNrTextField.setBounds(110, 12, 317, 22);
			contentPanel.add(roomNrTextField);
			roomNrTextField.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("Available");
			lblLastName.setBounds(12, 44, 62, 16);
			contentPanel.add(lblLastName);
		}
		{
			availabletField = new JTextField();
			availabletField.setBounds(110, 41, 317, 22);
			contentPanel.add(availabletField);
			availabletField.setColumns(10);
		}
		{
			JLabel lblEmail = new JLabel("Available From");
			lblEmail.setBounds(12, 73, 86, 16);
			contentPanel.add(lblEmail);
		}
		{
			availableFromTextField = new JTextField();
			availableFromTextField.setBounds(110, 70, 317, 22);
			contentPanel.add(availableFromTextField);
			availableFromTextField.setColumns(10);
		}
		{
			JLabel lblSalary = new JLabel("Bed");
			lblSalary.setBounds(12, 102, 62, 16);
			contentPanel.add(lblSalary);
		}
		{
			bedTextField = new JTextField();
			bedTextField.setBounds(110, 99, 317, 22);
			contentPanel.add(bedTextField);
			bedTextField.setColumns(10);
		}
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setBounds(12, 131, 56, 16);
		contentPanel.add(lblRate);
		
		rateTextField = new JTextField();
		rateTextField.setBounds(110, 128, 317, 22);
		contentPanel.add(rateTextField);
		rateTextField.setColumns(10);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setBounds(12, 160, 86, 16);
		contentPanel.add(lblRoomType);
		
		roomTypeTextField = new JTextField();
		roomTypeTextField.setBounds(110, 157, 317, 22);
		contentPanel.add(roomTypeTextField);
		roomTypeTextField.setColumns(10);
		
		JLabel lblStage = new JLabel("Stage");
		lblStage.setBounds(12, 189, 56, 16);
		contentPanel.add(lblStage);
		
		stageTextField = new JTextField();
		stageTextField.setBounds(110, 186, 317, 22);
		contentPanel.add(stageTextField);
		stageTextField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton saveButton = new JButton("Save");
				saveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						saveRoom();
					}
				});
				saveButton.setActionCommand("Save");
				buttonPane.add(saveButton);
				getRootPane().setDefaultButton(saveButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
	
			}	
		}
	}
	

	protected BigDecimal convertStringToBigDecimal(String str) {

		BigDecimal result = null;

		try {
			double strDouble = Double.parseDouble(str);

			result = BigDecimal.valueOf(strDouble);
		} catch (Exception exc) {
			System.out.println("Invalid value. Defaulting to 0.0");
			result = BigDecimal.valueOf(0.0);
		}

		return result;
	}

	protected void saveRoom() {

		// get the room info from gui
		String available = availabletField.getText();
		String available_from = availableFromTextField.getText();
		String room_type = roomTypeTextField.getText();
		
		String strBed = bedTextField.getText();
		BigDecimal bed = convertStringToBigDecimal(strBed);
		
		String strRate = rateTextField.getText();
		BigDecimal rate = convertStringToBigDecimal(strRate);
		
		String strStage = stageTextField.getText();
		BigDecimal stage = convertStringToBigDecimal(strStage);

		Room tempRoom = new Room(available, available_from, bed, rate, room_type, stage);
		
		try {
			// save to the database
			roomDAO.addRoom(tempRoom);

			// close dialog
			setVisible(false);
			dispose();

			// refresh gui list
			roomApp.refreshRoomView();
			
			// show success message
			JOptionPane.showMessageDialog(roomApp,
					"Room added succesfully.",
					"Room Added",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(
					roomApp,
					"Error saving Room: "
							+ exc.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
