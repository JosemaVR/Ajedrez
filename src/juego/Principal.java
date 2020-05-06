package juego;

import java.time.LocalTime;

public class Principal {

	public static void main(String[] args) {
		Vista v = new Vista();
		//Modelo m = new Modelo();
		//new Controlador(m, v);
		System.out.println("[" + LocalTime.now() + "][Inicio del programa]");
	}
}