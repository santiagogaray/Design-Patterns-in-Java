/**
 * Title:        	Final Project: BankServant class
 * Description:  	Remote object that hosts the accounts.
 *					Used by the ATM to obtain accounts'
 *					references.
 *
 * @author			Santiago Garay
 * @version 		%I% , %G%
 */

package cscie160.project;

import java.util.*;

public class BankServant extends _BankImplBase{

 	private HashMap _theAccounts = new HashMap();

	/**
  	* Default constructor.
    * Creates accounts with
    * predifined values.
    *
    * @throws AccountException
  	*/
    public BankServant()
		throws AccountException
    {
    	super();
    	createAccounts();
    }

	/**
    * Creates the required 3 accounts
    * with the specified balance.
    *
    * @throws AccountException
    */
	private void createAccounts()
 		throws AccountException
  	{
		Account account;

  		account = new AccountServant( 1, 0 );
  		_theAccounts.put( new Integer(1), account );

  		account = new AccountServant( 2, 100 );
      	_theAccounts.put( new Integer(2), account );;

		account = new AccountServant( 3, 500 );
		_theAccounts.put( new Integer(3), account );
  	}

  	/**
    * Retrieves an account
    * matching the account id number
    *
    * @param accInfo	the account info of the
    * 					account to be retrieved.
    *
    * @return			an Account reference.
    *
    * @throws AccountException
    */
   	public Account getAccount( AccountInfo accInfo )
    	throws AccountException
	{
		/* create a key */
		Integer accKey = new Integer( accInfo.number );

		/* return the requested account or throw exception */
    	if ( _theAccounts.containsKey( accKey ) )
         	return (Account) _theAccounts.get( accKey );
		else
			throw new AccountException
   				("error: Account not found in Bank");
    }
}