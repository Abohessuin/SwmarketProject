package Encapsulatedbehaviors;

public class paymentBehaviourByUAE implements PaymantBehaviors {


	public int currencyValue() {
		
		return 5;
	}

	
	public boolean checkcountry(String s) {
		
		if(s.equals("UAE")) {
			return true;
		}
		return false;
	}

}
