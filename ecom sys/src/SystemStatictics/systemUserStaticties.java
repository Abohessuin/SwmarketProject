package SystemStatictics;

import Datatypes.systemStatictics;

public class systemUserStaticties implements Observer {

	private systemStaticticsdData data;
	public systemUserStaticties(systemStaticticsdData data) {
		this.data = data;
		data.registerObserver(this);
	}


	public void sum(systemStatictics sys) {
		// TODO Auto-generated method stub
		
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
