package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Registro {
	
public ArrayList validarUsuario(String _nombreUsuario, String _clave, ArrayList<Usuario> users) {
		
		boolean validacion=false;
		Usuario user=null;
		for(int i=0;i<users.size();i++) {
			if(users.get(i).darNombre().equals(_nombreUsuario) && users.get(i).darClave().equals(_clave)) {

				validacion =true;
				user = users.get(i);
			}
		}
		
		ArrayList resultado = new ArrayList();
		resultado.add(validacion);
		resultado.add(user);

		return resultado;
	}
	
	public int registrarNuevoUsuario(String _nombreUsuario, String _clave, boolean _admin, ArrayList<Usuario> users) {
		
		boolean existe = false;
		int a=0;
		
		for(int i=0;i<users.size();i++) {
			
			if(users.get(i).darNombre().equals(_nombreUsuario)) {
				existe = true;
				System.out.println(existe);
			}
			
		}
		
		if(existe) {
			a=1;
		}
		else {
			a=2;
			
			FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter("./data/usuarios.txt",true);
	            pw = new PrintWriter(fichero);
	            String linea = _nombreUsuario+","+_clave+"," + _admin;
	            pw.println(linea);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
			
		}
		
		return a;

	}
	
	public void almacenarJugador(String nombre, String posicion, String equipo, double precio ) {
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("./data/jugadores.txt",true);
            pw = new PrintWriter(fichero);
            String linea = nombre + "," + posicion+"," + equipo + "," + precio;
            pw.println(linea);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
		
	}

	public void agregarEquipoFantasia(EquipoFantasia equipo) {
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("./data/equiposFantasia.txt",true);
            pw = new PrintWriter(fichero);
            
            String usuario = equipo.darUsuario();
            String nombre = equipo.darNombre();
            double presupuesto= equipo.darPresupuesto();
            int puntos = equipo.darPuntos();
            String jugador1 = equipo.getJugador1().darNombre();
            String jugador2 = equipo.getJugador2().darNombre();
            String jugador3 = equipo.getJugador3().darNombre();
            String jugador4 = equipo.getJugador4().darNombre();
            String jugador5 = equipo.getJugador5().darNombre();
            String jugador6 = equipo.getJugador6().darNombre();
            String jugador7 = equipo.getJugador7().darNombre();
            String jugador8 = equipo.getJugador8().darNombre();
            String jugador9 = equipo.getJugador9().darNombre();
            String jugador10 = equipo.getJugador10().darNombre();
            String jugador11 = equipo.getJugador11().darNombre();
            String jugador12 = equipo.getJugador12().darNombre();
            String jugador13 = equipo.getJugador13().darNombre();
            String jugador14 = equipo.getJugador14().darNombre();
            String jugador15 = equipo.getJugador15().darNombre();
            String titular1 = String.valueOf(equipo.isTitular1());
            String titular2 = String.valueOf(equipo.isTitular1());
            String titular3 = String.valueOf(equipo.isTitular1());
            String titular4 = String.valueOf(equipo.isTitular1());
            String titular5 = String.valueOf(equipo.isTitular1());
            String titular6 = String.valueOf(equipo.isTitular1());
            String titular7 = String.valueOf(equipo.isTitular1());
            String titular8 = String.valueOf(equipo.isTitular1());
            String titular9 = String.valueOf(equipo.isTitular1());
            String titular10 = String.valueOf(equipo.isTitular1());
            String titular11 = String.valueOf(equipo.isTitular1());
            String titular12 = String.valueOf(equipo.isTitular1());
            String titular13 = String.valueOf(equipo.isTitular1());
            String titular14 = String.valueOf(equipo.isTitular1());
            String titular15 = String.valueOf(equipo.isTitular1());
            
            String linea = "\n"+usuario+","+nombre+","+presupuesto+","+puntos+","+jugador1+","+jugador2+","+
            		jugador3+","+jugador4+","+jugador5+","+jugador6+","+jugador7+","+jugador8+","+
            		jugador9+","+jugador10+","+jugador11+","+jugador12+","+jugador13+","+jugador14+","
            		+jugador15+","+titular1+","+titular2+","+titular3+","+titular4+","+titular5+","
            		+titular6+","+titular7+","+titular8+","+titular9+","+titular10+","+titular11+","
            		+titular12+","+titular13+","+titular14+","+titular15;
            pw.println(linea);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	
	public void registrarAlineacion(ArrayList<EquipoFantasia> equipos) {
		
		File Old_File=new File("./data/equiposFantasia.txt");
        Old_File.delete();
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("./data/equiposFantasia.txt",true);
            pw = new PrintWriter(fichero);
            
            for(int i=0;i<equipos.size();i++) {
            
            	EquipoFantasia equipo = equipos.get(i);
            	
            String usuario = equipo.darUsuario();
            String nombre = equipo.darNombre();
            double presupuesto= equipo.darPresupuesto();
            int puntos = equipo.darPuntos();
            String jugador1 = equipo.getJugador1().darNombre();
            String jugador2 = equipo.getJugador2().darNombre();
            String jugador3 = equipo.getJugador3().darNombre();
            String jugador4 = equipo.getJugador4().darNombre();
            String jugador5 = equipo.getJugador5().darNombre();
            String jugador6 = equipo.getJugador6().darNombre();
            String jugador7 = equipo.getJugador7().darNombre();
            String jugador8 = equipo.getJugador8().darNombre();
            String jugador9 = equipo.getJugador9().darNombre();
            String jugador10 = equipo.getJugador10().darNombre();
            String jugador11 = equipo.getJugador11().darNombre();
            String jugador12 = equipo.getJugador12().darNombre();
            String jugador13 = equipo.getJugador13().darNombre();
            String jugador14 = equipo.getJugador14().darNombre();
            String jugador15 = equipo.getJugador15().darNombre();
            String titular1 = String.valueOf(equipo.isTitular1());
            String titular2 = String.valueOf(equipo.isTitular1());
            String titular3 = String.valueOf(equipo.isTitular1());
            String titular4 = String.valueOf(equipo.isTitular1());
            String titular5 = String.valueOf(equipo.isTitular1());
            String titular6 = String.valueOf(equipo.isTitular1());
            String titular7 = String.valueOf(equipo.isTitular1());
            String titular8 = String.valueOf(equipo.isTitular1());
            String titular9 = String.valueOf(equipo.isTitular1());
            String titular10 = String.valueOf(equipo.isTitular1());
            String titular11 = String.valueOf(equipo.isTitular1());
            String titular12 = String.valueOf(equipo.isTitular1());
            String titular13 = String.valueOf(equipo.isTitular1());
            String titular14 = String.valueOf(equipo.isTitular1());
            String titular15 = String.valueOf(equipo.isTitular1());
            
            String linea = usuario+","+nombre+","+presupuesto+","+puntos+","+jugador1+","+jugador2+","+
            		jugador3+","+jugador4+","+jugador5+","+jugador6+","+jugador7+","+jugador8+","+
            		jugador9+","+jugador10+","+jugador11+","+jugador12+","+jugador13+","+jugador14+","
            		+jugador15+","+titular1+","+titular2+","+titular3+","+titular4+","+titular5+","
            		+titular6+","+titular7+","+titular8+","+titular9+","+titular10+","+titular11+","
            		+titular12+","+titular13+","+titular14+","+titular15;
            pw.println(linea);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        
	}
}

