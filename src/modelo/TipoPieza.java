package modelo;

public class TipoPieza {

	private Torre torre;
	private Caballo caballo;
	private Alfil alfil;
	private Reina reina;
	private Rey rey;
	private Peon peon;
	
	public TipoPieza(String tipo) {
		if(tipo == "torre") {
			this.torre = new Torre();
		} else if (tipo == "caballo") {
			this.caballo = new Caballo();
		} else if (tipo == "alfil") {
			this.alfil = new Alfil();
		} else if (tipo == "reina") {
			this.reina = new Reina();
		} else if (tipo == "rey") {
			this.rey = new Rey();
		} else if (tipo == "peon") {
			this.peon = new Peon();
		} else {
			System.out.println("Error: tipo de pieza no válida.");
		}
	}
	
	public String toString() {
		
	}
}