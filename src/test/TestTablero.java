package test;

import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;

public class TestTablero {

	public static void main(String[] args) {

		//Pieza torreBlancaIzq = new Pieza("Torre", 0, 7, 5, Color.blanca);

		Tablero prueba1 = new Tablero();
		int i = 0;
		int j = 0;
		//prueba1.añadirPieza(torreBlancaIzq);
		for (i=0;i<8;i++) {
			for(j=0;j<8;j++) {
				System.out.print(" " + prueba1.getTablero()[i][j]);
			}
			System.out.print("\n");
		}
		
	}
}
