package controlador;

import java.io.IOException;
import java.util.ArrayList;

import modelo.CargarDatos;
import modelo.Equipo;
import modelo.EquipoFantasia;
import modelo.Jugador;
import modelo.Model;
import modelo.PartidoProgramado;
import modelo.Registro;
import modelo.Usuario;

public class Controlador {
	
	Registro registrar = new Registro();
	
	
	public ArrayList<Usuario> cargarDatos() throws IOException {
		CargarDatos data = new CargarDatos();
		ArrayList<Usuario> users = data.cargarUsuarios();
		
		return users;
	}
	
	public ArrayList validarUsuario(String _nombreUsuario, String _clave, ArrayList<Usuario> users) {
		
		ArrayList resultado = registrar.validarUsuario(_nombreUsuario, _clave, users);
		
		return resultado;
	}
	
	public int registrarNuevoUsuario(String _nombreUsuario, String _clave, boolean _admin, ArrayList<Usuario> users) {
		int a=registrar.registrarNuevoUsuario(_nombreUsuario,_clave, _admin, users);
		return a;
	}
	
	public void almacenarJugador(String nombre, String posicion, String equipo, double precio) {
		
		registrar.almacenarJugador(nombre, posicion, equipo, precio);
	}
	
	public ArrayList<Equipo> cargarEquipos() throws IOException{
		CargarDatos data = new CargarDatos();
		ArrayList<Equipo> equipos = data.cargarEquipos();
		return equipos;
	}
	
	public ArrayList<PartidoProgramado> cargarPartidosProgramados() throws IOException{
		CargarDatos data = new CargarDatos();
		ArrayList<PartidoProgramado> partidos = data.cargarPartidosProgramados();
		
		return partidos;
	}
	
	public ArrayList<EquipoFantasia> cargarEquiposFantasia() throws IOException{
		CargarDatos data = new CargarDatos();
		ArrayList<EquipoFantasia> equiposFantasia= data.cargarEquiposFantasia();
		
		return equiposFantasia;
	}
	
	public ArrayList<Jugador> listaJugadores() throws IOException{
		CargarDatos data = new CargarDatos();
		ArrayList<Jugador> jugadores = data.listaJugadores();
		return jugadores;
	}
	public void guardarNuevoEquipo(EquipoFantasia equipo) {
		registrar.agregarEquipoFantasia(equipo);
	}
	public void registrarAlineacion(ArrayList<EquipoFantasia> equipos) {
		
		registrar.registrarAlineacion(equipos);
		
	}
}
