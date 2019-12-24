package Datatypes;
import java.io.Serializable;

public class product implements Serializable{
      private String name;
      private int price ;
      private String brandname;
      private String category;
      private int Quantity;
      
      public product(String brandname,String category) {
    	  this.brandname=brandname;
    	  this.category=category;
      }
	  public product(String name, int price, String brandname, String type,int Quantity) {
		super();
		this.name = name;
		this.price = price;
		this.brandname = brandname;
		this.category = type;
		this.Quantity=Quantity;
	}
	public product() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getType() {
		return category;
	}
	public void setType(String type) {
		this.category = type;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	
}
