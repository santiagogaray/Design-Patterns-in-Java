/*
 * File: ./CSCIE160/PROJECT/BANK.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public interface Bank
    extends org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity {
    cscie160.project.Account getAccount(cscie160.project.AccountInfo accInfo)
        throws cscie160.project.AccountException;
}
