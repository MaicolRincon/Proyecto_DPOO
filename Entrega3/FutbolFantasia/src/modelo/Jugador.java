package modelo;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Jugador {
	
	private String nombre;
	private String posicion;
	private double precio;
	private int puntos;
	private boolean capitanEquipoFantasia;

	
	public Jugador(String nombre, String posicion, double precio, int puntos, boolean capitanEquipoFantasia) {
	
		this.nombre = nombre;
		this.posicion = posicion;
		this.precio = precio;
		this.puntos = puntos;
		this.capitanEquipoFantasia = capitanEquipoFantasia;
	}
	
	
	public String darNombre() {
		return nombre;
	}
	
	public String darPosicion() {
		return posicion;
	}
	
	public double darPrecio() {
		return precio;
	}
	
	public int sumarPuntos(int minutoEntrada, int minutoSalida, int goles, int autogoles, int asistencias, int golesRecibidos, int penaltisDetenidos, int penaltisErrados, int tarjetasAmarillas, int tarjetasRojas, boolean ganador) {
		
		int tiempoJugado= minutoSalida-minutoEntrada;
		int puntosTiempo=0;
		
		if(tiempoJugado<=60) puntosTiempo=1;
		else if(tiempoJugado>60) puntosTiempo=2;
		
		int puntosGoles=0;
		if(posicion.equals("delantero")) puntosGoles=goles*4;
		if(posicion.equals("medioCampista")) puntosGoles=goles*5;
		if(posicion.equals("arquero")||posicion.equals("defensa")) puntosGoles=goles*6;
		
		int puntosAsistencias = asistencias*3;
		
		int puntosGolesRecibidos=0;
		if((posicion.equals("arquero")||posicion.equals("defensa"))&& golesRecibidos==0) puntosGolesRecibidos = 4;
		
		int puntosPenaltisDetenidos =0;
		if(posicion.equals("arquero")) puntosPenaltisDetenidos = penaltisDetenidos*5;
		
		
		int puntosCapitan=0;
		if(capitanEquipoFantasia && ganador) puntosCapitan=5;
		
		int puntosPenaltisErrados=penaltisErrados * (-2);
		
		int puntosTarjetaAmarilla = tarjetasAmarillas *(-1);
		
		int puntosTarjetaRoja = tarjetasRojas *(-3);
		
		int puntosAutogol = autogoles* (-2);
		
		int puntosTotales= puntosTiempo + puntosGoles + puntosAsistencias + puntosGolesRecibidos + puntosPenaltisDetenidos + puntosCapitan+ puntosPenaltisErrados + puntosTarjetaAmarilla+ puntosTarjetaRoja + puntosAutogol;
		
		puntos += puntosTotales;
		
		return puntos;
	
	}

}
