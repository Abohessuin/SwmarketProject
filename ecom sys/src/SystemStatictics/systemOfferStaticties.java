package SystemStatictics;

import Datatypes.systemStatictics;

public class systemOfferStaticties implements Observer {

	private systemStaticticsdData data;
	
	public systemOfferStaticties(systemStaticticsdData data) {
		this.data = data;
		data.registerObserver(this);
	}

	public void sum(systemStatictics sys) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void avarage(systemStatictics sys) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void max(systemStatictics sys) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void min(systemStatictics sys) {
		// TODO Auto-generated method stub
		
	}



}
