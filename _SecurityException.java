/*
 * File: ./CSCIE160/PROJECT/_SECURITYEXCEPTION.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public final class _SecurityException
	extends org.omg.CORBA.UserException implements org.omg.CORBA.portable.IDLEntity {
    //	instance variables
    public String message;
    //	constructors
    public _SecurityException() {
	super();
    }
    public _SecurityException(String __message) {
	super();
	message = __message;
    }
}
