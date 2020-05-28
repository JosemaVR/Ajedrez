package controlador;

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

import modelo.Modelo;
import vista.Vista;

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

		objVista.getMniPartidaRapida().addActionListener(this);
		objVista.getMniSalir().addActionListener(this);
		objVista.getMniClasificacionJugador().addActionListener(this);
		objVista.getMniPartidas().addActionListener(this);
		objVista.getMniAyuda().addActionListener(this);
		
		for (i = 0; i < 8; i++)
		{
			for (j = 0; j < 8; j++)
			{
				objVista.getCasillas()[i][j].addActionListener(this);
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
				if (fuente.equals(objVista.getCasillas()[i][j]))
				{
					String[] text = ((JButton) fuente).getText().split(", ");
					for (i = 0; i < 8; i++)
					{
						for (j = 0; j < 8; j++)
						{
							objVista.getCasillas()[i][j].setBorder(sinBorde);
						}
					}
					objVista.getCasillas()[Integer.parseInt(text[0])][Integer.parseInt(text[1])].setBorder(bordeRojo);
					
					if (objModelo.getTablero()[i][j] != null) {
						
					}
				}
			}
		}
		
		//TODO Si pulsas en "Iniciar partida"
		//TODO Si pulsas en "Ranking de partidas"
		//TODO Ocultar todos los frames salvo el pulsado
		
		if (fuente.equals(objVista.getMniPartidaRapida())) {
			//objVista.setVisible(false);
			objVista.getDlgNuevaPartida().setVisible(true);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(false);
		}
		else if (fuente.equals(objVista.getMniAyuda())) {
			objVista.getFrmPartidaRapida().setVisible(false);
			objVista.getFrmAyuda().setVisible(true);
			objVista.getFrmClasificacionJugador().setVisible(false);		
		}
		else if (fuente.equals(objVista.getMniClasificacionJugador())) {
			objVista.getFrmPartidaRapida().setVisible(false);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(true);
			objVista.getTxtAreaConsultaJugadores().setText("");
			objModelo.consultaJugadores(objVista.getTxtAreaConsultaJugadores());
		}
		else if (fuente.equals(objVista.getMniSalir())) {
			System.exit(0);
			System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][[Cierre del programa]]");
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
