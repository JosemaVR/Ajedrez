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

public class Tablero_v3 extends JFrame implements WindowListener, ActionListener
{

	private static final long serialVersionUID = 1L;

	private Container contenedores;

	// Componentes

	private JButton[][] casillas = new JButton[8][8];

	// Colores
	private Color colorNegro = Color.black; // Casillas negras

	// Posición actual:
	// Esquina superior izquierda en el tablero es (0,0).
	private int linea = 7;
	private int columna = 1;

	// Imagenes:
	private ImageIcon caballo = new ImageIcon("./imagenes/con_fondo/Caballo_negro.png");

	public Tablero_v3()
	{
		super("Tablero Java - (pulsa una casilla válida para mover el caballo)");

		contenedores = getContentPane();
		contenedores.setLayout(new GridLayout(8, 8));

		// Crear eventos oficios
		BotonAccion botonAccion = new BotonAccion();

		// Crear y añadir componentes del tablero

		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				casillas[i][j] = new JButton();
				if ((i + j) % 2 != 0)
				{
					casillas[i][j].setBackground(colorNegro);

				}
				contenedores.add(casillas[i][j]);
				casillas[i][j].addActionListener(botonAccion);
			}

		}
		casillas[linea][columna].setIcon(caballo);
		// Tamaño y monitor de la ventana

		setSize(250, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private boolean esMovimValido(int i, int j)
	{
		int lineaPosicion = Math.abs(i - linea);
		int columnaPosicion = Math.abs(j - columna);

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
		casillas[linea][columna].setIcon(null);
		casillas[i][j].setIcon(caballo);
		linea = i;
		columna = j;

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

	public static void main(String[] args)
	{
		new Tablero_v3();

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

}
