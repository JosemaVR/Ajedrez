package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class VistaTablero extends JFrame implements WindowListener
{

	private static final long serialVersionUID = 1L;

	private Container contenedores;
	private Color colorNegro = Color.black; // Casillas negras

	public VistaTablero()
	{

		super("Tablero Java - (pulsa una casilla válida para mover el caballo)");

		contenedores = getContentPane();
		contenedores.setLayout(new GridLayout(8, 8));
		

		//Tamaño y monitor de la ventana
		
		setSize (750,750);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);		
		
		
	}

	@Override
	public void windowActivated(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

}
