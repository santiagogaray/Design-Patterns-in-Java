/*
 * File: ./CSCIE160/PROJECT/_SECURITYIMPLBASE.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public abstract class _SecurityImplBase extends org.omg.CORBA.DynamicImplementation implements cscie160.project.Security {
    // Constructor
    public _SecurityImplBase() {
         super();
    }
    // Type strings for this class and its superclases
    private static final String _type_ids[] = {
        "IDL:cscie160/project/Security:1.0"
    };

    public String[] _ids() { return (String[]) _type_ids.clone(); }

    private static java.util.Dictionary _methods = new java.util.Hashtable();
    static {
      _methods.put("authenticateAccount", new java.lang.Integer(0));
      _methods.put("authorizeOperation", new java.lang.Integer(1));
     }
    // DSI Dispatch call
    public void invoke(org.omg.CORBA.ServerRequest r) {
       switch (((java.lang.Integer) _methods.get(r.op_name())).intValue()) {
           case 0: // cscie160.project.Security.authenticateAccount
              {
              org.omg.CORBA.NVList _list = _orb().create_list(0);
              org.omg.CORBA.Any _accInfo = _orb().create_any();
              _accInfo.type(cscie160.project.AccountInfoHelper.type());
              _list.add_value("accInfo", _accInfo, org.omg.CORBA.ARG_IN.value);
              r.params(_list);
              cscie160.project.AccountInfo accInfo;
              accInfo = cscie160.project.AccountInfoHelper.extract(_accInfo);
              boolean ___result;
              try {
                            ___result = this.authenticateAccount(accInfo);
              }
              catch (cscie160.project._SecurityException e0) {
                            org.omg.CORBA.Any _except = _orb().create_any();
                            cscie160.project._SecurityExceptionHelper.insert(_except, e0);
                            r.except(_except);
                            return;
              }
              org.omg.CORBA.Any __result = _orb().create_any();
              __result.insert_boolean(___result);
              r.result(__result);
              }
              break;
           case 1: // cscie160.project.Security.authorizeOperation
              {
              org.omg.CORBA.NVList _list = _orb().create_list(0);
              org.omg.CORBA.Any _accInfo = _orb().create_any();
              _accInfo.type(cscie160.project.AccountInfoHelper.type());
              _list.add_value("accInfo", _accInfo, org.omg.CORBA.ARG_IN.value);
              org.omg.CORBA.Any _operation = _orb().create_any();
              _operation.type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
              _list.add_value("operation", _operation, org.omg.CORBA.ARG_IN.value);
              r.params(_list);
              cscie160.project.AccountInfo accInfo;
              accInfo = cscie160.project.AccountInfoHelper.extract(_accInfo);
              String operation;
              operation = _operation.extract_string();
              boolean ___result;
              try {
                            ___result = this.authorizeOperation(accInfo, operation);
              }
              catch (cscie160.project._SecurityException e0) {
                            org.omg.CORBA.Any _except = _orb().create_any();
                            cscie160.project._SecurityExceptionHelper.insert(_except, e0);
                            r.except(_except);
                            return;
              }
              org.omg.CORBA.Any __result = _orb().create_any();
              __result.insert_boolean(___result);
              r.result(__result);
              }
              break;
            default:
              throw new org.omg.CORBA.BAD_OPERATION(0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
       }
 }
}
