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

import es.studium.Ayuda.Ayuda;
import modelo.ColorPieza;
import modelo.Modelo;
import modelo.Pieza;
import modelo.TipoPieza;
import vista.Vista;

public class Controlador implements WindowListener, ActionListener
{
	Vista objVista = null;
	Modelo objModelo = null;
	Ayuda objAyuda;
	Integer i, j;
	Border bordeRojo = BorderFactory.createLineBorder(Color.red);
	Border bordeVerde = BorderFactory.createLineBorder(Color.green);
	// TO-DO Arreglar, pone el borde en negro
	Border sinBorde = BorderFactory.createLineBorder(null);
	Boolean primerClick = true;
	
	Pieza piezaElegida;
	int posX, posY, k;
	int turno = 1;
	
	public Controlador(Modelo objModelo, Vista objVista)
	{
		this.objVista = objVista;
		this.objModelo = objModelo;

		objVista.getMniPartidaRapida().addActionListener(this);
		objVista.getMniNuevoJugador().addActionListener(this);
		objVista.getMniSalir().addActionListener(this);
		objVista.getMniClasificacionJugador().addActionListener(this);
		//		objVista.getMniPartidas().addActionListener(this);
		objVista.getMniAyuda().addActionListener(this);
		objVista.btnAvanzar.addActionListener(this);
		objVista.btnEmpezar.addActionListener(this);
		objVista.btnCancelar.addActionListener(this);
		objVista.btnCancelar1.addActionListener(this);
		objVista.btnCrearNuevoJugador.addActionListener(this);
		objVista.btnVolverNuevoJugador.addActionListener(this);

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
		//TURNO BLANCAS
		if(turno%2 == 1) {
			for (i = 0; i < 8; i++)
			{
				for (j = 0; j < 8; j++)
				{
					if(objModelo.iconoPieza(objVista.fichaElegida) == "Vacío") {
						if (fuente.equals(objVista.getCasillas()[i][j]))
						{
							Integer x = i;
							Integer y = j;
							for (i = 0; i < 8; i++)
							{
								for (j = 0; j < 8; j++)
								{
									objVista.getCasillas()[i][j].setBorder(sinBorde);

								}
							}
							objVista.getCasillas()[x][y].setBorder(bordeRojo);
							objVista.fichaElegida.setIcon(objVista.getCasillas()[x][y].getIcon());
							objModelo.escribirLog("Pieza seleccionada: " + objModelo.iconoPieza(objVista.getCasillas()[x][y])
							+ " en " + objModelo.numeroLetra(y) + "" + (8 - x));
							if(objModelo.iconoPieza(objVista.getCasillas()[x][y]) == "Caballo") {
								if(objVista.caballoBI.getX() == x && objVista.caballoBI.getY() == y) {
									objModelo.movimientoCaballo(objVista.caballoBI);
									for (k = 0; k < 8; k++)
									{
										if(objModelo.movimientoCaballo(objVista.caballoBI)[k][0] >=0 
												&& objModelo.movimientoCaballo(objVista.caballoBI)[k][0] <= 7
												&& objModelo.movimientoCaballo(objVista.caballoBI)[k][1] >=0
												&& objModelo.movimientoCaballo(objVista.caballoBI)[k][1] <=7) {
											posX = objModelo.movimientoCaballo(objVista.caballoBI)[k][0];
											posY = objModelo.movimientoCaballo(objVista.caballoBI)[k][1];
											objVista.getCasillas()[posX][posY].setBorder(bordeVerde);
											piezaElegida = objVista.caballoBI;
										}

									}

								}
							}
						}
					}
					else {
						if (fuente.equals(objVista.getCasillas()[i][j]))
						{
							Integer x = i;
							Integer y = j;
							if(piezaElegida.tipoPieza == TipoPieza.CABALLO) {
								for (k = 0; k < 8; k++)
								{
									if(objModelo.movimientoCaballo(piezaElegida)[k][0] >=0 
											&& objModelo.movimientoCaballo(piezaElegida)[k][0] <=7
											&& objModelo.movimientoCaballo(piezaElegida)[k][1] >=0
											&& objModelo.movimientoCaballo(piezaElegida)[k][1] <=7) {
										posX = objModelo.movimientoCaballo(piezaElegida)[k][0];
										posY = objModelo.movimientoCaballo(piezaElegida)[k][1];
										if(posX==x && posY == y) {
											if(objModelo.colorPieza(objVista.getCasillas()[x][y]) != ColorPieza.BLANCO){
												objVista.getCasillas()[piezaElegida.getX()][piezaElegida.getY()].setIcon(null);
												objVista.getCasillas()[x][y].setIcon(null);
												objVista.getCasillas()[x][y].setIcon(piezaElegida.getIcono());
												piezaElegida.setX(x);
												piezaElegida.setY(y);
												piezaElegida = null;
												objVista.fichaElegida.setIcon(null);
												//Las 2 siguientes lineas marcan el siguiente turno
												turno++;
												objVista.lblNorte.setText("Juega " + objVista.choJugador2.getSelectedItem().split("-")[1] + " con negras");
											}
											else {
												objVista.fichaElegida.setIcon(null);
											}
										}
										else {
											objVista.fichaElegida.setIcon(null);
										}
										for (i = 0; i < 8; i++)
										{
											for (j = 0; j < 8; j++)
											{
												objVista.getCasillas()[i][j].setBorder(sinBorde);

											}
										}
									}
									
								}
							}
							

							objModelo.escribirLog("Pieza seleccionada: " + objModelo.iconoPieza(objVista.getCasillas()[x][y])
							+ " en " + objModelo.numeroLetra(y) + "" + (8 - x));
							if(objModelo.iconoPieza(objVista.getCasillas()[x][y]) == "Caballo") {
								if(objVista.caballoBI.getX() == x && objVista.caballoBI.getY() == y) {
									int k;
									objModelo.movimientoCaballo(objVista.caballoBI);
									for (k = 0; k < 8; k++)
									{
										if(objModelo.movimientoCaballo(objVista.caballoBI)[k][0] >=0 
												&& objModelo.movimientoCaballo(objVista.caballoBI)[k][0] <= 7
												&& objModelo.movimientoCaballo(objVista.caballoBI)[k][1] >=0
												&& objModelo.movimientoCaballo(objVista.caballoBI)[k][1] <=7) {
											int posX = objModelo.movimientoCaballo(objVista.caballoBI)[k][0];
											int posY = objModelo.movimientoCaballo(objVista.caballoBI)[k][1];
											objVista.getCasillas()[posX][posY].setBorder(bordeVerde);
										}

									}

								}
							}
						}
					}

				}
			}
		}
		//TURNO NEGRAS
		else if(turno%2==0) {
			for (i = 0; i < 8; i++)
			{
				for (j = 0; j < 8; j++)
				{
					if(objModelo.iconoPieza(objVista.fichaElegida) == "Vacío") {
						if (fuente.equals(objVista.getCasillas()[i][j]))
						{
							Integer x = i;
							Integer y = j;
							for (i = 0; i < 8; i++)
							{
								for (j = 0; j < 8; j++)
								{
									objVista.getCasillas()[i][j].setBorder(sinBorde);

								}
							}
							objVista.getCasillas()[x][y].setBorder(bordeRojo);
							objVista.fichaElegida.setIcon(objVista.getCasillas()[x][y].getIcon());
							objModelo.escribirLog("Pieza seleccionada: " + objModelo.iconoPieza(objVista.getCasillas()[x][y])
							+ " en " + objModelo.numeroLetra(y) + "" + (8 - x));
							if(objModelo.iconoPieza(objVista.getCasillas()[x][y]) == "Caballo") {
								if(objVista.caballoNI.getX() == x && objVista.caballoNI.getY() == y) {
									objModelo.movimientoCaballo(objVista.caballoNI);
									for (k = 0; k < 8; k++)
									{
										if(objModelo.movimientoCaballo(objVista.caballoNI)[k][0] >=0 
												&& objModelo.movimientoCaballo(objVista.caballoNI)[k][0] <= 7
												&& objModelo.movimientoCaballo(objVista.caballoNI)[k][1] >=0
												&& objModelo.movimientoCaballo(objVista.caballoNI)[k][1] <=7) {
											posX = objModelo.movimientoCaballo(objVista.caballoNI)[k][0];
											posY = objModelo.movimientoCaballo(objVista.caballoNI)[k][1];
											objVista.getCasillas()[posX][posY].setBorder(bordeVerde);
											piezaElegida = objVista.caballoNI;
										}

									}

								}
							}
						}
					}
					else {
						if (fuente.equals(objVista.getCasillas()[i][j]))
						{
							Integer x = i;
							Integer y = j;
							if(piezaElegida.tipoPieza == TipoPieza.CABALLO) {
								for (k = 0; k < 8; k++)
								{
									if(objModelo.movimientoCaballo(piezaElegida)[k][0] >=0 
											&& objModelo.movimientoCaballo(piezaElegida)[k][0] <=7
											&& objModelo.movimientoCaballo(piezaElegida)[k][1] >=0
											&& objModelo.movimientoCaballo(piezaElegida)[k][1] <=7) {
										posX = objModelo.movimientoCaballo(piezaElegida)[k][0];
										posY = objModelo.movimientoCaballo(piezaElegida)[k][1];
										if(posX==x && posY == y) {
											if(objModelo.colorPieza(objVista.getCasillas()[x][y]) != ColorPieza.NEGRO){
												objVista.getCasillas()[piezaElegida.getX()][piezaElegida.getY()].setIcon(null);
												objVista.getCasillas()[x][y].setIcon(piezaElegida.getIcono());
												piezaElegida.setX(x);
												piezaElegida.setY(y);
												piezaElegida = null;
												objVista.fichaElegida.setIcon(null);
												//Las 2 siguientes lineas marcan el siguiente turno
												turno++;
												objVista.lblNorte.setText("Juega " + objVista.choJugador1.getSelectedItem().split("-")[1] + " con negras");
											}
											else {
												objVista.fichaElegida.setIcon(null);
											}
										}
										else {
											objVista.fichaElegida.setIcon(null);
										}
										for (i = 0; i < 8; i++)
										{
											for (j = 0; j < 8; j++)
											{
												objVista.getCasillas()[i][j].setBorder(sinBorde);

											}
										}
									}
									
								}
							}
							objModelo.escribirLog("Pieza seleccionada: " + objModelo.iconoPieza(objVista.getCasillas()[x][y])
							+ " en " + objModelo.numeroLetra(y) + "" + (8 - x));
							if(objModelo.iconoPieza(objVista.getCasillas()[x][y]) == "Caballo") {
								if(objVista.caballoNI.getX() == x && objVista.caballoNI.getY() == y) {
									int k;
									objModelo.movimientoCaballo(objVista.caballoNI);
									for (k = 0; k < 8; k++)
									{
										if(objModelo.movimientoCaballo(objVista.caballoNI)[k][0] >=0 
												&& objModelo.movimientoCaballo(objVista.caballoNI)[k][0] <= 7
												&& objModelo.movimientoCaballo(objVista.caballoNI)[k][1] >=0
												&& objModelo.movimientoCaballo(objVista.caballoNI)[k][1] <=7) {
											int posX = objModelo.movimientoCaballo(objVista.caballoNI)[k][0];
											int posY = objModelo.movimientoCaballo(objVista.caballoNI)[k][1];
											objVista.getCasillas()[posX][posY].setBorder(bordeVerde);
										}

									}

								}
							}
						}
					}

				}
			}
		}
		
		// TODO Si pulsas en "Iniciar partida"
		// TODO Si pulsas en "Ranking de partidas"
		// TODO Ocultar todos los frames salvo el pulsado

		if (fuente.equals(objVista.getMniPartidaRapida()))
		{
			objVista.choJugador1.removeAll();
			objVista.choJugador1.add("Seleccionar uno...");
			objModelo.consultaJugador1(objVista.choJugador1);
			objVista.frmElegirJugador1.setVisible(true);
			objVista.frmElegirJugador2.setVisible(false);
			objVista.frmTablero.setVisible(false);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(false);
			objModelo.escribirLog("Abriendo nueva partida");
			System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][Abriendo nueva partida]");
		} else if (fuente.equals(objVista.btnAvanzar))
		{
			objVista.choJugador2.removeAll();
			objVista.choJugador2.add("Seleccionar otro...");
			objModelo.consultaJugador2(objVista.choJugador2, objVista.choJugador1.getSelectedItem().split("-")[0]);
			objVista.frmElegirJugador1.setVisible(false);
			objVista.frmElegirJugador2.setVisible(true);
			objVista.frmTablero.setVisible(false);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(false);
			objModelo.escribirLog("Elegido jugador blancas: " + objVista.choJugador1.getSelectedItem().split("-")[1]);
			System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][Elegido jugador blancas: "
					+ objVista.choJugador1.getSelectedItem().split("-")[1] + "]");
		} else if (fuente.equals(objVista.getMniNuevoJugador()))
		{
			// objVista.setVisible(false);
			objVista.frmElegirJugador1.setVisible(false);
			objVista.frmElegirJugador2.setVisible(false);
			objVista.frmNuevoJugador.setVisible(true);
			objVista.frmTablero.setVisible(false);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(false);
			objModelo.escribirLog("Abriendo creación de usuario");
			System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][Abriendo creación de usuario]");
		} else if (fuente.equals(objVista.btnEmpezar))
		{
			turno = 1;
			objVista.frmElegirJugador1.setVisible(false);
			objVista.frmElegirJugador2.setVisible(false);
			// label en tablero vacio --> meterle los jugadores
			objVista.frmTablero.setVisible(true);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(false);
			objModelo.escribirLog("Elegido jugador negras: " + objVista.choJugador2.getSelectedItem().split("-")[1]);
			System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][Elegido jugador negras: "
					+ objVista.choJugador2.getSelectedItem().split("-")[1] + "]");
			objVista.lblNorte.setText("Juega " + objVista.choJugador1.getSelectedItem().split("-")[1] + " con blancas");
		} else if (fuente.equals(objVista.btnCancelar))
		{
			objVista.frmElegirJugador1.setVisible(false);
			objVista.frmElegirJugador2.setVisible(false);
			objVista.frmTablero.setVisible(false);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(false);
			objModelo.escribirLog("Cancelando partida");
			System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][Cancelando partida]");
		} else if (fuente.equals(objVista.btnCancelar1))
		{
			objVista.frmElegirJugador1.setVisible(false);
			objVista.frmElegirJugador2.setVisible(false);
			objVista.frmTablero.setVisible(false);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(false);
			objModelo.escribirLog("Cancelando partida");
			System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][Cancelando partida]");
		} else if (fuente.equals(objVista.btnCrearNuevoJugador))
		{

			objVista.frmElegirJugador2.setVisible(false);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(false);
			objModelo.crearJugador(objVista.txtNombreNuevoJugador);
			objModelo.escribirLog("Nuevo jugador creado");
			System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][Nuevo jugador creado]");
		} else if (fuente.equals(objVista.btnVolverNuevoJugador))
		{

			objVista.frmElegirJugador1.setVisible(false);
			objVista.frmElegirJugador2.setVisible(false);
			objVista.frmNuevoJugador.setVisible(false);
			objVista.frmTablero.setVisible(false);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(false);
			objVista.choJugador1.removeAll();
			objVista.choJugador1.add("Seleccionar uno...");
			objModelo.consultaJugador1(objVista.choJugador1);
			objVista.frmElegirJugador1.setVisible(true);
			objModelo.escribirLog("Creación de nueva partida");
			System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][Creación de nueva partida]");

		} else if (fuente.equals(objVista.getMniAyuda()))
		{

			objVista.frmElegirJugador1.setVisible(false);
			objVista.frmElegirJugador2.setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(false);
			objModelo.escribirLog("Solicitando ayuda");
			System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][Solicitando ayuda]");
			new Ayuda();
		} else if (fuente.equals(objVista.btnVolver))
		{
			objVista.frmElegirJugador1.setVisible(false);
			objVista.frmElegirJugador2.setVisible(false);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(false);
			objVista.getTxtAreaConsultaJugadores().setText("");
			objModelo.consultaJugadoresRanking(objVista.getTxtAreaConsultaJugadores());
			objModelo.escribirLog("Saliendo de creación de usuarios");
			System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][Saliendo de creación de usuarios]");
		} else if (fuente.equals(objVista.getMniClasificacionJugador()))
		{
			objVista.frmElegirJugador1.setVisible(false);
			objVista.frmElegirJugador2.setVisible(false);
			objVista.getFrmAyuda().setVisible(false);
			objVista.getFrmClasificacionJugador().setVisible(true);
			objVista.getTxtAreaConsultaJugadores().setText("");
			objModelo.consultaJugadoresRanking(objVista.getTxtAreaConsultaJugadores());
			objModelo.escribirLog("Visualizando clasificación de jugadores");
			System.out.println(
					"[" + LocalDate.now() + "][" + LocalTime.now() + "][Visualizando clasificación de jugadores]");
		} else if (fuente.equals(objVista.getMniSalir()))
		{
			System.exit(0);
			objModelo.escribirLog("Cierre del programa");
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
