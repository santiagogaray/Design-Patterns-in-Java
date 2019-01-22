/**
 * Title:        	Final Project: Account class
 * Description:  	Holds the balance of the account
 * 					and implements basic account
 * 					operations.
 *
 * @author			Santiago Garay
 * @version 		%I% , %G%
 */

package cscie160.project;

public class AccountServant extends _AccountImplBase {

	private int _noAccount;
 	private float _balance;

   /**
  	* Default constructor
  	*/
    public AccountServant()
	{
    	super();
    	_noAccount = 1;
        _balance = 0;
    }

   /**
    * Creates an account using parameters
    * to define its initial state.
    *
    * @param noAccount		The account number
    * @param balance		the initial balance
    */
    public AccountServant( int noAccount, float balance)
	{
    	super();
    	_noAccount = noAccount;
    	_balance = balance;
    }

  	/**
    * Adds a specific amount to the
    * account's balance
    *
    * @param amount		The amount to deposit
    * @throws AccountException
    */
    public void deposit( float amount ) throws AccountException
	{
      	if ( amount < 0 )
    		throw new AccountException
      			("error: Amount must be positive");
    	_balance += amount;
    }

  	/**
    * Discounts a specific amount from the
    * account's balance
    *
    * @param amount		The amount to discount
    * @throws AccountException
    */
 	public void withdraw( float amount )
		throws AccountException
  	{
  		if ( _balance < amount )
    		throw new AccountException
      			("error: Amount is grater than actual balance");
        if ( amount < 0 )
    		throw new AccountException
      			("error: Amount must be positive");
  		_balance -= amount;
    }

  	/**
    * Retrieves the current balance of
    * the account.
    *
    * @return	a float representing the balance
    */
  	public float getBalance()
	{
   		return _balance;
    }
}