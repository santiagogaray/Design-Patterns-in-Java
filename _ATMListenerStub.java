/*
 * File: ./CSCIE160/PROJECT/_ATMLISTENERSTUB.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public class _ATMListenerStub
	extends org.omg.CORBA.portable.ObjectImpl
    	implements cscie160.project.ATMListener {

    public _ATMListenerStub(org.omg.CORBA.portable.Delegate d) {
          super();
          _set_delegate(d);
    }

    private static final String _type_ids[] = {
        "IDL:cscie160/project/ATMListener:1.0"
    };

    public String[] _ids() { return (String[]) _type_ids.clone(); }

    //	IDL operations
    //	    Implementation of ::cscie160::project::ATMListener::handleNotification
    public void handleNotification(cscie160.project.TransactionNotification tn)
 {
           org.omg.CORBA.Request r = _request("handleNotification");
           org.omg.CORBA.Any _tn = r.add_in_arg();
           cscie160.project.TransactionNotificationHelper.insert(_tn, tn);
           r.invoke();
   }

};
