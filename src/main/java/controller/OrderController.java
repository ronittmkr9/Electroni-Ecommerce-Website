package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CartModel;
import model.ProductModel;



public class OrderController {
	
	DatabaseController dbController = new DatabaseController();
	
	   public List<CartModel> getAllOrders() {
	        List<CartModel> cartItems = new ArrayList<>();

	        try (Connection con = dbController.getConnection()) {
	            if (con != null && !con.isClosed()) {
	                String query = "SELECT * FROM tbl_cart"; // Modify query as per your database schema

	                try (PreparedStatement statement = con.prepareStatement(query);
	                     ResultSet resultSet = statement.executeQuery()) {

	                    while (resultSet.next()) {
	                    	   int id = resultSet.getInt("cart_id");
	                        // Retrieve data from the result set and create ProductModel objects
	                    	   CartModel cart = new CartModel(
	                    			   resultSet.getInt("cart_id"),
	                    			   resultSet.getString("fk_user_id"),
	                    			   resultSet.getString("fk_product_id"),
	                    			   resultSet.getString("quantity"),
	                    			   resultSet.getString("unit_price"), 
	       	    	             resultSet.getString("productName"),
	       	    	          resultSet.getString("productImage"),
	       	    	       resultSet.getString("cart_status")
	       	    	            );
	                    	   cartItems.add(cart);
	                    }
	                }
	            }
	        } catch (SQLException | ClassNotFoundException ex) {
	            ex.printStackTrace();
	            // Handle database connection or query execution errors
	        }

	        return cartItems;
	    }
	   
	   
	   public String getUserFullName(int userId) {
	        String fullName = null;
	        try (Connection con = dbController.getConnection()) {
	            String sql = "SELECT fullName FROM users WHERE id = ?";
	   
	            try (PreparedStatement ps = con.prepareStatement(sql)) {
	              
	                ps.setInt(1, userId);
	                try (ResultSet rs = ps.executeQuery()) {
	               
	                    if (rs.next()) {
	                        fullName = rs.getString("fullName");
	                    }
	                }
	            }
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return fullName;
	    }
	    
	    
}