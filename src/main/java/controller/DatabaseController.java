package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CategoryModel;
import model.UsersModel;
import utils.StringUtlis;

public class DatabaseController {
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/eag_database";
        String user = "root";
        String pass = "";
        return DriverManager.getConnection(url, user, pass);
    }
    
    public int addUser(UsersModel userModel) {
        if (isValidUserModel(userModel)) {
            if (isUserNameExists(userModel.getUsername()) || isUserEmailExists(userModel.getUserEmail())) {
                return -3;
            }
            try (Connection con = getConnection()) {
                if (con != null && !con.isClosed()) {
                    PreparedStatement st = con.prepareStatement(StringUtlis.INSERT_USERS);
                    st.setString(1, userModel.getFullName());
                    st.setString(2, userModel.getUsername());
                    st.setString(3, userModel.getUserEmail());
                    st.setString(4, userModel.getUserPassword());
                    st.setString(5, userModel.getUserAddress());
                    st.setString(6, userModel.getUserContact());
                    st.setBoolean(7, userModel.isAdmin());
                    int result = st.executeUpdate();
                    if (result > 0) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    return -1; 
                }
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
                return -1;
            }
        } else {
            return -2; 
        }
    }

    private boolean isUserNameExists(String username) {
        return false; 
    }

    private boolean isUserEmailExists(String userEmail) {
        return false; 
    }

    private boolean isValidUserModel(UsersModel userModel) {
        if (userModel.getFullName() == null || userModel.getFullName().isEmpty()) {
            return false;
        }
        return true;
    }

    public int getUserLoginInfo(String user_name, String user_password) {
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(StringUtlis.GET_USER_LOGIN_INFO)) {
            st.setString(1, user_name);
            st.setString(2, user_password);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    int isAdmin = rs.getInt("is_admin"); // Get the value of the is_admin column
                    int userId = rs.getInt("id");
                    return isAdmin == 1 ? 999 : userId; // If admin, return 999, else return userId
                } else {
                    return 0; // User not found
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return -1; // Error occurred
        }
    }


    public int getLoggedInUserDetails(String user_name, String user_password) {
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(StringUtlis.GET_USER_LOGIN_INFO)) {
            st.setString(1, user_name);
            st.setString(2, user_password);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return 1; 
                } else {
                    return 0; 
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return -1; 
        }
    }
    
    public int addCategory(CategoryModel categoryModel) {
        try(Connection con = getConnection()) {
            if (con != null && !con.isClosed()) {
                PreparedStatement st = con.prepareStatement(StringUtlis.INSERT_CATEGORY);
                st.setString(1, categoryModel.getCategoryName());
                st.setString(2, categoryModel.getCategorySlug());
                st.setBoolean(3, categoryModel.getStatus());
                int result = st.executeUpdate();
                return result > 0 ? 1 : 0;
            } else {
                return -1; 
            }
        } catch(SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    public List<CategoryModel> getCategories() {
        List<CategoryModel> categories = new ArrayList<>();
        try (Connection con = getConnection()) {
            if (con != null && !con.isClosed()) { 
                PreparedStatement st = con.prepareStatement(StringUtlis.GET_CATEGORIES);
                ResultSet rs = st.executeQuery();
                while(rs.next()) {
                    CategoryModel row = new CategoryModel(
                            rs.getInt("id"),
                            rs.getString("categoryName"),
                            rs.getString("categorySlug"),
                            rs.getBoolean("status")
                    );
                    categories.add(row);
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return categories;
    }
    
    public static final String UPDATE_USERS = "UPDATE users SET  (fullName,user_name,user_email,user_password, user_address, user_contact, is_admin) value (?,?,?,?,?,?,?) where id = ? ";
    
    public int updateUser(UsersModel userModel ) {
        try(Connection con = getConnection()) {
            if (con != null && !con.isClosed()) {
                PreparedStatement st = con.prepareStatement(StringUtlis.UPDATE_USERS);
                st.setInt(1, userModel.getId());
                st.setString(2, userModel.getFullName());
                st.setString(3, userModel.getUsername());
                st.setString(4, userModel.getUserEmail());
                st.setString(5, userModel.getUserPassword());
                st.setString(6, userModel.getUserAddress());
                st.setString(7, userModel.getUserContact());
                st.setBoolean(8, userModel.isAdmin());
                int result = st.executeUpdate();
                return result > 0 ? 1 : 0;
            } else {
                return -1; 
            }
        } catch(SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
}
