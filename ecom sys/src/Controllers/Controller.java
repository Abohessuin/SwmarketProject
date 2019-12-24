package Controllers;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import Database.*;
import Datatypes.*;
import SystemBehavioralPatterns.*;
import Encapsulatedbehaviors.*;
public class Controller {
	
	private static Controller singletonObj;

	private Controller() {
	}
	
	public static Controller getInstance() {
		if( singletonObj==null) {
			singletonObj=new Controller();
		}
		return singletonObj;
	}
	 
	 public boolean checkValidtyOfProductQuantity(product p,int Productquant) {
		                if(p.getQuantity()<=Productquant) {
		                	return true;
		                }
		                return false;
	 }
	 
	 
	 public void addpurchase(Purchase p,itemsSoldDatabase db) {
		 db.addToDatabase(p);
	 }
	 

		public double  calculateNetPrice(String country,ArrayList<PaymantBehaviors>pb,user u) {
		    double price=0,pop;
		    product m=new product();
			Map<product,store>p=u.getCart(); 	
			for(int i=0;i<pb.size();++i) {
				if(pb.get(i).checkcountry(country)==true) {
					for (Entry<product, store> entry : p.entrySet()) {
						m=entry.getKey();
						pop=m.getPrice();
						price+=pop;
					}
					
				}
				break;
			}
			return price;
		}
		
		
		public double calculatePriceAfterSpecialOffers(double price,ArrayList<SpecialOfferBehavior>sp,OfferData o) {
			for(int i=0;i<sp.size();++i) {
				if(sp.get(i).OfferCondition(o)==true) {
					price=price*sp.get(i).OfferValue(o);
				}
			}
			
			return price;
			
		}


}
