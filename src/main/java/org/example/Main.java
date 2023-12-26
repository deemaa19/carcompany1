package org.example;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;


import car.*;
import static car.Appointment.*;
import static car.Category.*;
import static car.Customer.*;
import static car.Installer.*;
import static car.Order.*;
import static car.Product.*;
import static car.User.*;


public class Main {
    public static final ArrayList<User> userDatabase = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static final List<Category> categories = new ArrayList<>();

    public static List<Installer> getInstallersDatabase() {
        return installersDatabase;
    }

    public static List<Product> getproductList(){
        return products;
    }
    public static List<Installer> installersDatabase = new ArrayList<>();

    public static List<Dates> availableDates = new ArrayList<>();

    public static Dates availabledate1;
    public static Dates availabledate2;
    public static Dates availabledate3;
    public static Dates availabledate4;
    public static int orderIdCounter = 1;
    public static int appointmentIdCounter = 1;
    public static User adminUser;
    public static User customerUser;
    public static User customerUser2;
    public static Installer installerUser;
    public static Installer installerUser2;
    public static Product product;
    public static Category categoryy;
    public static String totalPrice;

    private static Logger logger = Logger.getLogger(Main.class.getName());
    private static final String INVALIDATION="Sorry..Invalid choice.\n Please try again.";

    public static ArrayList<User> getUserDatabase() {
        return userDatabase;
    }
    public static void main(String[] args) {
        adminUser = new User("admin", "sara@najah", "555", "admin");
        userDatabase.add(adminUser);

        String customerValue="customer";
        String installerValue="installer";


        customerUser = new User("customer1", "yara@najah", "555",customerValue);
        userDatabase.add(customerUser);

        customerUser2 = new User("customer2", "israa@najah", "555",customerValue);
        userDatabase.add(customerUser2);

        installerUser = new Installer(1, "installer1", "tala@najah","555",installerValue,"12/7/2023");
        installersDatabase.add(installerUser);

        installerUser2 = new Installer(2, "installer2", "rama@najah","555",installerValue,"2/2/2024");
        installersDatabase.add(installerUser2);

        categoryy=new Category("Interior");
        categories.add(categoryy);
        categoryy=new Category("Exterior");
        categories.add(categoryy);
        categoryy=new Category("Lighs");
        categories.add(categoryy);
        categoryy=new Category("Seats");
        categories.add(categoryy);
        product=new Product("light",20,"lights",20);
        products.add(product);
        product=new Product("Seat",20,"Seats",30);
        products.add(product);
        product=new Product("interior",20,"Interior",40);
        products.add(product);
        product=new Product("exterior",20,"Exterior",50);
        products.add(product);

        availabledate1=new Dates("1/1/2023","installerdeema");
        availabledate2=new Dates("11/11/2023","installerdeema");
        availabledate3=new Dates("5/5/2023","installerrdeema2");
        availabledate4=new Dates("7/72023","installerdeema2");
        availableDates.add(availabledate1);
        availableDates.add(availabledate2);
        availableDates.add(availabledate3);
        availableDates.add(availabledate4);



        Scanner scanner = new Scanner(System.in);

////////////////////////////////LOGIN AND REGISTER//////////////////////////////////////
        logger.info("Hello! Welcome to our Car Company..\n Please select a number:\n 1.Sign_Up 2.Log_In  3.Log_out \n ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                registerUser();
                break;
            case 2:
                loginUser();
                break;
            case 3:
                logger.info("log_out from the system" );
                System.exit(0);
                break;
            default:
                logger.info(INVALIDATION);
        }
    }
    public static void registerUser() {
        setIssignedup(false);
        Scanner scanner = new Scanner(System.in);

        logger.info("Enter your username: ");
        String username = scanner.nextLine();

        logger.info("Enter your email: ");
        String email = scanner.nextLine();

        logger.info("Enter your password: ");
        String password = scanner.nextLine();

        logger.info("Are you customer or installer? \n Choose user Type: ");
        String userType = scanner.nextLine();

        register(username,email,password,userType);
    }
    public static void loginUser() {
        setAdminislogged(false);
        setInstallerislogged(false);
        setCustomerislogged(false);

        Scanner scanner = new Scanner(System.in);

        logger.info("Enter your email: ");
        String email = scanner.nextLine();

        logger.info("Enter your password: ");
        String password = scanner.nextLine();
        signin(email,password);

    }

