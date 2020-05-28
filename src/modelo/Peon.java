package modelo;

public class Peon {
	int color = 0;
	
	public void colorPieza(int turno) {
		if (turno==1) {
			color = 1;
		}
		else {
			color = 0;
		}
	}
	
	public int direccion() {
		
		if(color==1) {
			return -1;
		}else {
			return 1;
		}
	}
	
	public boolean movimientoValido(int a, int b) {
		
		int posY = (Math.abs(a+1)) * direccion();
		
		if ((a==1||a==7)&&posY==2) {
			return true;
		}
		
		if ((a==1||a==7)&&posY==1) {
			return true;
		}
		
		if((posY==1)) {
			return true;
		}
		else{
			return false;
		}
	}
	public static void main(String[] args) {
		new Peon().direccion();
	}
}
