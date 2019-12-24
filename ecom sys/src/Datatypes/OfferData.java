package Datatypes;

import Database.itemsSoldDatabase;

public class OfferData {

	private user u ;
	private itemsSoldDatabase itemsdb;

	public OfferData(user u, itemsSoldDatabase itemsdb) {
		super();
		this.u = u;
		this.itemsdb = itemsdb;
	}

	public user getU() {
		return u;
	}


	public void setU(user u) {
		this.u = u;
	}


	public itemsSoldDatabase getItemsdb() {
		return itemsdb;
	}


	public void setItemsdb(itemsSoldDatabase itemsdb) {
		this.itemsdb = itemsdb;
	}



}
