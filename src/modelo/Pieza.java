package modelo;

public class Pieza {
	
	private int posicion[][] = new int[8][8];
	private int valor;
	private int color;
	
	public Pieza() {
		this.posicion = new int [0][0];
		this.valor = 0;
		this.color = 0;
	}
	
	public Pieza(int posicion[][], int valor, int color) {
		this.posicion = posicion;
		this.valor = valor;
		this.color = color;
	}

	public int[][] getPosicion() {
		return posicion;
	}

	public void setPosicion(int[][] posicion) {
		this.posicion = posicion;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
}
