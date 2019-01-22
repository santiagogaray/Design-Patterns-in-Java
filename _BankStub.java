/*
 * File: ./CSCIE160/PROJECT/_BANKSTUB.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public class _BankStub
	extends org.omg.CORBA.portable.ObjectImpl
    	implements cscie160.project.Bank {

    public _BankStub(org.omg.CORBA.portable.Delegate d) {
          super();
          _set_delegate(d);
    }

    private static final String _type_ids[] = {
        "IDL:cscie160/project/Bank:1.0"
    };

    public String[] _ids() { return (String[]) _type_ids.clone(); }

    //	IDL operations
    //	    Implementation of ::cscie160::project::Bank::getAccount
    public cscie160.project.Account getAccount(cscie160.project.AccountInfo accInfo)
        throws cscie160.project.AccountException {
           org.omg.CORBA.Request r = _request("getAccount");
           r.set_return_type(cscie160.project.AccountHelper.type());
           org.omg.CORBA.Any _accInfo = r.add_in_arg();
           cscie160.project.AccountInfoHelper.insert(_accInfo, accInfo);
           r.exceptions().add(cscie160.project.AccountExceptionHelper.type());
           r.invoke();
           java.lang.Exception __ex = r.env().exception();
           if (__ex instanceof org.omg.CORBA.UnknownUserException) {
               org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
               if (__userEx.except.type().equals(cscie160.project.AccountExceptionHelper.type())) {
                   throw cscie160.project.AccountExceptionHelper.extract(__userEx.except);
               }
           }
           cscie160.project.Account __result;
           __result = cscie160.project.AccountHelper.extract(r.return_value());
           return __result;
   }

};
