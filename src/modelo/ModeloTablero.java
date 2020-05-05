package modelo;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ModeloTablero 
{

	// Imagenes:
	public ImageIcon caballo = new ImageIcon("./imagenes/con_fondo/Caballo_negro.png");
	
	public JButton[][] casillas = new JButton[8][8];
	public int linea = 7;
	public int columna = 1;

	public boolean esMovimValido(int i, int j) {
		int lineaPosicion = Math.abs(i - linea);
		int columnaPosicion = Math.abs(j - columna);
		
		if ((lineaPosicion == 1) && (columnaPosicion == 2)) {
			
			return true;
		}
		if ((columnaPosicion == 1) && (lineaPosicion == 2)) {
			
			return true;
		}
		return false;
	}
	public  void procesoClic(int i, int j) {
		
		if (esMovimValido(i, j)== false) {
			return;
		}
		casillas[linea][columna].setIcon(null);
		casillas[i][j].setIcon(caballo);
		linea = i;
		columna= j;
		
	}
	public void botonAccion (Object fuente) {
		
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (fuente == casillas[i][j]){
					procesoClic(i,j);
					return;
				}
			}
		}
	}
	
	
}
