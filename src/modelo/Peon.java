package modelo;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Peon {

	public ColorPieza color;
	public Icon icono;
	public int x, y;

	public Peon(ColorPieza color, int y, int x) {
		this.color = color;
		if(color == ColorPieza.BLANCO) {
			this.icono = new ImageIcon("imagenes/sin_fondo/Peon_blanco.png");
		}
		else if(color == ColorPieza.NEGRO) {
			this.icono = new ImageIcon("imagenes/sin_fondo/Peon_negro.png");
		}
		this.x = x;
		this.y = y;
	}
	
	public Peon() {
		this.color = null;
		this.x = 0;
		this.y = 0;
		this.icono = null;
	}
	
	public ColorPieza getColor() {
		return color;
	}

	public void setColor(ColorPieza color) {
		this.color = color;
	}

	public Icon getIcono() {
		return icono;
	}

	public void setIcono(Icon icono) {
		this.icono = icono;
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


}
