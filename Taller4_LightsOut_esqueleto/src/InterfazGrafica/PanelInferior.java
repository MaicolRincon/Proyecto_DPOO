package InterfazGrafica;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class PanelInferior extends JPanel {

	private JLabel txtJugadas;

	
	public PanelInferior(int jugadas, String nombre) {
		
		JLabel lblNewLabel_1_1 = new JLabel("Jugadas:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		
		txtJugadas = new JLabel(String.valueOf(jugadas));
		txtJugadas.setHorizontalAlignment(SwingConstants.CENTER);
		txtJugadas.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3 = new JLabel("Jugador:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		
		JLabel txtNombre = new JLabel(nombre);
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addComponent(txtJugadas, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addComponent(txtJugadas, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
		);
		setLayout(groupLayout);

	}
	

}
