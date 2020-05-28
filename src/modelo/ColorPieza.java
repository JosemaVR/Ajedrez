package modelo;

public enum ColorPieza {

	BLANCO, NEGRO;
	
	public ColorPieza turno(int turno) {
		if(turno==1) {
			return BLANCO;
		}else {
			return NEGRO;
		}
	}
	
	public int direccion() {
		if(this == BLANCO) {
			return -1;
		}else {
			return 1;
		}
	}
}
