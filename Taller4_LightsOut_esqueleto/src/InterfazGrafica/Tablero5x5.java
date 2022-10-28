package InterfazGrafica;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class Tablero5x5 extends JPanel {
	
	private int tamano =5;
	private Tablero tablero = new Tablero(tamano);
	
	
	public Tablero5x5(int dificultad, VentanaPrincipal JF) {
		addMouseListener(new MouseAdapter() {
			

			public void mouseClicked(MouseEvent e) {
				
				int click_x = e.getX();
				int click_y = e.getY();
				int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
				tablero.jugar(casilla[0], casilla[1]);
				
				repaint();
				int jugadas = tablero.darJugadas();
				JF.setPanelInferiorJugadas(jugadas);
				
				if(tablero.tableroIluminado()) {
					JOptionPane.showMessageDialog(null,"Juego Terminado. Haz ganado"); 
				}
			}
		});
		setBackground(Color.WHITE);
		tablero.desordenar(dificultad);


	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		int ladoTablero = tablero.darTablero().length;
		int altoPanelTablero = getHeight();
		int anchoPanelTablero = getWidth();
		int altoCasilla = altoPanelTablero / ladoTablero;
		int anchoCasilla = anchoPanelTablero / ladoTablero;

		int x = 0;
		int y = 0;

		for (int a = 0; a < tamano; a++) {
			for (int b = 0; b < tamano; b++) {

				if (tablero.darTablero()[a][b] == true) {
					g2d.setColor(Color.orange);
					RoundRectangle2D.Double casilla = new RoundRectangle2D.Double(x, y, anchoCasilla, altoCasilla, 20,
							20);
					g2d.fill(casilla);
					g2d.setColor(Color.white);
					g2d.draw(casilla);
				} else {
					g2d.setColor(Color.black);
					RoundRectangle2D.Double casilla = new RoundRectangle2D.Double(x, y, anchoCasilla, altoCasilla, 20,
							20);
					g2d.fill(casilla);
					g2d.setColor(Color.white);
					g2d.draw(casilla);

				}
				x += anchoCasilla;
				if (b + 1 == tamano) {
					x = 0;
				}

				
			}
			y += altoCasilla;
		}
	}
	
	private int[] convertirCoordenadasACasilla(int x, int y)
	{
	int ladoTablero = tablero.darTablero().length;;
	int altoPanelTablero = getHeight();
	int anchoPanelTablero = getWidth();
	int altoCasilla = altoPanelTablero / ladoTablero;
	int anchoCasilla = anchoPanelTablero / ladoTablero;
	int fila = (int) (y / altoCasilla);
	int columna = (int) (x / anchoCasilla);
	return new int[] { fila, columna };
	}
	
	public void reiniciar() {
		tablero.reiniciar();
		repaint();
	}
	
}
