package modelo;

public class Pieza {
	
	private TipoPieza tipo;
	private int x, y;
	private Color color;
	
	public Pieza() {
		this.tipo = null;
		this.x = 0;
		this.y = 0;
		this.color = null;
	}
	
	public Pieza(String tipo, int x, int y, Color color) {
		this.tipo = new TipoPieza(tipo);
		this.x = x;
		this.y = y;
		this.color = color;
	}

	
	public TipoPieza getTipoPieza() {
		return tipo;
	}

	public void setTipoPieza(TipoPieza tipo) {
		this.tipo = tipo;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public String toString() {
		return getTipoPieza().toString() + " " + getColor();
	}
}
