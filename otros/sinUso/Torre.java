package sinUso;

public class Torre {
	
	private String nombre;
	private int valor;
	
	public Torre() {
		this.nombre = "Torre";
		this.valor = 5;
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
		return getNombre();
	}
}