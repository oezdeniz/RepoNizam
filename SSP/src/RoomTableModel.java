
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author Nizam Özdemir
 *
 */

class RoomTableModel extends AbstractTableModel {

	private static final int ROOM_NR_COL = 0;
	private static final int AVAILABLE_FROM_COL = 1;
	private static final int BED_COL = 2;
	private static final int RATE_COL = 3;
	private static final int AVAILABLE_COL = 4;
	private static final int ROOM_TYPE_COL = 5;
	private static final int STAGE_COL = 6;

	private String[] columnNamesRoom = { "Room_Nr", "Available", "Available_From", "Bed",
			"Rate", "Room_Type", "Stage" };
	private List<Room> roomList;

	public RoomTableModel(List<Room> theRooms) {
		roomList = theRooms;
	}

	//@Override
	public int getColumnCount() {
		return columnNamesRoom.length;
	}
	
	@Override
	public int getRowCount() {
		//return 6;
		return roomList.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNamesRoom[col];
	}

	@Override
	public Object getValueAt(int row, int col) {


		Room tempRoom = roomList.get(row);

		switch (col) {
		case ROOM_NR_COL:
			return tempRoom.getRoomNr();
		case AVAILABLE_COL:
			return tempRoom.getAvailable();
		case AVAILABLE_FROM_COL:
			return tempRoom.getAvailableFrom();
		case BED_COL:
			return tempRoom.getBed();
		case RATE_COL:
			return tempRoom.getRate();
		case ROOM_TYPE_COL:
			return tempRoom.getRoomType();
		case STAGE_COL:
			return tempRoom.getStage();
		default:
			return tempRoom.getAvailable();
		}
	}
	
	/*
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	*/
}
