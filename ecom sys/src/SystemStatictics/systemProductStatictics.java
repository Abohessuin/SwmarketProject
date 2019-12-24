package SystemStatictics;

import Datatypes.systemStatictics;

public class systemProductStatictics implements Observer {

	private systemStaticticsdData data;
	
	public systemProductStatictics(systemStaticticsdData data) {
		this.data = data;
		data.registerObserver(this);
	}


	public void sum(systemStatictics sys) {
		
		
	}


	public void avarage(systemStatictics sys) {
		// TODO Auto-generated method stub
		
	}

	
	public void max(systemStatictics sys) {
		// TODO Auto-generated method stub
		
	}

	
	public void min(systemStatictics sys) {
		// TODO Auto-generated method stub
		
	}

	
	

}
