package Database;

import java.util.ArrayList;

import Datatypes.*;

public interface itemsSoldDatabase {
	public ArrayList<Purchase> getPurchases();

	public boolean checkAboutUserPurchase(user u);

	public void addToDatabase(Object ob);

	public void printfortest();

	public void ObjectToFile(Object serObj, String loc);

	public int getIndexOfObjectInFile(Object ob);

	public void removeFromDatabase(int index);

	public void ModifyObjectInDatabase(int index, Object p);

	public void clear(String loc);
}
