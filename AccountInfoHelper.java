/*
 * File: ./CSCIE160/PROJECT/ACCOUNTINFOHELPER.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public class AccountInfoHelper {
     // It is useless to have instances of this class
     private AccountInfoHelper() { }

    public static void write(org.omg.CORBA.portable.OutputStream out, cscie160.project.AccountInfo that) {
	out.write_long(that.number);
	out.write_long(that.pin);
    }
    public static cscie160.project.AccountInfo read(org.omg.CORBA.portable.InputStream in) {
        cscie160.project.AccountInfo that = new cscie160.project.AccountInfo();
	that.number = in.read_long();
	that.pin = in.read_long();
        return that;
    }
   public static cscie160.project.AccountInfo extract(org.omg.CORBA.Any a) {
     org.omg.CORBA.portable.InputStream in = a.create_input_stream();
     return read(in);
   }
   public static void insert(org.omg.CORBA.Any a, cscie160.project.AccountInfo that) {
     org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
     write(out, that);
     a.read_value(out.create_input_stream(), type());
   }
   private static org.omg.CORBA.TypeCode _tc;
   synchronized public static org.omg.CORBA.TypeCode type() {
       int _memberCount = 2;
       org.omg.CORBA.StructMember[] _members = null;
          if (_tc == null) {
               _members= new org.omg.CORBA.StructMember[2];
               _members[0] = new org.omg.CORBA.StructMember(
                 "number",
                 org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_long),
                 null);

               _members[1] = new org.omg.CORBA.StructMember(
                 "pin",
                 org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.tk_long),
                 null);
             _tc = org.omg.CORBA.ORB.init().create_struct_tc(id(), "AccountInfo", _members);
          }
      return _tc;
   }
   public static String id() {
       return "IDL:cscie160/project/AccountInfo:1.0";
   }
}
