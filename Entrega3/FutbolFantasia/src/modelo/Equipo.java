package modelo;

import java.util.ArrayList;

public class Equipo {
	
	private String nombreEquipo;
	private ArrayList<Jugador> jugadores;
	
	
	public Equipo(String nombreEquipo, ArrayList<Jugador> jugadores) {

		this.nombreEquipo = nombreEquipo;
		this.jugadores = jugadores;
	}


	public String darNombre() {
		return nombreEquipo;
	}
	
	public ArrayList<Jugador> darJugadores() {
		return jugadores;
	}
	public void agregaJugador(Jugador jugador) {
		jugadores.add(jugador);
	}

}
