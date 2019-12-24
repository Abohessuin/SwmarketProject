package Database;

import java.util.ArrayList;
import Database.*;
import Datatypes.*;
import Controllers.*;
import SystemBehavioralPatterns.*;

public interface userDatabase {
	public boolean checkExistence(Object ob);

	public void printfortest();

	public void addToDatabase(Object ob);

	public user getuser(user us);

	public int getIndexOfObjectInFile(Object ob);

	public void removeFromDatabase(int index);

	public void ModifyObjectInDatabase(int index, Object p);

	public void clear(String loc);
}
