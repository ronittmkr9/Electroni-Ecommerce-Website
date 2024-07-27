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

import controller.DatabaseController;

import utils.StringUtlis;
@WebServlet(asyncSupported = true, urlPatterns = { "/deleteuser" })
public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteUserServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    DatabaseController dbController = new DatabaseController();

    
   
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("delete")) {
            int userId = Integer.parseInt(request.getParameter("userId"));

            boolean deleted = deleteUser(userId);
            if (deleted) {
                // Set success message as request attribute
                request.setAttribute("successMessage", StringUtlis.USER_DELETE_SUCCESS_MESSAGE);
            } else {
                // Handle deletion failure
                request.setAttribute("errorMessage", "Failed to delete user");
            }
        } else {
            // Handle other actions or requests if needed
        }
    }


    public boolean deleteUser(int userId) {
        try (Connection con = dbController.getConnection();
                PreparedStatement stmt = con.prepareStatement("DELETE FROM users WHERE id = ?")) {
            stmt.setInt(1, userId);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
