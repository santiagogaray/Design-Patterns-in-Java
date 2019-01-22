/*
 * File: ./CSCIE160/PROJECT/BANKHOLDER.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public final class BankHolder
     implements org.omg.CORBA.portable.Streamable{
    //	instance variable 
    public cscie160.project.Bank value;
    //	constructors 
    public BankHolder() {
	this(null);
    }
    public BankHolder(cscie160.project.Bank __arg) {
	value = __arg;
    }

    public void _write(org.omg.CORBA.portable.OutputStream out) {
        cscie160.project.BankHelper.write(out, value);
    }

    public void _read(org.omg.CORBA.portable.InputStream in) {
        value = cscie160.project.BankHelper.read(in);
    }

    public org.omg.CORBA.TypeCode _type() {
        return cscie160.project.BankHelper.type();
    }
}
