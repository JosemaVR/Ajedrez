package modelo;

public class Tablero {
	private String tablero[][]=new String[8][8];
	
	public Tablero() {
		int i,j;
		for (i=0;i<8;i++) {
			for(j=0;j<8;j++) {
				if(0 == 1 - (i+j) % 2) {
					tablero[i][j] = "N";
				} else {
					tablero[i][j] = "B";
				}
			}
		}
	}

	public String[][] getTablero() {
		return tablero;
	}

	public void setTablero(String tablero[][]) {
		this.tablero = tablero;
	}
}
