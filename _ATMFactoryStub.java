/*
 * File: ./CSCIE160/PROJECT/_ATMFACTORYSTUB.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public class _ATMFactoryStub
	extends org.omg.CORBA.portable.ObjectImpl
    	implements cscie160.project.ATMFactory {

    public _ATMFactoryStub(org.omg.CORBA.portable.Delegate d) {
          super();
          _set_delegate(d);
    }

    private static final String _type_ids[] = {
        "IDL:cscie160/project/ATMFactory:1.0"
    };

    public String[] _ids() { return (String[]) _type_ids.clone(); }

    //	IDL operations
    //	    Implementation of ::cscie160::project::ATMFactory::getATM
    public cscie160.project.ATM getATM()
 {
           org.omg.CORBA.Request r = _request("getATM");
           r.set_return_type(cscie160.project.ATMHelper.type());
           r.invoke();
           cscie160.project.ATM __result;
           __result = cscie160.project.ATMHelper.extract(r.return_value());
           return __result;
   }

};
