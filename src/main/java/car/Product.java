package car;

import java.util.List;
import java.util.logging.Logger;
import static car.Dates.*;
import static org.example.Main.*;


public class Product {
    private static boolean addProduct;

    private static boolean deleteProduct;
    private static boolean listProduct;
    public static boolean isAddProduct() {
        return addProduct;
    }
    public static void setAddProduct(boolean addProduct) {
        Product.addProduct = addProduct;
    }
    public static boolean isDeleteProduct() {
        return deleteProduct;
    }
    public static void setDeleteProduct(boolean deleteProduct) {
        Product.deleteProduct = deleteProduct;
    }
    public static boolean isListProduct() {
        return listProduct;
    }
    public static void setListProduct(boolean listProduct) {
        Product.listProduct = listProduct;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' ;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAvailablity(int availablity) {
        this.availablity = availablity;
    }

    private String name;
    private double price;
    private String category;
    private int availablity;
    private static final Logger logger = Logger.getLogger(Product.class.getName());
    public Product(String name, double price,String category,int availablity ) {
        this.name = name;
        this.price = price;
        this.category=category;
        this.availablity=availablity;
    }

    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public void setAvailablity() {
        availablity = availablity-1;
    }
    public double getPrice() {
        return price;
    }
    public int getAvailablity() {
        return availablity;
    }
    public static boolean productaddTest(String name,double price,String category,int amount){
        for (Product product : products) {
            if (product.getName().equals(name)) {

                logger.info("Product located..");
                return false;
            }
        }
        products.add(new Product(name, price, category,amount));
        logger.info("Product added .");
        return true;
    }//dd
    public static boolean productdeleteTest(String name){
        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.remove(product);
                logger.info("Product deleted .");
                return true;
            }
        }
        logger.info("Product not found.");
        return false;
    }

}
