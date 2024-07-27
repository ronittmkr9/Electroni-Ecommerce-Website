package controller.servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;

@WebServlet(asyncSupported = true, urlPatterns = { "/checkout" })


public class CheckoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("user_id");
        System.out.println(userId);

        // Update the cart status to 'C' (checked out) in the database for the user
        DatabaseController dbController = new DatabaseController();
        try (Connection con = dbController.getConnection();
             PreparedStatement stmt = con.prepareStatement("UPDATE tbl_cart SET cart_status = 'D' WHERE fk_user_id = ?")) {
            stmt.setInt(1, userId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {

                response.sendRedirect(request.getContextPath() + "/frontend/cart.jsp");
            } else {

                response.sendRedirect(request.getContextPath() + "/checkout-failure.jsp");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

            response.sendRedirect(request.getContextPath() + "/frontend/cart.jsp");
        }
    }
}
