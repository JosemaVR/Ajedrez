package modelo;

public class Pieza {
	
	private String nombre;
	private int x, y, valor;
	private Color color;
	
	public Pieza() {
		this.nombre = "";
		this.x = 0;
		this.y = 0;
		this.valor = 0;
		this.color = null;
	}
	
	public Pieza(String nombre, int x, int y, int valor, Color color) {
		this.nombre = nombre;
		this.x = x;
		this.y = y;
		this.valor = valor;
		this.color = color;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
