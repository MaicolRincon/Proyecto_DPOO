package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;

import controlador.Controlador;
import modelo.Equipo;
import modelo.EquipoFantasia;
import modelo.Jugador;
import modelo.PartidoProgramado;
import modelo.Usuario;

public class Consola {
	
	private static Controlador controler = new Controlador();
	
	public static void main(String[] args) throws IOException {
		
		
		ArrayList<Usuario> users = controler.cargarDatos();
		inicio(users);
	}
	
	
	public static void inicio(ArrayList<Usuario> users) throws IOException {
		
		System.out.println("\n------- Bienvenido a Fútbol Fantasía -------\n");
		System.out.println("1. Ingresar con un Usuario existente");
		System.out.println("2. Crear un nuevo Usuario");
		System.out.println("Marque cualquier otra opción para terminar el programa");
		
		int opcion = Integer.valueOf(input("\nIngrese una opción"));
		
		if(opcion==1) ingresar(users);
		else if (opcion==2) nuevoUsuario(users);
		else System.out.println("Bye");
	}
	//Ingreso del usuario
	
	public static void ingresar(ArrayList<Usuario> users) throws IOException {
		
		
		String _nombreUsuario = input("Ingrese su Usuario");
		String _clave = input("Ingrese su clave");
		
		ArrayList resultado = controler.validarUsuario(_nombreUsuario, _clave, users);
		
		boolean validacion = Boolean.valueOf((boolean) resultado.get(0));
		
		Usuario user = (Usuario) resultado.get(1);
		
		if(validacion) {
			System.out.println("\nBienvenido "+ _nombreUsuario);
			menuRol(user);
		}
		else {
			System.out.println("\nUsuario o Clave incorrectos. Sera mandado al menú de inicio automáticamente");
			System.out.println("Recuerde que puede crear un nuevo Usuario e ingresar al sistema con ese usuario");
			inicio(users);
		}
		
	}
	
	//Crear un nuevo Usuario
	
	public static void nuevoUsuario(ArrayList<Usuario> users) throws IOException {
		
		System.out.println("\n**Crear NUEVO Usuario**\n");
		String _nombreUsuario = input("Por favor ingrese su Usuario");
		String _clave = input("Por favor ingrese su clave");
		String admin = input("Desea ingresar como adminstrador(true/false)");
		boolean _admin=false;
		if(admin.equals("true")) _admin = true; 
		
		int a= controler.registrarNuevoUsuario(_nombreUsuario,_clave, _admin, users);
		if(a==1) {
			System.out.println("\nEl nombre de Usuario ya se encuentra registrado, intenta con otro");
			nuevoUsuario(users);
		}
		else {
			System.out.println("\nUsuario registrado correctamente, volvera al menu de inicio automáticamente");
			users = controler.cargarDatos();
			inicio(users);
		}
		
	}
	
//	 El siguiente método muestra el menu correspondite al usuario según su rol, es decir si el usuario es administrador
// solo podra registrar resultados, si no lo es tiene muchas opciones para disfrutar del programa
	
