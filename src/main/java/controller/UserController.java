package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.UsersModel;




public class UserController{
	
	DatabaseController dbController = new DatabaseController();
	
	   public List<UsersModel> getAllUsers() {
	        List<UsersModel> users = new ArrayList<>();

	        try (Connection con = dbController.getConnection()) {
	            if (con != null && !con.isClosed()) {
	                String query = "SELECT * FROM users"; // Modify query as per your database schema

	                try (PreparedStatement statement = con.prepareStatement(query);
	                     ResultSet resultSet = statement.executeQuery()) {
	                		System.out.println(resultSet);
	                    while (resultSet.next()) {
	                        // Retrieve data from the result set and create UserModel objects
	                    	UsersModel user = new UsersModel(
	                            resultSet.getInt("id"),
	                    			  resultSet.getString("fullName"),
	                    			  resultSet.getString("user_name"),
	                    			   resultSet.getString("user_email"),
	                    			    resultSet.getString("user_password"),
	                    	             resultSet.getString("user_address"),
	  	                            resultSet.getString("user_contact"),
		                         
	  	                            resultSet.getBoolean("is_admin")
	                            
	                            // You can include additional user attributes here
	                        );
	                        users.add(user);
	                    }
	                }
	            }
	        } catch (SQLException | ClassNotFoundException ex) {
	            ex.printStackTrace();
	            // Handle database connection or query execution errors
	        }

	        return users;
	    }
	   
	   
	   public UsersModel getUserById(HttpSession session) {
	        // Get the user ID from the session
	        int userId = (int) session.getAttribute("user_id");

	        UsersModel user = null;

	        try (Connection con = dbController.getConnection()) {
	            if (con != null && !con.isClosed()) {
	                String query = "SELECT * FROM users WHERE id = ?"; // Modify query as per your database schema

	                try (PreparedStatement statement = con.prepareStatement(query)) {
	                    statement.setInt(1, userId);

	                    try (ResultSet resultSet = statement.executeQuery()) {
	                        if (resultSet.next()) {
	                            // Retrieve data from the result set and create a UserModel object
	                            user = new UsersModel(
		                                resultSet.getInt("id"),
		                                resultSet.getString("fullName"),
		                                resultSet.getString("user_name"),
		                                resultSet.getString("user_email"),
		                                resultSet.getString("user_password"),
		                                resultSet.getString("user_address"),
		                                resultSet.getString("user_contact"),
		                                resultSet.getBoolean("is_admin")
		                                // Add more fields as needed
		                            );
	                        }
	                    }
	                }
	            }
	        } catch (SQLException | ClassNotFoundException ex) {
	            ex.printStackTrace();
	            // Handle database connection or query execution errors
	        }

	        return user;
	    }
	   
	   
	    public void updateUserProfile(int id, String fullName, String user_name, String user_email,String user_password, String user_address, String user_contact, String is_admin) {
	        try (Connection con = dbController.getConnection()) {
	            if (con != null && !con.isClosed()) {
	                String query = "UPDATE users SET fullName = ?, user_name = ?, user_email = ?, user_password = ?,user_address = ?, user_contact = ?, is_admin = ? WHERE id = ?";
	
	                try (PreparedStatement statement = con.prepareStatement(query)) {
	                    statement.setString(1, fullName);
	                    statement.setString(2, user_name);
	                    statement.setString(3, user_email);
	                    statement.setString(4, user_password);
	                    statement.setString(5, user_address);
	                    statement.setString(6, user_contact);
	                    statement.setString(7, is_admin);
	                    statement.setInt(8, id);
	                   
	                    statement.executeUpdate();
	                }
	            }
	        } catch (SQLException | ClassNotFoundException ex) {
	            ex.printStackTrace();
	            // Handle database connection or query execution errors
	        }
	    }
	
}