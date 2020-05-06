package juego;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Modelo
{

	public boolean esMovimValido(int i, int j, int linea, int columna)
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

	public void procesoClic(int i, int j, int linea, int columna, JButton[][] casillas, ImageIcon pieza)
	{

		if (esMovimValido(i, j, linea, columna) == false)
		{
			return;
		}
		casillas[linea][columna].setIcon(null);
		casillas[i][j].setIcon(pieza);
		linea = i;
		columna = j;

	}

	public void botonAccion(Object fuente,  int linea, int columna, JButton[][] casillas, ImageIcon pieza)
	{

		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (fuente == casillas[i][j])
				{
					procesoClic(i, j, linea, columna, casillas, pieza);
					return;
				}
			}
		}
	}
}