	public static void menuRol(Usuario user) throws IOException {
		if(user.darAdmin()) {
			System.out.println("\n---Menú Administrador---\n");
			System.out.println("1. Registrar resultados del partido");
			System.out.println("2. Registrar nominas de cada equipo");
			System.out.println("Digite cualquier otra para Volver al menú de inicio");
			int opcion = Integer.valueOf(input("Ingrese una opción"));
			
			if(opcion==1) {
				registrarResultadosPartido();
				
			}
			
			if(opcion==2) {
				registrarNomina();
			}
			else {
				ArrayList<Usuario> users = controler.cargarDatos();
				inicio(users);
			}
		}
		else {
			System.out.println("\nMenú Usuario\n");
			System.out.println("1. Mostrar partidos programados");
			System.out.println("2. Crear nuevo equipo de fantasía");
			System.out.println("3. Ver mis equipos de fantasía");
			System.out.println("4. Ver alineación");
			System.out.println("5. Configurar alineación");
			System.out.println("6. Vender y Comprar jugadores");
			System.out.println("Digite cualquier otra para Volver al menú de inicio");
			int opcion = Integer.valueOf(input("Ingrese una opción"));
			
			if(opcion==1) {
				partidosProgramados();
			}
			if(opcion==2) {
				nuevoEquipoFantasia(user);
			}
			if(opcion==3) {
				verEquiposFantasia(user);
			}
			if(opcion==4) {
				verAlineacion(user);
			}
			if(opcion==5) {
				configurarAlineacion(user);
			}
			if(opcion==6) {
				comercioJugadores(user);
			}
			else {
				ArrayList<Usuario> users = controler.cargarDatos();
				inicio(users);
			}
		}
		
	}
	public static void registrarResultadosPartido() throws IOException {
		ArrayList<Equipo> equipos = controler.cargarEquipos();
		
		System.out.println("\nEscriba el nombre de los 2 equipos que jugaron en el partido");
		String equipoA = input("Equipo 1");
		String equipoB = input("Equipo 2");
		
		int _equipoA= Integer.valueOf(input("Goles del " + equipoA));
		int _equipoB= Integer.valueOf(input("Goles del " + equipoB));
		
		boolean ganador = false;
		
		if(_equipoA>_equipoB) ganador=true;
		
		for(int i=0;i<equipos.size();i++) {
			if(equipos.get(i).darNombre().equals(equipoA)) {

				System.out.println("\nPor favor ingrese la siguiente información de los jugadores del " + equipoA);
				for(int a=0;a<equipos.get(i).darJugadores().size();a++) {
					System.out.println("\n--> Estadísticas para: " + equipos.get(i).darJugadores().get(a).darNombre() + "\n");
					int minutoEntrada = Integer.valueOf(input("Minuto en que ingreso"));
					int minutoSalida = Integer.valueOf(input("Minuto en que salio"));
					int goles = Integer.valueOf(input("Número de Goles anotados"));
					int autogoles = Integer.valueOf(input("Número de Autogoles"));
					int asistencias = Integer.valueOf(input("Numero de asistencias"));
					int penalesDetenidos=0;
					
					if(equipos.get(i).darJugadores().get(a).darPosicion().equals("portero") || equipos.get(i).darJugadores().get(a).darPosicion().equals("defensa")) {
					
						int golesEnContra = Integer.valueOf(input("Número de Goles recibidos"));
					}
					if(equipos.get(i).darJugadores().get(a).darPosicion().equals("portero")) {
						penalesDetenidos = Integer.valueOf(input("Número de Penales detenidos"));
					}
					
					int penalesErrados = Integer.valueOf(input("Número de Penales errados"));
					int tarjetasAmarillas = Integer.valueOf(input("Número de tarjetas amarillas"));
					int tarjetasRojas = Integer.valueOf(input("Número de tarjetas rojas"));
					int golesRecibidos=_equipoB;
					
					int puntos = equipos.get(i).darJugadores().get(a).sumarPuntos(minutoEntrada, minutoSalida, goles,
							autogoles, asistencias, golesRecibidos, penalesDetenidos, penalesErrados, tarjetasAmarillas,
							tarjetasRojas, ganador);
					System.out.println(
							"Puntuación para " + equipos.get(i).darJugadores().get(a).darNombre() + ": " + puntos);

				}
			}
		}
		
		if (_equipoA < _equipoB)
			ganador = true;

		for (int i = 0; i < equipos.size(); i++) {
			if (equipos.get(i).darNombre().equals(equipoB)) {

				System.out.println("\nPor favor ingrese la siguiente información de los jugadores del " + equipoA);
				for (int a = 0; a < equipos.get(i).darJugadores().size(); a++) {
					System.out.println(
							"\n--> Estadísticas para: " + equipos.get(i).darJugadores().get(a).darNombre() + "\n");
					int minutoEntrada = Integer.valueOf(input("Minuto en que ingreso"));
					int minutoSalida = Integer.valueOf(input("Minuto en que salio"));
					int goles = Integer.valueOf(input("Número de Goles anotados"));
					int autogoles = Integer.valueOf(input("Número de Autogoles"));
					int asistencias = Integer.valueOf(input("Numero de asistencias"));
					int penalesDetenidos=0;

					if (equipos.get(i).darJugadores().get(a).darPosicion().equals("portero")
							|| equipos.get(i).darJugadores().get(a).darPosicion().equals("defensa")) {

						int golesEnContra = Integer.valueOf(input("Número de Goles recibidos"));
					}
					if (equipos.get(i).darJugadores().get(a).darPosicion().equals("portero")) {
						penalesDetenidos = Integer.valueOf(input("Número de Penales detenidos"));
					}

					int penalesErrados = Integer.valueOf(input("Número de Penales errados"));
					int tarjetasAmarillas = Integer.valueOf(input("Número de tarjetas amarillas"));
					int tarjetasRojas = Integer.valueOf(input("Número de tarjetas rojas"));
					int golesRecibidos=_equipoA;
					

					int puntos = equipos.get(i).darJugadores().get(a).sumarPuntos(minutoEntrada, minutoSalida, goles,
							autogoles, asistencias, golesRecibidos, penalesDetenidos, penalesErrados, tarjetasAmarillas,
							tarjetasRojas, ganador);
					System.out.println(
							"Puntuación para " + equipos.get(i).darJugadores().get(a).darNombre() + ": " + puntos);

				}
			}
		}
		//TODO
		//falta guardar los datos
		System.out.println("\nRegistro Exitoso. Los datos ya fueron almacenados en el sistema");

	}
	
