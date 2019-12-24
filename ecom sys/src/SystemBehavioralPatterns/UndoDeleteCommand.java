package SystemBehavioralPatterns;

import Controllers.storeownerActions;
import Database.storeDatabase;

public class UndoDeleteCommand implements command {
	private storeownerActions sta;
	private storeDatabase sdb;

	public UndoDeleteCommand(storeownerActions sta, storeDatabase sdb) {
		super();
		this.sta = sta;
		this.sdb = sdb;
	}

	public void execute() {
  		sta.undoAdd();
		sdb.replaceObject(sta.getS());
	}
}
