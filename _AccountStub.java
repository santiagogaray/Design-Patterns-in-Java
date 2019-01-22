/*
 * File: ./CSCIE160/PROJECT/_ACCOUNTSTUB.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public class _AccountStub
	extends org.omg.CORBA.portable.ObjectImpl
    	implements cscie160.project.Account {

    public _AccountStub(org.omg.CORBA.portable.Delegate d) {
          super();
          _set_delegate(d);
    }

    private static final String _type_ids[] = {
        "IDL:cscie160/project/Account:1.0"
    };

    public String[] _ids() { return (String[]) _type_ids.clone(); }

    //	IDL operations
    //	    Implementation of ::cscie160::project::Account::deposit
    public void deposit(float amount)
        throws cscie160.project.AccountException {
           org.omg.CORBA.Request r = _request("deposit");
           org.omg.CORBA.Any _amount = r.add_in_arg();
           _amount.insert_float(amount);
           r.exceptions().add(cscie160.project.AccountExceptionHelper.type());
           r.invoke();
           java.lang.Exception __ex = r.env().exception();
           if (__ex instanceof org.omg.CORBA.UnknownUserException) {
               org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
               if (__userEx.except.type().equals(cscie160.project.AccountExceptionHelper.type())) {
                   throw cscie160.project.AccountExceptionHelper.extract(__userEx.except);
               }
           }
   }
    //	    Implementation of ::cscie160::project::Account::withdraw
    public void withdraw(float amount)
        throws cscie160.project.AccountException {
           org.omg.CORBA.Request r = _request("withdraw");
           org.omg.CORBA.Any _amount = r.add_in_arg();
           _amount.insert_float(amount);
           r.exceptions().add(cscie160.project.AccountExceptionHelper.type());
           r.invoke();
           java.lang.Exception __ex = r.env().exception();
           if (__ex instanceof org.omg.CORBA.UnknownUserException) {
               org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
               if (__userEx.except.type().equals(cscie160.project.AccountExceptionHelper.type())) {
                   throw cscie160.project.AccountExceptionHelper.extract(__userEx.except);
               }
           }
   }
    //	    Implementation of ::cscie160::project::Account::getBalance
    public float getBalance()
        throws cscie160.project.AccountException {
           org.omg.CORBA.Request r = _request("getBalance");
           r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_float));
           r.exceptions().add(cscie160.project.AccountExceptionHelper.type());
           r.invoke();
           java.lang.Exception __ex = r.env().exception();
           if (__ex instanceof org.omg.CORBA.UnknownUserException) {
               org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
               if (__userEx.except.type().equals(cscie160.project.AccountExceptionHelper.type())) {
                   throw cscie160.project.AccountExceptionHelper.extract(__userEx.except);
               }
           }
           float __result;
           __result = r.return_value().extract_float();
           return __result;
   }

};
