package SystemBehavioralPatterns;

public class simpleControl {
	command slot;

	public void setSlot(command slot) {
		this.slot = slot;
	}
	
	 public void buttonWasPressed() 
	    { 
	        slot.execute(); 
	    } 
}
