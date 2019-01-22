/**
 * Title:        	Final Project: AccountSecData class
 * Description:  	A data class that holds all the
 *					required account data to perform
 *				 	security checking.
 *					Used by the SecurityServant object.
 *
 * @author			Santiago Garay
 * @version 		%I% , %G%
 */

package cscie160.project;

public class AccountSecData {

	private int PIN;
	private boolean depositAuthState;
	private boolean withdrawAuthState;
	private boolean balanceAuthState;

	/**
     * Constructor
	 * Initializes the validation states
	 *
     * @param pin	account's personal id number
	 * @param dep	account's deposit permit
	 * @param with	account's withdraw permit
	 * @param bal	account's balance permit
     */
	public AccountSecData ( int pin, boolean dep, boolean with, boolean bal)
	{
		PIN = pin;
		depositAuthState = dep;
		withdrawAuthState = with;
		balanceAuthState = bal;
	}


	/**
	 * Checks if the specified pin number equals
	 * this object pin number.
     * @param pin	a pin number
	 * @returns		a boolean indicating the result
	 *				of the checking operation.
     */
	public boolean checkPIN( int pin )
	{
		if ( PIN == pin ) return true;
			else return false;
	}

	/**
	 * Retrieves the deposit authorization state
	 * of this data object.
	 *
	 * @returns		a boolean indicating the state
	 *				of the authorization.
     */
	public boolean getDepositAuthState()
	{
		return depositAuthState;
	}

	/**
	 * Retrieves the withdraw authorization state
	 * of this data object.
	 *
	 * @returns		a boolean indicating the state
	 *				of the authorization.
     */
	public boolean getWithdrawAuthState()
	{
		return withdrawAuthState;
	}

	/**
	 * Retrieves the balance authorization state
	 * of this data object.
	 *
	 * @returns		a boolean indicating the state
	 *				of the authorization.
     */
	public boolean getBalanceAuthState()
	{
		return balanceAuthState;
	}

}