    ////////////////////////////////////////////////////////////////////
    public static boolean isAdminLoggedIn() {
        return adminUser != null && adminUser.getUserType().equals("admin");
    }
    public static boolean isCustomerLoggedIn() {
        return customerUser != null && customerUser.getUserType().equals("customer");
    }
    public static boolean isInstallerLoggedIn() {
        return installerUser != null && installerUser.getUserType().equals("installer");
    }

    private static boolean adminDash;
    ///////////////////////////////////ADMIN///////////////////////////////
    public static void adminDashboard() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            adminDash=true;
            if(isAdminLoggedIn()) {
                logger.info("\nAdmin Dashboard\n1. Manage Products 2. Manage Categories 3. Manage User Accounts 4. Manage Customers\n" +
                        "5. Manage Installers 6. Manage Appointments 7. Manage Orders 8. Logout \n Enter Number: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        manageProductsLists();
                        break;
                    case 2:
                        manageCategories();
                        break;
                    case 3:
                        manageUserAccounts();
                        break;
                    case 4:
                        manageCustomersList();
                        break;
                    case 5:
                        manageInstallers();
                        break;
                    case 6:
                        manageAppointments();
                        break;
                    case 7:
                        manageOrders();
                        break;
                    case 8:
                        logger.info("Logging out from the admin dashboard.");
                        loginUser();
                        return;
                    default:
                        logger.info(INVALIDATION);
                }
            }}
    }
    //////////////////////////MANAGE PRODUCTS///////////////////////
    public static int manageProductsLists(){
        Scanner scanner = new Scanner(System.in);
        logger.info("\nProduct Management\n1. Add Product 2. Delete Product" +
                "\n3. List Products 4. edit product \n 5. Back \n Enter Number: ");
        int choice = scanner.nextInt();
        manageProducts(choice);
        return choice;
    }
    public static int manageProducts(int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1:
                setAddProduct(true);
                addProduct();
                return 1;
            case 2:
                setDeleteProduct(true);
                deleteProduct();
                return 2;
            case 3:
                setListProduct(true);
                listProducts(products);
                return 3;
            case 4:
                logger.info("insert the name of the product that you want to edit it ..");
                String oldName=scanner.nextLine();
                productdeleteTest2(oldName);
                edit1();
            case 5:
                adminDashboard();
                return 4;
            default:
                logger.info("Sorry ! Invalid choice \n  Please try again.");
        }
        return 5;
    }

    public static boolean productdeleteTest2(String name){
        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.remove(product);

                return true;
            }
        }
        logger.info("Product not found.");
        return false;
    }
    public static void edit1(){
        Scanner scanner = new Scanner(System.in);
        logger.info("insert the new name");
        String newName=scanner.nextLine();
        logger.info("insert the new category");
        String newCat=scanner.nextLine();
        logger.info("insert the new price");
        int newPrice=scanner.nextInt();
        logger.info("insert the new availability");
        int newAva=scanner.nextInt();
        products.add(new Product(newName,newPrice,newCat,newAva));
    }
    public static List<Product> updateProduct(String oldProductName, String newProductName, String newProductCategorie,
                                              int newProductPrice, int newProductAvailability) {
        for (Product product : products) {
            if (product.getName() == oldProductName) {
                product.setName(newProductName);
                product.setCategory(newProductCategorie);
                product.setPrice(newProductPrice);
                product.setAvailablity(newProductAvailability);
            }
            return products;
        }
        logger.info("This product is not found !!");
        return null;
    }
    public static void addProduct() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter product name: ");
        String name = scanner.nextLine();
        logger.info("Enter product price: ");
        double price = scanner.nextDouble();
        logger.info("Enter category name: ");
        String category = scanner.nextLine();
        logger.info("Enter product Quantity: ");
        int ava = scanner.nextInt();
        productaddTest(name,price,category,ava);
    }
    public static void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter the product name to delete: ");
        String name = scanner.nextLine();
        productdeleteTest(name);
    }
    /////////////////////////////////////////////////////////////////
    ///////////////////////////MANAGE CATIGORIES/////////////////////
    public static void manageCategories() {
        Scanner scanner = new Scanner(System.in);
        logger.info("\nCategory Management\n1. Add Category 2. Delete Category" +
                "\n3. List Categories 4. Search Product 5.edit category name 6. Back \n Enter Number: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        manageCat(choice);
    }
    public static boolean editCat(String name){
        Scanner scanner = new Scanner(System.in);
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                logger.info("write the new name you want");
                String NName=scanner.nextLine();
                category.setName(NName);
                return true;
            }
        }
        logger.info(" not found This Category.");
        return false;
    }
    public static void manageCat(int choice){
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1:
                setAddcat(true);
                addCategory();
                break;
            case 2:
                setDeletecat(true);
                deleteCategory();
                break;
            case 3:
                setListcat(true);
                listCategories();
                break;
            case 4:
                setSearchproduct(true);
                searchProducts();
                break;
            case 5:
                logger.info("write the category you wnat to change ..");
                String nn=scanner.nextLine();
                editCat(nn);

            case 6:
                return;
            default:
                logger.info("Invalid choice. Please try again.");
        }
    }
    private static void addCategory() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter category name: ");
        String name = scanner.nextLine();
        addcatTEG(name);
        logger.info("Add products to this category (yes)? or leave it empty? (no)? ");
        String c = scanner.nextLine();
        switch (c) {
            case "yes":
                logger.info("Enter product name: ");
                String pname = scanner.nextLine();
                logger.info("Enter product price: ");
                double price = scanner.nextDouble();
                logger.info("Enter product availability: ");
                int ava = scanner.nextInt();
                products.add(new Product(pname, price, name,ava));
                logger.info("successfully!.");
                break;
            case "no":
                addnoti();
                break;
            default:
                logger.info("Wrong choice!");
        }
    }
    private static void deleteCategory() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter the category name to delete: ");
        String name = scanner.nextLine();
        deletecat(name);
    }
    public static void deletecat(String name){

        for (Category category : categories) {
            if (category.getName().equals(name)) {
                categories.remove(category);
                for (Product product : products) {
                    if (product.getCategory().equals(name)) {
                        products.remove(product);
                        return;
                    }
                    deletenoti();

                }
            }

        }

    }
    public static void listCategories() {
        logger.info("Categories:");
        for (Category category : categories) {

            logger.info( category.getName()  );
        }
        Scanner scanner = new Scanner(System.in);
        logger.info("Select Category to Show category products: ");
        String cat = scanner.nextLine();
        for(Product product:products) {
            if (product.getCategory().equalsIgnoreCase(cat)) {
                logger.info("Name: " + product.getName() + ", Price: " + product.getPrice());
            }
        }
    }
    public static void searchProducts(){
        Scanner scanner = new Scanner(System.in);
        logger.info("Search about product by name:");
        String pro = scanner.nextLine();
        productsearch(pro);
    }
    /////////////////////////////////////////////////////////////////////
    ///////////////////////////MANAGE USERS ACCOUNTS/////////////////////
    public static void manageUserAccounts() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            logger.info("User Account Management\n1. List User Accounts 2. Delete User Account 3. Back\nEnter Number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listUserAccounts();
                    break;
                case 2:
                    deleteUserAccount();
                    break;
                case 3:
                    return;
                default:
                    logger.info("Sorry ! Invalid choice. Please try again.");
            }
        }
    }
    private static void deleteUserAccount() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter the email of the user account to delete: ");
        String email = scanner.nextLine();

        for (User user : userDatabase) {
            if (user.getEmail().equals(email)) {
                userDatabase.remove(user);
                logger.info("User account deleted successfully.");
                return;
            }
        }

        logger.info("User account not found.");
    }
    /////////////////////////////////////////////////////////////////////
    ///////////////////////////MANAGE CUSTOMERS//////////////////////////
    public static int manageCustomersList(){
        Scanner scanner = new Scanner(System.in);
        logger.info("\nCustomer Management\n1. Sign_Up Customer 2. List Customers" +
                "\n3. Back\nEnter Number: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return manageCustomers(choice);
    }
    public static int manageCustomers(int choice){
        switch (choice) {
            case 1:
                setRegCustomer(true);
                registerCustomer();
                return 1;
            case 2:
                setListCustomer(true);
                listCustomers();
                return 2;
            case 3:
                return 3;
            default:
                logger.info("Invalid choice. Please try again.");
        }
        return 5;
    }
    public static String registerCustomer() {

        Scanner scanner = new Scanner(System.in);
        String username = regCustName(scanner);
        String email = regCustEmail(scanner);
        String password = regCustPass(scanner);

        if (regCustTest(username, email, password, CUSTOMERU)) {
            return "Customer registration successful!";
        } else {
            return "Customer registration failed. ";
        }
    }
    public static String regCustName(Scanner scanner){

        logger.info("Enter customer's username: ");
        return scanner.nextLine();
    }
    public static String regCustEmail(Scanner scanner){

        logger.info("Enter customer's email: ");
        return scanner.nextLine();
    }
    public static String regCustPass(Scanner scanner){

        logger.info("Enter customer's password: ");
        return scanner.nextLine();
    }
    /////////////////////////////////////////////////////////////////////
    ///////////////////////////MANAGE INSTALLERS/////////////////////////
    public static void manageInstallers() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            logger.info("\nInstaller Management\n1. Sign_Up Installer 2. List Installers" +
                    "\n3. Back\nEnter Number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    setRegInstaller(true);
                    registerInstaller();
                    break;
                case 2:
                    setListInstaller(true);
                    listInstallers();
                    break;
                case 3:
                    return;
                default:
                    logger.info("Sorry ! Invalid choice. Please try again.");
            }
        }
    }
    public static void registerInstaller() {
        Scanner scanner = new Scanner(System.in);

        logger.info("Enter installer's id: ");
        int id = scanner.nextInt();

        logger.info("Enter installer's username: ");
        String username = scanner.nextLine();

        logger.info("Enter installer's email: ");
        String email = scanner.nextLine();

        logger.info("Enter installer's password: ");
        String password = scanner.nextLine();

        logger.info("Please input your available dates (Type 'finish' when finished)");
        String date = scanner.nextLine();
        switch (date){
            case "finish":
                break;
            default:
                installersDatabase.add(new Installer(id,username, email, password,"installer",date));
                availableDates.add(new Dates(date,getLoggedIngetName()));
                date();
        }
        logger.info(INSTALLERSUCCESS);
    }
    /////////////////////////////////////////////////////////////////////
    ///////////////////////////MANAGE APPOINTMENTS///////////////////////
    public static void manageAppointments() {
        Scanner scanner = new Scanner(System.in);
        Installer installer1 = getLoggedInInstaller();
        logger.info("Appointment Management\n1. List Appointments 2. Back\nEnter Number: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                listAppointments(installer1,installersDatabase);
                break;
            case 2:
                return;

            default:
                logger.info("Sorry ! Invalid choice. Please try again.");
        }
    }
    public static void date(){
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        switch (date){
            case "finish":
                break;
            default:
                availableDates.add(new Dates(date,getLoggedIngetName()));
                date();
        }
    }
    /////////////////////////////////////////////////////////////////////
    ///////////////////////////MANAGE ORDERS/////////////////////////////
    static String xchoice="Invalid choice. Please try again.";
    public static void manageOrders() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            logger.info("\nOrder Management\n1. Place Order 2. List Orders" +
                    "\n3. List Categories 4. Back\nEnter Number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    setPlaceOrder(true);
                    placeOrder();
                    break;
                case 2:
                    setListOrder(true);
                    listOrders();
                    break;
                case 3:
                    setListCategories(true);
                    listCategories();
                    break;
                case 4:
                    return;
                default:
                    logger.info(xchoice);
            }
        }
    }
    public static void placeOrder() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Available Products:");
        listProducts(products);
        logger.info("Enter yes if you want to search specifc products ?");
        String pro = scanner.nextLine();
        switch (pro){
            case "yes":
                searchProducts();
                ordersteps();
                break;
            case "no":
                ordersteps();
                break;
            default:
                logger.info(xchoice);
                placeOrder();
        }
    }




    ///////////////////////////CUSTOMER DASH/////////////////////////////
    public static void customerDashboard() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            logger.info("\ncustomer Dashboard\n1. Browse products 2. make purchases 3. view orders 4. List Categories\n" +
                    "5. Logout\nEnter Number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listProducts(products);
                    break;
                case 2:
                    placeOrder();
                    break;
                case 3:
                    listOrders();
                    break;
                case 4:
                    listCategories();
                    break;
                case 5:
                    logger.info("Logging out from the admin dashboard.");
                    loginUser();
                    return;
                default:
                    logger.info(INVALIDATION);
            }
        }
    }
    public static void listOrders() {
        Customer customer = getLoggedInCustomer();
        if (customer != null) {
            logger.info("Orders for " + customer.getUsername() + ":");
            List<Order> orders = customer.getOrders();
            for (Order order : orders) {
                logger.info("Order ID: " + order.getOrderId());
                logger.info("Ordered Products:");
                for (Product product : order.getOrderedProducts()) {
                    logger.info("Name: " + product.getName() + ", Price: " + product.getPrice());
                }
                logger.info("Total Price: " + order.getTotalPrice());
            }
        } else {
            logger.info("Orders for " + customer1.getUsername() + ":");
            for (Order order : orderss) {
                logger.info("Order ID: " + order.getOrderId());
                logger.info("Ordered Products:");
                for (Product product : order.getOrderedProducts()) {
                    logger.info("Name: " + product.getName() + ", Price: " + product.getPrice());
                }
                logger.info("Total Price: " + order.getTotalPrice());
            }
        }
    }

    public static void installerDashboard() {
        Scanner scanner = new Scanner(System.in);
        Installer installer1 = getLoggedInInstaller();

        while (true) {
            logger.info("\ninstaller Dashboard\n1. View installation requests 2. schedule appointments" +
                    "\n3. Logout\nEnter Number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listAppointments(installer1,installersDatabase);
                    break;
                case 2:
                    scheduleAppointment2();
                    break;
                case 3:
                    logger.info("Logging out from the installer dashboard.");
                    loginUser();
                    return;
                default:
                    logger.info(INVALIDATION);
            }
        }
    }

    public static List<Order> orderss;
    public static Customer customer1;
    public static List<Product> selectedProducts = new ArrayList<>();
    public static void orderstep1(String input,List<Product> products){
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(input)&&product.getAvailablity()!=0) {
                selectedProducts.add(product);
                product.setAvailablity();
                listProducts(products);

                break;
            }else if (product.getAvailablity()==0){ logger.info("There is no enough");}
        }
    }
    public static void ordersteps(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            logger.info("Enter the name of the product you want to order (or 'done' to finish): ");
            String input = scanner.nextLine();

            orderstep1(input,products);

            if (input.equalsIgnoreCase("done")) {
                logger.info("Enter yes if you want installation service ?");
                String in = scanner.nextLine();
                switch (in){
                    case "yes":
                        scheduleAppointment2();
                        break;
                    case "no":
                        logger.info("we sent to you a confirmation email ..");
                        return;

                    default:
                        logger.info(xchoice);
                }
                break;

            }
        }
        if(Appointment.getinstaller()==null){
            logger.info(xchoice);
            return;
        }

        Customer customer = getLoggedInCustomer();
        Order order = new Order(orderIdCounter, selectedProducts);
        totalPrice= String.valueOf(order.getTotalPrice());
        for(Product product:selectedProducts){
            String productName=product.getName();
        }
        sendOrderConfirmationEmail(product.getName(), Double.parseDouble(totalPrice));

        if (selectedProducts.isEmpty()) {
            logger.info("No products selected..");
        }

        if(customer==null){

            logger.info("Insert Customer Name: ");
            String customername=scanner.nextLine();
            logger.info("Insert Customer email: ");
            String customeremail=scanner.nextLine();
            customer1=new Customer(customername,customeremail,"","customer");
            customer1.getOrders().add(order);
            orderss=customer1.getOrders();
        }else customer.getOrders().add(order);
        orderIdCounter++;
        logger.info("successfully!");
    }

    public static void scheduleAppointment2(){
        setChooseSchedule(true);
        Scanner scanner = new Scanner(System.in);
        logger.info(" car model ?");
        String carmodel = scanner.nextLine();
        logger.info(" car date ?");
        String carDate = scanner.nextLine();
        logger.info("Choose the installer you want ");
        logger.info("Available Installers:");
        listInstallers();
        logger.info("Enter the # of the installer date you want to schedule an appointment with: ");
        int installerId = scanner.nextInt();
        scanner.nextLine();
        scheduleAppointment(carmodel,carDate,installerId,installersDatabase);
    }
    public static Customer getLoggedInCustomer() {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(getLoggedIngetEmailCustomer())) {
                return customer;
            }
        }
        return null ;
    }
    public static String getLoggedInCustomerName() {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(getLoggedIngetEmailCustomer())) {
                return customer.getUsername();
            }
        }
        return null ;
    }
    public static void addcatTEG(String name){
        categories.add(new Category(name));
    }

    public static Installer getLoggedInInstaller() {

        for (Installer installer : installersDatabase) {
            if (installer.getEmail().equals(getLoggedIngetEmail())) {
                return installer;
            }
        }
        return null;
    }
    public static void listProducts(List<Product> products) {
        logger.info("Products:");
        for (Product product : products) {
            logger.info("Name: " + product.getName() + ", Price: " + product.getPrice() +", Category: " + product.getCategory() + ", Availability: " + product.getAvailablity() );
        }
    }
    public static void productsearch(String name){
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                logger.info("Name: " + product.getName() + ", Price: " + product.getPrice());
            }
        }
    }
    public static void listProductsOrder() {
        logger.info("Products:");
        for (Product product : products) {
            logger.info("Name: " + product.getName() + ", Price: " + product.getPrice() +", Category: " + product.getCategory() + ", Availability: " + product.getAvailablity() );
        }
    }
    public static void isCustLogged(){
        if (isCustomerLoggedIn()) {
            customerDashboard();
        }
    }
    public static void isAdminLogged(){
        if (isAdminislogged()) {
            adminDashboard();
        } else logger.info("You need to log in correctly");
    }
    public static void isInstallerLogged(){
        while (isInstallerislogged()) {
            installerDashboard();
        }
    }

    public static void register(String username,String email,String password,String userType){
        User us = new User(username, email, password, userType);
        for (User user : userDatabase) {
            if (email.equals(user.getEmail())) {
                logger.info("this user already exist");
                return ;}
        }
        logger.info("Registration successful!");
        userDatabase.add(us);
        logger.info("Now you can Log_In!");
        loginUser();
    }
    public static void signin(String email,String password){
        for (User user : userDatabase) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password) && user.getUserType().equalsIgnoreCase("admin")) {
                adminsignin(user);
                isAdminLogged();
            } else if (user.getEmail().equals(email) && user.getPassword().equals(password) && user.getUserType().equalsIgnoreCase("customer")) {
                customersignin(user);
                isCustLogged();
            } else {
                installersignin(email, password);
                isInstallerLogged();
            }
        }
        logger.info("Log_In failed. \n Please check your email and password.");
    }

    public static void sendOrderConfirmationEmail(String productName,  double totalPrice) {
        String from= "laith.nnn96@gmail.com";
        String to = "s11927490@stu.najah.edu";

        String subject = "Order Confirmation";
        String messageText = "Thank you for your order!\n\n"
                + "Product Name: " + productName + "\n"
                + "Total Price: " + totalPrice + "$"+ "\n\n"
                + "We appreciate your business.";


        EmailSender.sendEmail(from, to, subject, messageText);
    }

}

