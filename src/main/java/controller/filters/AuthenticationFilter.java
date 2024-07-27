//package controller.filters;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = {"/admin/*", "/product/*", "/category/*"})
//public class AuthenticationFilter implements Filter {
//    public void init(FilterConfig config) throws ServletException {
//        // Initialization code if needed
//    }
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        HttpSession session = httpRequest.getSession(false);
//   
//        if (session != null && session.getAttribute("user") != null) {
//           
//        } else {
//            // User is not logged in, redirect to the login page
//            httpResponse.sendRedirect("../login");
//        }
//    }
//
////    private boolean isAuthorized(String requestURI, UsersModel user) {
////        // Example: Check if the user is an admin or has specific permissions for the requested resource
////        if (user.getIsAdmin() == 1) {
////            // Admin has access to all resources
////            return true;
////        } else {
////            // Non-admin users have limited access
////            if (requestURI.startsWith("/admin/")) {
////                // Non-admin users should not access admin-related resources
////                return false;
////            } else if (requestURI.startsWith("/product/") && user.hasProductPermissions()) {
////                // Example: Non-admin user has permission to access product-related resources
////                return true;
////            } else if (requestURI.startsWith("/category/") && user.hasCategoryPermissions()) {
////                // Example: Non-admin user has permission to access category-related resources
////                return true;
////            } else {
////                // Non-admin user does not have access to the requested resource
////                return false;
////            }
////        }
////    }
//
//    public void destroy() {
//        // Cleanup code if needed
//    }
//}
