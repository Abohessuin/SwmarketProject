package Gui;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import Database.*;
import Datatypes.*;
import Controllers.*;
import SystemBehavioralPatterns.*;
import Encapsulatedbehaviors.*;
import SystemStatictics.systemStaticticsdData;

public class UserGUI {
	private String a, b, c, d, e, f = "online";
	private int g, h;
	private product pro;
	private boolean check;
	private String name, password, type;
	private product p;
	private String storena;
	private static UserGUI singletonObj;

	private UserGUI() {
	}

	public static UserGUI getInstance() {
		if (singletonObj == null) {
			singletonObj = new UserGUI();
		}
		return singletonObj;
	}

	private boolean createNewProduct(adminController cr, productDatabase prd) {
		System.out.println("enter product details u need to sell");
		System.out.println("enter product name:");

		Scanner scan = new Scanner(System.in);
		a = scan.nextLine();

		System.out.println("enter product price:");
		scan = new Scanner(System.in);
		g = scan.nextInt();

		System.out.println("enter product brandname:");
		scan = new Scanner(System.in);
		b = scan.nextLine();

		System.out.println("enetr product category:");
		scan = new Scanner(System.in);
		c = scan.nextLine();
		System.out.println("enetr product quantity:");
		scan = new Scanner(System.in);
		h = scan.nextInt();
		pro = new product(a, g, b, c, h);
		this.p = pro;

		return cr.validateproduct(pro, prd);

	}

	public void createNewStore(storeDatabase sdb, storecontroller sc, String so) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter your store details");
		System.out.println("enter storename");
		scan = new Scanner(System.in);
		a = scan.nextLine();
		System.out.println("enetr storelocation");
		scan = new Scanner(System.in);
		b = scan.nextLine();
		store s = new store(a, b, f, so);

