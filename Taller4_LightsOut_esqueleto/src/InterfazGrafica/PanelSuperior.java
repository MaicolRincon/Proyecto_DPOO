package InterfazGrafica;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelSuperior extends JPanel {
	
	private JRadioButton facil;
	private JRadioButton medio;
	private JRadioButton dificil;
	
	public PanelSuperior() {
		setBackground(Color.RED);
		setForeground(new Color(30, 144, 255));
		setBounds(0,0,700,40);
		
		JLabel lblNewLabel = new JLabel("Tama\u00F1o:");
		lblNewLabel.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"5x5"}));
		
		JLabel lblDificultad = new JLabel("Dificultad:");
		lblDificultad.setForeground(Color.WHITE);
		lblDificultad.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		
		facil = new JRadioButton("F\u00E1cil");
		facil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				medio.setSelected(false);
				dificil.setSelected(false);
			}
		});
		facil.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		facil.setForeground(Color.WHITE);
		facil.setBackground(Color.RED);
		facil.setSelected(true);
		
		medio = new JRadioButton("Medio");
		medio.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				facil.setSelected(false);
				dificil.setSelected(false);
			}
		});
		medio.setForeground(Color.WHITE);
		medio.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		medio.setBackground(Color.RED);
		
		dificil = new JRadioButton("Dif\u00EDcil");
		dificil.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				facil.setSelected(false);
				medio.setSelected(false);
			}
		});
		dificil.setForeground(Color.WHITE);
		dificil.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		dificil.setBackground(Color.RED);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(98, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(lblDificultad, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(facil, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(medio, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(dificil, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(dificil, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(medio, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(facil)
						.addComponent(lblDificultad, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	public JRadioButton darFacil() {
		return facil;
	}
	public JRadioButton darMedio() {
		return medio;
	}
	public JRadioButton darDificil() {
		return dificil;
	}
}
