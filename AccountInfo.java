/*
 * File: ./CSCIE160/PROJECT/ACCOUNTINFO.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public final class AccountInfo implements org.omg.CORBA.portable.IDLEntity {
    //	instance variables
    public int number;
    public int pin;
    //	constructors
    public AccountInfo() { }
    public AccountInfo(int __number, int __pin) {
	number = __number;
	pin = __pin;
    }
}
