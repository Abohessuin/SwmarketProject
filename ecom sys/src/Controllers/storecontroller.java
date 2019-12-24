package Controllers;

import java.util.ArrayList;
import java.util.Map;
import Database.*;
import Datatypes.*;
import Controllers.*;
import SystemBehavioralPatterns.*;
import Encapsulatedbehaviors.*;

public class storecontroller {
	private static storecontroller singletonObj;

	private storecontroller() {

	}

	public static storecontroller getInstance() {
		if (singletonObj == null) {
			singletonObj = new storecontroller();
		}
		return singletonObj;
	}

	public void modifyOFFerToStore(storeDatabase sdb, store s, double setVal) {
		s.setStoreOffer(setVal);
		if (s.isActiveOnStore()) {
			storeHistory h = new storeHistory("add", "offer");
			s.addStoreHist(h);
		}
		sdb.replaceObject(s);
	}
	
	public void DeleteOFFerToStore(storeDatabase sdb, store s, double setVal) {
		double ss=s.getStoreOffer();
		s.setStoreOffer(setVal);
		if (s.isActiveOnStore()) {
			storeHistory h = new storeHistory("delete", "offer");
			h.setOfferhist(ss);
			s.addStoreHist(h);
		}
		sdb.replaceObject(s);
	}

	public void addProductToStoreInDb(storeDatabase sdb, product pr, String storename, store s) {
		store ss;
		ss = sdb.addProductInStore(pr, storename);
		if (s.isActiveOnStore() == true) {

			storeHistory h = new storeHistory("add", pr, "product");
			ss.addStoreHist(h);

		}
		sdb.replaceObject(ss);

	}

	public void deleteProductFromStoreInDb(storeDatabase sdb, product pr, String storename, store s) {
		store ss;
		ss = sdb.deleteProductFromStore(pr, storename);
		if (s.isActiveOnStore() == true) {

			storeHistory h = new storeHistory("delete", pr, "product");
			ss.addStoreHist(h);

		}
		sdb.replaceObject(ss);

	}

	public void editProductInStore(String pn, store s, storeDatabase sdb, String edname, String edval) {
		product p = sdb.getProductFromStore(pn);
		store ss = sdb.getStore(s.getStoreName());
		ss.deleteProduct(p.getName());
		storeHistory h = new storeHistory("edit", p, "product");
		if (p != null) {
			if (edname.equals("name")) {
				p.setName(edval);
				h.setEditedAttribute("name");
				h.setEditedValue(edval);
			} else if (edname.equals("price")) {
				int o = Integer.parseInt(edval);
				p.setPrice(o);
				h.setEditedAttribute("price");
				h.setEditedValue(edval);
			} else if (edname.equals("brandname")) {
				p.setBrandname(edval);
				h.setEditedAttribute("brandname");
				h.setEditedValue(edval);
			} else if (edname.equals("category")) {
				p.setType(edval);
				h.setEditedAttribute("category");
				h.setEditedValue(edval);
			} else {
				int o = Integer.parseInt(edval);
				p.setQuantity(o);
				h.setEditedAttribute("quantity");
				h.setEditedValue(edval);
			}
			ss.addStoreProducts(p);
			if (s.isActiveOnStore()) {
				ss.addStoreHist(h);
			}
			sdb.replaceObject(ss);
		}
	}

	public void addstoretostoredb(storeDatabase sdb, store s) {
		sdb.addToDatabase(s);
	}

	public Map<product, store> searchforproductbycont(String productsearch, storeDatabase db) {
		return db.searchForProductDb(productsearch);
	}

}