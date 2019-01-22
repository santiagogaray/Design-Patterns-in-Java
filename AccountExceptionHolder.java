/*
 * File: ./CSCIE160/PROJECT/ACCOUNTEXCEPTIONHOLDER.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public final class AccountExceptionHolder
     implements org.omg.CORBA.portable.Streamable{
    //	instance variable 
    public cscie160.project.AccountException value;
    //	constructors 
    public AccountExceptionHolder() {
	this(null);
    }
    public AccountExceptionHolder(cscie160.project.AccountException __arg) {
	value = __arg;
    }

    public void _write(org.omg.CORBA.portable.OutputStream out) {
        cscie160.project.AccountExceptionHelper.write(out, value);
    }

    public void _read(org.omg.CORBA.portable.InputStream in) {
        value = cscie160.project.AccountExceptionHelper.read(in);
    }

    public org.omg.CORBA.TypeCode _type() {
        return cscie160.project.AccountExceptionHelper.type();
    }
}
