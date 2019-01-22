/*
 * File: ./CSCIE160/PROJECT/_SECURITYSTUB.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public class _SecurityStub
	extends org.omg.CORBA.portable.ObjectImpl
    	implements cscie160.project.Security {

    public _SecurityStub(org.omg.CORBA.portable.Delegate d) {
          super();
          _set_delegate(d);
    }

    private static final String _type_ids[] = {
        "IDL:cscie160/project/Security:1.0"
    };

    public String[] _ids() { return (String[]) _type_ids.clone(); }

    //	IDL operations
    //	    Implementation of ::cscie160::project::Security::authenticateAccount
    public boolean authenticateAccount(cscie160.project.AccountInfo accInfo)
        throws cscie160.project._SecurityException {
           org.omg.CORBA.Request r = _request("authenticateAccount");
           r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_boolean));
           org.omg.CORBA.Any _accInfo = r.add_in_arg();
           cscie160.project.AccountInfoHelper.insert(_accInfo, accInfo);
           r.exceptions().add(cscie160.project._SecurityExceptionHelper.type());
           r.invoke();
           java.lang.Exception __ex = r.env().exception();
           if (__ex instanceof org.omg.CORBA.UnknownUserException) {
               org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
               if (__userEx.except.type().equals(cscie160.project._SecurityExceptionHelper.type())) {
                   throw cscie160.project._SecurityExceptionHelper.extract(__userEx.except);
               }
           }
           boolean __result;
           __result = r.return_value().extract_boolean();
           return __result;
   }
    //	    Implementation of ::cscie160::project::Security::authorizeOperation
    public boolean authorizeOperation(cscie160.project.AccountInfo accInfo, String operation)
        throws cscie160.project._SecurityException {
           org.omg.CORBA.Request r = _request("authorizeOperation");
           r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_boolean));
           org.omg.CORBA.Any _accInfo = r.add_in_arg();
           cscie160.project.AccountInfoHelper.insert(_accInfo, accInfo);
           org.omg.CORBA.Any _operation = r.add_in_arg();
           _operation.insert_string(operation);
           r.exceptions().add(cscie160.project._SecurityExceptionHelper.type());
           r.invoke();
           java.lang.Exception __ex = r.env().exception();
           if (__ex instanceof org.omg.CORBA.UnknownUserException) {
               org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
               if (__userEx.except.type().equals(cscie160.project._SecurityExceptionHelper.type())) {
                   throw cscie160.project._SecurityExceptionHelper.extract(__userEx.except);
               }
           }
           boolean __result;
           __result = r.return_value().extract_boolean();
           return __result;
   }

};
