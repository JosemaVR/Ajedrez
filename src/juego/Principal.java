package juego;

import java.time.LocalTime;

public class Principal {

	public static void main(String[] args) {
		Vista objVista = new Vista();
		Modelo objModelo = new Modelo();

		new Controlador(objModelo, objVista);

		System.out.println("[" + LocalTime.now() + "][Inicio del programa]");
		
		
	}
}