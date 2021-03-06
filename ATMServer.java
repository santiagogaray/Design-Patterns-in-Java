/**
 * Title:        	Final Project: ATMServer class
 * Description:  	Creates an ATMFactoryServant object
 * 					and binds it on the naming service for
 * 					future use by the Client.
 *
 * @author			Santiago Garay
 * @version 		%I% , %G%
 */

package cscie160.project;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

public class ATMServer {
	public static void main(String argv[]) {
		try {

 			// ORB object creation and init.
			ORB orb = ORB.init(argv, null);

 			// ATMFactoryServant creation for connecting
    		// to naming service
			ATMFactoryServant factory = new ATMFactoryServant();

			// initial naming context
			orb.connect(factory);
			org.omg.CORBA.Object objRef =
				orb.resolve_initial_references("NameService");

 			// Narrowing of generic object to NamingContext object
			NamingContext ncRef = NamingContextHelper.narrow(objRef);

			// Construction of NameComponent array
			NameComponent nc = new NameComponent("ATMFactory", "");
			NameComponent path[] = {nc};

   			// Notification of interface to the naming service
			ncRef.rebind(path, factory);

			System.out.println("ATMFactory registered");

			java.lang.Object sync = new java.lang.Object();
			synchronized (sync) {
				sync.wait();
			}

		} catch (Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
		}
	}
}
