import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import Database.*;
import Datatypes.*;
import Controllers.*;
import SystemBehavioralPatterns.*;
import Encapsulatedbehaviors.*;
import Gui.AdminGUI;
import Gui.UserGUI;
import SystemStatictics.systemOfferStaticties;
import SystemStatictics.systemProductStatictics;
import SystemStatictics.systemStaticticsdData;
import SystemStatictics.systemUserStaticties;

public class test {

	public static void main(String[] args) {
		storeDatabase dbstore;
		userDatabase db =  userDBUsingFiles.getInstance();
		productDatabase dbproduct =  productDbUsingFiles.getInstance();
		brandDatabase dbbrand =  brandDbUsingFiles.getInstance();
 		adminDatabase dbadmin = adminDbUsingFiles.getInstance();
		itemsSoldDatabase dbsolditems =  itemSoldDbUsingFiles.getInstance();
		usercontroller controluser =  usercontroller.getInstance();
		adminController admincont = adminController.getInstance();
		storecontroller stcontroller = storecontroller.getInstance();
		Controller controller = Controller.getInstance();
		UserGUI usergui =  UserGUI.getInstance();
		AdminGUI adminGUI =AdminGUI.getInstance();
		user currcustomer;
		ArrayList<SearchingBehavior> searchbehave = new ArrayList<SearchingBehavior>();
		ArrayList<PaymantBehaviors> pb = new ArrayList<PaymantBehaviors>();
		ArrayList<SpecialOfferBehavior> sb = new ArrayList<SpecialOfferBehavior>();
		SearchingBehavior searchbehbybrand = new searchingBehaviorByBrand();
		SearchingBehavior searchbehbycate = new searchingBehaviorByCategory();
		SearchingBehavior searchbehbyproductname = new searchingBehaviorByproductName();
		PaymantBehaviors paybehavebyle = new paymentBehaviourByLE();
		PaymantBehaviors paybehavebysar = new paymentBehaviourBySAR();
		PaymantBehaviors paybehavebyuae = new paymentBehaviourByUAE();
		SpecialOfferBehavior sp1 = new SpecialOfferStrategy1();
		SpecialOfferBehavior sp2 = new SpecialOfferStrategy2();
		SpecialOfferBehavior sp3 = new SpecialOfferStrategy3();
		pb.add(paybehavebyle);
		pb.add(paybehavebysar);
		pb.add(paybehavebyuae);
		sb.add(sp1);
		sb.add(sp2);
		sb.add(sp3);
		searchbehave.add(searchbehbybrand);
		searchbehave.add(searchbehbycate);
		searchbehave.add(searchbehbyproductname);
		dbstore = new storeDBUsingFiles(searchbehave);
		systemStaticticsdData systemStat = new systemStaticticsdData();
		systemUserStaticties userstat = new systemUserStaticties(systemStat);
		systemProductStatictics prodstat = new systemProductStatictics(systemStat);
		systemOfferStaticties offerstat = new systemOfferStaticties(systemStat);
		simpleControl smplecont = new simpleControl();
		boolean check, check2 = false;
		String name, Password;

		while (true) {

			System.out.println("create account press 1");
			System.out.println("to sign in  press 2");
			System.out.println("staff login press 3");
			Scanner m = new Scanner(System.in);
			int n = m.nextInt();

			switch (n) {

			case 1: { // register interface

				while (true) {
					check = usergui.userGUIRegister(controluser, db);
					if (check == true) {
						break;
					}
					System.out.println("if u need to exit press e");
					Scanner xu = new Scanner(System.in);
					String yn = xu.nextLine();
					String h = "e";
					if (yn.equals(h)) {

						break;
					}
				}

			}
				break;
			case 2: { /// user interface

				while (true) {
					System.out.println("pls enter USERNAME,PASSWORD  to login");
					Scanner x = new Scanner(System.in);
					Scanner y = new Scanner(System.in);
					name = x.nextLine();
					Password = y.nextLine();
					user userr = new user(name, Password);
					currcustomer = userr;
					check = usergui.userGUILOgin(controluser, db, currcustomer);
					if (check == true) {
						break;
					}
					System.out.println("if u need to exit press e");
					Scanner xu = new Scanner(System.in);
					String yn = xu.nextLine();
					String h = "e";
					if (yn.equals(h)) {
						check2 = true;
						break;
					}
				}
				if (check2 == true) {
					break;
				}
				boolean check4 = true;

				while (check4) {
					System.out.println("sell with us press 1");
					System.out.println("search for and add to your cart  press 2");
					System.out.println("buy items in your cart press 3");
					System.out.println("logout press 9");
					Scanner x = new Scanner(System.in);
					int u = x.nextInt();
					currcustomer=controluser.getuser(db, currcustomer);
					Map<product, store>s=currcustomer.getCart();
					System.out.println(s.size());
					switch (u) {
					case 1: {
						int nn;
						System.out.println("create new store press 1");
						System.out.println("log in current store press 2");
						x = new Scanner(System.in);
						nn = x.nextInt();
						switch (nn) {
						case 1: {
							usergui.createNewStore(dbstore, stcontroller, currcustomer.getUse_name(),controluser,db);

						}
							break;
						case 2: {
							int o;
							System.out.println("log in as storeowner press 1");
							System.out.println("log in as collaborator  press 2");
							x = new Scanner(System.in);
							o = x.nextInt();
							switch (o) {
							case 1: {
								usergui.storeOwnerFunctionalitiesToStore(currcustomer, controluser, dbstore, admincont,
										dbproduct, stcontroller, smplecont, db);
							}
							case 2: {
								usergui.collaboratorsFunctionalitiesToStoreuser(currcustomer, controluser, dbstore,
										admincont, dbproduct, stcontroller, smplecont,db);
							}
							}

						}
							break;

						}

					}
						break;
					case 2: {

						usergui.userAddToCartAndSearch(stcontroller, dbstore, controller, currcustomer, db,
								controluser);

					}
						break;
					case 3: {

						OfferData off = new OfferData(currcustomer, dbsolditems);
						usergui.userBuyItemsInCart(currcustomer, controluser, db, controller, dbsolditems, admincont,
								systemStat, pb, sb, off);

					}
						break;
					case 9: {
						check4 = false;
					}
					}

				}
			}
				break;
			case 3: { // Admin interface
				Object ob = new Object();
				dbadmin.addToDatabase(ob);
				while (true) {
					check = adminGUI.adminlogin(admincont, dbadmin);
					if (check == true) {
						break;
					}
					System.out.println("if u need to exit press e");
					Scanner xu = new Scanner(System.in);
					String yn = xu.nextLine();
					String h = "e";
					if (yn.equals(h)) {
						check2 = true;
						break;
					}
				}
				if (check2 == true) {
					break;
				}
				boolean check3 = true;
				while (check3) {
					int x;
					System.out.println("To ADDproduct press 1");
					System.out.println("To ADDBrand press 2");
					System.out.println("TO Logout press 3 ");
					Scanner scan = new Scanner(System.in);
					x = scan.nextInt();
					switch (x) {
					case 1: {
						adminGUI.adminAddAllowableproducts(admincont, dbproduct, dbbrand);
					}

						break;
					case 2: {

						AdminGUI gui = AdminGUI.getInstance();
						gui.addBrandGUI(admincont, dbbrand);
					}
						break;
					case 3: {
						check3 = false;
					}

					}
				}

			}

			}

		}

	}
}
