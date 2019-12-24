package SystemStatictics;
import java.util.ArrayList;

import Datatypes.product;

public class staticitics {
       private int noOfUsersViewProduct;
       private int noOfUsersBuyProduct;
       private ArrayList<product> soldOutProducts = new ArrayList<product>();

   	
   	public staticitics() {
   		this.noOfUsersBuyProduct=0;
   		this.noOfUsersViewProduct=0;
   	}
       
       
       public staticitics(int noOfUsersViewProduct, int noOfUsersBuyProduct) {
		this.noOfUsersViewProduct = noOfUsersViewProduct;
		this.noOfUsersBuyProduct = noOfUsersBuyProduct;
	}


	public int getNoOfUsersViewProduct() {
		return noOfUsersViewProduct;
	}


	public void setNoOfUsersViewProduct(int noOfUsersViewProduct) {
		this.noOfUsersViewProduct = noOfUsersViewProduct;
	}


	public int getNoOfUsersBuyProduct() {
		return noOfUsersBuyProduct;
	}


	public void setNoOfUsersBuyProduct(int noOfUsersBuyProduct) {
		this.noOfUsersBuyProduct = noOfUsersBuyProduct;
	}

	
     public void updateUsersView() {
    	 this.noOfUsersViewProduct++;
     }
     public void updateBuyproducts() {
    	 this.noOfUsersBuyProduct++;
     }
      
     public void addSoldOutProduct(product p) {
    	 soldOutProducts.add(p);
     }
}
