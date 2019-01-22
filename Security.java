/*
 * File: ./CSCIE160/PROJECT/SECURITY.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public interface Security
    extends org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity {
    boolean authenticateAccount(cscie160.project.AccountInfo accInfo)
        throws cscie160.project._SecurityException;
    boolean authorizeOperation(cscie160.project.AccountInfo accInfo, String operation)
        throws cscie160.project._SecurityException;
}
