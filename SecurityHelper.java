/*
 * File: ./CSCIE160/PROJECT/SECURITYHELPER.JAVA
 * From: CSCIE160.PROJECT.ATM.IDL
 * Date: Mon May 07 19:48:36 2001
 *   By: idltojava Java IDL 1.2 Aug 18 1998 16:25:34
 */

package cscie160.project;
public class SecurityHelper {
     // It is useless to have instances of this class
     private SecurityHelper() { }

    public static void write(org.omg.CORBA.portable.OutputStream out, cscie160.project.Security that) {
        out.write_Object(that);
    }
    public static cscie160.project.Security read(org.omg.CORBA.portable.InputStream in) {
        return cscie160.project.SecurityHelper.narrow(in.read_Object());
    }
   public static cscie160.project.Security extract(org.omg.CORBA.Any a) {
     org.omg.CORBA.portable.InputStream in = a.create_input_stream();
     return read(in);
   }
   public static void insert(org.omg.CORBA.Any a, cscie160.project.Security that) {
     org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
     write(out, that);
     a.read_value(out.create_input_stream(), type());
   }
   private static org.omg.CORBA.TypeCode _tc;
   synchronized public static org.omg.CORBA.TypeCode type() {
          if (_tc == null)
             _tc = org.omg.CORBA.ORB.init().create_interface_tc(id(), "Security");
      return _tc;
   }
   public static String id() {
       return "IDL:cscie160/project/Security:1.0";
   }
   public static cscie160.project.Security narrow(org.omg.CORBA.Object that)
	    throws org.omg.CORBA.BAD_PARAM {
        if (that == null)
            return null;
        if (that instanceof cscie160.project.Security)
            return (cscie160.project.Security) that;
	if (!that._is_a(id())) {
	    throw new org.omg.CORBA.BAD_PARAM();
	}
        org.omg.CORBA.portable.Delegate dup = ((org.omg.CORBA.portable.ObjectImpl)that)._get_delegate();
        cscie160.project.Security result = new cscie160.project._SecurityStub(dup);
        return result;
   }
}
