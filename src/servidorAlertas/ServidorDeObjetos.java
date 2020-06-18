package servidorAlertas;

import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import servidorAlertas.sop_corba.GestionAsintomaticos;
import servidorAlertas.sop_corba.GestionAsintomaticosImpl;
import servidorAlertas.sop_corba.GestionAsintomaticosPOATie;

public class ServidorDeObjetos {

  public static void main(String args[]) {
    try{
        System.out.println("1. Crea e inicia el orb");
        ORB orb = ORB.init(args, null);

        System.out.println("2. Obtiene la referencia al poa raiz, por medio del orb ");
        org.omg.CORBA.Object objPOA = null;
        objPOA=orb.resolve_initial_references("RootPOA");
        POA rootPOA = POAHelper.narrow(objPOA);

        System.out.println("3. Activa el POAManager");
        rootPOA.the_POAManager().activate();

               
        System.out.println("4. Crea el objeto servant");
        GestionAsintomaticosImpl ObjServant = new GestionAsintomaticosImpl();   
        
        System.out.println("5. Crea el objeto tie y se registra una referencia al objeto servant mediante el contructor");
        GestionAsintomaticosPOATie objTIE= new GestionAsintomaticosPOATie(ObjServant);

        System.out.println("6. Obtiene la referencia al orb ");
        GestionAsintomaticos referenciaORB = objTIE._this(orb);

        System.out.println("7. Obtiene una referencia al n_s del orb");
        org.omg.CORBA.Object objRefNameService = orb.resolve_initial_references("NameService");

        System.out.println("8. Convierte la ref genérica a ref de NamingContextExt");
        NamingContextExt refContextoNombrado = NamingContextExtHelper.narrow(objRefNameService);

        System.out.println("9.Construir el identificador del servant");
       
        String name = "objAsintomatico";
        NameComponent path[] = refContextoNombrado.to_name( name );
        
        System.out.println("10.Realiza el binding de la referencia de objeto en el N_S");
        refContextoNombrado.rebind(path, referenciaORB);

        System.out.println("Consultando referencia remota...");
        ObjServant.consultarReferenciaRemota(refContextoNombrado, "objNotificaciones");
        
        System.out.println("El Servidor esta listo y esperando ...");
        orb.run();
    } 
	
      catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
	  
      System.out.println("Servidor: Saliendo ...");
	
  }
}
