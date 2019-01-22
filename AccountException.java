/*
 * File: ./CSCIE160/PROJECT/ACCOUNTEXCEPTION.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public final class AccountException
	extends org.omg.CORBA.UserException implements org.omg.CORBA.portable.IDLEntity {
    //	instance variables
    public String message;
    //	constructors
    public AccountException() {
	super();
    }
    public AccountException(String __message) {
	super();
	message = __message;
    }
}
