
import java.util.*;
import java.sql.*;
import java.io.*;
import java.math.BigDecimal;


/**
 * 
 * @author Nizam Özdemir
 *
 */
public class RoomDAO {

	private Connection myConn;
	
	public RoomDAO() throws Exception {
		
		// connect to database
        myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sspdb","root","");
        System.out.println("Verbunden");
		
	}
	
	
	public void addRoom(Room theRoom) throws Exception {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("insert into room"
					+ " (room_nr, available, available_from, bed, rate, room_type, stage)"
					+ " values (?, ?, ?, ?, ?, ?, ?)");
			
			// set params
			myStmt.setInt(1, theRoom.getRoomNr());
			myStmt.setString(2, theRoom.getAvailable());
			myStmt.setString(3, theRoom.getAvailableFrom());
			myStmt.setBigDecimal(4, theRoom.getBed());
			myStmt.setBigDecimal(5, theRoom.getRate());
			myStmt.setString(6, theRoom.getRoomType());
			myStmt.setBigDecimal(7, theRoom.getStage());
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
	
	
	
	public List<Room> getAllRooms() throws Exception {
		List<Room> roomList = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from room");
			
			while (myRs.next()) {
				Room tempRoom = convertRowToRoom(myRs);
				roomList.add(tempRoom);
			}

			return roomList;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	
	public List<Room> searchRoom(String available) throws Exception {
		List<Room> roomList = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			available += "%";
			myStmt = myConn.prepareStatement("select * from room where available like ?");
			
			myStmt.setString(1, available);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Room tempRoom = convertRowToRoom(myRs);
				roomList.add(tempRoom);
			}
			
			return roomList;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	
	private Room convertRowToRoom(ResultSet myRs) throws SQLException {
		
		int room_nr = myRs.getInt("room_nr");
		String available = myRs.getString("available");
		String available_from = myRs.getString("available_from");
		BigDecimal bed = myRs.getBigDecimal("bed");
		BigDecimal rate = myRs.getBigDecimal("rate");
		String room_type = myRs.getString("room_type");
		BigDecimal stage = myRs.getBigDecimal("stage");
		
		Room tempRoom = new Room(room_nr, available, available_from, bed, rate, room_type, stage);
		
		return tempRoom;
	}

	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}

	private void close(Statement myStmt) throws SQLException {
		close(null, myStmt, null);		
	}
	
	public static void main(String[] args) throws Exception {
		
		RoomDAO dao = new RoomDAO();
		/*System.out.println(dao.searchRooms("1"));

		System.out.println(dao.getAllRooms());
		*/
	}
}
