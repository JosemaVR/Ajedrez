package juego;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Controlador implements WindowListener, ActionListener
{
	Vista objVista = null;
	Modelo objModelo = null;
	Border bordeRojo = BorderFactory.createLineBorder(Color.red);
	Integer i, j;

	public Controlador(Modelo objModelo, Vista objVista)
	{
		for(i=0; i<8; i++) 
		{
			for(j=0; j<8; j++) {
				objVista.casillas[i][j].addActionListener(this);
			}
		}
		objVista.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object fuente = arg0.getSource();
		if (objVista.casillas[0][0].equals(fuente))
		{
			objVista.casillas[0][0].setBorder(bordeRojo);
			System.out.println("Funciona en " + i + " " + j);
		}			
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
