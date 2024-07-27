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

@WebServlet(asyncSupported = true, urlPatterns = { "/deletecategory" })
public class DeleteCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteCategoryServlet() {
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
            int categoryId = Integer.parseInt(request.getParameter("categoryId"));
           
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
}