	public static void comercioJugadores(Usuario user) throws IOException {
		
		System.out.println("\nPara comprar jugadores, primero tendra que venderlos ya que el equipo en todo momento debe contar con 15 jugadores\n");
		
		ArrayList<EquipoFantasia> equipoF=controler.cargarEquiposFantasia();
		System.out.println("\n----Tus equipos de fantasia son los siguientes: \n");
		
		for(int i=0;i<equipoF.size();i++) {
			if(equipoF.get(i).darUsuario().equals(user.darNombre())) {
				System.out.println(equipoF.get(i).darNombre());
				
			}
		}
		String equi = input("\nIngrese el nombre del equipo que desea ver la alineación\n");
		//TODO
		
		int opcion=0;
		while(opcion!=0) {
			System.out.println("1. Vender jugador");
			System.out.println("0. Terminar");
			
		}
	}
	public static void registrarNomina() throws IOException {
		
		System.out.println("\nPara registrar los jugadores se recomienda hacer caso de los siguientes items");
		System.out.println("\n    - No deje ningún campo vacio");
		System.out.println("    - Despues de registrar a cada jugador, el programa le preguntara si desea registrar otro más o si desea finalizar");
		System.out.println("      marque 1 para seguir registrando y 0 para finalizar");;
		System.out.println("    - Se recomienda escribir todo en minúsculas y sin ningún error para evitar problemas en la asignación de los equipos y posiciones de cada jugador");
		System.out.println("    - En los valores númericos NO coloque ningún caracter. SOLO números");
		
		int registro = 1;
		while(registro == 1) {
			System.out.println("\n1. Registrar un nuevo jugador");
			System.out.println("2. Finalizar registro");
			int opcionRegistro = Integer.valueOf(input("Marque una opción para continuar"));
			
			if(opcionRegistro==1) {
				
				String nombre = input("Nombre del Jugador");
				String posicion = input("Posición (arquero/defensor/mediocampista/delantero)");
				String equipo = input("Equipo al que pertenece el Jugador");
				double precio = Double.valueOf(input("Precio del Jugador"));
				
				controler.almacenarJugador(nombre, posicion, equipo, precio);
				System.out.println("\nJugador registrado con éxito");
				
			}
			else if(opcionRegistro==2) {
				System.out.println("Se finalizo el registro de los jugadores volvera al menu de inicio");
				registro=0;
				ArrayList<Usuario> users = controler.cargarDatos();
				inicio(users);
				
			}
			else {
				System.out.println("No corresponde a ninguna opción, intente de nuevo");
			}
		}
	}
	
	
	public static void partidosProgramados() throws IOException {
		ArrayList<PartidoProgramado> partidos = controler.cargarPartidosProgramados();	
		
		System.out.println("\n|    DIA    |    MES    |    AÑO    |    HORA    |    LOCAL    |    VISITANTE    |");
		System.out.println("-------------------------------------------------------------------------------------");
		for(int i=0; i<partidos.size();i++) {
			
			String dia = partidos.get(i).getDia();
			String mes = partidos.get(i).getMes();
			String año = partidos.get(i).getAño();
			String hora = partidos.get(i).getHora();
			String local = partidos.get(i).getLocal();
			String visitante = partidos.get(i).getVisitante();
			
			System.out.println("|    " + dia + "    |    " + mes + "    |    " + año + "    |    "
					+ hora + "    |    " + local + "    |    " + visitante + "    |");
			
			ArrayList<Usuario> users = controler.cargarDatos();
			inicio(users);
		}
		
	}
	public static void nuevoEquipoFantasia(Usuario user) throws IOException {
		System.out.println("\n----CREAR NUEVO EQUIPO FANTASÍA-----\n");
		
		String nombreEquipo = input("Digite el nombre del equipo nuevo");
		System.out.println("\nTu presupuesto inicial sera de: 25000");
		
		double presupuesto = 50000;
		
		comprarJugadores(user,nombreEquipo,presupuesto);
		
		//TODO
		
	}
	
