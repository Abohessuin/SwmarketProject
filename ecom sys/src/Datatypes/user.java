package Datatypes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class user implements Serializable{
	private String use_name;
	private String password;
	private Map<product,store>Cart=new HashMap<product, store>();
	private ArrayList<store>storesUserowened=new ArrayList<store>();
	private ShippingInformatio shippinfo;
	private cerditCard card;


	public user(String use_name, String password) {
		this.use_name = use_name;
		this.password = password;

	}
	
	



	public user() {
		// TODO Auto-generated constructor stub
	}



	public void addToCart(product p,store s) {
		Cart.put(p,s);
	}

	public Map<product, store> getCart() {
		return Cart;
	}

	public void addToStore(store s) {
		storesUserowened.add(s);
	}


	public void setCart(Map<product, store> cart) {
		Cart = cart;
	}




	public ShippingInformatio getShippinfo() {
		return shippinfo;
	}




	public void setUse_name(String use_name) {
		this.use_name = use_name;
	}



	public void setShippinfo(ShippingInformatio shippinfo) {
		this.shippinfo = shippinfo;
	}




	public String getUse_name() {
		return use_name;
	}



	public cerditCard getCard() {
		return card;
	}




	public String getPassword() {
		return password;
	}






	public void setCard(cerditCard card) {
		this.card = card;
	}



	public ArrayList<store> getStoresUserowened() {
		return storesUserowened;
	}






}
