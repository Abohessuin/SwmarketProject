package Datatypes;

public class ShippingInformatio {
     private String name;
     private String familyname;
     private String city;
     private String town;
     private String streetnumberOrname;
     private String shippinginfoType;
     private String mobilenumber;
     private String notes;
	public ShippingInformatio(String name, String familyname, String city, String town, String streetnumberOrname,
			String shippinginfoType, String mobilenumber, String notes) {
		super();
		this.name = name;
		this.familyname = familyname;
		this.city = city;
		this.town = town;
		this.streetnumberOrname = streetnumberOrname;
		this.shippinginfoType = shippinginfoType;
		this.mobilenumber = mobilenumber;
		this.notes = notes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFamilyname() {
		return familyname;
	}
	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getStreetnumberOrname() {
		return streetnumberOrname;
	}
	public void setStreetnumberOrname(String streetnumberOrname) {
		this.streetnumberOrname = streetnumberOrname;
	}
	public String getShippinginfoType() {
		return shippinginfoType;
	}
	public void setShippinginfoType(String shippinginfoType) {
		this.shippinginfoType = shippinginfoType;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
     
}