	public static void verEquiposFantasia(Usuario user) throws IOException {
		System.out.println("\n----MIS EQUIPOS FANTASIA----\n");
		
		ArrayList<EquipoFantasia> equiposFantasia = controler.cargarEquiposFantasia();
		
		for(int i=0;i<equiposFantasia.size();i++) {
			if(equiposFantasia.get(i).darUsuario().equals(user.darNombre())) {
				System.out.println("\nEquipo Fantasia: " + equiposFantasia.get(i).darNombre());
				System.out.println("\nPresupuesto disponible: "+ equiposFantasia.get(i).darPresupuesto());
				System.out.println("\nPuntos: " + equiposFantasia.get(i).darPuntos());
				System.out.println("\n --> Lista de jugadores:\n");
				System.out.println("     " + equiposFantasia.get(i).getJugador1().darNombre());
				System.out.println("     " + equiposFantasia.get(i).getJugador2().darNombre());
				System.out.println("     " + equiposFantasia.get(i).getJugador3().darNombre());
				System.out.println("     " + equiposFantasia.get(i).getJugador4().darNombre());
				System.out.println("     " + equiposFantasia.get(i).getJugador5().darNombre());
				System.out.println("     " + equiposFantasia.get(i).getJugador6().darNombre());
				System.out.println("     " + equiposFantasia.get(i).getJugador7().darNombre());
				System.out.println("     " + equiposFantasia.get(i).getJugador8().darNombre());
				System.out.println("     " + equiposFantasia.get(i).getJugador9().darNombre());
				System.out.println("     " + equiposFantasia.get(i).getJugador10().darNombre());
				System.out.println("     " + equiposFantasia.get(i).getJugador11().darNombre());
				System.out.println("     " + equiposFantasia.get(i).getJugador12().darNombre());
				System.out.println("     " + equiposFantasia.get(i).getJugador13().darNombre());
				System.out.println("     " + equiposFantasia.get(i).getJugador14().darNombre());
				System.out.println("     " + equiposFantasia.get(i).getJugador15().darNombre());
				
			}
		}
	}
	
