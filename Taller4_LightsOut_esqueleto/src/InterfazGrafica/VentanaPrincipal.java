package InterfazGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.BorderLayout;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private int dificultad;
	private PanelInferior panelInferior;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlatLightLaf.install();
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		PanelSuperior panelSuperior = new PanelSuperior();
		panelSuperior.setBounds(0, 0, 700, 40);
		
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		
		
		
		int jugadas=0;
		String nombre="";
		panelInferior = new PanelInferior(jugadas,nombre);
		panelInferior.setBounds(0,0,700,40);
		contentPane.add(panelInferior, BorderLayout.SOUTH);
		
		if(panelSuperior.darFacil().isSelected()) {
			dificultad=3;
		}
		if(panelSuperior.darMedio().isSelected()) {
			dificultad=6;
		}
		if(panelSuperior.darDificil().isSelected()) {
			dificultad=9;
		}
		Tablero5x5 panelCentral = new Tablero5x5(dificultad, this);
		panelSuperior.setBounds(0, 0, 540, 600);
		PanelDerecha panelDerecha = new PanelDerecha(dificultad,this);
		contentPane.add(panelDerecha, BorderLayout.EAST);
		contentPane.add(panelCentral, BorderLayout.CENTER);
		
	}
	
	public void setPanelInferiorJugadas(int jugadas) {
		String nombre ="";
		PanelInferior panelInferior2 = new PanelInferior(jugadas, nombre);
		panelInferior2.setBounds(0,0,700,40);
		contentPane.remove(panelInferior);
		contentPane.add(panelInferior2, BorderLayout.SOUTH);
		
	}
	
	public void setPanelInferiorNombre(String nombre) {
		int jugadas=0;
		PanelInferior panelInferior2 = new PanelInferior(jugadas, nombre);
		panelInferior2.setBounds(0,0,700,40);
		contentPane.remove(panelInferior);
		contentPane.add(panelInferior2, BorderLayout.SOUTH);
		
	}
	

}
