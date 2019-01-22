/*
 * File: ./CSCIE160/PROJECT/ACCOUNTEXCEPTIONHELPER.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public class AccountExceptionHelper {
     // It is useless to have instances of this class
     private AccountExceptionHelper() { }

    public static void write(org.omg.CORBA.portable.OutputStream out, cscie160.project.AccountException that) {
    out.write_string(id());

	out.write_string(that.message);
    }
    public static cscie160.project.AccountException read(org.omg.CORBA.portable.InputStream in) {
        cscie160.project.AccountException that = new cscie160.project.AccountException();
         // read and discard the repository id
        in.read_string();

	that.message = in.read_string();
    return that;
    }
   public static cscie160.project.AccountException extract(org.omg.CORBA.Any a) {
     org.omg.CORBA.portable.InputStream in = a.create_input_stream();
     return read(in);
   }
   public static void insert(org.omg.CORBA.Any a, cscie160.project.AccountException that) {
     org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
     write(out, that);
     a.read_value(out.create_input_stream(), type());
   }
   private static org.omg.CORBA.TypeCode _tc;
   synchronized public static org.omg.CORBA.TypeCode type() {
       int _memberCount = 1;
       org.omg.CORBA.StructMember[] _members = null;
          if (_tc == null) {
               _members= new org.omg.CORBA.StructMember[1];
               _members[0] = new org.omg.CORBA.StructMember(
                 "message",
                 org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_string),
                 null);
             _tc = org.omg.CORBA.ORB.init().create_exception_tc(id(), "AccountException", _members);
          }
      return _tc;
   }
   public static String id() {
       return "IDL:cscie160/project/AccountException:1.0";
   }
}
