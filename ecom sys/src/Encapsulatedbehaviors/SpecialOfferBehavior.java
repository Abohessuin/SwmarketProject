package Encapsulatedbehaviors;

import Datatypes.OfferData;
import Datatypes.user;

public interface SpecialOfferBehavior {
	public boolean OfferCondition(OfferData a);
	public double OfferValue(OfferData a);
}
