package vista;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class Vista extends JFrame 
{

	private static final long serialVersionUID = 1L;

	JFrame frmInicio = new JFrame();
	JFrame frmMenuPartida = new JFrame();
	private JFrame frmPartidaRapida = new JFrame();
	private JFrame frmAyuda = new JFrame();
	private JFrame frmClasificacionJugador = new JFrame();
	JFrame frmTablero = new JFrame();
	
	
	JDialog dlgNuevaPartida = new JDialog(frmInicio, "Crear Partida");
	
	
	
	JMenuBar barraMenu = new JMenuBar();
	JMenu mnJugar = new JMenu("Jugar");
	JMenu mnClasificacion = new JMenu("Clasificaci�n");
	JMenu mnAyuda = new JMenu("Ayuda");

	private JMenuItem mniPartidaRapida = new JMenuItem("Partida R�pida");
	private JMenuItem mniSalir = new JMenuItem("Salir");
	private JMenuItem mniClasificacionJugador = new JMenuItem("Jugador");
	private JMenuItem mniPartidas = new JMenuItem("Partidas");
	private JMenuItem mniAyuda = new JMenuItem("Ayuda");

	// Etiquetas Men� Principal

	JLabel lblNombreJ1 = new JLabel("Nombre Jugador 1");
	JLabel lblNombreJ2 = new JLabel("Nombre Jugador 2");
	JLabel lblTipoPartida = new JLabel("Tipo de Partida");
	JLabel lblSeleccionColor = new JLabel("Seleccionar color");
	JLabel lblLimiTiempo = new JLabel("L�mite de tiempo");
	JLabel lblNombre = new JLabel("Nombre");

	JPanel pnlNuevaPartida1 = new JPanel();
	JPanel pnlNuevaPartida2 = new JPanel();
	JPanel pnlNuevaPartida3 = new JPanel();
	JPanel pnlNuevaPartida4 = new JPanel();
	JPanel pnlNuevaPartida5 = new JPanel();
	JPanel pnlNuevaPartida6 = new JPanel();
	
	// Botones Men� Principal

	JButton btnLanzar = new JButton("Lanzar Moneda");
	JButton btnEmpezar = new JButton("Empezar");
	JButton btnCancelar = new JButton("Cancelar");
	JButton btnMostrar = new JButton("Mostrar");
	JButton btnVolver = new JButton("Volver");

	// TextFields Men� Principal

	JTextField txtNombre = new JTextField("",10);
	JTextField txtNombreJ1 = new JTextField("",10);
	JTextField txtNombreJ2 = new JTextField("",10);
	JTextField txtTipoPartida = new JTextField("",10);
	JTextField txtSeleccionColor = new JTextField("",10);

	// CheckBox Men� Principal
	boolean selected = false;

	JCheckBox chkMejorTres = new JCheckBox("�Al mejor de tres?", selected);
	JCheckBox chkUnoVsUno = new JCheckBox("Jug. vs Jug.", selected);
	JCheckBox  chkUnoVsIa = new JCheckBox(" Jug. vs I.A.", selected);

	// Choices de selecci�n de jugadores
	Choice choJugador1 = new Choice();
	Choice choJugador2 = new Choice();
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
	JLabel lblEste = new JLabel("Texto panel ESTE");
	JLabel lblOeste = new JLabel("Texto panel OESTE");
	JLabel lblNorte = new JLabel("Texto panel NORTE");
	JLabel lblSur = new JLabel("Texto panel SUR");

	// Componentes del tablero
	private JButton[][] casillas = new JButton[8][8];
	JButton fichaElegida = new JButton();
	JLabel[] letTablero = new JLabel[9];
	JLabel[] numTablero = new JLabel[9];
	JPanel tablero = new JPanel(new GridLayout(9, 9));
	JPanel tableroCompleto = new JPanel();

	// Colores
	Color colorNegro = new Color(173, 113, 0); // Casillas marron oscuro
	Color colorBlanco = new Color(227, 194, 102);// Casillas amarillo crema

	//TextArea para consulta de jugadores
	private TextArea txtAreaConsultaJugadores = new TextArea(20,40);
	
	char letra = 'A';
	JLabel lblLetra;
	JLabel lblNum;
	Integer i, j;
	ImageIcon caballoBa2 = new ImageIcon("./imagenes/sin_fondo/Caballo_blanco.png");

	public Vista()
	{

		setTitle("Men� Principal");
		setJMenuBar(barraMenu);
		
		
		mnJugar.add(getMniPartidaRapida());
		mnJugar.addSeparator();
		mnJugar.add(getMniSalir());
		
		mnClasificacion.add(getMniClasificacionJugador());
		mnClasificacion.add(getMniPartidas());
		mnAyuda.add(getMniAyuda());

		
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

		barraMenu.add(mnJugar);
		barraMenu.add(mnClasificacion);	
		barraMenu.add(mnAyuda);
		
		frmTablero.setTitle("Tablero");
		UIManager.put("Label.font", fuenteEtiquetas);

		// Crear y a�adir componentes del tablero
		for (i = 0; i < 9; i++)
		{
			for (j = 0; j < 9; j++, letra++)
			{
				if (i == 0 && j == 0)
				{
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
						numTablero[i] = new JLabel(Integer.toString(i));
						numTablero[i].setHorizontalAlignment(JLabel.CENTER);
						numTablero[i].setVerticalAlignment(JLabel.CENTER);
						tablero.add(numTablero[i]);
					} else
					{
						getCasillas()[i - 1][j - 1] = new JButton((i - 1) + ", " + (j - 1));
						getCasillas()[i - 1][j - 1].setPreferredSize(new Dimension(70, 70));
						if ((i + j) % 2 != 0)
						{
							getCasillas()[i - 1][j - 1].setBackground(colorNegro);
						}
						if ((i + j) % 2 == 0)
						{
							getCasillas()[i - 1][j - 1].setBackground(colorBlanco);
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

		frmTablero.setSize(1100, 800);
		frmTablero.setResizable(false);
		frmTablero.setLocationRelativeTo(null);
		frmTablero.setVisible(false);
		
		//TODO Completar frame para "Crear partida"
		
		dlgNuevaPartida.setLayout(new GridLayout(1,5));
		dlgNuevaPartida.setTitle("Crear Partida");
		
		pnlNuevaPartida1.add(lblTipoPartida);
		pnlNuevaPartida1.add(txtTipoPartida);
		dlgNuevaPartida.add(pnlNuevaPartida1);
		
		pnlNuevaPartida2.add(lblNombreJ1);
		pnlNuevaPartida2.add(txtNombreJ1);		
		dlgNuevaPartida.add(pnlNuevaPartida2);
		
		pnlNuevaPartida3.add(lblNombreJ2);
		pnlNuevaPartida3.add(txtNombreJ2);
		dlgNuevaPartida.add(pnlNuevaPartida3);
		
		pnlNuevaPartida4.add(lblSeleccionColor);
		pnlNuevaPartida4.add(txtSeleccionColor);
		txtSeleccionColor.setEditable(false);
		pnlNuevaPartida4.add(btnLanzar);
		dlgNuevaPartida.add(pnlNuevaPartida4);
		
		pnlNuevaPartida5.add(lblLimiTiempo);
		pnlNuevaPartida5.add(choTiempo);
		pnlNuevaPartida5.add(chkMejorTres);
		dlgNuevaPartida.add(pnlNuevaPartida5);
		
		pnlNuevaPartida6.add(btnEmpezar);
		pnlNuevaPartida6.add(btnCancelar);
		dlgNuevaPartida.add(pnlNuevaPartida6);
		
		dlgNuevaPartida.setSize(850, 125);
		dlgNuevaPartida.setVisible(false);
		dlgNuevaPartida.setLocationRelativeTo(null);
		dlgNuevaPartida.setResizable(true);
		
		
		
		
		//TODO Completar frame para "Ranking de jugadores"
		//Ranking de jugadores
		getFrmClasificacionJugador().setTitle("Clasificaci�n de jugadores");
		getFrmClasificacionJugador().setSize(600, 600);
		getFrmClasificacionJugador().setResizable(false);
		getFrmClasificacionJugador().setLocationRelativeTo(null);
		getFrmClasificacionJugador().setVisible(false);
		getFrmClasificacionJugador().add(getTxtAreaConsultaJugadores());
		
		
		
		//TODO Completar frame para "Ranking de partidas"
		
		//TODO Completar frame para "Ayuda"
		
		//TODO Completar frame para "Final de la partida"
		
	}

	public JDialog getDlgNuevaPartida()
	{
		return dlgNuevaPartida;
	}

	public void setDlgNuevaPartida(JDialog dlgNuevaPartida)
	{
		this.dlgNuevaPartida = dlgNuevaPartida;
	}

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

	public JMenuItem getMniPartidas() {
		return mniPartidas;
	}

	public void setMniPartidas(JMenuItem mniPartidas) {
		this.mniPartidas = mniPartidas;
	}

	public JMenuItem getMniAyuda() {
		return mniAyuda;
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

	public JFrame getFrmPartidaRapida() {
		return frmPartidaRapida;
	}

	public void setFrmPartidaRapida(JFrame frmPartidaRapida) {
		this.frmPartidaRapida = frmPartidaRapida;
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