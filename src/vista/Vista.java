package vista;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

import modelo.ColorPieza;
import modelo.Pieza;
import modelo.TipoPieza;

public class Vista extends JFrame 
{
	private static final long serialVersionUID = 1L;

	JFrame frmInicio = new JFrame();
	JFrame frmMenuPartida = new JFrame();
	
	public JFrame frmElegirJugador1 = new JFrame();
	public JFrame frmElegirJugador2 = new JFrame();
	public JFrame frmNuevoJugador = new JFrame();
	public JFrame frmAyuda = new JFrame();
	public JFrame frmClasificacionJugador = new JFrame();
	public JFrame frmTablero = new JFrame();

	JDialog dlgNuevaPartida = new JDialog(frmInicio, "Crear Partida");
	JDialog dlgNuevoJugador = new JDialog(frmInicio, "Crear Jugador");
	JMenuBar barraMenu = new JMenuBar();
	JMenu mnJugar = new JMenu("Jugar");
	JMenu mnClasificacion = new JMenu("Clasificación");
	JMenu mnAyuda = new JMenu("Ayuda");

	private JMenuItem mniPartidaRapida = new JMenuItem("Partida Rápida");
	private JMenuItem mniNuevoJugador = new JMenuItem("Nuevo Jugador");
	private JMenuItem mniSalir = new JMenuItem("Salir");
	private JMenuItem mniClasificacionJugador = new JMenuItem("Jugador");
	//private JMenuItem mniPartidas = new JMenuItem("Partidas");
	private JMenuItem mniAyuda = new JMenuItem("Ayuda");

	// Etiquetas Menú Principal

	JLabel lblNombreJ1 = new JLabel("Jugador Blancas");
	JLabel lblNombreJ2 = new JLabel("Jugador Negras");
	JLabel lblTipoPartida = new JLabel("Tipo de Partida");
	JLabel lblSeleccionColor = new JLabel("Seleccionar color");
	JLabel lblLimiTiempo = new JLabel("Límite de tiempo");
	JLabel lblNombre = new JLabel("Nombre");
	JLabel lblNuevoJugador = new JLabel("Nombre nuevo jugador");
	

	JPanel pnlNuevaPartida1 = new JPanel();
	JPanel pnlNuevaPartida2 = new JPanel();
	JPanel pnlNuevaPartida3 = new JPanel();
	JPanel pnlNuevaPartida4 = new JPanel();
	JPanel pnlNuevaPartida5 = new JPanel();
	JPanel pnlNuevaPartida6 = new JPanel();

	// Botones Menú Principal

	public JButton btnLanzar = new JButton("Lanzar Moneda");
	public JButton btnEmpezar = new JButton("Empezar");
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnAvanzar = new JButton("Avanzar");
	public JButton btnCancelar1 = new JButton("Cancelar");
	public JButton btnMostrar = new JButton("Mostrar");
	public JButton btnVolver = new JButton("Volver");
	public JButton btnCrearNuevoJugador = new JButton("Crear");
	public JButton btnVolverNuevoJugador = new JButton("Crear partida");
	// TextFields Menú Principal
	JTextField txtNombre = new JTextField("",10);
	JTextField txtNombreJ1 = new JTextField("",10);
	JTextField txtNombreJ2 = new JTextField("",10);
	JTextField txtTipoPartida = new JTextField("",10);
	JTextField txtSeleccionColor = new JTextField("",10);
	public JTextField txtNombreNuevoJugador = new JTextField("",10);
	// CheckBox Menú Principal
	boolean selected = false;

	JCheckBox chkMejorTres = new JCheckBox("¿Al mejor de tres?", selected);
	JCheckBox chkUnoVsUno = new JCheckBox("Jug. vs Jug.", selected);
	JCheckBox  chkUnoVsIa = new JCheckBox(" Jug. vs I.A.", selected);

