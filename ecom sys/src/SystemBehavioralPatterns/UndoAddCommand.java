package SystemBehavioralPatterns;

import Controllers.storeownerActions;
import Database.storeDatabase;

public class UndoAddCommand implements command {

	private storeownerActions sta;
	private storeDatabase sdb;

	

	public UndoAddCommand(storeownerActions sta, storeDatabase sdb) {
		super();
		this.sta = sta;
		this.sdb = sdb;
	}



	public void execute() {
		sta.undoAdd();
		sdb.replaceObject(sta.getS());
	}
     
      
}
