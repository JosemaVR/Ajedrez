package modelo;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Reina {

	public ColorPieza color;
	public Icon icono;
	public int x, y;

	public Reina(ColorPieza color, int y, int x) {
		this.color = color;
		if(color == ColorPieza.BLANCO) {
			this.icono = new ImageIcon("imagenes/sin_fondo/Reina_blanca.png");
		}
		else if(color == ColorPieza.NEGRO) {
			this.icono = new ImageIcon("imagenes/sin_fondo/Reina_negra.png");
		}
		this.x = x;
		this.y = y;
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
