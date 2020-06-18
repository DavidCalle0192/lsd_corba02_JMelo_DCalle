package servidorAlertas.sop_corba;


/**
* servidorAlertas/sop_corba/_GestionAsintomaticosStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from salertas.idl
* jueves 18 de junio de 2020 04:55:18 PM COT
*/

public class _GestionAsintomaticosStub extends org.omg.CORBA.portable.ObjectImpl implements servidorAlertas.sop_corba.GestionAsintomaticos
{

  public void registrarAsintomatico (servidorAlertas.sop_corba.GestionAsintomaticosPackage.asintomaticoDTO objDTO, org.omg.CORBA.BooleanHolder resultado)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("registrarAsintomatico", true);
                servidorAlertas.sop_corba.GestionAsintomaticosPackage.asintomaticoDTOHelper.write ($out, objDTO);
                $in = _invoke ($out);
                resultado.value = $in.read_boolean ();
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                registrarAsintomatico (objDTO, resultado        );
            } finally {
                _releaseReply ($in);
            }
  } // registrarAsintomatico

  public boolean enviarIndicador (int id, float ToC)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("enviarIndicador", true);
                $out.write_long (id);
                $out.write_float (ToC);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return enviarIndicador (id, ToC        );
            } finally {
                _releaseReply ($in);
            }
  } // enviarIndicador

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:servidorAlertas/sop_corba/GestionAsintomaticos:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _GestionAsintomaticosStub