	// Choices de selección de jugadores
	public Choice choJugador1 = new Choice();
	public Choice choJugador2 = new Choice();
	Choice choTiempo = new Choice();
	// Panel contenedor
	JPanel pantalla = new JPanel();
	JPanel panelCentral = new JPanel();
	JPanel panelNorte = new JPanel();
	JPanel panelSur = new JPanel();
	JPanel panelOeste = new JPanel();
	JPanel panelEste = new JPanel();

	// Límites
	Border borderContents = BorderFactory.createEmptyBorder(10, 10, 10, 10);
	// private Border borderRegion = BorderFactory.createLineBorder(Color.RED, 1);

	// Colores
	Color colorContenedores = Color.WHITE; // Panel contenedor

	// Fuentes:
	Font fuenteEtiquetas = new Font(Font.DIALOG, Font.BOLD, 16);

	// Labels
	JLabel lblEste = new JLabel();
	JLabel lblOeste = new JLabel();
	public JLabel lblNorte = new JLabel();
	public JLabel lblSur = new JLabel();

	// Componentes del tablero
	public JButton[][] casillas = new JButton[8][8];
	public JButton fichaElegida = new JButton();
	JLabel[] letTablero = new JLabel[9];
	JLabel[] numTablero = new JLabel[9];
	public JPanel tablero = new JPanel(new GridLayout(9, 9));
	public JPanel tableroCompleto = new JPanel();

	// Colores
	public Color colorNegro = new Color(173, 113, 0); // Casillas marron oscuro
	public Color colorBlanco = new Color(227, 194, 102);// Casillas amarillo crema

	//TextArea para consulta de jugadores
	public TextArea txtAreaConsultaJugadores = new TextArea(20,40);

	public char letra = 'A';
	JLabel lblLetra;
	JLabel lblNum;
	Integer i, j;
	ImageIcon caballoBa2 = new ImageIcon("./imagenes/sin_fondo/Caballo_blanco.png");
	
	
	public Pieza torreNI = new Pieza();
	public Pieza torreND = new Pieza();
	public Pieza torreBI = new Pieza();
	public Pieza torreBD = new Pieza();
	
	public Pieza alfilNI = new Pieza();
	public Pieza alfilND = new Pieza();
	public Pieza alfilBI = new Pieza();
	public Pieza alfilBD = new Pieza();
	
	public Pieza reinaN = new Pieza();
	public Pieza reinaB = new Pieza();
	
	public Pieza reyN = new Pieza();
	public Pieza reyB = new Pieza();
	
	public Pieza peonN1 = new Pieza();
	public Pieza peonN2 = new Pieza();
	public Pieza peonN3 = new Pieza();
	public Pieza peonN4 = new Pieza();
	public Pieza peonN5 = new Pieza();
	public Pieza peonN6 = new Pieza();
	public Pieza peonN7 = new Pieza();
	public Pieza peonN8 = new Pieza();
	public Pieza peonB1 = new Pieza();
	public Pieza peonB2 = new Pieza();
	public Pieza peonB3 = new Pieza();
	public Pieza peonB4 = new Pieza();
	public Pieza peonB5 = new Pieza();
	public Pieza peonB6 = new Pieza();
	public Pieza peonB7 = new Pieza();
	public Pieza peonB8 = new Pieza();
	
	public Pieza caballoNI = new Pieza();
	public Pieza caballoND = new Pieza();
	public Pieza caballoBD = new Pieza();
	public Pieza caballoBI = new Pieza();
	
