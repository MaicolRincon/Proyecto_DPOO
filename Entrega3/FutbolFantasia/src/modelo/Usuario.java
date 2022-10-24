package modelo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Usuario {
	
	private String nombreUsuario;
	private String clave;
	private boolean admin;
	
	public Usuario(String nombreUsuario, String clave, boolean admin) {
		
		this.nombreUsuario = nombreUsuario;
		this.clave=clave;
		this.admin=admin;

	}
	
	public String darNombre() {
		return nombreUsuario;
	}
	
	public String darClave() {
		return clave;
	}
	
	public boolean darAdmin() {
		return admin;
	}
	
	

}
