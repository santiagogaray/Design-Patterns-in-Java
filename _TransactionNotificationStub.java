/*
 * File: ./CSCIE160/PROJECT/_TRANSACTIONNOTIFICATIONSTUB.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public class _TransactionNotificationStub
	extends org.omg.CORBA.portable.ObjectImpl
    	implements cscie160.project.TransactionNotification {

    public _TransactionNotificationStub(org.omg.CORBA.portable.Delegate d) {
          super();
          _set_delegate(d);
    }

    private static final String _type_ids[] = {
        "IDL:cscie160/project/TransactionNotification:1.0"
    };

    public String[] _ids() { return (String[]) _type_ids.clone(); }

    //	IDL operations
    //	    Implementation of ::cscie160::project::TransactionNotification::getDescription
    public String getDescription()
 {
           org.omg.CORBA.Request r = _request("getDescription");
           r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
           r.invoke();
           String __result;
           __result = r.return_value().extract_string();
           return __result;
   }

};
