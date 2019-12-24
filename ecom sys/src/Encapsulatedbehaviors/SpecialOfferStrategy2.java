package Encapsulatedbehaviors;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import Datatypes.OfferData;
import Datatypes.product;
import Datatypes.store;
import Datatypes.user;

public class SpecialOfferStrategy2 implements SpecialOfferBehavior {

	
	public boolean OfferCondition(OfferData a) {
		user u=a.getU();
		Map<product,store>c=u.getCart();
		String productn,brandn,currprod,currbrand;
		for (Entry<product, store> entry : c.entrySet()){
			productn=entry.getKey().getName();
			brandn=entry.getKey().getBrandname();
			for (Entry<product, store> entry1 : c.entrySet()) {
				currprod=entry1.getKey().getName();
				currbrand=entry1.getKey().getBrandname();
				if(productn.equals(currprod)&&brandn.equals(currbrand)) {
					return true;
				}
			}
			
		}
		return false;
	}

	
	public double OfferValue(OfferData a) {
		
		return 0.1;
	}

}
