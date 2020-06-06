package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.BorderFactory;
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
		objVista.btnAvanzar.addActionListener(this);
		objVista.btnEmpezar.addActionListener(this);
		objVista.btnCancelar.addActionListener(this);
		objVista.btnCancelar1.addActionListener(this);

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
					Integer x = i;
					Integer y = j;
					for (i = 0; i < 8; i++)
					{
						for (j = 0; j < 8; j++)
						{
							objVista.getCasillas()[i][j].setBorder(sinBorde);
							System.out.println(i + " " + j);
						}
					}
					objVista.getCasillas()[x][y].setBorder(bordeRojo);
					objVista.fichaElegida.setIcon(objVista.getCasillas()[x][y].getIcon());
				}
			}
		}
		//TODO Si pulsas en "Iniciar partida"
		//TODO Si pulsas en "Ranking de partidas"
		//TODO Ocultar todos los frames salvo el pulsado
		
		if (fuente.equals(objVista.getMniPartidaRapida())) {
			//objVista.setVisible(false);
			objModelo.consultaJugador1(objVista.choJugador1);
			objVista.frmElegirJugador1.setVisible(true);
			objVista.frmElegirJugador2.setVisible(false);
			objVista.frmTablero.setVisible(false);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(false);
		}
		else if (fuente.equals(objVista.btnAvanzar)){
			objModelo.consultaJugador2(objVista.choJugador2, objVista.choJugador1.getSelectedItem().split("-")[0]);
			objVista.frmElegirJugador1.setVisible(false);
			objVista.frmElegirJugador2.setVisible(true);
			objVista.frmTablero.setVisible(false);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(false);
		}
		else if (fuente.equals(objVista.btnEmpezar)) {
			objVista.frmElegirJugador1.setVisible(false);
			objVista.frmElegirJugador2.setVisible(false);
			//label en tablero vacio --> meterle los jugadores
			objVista.frmTablero.setVisible(true);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(false);
			objVista.lblNorte.setText("Juega " + objVista.choJugador1.getSelectedItem().split("-")[1] + " con blancas");
		}
		else if (fuente.equals(objVista.btnCancelar)) {
			objVista.frmElegirJugador1.setVisible(false);
			objVista.frmElegirJugador2.setVisible(false);
			objVista.frmTablero.setVisible(false);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(false);
		}
		else if (fuente.equals(objVista.btnCancelar1)) {
			objVista.frmElegirJugador1.setVisible(false);
			objVista.frmElegirJugador2.setVisible(false);
			objVista.frmTablero.setVisible(false);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(false);
		}
		else if (fuente.equals(objVista.getMniAyuda())) {
			objVista.frmElegirJugador1.setVisible(false);
			objVista.frmElegirJugador2.setVisible(false);
			objVista.getFrmAyuda().setVisible(true);
			objVista.getFrmClasificacionJugador().setVisible(false);		
		}
		else if (fuente.equals(objVista.getMniClasificacionJugador())) {
			objVista.frmElegirJugador1.setVisible(false);
			objVista.frmElegirJugador2.setVisible(false);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(true);
			objVista.getTxtAreaConsultaJugadores().setText("");
			objModelo.consultaJugadoresRanking(objVista.getTxtAreaConsultaJugadores());
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
