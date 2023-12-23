package car;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class product {
    static Logger logger = Logger.getLogger(main.class.getName());
    private int productid;
    private String productname ;
    private String productdescription;
    private String productcategorie;
    private String productprice;
    private String productimage;
    private String productavailability ;


    public product( int productid ,String productname, String productdescription, String productcategorie, String productprice,
                    String productimage, String productavailability) {
        this.productid = productid;
        this.productname = productname ;
        this.productdescription = productdescription ;
        this.productcategorie = productcategorie ;
        this.productprice= productprice;
        this.productimage = productimage;
        this.productavailability = productavailability ;
        // TODO Auto-generated constructor stub
    }
    public product() {
        // TODO Auto-generated constructor stub
    }
    public List<product>addproduct(int productid , String productname, String productdescription, String productcategorie, String productprice,
                                   String productimage, String productavailability ,  List<product> productlist)
    {
        String productnamelower = productname.toLowerCase();
        String productdescriptionlower = productname.toLowerCase();
        String productcategorielower = productname.toLowerCase();
        String productpricelower = productname.toLowerCase();
        String productimagelower = productname.toLowerCase();
        String productavailabilitylower = productname.toLowerCase();
        productlist.add(new product (productid, productnamelower,productdescriptionlower,productcategorielower,productpricelower,
                productimagelower, productavailabilitylower));

        //userlist.add(new User(username,email ,password , userlevelupper));
        return productlist;

    }
//	public List <Product>deleteproduct (int productid, List<Product> productlist){
//        for (Product product: productlist) {
//            if ( product.getProductid()==productid) {
//            	productlist.remove (product);
//            }
//        }
//		return productlist;
//	}

    public boolean deleteproduct (int productid, List<product> productlist){
        for (product product: productlist) {
            if ( product.getProductid()==productid) {
                productlist.remove (product);
                return true;
            }
        }
        return false;
    }
    public boolean ret(int productid, List<product> productlist) {
        for (product product: productlist) {
            if ( product.getProductid()==productid)
            {
                return true ;
            }
        }
        return false;
    }


    public product searchproduct (int productid, List<product> productlist){
        for (product product: productlist) {
            if ( product.getProductid()==productid) {
                return product ;
            }
        }
        return null ;
    }

    public static void printproduct (product product) {

        logger.log(Level.INFO, "Product Id :"+ product.getProductid()+"\n");
        logger.log(Level.INFO, "Product name :"+ product.getProductname()+"\n");
        logger.log(Level.INFO, "Product description :"+ product.getProductdescription()+"\n");
        logger.log(Level.INFO, "Product categorie :"+ product.getProductcategorie()+"\n");
        logger.log(Level.INFO, "Product price :"+ product.getProductprice()+"\n");
        logger.log(Level.INFO, "Product image :"+ product.getProductimage()+"\n");
        logger.log(Level.INFO, "Product availability :"+ product.getProductavailability()+"\n");
    }


    public int getProductid() {
        return productid;
    }
    public void setProductid(int productid) {
        this.productid = productid;
    }


    public String getProductname() {
        return productname;
    }
    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdescription() {
        return productdescription;
    }
    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    public String getProductcategorie() {
        return productcategorie;
    }
    public void setProductcategorie(String productcategorie) {
        this.productcategorie = productcategorie;
    }

    public String getProductprice() {
        return productprice;
    }
    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }


    public String getProductimage() {
        return productprice;
    }
    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }

    public String getProductavailability() {
        return productavailability;
    }
    public void setProductavailability(String productavailability) {
        this.productavailability = productavailability;
    }


}
