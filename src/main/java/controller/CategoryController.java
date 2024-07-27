package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoryModel;
import model.ProductModel;

@WebServlet("/categoryController")
public class CategoryController{
	
	DatabaseController dbController = new DatabaseController();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");
	    
	    if (action != null && action.equals("delete")) {
	        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
	        System.out.println("test");
	        boolean deleted = deleteCategory(categoryId); 
	        if (deleted) {
	            response.getWriter().write("Category deleted successfully");
	        } else {
	            response.getWriter().write("Failed to delete category");
	        }
	    } else {
	        // Handle other actions or requests if needed
	    }
	}
    public boolean deleteCategory(int categoryId) {
        try (Connection con = dbController.getConnection();
             PreparedStatement stmt = con.prepareStatement("DELETE FROM tbl_category WHERE id = ?")) {
            stmt.setInt(1, categoryId);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
    }
	
    
    public List<CategoryModel> getAllCategories() {
    	List<CategoryModel> categories = new ArrayList<>();
    	try (Connection con = dbController.getConnection()) {
    	    String sql = "SELECT * FROM tbl_category";
    	    try (PreparedStatement st = con.prepareStatement(sql);
    	         ResultSet rs = st.executeQuery()) {
    	        while (rs.next()) {
    	            CategoryModel category = new CategoryModel(
    	                rs.getInt("id"),
    	                rs.getString("categoryName"),
    	                rs.getString("categorySlug"),
    	                rs.getBoolean("status")
    	            );
    	            categories.add(category);
    	        }
    	    }
    	} catch (SQLException | ClassNotFoundException ex) {
    	    ex.printStackTrace();
    	}
    	return categories;

    }
    
    
    public String getCategoryNameById(String categoryId) {
        String categoryName = "";
        try (Connection con = dbController.getConnection()) {
            String sql = "SELECT categoryName FROM tbl_category WHERE id = ?";
            try (PreparedStatement st = con.prepareStatement(sql)) {
                st.setString(1, categoryId);
                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        categoryName = rs.getString("categoryName");
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return categoryName;
    }
    
    
    public CategoryModel getCategoryById(int categoryId) {
    	CategoryModel category = null;
        try (Connection con = dbController.getConnection()) {
            if (con != null && !con.isClosed()) {
                String query = "SELECT * FROM tbl_category WHERE id = ?";
                try (PreparedStatement statement = con.prepareStatement(query)) {
                    statement.setInt(1, categoryId);
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {

                        	category = new CategoryModel(
                            		resultSet.getInt("id"),
                            		resultSet.getString("categoryName"),
                            		resultSet.getString("categorySlug"),
                            		resultSet.getBoolean("status")
                            );
                        }
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // Handle database connection or query execution errors
        }
        return category;
    }
    
    
    public void updateCategory(int categoryId, String categoryName, String categorySlug, boolean status) {
        try (Connection con = dbController.getConnection()) {
            if (con != null && !con.isClosed()) {
                String query = "UPDATE tbl_category SET categoryName = ?, categorySlug = ?, status = ? WHERE id = ?";
                try (PreparedStatement statement = con.prepareStatement(query)) {
                    statement.setString(1, categoryName);
                    statement.setString(2, categorySlug);
                    statement.setBoolean(3, status);
                    statement.setInt(4, categoryId);
                    statement.executeUpdate();
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // Handle database connection or query execution errors
        }
    }

    

}