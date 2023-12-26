package car;


import java.util.logging.Logger;
import static org.example.Main.categories;
import static org.example.Main.products;

public class Category {
    private static boolean addCattego;
    private static boolean deleteCat;
    private static boolean listcat;

    public static boolean isSearchproduct() {
        return searchproduct;
    }

    private static boolean searchproduct;

    public static void setSearchproduct(boolean searchproduct) {
        Category.searchproduct = searchproduct;
    }
    public static boolean isListcat() {
        return listcat;
    }

    public static void setListcat(boolean listcat) {
        Category.listcat = listcat;
    }
    public static void setAddcat(boolean addcat) {
        Category.addCattego = addcat;
    }

    public static boolean isAddcat() {
        return addCattego;
    }
    public static boolean isDeletecat() {
        return deleteCat;
    }

    public static void setDeletecat(boolean deletecat) {
        Category.deleteCat = deletecat;
    }


    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private static Logger logger = Logger.getLogger(Category.class.getName());

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }






    public static boolean addcatTest(String name){
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                logger.info("Category exist");
                return false;
            }
        }
        categories.add(new Category(name));
        addnoti();
        return true;
    }

    public static boolean deletecatTest(String name){
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                categories.remove(category);
                deletenoti();
                return true;
            }
        }
        logger.info(" not found This Category.");
        return false;
    }

    public static void deletenoti(){ logger.info("\n" +
            "Category successfully removed...");
    }
    public static void addnoti(){
        logger.info("Category successfully added..!");
    }






    public static void listCategoriesTest(){
        for (Category category : categories) {

            logger.info( category.getName()  );
        }
    }



}