	public Vista()
	{
		//Menú principal
		setTitle("Menú Principal");
		setJMenuBar(barraMenu);

		mnJugar.add(getMniPartidaRapida());
		mnJugar.add(getMniNuevoJugador());
		mnJugar.addSeparator();
		mnJugar.add(getMniSalir());

		mnClasificacion.add(getMniClasificacionJugador());
	//	mnClasificacion.add(getMniPartidas());
		mnAyuda.add(getMniAyuda());

		torreNI = new Pieza(ColorPieza.NEGRO, TipoPieza.TORRE, 0, 0);
		torreND = new Pieza(ColorPieza.NEGRO, TipoPieza.TORRE, 7, 0);
		torreBI = new Pieza(ColorPieza.BLANCO, TipoPieza.TORRE, 0, 7);
		torreBD = new Pieza(ColorPieza.BLANCO, TipoPieza.TORRE, 7, 7);
		
		alfilNI = new Pieza(ColorPieza.NEGRO, TipoPieza.ALFIL, 2, 0);
		alfilND = new Pieza(ColorPieza.NEGRO, TipoPieza.ALFIL, 5, 0);
		alfilBI = new Pieza(ColorPieza.BLANCO, TipoPieza.ALFIL, 2, 7);
		alfilBD = new Pieza(ColorPieza.BLANCO, TipoPieza.ALFIL, 5, 7);
		
		reinaN = new Pieza(ColorPieza.NEGRO, TipoPieza.REINA, 3, 0);
		reinaB = new Pieza(ColorPieza.BLANCO, TipoPieza.REINA, 3, 7);
		
		reyN = new Pieza(ColorPieza.NEGRO, TipoPieza.REY, 4, 0);
		reyB = new Pieza(ColorPieza.BLANCO, TipoPieza.REY, 4, 7);
		
		peonN1 = new Pieza(ColorPieza.NEGRO, TipoPieza.PEON, 0, 1);
		peonN2 = new Pieza(ColorPieza.NEGRO, TipoPieza.PEON, 1, 1);
		peonN3 = new Pieza(ColorPieza.NEGRO, TipoPieza.PEON, 2, 1);
		peonN4 = new Pieza(ColorPieza.NEGRO, TipoPieza.PEON, 3, 1);
		peonN5 = new Pieza(ColorPieza.NEGRO, TipoPieza.PEON, 4, 1);
		peonN6 = new Pieza(ColorPieza.NEGRO, TipoPieza.PEON, 5, 1);
		peonN7 = new Pieza(ColorPieza.NEGRO, TipoPieza.PEON, 6, 1);
		peonN8 = new Pieza(ColorPieza.NEGRO, TipoPieza.PEON, 7, 1);
		peonB1 = new Pieza(ColorPieza.BLANCO, TipoPieza.PEON, 0, 6);
		peonB2 = new Pieza(ColorPieza.BLANCO, TipoPieza.PEON, 1, 6);
		peonB3 = new Pieza(ColorPieza.BLANCO, TipoPieza.PEON, 2, 6);
		peonB4 = new Pieza(ColorPieza.BLANCO, TipoPieza.PEON, 3, 6);
		peonB5 = new Pieza(ColorPieza.BLANCO, TipoPieza.PEON, 4, 6);
		peonB6 = new Pieza(ColorPieza.BLANCO, TipoPieza.PEON, 5, 6);
		peonB7 = new Pieza(ColorPieza.BLANCO, TipoPieza.PEON, 6, 6);
		peonB8 = new Pieza(ColorPieza.BLANCO, TipoPieza.PEON, 7, 6);
		
		caballoNI = new Pieza(ColorPieza.NEGRO, TipoPieza.CABALLO, 1, 0);
		caballoND = new Pieza(ColorPieza.NEGRO, TipoPieza.CABALLO, 6, 0);
		caballoBD = new Pieza(ColorPieza.BLANCO, TipoPieza.CABALLO, 6, 7);
		caballoBI = new Pieza(ColorPieza.BLANCO, TipoPieza.CABALLO, 1, 7);
		
		setSize(300, 150);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

		barraMenu.add(mnJugar);
		barraMenu.add(mnClasificacion);	
		barraMenu.add(mnAyuda);

		frmTablero.setTitle("Tablero");
		UIManager.put("Label.font", fuenteEtiquetas);

		getCasillas()[torreNI.getX()][torreNI.getY()] = new JButton(torreNI.getIcono());

		getCasillas()[caballoNI.getX()][caballoNI.getY()] = new JButton(caballoNI.getIcono());

		getCasillas()[alfilNI.getX()][alfilNI.getY()] = new JButton(alfilNI.getIcono());

		getCasillas()[reinaN.getX()][reinaN.getY()] = new JButton(reinaN.getIcono());

		getCasillas()[reyN.getX()][reyN.getY()] = new JButton(reyN.getIcono());

		getCasillas()[alfilND.getX()][alfilND.getY()] = new JButton(alfilND.getIcono());

		getCasillas()[caballoND.getX()][caballoND.getY()] = new JButton(caballoND.getIcono());

		getCasillas()[torreND.getX()][torreND.getY()] = new JButton(torreND.getIcono());

		getCasillas()[peonN1.getX()][peonN1.getY()] = new JButton(peonN1.getIcono());

		getCasillas()[peonN2.getX()][peonN2.getY()] = new JButton(peonN2.getIcono());

		getCasillas()[peonN3.getX()][peonN3.getY()] = new JButton(peonN3.getIcono());

		getCasillas()[peonN4.getX()][peonN4.getY()] = new JButton(peonN4.getIcono());

		getCasillas()[peonN5.getX()][peonN5.getY()] = new JButton(peonN5.getIcono());

		getCasillas()[peonN6.getX()][peonN6.getY()] = new JButton(peonN6.getIcono());

		getCasillas()[peonN7.getX()][peonN7.getY()] = new JButton(peonN7.getIcono());

		getCasillas()[peonN8.getX()][peonN8.getY()] = new JButton(peonN8.getIcono());

		
		getCasillas()[torreBI.getX()][torreBI.getY()] = new JButton(torreBI.getIcono());

		getCasillas()[caballoBI.getX()][caballoBI.getY()] = new JButton(caballoBI.getIcono());

		getCasillas()[alfilBI.getX()][alfilBI.getY()] = new JButton(alfilBI.getIcono());

		getCasillas()[reinaB.getX()][reinaB.getY()] = new JButton(reinaB.getIcono());

		getCasillas()[reyB.getX()][reyB.getY()] = new JButton(reyB.getIcono());

		getCasillas()[alfilBD.getX()][alfilBD.getY()] = new JButton(alfilBD.getIcono());

		getCasillas()[caballoBD.getX()][caballoBD.getY()] = new JButton(caballoBD.getIcono());

		getCasillas()[torreBD.getX()][torreBD.getY()] = new JButton(torreBD.getIcono());
		
		getCasillas()[peonB1.getX()][peonB1.getY()] = new JButton(peonB1.getIcono());
		
		getCasillas()[peonB2.getX()][peonB2.getY()] = new JButton(peonB2.getIcono());
		
		getCasillas()[peonB3.getX()][peonB3.getY()] = new JButton(peonB3.getIcono());
		
		getCasillas()[peonB4.getX()][peonB4.getY()] = new JButton(peonB4.getIcono());
		
		getCasillas()[peonB5.getX()][peonB5.getY()] = new JButton(peonB5.getIcono());
		
		getCasillas()[peonB6.getX()][peonB6.getY()] = new JButton(peonB6.getIcono());
		
		getCasillas()[peonB7.getX()][peonB7.getY()] = new JButton(peonB7.getIcono());
		
		getCasillas()[peonB8.getX()][peonB8.getY()] = new JButton(peonB8.getIcono());

		// Crear y añadir componentes del tablero
		for (i = 0; i < 9; i++)
		{
			for (j = 0; j < 9; j++, letra++)
			{
				if (i == 0 && j == 0)
				{
					fichaElegida.setEnabled(false);
					fichaElegida.setIcon(caballoBa2);
					fichaElegida.setPreferredSize(new Dimension(70, 70));
					tablero.add(fichaElegida);
					// En un futuro añadir cambios aqui segun la pieza seleccionada o algo así
				} else if (i == 0 || i == 9)
				{
					letTablero[j] = new JLabel(Character.toString((char) (letra - 1)));
					letTablero[j].setHorizontalAlignment(JLabel.CENTER);
					letTablero[j].setVerticalAlignment(JLabel.CENTER);
					tablero.add(letTablero[j]);
				} else
				{
					if ((j == 0 && (i != 0 || i != 9)))
					{
						numTablero[i] = new JLabel(Integer.toString(9-i));
						numTablero[i].setHorizontalAlignment(JLabel.CENTER);
						numTablero[i].setVerticalAlignment(JLabel.CENTER);
						tablero.add(numTablero[i]);
					} else
					{
						if(getCasillas()[i - 1][j - 1] == null) {
							getCasillas()[i - 1][j - 1] = new JButton("");
							getCasillas()[i - 1][j - 1].setPreferredSize(new Dimension(70, 70));
							if ((i + j) % 2 != 0)
							{
								getCasillas()[i - 1][j - 1].setBackground(colorNegro);
							}
							if ((i + j) % 2 == 0)
							{
								getCasillas()[i - 1][j - 1].setBackground(colorBlanco);
							}
						} else {
							getCasillas()[i - 1][j - 1].setPreferredSize(new Dimension(70, 70));
							if ((i + j) % 2 != 0)
							{
								getCasillas()[i - 1][j - 1].setBackground(colorNegro);
							}
							if ((i + j) % 2 == 0)
							{
								getCasillas()[i - 1][j - 1].setBackground(colorBlanco);
							}
						}
						tablero.add(getCasillas()[i - 1][j - 1]);
					}
				}
			}
		}

		tableroCompleto.add(tablero);
		frmTablero.add(tableroCompleto);

		panelEste.add(lblEste);
		frmTablero.add(panelEste, BorderLayout.EAST);

		panelOeste.setPreferredSize(new Dimension(25, 25));
		panelOeste.add(lblOeste);
		frmTablero.add(panelOeste, BorderLayout.WEST);

		panelNorte.add(lblNorte);
		frmTablero.add(panelNorte, BorderLayout.NORTH);

		panelSur.add(lblSur);
		frmTablero.add(panelSur, BorderLayout.SOUTH);
		
		//Layout Tablero de juego
		frmTablero.setSize(1100, 800);
		frmTablero.setResizable(false);
		frmTablero.setLocationRelativeTo(null);
		frmTablero.setVisible(false);

		//Layout Crear Partida
		//TODO Completar frame para "Crear partida"
//		dlgNuevaPartida.setLayout(new GridLayout(2,2));
//		dlgNuevaPartida.setTitle("Crear Partida");

		choJugador1.add("Seleccionar uno...");
		choJugador2.add("Seleccionar otro...");
		
		frmElegirJugador1.setLayout(new FlowLayout());
		frmElegirJugador1.setTitle("Crear Partida");
		frmElegirJugador1.add(lblNombreJ1);
		frmElegirJugador1.add(choJugador1);		
		frmElegirJugador1.add(btnAvanzar);
		frmElegirJugador1.add(btnCancelar1);
		frmElegirJugador1.setSize(300, 150);
		frmElegirJugador1.setVisible(false);
		frmElegirJugador1.setLocationRelativeTo(null);
		frmElegirJugador1.setResizable(true);
		
		frmElegirJugador2.setLayout(new FlowLayout());
		frmElegirJugador2.setTitle("Crear Partida");
		frmElegirJugador2.add(lblNombreJ2);
		frmElegirJugador2.add(choJugador2);
		frmElegirJugador2.add(btnEmpezar);
		frmElegirJugador2.add(btnCancelar);
		frmElegirJugador2.setSize(300, 150);
		frmElegirJugador2.setVisible(false);
		frmElegirJugador2.setLocationRelativeTo(null);
		frmElegirJugador2.setResizable(true);

		getFrmClasificacionJugador().setTitle("Clasificación de jugadores");
		getFrmClasificacionJugador().setSize(600, 600);
		getFrmClasificacionJugador().setResizable(false);
		getFrmClasificacionJugador().setLocationRelativeTo(null);
		getFrmClasificacionJugador().setVisible(false);
		getFrmClasificacionJugador().add(getTxtAreaConsultaJugadores());

		//Layout Crear nuevo jugador
		
//		dlgNuevoJugador.setLayout(new GridLayout(2,2));
//		dlgNuevoJugador.setTitle("Crear nuevo Jugador");
		frmNuevoJugador.setLayout(new FlowLayout());
		frmNuevoJugador.setTitle("Crear nuevo Jugador");
		frmNuevoJugador.add(lblNuevoJugador);
		frmNuevoJugador.add(txtNombreNuevoJugador);
		frmNuevoJugador.add(btnCrearNuevoJugador);
		frmNuevoJugador.add(btnVolverNuevoJugador);
		frmNuevoJugador.setSize(300, 150);
		frmNuevoJugador.setVisible(false);
		frmNuevoJugador.setResizable(false);
		frmNuevoJugador.setLocationRelativeTo(null);
		
		
		
		//TODO Completar frame para "Ranking de partidas"

		//TODO Completar frame para "Ayuda"

		//TODO Completar frame para "Final de la partida"

	}

//	public JDialog getDlgNuevoJugador()
//	{
//		return dlgNuevoJugador;
//	}
//
//	public void setDlgNuevoJugador(JDialog dlgNuevoJugador)
//	{
//		this.dlgNuevoJugador = dlgNuevoJugador;
//	}

