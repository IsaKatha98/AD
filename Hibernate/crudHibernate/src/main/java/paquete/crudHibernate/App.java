package paquete.crudHibernate;

public class App {
	 private static AccesoBD instancia;

	    public static void main(String[] args) throws Exception {
	        instancia=new AccesoBD();
	        instancia.abrir();
	        
	    }

}
