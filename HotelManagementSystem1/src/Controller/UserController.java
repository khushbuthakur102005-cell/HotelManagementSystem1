package Controller;

import java.util.Scanner;
import DBUtil.userDao;

import Model.User;

public class UserController {
	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        userDao dao = new userDao();
//	        UserDao dao = new UserDao();
	       
	        System.out.println("===== USER MENU =====");
	        System.out.println("1. Register User");
	        System.out.println("2. Login User");
	        System.out.println("3. Get User By ID");
            System.out.println("enter deleteUser ");
	        System.out.println("Enter choice:");

	        int ch = sc.nextInt();
	        switch (ch) {

	        case 1:
                User u1 = new User();

                System.out.println("Enter Name:");
                u1.setName(sc.next());

                System.out.println("Enter Phone:");
                u1.setPhone(sc.next());
              sc.nextLine();
                System.out.println("Enter Email:");
                u1.setEmail(sc.next());
                
                System.out.println("Enter Password:");
                u1.setPassword(sc.next());

                u1.setRole("CUSTOMER");

                int i = dao.registerUser(u1);

                if (i > 0) {
                    System.out.println("User Registered Successfully!");
                } else {
                    System.out.println("Registration Failed!");
                }
                break;
                
               
	        case 2:

                System.out.println("Enter Email:");
                String email = sc.next();

                System.out.println("Enter Password:");
                String pass = sc.next();

                User loginUser = dao.login(email, pass);

                if (loginUser != null) {
                    System.out.println("Login Success Welcome " + loginUser.getName());
                    System.out.println("Role: " + loginUser.getRole());
                } else {
                    System.out.println("Invalid Email or Password");
                }
                break;
                
                
                
                
	        
	        case 3:
                System.out.println("Enter User ID:");
                int id = sc.nextInt();

                User u = dao.getid(id);

                if (u != null) {
                    System.out.println("Name: " + u.getName());
                    System.out.println("Email: " + u.getEmail());
                    System.out.println("Phone: " + u.getPhone());
                    System.out.println("Role: " + u.getRole());
                } else {
                    System.out.println("User Not Found!");
                }
                break;
                
                
                
	        case 4:
	        	System.out.println("enter User ID");
	        	id = sc.nextInt();	 
	        	 
	        	 int ID = dao.remove(id);
	        	
	        	 if(ID > 0 ) {
	        		 System.out.println(ID + "user Upadeted");
	        	 }else 
	        	 {
	        		 System.out.println("somthing went worng..");
	        	 }
	        	 
	        
	        break;

            default:
                System.out.println("Invalid Choice!");
        }

        sc.close();
    }
         
	
}
