package Datatypes;
import java.io.Serializable;
public class Admin implements Serializable {

	private int ID;
	private String Name;
	private String Password;
	public Admin(int iD, String password) {
		super();
		ID = iD;
		Password = password;
	}
	public Admin() {
		
	}
	public int getID() {
		return ID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}

	

	
}
