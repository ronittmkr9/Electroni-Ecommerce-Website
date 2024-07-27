package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import model.ProductModel;
import utils.StringUtlis;



public class ProductController{
	
	DatabaseController dbController = new DatabaseController();
	
    public static final String UPLOAD_DIRECTORY = "C:\\Users\\Sanish\\eclipse-workspace\\SFS_Enterprises\\src\\main\\webapp\\uploads\\";

	

	public int addProducts(ProductModel productModel) {		
		
		try(Connection con = dbController.getConnection()){
			
			  if (con != null && !con.isClosed()) { // Check if connection is established and not closed
		            PreparedStatement statement = con.prepareStatement(StringUtlis.INSERT_PRODUCTS);

		            statement.setString(1, productModel.getFk_categoryID());
		            statement.setString(2, productModel.getProductName());
		            statement.setString(3, productModel.getProductSlug());
		            statement.setString(4, productModel.getProductImage());
		            statement.setString(5, productModel.getProductCostPrice());
		            statement.setString(6, productModel.getProductRetailPrice());
		            statement.setString(7, productModel.getProductQuantity());
		            statement.setString(8, productModel.getProductDescription());
		            statement.setBoolean(9, productModel.getproductStatus());
		            
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
	

    public List<ProductModel> getAllProducts() {
        List<ProductModel> products = new ArrayList<>();

        try (Connection con = dbController.getConnection()) {
            if (con != null && !con.isClosed()) {
                String query = "SELECT * FROM tbl_product"; // Modify query as per your database schema

                try (PreparedStatement statement = con.prepareStatement(query);
                     ResultSet resultSet = statement.executeQuery()) {

                    while (resultSet.next()) {
                    	   int id = resultSet.getInt("id");
                        // Retrieve data from the result set and create ProductModel objects
                        ProductModel product = new ProductModel(
                        		id,
                                resultSet.getString("fk_categoryID"),
                                resultSet.getString("productName"),
                                resultSet.getString("productSlug"),
                                resultSet.getString("productImage"),
                                resultSet.getString("productCostPrice"),
                                resultSet.getString("productRetailPrice"),
                                resultSet.getString("productQuantity"),
                                resultSet.getString("productDescription"),
                                resultSet.getBoolean("productStatus")
                        );
                        products.add(product);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // Handle database connection or query execution errors
        }

        return products;
    }
    
    
    public ProductModel getProductBySlug(String productSlug) {
        ProductModel product = null;
        try (Connection con = dbController.getConnection()) {
            if (con != null && !con.isClosed()) {
                String query = "SELECT * FROM tbl_product WHERE productSlug = ?";
                try (PreparedStatement statement = con.prepareStatement(query)) {
                    statement.setString(1, productSlug);
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {

                            product = new ProductModel(
                            	resultSet.getInt("id"),
                                resultSet.getString("fk_categoryID"),
                                resultSet.getString("productName"),
                                resultSet.getString("productSlug"),
                                resultSet.getString("productImage"),
                                resultSet.getString("productCostPrice"),
                                resultSet.getString("productRetailPrice"),
                                resultSet.getString("productQuantity"),
                                resultSet.getString("productDescription"),
                                resultSet.getBoolean("productStatus")
                            );
                        }
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // Handle database connection or query execution errors
        }
        return product;
    }
    
    
    public ProductModel getProductDetails(String productId) {
        ProductModel product = null;
        try (Connection con = dbController.getConnection()) {
            if (con != null && !con.isClosed()) {
                String query = "SELECT * FROM tbl_product WHERE productId = ?";
                try (PreparedStatement statement = con.prepareStatement(query)) {
                    statement.setString(1, productId);
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                        	   int id = resultSet.getInt("id");
                            product = new ProductModel(
                               id,
                                resultSet.getString("fk_categoryID"),
                                resultSet.getString("productName"),
                                resultSet.getString("productSlug"),
                                resultSet.getString("productImage"),
                                resultSet.getString("productCostPrice"),
                                resultSet.getString("productRetailPrice"),
                                resultSet.getString("productQuantity"),
                                resultSet.getString("productDescription"),
                                resultSet.getBoolean("productStatus")
                            );
                        }
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return product;
    }
    
    
    public boolean updateProduct(ProductModel product) {
        try (Connection con = dbController.getConnection()) {
            if (con != null && !con.isClosed()) {
                String query = "UPDATE tbl_product SET fk_categoryID = ?,productName = ?, productSlug = ?, productImage = ?, productCostPrice = ?, productRetailPrice = ?, productQuantity = ?, productDescription = ?, productStatus = ? WHERE id = ?";
                try (PreparedStatement statement = con.prepareStatement(query)) {
                	 statement.setInt(1, product.getId());
                	 statement.setString(2, product.getFk_categoryID());
                    statement.setString(3, product.getProductName());
                    statement.setString(4, product.getProductSlug());
                    statement.setString(5, product.getProductImage());
                    statement.setString(6, product.getProductCostPrice());
                    statement.setString(7, product.getProductRetailPrice());
                    statement.setString(8, product.getProductQuantity());
                    statement.setString(9, product.getProductDescription());
                    statement.setBoolean(10, product.getproductStatus());
                   
                    int rowsUpdated = statement.executeUpdate();
                    return rowsUpdated > 0;
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // Handle database connection or query execution errors
        }
        return false;
    }

    
    public void updateProduct(int productId, int categoryId, String productName, String productSlug, String fileName, double productCostPrice, double productRetailPrice, int productQuantity, String productDescription, boolean productStatus) {
        try (Connection con = dbController.getConnection()) {
            if (con != null && !con.isClosed()) {
                String query = "UPDATE tbl_product SET fk_categoryID = ?, productName = ?, productSlug = ?, productImage = ?, productCostPrice = ?, productRetailPrice = ?, productQuantity = ?, productDescription = ?, productStatus = ? WHERE id = ?";
                try (PreparedStatement statement = con.prepareStatement(query)) {
                    statement.setInt(1, categoryId);
                    statement.setString(2, productName);
                    statement.setString(3, productSlug);
                    statement.setString(4, fileName);
                    statement.setDouble(5, productCostPrice);
                    statement.setDouble(6, productRetailPrice);
                    statement.setInt(7, productQuantity);
                    statement.setString(8, productDescription);
                    statement.setBoolean(9, productStatus);
                    statement.setInt(10, productId);
                    statement.executeUpdate();
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // Handle database connection or query execution errors
        }
    }


    
    

}