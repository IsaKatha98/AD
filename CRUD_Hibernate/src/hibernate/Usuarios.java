package hibernate;
import java.util.List;
import javax.persistence.*;

import java.io.Serializable;
@Entity
@Table(name="Usuarios2")
//implementamos la interfaz serializable
public class Usuarios2 implements Serializable{
	
	//declaramos los atributos con sus respectivas anotaciones
	@Id
	@GeneratedValue(strategy=GenerationType.Identity)
	@Column(name="idUsuario")
	int idUsuario;
	@Column(name="nombre")
	String nombre;
	@Column(name="apellidos")
	String apellidos;
	@Column(name="username")
	String username;
	@Column(name="password")
	String password;
	@Column (name="email")
	String email;

	//constructores
	//constructor vacío
	public Usuarios2() {
		
	}
	
	//constructor con parámetros
	public Usuarios2(int idUsuario, String nombre, String apellidos, String username, String password, String email) {

		this.idUsuario=idUsuario;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.username=username;
		this.password=password;
		this.email=email;
	}

	//setters y getters
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario=idUsuario;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos=apellidos;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username=username;
	}
	
	public String getPassword () {
		return password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
}
