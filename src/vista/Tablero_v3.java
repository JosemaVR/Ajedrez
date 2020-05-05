package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tablero_v3 extends JFrame implements WindowListener, ActionListener, MouseListener
{

	private static final long serialVersionUID = 1L;

	private JPanel contenedores;

	// Componentes

	private JButton[][] casillas = new JButton[8][8];

	// Colores
	private Color colorNegro =  new Color(173, 113, 0); // Casillas marron oscuro
	private Color colorBlanco = new Color(227, 194, 102);// Casillas amarillo crema
	
	// Posición actual:Caballos
	// Esquina superior izquierda en el tablero es (0,0).

	private int lineaCBa2 = 7;
	private int columnaCBa2 = 1;
	
	private int lineaCBa7 = 7;
	private int columnaCBa7 = 6;
	
	private int lineaCNh2 = 0;
	private int columnaCNh2 = 1;
	
	private int lineaCNh7 = 0;
	private int columnaCNh7 = 6;
	
	// Posición actual:Torres
	// Esquina superior izquierda en el tablero es (0,0).
	
	private int lineaTBa1 = 7;
	private int columnaTBa1 = 0;
	
	private int lineaTBa8 = 7;
	private int columnaTBa8 = 7;
	
	private int lineaTNh1 = 0;
	private int columnaTNh1 = 0;
	
	private int lineaTNh8 = 0;
	private int columnaTNh8 = 7;
	

	// Imagenes:
	//Caballos
	private ImageIcon caballoBa2 = new ImageIcon("./imagenes/sin_fondo/Caballo_blanco.png");
	private ImageIcon caballoBa7 = new ImageIcon("./imagenes/sin_fondo/Caballo_blanco.png");
	private ImageIcon caballoNh2 = new ImageIcon("./imagenes/sin_fondo/Caballo_negro.png");
	private ImageIcon caballoNh7 = new ImageIcon("./imagenes/sin_fondo/Caballo_negro.png");
	//Torres
	private ImageIcon torreTBa0 = new ImageIcon("./imagenes/sin_fondo/Torre_blanca.png");
	private ImageIcon torreTBa8 = new ImageIcon("./imagenes/sin_fondo/Torre_blanca.png");
	private ImageIcon torreTNh0 = new ImageIcon("./imagenes/sin_fondo/Torre_negra.png");
	private ImageIcon torreTNh8 = new ImageIcon("./imagenes/sin_fondo/Torre_negra.png");

	public Tablero_v3(int x, int y)
	{
		super("Tablero Java - (pulsa una casilla válida para mover el caballo)");

		contenedores = (JPanel) getContentPane();
		contenedores.setLayout(new GridLayout(8, 8));

		// Crear eventos oficios
		BotonAccion botonAccion = new BotonAccion();

		// Crear y añadir componentes del tablero
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				casillas[i][j] = new JButton();
				casillas[i][j].setPreferredSize(new Dimension(x, y));
				if ((i + j) % 2 != 0)
				{
					casillas[i][j].setBackground(colorNegro);

				}
				if ((i + j) % 2 == 0)
				{
					casillas[i][j].setBackground(colorBlanco);

				}
				contenedores.add(casillas[i][j]);
				casillas[i][j].addActionListener(botonAccion);
			}

		}
		//Posición inicial:
		//Caballos
		casillas[lineaCBa2][columnaCBa2].setIcon(caballoBa2);
		casillas[lineaCBa7][columnaCBa7].setIcon(caballoBa7);
		casillas[lineaCNh2][columnaCNh2].setIcon(caballoNh2);
		casillas[lineaCNh7][columnaCNh7].setIcon(caballoNh7);
		//Torres
		casillas[lineaTBa1][columnaTBa1].setIcon(torreTBa0);
		casillas[lineaTBa8][columnaTBa8].setIcon(torreTBa8);
		casillas[lineaTNh1][columnaTNh1].setIcon(torreTNh0);
		casillas[lineaTNh8][columnaTNh8].setIcon(torreTNh8);
		// Tamaño y monitor de la ventana

		setSize(750,750);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(false);

	}

	private boolean esMovimValido(int i, int j)
	{
		int lineaPosicion = Math.abs(i - lineaCBa2);
		int columnaPosicion = Math.abs(j - columnaCBa2);

		
		if ((lineaPosicion == 1) && (columnaPosicion == 2))
		{
			
			return true;
		}
		if ((columnaPosicion == 1) && (lineaPosicion == 2))
		{

			return true;
		}
		return false;
	}

	private void procesoClic(int i, int j)
	{

		if (esMovimValido(i, j) == false)
		{
			
			return;
		}
		casillas[lineaCBa2][columnaCBa2].setIcon(null);
		casillas[i][j].setIcon(caballoBa2);
		
		
		lineaCBa2 = i;
		columnaCBa2 = j;

	}

	private class BotonAccion implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0)
		{
			Object fuente = arg0.getSource();

			for (int i = 0; i < 8; i++)
			{
				for (int j = 0; j < 8; j++)
				{
					if (fuente == casillas[i][j])
					{
						
						
						procesoClic(i, j);
						return;
					}
				}
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub

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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
