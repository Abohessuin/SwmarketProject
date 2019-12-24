package Controllers;
import Database.*;
import Datatypes.*;
import java.util.ArrayList;
import Controllers.*;
import SystemBehavioralPatterns.*;
import Database.*;
import Datatypes.*;
import Controllers.*;
import Encapsulatedbehaviors.*;

public class adminController {
   
	private static adminController singletonObj;

	private adminController() {
	}
	
	public static adminController getInstance() {
		if( singletonObj==null) {
			singletonObj=new adminController();
		}
		return singletonObj;
	}
	
	
	public boolean Addproduct(productDatabase h,product p,brandDatabase db) {
		String BN=p.getBrandname();
		Brand br=new Brand(BN, "NONE");
		if(validatebrand(br,db))
		{
	           h.addToDatabase(p);
	           return true;
	   
   }
		else {
			return false;
		}
	}
	
	
	
	
	
	public Boolean validatebrand(Brand br,brandDatabase db){
        return db.checkExistence(br);
	}
	
	public boolean validateproduct(product pr,productDatabase db) {

              return db.checkExistence(pr);
		
	}
	
	
	
	public void Addbrand(brandDatabase db,Brand br) {
		
			if(validatebrand(br, db)){
		          System.out.println("Brand already exist");	
			}
	      else {

		     db.addToDatabase(br);
		     
	  }
 }
	
	
	


  public boolean adminLogin(Admin ad,adminDatabase db) {
	  boolean check;
	 return check=db.checkExistence(ad);
	  
	  
	  
  }
  
  
  public ArrayList<Purchase>getSoldItems(itemsSoldDatabase db){
	  return db.getPurchases();
  }



	
}	
	

	

