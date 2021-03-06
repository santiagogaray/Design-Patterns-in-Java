/**
 * Title:        	Final Project: ATMServant class
 * Description:  	Serves as a remotable class used
 * 					by Client as a means of interfacing
 * 					remote account operations.
 *
 * @author			Santiago Garay
 * @version 		%I% , %G%
 */

package cscie160.project;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import java.util.*;


public class ATMServant extends _ATMImplBase{

	private float cashOnHand = 500;
	private boolean checkCashOnHand = true;
	/* ATM clients registered with this atm */
 	private Vector atmListeners = new Vector();
	/* remote references */
	private Security security=null;
	private Bank bank=null;

	/**
     * Parameterless constructor
	 * Initializes it bank and security
	 * remote references.
     */
	public ATMServant()
	{
		super();
		security = getNetSecurityRef( new String[0] );
		bank = getNetBankRef( new String[0] );
	}


    /**
    * Retrieves a Bank object reference used
    * by account operations.
    * @param args	array of strings used to
    *				initialize the orb.
	* @returns		a bank remote reference
    */
	private Bank getNetBankRef( String[] args )
	{
		try {
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
			NamingContext ctxt = NamingContextHelper.narrow(obj);
			NameComponent[] name = { new NameComponent("Bank", "") };
			bank = BankHelper.narrow(ctxt.resolve(name));
		} catch (Exception e) {
			System.out.println("error while looking for Bank reference");
			e.printStackTrace();
			System.exit(1);
		}
		return bank;
	}


    /**
    * Retrieves a Security object reference used
    * by account operations for validation.
    * @param args	array of strings used to
    *				initialize the orb.
	* @returns		a security remote reference
    */
	private Security getNetSecurityRef( String[] args )
	{
		try {
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
			NamingContext ctxt = NamingContextHelper.narrow(obj);
			NameComponent[] name = { new NameComponent("Security", "") };
			security = SecurityHelper.narrow(ctxt.resolve(name));
		} catch (Exception e) {
			System.out.println("error while looking for Service reference");
			e.printStackTrace();
			System.exit(1);
		}
		return security;
	}

    /**
    * Registers a specified listener to the
	* atm in order for them to receive the
	* transaction notifications.
    * @param ATMListener	the listener to
	* 						include in the list
    */
	public void addATMListener( ATMListener atml )
	{
		if (! atmListeners.contains(atml) )
			atmListeners.add(atml);
	}


    /**
    * Calls the notification handler of the
	* registered listeners and passes to them
	* the specified transaction information
	* data object.
    * @param TransactionInformation
	*				the transaction data currently
	*				in process by the atm.
    */
	private void distributeTransaction( TransactionNotification tn )
	{
		Iterator it = atmListeners.iterator();
		while (it.hasNext()) {
			ATMListener atml = (ATMListener) it.next();
			try {
				atml.handleNotification( tn );
			} catch (Exception ex) {
				System.out.println
					("error while performing notification callbacks");
				ex.printStackTrace();
			}
		}
	}

    /**
    * Adds an amount to an account
	* specified by its an accountInfo object.
	*
	* Steps:
	* -Notifies all registered listeners of
	*  the transaction.
    * -Authenticates the account data.
	* -Validates the operation to perform.
	* -Retrieves the account reference from
	*  the bank.
	* -Performs the operation.
	*
    * @param AccountInfo	the data object holding
    * 						the account id used to
	*						perform the operation.
    * @param amount			The amount to deposit
    *
    * @throws AccountException	 thrown by the account in case
	*							 ordinary errors are found in
	*							 the operation.
	* @throws _SecurityException thrown by the security service
	*							 in case specific invalid values
	*							 are found.
    */
   	public void deposit( AccountInfo accInfo, float amount )
    	throws AccountException, _SecurityException
    {
		Account theAccount = null;

		/* build and distribute notification */
		int accNum = accInfo.number;
		TransactionNotification tn =
			new TransactionNotificationServant( "Deposit", accNum, amount );
		distributeTransaction(tn);

		/* verify data and perform operation  or */
		/* throw exception */
		if ( security.authenticateAccount( accInfo ) ) {
			if ( security.authorizeOperation( accInfo, "Deposit" ) ) {
				/* perform operation or receive exception */
				/* from account */
				theAccount = bank.getAccount( accInfo );
  				theAccount.deposit( amount );
			}
			else
				throw new _SecurityException
   					("error: Operation not allowed in account");
		} else
			throw new _SecurityException
   				("error: Account is not valid");
    }