	public JMenuItem getMniNuevoJugador()
	{
		return mniNuevoJugador;
	}

	public void setMniNuevoJugador(JMenuItem mniNuevoJugador)
	{
		this.mniNuevoJugador = mniNuevoJugador;
	}

//	public JDialog getDlgNuevaPartida()
//	{
//		return dlgNuevaPartida;
//	}
//
//	public void setDlgNuevaPartida(JDialog dlgNuevaPartida)
//	{
//		this.dlgNuevaPartida = dlgNuevaPartida;
//	}

	public JMenuItem getMniClasificacionJugador() {
		return mniClasificacionJugador;
	}

	public void setMniClasificacionJugador(JMenuItem mniClasificacionJugador) {
		this.mniClasificacionJugador = mniClasificacionJugador;
	}

	public JMenuItem getMniSalir() {
		return mniSalir;
	}

	public void setMniSalir(JMenuItem mniSalir) {
		this.mniSalir = mniSalir;
	}

	public JMenuItem getMniPartidaRapida() {
		return mniPartidaRapida;
	}

	public void setMniPartidaRapida(JMenuItem mniPartidaRapida) {
		this.mniPartidaRapida = mniPartidaRapida;
	}

//	public JMenuItem getMniPartidas() {
//		return mniPartidas;
//	}
//
//	public void setMniPartidas(JMenuItem mniPartidas) {
//		this.mniPartidas = mniPartidas;
//	}

