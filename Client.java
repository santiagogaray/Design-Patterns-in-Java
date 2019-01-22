/**
 * Title:        	Final Project: Client class
 * Description:  	Obtains an ATMFactoryServant from
 * 					the naming service and gets an ATM
 * 					reference from it.
 *					The client registers itself as
 *					an ATM listener to the ATM
 *					in order to display transactions
 *					callbacks.
 * 					Tests several account
 * 					operations through the existing
 * 				 	accounts.
 *
 * @author			Santiago Garay
 * @version 		%I% , %G%
 */

package cscie160.project;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

public class Client extends _ATMListenerImplBase {

	/* parameterless constructor */
    public Client() {
		super();
    }

  	/**
    * Callback handler invoked by the ATM.
    * Displays the transaction notification.
    *
    * @param tn		the transaction information
    * 				to be printed.
    */
	public void handleNotification( TransactionNotification tn )
	{
		System.out.println( tn.getDescription() );
	}

	/**
	* Obtains an atm remote reference,
	* registers as a listener with the atm
	* and performs atm testings.
	*/
	public static void main(String[] args)
	{
		try {
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
			NamingContext ctxt = NamingContextHelper.narrow(obj);
			NameComponent[] name = { new NameComponent("ATMFactory", "") };
			ATMFactory factory = ATMFactoryHelper.narrow(ctxt.resolve(name));
			ATM atm = factory.getATM();
			Client clientATMListener = new Client();
			atm.addATMListener(clientATMListener);
			testATM(atm);
		} catch (Exception e) {
			System.out.println("An exception occurred while communicating with the ATM");
			e.printStackTrace();
		}
	}

	/**
    * Creates an AccountInfo object based on
	* the data specified as parameters.
	*
    * @param acNum	an account number
	* @param acPIN	a pin number
	* @returns		the AccountInfo created
    */
	private static AccountInfo getAccountInfo( int acNum, int acPIN )
	{
		AccountInfo ai = new AccountInfo();
		ai.number = acNum;	ai.pin = acPIN;

		return ai;
	}




	/* Tests (copied from project handout) */

   public static void testATM(ATM atm) {
      if (atm!=null) {
         printBalances(atm);
         performTestOne(atm);
         performTestTwo(atm);
         performTestThree(atm);
         performTestFour(atm);
         performTestFive(atm);
         performTestSix(atm);
         performTestSeven(atm);
         performTestEight(atm);
         performTestNine(atm);
         printBalances(atm);
      }
   }
   public static void printBalances(ATM atm) {
      try {
         System.out.println("Balance(0000001): "+atm.getBalance(getAccountInfo(0000001, 1234)));
         System.out.println("Balance(0000002): "+atm.getBalance(getAccountInfo(0000002, 2345)));
         System.out.println("Balance(0000003): "+atm.getBalance(getAccountInfo(0000003, 3456)));
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   public static void performTestOne(ATM atm) {
      try {
         atm.getBalance(getAccountInfo(0000001, 5555));
      } catch (Exception e) {
         System.out.println("Failed as expected: "+e);
      }
   }
   public static void performTestTwo(ATM atm) {
      try {
         atm.withdraw(getAccountInfo(0000002, 2345), 500);
      } catch (Exception e) {
         System.out.println("Failed as expected: "+e);
      }
   }
   public static void performTestThree(ATM atm) {
      try {
         atm.withdraw(getAccountInfo(0000001, 1234), 50);
      } catch (Exception e) {
         System.out.println("Failed as expected: "+e);
      }
   }
   public static void performTestFour(ATM atm) {
      try {
         atm.deposit(getAccountInfo(0000001, 1234), 500);
      } catch (Exception e) {
         System.out.println("Unexpected error: "+e);
      }
   }
   public static void performTestFive(ATM atm) {
      try {
         atm.deposit(getAccountInfo(0000002, 2345), 100);
      } catch (Exception e) {
         System.out.println("Unexpected error: "+e);
      }
   }
   public static void performTestSix(ATM atm) {
      try {
         atm.withdraw(getAccountInfo(0000001, 1234), 100);
      } catch (Exception e) {
         System.out.println("Unexpected error: "+e);
      }
   }
   public static void performTestSeven(ATM atm) {
      try {
         atm.withdraw(getAccountInfo(0000003, 3456), 300);
      } catch (Exception e) {
         System.out.println("Unexpected error: "+e);
      }
   }
   public static void performTestEight(ATM atm) {
      try {
         atm.withdraw(getAccountInfo(0000001, 1234), 200);
      } catch (Exception e) {
         System.out.println("Failed as expected: "+e);
      }
   }
   public static void performTestNine(ATM atm) {
      try {
         atm.transfer(getAccountInfo(0000001, 1234),getAccountInfo(0000002, 2345), 100);
      } catch (Exception e) {
         System.out.println("Unexpected error: "+e);
      }
   }


}