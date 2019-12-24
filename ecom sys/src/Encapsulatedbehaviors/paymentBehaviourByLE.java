package Encapsulatedbehaviors;

public class paymentBehaviourByLE implements PaymantBehaviors {

	
	public int currencyValue() {
		
		return 1;
	}

	
	public boolean checkcountry(String s) {
		
		if(s.equals("Egypt")) {
			return true; 
		}
		return false;
	}

}
