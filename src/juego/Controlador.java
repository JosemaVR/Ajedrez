package juego;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class Controlador implements WindowListener, ActionListener
{
	Vista objVista = null;
	Modelo objModelo = null;
	Integer i, j;
	Border bordeRojo = BorderFactory.createLineBorder(Color.red);
	// TO-DO Arreglar, pone el borde en negro
	Border sinBorde = BorderFactory.createLineBorder(null);

	public Controlador(Modelo objModelo, Vista objVista)
	{
		this.objVista = objVista;
		this.objModelo = objModelo;

		for (i = 0; i < 8; i++)
		{
			for (j = 0; j < 8; j++)
			{
				objVista.casillas[i][j].addActionListener(this);
			}
		}
		objVista.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object fuente = e.getSource();

		for (i = 0; i < 8; i++)
		{
			for (j = 0; j < 8; j++)
			{
				if (fuente.equals(objVista.casillas[i][j]))
				{
					String[] text = ((JButton) fuente).getText().split(", ");
					for (i = 0; i < 8; i++)
					{
						for (j = 0; j < 8; j++)
						{
							objVista.casillas[i][j].setBorder(sinBorde);
						}
					}
					objVista.casillas[Integer.parseInt(text[0])][Integer.parseInt(text[1])].setBorder(bordeRojo);
					
					if (objModelo.tablero[i][j] != null) {
						
					}
				}
			}
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
		System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][Cierre del programa]");
		System.exit(0);
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
