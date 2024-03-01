package paquete.crudHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class AccesoBD {

	 private SessionFactory sf;
	 private Session sesion;
	 private Transaction transaction;
	    
	 protected void setUp() {
	        
		 final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	                .configure() // por defecto: hibernate.cfg.xml
	                .build();
	       try {
	    	   sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	    	   
	        }
	        catch (Exception e) {
	            StandardServiceRegistryBuilder.destroy( registry );
	        }
	    }
	    public void abrir() throws Exception {
	        setUp();
	        sesion=sf.openSession();
	        if (sesion.isOpen()) {
	            // La conexión está abierta
	        	System.out.println("Se ha establecido la conexión con la base de datos");
	        } else {
	            System.out.println("La conexión no se pudo establecer");
	        }
	        transaction = sesion.beginTransaction();
	    }
	    public void cerrar(){
	        try {
	            transaction.commit();
	        }catch(Exception e){
	            transaction.rollback();
	        }
	        sf.close();
	        
	        if (sf.isOpen()) {
	            // La conexión está abierta
	        	System.out.println("Se ha establecido la conexión con la base de datos");
	        } else {
	            System.out.println("La conexión está cerrada");
	        }
	    }

	    public void guardar(Object cosa) {
	    	 try {
	    		 sesion.save(cosa);
		         transaction.commit();
		     }catch(Exception e){
		         transaction.rollback();
		     }
	        
	    }
	    
	    public void mostrarDatos (int id) throws Exception {
	    	
	    	Usuarios2 usuario=sesion.get(Usuarios2.class, id);
	    	
	    	//mostramos los datos
	    	System.out.println("Nombre: "+usuario.getNombre());
	    	System.out.println("Apellidos: "+usuario.getApellidos());
	    	System.out.println("Nombre de usuario: "+usuario.getUsername());
	    	System.out.println("Contraseña: "+usuario.getPassword());
	    	System.out.println("Correo: "+usuario.getEmail());
	    	
	    }
	    
	    public void modificar (int id, String res, String datoN) throws Exception {
	    	
	    	 try {
	    		 Usuarios2 usuario=sesion.get(Usuarios2.class, id);
	    		 
	    		 switch (res) {
	    		 
	    		 case "nombre": {
	    			 usuario.setNombre(datoN); 
	    		 }
	    		 
	    		 case "apellidos":{
	    			 usuario.setApellidos(datoN);
	    		 }
	    		 case "nombre de usuario":{
	    			 usuario.setUsername(datoN);
	    		 }
	    		 case "contraseña":{
	    			 usuario.setPassword(datoN);
	    		 }
	    		 case "correo":{
	    			 usuario.setEmail(datoN);
	    		 }
	    		 
	    		 }
	    		 
	    		 //hacemos el update.
	    		 sesion.update(usuario);
	    		 
		         transaction.commit();
		         
		        System.out.println("Este usuario ha sido modificado correctamente.");
		         
		     }catch(Exception e){
		         transaction.rollback();
		     }
	    }
	    
	    
	    public void eliminar (int id) throws Exception {
	    	
	   	 try {
	   		 Usuarios2 usuario=sesion.get(Usuarios2.class, id);
    		 sesion.delete(usuario);
	         transaction.commit();
	         System.out.println("Este usuario se ha eliminado");
	     }catch(Exception e){
	         transaction.rollback();
	     }
	    	
	    }
}
