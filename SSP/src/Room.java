
/**
 * 
 * @author Nizam �zdemir
 *
 */
public class Room {

	private String available;
	private String available_from;
	private int bed;
	private int rate;
	private int room_nr;
	private String room_type;
	private int stage;

	public Room(String available, String available_from, int bed, int rate, 
			String room_type, int stage) {

		this( 0,available, available_from, bed, rate, room_type, stage);
	}
	
	public Room(int room_nr, String available, String available_from, int bed, int rate,
			String room_type, int stage) {
		super();
		this.available = available;
		this.available_from = available_from;
		this.bed = bed;
		this.rate = rate;
		this.room_nr = room_nr;
		this.room_type = room_type;
		this.stage = stage;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getAvailableFrom() {
		return available_from;
	}

	public void setAvailableFrom(String available_from) {
		this.available_from = available_from;
	}

	public int getBed() {
		return bed;
	}

	public void setBed(int bed) {
		this.bed = bed;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getRoomNr() {
		return room_nr;
	}

	public void setRoomNr(int room_nr) {
		this.room_nr = room_nr;
	}
	
	public String getRoomType() {
		return room_type;
	}

	public void setRoomType(String room_type) {
		this.room_type = room_type;
	}
	
	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	@Override
	public String toString() {
		return String
				.format("Room [available=%s, available_from=%s, bed=%s, rate=%s, room_nr=%s, room_type=%s, stage=%s]",
						available, available_from, bed, rate, room_nr, room_type, stage);
	}
	
	
		
}