package Datatypes;

import java.util.ArrayList;

public class systemStatictics {
   private ArrayList<Purchase> a;
   private ArrayList<user> u;
   private ArrayList<product> p;
   private ArrayList<store>s; 
   
	 public systemStatictics(ArrayList<Purchase> a) {
		 
		 this.a=a;
		 }
	 
	 public ArrayList<user> getU() {
		return u;
	}



	public ArrayList<product> getP() {
		return p;
	}

	

	public ArrayList<store> getS() {
		return s;
	}
    
	public void getarrayuser(){
		 ArrayList<user> u = new ArrayList<user>(); 
		  for (Purchase p : a) { 		      
	           		user u1=p.getuser();
	           		u.add(u1);
	      }
		  this.u=u;
	 }
	 
	 public void getarrayproduct(){
		 ArrayList<product> u = new ArrayList<product>(); 
		  for (Purchase p : a) { 		      
	           		product p1=p.getproduct();
	           		u.add(p1);
	      }
		  this.p=u;
	 }
	 public void getarraystore(){
		 ArrayList<store> u = new ArrayList<store>(); 
		  for (Purchase p : a) { 		      
	           		store s1=p.getstore();
	           		u.add(s1);
	      }
		  this.s=u;
	 }
	 
	 public void getSystemStatictics() {
		 getarrayuser();
		 getarrayproduct();
		 getarraystore();
	 }
	 
}
