package modelo;

public class Tablero {
	private Pieza[][] tablero;
	
	public Tablero() {
		tablero = new Pieza[8][8];
		a�adirPieza(new Pieza("torre", 7, 7, Color.blanca));
		a�adirPieza(new Pieza("torre", 7, 0, Color.blanca));
		a�adirPieza(new Pieza("torre", 0, 0, Color.negra));
		a�adirPieza(new Pieza("torre", 0, 7, Color.negra));
		a�adirPieza(new Pieza("caballo", 7, 6, Color.blanca));
		a�adirPieza(new Pieza("caballo", 7, 1, Color.blanca));
		a�adirPieza(new Pieza("caballo", 0, 6, Color.negra));
		a�adirPieza(new Pieza("caballo", 0, 1, Color.negra));
		
	}

	public Pieza[][] getTablero() {
		return tablero;
	}

	public void setTablero(Pieza[][] tablero) {
		this.tablero = tablero;
	}
	
	public void a�adirPieza(Pieza pieza) {
		int x = pieza.getX();
		int y = pieza.getY();
		tablero[x][y] = pieza;
	}
}