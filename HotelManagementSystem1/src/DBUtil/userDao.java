package DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.User;

public class userDao{
		Connection con = DBUtil.makeConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		public int registerUser(User s) {
			int i = 0;
		try {
			pst = con.prepareStatement(
					"INSERT INTO users(name, phone, email, password, role) VALUES(?,?,?,?,?)");
			 pst.setString(1, s.getName());
	            pst.setString(2, s.getPhone());
	            pst.setString(3, s.getEmail());
	            pst.setString(4, s.getPassword());
	            pst.setString(5, s.getRole());

			 i = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return i;
		}
		public User login(String e,String p) {
			User i= null;
			try {
				pst = con.prepareStatement(
						("SELECT * FROM users WHERE email=? AND password=?"));
				 pst.setString(1, e);
		            pst.setString(2, p);
		           
		            rs = pst.executeQuery();
		            if (rs.next()) {
		                i = new User();

		                i.setUser_id(rs.getInt("user_id"));
		                i.setName(rs.getString("name"));
		                i.setPhone(rs.getString("phone"));
		                i.setEmail(rs.getString("email"));
		                i.setPassword(rs.getString("password"));
		                i.setRole(rs.getString("role"));
		            }

				 
				
			} catch (Exception e1) {
				e1.printStackTrace();

			}
			return i;
			
		}
		public List<User> getall(){
		List<User> list = new ArrayList<>();
		Connection con = DBUtil.makeConnection();
		try {

			pst = con.prepareStatement("SELECT * FROM users");

			rs = pst.executeQuery();

			while (rs.next()) {
            User u = new User();
            u.setUser_id(rs.getInt("user_id"));
            u.setName(rs.getString("name"));
            u.setPhone(rs.getString("phone"));
            u.setEmail(rs.getString("email"));
            u.setPassword(rs.getString("password"));
            u.setRole(rs.getString("role"));
            list.add(u);
			}
		 } catch (Exception e) {
	            e.printStackTrace();
	        }
			 return list;
		}
		public User getid(int id) {

	        User u = null;

	        try {
	            con = DBUtil.makeConnection();

	            String sql = "SELECT * FROM users WHERE user_id=?";
	            pst = con.prepareStatement(sql);

	            pst.setInt(1, id);

	            rs = pst.executeQuery();

	            if (rs.next()) {
	                u = new User();

	                u.setUser_id(rs.getInt("user_id"));
	                u.setName(rs.getString("name"));
	                u.setPhone(rs.getString("phone"));
	                u.setEmail(rs.getString("email"));
	                u.setPassword(rs.getString("password"));
	                u.setRole(rs.getString("role"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return u;
	    }
		public int remove(int id) {

			Connection con = DBUtil.makeConnection();
			PreparedStatement pst = null;
			int i = 0;

			try {

				pst = con.prepareStatement("DELETE FROM rooms WHERE User_id = ?");

				pst.setInt(1, id);

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

}