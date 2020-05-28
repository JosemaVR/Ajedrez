package juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class Vista extends JFrame 
{

	private static final long serialVersionUID = 1L;

	JFrame frmInicio = new JFrame();
	JMenuBar barraMenu = new JMenuBar();
	JMenu mnJugar = new JMenu();
	JMenu mnClasificacion = new JMenu();
	JMenu mnAyuda = new JMenu();

	JMenuItem mniPartidaRapida = new JMenuItem("Partida Rápida");
	JMenuItem mniSalir = new JMenuItem("Salir");
	JMenuItem mniJugador = new JMenuItem("Jugador");
	JMenuItem mniPartidas = new JMenuItem("Partidas");
	JMenuItem mniAyuda = new JMenuItem("Ayuda");

	// Etiquetas Menú Principal

	JLabel lblNombreJ1 = new JLabel("Nombre Jugador 1");
	JLabel lblNombreJ2 = new JLabel("Nombre Jugador 2");
	JLabel lblTipoPartida = new JLabel("Tipo de Partida");
	JLabel lblSeleccionColor = new JLabel("Seleccionar color");
	JLabel lblLimiTiempo = new JLabel("Límite de tiempo");
	JLabel lblNombre = new JLabel("Nombre");

	// Botones Menú Principal

	JButton btnLanzar = new JButton("Lanzar");
	JButton btnEmpezar = new JButton("Empezar");
	JButton btnCancelar = new JButton("Cancelar");
	JButton btnMostrar = new JButton("Mostrar");
	JButton btnVolver = new JButton("Volver");

	// TextFields Menú Principal

	JTextField txtNombre = new JTextField();
	JTextField txtNombreJ1 = new JTextField();
	JTextField txtNombreJ2 = new JTextField();
	JTextField txtSeleccionColor = new JTextField();

	// Choices Menú Principal
	boolean selected = false;

	JCheckBox chkMejorTres = new JCheckBox("¿Al mejor de tres?", selected);
	JCheckBox chkUnoVsUno = new JCheckBox("Jugador contra Jugador", selected);
	JCheckBox chkUnoVsIa = new JCheckBox();

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
	JLabel lblEste = new JLabel("Texto panel ESTE");
	JLabel lblOeste = new JLabel("Texto panel OESTE");
	JLabel lblNorte = new JLabel("Texto panel NORTE");
	JLabel lblSur = new JLabel("Texto panel SUR");

	// Componentes del tablero
	JButton[][] casillas = new JButton[8][8];
	JButton fichaElegida = new JButton();
	JLabel[] letTablero = new JLabel[9];
	JLabel[] numTablero = new JLabel[9];
	JPanel tablero = new JPanel(new GridLayout(9, 9));
	JPanel tableroCompleto = new JPanel();

	// Colores
	Color colorNegro = new Color(173, 113, 0); // Casillas marron oscuro
	Color colorBlanco = new Color(227, 194, 102);// Casillas amarillo crema

	char letra = 'A';
	JLabel lblLetra;
	JLabel lblNum;
	Integer i, j;
	ImageIcon caballoBa2 = new ImageIcon("./imagenes/sin_fondo/Caballo_blanco.png");

	public Vista()
	{

		frmInicio.setTitle("Menú Principal");
		frmInicio.setJMenuBar(barraMenu);
		
		
		mnJugar.add(mniPartidaRapida);
		mnJugar.addSeparator();
		mnJugar.add(mniSalir);
		
		mnClasificacion.add(mniJugador);
		mnClasificacion.add(mniPartidas);
		mnAyuda.add(mniAyuda);

		
		frmInicio.setSize(300, 300);
		frmInicio.setLocationRelativeTo(null);
		frmInicio.setVisible(true);
		frmInicio.setResizable(false);

		barraMenu.add(mnJugar);
		barraMenu.add(mnClasificacion);	
		barraMenu.add(mnAyuda);
		
		setTitle("Tablero");
		UIManager.put("Label.font", fuenteEtiquetas);

		// Crear y añadir componentes del tablero
		for (i = 0; i < 9; i++)
		{
			for (j = 0; j < 9; j++, letra++)
			{
				if (i == 0 && j == 0)
				{
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
						numTablero[i] = new JLabel(Integer.toString(i));
						numTablero[i].setHorizontalAlignment(JLabel.CENTER);
						numTablero[i].setVerticalAlignment(JLabel.CENTER);
						tablero.add(numTablero[i]);
					} else
					{
						casillas[i - 1][j - 1] = new JButton((i - 1) + ", " + (j - 1));
						casillas[i - 1][j - 1].setPreferredSize(new Dimension(70, 70));
						if ((i + j) % 2 != 0)
						{
							casillas[i - 1][j - 1].setBackground(colorNegro);
						}
						if ((i + j) % 2 == 0)
						{
							casillas[i - 1][j - 1].setBackground(colorBlanco);
						}
						tablero.add(casillas[i - 1][j - 1]);
					}
				}
			}
		}

		tableroCompleto.add(tablero);
		add(tableroCompleto);

		panelEste.add(lblEste);
		add(panelEste, BorderLayout.EAST);

		panelOeste.setPreferredSize(new Dimension(25, 25));
		panelOeste.add(lblOeste);
		add(panelOeste, BorderLayout.WEST);

		panelNorte.add(lblNorte);
		add(panelNorte, BorderLayout.NORTH);

		panelSur.add(lblSur);
		add(panelSur, BorderLayout.SOUTH);

		setSize(1100, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
	}
}
