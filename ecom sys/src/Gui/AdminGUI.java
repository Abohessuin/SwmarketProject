package Gui;
import java.util.Scanner;

import Database.*;
import Datatypes.*;
import Controllers.*;
import SystemBehavioralPatterns.*;
import Encapsulatedbehaviors.*;
public class AdminGUI {
	private static AdminGUI singletonObj;

	private AdminGUI() {
	}
	
	public static AdminGUI getInstance() {
		if( singletonObj==null) {
			singletonObj=new AdminGUI();
		}
		return singletonObj;
	}

	public void addBrandGUI(adminController cr,brandDatabase br) {
		String a,b,c;
		System.out.println("Enter brand details");
		System.out.println("brand name:");
		Scanner scan=new Scanner(System.in);
		a=scan.nextLine();//
		System.out.println("brand category:");
		Scanner scann=new Scanner(System.in);
		b=scann.nextLine();//


		Brand brand=new Brand(a, b);
		cr.Addbrand(br, brand);


		System.out.println("if u want to show your list press 8 or other key to not");
		int x_o;
		Scanner ttt=new Scanner(System.in);
		x_o=ttt.nextInt();
		if(x_o==8) {
			br.printfortest();
		}



	}

	public void adminAddAllowableproducts(adminController admincont,productDatabase dbproduct,brandDatabase dbbrand) {
		boolean check;
		System.out.println("enter product brandname(brand must be allowable as product to be added)");
		Scanner q=new Scanner(System.in);
		System.out.println("enter product category");
		Scanner f=new Scanner(System.in);
		String brandname=q.nextLine();
		String category=f.nextLine();
		product pp=new product(brandname, category);
		check=admincont.Addproduct(dbproduct, pp,dbbrand);
		if(check) {
			System.out.println( "product added succ");
		}
		else {
			System.out.println("product or brand is not allowable to add");

		}
		System.out.println("if u want to show your list press 8");
		int x_o;
		Scanner ttt=new Scanner(System.in);
		x_o=ttt.nextInt();
		if(x_o==8) {
			dbproduct.printfortest();

		}


	}


	public boolean adminlogin (adminController controladmin,adminDatabase db) {
		boolean check;
		System.out.println("pls enter id and password");
		int id;
		String password1;

		Scanner xx=new Scanner(System.in);

		Scanner yy=new Scanner(System.in);

		Scanner zz=new Scanner(System.in);
		id=xx.nextInt();
		password1=yy.nextLine();
		Admin personn=new Admin(id,password1);
		check=controladmin.adminLogin(personn, db);
		if(check) {
			System.out.println("log in succ");
		}else {
			System.out.println("invalid password or id");
		}

		return check;
	}







}

