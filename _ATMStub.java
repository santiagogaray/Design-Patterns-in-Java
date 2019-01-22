/*
 * File: ./CSCIE160/PROJECT/_ATMSTUB.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public class _ATMStub
	extends org.omg.CORBA.portable.ObjectImpl
    	implements cscie160.project.ATM {

    public _ATMStub(org.omg.CORBA.portable.Delegate d) {
          super();
          _set_delegate(d);
    }

    private static final String _type_ids[] = {
        "IDL:cscie160/project/ATM:1.0"
    };

    public String[] _ids() { return (String[]) _type_ids.clone(); }

    //	IDL operations
    //	    Implementation of ::cscie160::project::ATM::addATMListener
    public void addATMListener(cscie160.project.ATMListener atml)
 {
           org.omg.CORBA.Request r = _request("addATMListener");
           org.omg.CORBA.Any _atml = r.add_in_arg();
           cscie160.project.ATMListenerHelper.insert(_atml, atml);
           r.invoke();
   }
    //	    Implementation of ::cscie160::project::ATM::deposit
    public void deposit(cscie160.project.AccountInfo accInfo, float amount)
        throws cscie160.project.AccountException, cscie160.project._SecurityException {
           org.omg.CORBA.Request r = _request("deposit");
           org.omg.CORBA.Any _accInfo = r.add_in_arg();
           cscie160.project.AccountInfoHelper.insert(_accInfo, accInfo);
           org.omg.CORBA.Any _amount = r.add_in_arg();
           _amount.insert_float(amount);
           r.exceptions().add(cscie160.project.AccountExceptionHelper.type());
           r.exceptions().add(cscie160.project._SecurityExceptionHelper.type());
           r.invoke();
           java.lang.Exception __ex = r.env().exception();
           if (__ex instanceof org.omg.CORBA.UnknownUserException) {
               org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
               if (__userEx.except.type().equals(cscie160.project.AccountExceptionHelper.type())) {
                   throw cscie160.project.AccountExceptionHelper.extract(__userEx.except);
               }
               if (__userEx.except.type().equals(cscie160.project._SecurityExceptionHelper.type())) {
                   throw cscie160.project._SecurityExceptionHelper.extract(__userEx.except);
               }
           }
   }
    //	    Implementation of ::cscie160::project::ATM::withdraw
    public void withdraw(cscie160.project.AccountInfo accInfo, float amount)
        throws cscie160.project.AccountException, cscie160.project._SecurityException, cscie160.project.ATMException {
           org.omg.CORBA.Request r = _request("withdraw");
           org.omg.CORBA.Any _accInfo = r.add_in_arg();
           cscie160.project.AccountInfoHelper.insert(_accInfo, accInfo);
           org.omg.CORBA.Any _amount = r.add_in_arg();
           _amount.insert_float(amount);
           r.exceptions().add(cscie160.project.AccountExceptionHelper.type());
           r.exceptions().add(cscie160.project._SecurityExceptionHelper.type());
           r.exceptions().add(cscie160.project.ATMExceptionHelper.type());
           r.invoke();
           java.lang.Exception __ex = r.env().exception();
           if (__ex instanceof org.omg.CORBA.UnknownUserException) {
               org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
               if (__userEx.except.type().equals(cscie160.project.AccountExceptionHelper.type())) {
                   throw cscie160.project.AccountExceptionHelper.extract(__userEx.except);
               }
               if (__userEx.except.type().equals(cscie160.project._SecurityExceptionHelper.type())) {
                   throw cscie160.project._SecurityExceptionHelper.extract(__userEx.except);
               }
               if (__userEx.except.type().equals(cscie160.project.ATMExceptionHelper.type())) {
                   throw cscie160.project.ATMExceptionHelper.extract(__userEx.except);
               }
           }
   }
    //	    Implementation of ::cscie160::project::ATM::transfer
    public void transfer(cscie160.project.AccountInfo fromAccInfo, cscie160.project.AccountInfo toAccInfo, float amount)
        throws cscie160.project.AccountException, cscie160.project._SecurityException {
           org.omg.CORBA.Request r = _request("transfer");
           org.omg.CORBA.Any _fromAccInfo = r.add_in_arg();
           cscie160.project.AccountInfoHelper.insert(_fromAccInfo, fromAccInfo);
           org.omg.CORBA.Any _toAccInfo = r.add_in_arg();
           cscie160.project.AccountInfoHelper.insert(_toAccInfo, toAccInfo);
           org.omg.CORBA.Any _amount = r.add_in_arg();
           _amount.insert_float(amount);
           r.exceptions().add(cscie160.project.AccountExceptionHelper.type());
           r.exceptions().add(cscie160.project._SecurityExceptionHelper.type());
           r.invoke();
           java.lang.Exception __ex = r.env().exception();
           if (__ex instanceof org.omg.CORBA.UnknownUserException) {
               org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
               if (__userEx.except.type().equals(cscie160.project.AccountExceptionHelper.type())) {
                   throw cscie160.project.AccountExceptionHelper.extract(__userEx.except);
               }
               if (__userEx.except.type().equals(cscie160.project._SecurityExceptionHelper.type())) {
                   throw cscie160.project._SecurityExceptionHelper.extract(__userEx.except);
               }
           }
   }
    //	    Implementation of ::cscie160::project::ATM::getBalance
    public float getBalance(cscie160.project.AccountInfo accInfo)
        throws cscie160.project.AccountException, cscie160.project._SecurityException {
           org.omg.CORBA.Request r = _request("getBalance");
           r.set_return_type(org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_float));
           org.omg.CORBA.Any _accInfo = r.add_in_arg();
           cscie160.project.AccountInfoHelper.insert(_accInfo, accInfo);
           r.exceptions().add(cscie160.project.AccountExceptionHelper.type());
           r.exceptions().add(cscie160.project._SecurityExceptionHelper.type());
           r.invoke();
           java.lang.Exception __ex = r.env().exception();
           if (__ex instanceof org.omg.CORBA.UnknownUserException) {
               org.omg.CORBA.UnknownUserException __userEx = (org.omg.CORBA.UnknownUserException) __ex;
               if (__userEx.except.type().equals(cscie160.project.AccountExceptionHelper.type())) {
                   throw cscie160.project.AccountExceptionHelper.extract(__userEx.except);
               }
               if (__userEx.except.type().equals(cscie160.project._SecurityExceptionHelper.type())) {
                   throw cscie160.project._SecurityExceptionHelper.extract(__userEx.except);
               }
           }
           float __result;
           __result = r.return_value().extract_float();
           return __result;
   }

};
