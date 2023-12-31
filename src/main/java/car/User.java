package car;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static car.Dates.*;
import static org.example.Main.*;
import static car.Customer.customers;
public class User {
    public static boolean isListAcc() {
        return listAcc;
    }

    public static void setListAcc(boolean listAcc) {
        User.listAcc = listAcc;
    }

    private static boolean listAcc;
    private static boolean isSignedup;
    public static boolean isIssignedup() {
        return isSignedup;
    }
    public static void setIssignedup(boolean issignedup) {
        User.isSignedup = issignedup;
    }
    private static boolean adminIslogged;
    private static boolean installerIslogged;
    private static boolean customerIslogged;
    public static final String INSTALLERUT="installer";
    public static final String ADMINUT="installer";
    public static final String CUSTOMERUT="installer";
    public static boolean isAdminislogged() {
        return adminIslogged;
    }
    public static void setAdminislogged(boolean adminislogged) {
        adminIslogged = adminislogged;
    }
    public static boolean isInstallerislogged() {
        return installerIslogged;
    }
    public static void setInstallerislogged(boolean installerislogged) {
        installerIslogged = installerislogged;
    }
    public static boolean isCustomerislogged() {
        return customerIslogged;
    }
    public static void setCustomerislogged(boolean customerislogged) {
        customerIslogged = customerislogged;
    }
    private String username;
    private  String email;
    private  String password;
    private  String userType;
    private static String customerOrder;
    public static void setCustomerOrder(String customerOrder) {
        User.customerOrder = customerOrder;
    }
    private static Logger logger = Logger.getLogger(User.class.getName());
    public static String getLoggedIngetEmail() {
        return loggedIngetEmail;
    }
    private static String loggedIngetEmail;
    public static String getLoggedIngetName() {
        return loggedIngetName;
    }
    private static String loggedIngetName;
    public static String getLoggedIngetEmailCustomer() {
        return loggedIngetEmailCustomer;
    }
    private static String loggedIngetEmailCustomer;
    public User(String username, String email, String password, String userType) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }
    protected static ArrayList<User> userDatabasee = new ArrayList<>();
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getUserType() {
        return userType;
    }
    public static void listUserAccounts() {
        logger.info("User Accounts:");
        for (User user : userDatabase) {
            logger.info("Username: " + user.getUsername() + ", Email: " + user.getEmail() + ", User Type: " + user.getUserType());
        }
        for (Installer installer : installersDatabase) {
            logger.info("Username: " + installer.getUsername() + ", Email: " + installer.getEmail() + ", User Type: " + installer.getUserType());
        }
    }//dd
    public static boolean registerTest(String username,String email,String password,String userType){
        User us = new User(username, email, password, userType);
        for (User user : userDatabase) {
            if (email.equals(user.getEmail())) {
                logger.info(" SORRY! user already exist");
                return false ;}
        }
        logger.info("Registration DONE!");
        userDatabase.add(us);
        return true;
    }
    public static void adminsignin(User user){
        logger.info("DONE!.\n User type: " + user.getUserType());
        setAdminislogged(true);
    }
    public static void customersignin(User user){
        Customer customer = new Customer(user.getUsername(), user.getEmail(), user.getPassword(), user.getUserType());
        customers.add(customer);
        loggedIngetEmailCustomer = user.getEmail();
        customerOrder = user.getEmail();
        setCustomerOrder(user.getEmail());
        logger.info("DONE!.\n User type: " + user.getUserType());
        setCustomerislogged(true);
    }
    public static void installersignin(String email ,String password){
        for (Installer installer : installersDatabase) {
            if (installer.getEmail().equals(email) && installer.getPassword().equals(password) && installer.getUserType().equalsIgnoreCase(INSTALLERUT)) {
                loggedIngetEmail = installer.getEmail();
                loggedIngetName = installer.getUsername();
                setInstallerislogged(true);
            }
        }
        logger.info("DONE!.\n User type: installer");
    }
    public static List<User> getlist(){
        User customerUser= new User(CUSTOMERUT, "yara@najah", "555", CUSTOMERUT);
        userDatabasee.add(customerUser);
        User adminUser= new User(ADMINUT, "sara@najah", "555", ADMINUT);
        userDatabasee.add(adminUser);
        User installerUser= new User(INSTALLERUT, "tala@najah", "555", INSTALLERUT);
        userDatabasee.add(installerUser);
        return userDatabasee;
    }
    public static boolean loginadmin(String email, String password,List<User> userList){
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password) && user.getUserType().equalsIgnoreCase("admin")) {
                adminsignin(user);
                return true;
            }
        }
        return false;
    }
    public static boolean logincustomer(String email, String password,List<User> userList){
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password) && user.getUserType().equalsIgnoreCase("customer")) {
                customersignin(user);
                return true;
            }
        }
        return false;
    }
    public static boolean logininstaller(String email, String password,List<User> userList){
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password) && user.getUserType().equalsIgnoreCase(INSTALLERUT)) {
                customersignin(user);
                return true;
            }
        }
        return false;
    }
}
