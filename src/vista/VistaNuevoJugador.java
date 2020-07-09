package vista;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VistaNuevoJugador extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JLabel lblNuevoJugador = new JLabel("Nombre nuevo jugador");
	public JTextField txtNombreNuevoJugador = new JTextField("",10);
	public JButton btnCrearNuevoJugador = new JButton("Crear");
	public JButton btnVolverNuevoJugador = new JButton("Crear partida");
	
	
	public VistaNuevoJugador() {
		
		setLayout(new FlowLayout());
		setTitle("Crear nuevo Jugador");
		add(lblNuevoJugador);
		add(txtNombreNuevoJugador);
		add(btnCrearNuevoJugador);
		add(btnVolverNuevoJugador);
		setSize(300, 150);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
	}
}
