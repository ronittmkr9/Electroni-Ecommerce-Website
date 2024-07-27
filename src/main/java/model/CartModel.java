package model;

public class CartModel {

	private int id;
    private String fk_user_id;
    private String fk_product_id;
    private String unit_price;
    private String quantity;
    private String productName;
    private String productImage;
    private String 	cart_status;
    

    public CartModel(int id, String fk_user_id, String fk_product_id, String quantity, String unit_price, String productName, String productImage, String cart_status) {
    	this.id = id;
        this.fk_user_id = fk_user_id;
        this.fk_product_id = fk_product_id;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.productName = productName;
        this.productImage = productImage;
        this.cart_status = cart_status;
    }

    
	  public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }
	    
    public String getFk_user_id() {
        return fk_user_id;
    }

    public void setFk_user_id(String fk_user_id) {
        this.fk_user_id = fk_user_id;
    }

    public String getFk_product_id() {
        return fk_product_id;
    }

    public void setFk_product_id(String fk_product_id) {
        this.fk_product_id = fk_product_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }
    
    public String getproductName() {
        return productName;
    }

    public void setproductName(String productName) {
        this.productName = productName;
    }

    public String getproductImage() {
        return productImage;
    }

    public void setproductImage(String productImage) {
        this.productImage = productImage;
    }
    
    
    public String getCartStatus() {
        return cart_status;
    }

    public void setCartStatus(String cart_status) {
        this.cart_status = cart_status;
    }
}
