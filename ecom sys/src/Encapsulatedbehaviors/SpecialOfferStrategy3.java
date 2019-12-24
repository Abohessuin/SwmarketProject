package Encapsulatedbehaviors;

import Database.itemsSoldDatabase;
import Datatypes.OfferData;
import Datatypes.user;

public class SpecialOfferStrategy3 implements SpecialOfferBehavior {


	public boolean OfferCondition(OfferData a) {
		itemsSoldDatabase db=a.getItemsdb();
		user u=a.getU();
		return db.checkAboutUserPurchase(u);
		
	}

	
	public double OfferValue(OfferData a) {
		
		return 0.5;
	}

}
