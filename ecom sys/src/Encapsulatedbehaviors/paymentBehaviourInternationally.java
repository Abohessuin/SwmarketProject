package Encapsulatedbehaviors;

public class paymentBehaviourInternationally implements PaymantBehaviors {


	public int currencyValue() {
		
		return 16;
	}
	
	public boolean checkcountry(String s) {
	
		if(s.equals("International")) {
			return true;
		}
		return false;
	}

}
