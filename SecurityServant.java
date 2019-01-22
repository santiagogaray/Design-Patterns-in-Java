/**
 * Title:        	Final Project: SecurityServant class
 * Description:  	Remote object used by the ATM to
 *					validate account information and
 *				 	operations.
 *
 * @author			Santiago Garay
 * @version 		%I% , %G%
 */

package cscie160.project;

import java.util.*;

public class SecurityServant extends _SecurityImplBase{

	/* map of AccountSecData objects */
	private HashMap accSecurityMap = new HashMap();

   /** Parameterless constructor
	 * Intializes accSecurityMap with
	 * specified accounts' security
	 * data.
	 */
    public SecurityServant()
	{
		super();
		createSecurityValues();
    }

    /**
    * Verifies if the account number and pin
	* number are valid.
    * @param AccountInfo	a data object holding
    *						the account number and pin
	* @returns				a boolean indicating the result
	*						of the verification
	* @throws _SecurityException thrown by the security service
	*							 in case the account is not valid
    */
	public boolean authenticateAccount( AccountInfo accInfo )
		throws _SecurityException
	{
		/* make key */
		Integer accKey = new Integer( accInfo.number );

		/* check if account exists */
    	if ( accSecurityMap.containsKey( accKey ) ) {
			/* get account's security data from hash */
			AccountSecData asd =
				(AccountSecData)accSecurityMap.get( accKey );
			/* check the pin and return result*/
			return asd.checkPIN( accInfo.pin );
		/* invalid data */
		} else
			throw new _SecurityException
   				("error: Account not registered in security service");
	}

    /**
    * Verifies if the specific operation
	* is valid on the account.
    * @param AccountInfo	a data object holding
    *						the account number and pin
	* @returns				a boolean indicating the result
	*						of the verification
	* @throws _SecurityException thrown by the security service
	*							 in case the account or the
	*							 the operation is not valid.
    */
	public boolean authorizeOperation
		( AccountInfo accInfo, String operation )
		throws _SecurityException
	{
		/* make key */
		Integer accKey = new Integer( accInfo.number );

		/* check if account exists */
		if ( accSecurityMap.containsKey( accKey ) ) {
			/* get account's security data from hash */
			AccountSecData asd =
				(AccountSecData) accSecurityMap.get( accKey );
			/* return the specified operation auth. state */
			if ( operation.equals("Deposit") )
				return asd.getDepositAuthState();
			if ( operation.equals("Withdraw") )
				return asd.getWithdrawAuthState();
			if ( operation.equals("Balance") )
				return asd.getBalanceAuthState();
			/* invlalid data */
			throw new _SecurityException ("error: operation not defined");
		} else
			throw new _SecurityException
				("error: Account not registered in security service");
	}

    /**
    * Creates accounts' security data objects
	* and stores them in the accounts security map.
    */
	private void createSecurityValues()
	{
		AccountSecData accSec;
		accSec = new AccountSecData( 1234, true, true, true );
		accSecurityMap.put ( new Integer(1), accSec );

		accSec = new AccountSecData( 2345, true, false, true );
		accSecurityMap.put ( new Integer(2), accSec );

		accSec = new AccountSecData( 3456, false, true, true );
		accSecurityMap.put ( new Integer(3), accSec );
	}

}