    /**
    * Withdraws an amount from an account
	* specified by its accountInfo object.
	*
	* Steps:
	* -Checks for cash availabilty in atm.
	* -Notifies all registered listeners of
	*  the transaction.
    * -Authenticates the account data.
	* -Validates the operation to perform.
	* -Retrieves the account reference from
	*  the bank.
	* -Performs the operation.
	*
    * @param AccountInfo	the data object holding
    * 						the account id used to
	*						perform the operation.
    * @param amount			The amount to withdraw
    *
    * @throws AccountException	 thrown by the account in case
	*							 ordinary errors are found in
	*							 the operation.
	* @throws _SecurityException thrown by the security service
	*							 in case specific invalid values
	*							 are found.
	* @throws ATMException 		 thrown by the atm in case there
	*							 is'nt enough cash for the operation.
    */
 	public void withdraw( AccountInfo accInfo, float amount )
  		throws AccountException, _SecurityException, ATMException
	{
		Account theAccount = null;

		/* checks for required cash in atm */
		if ( checkCashOnHand && amount > cashOnHand)
			throw new ATMException
   				("error: Not sufficient funds in ATM for operation");

		/* build and distribute notification */
		int accNum = accInfo.number;
		TransactionNotification tn =
			new TransactionNotificationServant( "Withdraw", accNum, amount );
		distributeTransaction(tn);

		/* verify data and perform operation  or */
		/* throw exception */
		if ( security.authenticateAccount( accInfo ) ) {
			if ( security.authorizeOperation( accInfo, "Withdraw" ) ) {
				/* perform operation or receive exception */
				/* from account */
				theAccount = bank.getAccount( accInfo );
  				theAccount.withdraw( amount );
				if ( checkCashOnHand ) {cashOnHand -= amount; }
			} else
				throw new _SecurityException
   					("error: Operation not allowed in account");
		} else
			throw new _SecurityException
   				("error: Account is not valid");
    }


    /**
    * Gets current balance from account.
	*
	* Steps:
	* -Notifies all registered listeners of
	*  the transaction.
    * -Authenticates the account data.
	* -Validates the operation to perform.
	* -Retrieves the account reference from
	*  the bank.
	* -Performs the operation.
	*
    * @param AccountInfo	the data object holding
    * 						the account id used to
	*						perform the operation.
    *
    * @throws AccountException	 thrown by the account in case
	*							 ordinary errors are found in
	*							 the operation.
	* @throws _SecurityException thrown by the security service
	*							 in case specific invalid values
	*							 are found.
    */
  	public float getBalance(  AccountInfo accInfo )
   		throws AccountException, _SecurityException
	{
		Account theAccount = null;

		/* build and distribute notification */
		int accNum = accInfo.number;
		TransactionNotification tn =
			new TransactionNotificationServant( "Balance", accNum, 0 );
		distributeTransaction(tn);

		/* verify data and perform operation  or */
		/* throw exception */
		if ( security.authenticateAccount( accInfo ) ) {
			if ( security.authorizeOperation( accInfo, "Balance" ) ) {
				/* perform operation or receive exception */
				/* from account */
				theAccount = bank.getAccount( accInfo );
  				return theAccount.getBalance();
			}
			else
				throw new AccountException
   					("error: Operation not allowed in account");
		} else
			throw new AccountException
   				("error: Account is not valid");

    }

    /**
	* Transfers an amount from one account
	* to another.
    * Withdraws an amount from an account
	* specified by its fromAccountInfo object.
	* Deposits the same amount in the
	* account specified by the toAccountInfo
	* object.
	*
    * @param fromAccountInfo	the data object holding
    * 							the account id used to
	*							perform the withdraw.
    * @param toAccountInfo		the data object holding
    * 							the account id used to
	*							perform the deposit.
	*
    * @param amount				The amount to transfer
    *
    * @throws AccountException	 thrown by the account in case
	*							 ordinary errors are found in
	*							 the operation.
	* @throws _SecurityException thrown by the security service
	*							 in case specific invalid values
	*							 are found.
    */
    public void transfer
		( AccountInfo fromAccInfo, AccountInfo toAccInfo, float amount )
  		throws AccountException, _SecurityException
	{
		/* avoid checking to and discount from atm cash	*/
		try {
			checkCashOnHand = false;
			withdraw(fromAccInfo, amount);
			checkCashOnHand = true;
		} catch (ATMException e) { }
		/* continue with transfer */
		deposit(toAccInfo, amount);
    }

}