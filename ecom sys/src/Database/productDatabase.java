package Database;

import java.util.ArrayList;
import Database.*;
import Datatypes.*;
import Controllers.*;
import SystemBehavioralPatterns.*;

public interface productDatabase {
	public boolean checkExistence(Object ob);

	public void addToDatabase(Object ob);

	public void printfortest();

	public int getIndexOfObjectInFile(Object ob);

	public void removeFromDatabase(int index);

	public void ModifyObjectInDatabase(int index, Object p);

	public void clear(String loc);

}
