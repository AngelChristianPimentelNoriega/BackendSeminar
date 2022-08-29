package Practica01.app;

class Category {

    private int categoryID;
    private String category;

    public Category(int categoryID, String category) {
        this.categoryID = categoryID;
        this.category = category;
    }

    public int getCategoryID() {
        return categoryID;
    }
    
    public String getCategory() {
        return category;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

}
