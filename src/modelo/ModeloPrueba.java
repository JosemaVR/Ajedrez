package modelo;

public class ModeloPrueba {
	
	public String piezas[][] = new String[8][8]; 
	
	
	public void newGame() {
		 for (int i=0; i<8; i++) {
			 for (int j=0; j<8; j++) {
				 piezas[i][j] = "";
			 }
		 }
		
		piezas[0][0] = "TB" ;
		piezas[7][0] = "TB" ;
		piezas[0][7] = "TN" ;
		piezas[7][7] = "TN" ;
		
		piezas[1][0] = "CB" ;
		piezas[6][0] = "CB" ;
		piezas[1][7] = "CN" ;
		piezas[6][7] = "CN" ;
		
		piezas[2][0] = "AB" ;
		piezas[5][0] = "AB" ;
		piezas[2][7] = "AN" ;
		piezas[5][7] = "AN" ;
		
		piezas[3][0] = "KB" ;
		piezas[4][0] = "QB" ;
		piezas[3][7] = "KN" ;
		piezas[4][7] = "QN" ;
		
		piezas[0][1] = "PB" ;
		piezas[1][1] = "PB" ;
		piezas[2][1] = "PB" ;
		piezas[3][1] = "PB" ;
		piezas[4][1] = "PB" ;
		piezas[5][1] = "PB" ;
		piezas[6][1] = "PB" ;
		piezas[7][1] = "PB" ;
		
		piezas[0][6] = "PN" ;
		piezas[1][6] = "PN" ;
		piezas[2][6] = "PN" ;
		piezas[3][6] = "PN" ;
		piezas[4][6] = "PN" ;
		piezas[5][6] = "PN" ;
		piezas[6][6] = "PN" ;
		piezas[7][6] = "PN" ;
	} 
	
	public boolean movimientosPeonBlanco(int posX, int posY, int posSelX, int posSelY) {
		if (piezas[posX][posY+1]==""&&piezas[posSelX][posSelY]==piezas[posX][posY+1]) {
			piezas[posX][posY]="";
			piezas[posSelX][posSelY]="PB";
			return true;
		}
		if (piezas[posX+1][posY+1]!="") {
			piezas[posX][posY]="";
			piezas[posSelX][posSelY]="PB";
			return true;
		}
		if (piezas[posX-1][posY+1]!="") {
			piezas[posX][posY]="";
			piezas[posSelX][posSelY]="PB";
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean movimientosPeonNegro(int posX, int posY, int posSelX, int posSelY) {
		if (piezas[posX][posY-1]==""&&piezas[posSelX][posSelY]==piezas[posX][posY-1]) {
			piezas[posX][posY]="";
			piezas[posSelX][posSelY]="PN";
			return true;
		}
		if (piezas[posX+1][posY-1]!="") {
			piezas[posX][posY]="";
			piezas[posSelX][posSelY]="PN";
			return true;
		}
		if (piezas[posX-1][posY-1]!="") {
			piezas[posX][posY]="";
			piezas[posSelX][posSelY]="PN";
			return true;
		}
		else {
			return false;
		}
	}
	
}
