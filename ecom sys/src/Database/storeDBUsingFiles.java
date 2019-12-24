package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Database.*;
import Datatypes.*;
import Controllers.*;
import SystemBehavioralPatterns.*;
import Database.*;
import Datatypes.*;
import Controllers.*;
import Encapsulatedbehaviors.*;
import SystemBehavioralPatterns.databaseIterator;

public class storeDBUsingFiles implements storeDatabase {

	private int count = 0;
	private String filePath = "C:\\Users\\lenovo\\Desktop\\ecom2\\fileDatabase\\store.txt";
	private String tmp = "C:\\Users\\lenovo\\Desktop\\ecom2\\fileDatabase\\tmp.txt";
	private databaseIterator baseIter;
	private ArrayList<SearchingBehavior> searchbehave;

	public storeDBUsingFiles(ArrayList<SearchingBehavior> searchbehave2) {
		super();
		this.searchbehave = searchbehave;
	}

	public store addProductInStore(product pr, String storename) {
		String n;
		store ad1 = new store();
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			ad1 = (store) baseIter.next();
			n = ad1.getStoreName();
			if (n.equals(storename)) {
				ad1.addStoreProducts(pr);
				return ad1;

			}

		}
		return null;

	}

	public store deleteProductFromStore(product pr, String storename) {
		String n;
		store ad1 = new store();
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			ad1 = (store) baseIter.next();
			n = ad1.getStoreName();
			if (n.equals(storename)) {
				ad1.deleteProduct(pr.getName());
				return ad1;
			}

		}
		return null;

	}

	public boolean checkExistence(Object ob) {
		store us = (store) ob;
		store ad1 = new store();
		String storename = us.getStoreName();
		String storeowner = us.getStoreOwnername();
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			ad1 = (store) baseIter.next();
			String currstorename = ad1.getStoreName();
			String currowner = ad1.getStoreOwnername();

			if (currstorename.equals(storename) && currowner.equals(storeowner)) {
				return true;
			}

		}

		return false;

	}

	public void printfortest() {
		store ad1 = new store();
		String nam;
		String storeowner;
		baseIter = new databaseIterator(filePath, count);
		int count = 1;
		while (baseIter.hasNext()) {
			ad1 = (store) baseIter.next();
			nam = ad1.getStoreName();
			storeowner = ad1.getStoreOwnername();
			System.out.println(count + "one.........................");
			System.out.println(nam);
			System.out.println(storeowner);

			count++;
		}
	}

	public void addToDatabase(Object ob) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(filePath, true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ob);
			oos.close();
			count++;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Map<product, store> searchForProductDb(String searchproduct) {
		Map<product, store> mergeAllMatchedProducts = new HashMap<product, store>();
		for (SearchingBehavior curr : searchbehave) {
			Map<product, store> subarr = curr.searchingAboutMatchingProduct(filePath, searchproduct, count);
			for (Map.Entry<product, store> entry : subarr.entrySet()) {
				mergeAllMatchedProducts.put(entry.getKey(), entry.getValue());

			}
		}
		return mergeAllMatchedProducts;
	}

	public void ObjectToFile(Object serObj, String loc) {
		FileOutputStream fos;
		try {

			fos = new FileOutputStream(loc, true);
			ObjectOutputStream objectOut = new ObjectOutputStream(fos);
			objectOut.writeObject(serObj);
			objectOut.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void clear(String loc) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(loc);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getIndexOfObjectInFile(Object ob) {
		int i = 0;
		count = baseIter.setcounter(filePath);
		store a = new store();
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			a = (store) baseIter.next();
			i++;

		}
		return i;
	}

	public void removeFromDatabase(int index) {
		int j = 0;
		store ss = new store();
		count = baseIter.setcounter(filePath);
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			ss = (store) baseIter.next();
			if (j != index) {
				this.ObjectToFile(ss, tmp);
			}
			j++;
		}
		count = baseIter.setcounter(filePath);
		this.clear(filePath);
		baseIter = new databaseIterator(tmp, count);
		while (baseIter.hasNext()) {
			ss = (store) baseIter.next();
			ObjectToFile(ss, filePath);
		}

		this.clear(tmp);

	}

	public void ModifyObjectInDatabase(int index, Object p) {
		int j = 0;
		store ss = new store();
		count = baseIter.setcounter(filePath);
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			ss = (store) baseIter.next();
			if (j == index) {
				this.ObjectToFile((store) p, tmp);
			} else {
				this.ObjectToFile(ss, tmp);
			}
			j++;
		}
		count = baseIter.setcounter(filePath);
		this.clear(filePath);
		baseIter = new databaseIterator(tmp, count);
		while (baseIter.hasNext()) {
			ss = (store) baseIter.next();
			ObjectToFile(ss, filePath);
		}

		this.clear(tmp);

	}

	public void replaceObject(Object p) {
		int n = getIndexOfObjectInFile(p);
		ModifyObjectInDatabase(n, p);

	}

	public store getStore(String storename) {
		store ad1 = new store();
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			ad1 = (store) baseIter.next();
			String currstorename = ad1.getStoreName();
			if (currstorename.equals(storename)) {
				return ad1;
			}
		}
		return null;

	}

	public product getProductFromStore(String productname) {
		store ad1 = new store();
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			ad1 = (store) baseIter.next();
			Map<product, store> m = ad1.getArrOfFroducts();
			for (Map.Entry<product, store> entry : m.entrySet()) {
				if (entry.getKey().getName().equals(productname)) {
					return entry.getKey();
				}
			}

		}

		return null;
	}

}
