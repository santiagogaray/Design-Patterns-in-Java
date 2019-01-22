/*
 * File: ./CSCIE160/PROJECT/ATM.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public interface ATM
    extends org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity {
    void addATMListener(cscie160.project.ATMListener atml)
;
    void deposit(cscie160.project.AccountInfo accInfo, float amount)
        throws cscie160.project.AccountException, cscie160.project._SecurityException;
    void withdraw(cscie160.project.AccountInfo accInfo, float amount)
        throws cscie160.project.AccountException, cscie160.project._SecurityException, cscie160.project.ATMException;
    void transfer(cscie160.project.AccountInfo fromAccInfo, cscie160.project.AccountInfo toAccInfo, float amount)
        throws cscie160.project.AccountException, cscie160.project._SecurityException;
    float getBalance(cscie160.project.AccountInfo accInfo)
        throws cscie160.project.AccountException, cscie160.project._SecurityException;
}