	public static void verAlineacion(Usuario user) throws IOException {
		
		ArrayList<EquipoFantasia> equiposFantasia = controler.cargarEquiposFantasia();
		
		System.out.println("\n----Tus equipos de fantasia son los siguientes: \n");
		
		for(int i=0;i<equiposFantasia.size();i++) {
			if(equiposFantasia.get(i).darUsuario().equals(user.darNombre())) {
				System.out.println(equiposFantasia.get(i).darNombre());
				
			}
		}
		String equipo = input("\nIngrese el nombre del equipo que desea ver la alineación\n");
		
		for(int a=0;a<equiposFantasia.size();a++){
			if(equiposFantasia.get(a).darNombre().equals(equipo)) {
				
				System.out.println("1. "+equiposFantasia.get(a).getJugador1().darNombre()+" Titular: "+equiposFantasia.get(a).isTitular1());
				System.out.println("2. "+equiposFantasia.get(a).getJugador2().darNombre()+" Titular: "+equiposFantasia.get(a).isTitular2());
				System.out.println("3. "+equiposFantasia.get(a).getJugador3().darNombre()+" Titular: "+equiposFantasia.get(a).isTitular3());
				System.out.println("4. "+equiposFantasia.get(a).getJugador4().darNombre()+" Titular: "+equiposFantasia.get(a).isTitular4());
				System.out.println("5. "+equiposFantasia.get(a).getJugador5().darNombre()+" Titular: "+equiposFantasia.get(a).isTitular5());
				System.out.println("6. "+equiposFantasia.get(a).getJugador6().darNombre()+" Titular: "+equiposFantasia.get(a).isTitular6());
				System.out.println("7. "+equiposFantasia.get(a).getJugador7().darNombre()+" Titular: "+equiposFantasia.get(a).isTitular7());
				System.out.println("8. "+equiposFantasia.get(a).getJugador8().darNombre()+" Titular: "+equiposFantasia.get(a).isTitular8());
				System.out.println("9. "+equiposFantasia.get(a).getJugador9().darNombre()+" Titular: "+equiposFantasia.get(a).isTitular9());
				System.out.println("10. "+equiposFantasia.get(a).getJugador10().darNombre()+" Titular: "+equiposFantasia.get(a).isTitular10());
				System.out.println("11. "+equiposFantasia.get(a).getJugador11().darNombre()+" Titular: "+equiposFantasia.get(a).isTitular11());
				System.out.println("12. "+equiposFantasia.get(a).getJugador12().darNombre()+" Titular: "+equiposFantasia.get(a).isTitular12());
				System.out.println("13. "+equiposFantasia.get(a).getJugador13().darNombre()+" Titular: "+equiposFantasia.get(a).isTitular13());
				System.out.println("14. "+equiposFantasia.get(a).getJugador14().darNombre()+" Titular: "+equiposFantasia.get(a).isTitular14());
				System.out.println("15. "+equiposFantasia.get(a).getJugador15().darNombre()+" Titular: "+equiposFantasia.get(a).isTitular15());
				
		}
		
		}
		menuRol(user);
	}
	
	public static void configurarAlineacion(Usuario user) throws IOException {
		
		ArrayList<EquipoFantasia> equiposFantasia = controler.cargarEquiposFantasia();
		
		System.out.println("\n----Tus equipos de fantasia son los siguientes: \n");
		
		for(int i=0;i<equiposFantasia.size();i++) {
			if(equiposFantasia.get(i).darUsuario().equals(user.darNombre())) {
				System.out.println(equiposFantasia.get(i).darNombre());
				
			}
		}
		String equipo = input("\nIngrese el nombre del equipo que desea configurar la alineación\n");
		
		EquipoFantasia equipoF = null;
		int b=0;
		for(int a=0;a<equiposFantasia.size();a++) {
			if(equiposFantasia.get(a).darNombre().equals(equipo)) equipoF=equiposFantasia.get(a);
			b=a;
		}
		
		System.out.println("Escriba true para que sea titular o false para suplente");
		
		String titular1= input(equipoF.getJugador1().darNombre());
		boolean titular_1=Boolean.valueOf(titular1);
		equipoF.setTitular1(titular_1);
		
		String titular2= input(equipoF.getJugador2().darNombre());
		boolean titular_2=Boolean.valueOf(titular2);
		equipoF.setTitular1(titular_2);
		String titular3= input(equipoF.getJugador3().darNombre());
		boolean titular_3=Boolean.valueOf(titular3);
		equipoF.setTitular1(titular_3);
		String titular4= input(equipoF.getJugador4().darNombre());
		boolean titular_4=Boolean.valueOf(titular4);
		equipoF.setTitular1(titular_4);
		String titular5= input(equipoF.getJugador5().darNombre());
		boolean titular_5=Boolean.valueOf(titular5);
		equipoF.setTitular1(titular_5);
		String titular6= input(equipoF.getJugador6().darNombre());
		boolean titular_6=Boolean.valueOf(titular6);
		equipoF.setTitular1(titular_6);
		String titular7= input(equipoF.getJugador7().darNombre());
		boolean titular_7=Boolean.valueOf(titular7);
		equipoF.setTitular1(titular_7);
		String titular8= input(equipoF.getJugador8().darNombre());
		boolean titular_8=Boolean.valueOf(titular8);
		equipoF.setTitular1(titular_8);
		String titular9= input(equipoF.getJugador9().darNombre());
		boolean titular_9=Boolean.valueOf(titular9);
		equipoF.setTitular1(titular_9);
		String titular10= input(equipoF.getJugador10().darNombre());
		boolean titular_10=Boolean.valueOf(titular10);
		equipoF.setTitular1(titular_10);
		String titular11= input(equipoF.getJugador11().darNombre());
		boolean titular_11=Boolean.valueOf(titular11);
		equipoF.setTitular1(titular_11);
		String titular12= input(equipoF.getJugador12().darNombre());
		boolean titular_12=Boolean.valueOf(titular12);
		equipoF.setTitular1(titular_12);
		String titular13= input(equipoF.getJugador13().darNombre());
		boolean titular_13=Boolean.valueOf(titular13);
		equipoF.setTitular1(titular_13);
		String titular14= input(equipoF.getJugador14().darNombre());
		boolean titular_14=Boolean.valueOf(titular14);
		equipoF.setTitular1(titular_14);
		String titular15= input(equipoF.getJugador15().darNombre());
		boolean titular_15=Boolean.valueOf(titular15);
		equipoF.setTitular1(titular_15);
		
		
		equiposFantasia.remove(b);
		equiposFantasia.add(equipoF);
		
		controler.registrarAlineacion(equiposFantasia);
		menuRol(user);
		//TODO  Registrarlo como txt
	}
	