	public JMenuItem getMniAyuda() {
		return mniAyuda;
	}

	public JFrame getFrmNuevoJugador()
	{
		return frmNuevoJugador;
	}

	public void setFrmNuevoJugador(JFrame frmNuevoJugador)
	{
		this.frmNuevoJugador = frmNuevoJugador;
	}

	public void setMniAyuda(JMenuItem mniAyuda) {
		this.mniAyuda = mniAyuda;
	}

	public JButton[][] getCasillas() {
		return casillas;
	}

	public void setCasillas(JButton[][] casillas) {
		this.casillas = casillas;
	}

	public JFrame getFrmAyuda() {
		return frmAyuda;
	}

	public void setFrmAyuda(JFrame frmAyuda) {
		this.frmAyuda = frmAyuda;
	}

	public JFrame getFrmClasificacionJugador() {
		return frmClasificacionJugador;
	}

	public void setFrmClasificacionJugador(JFrame frmClasificacionJugador) {
		this.frmClasificacionJugador = frmClasificacionJugador;
	}

	public TextArea getTxtAreaConsultaJugadores() {
		return txtAreaConsultaJugadores;
	}

	public void setTxtAreaConsultaJugadores(TextArea txtAreaConsultaJugadores) {
		this.txtAreaConsultaJugadores = txtAreaConsultaJugadores;
	}
}