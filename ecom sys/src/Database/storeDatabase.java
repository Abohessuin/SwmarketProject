package Database;

import java.util.ArrayList;
import java.util.Map;
import Database.*;
import Datatypes.*;
import Controllers.*;
import SystemBehavioralPatterns.*;
import Encapsulatedbehaviors.*;

public interface storeDatabase {
	public store addProductInStore(product pr, String storename);

	public store deleteProductFromStore(product pr, String storename);

	public store getStore(String storename);

	public product getProductFromStore(String productname);

	public boolean checkExistence(Object ob);

	public void printfortest();

	public void addToDatabase(Object ob);

	public int getIndexOfObjectInFile(Object ob);

	public void removeFromDatabase(int index);

	public void ModifyObjectInDatabase(int index, Object p);

	public void replaceObject(Object p);

	public void clear(String loc);

	public Map<product, store> searchForProductDb(String searchproduct);
}