	public static void comprarJugadores(Usuario user, String nombreEquipo, double presupuesto) throws IOException {
		
		System.out.println("\nLista de jugadores:");
		System.out.println("Presupuesto: " + presupuesto +"\n");
		
		
		String jugador1=null;
		String jugador2=null;
		String jugador3=null;
		String jugador4=null;
		String jugador5=null;
		String jugador6=null;
		String jugador7=null;
		String jugador8=null;
		String jugador9=null;
		String jugador10=null;
		String jugador11=null;
		String jugador12=null;
		String jugador13=null;
		String jugador14=null;
		String jugador15=null;
		
		Jugador _jugador1=null;
		Jugador _jugador2=null;
		Jugador _jugador3=null;
		Jugador _jugador4=null;
		Jugador _jugador5=null;
		Jugador _jugador6=null;
		Jugador _jugador7=null;
		Jugador _jugador8=null;
		Jugador _jugador9=null;
		Jugador _jugador10=null;
		Jugador _jugador11=null;
		Jugador _jugador12=null;
		Jugador _jugador13=null;
		Jugador _jugador14=null;
		Jugador _jugador15=null;
		
		ArrayList<Jugador> jugadores = controler.listaJugadores();
		
		for(int a=0;a<jugadores.size();a++) {
			if(jugadores.get(a).darPosicion().equals("arquero")) {
				System.out.println("--> " + jugadores.get(a).darNombre() + "     Precio: " + 
			jugadores.get(a).darPrecio() + "   Posición: Arquero");
			}
		}
		
		jugador1=input("Digite el nombre del 1° arquero(titular)que desea comprar");
		jugador2=input("Digite el nombre del 2° arquero(suplente) que desea comprar");
		
		for(int a=0;a<jugadores.size();a++) {
			if(jugadores.get(a).darPosicion().equals("defensa")) {
				System.out.println("--> " + jugadores.get(a).darNombre() + "     Precio: " + 
			jugadores.get(a).darPrecio() + "   Posición: Defensa");
			}
		}
		
		jugador3=input("Digite el nombre del 1° defensa(titular) que desea comprar");
		jugador4=input("Digite el nombre del 2° defensa(titular) que desea comprar");
		jugador5=input("Digite el nombre del 3° defensa(titular) que desea comprar");
		jugador6=input("Digite el nombre del 4° defensa(titular) que desea comprar");
		jugador7=input("Digite el nombre del 5° defensa(suplente) que desea comprar");
		
		
		for(int a=0;a<jugadores.size();a++) {
			if(jugadores.get(a).darPosicion().equals("mediocampista")) {
				System.out.println("--> " + jugadores.get(a).darNombre() + "     Precio: " + 
			jugadores.get(a).darPrecio() + "   Posición: Mediocampista");
			}
		}
		
		jugador8=input("Digite el nombre del 1° mediocampista(titular) que desea comprar");
		jugador9=input("Digite el nombre del 2° mediocampista(titular) que desea comprar");
		jugador10=input("Digite el nombre del 3° mediocampista(titular) que desea comprar");
		jugador11=input("Digite el nombre del 4° mediocampista(suplente) que desea comprar");
		jugador12=input("Digite el nombre del 5° mediocampista(suplente) que desea comprar");
		
		for(int a=0;a<jugadores.size();a++) {
			if(jugadores.get(a).darPosicion().equals("delantero")) {
				System.out.println("--> " + jugadores.get(a).darNombre() + "     Precio: " + 
			jugadores.get(a).darPrecio() + "   Posición: Delantero");
			}
		}
		
		jugador13=input("Digite el nombre del 1° delantero(titular) que desea comprar");
		jugador14=input("Digite el nombre del 2° delantero(titular) que desea comprar");
		jugador15=input("Digite el nombre del 3° delantero(titular) que desea comprar");
		int puntos=0;
		
		for(int i=0;i<jugadores.size();i++) {
			if(jugadores.get(i).darNombre().equals(jugador1)) {
				_jugador1 = jugadores.get(i);
				presupuesto -= jugadores.get(i).darPrecio();
			}
			if(jugadores.get(i).darNombre().equals(jugador2)) {
				_jugador2 = jugadores.get(i);
				presupuesto -= jugadores.get(i).darPrecio();
			}
			if(jugadores.get(i).darNombre().equals(jugador3)) {
				_jugador3 = jugadores.get(i);
				presupuesto -= jugadores.get(i).darPrecio();
			}
			if(jugadores.get(i).darNombre().equals(jugador4)) {
				_jugador4 = jugadores.get(i);
				presupuesto -= jugadores.get(i).darPrecio();
			}
			if(jugadores.get(i).darNombre().equals(jugador5)) {
				_jugador5 = jugadores.get(i);
				presupuesto -= jugadores.get(i).darPrecio();
			}
			if(jugadores.get(i).darNombre().equals(jugador6)) {
				_jugador6 = jugadores.get(i);
				presupuesto -= jugadores.get(i).darPrecio();
			}
			if(jugadores.get(i).darNombre().equals(jugador7)) {
				_jugador7 = jugadores.get(i);
				presupuesto -= jugadores.get(i).darPrecio();
			}
			if(jugadores.get(i).darNombre().equals(jugador8)) {
				_jugador8 = jugadores.get(i);
				presupuesto -= jugadores.get(i).darPrecio();
			}
			if(jugadores.get(i).darNombre().equals(jugador9)) {
				_jugador9 = jugadores.get(i);
				presupuesto -= jugadores.get(i).darPrecio();
			}
			if(jugadores.get(i).darNombre().equals(jugador10)) {
				_jugador10 = jugadores.get(i);
			}
			if(jugadores.get(i).darNombre().equals(jugador11)) {
				_jugador11 = jugadores.get(i);
				presupuesto -= jugadores.get(i).darPrecio();
			}
			if(jugadores.get(i).darNombre().equals(jugador12)) {
				_jugador12 = jugadores.get(i);
				presupuesto -= jugadores.get(i).darPrecio();
			}
			if(jugadores.get(i).darNombre().equals(jugador13)) {
				_jugador13 = jugadores.get(i);
				presupuesto -= jugadores.get(i).darPrecio();
			}
			if(jugadores.get(i).darNombre().equals(jugador14)) {
				_jugador14 = jugadores.get(i);
				presupuesto -= jugadores.get(i).darPrecio();
			}
			if(jugadores.get(i).darNombre().equals(jugador15)) {
				_jugador15 = jugadores.get(i);
				presupuesto -= jugadores.get(i).darPrecio();
			}
		}
		System.out.println("\nPresupuesto disponible: " + presupuesto);
		
		EquipoFantasia equipo = new EquipoFantasia(user.darNombre(),nombreEquipo,presupuesto,puntos,
				_jugador1,_jugador2,_jugador3,_jugador4,_jugador5,_jugador6,_jugador7,_jugador8,_jugador9,
				_jugador10,_jugador11,_jugador12,_jugador13,_jugador14,_jugador15,true,false,true,true,
				true,true,false,true,true,true,false,false,true,true,true);
	
		controler.guardarNuevoEquipo(equipo);
		System.out.println("\nEquipo Correctamente creado");
		menuRol(user);
		
	}
	
	// Este método es para que sea más fácil para nosotros pedirle al usuario que ingrrese algún texto
	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
}
