package modelo;

public class Pieza {

	public ColorPieza colorPieza;
	public TipoPieza tipoPieza;
	public Integer posX, posY;

	public Pieza() {
		this.colorPieza = ColorPieza.BLANCO;
		this.tipoPieza = TipoPieza.PEON;
		this.posX = null;
		this.posY = null;
	}
	
	public Pieza(ColorPieza colorPieza, TipoPieza tipoPieza, Integer posX, Integer posY) {
		this.colorPieza = colorPieza;
		this.tipoPieza = tipoPieza;
		this.posX = posX;
		this.posY = posY;
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

	public Integer getPosX() {
		return posX;
	}

	public void setPosX(Integer posX) {
		this.posX = posX;
	}

	public Integer getPosY() {
		return posY;
	}

	public void setPosY(Integer posY) {
		this.posY = posY;
	}
	
	public String toString() {
		return "Es un/a " + getTipoPieza() + " de color " + getColorPieza() + ", comienza en la posicion " + getPosX() + ", " + getPosY();
	}
}
