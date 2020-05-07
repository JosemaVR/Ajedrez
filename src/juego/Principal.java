package juego;

import java.time.LocalDate;
import java.time.LocalTime;

public class Principal {

	public static void main(String[] args) {
		Vista objVista = new Vista();
		Modelo objModelo = new Modelo();
		new Controlador(objModelo, objVista);
		System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][Inicio del programa]");
	}
}