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

import modelo.Alfil;
import modelo.Caballo;
import modelo.ColorPieza;
import modelo.Peon;
import modelo.Reina;
import modelo.Rey;
import modelo.Torre;

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
	JMenu mnClasificacion = new JMenu("Clasificaci�n");
	JMenu mnAyuda = new JMenu("Ayuda");

	private JMenuItem mniPartidaRapida = new JMenuItem("Partida R�pida");
	private JMenuItem mniNuevoJugador = new JMenuItem("Nuevo Jugador");
	private JMenuItem mniSalir = new JMenuItem("Salir");
	private JMenuItem mniClasificacionJugador = new JMenuItem("Jugador");
	//private JMenuItem mniPartidas = new JMenuItem("Partidas");
	private JMenuItem mniAyuda = new JMenuItem("Ayuda");

	// Etiquetas Men� Principal

	JLabel lblNombreJ1 = new JLabel("Jugador Blancas");
	JLabel lblNombreJ2 = new JLabel("Jugador Negras");
	JLabel lblTipoPartida = new JLabel("Tipo de Partida");
	JLabel lblSeleccionColor = new JLabel("Seleccionar color");
	JLabel lblLimiTiempo = new JLabel("L�mite de tiempo");
	JLabel lblNombre = new JLabel("Nombre");
	JLabel lblNuevoJugador = new JLabel("Nombre nuevo jugador");
	

	JPanel pnlNuevaPartida1 = new JPanel();
	JPanel pnlNuevaPartida2 = new JPanel();
	JPanel pnlNuevaPartida3 = new JPanel();
	JPanel pnlNuevaPartida4 = new JPanel();
	JPanel pnlNuevaPartida5 = new JPanel();
	JPanel pnlNuevaPartida6 = new JPanel();

	// Botones Men� Principal

	public JButton btnLanzar = new JButton("Lanzar Moneda");
	public JButton btnEmpezar = new JButton("Empezar");
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnAvanzar = new JButton("Avanzar");
	public JButton btnCancelar1 = new JButton("Cancelar");
	public JButton btnMostrar = new JButton("Mostrar");
	public JButton btnVolver = new JButton("Volver");
	public JButton btnCrearNuevoJugador = new JButton("Crear");
	public JButton btnVolverNuevoJugador = new JButton("Crear partida");
	// TextFields Men� Principal
	JTextField txtNombre = new JTextField("",10);
	JTextField txtNombreJ1 = new JTextField("",10);
	JTextField txtNombreJ2 = new JTextField("",10);
	JTextField txtTipoPartida = new JTextField("",10);
	JTextField txtSeleccionColor = new JTextField("",10);
	public JTextField txtNombreNuevoJugador = new JTextField("",10);
	// CheckBox Men� Principal
	boolean selected = false;

	JCheckBox chkMejorTres = new JCheckBox("�Al mejor de tres?", selected);
	JCheckBox chkUnoVsUno = new JCheckBox("Jug. vs Jug.", selected);
	JCheckBox  chkUnoVsIa = new JCheckBox(" Jug. vs I.A.", selected);

	// Choices de selecci�n de jugadores
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

	// L�mites
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

	public Vista()
	{
		//Men� principal
		setTitle("Men� Principal");
		setJMenuBar(barraMenu);

		mnJugar.add(getMniPartidaRapida());
		mnJugar.add(getMniNuevoJugador());
		mnJugar.addSeparator();
		mnJugar.add(getMniSalir());

		mnClasificacion.add(getMniClasificacionJugador());
	//	mnClasificacion.add(getMniPartidas());
		mnAyuda.add(getMniAyuda());


		setSize(300, 150);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

		barraMenu.add(mnJugar);
		barraMenu.add(mnClasificacion);	
		barraMenu.add(mnAyuda);

		frmTablero.setTitle("Tablero");
		UIManager.put("Label.font", fuenteEtiquetas);

		Torre torreNI = new Torre(ColorPieza.NEGRO, 0, 0);
		getCasillas()[torreNI.getX()][torreNI.getY()] = new JButton(torreNI.getIcono());

		Caballo caballoNI = new Caballo(ColorPieza.NEGRO, 1, 0);
		getCasillas()[caballoNI.getX()][caballoNI.getY()] = new JButton(caballoNI.getIcono());

		Alfil alfilNI = new Alfil(ColorPieza.NEGRO, 2, 0);
		getCasillas()[alfilNI.getX()][alfilNI.getY()] = new JButton(alfilNI.getIcono());

		Reina reinaN = new Reina(ColorPieza.NEGRO, 3, 0);
		getCasillas()[reinaN.getX()][reinaN.getY()] = new JButton(reinaN.getIcono());

		Rey reyN = new Rey(ColorPieza.NEGRO, 4, 0);
		getCasillas()[reyN.getX()][reyN.getY()] = new JButton(reyN.getIcono());

		Alfil alfilND = new Alfil(ColorPieza.NEGRO, 5, 0);
		getCasillas()[alfilND.getX()][alfilND.getY()] = new JButton(alfilND.getIcono());

		Caballo caballoND = new Caballo(ColorPieza.NEGRO, 6, 0);
		getCasillas()[caballoND.getX()][caballoND.getY()] = new JButton(caballoND.getIcono());

		Torre torreND = new Torre(ColorPieza.NEGRO, 7, 0);
		getCasillas()[torreND.getX()][torreND.getY()] = new JButton(torreND.getIcono());

		Peon peonN1 = new Peon(ColorPieza.NEGRO, 0, 1);
		getCasillas()[peonN1.getX()][peonN1.getY()] = new JButton(peonN1.getIcono());

		Peon peonN2 = new Peon(ColorPieza.NEGRO, 1, 1);
		getCasillas()[peonN2.getX()][peonN2.getY()] = new JButton(peonN2.getIcono());

		Peon peonN3 = new Peon(ColorPieza.NEGRO, 2, 1);
		getCasillas()[peonN3.getX()][peonN3.getY()] = new JButton(peonN3.getIcono());

		Peon peonN4 = new Peon(ColorPieza.NEGRO, 3, 1);
		getCasillas()[peonN4.getX()][peonN4.getY()] = new JButton(peonN4.getIcono());

		Peon peonN5 = new Peon(ColorPieza.NEGRO, 4, 1);
		getCasillas()[peonN5.getX()][peonN5.getY()] = new JButton(peonN5.getIcono());

		Peon peonN6 = new Peon(ColorPieza.NEGRO, 5, 1);
		getCasillas()[peonN6.getX()][peonN6.getY()] = new JButton(peonN6.getIcono());

		Peon peonN7 = new Peon(ColorPieza.NEGRO, 6, 1);
		getCasillas()[peonN7.getX()][peonN7.getY()] = new JButton(peonN7.getIcono());

		Peon peonN8 = new Peon(ColorPieza.NEGRO, 7, 1);
		getCasillas()[peonN8.getX()][peonN8.getY()] = new JButton(peonN8.getIcono());

		Torre torreBI = new Torre(ColorPieza.BLANCO, 0, 7);
		getCasillas()[torreBI.getX()][torreBI.getY()] = new JButton(torreBI.getIcono());

		Caballo caballoBI = new Caballo(ColorPieza.BLANCO, 1, 7);
		getCasillas()[caballoBI.getX()][caballoBI.getY()] = new JButton(caballoBI.getIcono());

		Alfil alfilBI = new Alfil(ColorPieza.BLANCO, 2, 7);
		getCasillas()[alfilBI.getX()][alfilBI.getY()] = new JButton(alfilBI.getIcono());

		Reina reinaB = new Reina(ColorPieza.BLANCO, 3, 7);
		getCasillas()[reinaB.getX()][reinaB.getY()] = new JButton(reinaB.getIcono());

		Rey reyB = new Rey(ColorPieza.BLANCO, 4, 7);
		getCasillas()[reyB.getX()][reyB.getY()] = new JButton(reyB.getIcono());

		Alfil alfilBD = new Alfil(ColorPieza.BLANCO, 5, 7);
		getCasillas()[alfilBD.getX()][alfilBD.getY()] = new JButton(alfilBD.getIcono());

		Caballo caballoBD = new Caballo(ColorPieza.BLANCO, 6, 7);
		getCasillas()[caballoBD.getX()][caballoBD.getY()] = new JButton(caballoBD.getIcono());

		Torre torreBD = new Torre(ColorPieza.BLANCO, 7, 7);
		getCasillas()[torreBD.getX()][torreBD.getY()] = new JButton(torreBD.getIcono());

		Peon peonB1 = new Peon(ColorPieza.BLANCO, 0, 6);
		getCasillas()[peonB1.getX()][peonB1.getY()] = new JButton(peonB1.getIcono());

		Peon peonB2 = new Peon(ColorPieza.BLANCO, 1, 6);
		getCasillas()[peonB2.getX()][peonB2.getY()] = new JButton(peonB2.getIcono());

		Peon peonB3 = new Peon(ColorPieza.BLANCO, 2, 6);
		getCasillas()[peonB3.getX()][peonB3.getY()] = new JButton(peonB3.getIcono());

		Peon peonB4 = new Peon(ColorPieza.BLANCO, 3, 6);
		getCasillas()[peonB4.getX()][peonB4.getY()] = new JButton(peonB4.getIcono());

		Peon peonB5 = new Peon(ColorPieza.BLANCO, 4, 6);
		getCasillas()[peonB5.getX()][peonB5.getY()] = new JButton(peonB5.getIcono());

		Peon peonB6 = new Peon(ColorPieza.BLANCO, 5, 6);
		getCasillas()[peonB6.getX()][peonB6.getY()] = new JButton(peonB6.getIcono());

		Peon peonB7 = new Peon(ColorPieza.BLANCO, 6, 6);
		getCasillas()[peonB7.getX()][peonB7.getY()] = new JButton(peonB7.getIcono());

		Peon peonB8 = new Peon(ColorPieza.BLANCO, 7, 6);
		getCasillas()[peonB8.getX()][peonB8.getY()] = new JButton(peonB8.getIcono());

		// Crear y a�adir componentes del tablero
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
					// En un futuro a�adir cambios aqui segun la pieza seleccionada o algo as�
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

		getFrmClasificacionJugador().setTitle("Clasificaci�n de jugadores");
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