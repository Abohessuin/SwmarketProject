package Database;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import Datatypes.Admin;
import Datatypes.Purchase;
import Datatypes.product;
import Datatypes.user;
import SystemBehavioralPatterns.databaseIterator;

public class itemSoldDbUsingFiles implements itemsSoldDatabase {
	private int count = 0;
	private String filePath = "C:\\Users\\lenovo\\Desktop\\ecom2\\fileDatabase\\itemssold.txt";
	private String tmp = "C:\\Users\\lenovo\\Desktop\\ecom2\\fileDatabase\\tmp.txt";
	private databaseIterator baseIter;
	private static itemSoldDbUsingFiles singletonObj;

	private itemSoldDbUsingFiles() {
	}

	public static itemSoldDbUsingFiles getInstance() {
		if (singletonObj == null) {
			singletonObj = new itemSoldDbUsingFiles();
		}
		return singletonObj;
	}

	public ArrayList<Purchase> getPurchases() {
		Purchase ss = new Purchase();
		count = baseIter.setcounter(filePath);
		baseIter = new databaseIterator(filePath, count);
		ArrayList<Purchase> purchase = new ArrayList<Purchase>();
		while (baseIter.hasNext()) {
			ss = (Purchase) baseIter.next();
			purchase.add(ss);
		}
		return purchase;
	}

	public void printfortest() {
		product ad1 = new product();
		String nam;
		String brandname;
		int count = baseIter.setcounter(filePath);
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			ad1 = (product) baseIter.next();
			nam = ad1.getName();
			brandname = ad1.getBrandname();
			System.out.println(count + "one.........................");
			System.out.println(nam);
			System.out.println(brandname);
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

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

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
		Purchase a = new Purchase();
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			a = (Purchase) baseIter.next();
			i++;

		}
		return i;
	}

	public void removeFromDatabase(int index) {
		int j = 0;
		Purchase ss = new Purchase();
		count = baseIter.setcounter(filePath);
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			ss = (Purchase) baseIter.next();
			if (j != index) {
				this.ObjectToFile(ss, tmp);
			}
			j++;
		}
		count = baseIter.setcounter(filePath);
		this.clear(filePath);
		baseIter = new databaseIterator(tmp, count);
		while (baseIter.hasNext()) {
			ss = (Purchase) baseIter.next();
			ObjectToFile(ss, filePath);
		}

		this.clear(tmp);

	}

	public void ModifyObjectInDatabase(int index, Object p) {
		int j = 0;
		Purchase ss = new Purchase();
		count = baseIter.setcounter(filePath);
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			ss = (Purchase) baseIter.next();
			if (j == index) {
				this.ObjectToFile((Admin) p, tmp);
			} else {
				this.ObjectToFile(ss, tmp);
			}
			j++;
		}
		count = baseIter.setcounter(filePath);
		this.clear(filePath);
		baseIter = new databaseIterator(tmp, count);
		while (baseIter.hasNext()) {
			ss = (Purchase) baseIter.next();
			ObjectToFile(ss, filePath);
		}

		this.clear(tmp);

	}

	public boolean checkAboutUserPurchase(user u) {
		Purchase ad1 = new Purchase();
		String nam = u.getUse_name(), n;
		int count = baseIter.setcounter(filePath);
		user f;
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			ad1 = (Purchase) baseIter.next();
			f = ad1.getuser();
			n = f.getUse_name();
			if (n.equals(nam)) {
				return true;
			}

		}

		return false;

	}

}
