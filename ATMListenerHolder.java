/*
 * File: ./CSCIE160/PROJECT/ATMLISTENERHOLDER.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public final class ATMListenerHolder
     implements org.omg.CORBA.portable.Streamable{
    //	instance variable 
    public cscie160.project.ATMListener value;
    //	constructors 
    public ATMListenerHolder() {
	this(null);
    }
    public ATMListenerHolder(cscie160.project.ATMListener __arg) {
	value = __arg;
    }

    public void _write(org.omg.CORBA.portable.OutputStream out) {
        cscie160.project.ATMListenerHelper.write(out, value);
    }

    public void _read(org.omg.CORBA.portable.InputStream in) {
        value = cscie160.project.ATMListenerHelper.read(in);
    }

    public org.omg.CORBA.TypeCode _type() {
        return cscie160.project.ATMListenerHelper.type();
    }
}
