package Database;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import Datatypes.Admin;
import SystemBehavioralPatterns.databaseIterator;

public class adminDbUsingFiles implements adminDatabase {

	private int count = 0;
	private String filePath = "C:\\Users\\lenovo\\Desktop\\ecom2\\fileDatabase\\admin.txt";
	private String tmp = "C:\\Users\\lenovo\\Desktop\\ecom2\\fileDatabase\\tmp.txt";
	private databaseIterator baseIter;
	private static adminDbUsingFiles singletonObj;

	private adminDbUsingFiles() {
	}

	public static adminDatabase getInstance() {
		if (singletonObj == null) {
			singletonObj = new adminDbUsingFiles();
		}
		return singletonObj;
	}

	public boolean checkExistence(Object ob) {
		Admin ad1 = new Admin();
		Admin a = (Admin) ob;
		int id;
		String s;
		boolean check = false;
		baseIter = new databaseIterator(filePath, count);
		while (true) {
			ad1 = (Admin) baseIter.next();
			id = a.getID();
			s = a.getPassword();
			if (id == ad1.getID() && s.equals(ad1.getPassword())) {
				check = true;
				break;
			}
		}
		if (check) {
			return true;
		} else {
			return false;
		}
	}

	public void printfortest() {
		Admin ad1 = new Admin();
		String name;
		int id;
		String s;
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			ad1 = (Admin) baseIter.next();
			id = ad1.getID();
			s = ad1.getPassword();
			name = ad1.getName();
			System.out.println("1st one");
			System.out.println(name);
			System.out.println(s);
			System.out.println(ad1);
		}
	}

	public void addToDatabase(Object ob) {
		Admin a = new Admin(200, "1");
		a.setName("hmada");
		Admin b = new Admin(20176026, "2");
		b.setName("ahmed");
		Admin c = new Admin(20176027, "3");
		c.setName("fesalem");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(a);
			oos.writeObject(b);
			oos.writeObject(c);
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
		Admin a = new Admin();
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			a = (Admin) baseIter.next();
			i++;

		}
		return i;
	}

	public void removeFromDatabase(int index) {
		int j = 0;
		Admin ss = new Admin();
		count = baseIter.setcounter(filePath);
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			ss = (Admin) baseIter.next();
			if (j != index) {
				this.ObjectToFile(ss, tmp);
			}
			j++;
		}
		count = baseIter.setcounter(filePath);
		this.clear(filePath);
		baseIter = new databaseIterator(tmp, count);
		while (baseIter.hasNext()) {
			ss = (Admin) baseIter.next();
			ObjectToFile(ss, filePath);
		}

		this.clear(tmp);

	}

	public void ModifyObjectInDatabase(int index, Object p) {
		int j = 0;
		Admin ss = new Admin();
		count = baseIter.setcounter(filePath);
		baseIter = new databaseIterator(filePath, count);
		while (baseIter.hasNext()) {
			ss = (Admin) baseIter.next();
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
			ss = (Admin) baseIter.next();
			ObjectToFile(ss, filePath);
		}

		this.clear(tmp);

	}

}
