package Practica01.app;


public class Practica01 {

    public static void main(String[] args) {
        Categories categories = new Categories();
        categories.getCategories();
        categories.createCategory(1, "Categoria 1");
        categories.createCategory(2, "Categoria 2");
        categories.createCategory(3, "Categoria 3");
        categories.createCategory(4, "Categoria 4");
        categories.createCategory(5, "Categoria 5");
        categories.createCategory(6, "Categoria 6");
        categories.getCategories();
        categories.getCategory(1);
        categories.deleteCategory(1);
        categories.getCategory(1);
        categories.getCategories();
    }

    

    
    

   

   

}

