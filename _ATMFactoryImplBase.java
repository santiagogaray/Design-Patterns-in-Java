/*
 * File: ./CSCIE160/PROJECT/_ATMFACTORYIMPLBASE.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public abstract class _ATMFactoryImplBase extends org.omg.CORBA.DynamicImplementation implements cscie160.project.ATMFactory {
    // Constructor
    public _ATMFactoryImplBase() {
         super();
    }
    // Type strings for this class and its superclases
    private static final String _type_ids[] = {
        "IDL:cscie160/project/ATMFactory:1.0"
    };

    public String[] _ids() { return (String[]) _type_ids.clone(); }

    private static java.util.Dictionary _methods = new java.util.Hashtable();
    static {
      _methods.put("getATM", new java.lang.Integer(0));
     }
    // DSI Dispatch call
    public void invoke(org.omg.CORBA.ServerRequest r) {
       switch (((java.lang.Integer) _methods.get(r.op_name())).intValue()) {
           case 0: // cscie160.project.ATMFactory.getATM
              {
              org.omg.CORBA.NVList _list = _orb().create_list(0);
              r.params(_list);
              cscie160.project.ATM ___result;
                            ___result = this.getATM();
              org.omg.CORBA.Any __result = _orb().create_any();
              cscie160.project.ATMHelper.insert(__result, ___result);
              r.result(__result);
              }
              break;
            default:
              throw new org.omg.CORBA.BAD_OPERATION(0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
       }
 }
}
