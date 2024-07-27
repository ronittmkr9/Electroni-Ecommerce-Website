package model;

//import java.time.LocalDate;

public class UsersModel {
    private int id;
    private String fullName;
    private String user_contact;
    private String user_name;
    private String user_email;
    private String user_address;
    private String user_password;
    private boolean is_admin;

    // Constructor
    public UsersModel(int id, String fullName,String user_name, String user_email, String user_password,
                      String user_address,  String user_contact,  boolean is_admin) {
        this.id = id;
        this.fullName = fullName;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_address = user_address;
        this.user_contact = user_contact;

        this.is_admin = is_admin;
    }

    // Getter and setter methods for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter methods for fullName
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Getter and setter methods for user_contact
    public String getUserContact() {
        return user_contact;
    }

    public void setUser_contact(String user_contact) {
        this.user_contact = user_contact;
    }

    // Getter and setter methods for user_name
    public String getUsername() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    // Getter and setter methods for user_email
    public String getUserEmail() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    // Getter and setter methods for user_address
    public String getUserAddress() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    // Getter and setter methods for user_password
    public String getUserPassword() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    // Getter and setter methods for is_admin
    public boolean isAdmin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    // toString() method
    @Override
    public String toString() {
        return "UsersModel{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", user_contact='" + user_contact + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_address='" + user_address + '\'' +
                ", user_password='" + user_password + '\'' +
                ", is_admin=" + is_admin +
                '}';
    }
    
//    public UsersModel getIsAdmin() {
//    	
//    }
}


