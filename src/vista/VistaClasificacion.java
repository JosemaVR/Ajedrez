package vista;

import java.awt.FlowLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VistaClasificacion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TextArea txtAreaConsultaJugadores = new TextArea(20,50);
	public JButton btnVolver = new JButton("Volver");
	
	public VistaClasificacion() {
		setTitle("Clasificación de jugadores");
		setLayout(new FlowLayout());
		
		add(txtAreaConsultaJugadores);
		add(btnVolver);
		
		setSize(450, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
}
