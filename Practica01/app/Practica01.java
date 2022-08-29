package Practica01.app;
import Practica01.app.Category;

import java.util.ArrayList;

public class Practica01 {
    
    ArrayList<Category> categoryList;

    public Practica01() {
        categoryList = new ArrayList<Category>();
    }

    public static void main(String[] args) {
        Practica01 practica01 = new Practica01();
        practica01.getCategories();
        practica01.createCategory(new Category(1, "Categoria 1"));
        practica01.createCategory(new Category(2, "Categoria 2"));
        practica01.createCategory(new Category(3, "Categoria 3"));
        practica01.createCategory(new Category(4, "Categoria 4"));
        practica01.createCategory(new Category(5, "Categoria 5"));
        practica01.createCategory(new Category(6, "Categoria 6"));
        practica01.getCategories();
        practica01.getCategory(1);
        practica01.deleteCategory(1);
        practica01.getCategory(1);
        practica01.getCategories();
    }

    private boolean alreadyExists(int categoryID) {
        for (Category category : categoryList) {
            if (category.getCategoryID() == categoryID) {
                return true;
            }
        }
        return false;
    }

    public void createCategory(Category category) {
        if (!alreadyExists(category.getCategoryID())) {
            categoryList.add(category);
        }else{
            System.out.println("Ya existe una categoria con ese ID");
        }
    }

    public void getCategories(){
        if (categoryList.size() == 0) {
            System.out.println("No existen categorias registradas");
        }
        for (Category category : categoryList) {
            System.out.println(category.getCategoryID() + " " + category.getCategory());
        }
    }

    public void getCategory(int categoryID) {
        boolean categoryFound = false;
        for (Category category : categoryList) {
            if (category.getCategoryID() == categoryID) {
                System.out.println(category.getCategoryID() + " " + category.getCategory());
                categoryFound = true;
            }
        }
        if (!categoryFound) {
            System.out.println("No existe una categoria con el ID ingresado");
        }

    }

    public void deleteCategory(int categoryID) {
        ArrayList<Category> newCategoryList = new ArrayList<Category>();
        for (Category category : categoryList) {
            if (category.getCategoryID() != categoryID) {
                newCategoryList.add(category);
            }
        this.categoryList = newCategoryList;

        }
    }

}

