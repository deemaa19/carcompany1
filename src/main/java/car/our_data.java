package car;


import java.util.ArrayList;
import java.util.*;


//import project2021.Book;

public class our_data {
    public static List<userr> userList = new ArrayList<userr>();
    public static List<product> productList = new ArrayList<product>();


    public  List<userr> getUserList() {
        return userList;
    }

    public void setUserList (ArrayList<userr> userList) {
        our_data.userList= userList ;
    }

    public  List<product> getProductList() {
        return productList;
    }

    public void setProductList (ArrayList<product> productList) {our_data.productList= productList ;
    }

    public static List<userr> listUsers(){
        userList.add(new userr ("sara","sara@gmail.com", "111","ADMIN"));
        userList.add(new userr ("yara","yara@gmail.com", "000","CUSTOMER"));
        userList.add(new userr ("tala","tala@gmail.com", "222","INSTALLER"));
        return userList;

    }

    public static List<product> listproducts(){
        productList.add(new product (1,"vehicle engine","strong vehicle engine", "interior","1000","",""));
        productList.add(new product (2,"vehicl door","strong vehice door", "exterior","100","",""));
        productList.add(new product (3, "car radio","strong car radio", "Electronics","150","",""));
        return productList;

    }



}
