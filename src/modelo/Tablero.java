package modelo;

public class Tablero {
	private String[][] tablero;
	
	public Tablero() {
		tablero = new String[8][8];
		aņadirPieza(new Pieza("Torre", 7, 7, 5, Color.blanca));
		aņadirPieza(new Pieza("Torre", 7, 0, 5, Color.blanca));
		aņadirPieza(new Pieza("Torre", 0, 0, 5, Color.negra));
		//aņadirPieza(new Pieza(new Torre(), 0, 7, Color.negra));
	}

	public String[][] getTablero() {
		return tablero;
	}

	public void setTablero(String[][] tablero) {
		this.tablero = tablero;
	}
	
	public void aņadirPieza(Pieza pieza) {
		int x = pieza.getX();
		int y = pieza.getY();
		tablero[x][y] = pieza.getNombre() + " " + pieza.getColor();
	}
}