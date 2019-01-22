/*
 * File: ./CSCIE160/PROJECT/_BANKIMPLBASE.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public abstract class _BankImplBase extends org.omg.CORBA.DynamicImplementation implements cscie160.project.Bank {
    // Constructor
    public _BankImplBase() {
         super();
    }
    // Type strings for this class and its superclases
    private static final String _type_ids[] = {
        "IDL:cscie160/project/Bank:1.0"
    };

    public String[] _ids() { return (String[]) _type_ids.clone(); }

    private static java.util.Dictionary _methods = new java.util.Hashtable();
    static {
      _methods.put("getAccount", new java.lang.Integer(0));
     }
    // DSI Dispatch call
    public void invoke(org.omg.CORBA.ServerRequest r) {
       switch (((java.lang.Integer) _methods.get(r.op_name())).intValue()) {
           case 0: // cscie160.project.Bank.getAccount
              {
              org.omg.CORBA.NVList _list = _orb().create_list(0);
              org.omg.CORBA.Any _accInfo = _orb().create_any();
              _accInfo.type(cscie160.project.AccountInfoHelper.type());
              _list.add_value("accInfo", _accInfo, org.omg.CORBA.ARG_IN.value);
              r.params(_list);
              cscie160.project.AccountInfo accInfo;
              accInfo = cscie160.project.AccountInfoHelper.extract(_accInfo);
              cscie160.project.Account ___result;
              try {
                            ___result = this.getAccount(accInfo);
              }
              catch (cscie160.project.AccountException e0) {
                            org.omg.CORBA.Any _except = _orb().create_any();
                            cscie160.project.AccountExceptionHelper.insert(_except, e0);
                            r.except(_except);
                            return;
              }
              org.omg.CORBA.Any __result = _orb().create_any();
              cscie160.project.AccountHelper.insert(__result, ___result);
              r.result(__result);
              }
              break;
            default:
              throw new org.omg.CORBA.BAD_OPERATION(0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
       }
 }
}
