package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CartModel;
import utils.StringUtlis;



public class CartController{
	
	DatabaseController dbController = new DatabaseController();
	
   
	public int addCart(CartModel cartModel) {
		
		try(Connection con = dbController.getConnection()){
			
			  if (con != null && !con.isClosed()) { 
		            PreparedStatement statement = con.prepareStatement(StringUtlis.INSERT_CART);

		            statement.setString(1, cartModel.getFk_user_id());
		            statement.setString(2, cartModel.getFk_product_id());
		            statement.setString(3, cartModel.getUnit_price());
		            statement.setString(4, cartModel.getQuantity());
		            statement.setString(5, cartModel.getproductName());
		            statement.setString(6, cartModel.getproductImage());
		            statement.setString(7, cartModel.getCartStatus());

	
		            
		            int result = statement.executeUpdate();
		            System.out.println("Connection is  established.");
		            return result > 0 ? 1 : 0;
		        } else {
		            System.out.println("Connection is not established or closed.");
		            return -1; // Indicate connection issue
		        }
		}
		
		catch( SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			
			return - 1;
		}	
		
		
	}
	
	public List<CartModel> getCartItemsByUserId(int userId) {
	    List<CartModel> cartItems = new ArrayList<>();

	    try (Connection con = dbController.getConnection()) {
	        if (con != null && !con.isClosed()) {
	            String query = "SELECT * FROM tbl_cart WHERE fk_user_id = ? AND cart_status = 'C'"; 

	            try (PreparedStatement statement = con.prepareStatement(query)) {
	                statement.setInt(1, userId);

	                try (ResultSet resultSet = statement.executeQuery()) {
	                    while (resultSet.next()) {
	                 
	                        CartModel cartItem = new CartModel(
	                                resultSet.getInt("cart_id"),
	                                resultSet.getString("fk_user_id"),
	                                resultSet.getString("fk_product_id"),
	                                resultSet.getString("unit_price"),
	                                resultSet.getString("quantity"),
	                                resultSet.getString("productName"),
	                                resultSet.getString("productImage"),
	                                resultSet.getString("cart_status")
	                        );
	                        cartItems.add(cartItem);
	                    }
	                }
	            }
	        }
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();

	    }

	    return cartItems;
	}
	
	
	public List<CartModel> getOrderHistoryByUserId(int userId) {
	    List<CartModel> cartItems = new ArrayList<>();

	    try (Connection con = dbController.getConnection()) {
	        if (con != null && !con.isClosed()) {
	            String query = "SELECT * FROM tbl_cart WHERE fk_user_id = ? AND cart_status = 'D'";

	            try (PreparedStatement statement = con.prepareStatement(query)) {
	                statement.setInt(1, userId);

	                try (ResultSet resultSet = statement.executeQuery()) {
	                    while (resultSet.next()) {
	                        
	                        CartModel cartItem = new CartModel(
	                                resultSet.getInt("cart_id"),
	                                resultSet.getString("fk_user_id"),
	                                resultSet.getString("fk_product_id"),
	                                resultSet.getString("unit_price"),
	                                resultSet.getString("quantity"),
	                                resultSet.getString("productName"),
	                                resultSet.getString("productImage"),
	                                resultSet.getString("cart_status")
	                        );
	                        cartItems.add(cartItem);
	                    }
	                }
	            }
	        }
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();

	    }

	    return cartItems;
	}

	
}
