package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CargarDatos {
	
	public ArrayList<Usuario> cargarUsuarios() throws IOException {
		FileReader file = new FileReader("./data/usuarios.txt");
		BufferedReader br = new BufferedReader(file);
		
		String linea = br.readLine();
		
		ArrayList<Usuario> users = new ArrayList<Usuario>();
		boolean admin = false;
		
		while(linea != null) {
			String[] partes = linea.split(",");
			String nombreUsuario = partes[0];
			String clave = partes[1];
			String administrador = partes[2];
			
			if(administrador.equals("true")) {
				admin = true;
			}
			else {
				admin = false;
			}
			
			Usuario _usuario = new Usuario(nombreUsuario, clave, admin);
			users.add(_usuario);
			
			linea = br.readLine();
			
		}
		return users;
		
	}
	
	public ArrayList<Equipo> cargarEquipos() throws IOException{
		
		FileReader file = new FileReader("./data/jugadores.txt");
		BufferedReader br = new BufferedReader(file);
		
		String linea = br.readLine();
		
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		
		ArrayList<String> listaEquipos = new ArrayList();
		ArrayList<Jugador> jugadores;
		
		boolean capitan = false;
		int puntos = 0;
		
		while(linea != null) {
			String[] partes = linea.split(",");
			String nombre = partes[0];
			String posicion = partes[1];
			String equipo = partes[2];
			double precio = Double.valueOf(partes[3]);
			
			
			Jugador jugador = new Jugador(nombre, posicion, precio, puntos, capitan);
			int x=0;
			
				for(int i=0;i<equipos.size();i++) {
					if(equipos.get(i).darNombre().equals(equipo)) {
						equipos.get(i).agregaJugador(jugador);
						x=1;
					}
				}
				if(x==0) {
			
					jugadores = new ArrayList<>();
					jugadores.add(jugador);
					Equipo _equipo = new Equipo(equipo, jugadores);
					equipos.add(_equipo);
					x=0;
				}
			
			
			linea = br.readLine();
			
		}
		
		return equipos;
	}
	
	public ArrayList<Jugador> listaJugadores() throws IOException{
		FileReader file = new FileReader("./data/jugadores.txt");
		BufferedReader br = new BufferedReader(file);
		String linea = br.readLine();
		
		ArrayList<Jugador> jugadores = new ArrayList<>();
		int puntos = 0;
		
		boolean capitan = false;
		
		while(linea != null) {
			
			String[] partes = linea.split(",");
			String nombre = partes[0];
			String posicion = partes[1];
			String equipo = partes[2];
			double precio = Double.valueOf(partes[3]);
			
			Jugador jugador = new Jugador(nombre, posicion, precio, puntos, capitan);
			
			jugadores.add(jugador);
			linea =br.readLine();
		}
		
		return jugadores;
		
	}
	
	
	public ArrayList<PartidoProgramado> cargarPartidosProgramados() throws IOException{
		
		FileReader file = new FileReader("./data/partidosProgramados.txt");
		BufferedReader br = new BufferedReader(file);
		
		String linea = br.readLine();
		
		ArrayList<PartidoProgramado> partidos = new ArrayList<PartidoProgramado>();
		
		PartidoProgramado partido;
		
		
		while(linea != null) {
			String[] partes = linea.split(",");
			String dia = partes[0];
			String mes = partes[1];
			String año = partes[2];
			String hora = partes[3];
			String local = partes[4];
			String visitante = partes[5];
			
			partido = new PartidoProgramado(dia,mes,año,hora,local,visitante);
			
			partidos.add(partido);
			
			linea = br.readLine();
			br.close();
			
		}
		
		return partidos;
	}
	
	public ArrayList<EquipoFantasia> cargarEquiposFantasia() throws IOException{
		
		FileReader file = new FileReader("./data/equiposFantasia.txt");
		BufferedReader br = new BufferedReader(file);
		
		String linea = br.readLine();
		
		ArrayList<EquipoFantasia> equiposFantasia = new ArrayList<EquipoFantasia>();
		
		EquipoFantasia equipoF;
		
		ArrayList<Jugador> jugadores = listaJugadores();
		
		
		Jugador jugador_1=null;
		Jugador jugador_2=null;
		Jugador jugador_3=null;
		Jugador jugador_4=null;
		Jugador jugador_5=null;
		Jugador jugador_6=null;
		Jugador jugador_7=null;
		Jugador jugador_8=null;
		Jugador jugador_9=null;
		Jugador jugador_10=null;
		Jugador jugador_11=null;
		Jugador jugador_12=null;
		Jugador jugador_13=null;
		Jugador jugador_14=null;
		Jugador jugador_15=null;

		
		while(linea != null) {
			
			String[] partes = linea.split(",");
			String usuario = partes[0];
			String nombreEquipo = partes[1];
			double presupuesto = Double.valueOf(partes[2]);
			int puntos = Integer.valueOf(partes[3]);
			String jugador1 = partes[4];
			String jugador2 = partes[5];
			String jugador3 = partes[6];
			String jugador4 = partes[7];
			String jugador5 = partes[8];
			String jugador6 = partes[9];
			String jugador7 = partes[10];
			String jugador8 = partes[11];
			String jugador9 = partes[12];
			String jugador10 = partes[13];
			String jugador11 = partes[14];
			String jugador12 = partes[15];
			String jugador13 = partes[16];
			String jugador14 = partes[17];
			String jugador15 = partes[18];
			boolean titular1= Boolean.valueOf(partes[19]);
			boolean titular2= Boolean.valueOf(partes[20]);
			boolean titular3= Boolean.valueOf(partes[21]);
			boolean titular4= Boolean.valueOf(partes[22]);
			boolean titular5= Boolean.valueOf(partes[23]);
			boolean titular6= Boolean.valueOf(partes[24]);
			boolean titular7= Boolean.valueOf(partes[25]);
			boolean titular8= Boolean.valueOf(partes[26]);
			boolean titular9= Boolean.valueOf(partes[27]);
			boolean titular10= Boolean.valueOf(partes[28]);
			boolean titular11= Boolean.valueOf(partes[29]);
			boolean titular12= Boolean.valueOf(partes[30]);
			boolean titular13= Boolean.valueOf(partes[31]);
			boolean titular14= Boolean.valueOf(partes[32]);
			boolean titular15= Boolean.valueOf(partes[33]);
			
			
			
			for(int i=0;i<jugadores.size();i++) {
				
				if(jugadores.get(i).darNombre().equals(jugador1)) jugador_1=jugadores.get(i);
				if(jugadores.get(i).darNombre().equals(jugador2)) jugador_2=jugadores.get(i);
				if(jugadores.get(i).darNombre().equals(jugador3)) jugador_3=jugadores.get(i);
				if(jugadores.get(i).darNombre().equals(jugador4)) jugador_4=jugadores.get(i);
				if(jugadores.get(i).darNombre().equals(jugador5)) jugador_5=jugadores.get(i);
				if(jugadores.get(i).darNombre().equals(jugador6)) jugador_6=jugadores.get(i);
				if(jugadores.get(i).darNombre().equals(jugador7)) jugador_7=jugadores.get(i);
				if(jugadores.get(i).darNombre().equals(jugador8)) jugador_8=jugadores.get(i);
				if(jugadores.get(i).darNombre().equals(jugador9)) jugador_9=jugadores.get(i);
				if(jugadores.get(i).darNombre().equals(jugador10)) jugador_10=jugadores.get(i);
				if(jugadores.get(i).darNombre().equals(jugador11)) jugador_11=jugadores.get(i);
				if(jugadores.get(i).darNombre().equals(jugador12)) jugador_12=jugadores.get(i);
				if(jugadores.get(i).darNombre().equals(jugador13)) jugador_13=jugadores.get(i);
				if(jugadores.get(i).darNombre().equals(jugador14)) jugador_14=jugadores.get(i);
				if(jugadores.get(i).darNombre().equals(jugador15)) jugador_15=jugadores.get(i);
			}
			
			equipoF= new EquipoFantasia(usuario,nombreEquipo,presupuesto,puntos,jugador_1,jugador_2,jugador_3,
					jugador_4,jugador_5,jugador_6,jugador_7,jugador_8,jugador_9,jugador_10,
					jugador_11,jugador_12,jugador_13,jugador_14,jugador_15,titular1,titular2,titular3,
					titular4,titular5,titular6,titular7,titular8,titular9,titular10,titular11,
					titular12,titular13,titular14,titular15);
			
			equiposFantasia.add(equipoF);
			
			linea = br.readLine();
			
			
		}
		br.close();
		
		return equiposFantasia;
	}
	

}
