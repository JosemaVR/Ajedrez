package modelo;

import modelo.Pieza;

public class Torre {
	
	private String nombre;
	private int valor;
	
	
	
	public Pieza torreBlancaIzq = new Pieza("Torre", 0, 7, 5, Color.blanca);
	public Pieza torreBlancaDer = new Pieza("Torre", 7, 7, 5, Color.blanca);
	public Pieza torreNegraIzq = new Pieza("Torre", 0, 0, 5, Color.negra);
	public Pieza torreNegraDer = new Pieza("Torre", 7, 0, 5, Color.negra);
	
	
	
	//Como se mueve
	//4 Torres iniciales
	//Movimiento lateral y vertical	
}
