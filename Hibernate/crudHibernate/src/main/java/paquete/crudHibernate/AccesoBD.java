package paquete.crudHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;


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

	    public void guardar(Object cosa) throws Exception {
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
	    
	    public List<Usuarios2> listarUsuarios() throws Exception{
	    	
	    	List<Usuarios2> usuarios = null;
	    	try {
	    		
	    		String sql = "SELECT * FROM Usuarios2";
	            Query query = sesion.createNativeQuery(sql, Usuarios2.class);

	            usuarios = query.getResultList();

	           
	    	} catch (Exception e) {
	    		 transaction.rollback();
	    	}
	    	return usuarios;
	    }
	    
	    public void modificar (int id, String res, String datoN) throws Exception {
	    	
	    	try {
	            

	            // Utiliza una consulta HQL para actualizar el usuario
	            Query query = sesion.createQuery("UPDATE Usuarios2 SET " + res + " = :datoN WHERE id = :id");
	            query.setParameter("datoN", datoN);
	            query.setParameter("id", id);
	            int rowsAffected = query.executeUpdate();

	            // Comprueba el número de filas afectadas para confirmar la actualización
	            if (rowsAffected > 0) {
	                System.out.println("Este usuario ha sido modificado correctamente.");
	            } else {
	                System.out.println("Ha ocurrido un error.");
	            }

	           

	        } catch (Exception e) {
	          
	            throw e; // Vuelve a lanzar la excepción para que el método que llamó pueda manejarla
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
	    
	    public boolean compruebaId(int id) throws Exception {
	    	 
	    	Usuarios2 usuario = null;
	    	boolean idExiste= false;

	    	    try {
	    	        // Obtiene el usuario por su ID usando JPA
	    	        usuario = sesion.find(Usuarios2.class, id);
	    	        
	    	        if (usuario!=null) {
	    	        	  idExiste= true;

	    	        }
	    	      
	    	    } catch (Exception e) {
	    	        e.printStackTrace();
	    	    }
	    	    
	    	    return idExiste;
	    }
	    
}
