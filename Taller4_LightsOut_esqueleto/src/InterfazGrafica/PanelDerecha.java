package InterfazGrafica;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class PanelDerecha extends JPanel {

	
	public PanelDerecha(int dificultad, VentanaPrincipal ventana) {
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevo.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				btnNuevo.setBackground(new Color(30, 144, 255));
			}
			
			public void mouseExited(MouseEvent e) {
				btnNuevo.setBackground(Color.blue);
			}
		});
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setBackground(Color.BLUE);
		btnNuevo.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		
		JButton btnReiniciar = new JButton("REINICIAR");
		btnReiniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReiniciar.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				btnReiniciar.setBackground(new Color(30, 144, 255));
			}
			
			public void mouseExited(MouseEvent e) {
				btnReiniciar.setBackground(Color.blue);
			}
			
			public void mouseClicked(MouseEvent e) {
				Tablero5x5 tablero = new Tablero5x5(dificultad,ventana);
				tablero.reiniciar();
			}
		});
		btnReiniciar.setForeground(Color.WHITE);
		btnReiniciar.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		btnReiniciar.setBackground(Color.BLUE);
		
		JButton btnTop = new JButton("TOP-10");
		btnTop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTop.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				btnTop.setBackground(new Color(30, 144, 255));
			}
			
			public void mouseExited(MouseEvent e) {
				btnTop.setBackground(Color.blue);
			}
		});
		btnTop.setForeground(Color.WHITE);
		btnTop.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		btnTop.setBackground(Color.BLUE);
		
		JButton btnCambiarJugador = new JButton("CAMBIAR JUGADOR");
		btnCambiarJugador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCambiarJugador.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				btnCambiarJugador.setBackground(new Color(30, 144, 255));
			}
			
			public void mouseExited(MouseEvent e) {
				btnCambiarJugador.setBackground(Color.blue);
			}
			
			public void mouseClicked(MouseEvent e) {
				String nombre = JOptionPane.showInputDialog("Ingrese el nombre del Jugador: ");
				VentanaPrincipal ven = new VentanaPrincipal();
				ven.setPanelInferiorNombre(nombre);
			}
		});
		btnCambiarJugador.setForeground(Color.WHITE);
		btnCambiarJugador.setFont(new Font("Roboto Black", Font.PLAIN, 12));
		btnCambiarJugador.setBackground(Color.BLUE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnTop, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCambiarJugador, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnNuevo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnReiniciar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(169)
					.addComponent(btnNuevo, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnReiniciar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnTop, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCambiarJugador, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(217, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
