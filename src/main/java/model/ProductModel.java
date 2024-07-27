package model;

public class ProductModel {
	
	private int id;

	private String fk_categoryID;
	
	private String productName;
	
	private String productSlug;
	
	private String productImage;
	
	private String productCostPrice;
	
	private String productRetailPrice;
	
	private String productQuantity;
	
	private String productDescription;
	
	private Boolean productStatus;
	
	  public ProductModel(int id, String fk_categoryID, String productName, String productSlug, String productImage, String productCostPrice, String productRetailPrice, String productQuantity, String productDescription, Boolean productStatus) {
	       this.id = id;
	       this.fk_categoryID = fk_categoryID;
	        this.productName = productName;
	        this.productSlug = productSlug;
	        this.productImage = productImage;
	        this.productCostPrice = productCostPrice;
	        this.productRetailPrice = productRetailPrice;
	        this.productQuantity = productQuantity;
	        this.productDescription = productDescription;
	        this.productStatus = productStatus;
	    }

	  
	  public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }


	    public String getFk_categoryID() {
	        return fk_categoryID;
	    }

	    public void setFk_categoryID(String fk_categoryID) {
	        this.fk_categoryID = fk_categoryID;
	    }

	    public String getProductName() {
	        return productName;
	    }

	    public void setProductName(String productName) {
	        this.productName = productName;
	    }

	    public String getProductSlug() {
	        return productSlug;
	    }

	    public void setProductSlug(String productSlug) {
	        this.productSlug = productSlug;
	    }

	    public String getProductImage() {
	        return productImage;
	    }

	    public void setProductImage(String productImage) {
	        this.productImage = productImage;
	    }

	    public String getProductCostPrice() {
	        return productCostPrice;
	    }

	    public void setProductCostPrice(String productCostPrice) {
	        this.productCostPrice = productCostPrice;
	    }

	    public String getProductRetailPrice() {
	        return productRetailPrice;
	    }

	    public void setProductRetailPrice(String productRetailPrice) {
	        this.productRetailPrice = productRetailPrice;
	    }

	    public String getProductQuantity() {
	        return productQuantity;
	    }

	    public void setProductQuantity(String productQuantity) {
	        this.productQuantity = productQuantity;
	    }

	    public String getProductDescription() {
	        return productDescription;
	    }

	    public void setProductDescription(String productDescription) {
	        this.productDescription = productDescription;
	    }
	    
	    public Boolean getproductStatus() {
	        return productStatus;
	    }

	    public void setproductStatus(Boolean productStatus) {
	        this.productStatus = productStatus;
	    }
	
	    @Override
	    public String toString() {
	        return "ProductModel{" +
	                "fk_categoryID='" + fk_categoryID + '\'' +
	                ", productName='" + productName + '\'' +
	                ", productSlug='" + productSlug + '\'' +
	                ", productImage='" + productImage + '\'' +
	                ", productCostPrice='" + productCostPrice + '\'' +
	                ", productRetailPrice='" + productRetailPrice + '\'' +
	                ", productQuantity='" + productQuantity + '\'' +
	                ", productDescription='" + productDescription + '\'' +
	                ", productStatus=" + productStatus +
	                '}';
	    }

	    
	
	
}
