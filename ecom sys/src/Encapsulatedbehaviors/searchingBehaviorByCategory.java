package Encapsulatedbehaviors;
import java.util.HashMap;
import java.util.Map;
import Database.*;
import Datatypes.*;
import SystemBehavioralPatterns.databaseIterator;
import Controllers.*;
import SystemBehavioralPatterns.*;
public class searchingBehaviorByCategory implements SearchingBehavior{

	 private databaseIterator baseIter;
	public Map<product, store> searchingAboutMatchingProduct(String location, String searchp,int counter) {
		Map<product,store> prod=new HashMap<product,store>();
		Map<product, store> storeProd;
		baseIter=new databaseIterator(location, counter);
		store s=new store();
		product p=new product();
		String cat;
		while(baseIter.hasNext()) {
			s=(store)baseIter.next();
			storeProd=s.getArrOfFroducts();
			 for (Map.Entry<product,store> entry : storeProd.entrySet()) {
				 p=entry.getKey();
				 cat=p.getType();
				 if(cat.equals(searchp)) {
					prod.put(p,entry.getValue());
				 }
			 }
		           
			
		}
		return prod;
		
	}

}
