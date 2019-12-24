package SystemBehavioralPatterns;

import Controllers.storeownerActions;
import Database.storeDatabase;

public class UndoAddOffercommand implements command{
	private storeownerActions sta;
	private storeDatabase sdb;

	

	public UndoAddOffercommand(storeownerActions sta, storeDatabase sdb) {
		super();
		this.sta = sta;
		this.sdb = sdb;
	}



	public void execute() {
		sta.undoAddStoreOffer();
		sdb.replaceObject(sta.getS());

	}
     
      
}
