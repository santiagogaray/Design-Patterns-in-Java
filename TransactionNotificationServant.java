/**
 * Title:        	Final Project: TransactionNotificationServant class
 * Description:  	Data class used by the ATM to notify
 *				 	its atm listeners of the current
 *					transaction being processed.
 *					Holds specific data relative to the
 *					transaction performed.
 *
 * @author			Santiago Garay
 * @version 		%I% , %G%
 */

package cscie160.project;

public class TransactionNotificationServant
	extends _TransactionNotificationImplBase
{
	/* transaction data */
	private String operation;
	private int accNumber;
	private float amount;

   /**
    * Constructor. Parameters are
	* required to define its state.
    *
    * @param op			The operation to notify
    * @param accNum		The account number involved
    * @param amount		The amount involved
    */
	public TransactionNotificationServant( String op, int accNum, float am)
	{
		super();
		operation = op;
		accNumber = accNum;
		amount = am;
	}

  	/**
    * Retrieves a brief description of
    * the transaction being performed.
    *
    * @return	a string containing the
	*			description
    */
	public String getDescription()
	{
		/* heading and general data */
		String description =   "----------Transaction Information--------" +
				"\n| Account number:\t" + accNumber + "\t\t|" +
				"\n| Operation:\t\t" + operation.substring(0,7) + "\t\t|";
		/* amount data */
		if (! operation.equals("Balance") )
			description += 	 "\n| Amount of operation:\t" + amount + " \t\t|";
		/* footer */
		description += 	     "\n-----------------------------------------";

		return description;
	}


}