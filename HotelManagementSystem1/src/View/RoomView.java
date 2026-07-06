
package View;

import java.util.Scanner;

import Controller.RoomsController;

public class RoomView {

    Scanner sc = new Scanner(System.in);
    RoomsController rc = new RoomsController();
    public static void main(String[] args) {
        RoomView rv = new RoomView();
        rv.showMenu();
    }   
    public void showMenu() {

        System.out.println("\n===== Hotel Management System =====");
        System.out.println("1. Add Room");
        System.out.println("2. View Rooms");
        System.out.println("3. Update Room");
        System.out.println("4. Delete Room");
        System.out.println("5. Exit");

        System.out.print("Enter Choice: ");
        
        int ch = sc.nextInt();
        switch(ch){
        case 1:
        	rc.addRoom();
        	break;
        	
        case 2:
            rc.viewRooms();
            break;

        case 3:
            rc.Bookings();
            break;

        case 4:
            rc.deleteRoom();
            break;

        case 5:
            System.out.println("Thank You...");
            break;

        default:
            System.out.println("Invalid Choice!");
        } 	

     while (ch != 5);

    sc.close();

}
        	
        	
        
    }
