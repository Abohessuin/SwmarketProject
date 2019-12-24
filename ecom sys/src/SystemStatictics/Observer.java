package SystemStatictics;

import Datatypes.systemStatictics;

public interface Observer {
      public void sum(systemStatictics sys);
      public void avarage(systemStatictics sys);
      public void max(systemStatictics sys);
      public void min(systemStatictics sys);
	
}
