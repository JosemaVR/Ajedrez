package modelo;

public class Jugador {
	String nombre = new String();
	ColorPieza color = null;
	int turno = 0;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public ColorPieza getColor() {
		return color;
	}
	public void setColor(ColorPieza color) {
		this.color = color;
	}
	
	
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
}

