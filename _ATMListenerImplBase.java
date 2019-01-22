/*
 * File: ./CSCIE160/PROJECT/_ATMLISTENERIMPLBASE.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public abstract class _ATMListenerImplBase extends org.omg.CORBA.DynamicImplementation implements cscie160.project.ATMListener {
    // Constructor
    public _ATMListenerImplBase() {
         super();
    }
    // Type strings for this class and its superclases
    private static final String _type_ids[] = {
        "IDL:cscie160/project/ATMListener:1.0"
    };

    public String[] _ids() { return (String[]) _type_ids.clone(); }

    private static java.util.Dictionary _methods = new java.util.Hashtable();
    static {
      _methods.put("handleNotification", new java.lang.Integer(0));
     }
    // DSI Dispatch call
    public void invoke(org.omg.CORBA.ServerRequest r) {
       switch (((java.lang.Integer) _methods.get(r.op_name())).intValue()) {
           case 0: // cscie160.project.ATMListener.handleNotification
              {
              org.omg.CORBA.NVList _list = _orb().create_list(0);
              org.omg.CORBA.Any _tn = _orb().create_any();
              _tn.type(cscie160.project.TransactionNotificationHelper.type());
              _list.add_value("tn", _tn, org.omg.CORBA.ARG_IN.value);
              r.params(_list);
              cscie160.project.TransactionNotification tn;
              tn = cscie160.project.TransactionNotificationHelper.extract(_tn);
                            this.handleNotification(tn);
              org.omg.CORBA.Any __return = _orb().create_any();
              __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
              r.result(__return);
              }
              break;
            default:
              throw new org.omg.CORBA.BAD_OPERATION(0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
       }
 }
}
