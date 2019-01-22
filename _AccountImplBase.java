/*
 * File: ./CSCIE160/PROJECT/_ACCOUNTIMPLBASE.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public abstract class _AccountImplBase extends org.omg.CORBA.DynamicImplementation implements cscie160.project.Account {
    // Constructor
    public _AccountImplBase() {
         super();
    }
    // Type strings for this class and its superclases
    private static final String _type_ids[] = {
        "IDL:cscie160/project/Account:1.0"
    };

    public String[] _ids() { return (String[]) _type_ids.clone(); }

    private static java.util.Dictionary _methods = new java.util.Hashtable();
    static {
      _methods.put("deposit", new java.lang.Integer(0));
      _methods.put("withdraw", new java.lang.Integer(1));
      _methods.put("getBalance", new java.lang.Integer(2));
     }
    // DSI Dispatch call
    public void invoke(org.omg.CORBA.ServerRequest r) {
       switch (((java.lang.Integer) _methods.get(r.op_name())).intValue()) {
           case 0: // cscie160.project.Account.deposit
              {
              org.omg.CORBA.NVList _list = _orb().create_list(0);
              org.omg.CORBA.Any _amount = _orb().create_any();
              _amount.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_float));
              _list.add_value("amount", _amount, org.omg.CORBA.ARG_IN.value);
              r.params(_list);
              float amount;
              amount = _amount.extract_float();
              try {
                            this.deposit(amount);
              }
              catch (cscie160.project.AccountException e0) {
                            org.omg.CORBA.Any _except = _orb().create_any();
                            cscie160.project.AccountExceptionHelper.insert(_except, e0);
                            r.except(_except);
                            return;
              }
              org.omg.CORBA.Any __return = _orb().create_any();
              __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
              r.result(__return);
              }
              break;
           case 1: // cscie160.project.Account.withdraw
              {
              org.omg.CORBA.NVList _list = _orb().create_list(0);
              org.omg.CORBA.Any _amount = _orb().create_any();
              _amount.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_float));
              _list.add_value("amount", _amount, org.omg.CORBA.ARG_IN.value);
              r.params(_list);
              float amount;
              amount = _amount.extract_float();
              try {
                            this.withdraw(amount);
              }
              catch (cscie160.project.AccountException e0) {
                            org.omg.CORBA.Any _except = _orb().create_any();
                            cscie160.project.AccountExceptionHelper.insert(_except, e0);
                            r.except(_except);
                            return;
              }
              org.omg.CORBA.Any __return = _orb().create_any();
              __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
              r.result(__return);
              }
              break;
           case 2: // cscie160.project.Account.getBalance
              {
              org.omg.CORBA.NVList _list = _orb().create_list(0);
              r.params(_list);
              float ___result;
              try {
                            ___result = this.getBalance();
              }
              catch (cscie160.project.AccountException e0) {
                            org.omg.CORBA.Any _except = _orb().create_any();
                            cscie160.project.AccountExceptionHelper.insert(_except, e0);
                            r.except(_except);
                            return;
              }
              org.omg.CORBA.Any __result = _orb().create_any();
              __result.insert_float(___result);
              r.result(__result);
              }
              break;
            default:
              throw new org.omg.CORBA.BAD_OPERATION(0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
       }
 }
}
