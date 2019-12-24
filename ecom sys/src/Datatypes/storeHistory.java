package Datatypes;

public class storeHistory {
	private String historyType;
	private String type;
	private product p;
	private String editedAttribute;
	private String editedValue;
	private double offerhist;

	
	public storeHistory(String historyType, product p,String type) {
		this.historyType = historyType;
		this.p = p;
		this.type=type;
	}
	public storeHistory(String historyType, String type) {
		this.historyType = historyType;
		this.type=type;
	}


	public String getHistoryType() {
		return historyType;
	}

	public void setHistoryType(String historyType) {
		this.historyType = historyType;
	}

	public product getP() {
		return p;
	}

	public void setP(product p) {
		this.p = p;
	}

	public String getEditedAttribute() {
		return editedAttribute;
	}

	public void setEditedAttribute(String editedAttribute) {
		this.editedAttribute = editedAttribute;
	}

	public String getEditedValue() {
		return editedValue;
	}

	public void setEditedValue(String editedValue) {
		this.editedValue = editedValue;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getOfferhist() {
		return offerhist;
	}
	public void setOfferhist(double offerhist) {
		this.offerhist = offerhist;
	}

}
