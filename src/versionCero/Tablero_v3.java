package versionCero;

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

	JPanel contenedores;

	// Componentes

	JButton[][] casillas = new JButton[8][8];

	// Colores
	Color colorNegro = new Color(173, 113, 0); // Casillas marron oscuro
	Color colorBlanco = new Color(227, 194, 102);// Casillas amarillo crema

	// Posici�n Inicial:Caballos
	// Esquina superior izquierda en el tablero es (0,0).

	int lineaCBa2 = 7;
	int columnaCBa2 = 1;

	int lineaCBa7 = 7;
	int columnaCBa7 = 6;

	int lineaCNh2 = 0;
	int columnaCNh2 = 1;

	int lineaCNh7 = 0;
	int columnaCNh7 = 6;

	// Posici�n Inicial:Torres
	// Esquina superior izquierda en el tablero es (0,0).

	int lineaTBa1 = 7;
	int columnaTBa1 = 0;

	int lineaTBa8 = 7;
	int columnaTBa8 = 7;

	int lineaTNh1 = 0;
	int columnaTNh1 = 0;

	int lineaTNh8 = 0;
	int columnaTNh8 = 7;

	// Posici�n Inicial:Alfiles
	// Esquina superior izquierda en el tablero es (0,0).

	int lineaABa3 = 7;
	int columnaABa3 = 2;

	int lineaABa6 = 7;
	int columnaABa6 = 5;

	int lineaANh3 = 0;
	int columnaANh3 = 2;

	int lineaANh6 = 0;
	int columnaANh6 = 5;

	// Posici�n Inicial:Reinas
	// Esquina superior izquierda en el tablero es (0,0).

	int lineaQBa4 = 7;
	int columnaQBa4 = 3;

	int lineaQNh4 = 0;
	int columnaQNh4 = 3;

	// Posici�n Inicial:Reyess
	// Esquina superior izquierda en el tablero es (0,0).

	int lineaRBa5 = 7;
	int columnaRBa5 = 4;

	int lineaRNh5 = 0;
	int columnaRNh5 = 4;

	// Imagenes:
	// Caballos
	public ImageIcon caballoBa2 = new ImageIcon("./imagenes/sin_fondo/Caballo_blanco.png");
	public ImageIcon caballoBa7 = new ImageIcon("./imagenes/sin_fondo/Caballo_blanco.png");
	public ImageIcon caballoNh2 = new ImageIcon("./imagenes/sin_fondo/Caballo_negro.png");
	public ImageIcon caballoNh7 = new ImageIcon("./imagenes/sin_fondo/Caballo_negro.png");
	// Torres
	public ImageIcon torreTBa0 = new ImageIcon("./imagenes/sin_fondo/Torre_blanca.png");
	public ImageIcon torreTBa8 = new ImageIcon("./imagenes/sin_fondo/Torre_blanca.png");
	public ImageIcon torreTNh0 = new ImageIcon("./imagenes/sin_fondo/Torre_negra.png");
	public ImageIcon torreTNh8 = new ImageIcon("./imagenes/sin_fondo/Torre_negra.png");
	// Alfiles
	public ImageIcon AlfilABa2 = new ImageIcon("./imagenes/sin_fondo/Alfil_blanco.png");
	public ImageIcon AlfilABa6 = new ImageIcon("./imagenes/sin_fondo/Alfil_blanco.png");
	public ImageIcon AlfilANa2 = new ImageIcon("./imagenes/sin_fondo/Alfil_negro.png");
	public ImageIcon AlfilANh6 = new ImageIcon("./imagenes/sin_fondo/Alfil_negro.png");
	 // Reinas
	public ImageIcon ReinaQBa4 = new ImageIcon("./imagenes/con_fondo/Reina1_blanca.png");
	public ImageIcon ReinaQNh4 = new ImageIcon("./imagenes/con_fondo/Reina1_negra.png");
	 // Reyes
	public ImageIcon ReyRBa5 = new ImageIcon("./imagenes/sin_fondo/Rey_blanco.png");
	public ImageIcon ReyRNh5 = new ImageIcon("./imagenes/sin_fondo/Rey_negro.png");

	public Tablero_v3(int x, int y)
	{
		super("Tablero Java - (pulsa una casilla v�lida para mover el caballo)");

		contenedores = (JPanel) getContentPane();
		contenedores.setLayout(new GridLayout(8, 8));

		// Crear eventos oficios
		BotonAccion botonAccion = new BotonAccion();

		// Crear y a�adir componentes del tablero
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
		// Posici�n inicial:
		// Caballos
		casillas[7][1].setIcon(caballoBa2);
		casillas[7][6].setIcon(caballoBa7);
		casillas[0][1].setIcon(caballoNh2);
		casillas[0][6].setIcon(caballoNh7);
		// Torres
		casillas[7][0].setIcon(torreTBa0);
		casillas[7][7].setIcon(torreTBa8);
		casillas[0][0].setIcon(torreTNh0);
		casillas[0][7].setIcon(torreTNh8);
		// Alfiles
		casillas[7][2].setIcon(AlfilABa2);
		casillas[7][5].setIcon(AlfilABa6);
		casillas[0][2].setIcon(AlfilANa2);
		casillas[0][5].setIcon(AlfilANh6);
		// Reinas
		casillas[7][3].setIcon(ReinaQBa4);
		casillas[0][3].setIcon(ReinaQNh4);
		// Reyes
		casillas[7][4].setIcon(ReyRBa5);
		casillas[0][4].setIcon(ReyRNh5);
		// Tama�o y monitor de la ventana

		setSize(750, 750);
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
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

}
