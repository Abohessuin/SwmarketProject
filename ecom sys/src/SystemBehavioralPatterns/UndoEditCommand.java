package SystemBehavioralPatterns;

import Controllers.storeownerActions;
import Database.storeDatabase;

public class UndoEditCommand implements command {
	private storeownerActions sta;
	private storeDatabase sdb;

	public UndoEditCommand(storeownerActions sta, storeDatabase sdb) {
		
		this.sta = sta;
		this.sdb = sdb;
	}

	public void execute() {
		sta.undoAdd();
		sdb.replaceObject(sta.getS());

	}

}
