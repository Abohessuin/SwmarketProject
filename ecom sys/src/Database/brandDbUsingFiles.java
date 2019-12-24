package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import Database.*;
import Datatypes.*;
import SystemBehavioralPatterns.databaseIterator;
import Controllers.*;
import SystemBehavioralPatterns.*;

public class brandDbUsingFiles implements brandDatabase {

	private int count = 0;
	private String filePath = "C:\\Users\\lenovo\\Desktop\\ecom2\\fileDatabase\\brand.txt";
	private String tmp = "C:\\Users\\lenovo\\Desktop\\ecom2\\fileDatabase\\tmp.txt";
	private databaseIterator baseIter;
	private static brandDbUsingFiles singletonObj;

	private brandDbUsingFiles() {
	}

	public static brandDbUsingFiles getInstance() {
		if (singletonObj == null) {
			singletonObj = new brandDbUsingFiles();
		}
		return singletonObj;
	}

	public boolean checkExistence(Object ob) {
		Brand us = (Brand) ob;
		Brand ad1 = new Brand();
		String brandname = us.getBrandname();
		baseIter=new databaseIterator();
		count=baseIter.setcounter(filePath);
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			ad1 = (Brand) baseIter.next();
			String currbrandname = ad1.getBrandname();
			if (currbrandname.equals(brandname)) {
				return true;
			}

		}
		return false;
	}

	public void printfortest() {
		Brand ad1 = new Brand();
		String brandname;
		int count = 1;
		baseIter = new databaseIterator(filePath, count);
		while (true) {
			ad1 = (Brand) baseIter.next();
			brandname = ad1.getBrandname();
			System.out.println(count + " one.........................");
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
			// TODO Auto-generated catch block
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
		Brand a = new Brand();
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			a = (Brand) baseIter.next();
			i++;

		}
		return i;
	}

	public void removeFromDatabase(int index) {
		int j = 0;
		Brand ss = new Brand();
		count = baseIter.setcounter(filePath);
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			ss = (Brand) baseIter.next();
			if (j != index) {
				this.ObjectToFile(ss, tmp);
			}
			j++;
		}
		count = baseIter.setcounter(filePath);
		this.clear(filePath);
		baseIter = new databaseIterator(tmp, count);
		while (baseIter.hasNext()) {
			ss = (Brand) baseIter.next();
			ObjectToFile(ss, filePath);
		}

		this.clear(tmp);

	}

	public void ModifyObjectInDatabase(int index, Object p) {
		int j = 0;
		Brand ss = new Brand();
		count = baseIter.setcounter(filePath);
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			ss = (Brand) baseIter.next();
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
			ss = (Brand) baseIter.next();
			ObjectToFile(ss, filePath);
		}

		this.clear(tmp);

	}

}