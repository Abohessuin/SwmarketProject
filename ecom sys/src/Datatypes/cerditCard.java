package Datatypes;

public class cerditCard {
	private int cardnumber;
	private String Cardholdersname;
	private String Expirydate;
	private int Cardverificationcode;


	public cerditCard(int cardnumber, String cardholdersname, String expirydate, int cardverificationcode) {
		super();
		this.cardnumber = cardnumber;
		Cardholdersname = cardholdersname;
		Expirydate = expirydate;
		Cardverificationcode = cardverificationcode;
	}


	public int getCardnumber() {
		return cardnumber;
	}


	public void setCardnumber(int cardnumber) {
		this.cardnumber = cardnumber;
	}


	public String getCardholdersname() {
		return Cardholdersname;
	}


	public void setCardholdersname(String cardholdersname) {
		Cardholdersname = cardholdersname;
	}


	public String getExpirydate() {
		return Expirydate;
	}


	public void setExpirydate(String expirydate) {
		Expirydate = expirydate;
	}


	public int getCardverificationcode() {
		return Cardverificationcode;
	}


	public void setCardverificationcode(int cardverificationcode) {
		Cardverificationcode = cardverificationcode;
	}



  
}
