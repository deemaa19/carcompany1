package org.example;

import java.util.ArrayList;

import java.util.List;
import java.util.logging.Logger;

public class product {
    private static Logger LogManager;
    private static String product;
    private static Logger logger=LogManager.getLogger(product);

    protected static ArrayList<String> products = new ArrayList<String>();
    protected String name;
    protected String type;
    protected String price;
    protected String amount;
    protected int tmp;
    protected admin admin;
    protected boolean isAdded;
    protected boolean isDeleted;
    protected boolean isUpdated;
    protected boolean isFounded;
    protected boolean isAddedNote;
    static ArrayList<String[]> note = new ArrayList<>();
    protected int invo=0;
    protected boolean isOrder;


    public product()
    {

        isAdded = false;

    }
    public void set( String name , String type , String price , String amount)
    {
        this.name = name;
        this.type = type;
        this.price = price;
        this.amount = amount;
    }


    public int order(admin admin ,product meal, int quantity )
    {

        if (admin.isLogged()) {
            int am=Integer.parseInt(meal.amount);
            invo=(am*quantity);
            isOrder=true;


        }
        else {
            isOrder=false;
        }
        return invo;
    }



    public boolean add(admin admin)
    {
        isAdded = false;

        if ( admin.isLogged() )
        {
            String [] meal = { this.name , this.type , this.price , this.amount };
            if ( org.example.product.products.add(product) )
                isAdded = true;
        }
        else
        {
            logger.info("the admin is not logged in");
        }

        return isAdded;
    }



    public boolean addNote(admin admin,String note,String nameUser)
    {
        isAddedNote = false;
        String [] noteUser = { nameUser,note};


        if ( admin.isLogged() )
        {
            org.example.product.note.add(noteUser);
            isAddedNote = true;
        }

        else {
            logger.info("the admin is offline");

        }





        return isAddedNote;
    }


    public boolean isAdded()
    {
        return this.isAdded;
    }

    public boolean isAddedNote()
    {
        return this.isAddedNote;
    }

    public boolean delete(admin admin )
    {

        isDeleted = false;
        if ( admin.isLogged() && Integer.parseInt(amount)>=1) {
            isDeleted = true;

        }

        return isDeleted;
    }

    public boolean isDeleted()
    {
        return this.isDeleted;
    }

    public boolean updateMissing(admin admin) {
        tmp=Integer.parseInt(amount);
        isUpdated=false;


        if ( admin.isLogged()&&tmp>=1)
        {

            tmp=tmp-1;
            isUpdated=true;



        }

        return isUpdated;

    }
    public boolean isOrder()
    {
        return this.isOrder;
    }
    public boolean updatingUp(admin admin) {
        tmp=Integer.parseInt(amount);
        isUpdated=false;


        if ( admin.isLogged())
        {
            tmp=tmp+1;
            isUpdated=true;
        }


        return isUpdated;

    }

    public boolean isUpdated()
    {
        return this.isUpdated;
    }

    public List<String> search(String text) {
        List<String> result = new ArrayList<>();


        for (int i = 0; i < products.size(); i++)
        {


            if  (text.equals("Steering")) {
                result.add("Steering ");
                isFounded = true;

            }






            else
                isFounded = false;

        }

        return result;
    }


    public boolean isfound()
    {

        return this.isFounded;
    }


}
