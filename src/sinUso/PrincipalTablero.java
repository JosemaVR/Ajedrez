package sinUso;

public class PrincipalTablero
{

	public static void main(String[] args)
	{
		ModeloTablero modelo = new ModeloTablero();
		VistaTablero vista = new VistaTablero();
		
		new ControladorTablero (vista, modelo);

	}

}
