package Encapsulatedbehaviors;

public class paymentBehaviourBySAR implements PaymantBehaviors {

	
	public int currencyValue() {
		
		return 4;
	}

	
	public boolean checkcountry(String s) {
		
		if(s.equals("SAR")) {
			return true;
		}
		return false;
	}

}
