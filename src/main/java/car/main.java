package car;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Properties;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;


import java.util.logging.Level;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class main {

        private static userr user = new userr();
    private static product product = new product();
    private static product result = new product();
//    public Product result;


        private static boolean e=true;


        private static List<userr> userList = our_data.listUsers();
        private static List<product> productList = our_data.listproducts();


        static Logger logger = Logger.getLogger(main.class.getName());
        static Scanner scanner = new Scanner(System.in);

        private static int level;
        private static boolean f1= true ;
        private static boolean f2= true ;

        private static boolean f3= true ;





        public static void function() throws IOException
        {
            int key ;
            while (true) {
                logger.log(Level.INFO, "Welcome to our Car accessories company. \\r\\n");
                logger.log(Level.INFO, "Enter your email \\r\\n");
                String email = scanner.next();
                logger.log(Level.INFO, "Enter your password \\n");
                String password = scanner.next();
                boolean jal = user.login(email ,password,userList);
                if (jal =true)
                {
                    //call fun to return userlevel
                    level = user.gotopage(email ,password, userList);
                    switch (level) {
                        case 1 :
                            //go to admin page
                            while (f1) {
                                logger.log(Level.INFO, " you are in admin page \n");
                                logger.log(Level.INFO, " please choose from List: \n");
                                logger.log(Level.INFO, " 1.Create new acount \n"
                                        + "2. Manage poudect table" // first enter the categore
                                        + "3. Manage user acconut \\n"
                                        + "4. log out "); /// exit from all  e=false
                                int input = scanner.nextInt();
                                if (input == 1 )
                                {
                                    //  call fun to sign up
                                    //   while (f2)
                                    // {
                                    logger.log(Level.INFO, "Enter your data to Sign up \\n");
                                    logger.log(Level.INFO, "Enter your name \\n");
                                    String username = scanner.next();
                                    logger.log(Level.INFO, "Enter your email \\r\\n");
                                    String email1 = scanner.next();
                                    logger.log(Level.INFO, "Enter your password \\n");
                                    String password1= scanner.next();
                                    logger.log(Level.INFO, "Enter user level \\n");
                                    String userlevel = scanner.next();
                                    boolean l = user.retsign(email1, userList);
                                    if (l==false) {
                                        userList= user.signup(username, email1, password1, userlevel, userList);
                                        /// call fun print
                                        userr.printuserlist(userList);
                                        f2=false;
                                        //break;
                                    }
                                    else {
                                        logger.log(Level.INFO, "sorry , this user is already exist \\n");
                                        // break;
                                    }
                                }

                                //}
                                else if (input == 2 )
                                {
                                    // manage product with categure
                                    logger.log(Level.INFO, " please choose from List: \n");
                                    logger.log(Level.INFO, " 1.Add pruduct \n"
                                            + "2. Delete pruduct \n" // first enter the categore
                                            + "3. Search pruduct \\n"
                                            + "4. Update pruduct\n ");
                                    int input3 = scanner.nextInt();

                                    if (input3 == 1) {
                                        //call fun add pruduct
                                        logger.log(Level.INFO, "Enter product id\\n");
                                        int productid = scanner.nextInt();
                                        logger.log(Level.INFO, "Enter product name\\n");
                                        String productname = scanner.next();
                                        logger.log(Level.INFO, "Enter product description\\n");
                                        String productdescription = scanner.next();
                                        logger.log(Level.INFO, "Enter product categorie \\r\\n");
                                        String productcategorie = scanner.next();
                                        logger.log(Level.INFO, "Enter product price\\r\\n");
                                        String productprice = scanner.next();
                                        logger.log(Level.INFO, "uplode images \\n");
                                        String productimage = scanner.next();
                                        //    BufferedImage myPicture = ImageIO.read(new File(imagePath));
                                        logger.log(Level.INFO, "enter the  availability \\n");
                                        String productavailability= scanner.next();

                                        boolean p= product.ret(productid, productList);
                                        if (p=false) {
                                            productList= product.addproduct(productid, productname, productdescription, productcategorie, productprice, productimage, productavailability, productList);
                                        }
                                        else {
                                            logger.log(Level.INFO, "sorry , this book is already exist \\n");
                                            continue;

                                        }


                                    }
                                    else if (input3 == 2) {
                                        //call fun delete product
                                        logger.log(Level.INFO, "Enter product id to delete it \\n");
                                        int productiddelete = scanner.nextInt();
                                        boolean d= product.deleteproduct(productiddelete, productList);
                                        if (d==false) {
                                            logger.log(Level.INFO, "not found this product  \\n");

                                        }
                        }
                                    else if (input3 == 3) {
                                        //call fun search product
                                        logger.log(Level.INFO, "Enter product id to search \\n");
                                        int productid = scanner.nextInt();
                                        result=product.searchproduct(productid, productList);
                                        if (result != null) {
                                            product.printproduct(product);
                                        }
                                        else {
                                            logger.log(Level.INFO, "this id is not exist \\n");
                                        }

                                    }
                                    else if (input3 == 4) {
                                        //call fun update product


                                    }


                                }
                                else if (input == 3 )
                                {
                                    // manage user acount
                                }
                                else if (input == 4 )
                                {
                                    // call fun to log out
                                    user.logout();
                                    f1=false;

                                }
                            }
                            break;


                        case 2:
                            // go to customer page
                            logger.log(Level.INFO, " you are in Custumer page \n");
                            logger.log(Level.INFO, " please choose from List: \n");
                            logger.log(Level.INFO, " 1. View product \n" //view and buy
                                    + "2. view order \\n"
                                    + "3. edit profile \n"
                                    + "4. request installation aervice's \n "
                                    + "5. log out ");
                            int input2 = scanner.nextInt();
                            if (input2 == 1 )
                            {
                                //  call fun to view prod and buy
                            }
                            else if (input2 == 2 )
                            {
                                // view order
                            }
                            else if (input2 == 3 )
                            {
                                // edit profile
                            }
                            else if (input2 == 4 )
                            {
                                // request installation aervice's

                            }
                            else if (input2 == 5 )
                            {
                                // call fun to log out

                            }
                            break;


                        case 3:
                            // go to instulaar page
                            logger.log(Level.INFO, " you are in Inataller page \n");
                            logger.log(Level.INFO, " please choose from List: \n");
                            logger.log(Level.INFO, " 1. View installation requests and schedule appointments. \n"
                                    + "2. Schedule and manage installation appointment\\n"
                                    + "3. log out ");
                            int input3 = scanner.nextInt();
                            if (input3 == 1 )
                            {
                                //  View installation requests and schedule appointments.
                            }
                            else if (input3 == 2 )
                            {
                                // Schedule and manage installation appointment
                            }
                            else if (input3 == 3 )
                            {
                                // call fun to log out
                            }
                            break;
                    }
                }
                else if (jal=false) {
                    // try again
                    logger.log(Level.INFO, "try again please\\n");
                    continue;


                }
            }
        }

        public static void main(String[] args) throws IOException
        {

            function();

        }
    }

