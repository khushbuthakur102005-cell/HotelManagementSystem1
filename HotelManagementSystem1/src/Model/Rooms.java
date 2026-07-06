package Model;
public class Rooms{
	public int rooms_id;
	public int rooms_no;
	public String rooms_type;
	public double price_;
	public Boolean is_booked;
	public int user_id;
	public Rooms(int room_id) {
		super();
		this.rooms_no = room_id;
		
	}
	public int getRoom_id() {
		return rooms_id;
	}
	public void setRoom_id(int room_id) {
		this.rooms_no = room_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRoom_no() {
		return rooms_no;
	}
	public Rooms() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rooms(int room_no, String room_type, double price_, Boolean is_booked,int user_id) {
		super();
		this.rooms_no = room_no;
		this.rooms_type = room_type;
		this.price_ = price_;
		this.is_booked = is_booked;
		this.user_id = user_id;
	}
	public void setRoom_no(int room_no) {
		this.rooms_no = room_no;
	
	}
	public String getRoom_type() {
		return rooms_type;
	}
	public void setRoom_type(String room_type) {
		this.rooms_type = room_type;
	}
	public double getPrice_() {
		return price_;
	}
	public void setPrice_(double price_) {
		this.price_ = price_;
	}
	public Boolean getIs_booked() {
		return is_booked;
	}
	public void setIs_booked(Boolean is_booked) {
		this.is_booked = is_booked;
	} 
	@Override
	public String toString() {
		return "Rooms [room_id=" + rooms_no + ", user_id=" + user_id + "]";
	}
}

