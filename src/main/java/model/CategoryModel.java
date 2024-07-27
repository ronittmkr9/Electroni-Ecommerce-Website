package model;


public class CategoryModel{
	
    private int id;
    
	private String categoryName;
	
	private String categorySlug;
	
	private Boolean status;
	
	
	public CategoryModel(int id, String categoryName, String categorySlug, Boolean status) {
		
	     this.id = id;
		
		this.categoryName = categoryName;
		
		this.categorySlug = categorySlug;
		
		this.status = status;
	}
	
	 public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	public String getCategoryName() {
        return categoryName;
    }

    // Setter method for categoryName
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    // Getter method for categorySlug
    public String getCategorySlug() {
        return categorySlug;
    }

    // Setter method for categorySlug
    public void setCategorySlug(String categorySlug) {
        this.categorySlug = categorySlug;
    }

    // Getter method for status
    public Boolean getStatus() {
        return status;
    }

    // Setter method for status
    public void setStatus(Boolean status) {
        this.status = status;
    }
}