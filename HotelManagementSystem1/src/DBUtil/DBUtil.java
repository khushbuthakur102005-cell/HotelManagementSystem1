package DBUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Rooms;




public class DBUtil {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/HotelManagementSystem1";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";

	public static Connection makeConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

// insterd
	public int addRoom(Rooms s) {
		Connection con = DBUtil.makeConnection();
		PreparedStatement pst = null;
int i = 0;
		try {
			pst = con.prepareStatement(
					"INSERT INTO rooms(rooms_no, rooms_type, price_, is_booked, user_id) VALUES(?,?,?,?,?)");

			pst.setInt(1, s.rooms_no);
			pst.setString(2, s.rooms_type);
			pst.setDouble(3, s.price_);
			pst.setBoolean(4, s.is_booked);
			pst.setInt(5, s.user_id);
			 i = pst.executeUpdate();
			if (i > 0) {
				System.out.println("---add rooms---");
			} else {
				System.out.println("Something went wrong...");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return i;
	}

//		delete
	public int deleteRoom(int rooms_id) {

		Connection con = DBUtil.makeConnection();
		PreparedStatement pst = null;
		int i = 0;

		try {

			pst = con.prepareStatement("DELETE FROM rooms WHERE rooms_id = ?");

			pst.setInt(1, rooms_id);

			i = pst.executeUpdate();

			if (i > 0) {
				System.out.println("Room Deleted Successfully");
			} else {
				System.out.println("Room ID Not Found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
//	update

	public void updateRoom(Rooms s) {

		Connection con = DBUtil.makeConnection();
		PreparedStatement pst = null;

		try {

			pst = con.prepareStatement("UPDATE rooms SET rooms_type = ?, price_ = ? WHERE rooms_id = ?");

			pst.setString(1, s.rooms_type);
			pst.setDouble(2, s.price_);
			pst.setInt(3, s.rooms_id);

			int i = pst.executeUpdate();

			if (i > 0) {
				System.out.println("Room Updated Successfully");
			} else {
				System.out.println("Room ID Not Found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//		    show all 
	public ArrayList<Rooms> viewRooms() {

		Connection con = DBUtil.makeConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Rooms> list = new ArrayList<>();

		try {

			pst = con.prepareStatement("SELECT * FROM rooms");

			rs = pst.executeQuery();

			while (rs.next()) {
				Rooms rm = new Rooms();

				System.out.println("--------show rooms --------------------------");

				rm.rooms_id = rs.getInt("rooms_id");
				rm.rooms_no = rs.getInt("rooms_no");
				rm.rooms_type = rs.getString("rooms_type");
				rm.price_ = rs.getDouble("price_");
				rm.is_booked = rs.getBoolean("is_booked");
				rm.user_id = rs.getInt("user_id");

				list.add(rm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Rooms> get () {
		 Connection con = DBUtil.makeConnection();
		    PreparedStatement pst = null;
		    ResultSet rs = null;

		    ArrayList<Rooms> list = new ArrayList<>();

		    try {

		        pst = con.prepareStatement("SELECT * FROM rooms WHERE is_booked = ?");

		        pst.setBoolean(1, false);

		        rs = pst.executeQuery();

		        while (rs.next()) {

		            Rooms rm = new Rooms();

		            rm.rooms_id = rs.getInt("rooms_id");
		            rm.rooms_no = rs.getInt("rooms_no");
		            rm.rooms_type = rs.getString("rooms_type");
		            rm.price_ = rs.getDouble("price_");
		            rm.is_booked = rs.getBoolean("is_booked");
		            rm.user_id = rs.getInt("user_id");

		            list.add(rm);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		 
		
		return list;
	 }

	public int addRoom(int rn, int uid) {
		// T
		return 0;
	}
			        
			
}
		
		
	



