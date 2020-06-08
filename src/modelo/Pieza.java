package modelo;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Pieza {

	public ColorPieza colorPieza;
	public TipoPieza tipoPieza;
	public Integer x, y;
	public Icon icono;

	public Pieza() {
		this.colorPieza = ColorPieza.BLANCO;
		this.tipoPieza = TipoPieza.PEON;
		this.x = 0;
		this.y = 0;
		this.icono = null;
	}
	
	public Pieza(ColorPieza colorPieza, TipoPieza tipoPieza, Integer y, Integer x) {
		this.colorPieza = colorPieza;
		this.tipoPieza = tipoPieza;
		this.x = x;
		this.y = y;
		if(tipoPieza == TipoPieza.ALFIL) {
			if(colorPieza == ColorPieza.BLANCO) {
				this.icono = new ImageIcon("imagenes/sin_fondo/Alfil_blanco.png");
			}
			else if(colorPieza == ColorPieza.NEGRO) {
				this.icono = new ImageIcon("imagenes/sin_fondo/Alfil_negro.png");
			}
		}
		else if(tipoPieza == TipoPieza.CABALLO) {
			if(colorPieza == ColorPieza.BLANCO) {
				this.icono = new ImageIcon("imagenes/sin_fondo/Caballo_blanco.png");
			}
			else if(colorPieza == ColorPieza.NEGRO) {
				this.icono = new ImageIcon("imagenes/sin_fondo/Caballo_negro.png");
			}
		}
		else if(tipoPieza == TipoPieza.PEON) {
			if(colorPieza == ColorPieza.BLANCO) {
				this.icono = new ImageIcon("imagenes/sin_fondo/Peon_blanco.png");
			}
			else if(colorPieza == ColorPieza.NEGRO) {
				this.icono = new ImageIcon("imagenes/sin_fondo/Peon_negro.png");
			}
		}
		else if(tipoPieza == TipoPieza.TORRE) {
			if(colorPieza == ColorPieza.BLANCO) {
				this.icono = new ImageIcon("imagenes/sin_fondo/Torre_blanca.png");
			}
			else if(colorPieza == ColorPieza.NEGRO) {
				this.icono = new ImageIcon("imagenes/sin_fondo/Torre_negra.png");
			}
		}
		else if(tipoPieza == TipoPieza.REINA) {
			if(colorPieza == ColorPieza.BLANCO) {
				this.icono = new ImageIcon("imagenes/sin_fondo/Reina_blanca.png");
			}
			else if(colorPieza == ColorPieza.NEGRO) {
				this.icono = new ImageIcon("imagenes/sin_fondo/Reina_negra.png");
			}
		}
		else if(tipoPieza == TipoPieza.REY) {
			if(colorPieza == ColorPieza.BLANCO) {
				this.icono = new ImageIcon("imagenes/sin_fondo/Rey_blanco.png");
			}
			else if(colorPieza == ColorPieza.NEGRO) {
				this.icono = new ImageIcon("imagenes/sin_fondo/Rey_negro.png");
			}
		}
	}

	public ColorPieza getColorPieza() {
		return colorPieza;
	}

	public void setColorPieza(ColorPieza colorPieza) {
		this.colorPieza = colorPieza;
	}

	public TipoPieza getTipoPieza() {
		return tipoPieza;
	}

	public void setTipoPieza(TipoPieza tipoPieza) {
		this.tipoPieza = tipoPieza;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}
	
	public Icon getIcono() {
		return icono;
	}

	public void setIcono(Icon icono) {
		this.icono = icono;
	}

	public String toString() {
		return "Es un/a " + getTipoPieza() + " de color " + getColorPieza() + ", comienza en la posicion " + getX() + ", " + getY();
	}
}