		sc.addstoretostoredb(sdb, s);
	}

	private void addProductTOStore(storeDatabase sdb, adminController cr, productDatabase prd, store s,
			storecontroller stocont) {
		Scanner scan = new Scanner(System.in);
		if (createNewProduct(cr, prd) == true) {
			stocont.addProductToStoreInDb(sdb, p, s.getStoreOwnername(), s);
			System.out.println("product added to your list succefully");
		} else {

			System.out.println("product invalid here");
		}

	}

	private void deleteProductFromStore(storeDatabase sdb, store s, storecontroller stocont) {
		Scanner scan;
		System.out.println("Enter product name");
		scan = new Scanner(System.in);
		String prn = scan.nextLine();
		product p = new product();
		p.setName(prn);
		stocont.deleteProductFromStoreInDb(sdb, p, s.getStoreName(), s);
		System.out.println("deleted if avaliable");
	}

	private void editProduct(store s, storecontroller stocont, storeDatabase sdb) {
		Scanner scan;
		System.out.println("product name");
		scan = new Scanner(System.in);
		String prn = scan.nextLine();
		System.out.println("attribute");
		scan = new Scanner(System.in);
		String editatt = scan.nextLine();
		System.out.println("value");
		scan = new Scanner(System.in);
		String editvalue = scan.nextLine();
		stocont.editProductInStore(prn, s, sdb, editatt, editvalue);

	}

	private store accessStore(user u, usercontroller ucont, int nn) {
		Scanner scan;
		store st = new store();
		int n;
		String s;
		System.out.println("Enter store name");
		scan = new Scanner(System.in);
		s = scan.nextLine();
		storena = s;
		if (nn == 1) {
			return ucont.checkStoreownerAccessToHisStores(s, u);
		} else {
			return ucont.checkcollaboratorAccessToHisStores(s, u);
		}

	}

	private boolean addCalaboratores(store s, usercontroller scont, userDatabase udb, storeDatabase sdb) {
		Scanner scann;
		System.out.println("collaborators  username");
		scann = new Scanner(System.in);
		String callname = scann.nextLine();
		return scont.addcollaboratorsTOStore(callname, s, udb, sdb);

	}

	public void storeOwnerFunctionalitiesToStore(user u, usercontroller ucont, storeDatabase sdb, adminController cr,
			productDatabase prd, storecontroller stocont, simpleControl sp, userDatabase udb) {
		Scanner scan;
		int n;
		store s = new store();
		s = accessStore(u, ucont, 1);
		storeownerActions sta = new storeownerActions(s);
		if (s != null) {
			s.setActiveOnStore(false);
			System.out.println("Add product press 1");
			System.out.println("Delete product  press 2");
			System.out.println("Edit product press 3");
			System.out.println("Add collaborators  press 4");
			System.out.println("Undo  collaborators add press 6");
			System.out.println("Undo  collaborators delete press 7");
			System.out.println("Undo  collaborators edit press 8");
			System.out.println("Add offer press 9");
			System.out.println("Delete offer press 10 ");
			System.out.println("Undo  collaborators addoffer press 11");
			System.out.println("Undo  collaborators deleteoffer press 12");
			scan = new Scanner(System.in);
			n = scan.nextInt();
			switch (n) {
			case 1: {
				
				addProductTOStore(sdb, cr, prd, s, stocont);
			}
				break;
			case 2: {
			
				deleteProductFromStore(sdb, s, stocont);
			}
				break;
			case 3: {
				
				editProduct(s, stocont, sdb);

			}
				break;
			case 4: {
				if (addCalaboratores(s, ucont, udb, sdb)) {
					System.out.println("collabrator added ");
				} else {
					System.out.println("not registed user in system");
				}
			}
				break;
			case 6: {
				sp.setSlot(new UndoAddCommand(sta,sdb));

			}
				break;
			case 7: {
				sp.setSlot(new UndoDeleteCommand(sta,sdb));
			}
				break;
			case 8: {
				sp.setSlot(new UndoEditCommand(sta,sdb));
			}
			case 9:{
				Scanner f;
				System.out.println("enter value of offer");
				f = new Scanner(System.in);
				double val = f.nextDouble();
				stocont.modifyOFFerToStore(sdb, s, val);
			}
			break;
			case 10:{
				stocont.DeleteOFFerToStore(sdb, s, 0.0);
			}
			break;
			case 11:{
				sp.setSlot(new UndoAddOffercommand(sta,sdb));
			}
			break;
			case 12:{
				sp.setSlot(new UndoDeleteOfferCommand(sta,sdb));
			}
			break;
			}
		} else {
			System.out.println("u have no store to access");
		}
	}

	public void collaboratorsFunctionalitiesToStoreuser(user u, usercontroller ucont, storeDatabase sdb,
			adminController cr, productDatabase prd, storecontroller stocont, simpleControl sp) {
		Scanner scan;
		int n;
		store s = new store();
		s = accessStore(u, ucont, 2);
		if (s != null) {
			s.setActiveOnStore(true);
			System.out.println("Add product press 1");
			System.out.println("Delete product press 2");
			System.out.println("Edit product press 3");
			System.out.println("Add offer press 4");
			System.out.println("Delete offer press 5");

			scan = new Scanner(System.in);
			n = scan.nextInt();
			switch (n) {
			case 1: {
				addProductTOStore(sdb, cr, prd, s, stocont);
			}
				break;
			case 2: {
				deleteProductFromStore(sdb, s, stocont);

			}
				break;
			case 3: {
				editProduct(s, stocont, sdb);
			}
				break;
			case 4: {
				Scanner f;
				System.out.println("enter value of offer");
				f = new Scanner(System.in);
				double val = f.nextDouble();
				stocont.modifyOFFerToStore(sdb, s, val);
			}
				break;
			case 5: {
				
				stocont.DeleteOFFerToStore(sdb, s, 0.0);
			}
				break;

			}
		} else {
			System.out.println("u have no store to access");
		}

	}

	public boolean userGUILOgin(usercontroller controluser, userDatabase db, user person) {

		boolean check;

		check = controluser.login(db, person);
		return check;
	}

	public boolean userGUIRegister(usercontroller controluser, userDatabase db) {
		boolean check;
		System.out.println("enter username,password to register");
		String name, password;

		Scanner x = new Scanner(System.in);

		Scanner y = new Scanner(System.in);
		name = x.nextLine();
		password = y.nextLine();
		user person = new user(name, password);
		check = controluser.register(db, person);
		return check;
	}

	public void userAddToCartAndSearch(storecontroller controlstore, storeDatabase db, Controller cont, user cust,
			userDatabase db1, usercontroller usercont) {
		String searchfor;
		String productname;
		String brandname;
		String category;
		int quantity;
		int i = 1, o;
		int productnum, productquant;
		boolean check, check1 = true, check2 = true, check3 = true;
		Map<product, store> products;
		product p = new product();
		product buyproduct = new product();
		store buystore = new store();
		Scanner x, y;
		while (true) {
			System.out.println("Enter what u search for:");
			x = new Scanner(System.in);
			searchfor = x.nextLine();
			products = controlstore.searchforproductbycont(searchfor, db);
			if (products.size() == 0) {
				System.out.println("product is not avalieable or out of stocks");
				x = new Scanner(System.in);
				o = x.nextInt();
				if (o == 1) {
					check1 = false;
				}

			} else {
				for (Map.Entry<product, store> entry : products.entrySet()) {
					System.out.println("product no." + i);
					p = entry.getKey();
					productname = p.getName();
					brandname = p.getBrandname();
					category = p.getType();
					quantity = p.getQuantity();
					System.out.println(productname);
					System.out.println(brandname);
					System.out.println(category);
					System.out.println(quantity);
					System.out.println("-------------------------------------");
					i++;
				}
				while (check2) {
					System.out.println("Enter number of product u need to buy and the quantity u want from it");
					System.out.println("enter product number:");
					x = new Scanner(System.in);
					productnum = x.nextInt();
					System.out.println("enter quantity:");
					y = new Scanner(System.in);
					productquant = y.nextInt();
					if (productnum < products.size() && productnum > products.size()) {
						System.out.println("product not avaibale at list");
					}
					int k = 1;
					for (Map.Entry<product, store> entry : products.entrySet()) {
						if (productnum == k) {
							buyproduct = entry.getKey();
							buystore = entry.getValue();

						}
						k++;
					}
					check = cont.checkValidtyOfProductQuantity(p, productquant);
					if (check) {
						for (int i1 = 0; i1 < productquant; ++i1) {
							cust.addToCart(buyproduct, buystore);
						}
						System.out.println("Added to your cart");
					} else {
						System.out.println("quantity more than avaiable or product is out of stock");
					}
					System.out.println("to exit from buying  same product press 2");
					System.out.println("to exit search and buy process press 1");

					x = new Scanner(System.in);
					o = x.nextInt();
					if (o == 1) {
						check1 = false;
						check2 = false;
					} else if (o == 2) {
						check2 = false;
					}

				}
			}
			usercont.modifyUser(cust, db1);
		}

	}

	public user getuserGUI(usercontroller controluser, userDatabase db) {

		boolean check;
		System.out.println("pls enter password ,username and type to access your cart");
		Scanner x = new Scanner(System.in);
		Scanner y = new Scanner(System.in);
		Scanner z = new Scanner(System.in);
		name = x.nextLine();
		password = y.nextLine();
		user person = new user(name, password);
		user k = new user();
		k = controluser.getuser(db, person);
		return k;
	}

	private void shippingProcess(user cust) {
		ShippingInformatio shippinfo;
		String a, b, c, d, e, f, g, h;
		Scanner x;
		System.out.println("Enter name:");
		x = new Scanner(System.in);
		a = x.nextLine();
		System.out.println("Ente surename:");
		x = new Scanner(System.in);
		b = x.nextLine();
		System.out.println("Enter city:");
		x = new Scanner(System.in);
		c = x.nextLine();
		System.out.println("Enter town:");
		x = new Scanner(System.in);
		d = x.nextLine();
		System.out.println("Enter streetnumberOrname :");
		x = new Scanner(System.in);
		e = x.nextLine();
		System.out.println("Enter shippinginfoType :");
		x = new Scanner(System.in);
		f = x.nextLine();
		System.out.println("Enter mobilenumber :");
		x = new Scanner(System.in);
		g = x.nextLine();
		System.out.println("Enter notesaboutshipping :");
		x = new Scanner(System.in);
		h = x.nextLine();
		shippinfo = new ShippingInformatio(a, b, c, d, e, f, g, h);
		cust.setShippinfo(shippinfo);
	}

	private void paymentMethod(user cust, usercontroller cont, userDatabase db) {
		int n, a, c;
		String name, date;
		System.out.println("to pay cash on delivery press 1");
		System.out.println("to pay using Credit or Debit Cards press 2");
		Scanner x = new Scanner(System.in);
		n = x.nextInt();
		if (n == 2) {
			System.out.println("enter cardnumber:");
			x = new Scanner(System.in);
			a = x.nextInt();
			System.out.println("enter Cardholdersname: ");
			x = new Scanner(System.in);
			name = x.nextLine();
			System.out.println("enter Expirydate: ");
			x = new Scanner(System.in);
			date = x.nextLine();
			System.out.println("enter Card verification code: ");
			x = new Scanner(System.in);
			c = x.nextInt();
			cerditCard card = new cerditCard(a, name, date, c);
			cust.setCard(card);
			cont.modifyUser(cust, db);

		}
	}

	private void updateSystemStatictics(adminController adcont, itemsSoldDatabase solddb, systemStaticticsdData sys) {

		ArrayList<Purchase> purchase = adcont.getSoldItems(solddb);
		systemStatictics sysstat = new systemStatictics(purchase);
		sysstat.getSystemStatictics();
		sys.setSystemstat(sysstat);

	}

	private void addPurchaseToDb(user cust, Controller controller, itemsSoldDatabase s) {
		Map<product, store> usercart = cust.getCart();
		product prod;
		store sto;
		for (Map.Entry<product, store> entry : usercart.entrySet()) {
			prod = entry.getKey();
			sto = entry.getValue();
			Purchase purchase = new Purchase(cust, prod, sto);
			controller.addpurchase(purchase, s);

		}
	}

	public void userBuyItemsInCart(user cust, usercontroller cont, userDatabase db, Controller controller,
			itemsSoldDatabase solddb, adminController adcont, systemStaticticsdData sys, ArrayList<PaymantBehaviors> pb,
			ArrayList<SpecialOfferBehavior> sp, OfferData o) {

		shippingProcess(cust);

		paymentMethod(cust, cont, db);

		calculateTransactionsPrice(controller, pb, cust, o, sp);

		addPurchaseToDb(cust, controller, solddb);

		updateSystemStatictics(adcont, solddb, sys);

		System.out.println("purchases confirmed successfully");

	}

	private void calculateTransactionsPrice(Controller c, ArrayList<PaymantBehaviors> pb, user u, OfferData o,
			ArrayList<SpecialOfferBehavior> sp) {
		double priceBeforeDis, priceAfterDis;
		String country;
		System.out.println("choose country ship to UAE-SAR-Internationally");
		Scanner s = new Scanner(System.in);
		country = s.nextLine();
		priceBeforeDis = c.calculateNetPrice(country, pb, u);
		System.out.println("total price:" + priceBeforeDis);
		priceAfterDis = c.calculatePriceAfterSpecialOffers(priceBeforeDis, sp, o);
		System.out.println("total price after disc:" + priceAfterDis);
	}

}
