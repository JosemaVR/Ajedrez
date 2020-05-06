package juego;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class Controlador implements WindowListener, ActionListener
{
	Vista objVista = null;
	Modelo objModelo = null;
	Integer i, j;
	Border bordeRojo = BorderFactory.createLineBorder(Color.red);

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
	public void actionPerformed(ActionEvent e) {
		Object fuente = e.getSource();
		if (e.getSource() instanceof JButton) {
			String text = ((JButton) e.getSource()).getText();
			for(i=0; i<8; i++) 
			{
				for(j=0; j<8; j++) {
					if ((i + ", " + j).equals(text))
					{
						System.out.println("Funciona en " + i + " " + j);
					}     			
				}
			}
		}

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
