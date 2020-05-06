package juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import versionCero.Tablero_v3;

public class Controlador implements WindowListener, ActionListener
{
	Vista objVista = null;
	Modelo objModelo = null;
	Tablero_v3 pieza = null;

	public Controlador(Vista objVista, Modelo objModelo)
	{

	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Object fuente = arg0.getSource();

		objModelo.botonAccion(fuente, 7, 1, objVista.casillas, pieza.caballoBa2 );

	}

	@Override
	public void windowActivated(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}
}
