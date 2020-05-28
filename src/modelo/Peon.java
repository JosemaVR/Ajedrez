package modelo;

public class Peon {
	
	public boolean movimientoValido(int a, int b, ColorPieza color) {
		Boolean movimiento = false;
		if(ColorPieza.BLANCO == color) {
			int posY = (Math.abs(a+1)*(-1));
			
			if ((a==1||a==7)&&posY==2) {
				movimiento = true;
			}
			if ((a==1||a==7)&&posY==1) {
				movimiento = true;
			}
			if((posY==1)) {
				movimiento = true;
			}
		}
		else if (ColorPieza.NEGRO == color) {
			int posY = (Math.abs(a+1));
			
			if ((a==1||a==7)&&posY==2) {
				movimiento = true;
			}
			if ((a==1||a==7)&&posY==1) {
				movimiento = true;
			}
			if((posY==1)) {
				movimiento = true;
			}
		}
		else{
			movimiento = false;
		}
		return movimiento;
	}

}
