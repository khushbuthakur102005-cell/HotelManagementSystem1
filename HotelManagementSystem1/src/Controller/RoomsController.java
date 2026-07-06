package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import DBUtil.DBUtil;
import Model.Rooms;

public class RoomsController {

    Scanner sc = new Scanner(System.in);

    public void addRoom() {
    	  Scanner sc = new Scanner(System.in);

        System.out.println("Enter Room No : ");
        int rn = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter Room Type : ");
        String rt = sc.nextLine();

        System.out.println("Enter Price : ");
        double rp = sc.nextDouble();

        System.out.println("Is Booked (true/false) : ");
        boolean ib = sc.nextBoolean();

        System.out.println("Enter User ID : ");
        int uid = sc.nextInt();
        System.out.println("Enter rooms ID : ");
        int rid = sc.nextInt();

        Rooms dto = new Rooms(rn,rt,rp,ib,uid);
        DBUtil db = new DBUtil();
          int i = db.addRoom(dto);
          if (i > 0) {
        	    System.out.println("Room Added Successfully");
        	} else {
        	    System.out.println("Something went wrong...");
        	}
    }

//	public void bookroom() {
//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("Enter Room No : ");
//		int rn = sc.nextInt();
//		System.out.println("Enter User ID : ");
//		int uid = sc.nextInt();
//		Rooms r = new Rooms();
//		r.rooms_no = rn;
//		r.user_id = uid;
//		 r.is_booked = true; 
//
//		DBUtil db = new DBUtil();
//		int i = db.addRoom(r);
//		
//		if (i != 0) {
//			System.out.println(i + "Room booked");
//		} else {
//			System.out.println("somethig went worg...");
//		}
//
//	}
//	public void cancelRooms() {
//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("Enter Room id : ");
//		int rid = sc.nextInt();
//		System.out.println("Enter User ID : ");
//		int uid = sc.nextInt();
//		DBUtil db = new DBUtil();
//		int i = db.Booking(rid);
//		if (i != 0) {
//			System.out.println(i + "Room booked");
//		} else {
//			System.out.println("somethig went worg...");
//		}
//
//	}
    
    
    public void deleteRoom() {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter Room ID : ");
        int rid = sc.nextInt();

        DBUtil db = new DBUtil();

        int i = db.deleteRoom(rid);

        if (i != 0) {
            System.out.println( i + "Room Deleted Successfully");
        } else {
            System.out.println("Something went Worng: --");
        }
    }
    
    public void viewRooms() {

        DBUtil db = new DBUtil();

        ArrayList<Rooms> list = db.viewRooms();

        System.out.println("---------- Rooms Details ----------");

        for (Rooms rm : list) {

            System.out.println("Room ID      : " + rm.getRoom_id());
            System.out.println("Room No      : " + rm.getRoom_no());
            System.out.println("Room Type    : " + rm.getRoom_type());
            System.out.println("Price        : " + rm.getPrice_());
            System.out.println("Is Booked    : " + rm.getIs_booked());
            System.out.println("User ID      : " + rm.getUser_id());
            System.out.println("----------------------------------");
        }
    
   }
    public void Bookings() {

        DBUtil db = new DBUtil();

        ArrayList<Rooms> list = db.get();

        System.out.println("---------- Rooms Details ----------");

        for (Rooms rm : list) {

            System.out.println("Room ID      : " + rm.getRoom_id());
            System.out.println("Room No      : " + rm.getRoom_no());
            System.out.println("Room Type    : " + rm.getRoom_type());
            System.out.println("Price_       : " + rm.getPrice_());
            System.out.println("Is Booked    : " + rm.getIs_booked());
            System.out.println("User ID      : " + rm.getUser_id());
            System.out.println("----------------------------------");
        }
    }
    
}
