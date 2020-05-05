package test;

import controlador.ControladorTablero;
import modelo.ModeloTablero;
import vista.VistaTablero;

public class PrincipalTablero
{

	public static void main(String[] args)
	{
		ModeloTablero modelo = new ModeloTablero();
		VistaTablero vista = new VistaTablero();
		
		new ControladorTablero (vista, modelo);

	}

}
