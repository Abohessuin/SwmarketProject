package Encapsulatedbehaviors;

import java.util.ArrayList;

import Datatypes.OfferData;
import Datatypes.store;
import Datatypes.user;

public class SpecialOfferStrategy1 implements SpecialOfferBehavior {

	
	public boolean OfferCondition(OfferData a) {
		user u=a.getU();
		String un=u.getUse_name();
		String storeun;
		ArrayList<store>st=u.getStoresUserowened();
		for(int i=0;i<st.size();++i) {
			storeun=st.get(i).getStoreOwnername();
			if(storeun.equals(un)==true) {
				return true;
			}
		}
		return false;
	}

	
	public double OfferValue(OfferData a) {
		
		return 0.15;
	}

}
