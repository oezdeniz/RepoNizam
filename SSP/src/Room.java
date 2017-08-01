import java.math.BigDecimal;

/**
 * 
 * @author Nizam Özdemir
 *
 */
public class Room {

	private String available;
	private String available_from;
	private BigDecimal bed;
	private BigDecimal rate;
	private int room_nr;
	private String room_type;
	private BigDecimal stage;

	public Room(String available, String available_from, BigDecimal bed, BigDecimal rate, 
			String room_type, BigDecimal stage) {

		this( 0,available, available_from, bed, rate, room_type, stage);
	}
	
	public Room(int room_nr, String available, String available_from, BigDecimal bed, BigDecimal rate,
			String room_type, BigDecimal stage) {
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

	public BigDecimal getBed() {
		return bed;
	}

	public void setBed(BigDecimal bed) {
		this.bed = bed;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
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
	
	public BigDecimal getStage() {
		return stage;
	}

	public void setStage(BigDecimal stage) {
		this.stage = stage;
	}

	@Override
	public String toString() {
		return String
				.format("Room [available=%s, available_from=%s, bed=%s, rate=%s, room_nr=%s, room_type=%s, stage=%s]",
						available, available_from, bed, rate, room_nr, room_type, stage);
	}
	
	
		
}