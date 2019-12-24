package Datatypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import Database.*;
import Datatypes.*;
import SystemStatictics.staticitics;
import Controllers.*;
import SystemBehavioralPatterns.*;

public class store extends TimerTask implements Serializable {

	private int StoreId;
	private String StoreName;
	private String storeLocation;
	private String storeType;
	private String storeOwnername;
	private double storeOffer;
	private staticitics stc;
	private boolean checkproductviewrs;
	private boolean checkproductbuyers;
	private boolean activeOnStore;
	private Map<product, store> arrOfFroducts = new HashMap<product, store>();
	private ArrayList<user> collaborators = new ArrayList<user>();
	private ArrayList<storeHistory> storehist = new ArrayList<storeHistory>();

	public store() {
		stc = new staticitics();
		storeOffer = 1;
		checkproductbuyers = false;
		checkproductviewrs = false;
		activeOnStore = false; /// mean storeowner
		Timer timer = new Timer();
		timer.schedule(this, 0, 60000);
	}

	public store(String storeName, String storeLocation, String storeType, String so) {
		storeOffer = 1;
		StoreName = storeName;
		this.storeLocation = storeLocation;
		this.storeType = storeType;
		this.storeOwnername = so;
	}

	public void puthistory(storeHistory h) {
		storehist.add(h);
	}

	public boolean deleteProduct(String pdn) {
		for (Map.Entry<product, store> entry : arrOfFroducts.entrySet()) {
			if (entry.getKey().getName().equals(pdn)) {
				arrOfFroducts.remove(entry.getKey());
				return true;
			}
		}
		return false;
	}

	public int getStoreId() {
		return StoreId;
	}

	public void setStoreId(int storeId) {
		StoreId = storeId;
	}

	public String getStoreName() {
		return StoreName;
	}

	public void setStoreName(String storeName) {
		StoreName = storeName;
	}

	public String getStoreLocation() {
		return storeLocation;
	}

	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public String getStoreOwnername() {
		return storeOwnername;
	}

	public void setStoreOwnername(String storeOwnername) {
		this.storeOwnername = storeOwnername;
	}

	public Map<product, store> getArrOfFroducts() {
		return arrOfFroducts;
	}

	public void addStoreProducts(product pr) {
		arrOfFroducts.put(pr, this);
	}

	public void addStoreCollaborators(user u) {
		collaborators.add(u);
	}

	public void setArrOfFroducts(Map<product, store> arrOfFroducts) {
		this.arrOfFroducts = arrOfFroducts;
	}

	public ArrayList<storeHistory> getStorehist() {
		return storehist;
	}

	public void setStorehist(ArrayList<storeHistory> storehist) {
		this.storehist = storehist;
	}

	public boolean isActiveOnStore() {
		return activeOnStore;
	}

	public void setActiveOnStore(boolean activeOnStore) {
		this.activeOnStore = activeOnStore;
	}

	public void addStoreHist(storeHistory H) {
		storehist.add(H);
	}

	public ArrayList<user> getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(ArrayList<user> collaborators) {
		this.collaborators = collaborators;
	}
	

	public double getStoreOffer() {
		return storeOffer;
	}

	public void setStoreOffer(double storeOffer) {
		this.storeOffer = storeOffer;
	}

	public void run() {
		if (checkproductviewrs == true) {
			stc.updateUsersView();
			checkproductviewrs = false;
		}
		if (checkproductbuyers == true) {
			stc.updateBuyproducts();
			checkproductbuyers = false;
		}

	}
}
