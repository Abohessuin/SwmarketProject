package SystemBehavioralPatterns;

import Controllers.storeownerActions;
import Database.storeDatabase;

public class UndoDeleteOfferCommand implements command{
	private storeownerActions sta;
	private storeDatabase sdb;

	public UndoDeleteOfferCommand(storeownerActions sta, storeDatabase sdb) {
		super();
		this.sta = sta;
		this.sdb = sdb;
	}

	public void execute() {
		sta.undoDeleteStoreOffer();
		sdb.replaceObject(sta.getS());

	}

}
