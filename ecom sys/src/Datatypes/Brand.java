package Datatypes;
import java.io.Serializable;

public class Brand implements Serializable{
	 private String Brandname;
     private String Brandcategory;
	public Brand(String brandname, String brandcategory) {
		Brandname = brandname;
		Brandcategory = brandcategory;
	}
	public Brand() {
		
	}
	public String getBrandname() {
		return Brandname;
	}
	public void setBrandname(String brandname) {
		Brandname = brandname;
	}
	public String getBrandcategory() {
		return Brandcategory;
	}
	public void setBrandcategory(String brandcategory) {
		Brandcategory = brandcategory;
	}
     
	

}
