package Model;

public class User {

    private int user_id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String role;

    
    public User() {
    }

    
    public User(int user_id, String name, String phone, String email, String password, String role) {
        this.user_id = user_id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", password="
				+ password + ", role=" + role + "]";
	}


	// Getter and Setter
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
