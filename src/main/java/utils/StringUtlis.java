package utils;

public class StringUtlis{
	
//	public static final String INSERT_USERS = "INSERT INTO tbl_users" + "('fullName',user_name','dob','gender','user_email','user_password','user_address','user_contact','is_admin')" + "VALUES (?,?,?,?,?,?,?,?,?)";
	
	
//	public static final String INSERT_USERS = "INSERT INTO tbl_users (fullName,user_name,dob,gender,user_email,user_password,user_address,user_contact,is_admin) value (?,?,?,?,?,?,?,?,?)";

	
	public static final String INSERT_USERS = "INSERT INTO users (fullName,user_name,user_email,user_password, user_address, user_contact, is_admin) value (?,?,?,?,?,?,?)";
	 
	public static final String GET_USER_LOGIN_INFO = "SELECT * FROM users WHERE user_name = ? AND user_password = ?";
	
	public static final String GET_LOGGED_IN_USER = "SELECT * FROM users WHERE user_name = ?";

	
	public static final String GET_ALL_USER_INFO = "SELECT * FROM users WHERE user_name = ? AND user_password = ?";
	
	
	public static final String INSERT_CATEGORY = "INSERT INTO tbl_category (categoryName,categorySlug,status) value(?,?,?)";
	
	public static final String GET_CATEGORIES = "SELECT * FROM tbl_category";
	
	
	public static final String INSERT_PRODUCTS = "INSERT INTO tbl_product (fk_categoryID, productName, productSlug, productImage, productCostPrice, productRetailPrice, productQuantity, productDescription,productStatus) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String GET_PRODUCTS = "SELECT * FROM tbl_product";
	
	public static final String INSERT_CART = "INSERT INTO tbl_cart (fk_user_id, fk_product_id,unit_price, quantity, productName, productImage,cart_status) VALUES (?,?,?,?,?,?,?)";
	
	
	public static final String UPDATE_USERS = "UPDATE users SET  ( fullName,user_name,user_email,user_password, user_address, user_contact, is_admin) value (?,?,?,?,?,?,?) where id = ? ";
	
	
	public static final String SUCCESS_MESSAGE = "successMessage";
	
	public static final String ERROR_MESSAGE = "errorMessage";
	
	public static final String SUCCESS_REGISTER_MESSAGE = "Successfully Registered";
	
	public static final String REGISTER_ERROR_MESSAGE = "Registering User Failed";
	
	public static final String REGISTER_SERVLET = "/RegisterServlet";
	
	public static final String REGISTER_PAGE = "/auth/register.jsp";
	
	public static final String LOGIN_PAGE = "/auth/login.jsp";
	
	public static final String LOGIN_ERROR_MESSAGE = "Please enter valid credentials";
	
	public static final String USER_DOESNOT_EXISTS = "User doesnot exists in the system";
	
	
	
	//setting up validation for username or user email exists or not....
	
	public static final String USER_EXISTS_MESSAGE = "Entered user name already exists";
	
	public static final String USER_EMAIL_EXISTS_MESSAGE = "Entered user email already exists";
	
	
    public static final String USERNAME = "username";
    public static final String USER = "user";
    public static final String JSESSIONID = "JSESSIONID";
    
    
    
    //product message
	public static final String PRODUCT_SUCCESS_MESSAGE = "Product was added succesfully";
	
	
	public static final String PRODUCT_ERROR_MESSAGE = "Unable to add products";
	
	
	public static final String USER_DELETE_SUCCESS_MESSAGE = "User was deleted succesfully";
	
	
	
	
}