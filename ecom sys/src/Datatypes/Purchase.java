package Datatypes;

public class Purchase {

	private user u ;
	private product p;
	private store s ;
	
	
	public Purchase(user u, product p, store s) {
		this.u = u;
		this.p = p;
		this.s = s;
	}
	public Purchase() {
		// TODO Auto-generated constructor stub
	}
	public user getuser() {
		return u;
	}
	public void setuser(user u1) {
		u = u1;
	}
	public product getproduct() {
		return p;
	}
	public void setproduct(product p1) {
		p = p1;
	}
	public store getstore() {
		return s;
	}
	public void setstore(store s1) {
		s = s1;
	}
}
