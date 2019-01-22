/*
 * File: ./CSCIE160/PROJECT/_ATMIMPLBASE.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public abstract class _ATMImplBase extends org.omg.CORBA.DynamicImplementation implements cscie160.project.ATM {
    // Constructor
    public _ATMImplBase() {
         super();
    }
    // Type strings for this class and its superclases
    private static final String _type_ids[] = {
        "IDL:cscie160/project/ATM:1.0"
    };

    public String[] _ids() { return (String[]) _type_ids.clone(); }

    private static java.util.Dictionary _methods = new java.util.Hashtable();
    static {
      _methods.put("addATMListener", new java.lang.Integer(0));
      _methods.put("deposit", new java.lang.Integer(1));
      _methods.put("withdraw", new java.lang.Integer(2));
      _methods.put("transfer", new java.lang.Integer(3));
      _methods.put("getBalance", new java.lang.Integer(4));
     }
    // DSI Dispatch call
    public void invoke(org.omg.CORBA.ServerRequest r) {
       switch (((java.lang.Integer) _methods.get(r.op_name())).intValue()) {
           case 0: // cscie160.project.ATM.addATMListener
              {
              org.omg.CORBA.NVList _list = _orb().create_list(0);
              org.omg.CORBA.Any _atml = _orb().create_any();
              _atml.type(cscie160.project.ATMListenerHelper.type());
              _list.add_value("atml", _atml, org.omg.CORBA.ARG_IN.value);
              r.params(_list);
              cscie160.project.ATMListener atml;
              atml = cscie160.project.ATMListenerHelper.extract(_atml);
                            this.addATMListener(atml);
              org.omg.CORBA.Any __return = _orb().create_any();
              __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
              r.result(__return);
              }
              break;
           case 1: // cscie160.project.ATM.deposit
              {
              org.omg.CORBA.NVList _list = _orb().create_list(0);
              org.omg.CORBA.Any _accInfo = _orb().create_any();
              _accInfo.type(cscie160.project.AccountInfoHelper.type());
              _list.add_value("accInfo", _accInfo, org.omg.CORBA.ARG_IN.value);
              org.omg.CORBA.Any _amount = _orb().create_any();
              _amount.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_float));
              _list.add_value("amount", _amount, org.omg.CORBA.ARG_IN.value);
              r.params(_list);
              cscie160.project.AccountInfo accInfo;
              accInfo = cscie160.project.AccountInfoHelper.extract(_accInfo);
              float amount;
              amount = _amount.extract_float();
              try {
                            this.deposit(accInfo, amount);
              }
              catch (cscie160.project.AccountException e0) {
                            org.omg.CORBA.Any _except = _orb().create_any();
                            cscie160.project.AccountExceptionHelper.insert(_except, e0);
                            r.except(_except);
                            return;
              }
              catch (cscie160.project._SecurityException e1) {
                            org.omg.CORBA.Any _except = _orb().create_any();
                            cscie160.project._SecurityExceptionHelper.insert(_except, e1);
                            r.except(_except);
                            return;
              }
              org.omg.CORBA.Any __return = _orb().create_any();
              __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
              r.result(__return);
              }
              break;
           case 2: // cscie160.project.ATM.withdraw
              {
              org.omg.CORBA.NVList _list = _orb().create_list(0);
              org.omg.CORBA.Any _accInfo = _orb().create_any();
              _accInfo.type(cscie160.project.AccountInfoHelper.type());
              _list.add_value("accInfo", _accInfo, org.omg.CORBA.ARG_IN.value);
              org.omg.CORBA.Any _amount = _orb().create_any();
              _amount.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_float));
              _list.add_value("amount", _amount, org.omg.CORBA.ARG_IN.value);
              r.params(_list);
              cscie160.project.AccountInfo accInfo;
              accInfo = cscie160.project.AccountInfoHelper.extract(_accInfo);
              float amount;
              amount = _amount.extract_float();
              try {
                            this.withdraw(accInfo, amount);
              }
              catch (cscie160.project.AccountException e0) {
                            org.omg.CORBA.Any _except = _orb().create_any();
                            cscie160.project.AccountExceptionHelper.insert(_except, e0);
                            r.except(_except);
                            return;
              }
              catch (cscie160.project._SecurityException e1) {
                            org.omg.CORBA.Any _except = _orb().create_any();
                            cscie160.project._SecurityExceptionHelper.insert(_except, e1);
                            r.except(_except);
                            return;
              }
              catch (cscie160.project.ATMException e2) {
                            org.omg.CORBA.Any _except = _orb().create_any();
                            cscie160.project.ATMExceptionHelper.insert(_except, e2);
                            r.except(_except);
                            return;
              }
              org.omg.CORBA.Any __return = _orb().create_any();
              __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
              r.result(__return);
              }
              break;
           case 3: // cscie160.project.ATM.transfer
              {
              org.omg.CORBA.NVList _list = _orb().create_list(0);
              org.omg.CORBA.Any _fromAccInfo = _orb().create_any();
              _fromAccInfo.type(cscie160.project.AccountInfoHelper.type());
              _list.add_value("fromAccInfo", _fromAccInfo, org.omg.CORBA.ARG_IN.value);
              org.omg.CORBA.Any _toAccInfo = _orb().create_any();
              _toAccInfo.type(cscie160.project.AccountInfoHelper.type());
              _list.add_value("toAccInfo", _toAccInfo, org.omg.CORBA.ARG_IN.value);
              org.omg.CORBA.Any _amount = _orb().create_any();
              _amount.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_float));
              _list.add_value("amount", _amount, org.omg.CORBA.ARG_IN.value);
              r.params(_list);
              cscie160.project.AccountInfo fromAccInfo;
              fromAccInfo = cscie160.project.AccountInfoHelper.extract(_fromAccInfo);
              cscie160.project.AccountInfo toAccInfo;
              toAccInfo = cscie160.project.AccountInfoHelper.extract(_toAccInfo);
              float amount;
              amount = _amount.extract_float();
              try {
                            this.transfer(fromAccInfo, toAccInfo, amount);
              }
              catch (cscie160.project.AccountException e0) {
                            org.omg.CORBA.Any _except = _orb().create_any();
                            cscie160.project.AccountExceptionHelper.insert(_except, e0);
                            r.except(_except);
                            return;
              }
              catch (cscie160.project._SecurityException e1) {
                            org.omg.CORBA.Any _except = _orb().create_any();
                            cscie160.project._SecurityExceptionHelper.insert(_except, e1);
                            r.except(_except);
                            return;
              }
              org.omg.CORBA.Any __return = _orb().create_any();
              __return.type(_orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
              r.result(__return);
              }
              break;
           case 4: // cscie160.project.ATM.getBalance
              {
              org.omg.CORBA.NVList _list = _orb().create_list(0);
              org.omg.CORBA.Any _accInfo = _orb().create_any();
              _accInfo.type(cscie160.project.AccountInfoHelper.type());
              _list.add_value("accInfo", _accInfo, org.omg.CORBA.ARG_IN.value);
              r.params(_list);
              cscie160.project.AccountInfo accInfo;
              accInfo = cscie160.project.AccountInfoHelper.extract(_accInfo);
              float ___result;
              try {
                            ___result = this.getBalance(accInfo);
              }
              catch (cscie160.project.AccountException e0) {
                            org.omg.CORBA.Any _except = _orb().create_any();
                            cscie160.project.AccountExceptionHelper.insert(_except, e0);
                            r.except(_except);
                            return;
              }
              catch (cscie160.project._SecurityException e1) {
                            org.omg.CORBA.Any _except = _orb().create_any();
                            cscie160.project._SecurityExceptionHelper.insert(_except, e1);
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
