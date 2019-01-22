/**
 * Title:        	Final Project: ATMFactoryServant class
 * Description:  	Serves as a remotable class used
 * 					by Client. It's only purpose is to
 * 					retrieve ATMServant objects via
 * 					distributed processes.
 *
 * @author			Santiago Garay
 * @version 		%I% , %G%
 */

package cscie160.project;

public class ATMFactoryServant extends _ATMFactoryImplBase {
	/**
    * Parameterless constructor
    */
    public ATMFactoryServant() {
    	super();
    }
	/**
    * Creates and retrives an ATMServant object. Used
    * by remote calls invoked by Client.
    *
    * @return 	the ATMServant created.
    */
    public ATM getATM() {
    	ATMServant retATM = new ATMServant();
        return retATM;
    }
    /**
     * Used to test ATM without a
     * remote connection.
     */
    public static void main(String args[]) {
    	try {
    		ATMFactoryServant factory = new ATMFactoryServant();
     		ATM atm = factory.getATM();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}