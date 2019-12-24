package SystemStatictics;
import java.util.ArrayList;

import Datatypes.systemStatictics;

public class systemStaticticsdData implements Subject {

	private ArrayList observers;
	private systemStatictics systemstat;
	
	
	public systemStaticticsdData() {
		observers=new ArrayList<Observer>();
	}
	
	
	public void registerObserver(Observer o) { 
		observers.add(o); 
		} 


	public void removeObserver(Observer o) {
		int i = observers.indexOf(o); 
		if (i >= 0) { 
			observers.remove(i);
			} 
		
	}


	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
		  Observer observer = (Observer)observers.get(i);
		  observer.sum(systemstat);
		  observer.avarage(systemstat);
		  observer.max(systemstat);
		  observer.min(systemstat);
		
		}
		}
		
	

   public void systemStatChanged() {
	   notifyObservers();
   }
 
   public void setSystemstat(systemStatictics systemstat) {
	this.systemstat = systemstat;
	systemStatChanged();
}
   
   

}
