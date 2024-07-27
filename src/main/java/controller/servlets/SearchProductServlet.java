package controller.servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ProductModel;


@WebServlet("/search")
public class SearchProductServlet extends HttpServlet {
    DatabaseController dbController = new DatabaseController();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the search term from request parameter
        String searchTerm = request.getParameter("query");

        // Call searchProducts method to search for products
        List<ProductModel> products = searchProducts(searchTerm);

        // Forward the search results to a JSP page for rendering
        request.setAttribute("products", products);
        request.getRequestDispatcher("/frontend/search_results.jsp").forward(request, response);
    }

    private List<ProductModel> searchProducts(String searchTerm) {
        List<ProductModel> products = new ArrayList<>();

        try (Connection con = dbController.getConnection()) {
            if (con != null && !con.isClosed()) {
                // Connection is established and not closed
                String sql = "SELECT * FROM tbl_product WHERE productName LIKE ?";
                try (PreparedStatement st = con.prepareStatement(sql)) {
                    st.setString(1, "%" + searchTerm + "%");

                    // Execute the query
                    try (ResultSet rs = st.executeQuery()) {
                        // Process the result set
                        while (rs.next()) {
                            ProductModel product = new ProductModel(
                                rs.getInt("id"),
                                rs.getString("fk_categoryID"),
                                rs.getString("productName"),
                                rs.getString("productSlug"),
                                rs.getString("productImage"),
                                rs.getString("productCostPrice"),
                                rs.getString("productRetailPrice"),
                                rs.getString("productQuantity"),
                                rs.getString("productDescription"),
                                rs.getBoolean("productStatus")
                            );

                            // Add product to the list
                            products.add(product);
                        }
                    }
                }
            } else {
                // Connection is not established or closed
                System.out.println("Connection is not established or closed.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return products;
    }
}

