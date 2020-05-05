package modelo;

public class Caballo {

	private String nombre;
	private int valor;

	public Caballo() {
		this.nombre = "Caballo";
		this.valor = 4;
	}



	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}

	public String toString() {
		return nombre;
	}
}