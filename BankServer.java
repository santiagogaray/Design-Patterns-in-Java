/**
 * Title:        	Final Project: BankServer class
 * Description:  	Creates an BankServant and SecurityServant
 * 					object and binds it on the naming service for
 * 					future use by the ATM.
 *
 * @author			Santiago Garay
 * @version 		%I% , %G%
 */

package cscie160.project;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

public class BankServer {

	/* remote bank and security members */
	private static BankServant bank=null;
	private static SecurityServant security = null;


	public static void main(String argv[])
	{
		/* create and register objects */
		registerBank(argv);
		System.out.println("Bank registered");

		registerSecurity(argv);
		System.out.println("Security registered");

		/* pause thread */
		java.lang.Object sync = new java.lang.Object();
		try {
			synchronized (sync) {
				sync.wait();
			}
		} catch (Exception e) {
				System.err.println("ERROR: " + e);
				e.printStackTrace(System.out);
		}
	}

	/**
 	 * Create bank object and bind it to the
	 * naming service
	 */
	private static void registerBank(String argv[])
	{
		try {

 			// ORB object creation and init.
			ORB orb = ORB.init(argv, null);

 			// BankServant creation for connecting
    		// to naming service
			bank = new BankServant();

			// initial naming context
			orb.connect(bank);
			org.omg.CORBA.Object objRef =
				orb.resolve_initial_references("NameService");

 			// Narrowing of generic object to NamingContext object
			NamingContext ncRef = NamingContextHelper.narrow(objRef);

			// Construction of NameComponent array
			NameComponent nc = new NameComponent("Bank", "");
			NameComponent path[] = {nc};

   			// Notification of interface to the naming service
			ncRef.rebind(path, bank);

		} catch (Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
			System.exit(0);
		}
	}

	/**
 	 * Create security object and bind it to the
	 * naming service
	 */
	private static void registerSecurity(String argv[])
	{
		try {

 			// ORB object creation and init.
			ORB orb = ORB.init(argv, null);

 			// BankServant creation for connecting
    		// to naming service
			security = new SecurityServant();

			// initial naming context
			orb.connect(security);
			org.omg.CORBA.Object objRef =
				orb.resolve_initial_references("NameService");

 			// Narrowing of generic object to NamingContext object
			NamingContext ncRef = NamingContextHelper.narrow(objRef);

			// Construction of NameComponent array
			NameComponent nc = new NameComponent("Security", "");
			NameComponent path[] = {nc};

   			// Notification of interface to the naming service
			ncRef.rebind(path, security);

		} catch (Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
			System.exit(0);
		}
	}

}