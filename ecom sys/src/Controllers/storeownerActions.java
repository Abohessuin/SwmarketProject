package Controllers;

import java.util.ArrayList;
import java.util.Map;

import Database.storeDatabase;
import Datatypes.product;
import Datatypes.store;
import Datatypes.storeHistory;

public class storeownerActions {
	private store s;

	public storeownerActions(store s) {
		this.s = s;

	}

	public void undoAdd() {
		Map<product, store> p = s.getArrOfFroducts();
		ArrayList<storeHistory> h = s.getStorehist();
		product b;
		for (int i = 0; i < h.size(); ++i) {
			if (h.get(i).getEditedAttribute() == "add") {
				b = h.get(i).getP();
				for (Map.Entry<product, store> entry : p.entrySet()) {
					if (entry.getKey().getName().equals(b.getName())) {
						p.remove(entry.getKey());
					}
				}
			}
		}
		this.s.setArrOfFroducts(p);
	}

	public void undoDelete() {
		Map<product, store> p = s.getArrOfFroducts();
		ArrayList<storeHistory> h = s.getStorehist();
		product b;
		for (int i = 0; i < h.size(); ++i) {
			if (h.get(i).getEditedAttribute() == "delete") {
				b = h.get(i).getP();
				p.put(b, this.s);
			}
		}
		this.s.setArrOfFroducts(p);

	}

	public void undoEdit() {
		Map<product, store> p = s.getArrOfFroducts();
		ArrayList<storeHistory> h = s.getStorehist();
		product b;
		String editattribute;
		String editvalue;
		String name;
		String brandname;
		int price;
		int quant;
		String cat;
		for (int i = 0; i < h.size(); ++i) {
			b = h.get(i).getP();
			if (h.get(i).getEditedAttribute() == "edit") {
				editattribute = h.get(i).getEditedAttribute();
				editvalue = h.get(i).getEditedValue();
				for (Map.Entry<product, store> entry : p.entrySet()) {
					if (entry.getKey().getName().equals(b.getName())) {
						name = entry.getKey().getName();
						price = entry.getKey().getPrice();
						quant = entry.getKey().getQuantity();
						cat = entry.getKey().getType();
						brandname = entry.getKey().getBrandname();
						product l;
						if (editattribute.equals("name")) {
							l = new product(editvalue, price, brandname, cat, quant);
							p.put(l, this.s);
						} else if (editattribute.equals("brandname")) {
							l = new product(name, price, editvalue, cat, quant);
							p.put(l, this.s);
						} else if (editattribute.equals("category")) {
							l = new product(name, price, brandname, editvalue, quant);
							p.put(l, this.s);
						} else if (editattribute.equals("price")) {
							int m = Integer.parseInt(editvalue);
							l = new product(name, m, brandname, cat, quant);
							p.put(l, this.s);
						} else {
							int m = Integer.parseInt(editvalue);
							l = new product(name, price, brandname, cat, m);
							p.put(l, this.s);
						}
					}
				}
			}

		}
		this.s.setArrOfFroducts(p);
	}
    public void undoAddStoreOffer() {
    	ArrayList<storeHistory> h = s.getStorehist();
    	for(storeHistory curr:h) {
    		if(curr.getType().equals("offer")&&curr.getHistoryType().equals("add")) {
    			s.setStoreOffer(0);
    		}
    	}
    }
 public void undoDeleteStoreOffer() {
	    ArrayList<storeHistory> h = s.getStorehist();	 
	    for(storeHistory curr:h) {
    		if(curr.getType().equals("offer")&&curr.getHistoryType().equals("delete")) {
    		                                                                      	                                       
    			this.s.setStoreOffer(curr.getOfferhist());                            
    		                                  
    		}
    	}
    }
 
	public store getS() {
		return s;
	}

	public void setS(store s) {
		this.s = s;
	}

}
