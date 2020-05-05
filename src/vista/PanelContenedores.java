package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class PanelContenedores extends JFrame
{
	Tablero_v3 tablerin;
	
	private static final long serialVersionUID = 1L;

	private JPanel contenedor;// Panel contenedor

	private JPanel panelCentral;
	private JPanel panelNorte;
	private JPanel panelSur;
	private JPanel panelOeste;
	private JPanel panelEste;

	// Límites

	private Border borderContents = BorderFactory.createEmptyBorder(10, 10, 10, 10);
	//private Border borderRegion = BorderFactory.createLineBorder(Color.RED, 1);

	// Colores
	private Color colorContenedores = Color.WHITE; // Panel contenedor

	// Fuentes:

	private Font fuenteEtiquetas = new Font(Font.DIALOG, Font.BOLD, 16);

	public PanelContenedores()
	{

		super("Conjunto paneles Java");
		setFonts();
		
		contenedor = new JPanel();
		contenedor.setLayout(new BorderLayout());
		contenedor.setBorder(borderContents);
		contenedor.setBackground(colorContenedores);
		contenedor.setSize(750, 750);
		setContentPane(contenedor);
		// Crear y añadir componentes
		

		panelEste = new JPanel();
	//panelEste.setBorder(borderRegion);
		JLabel lblEste = new JLabel("Texto panel ESTE");
		panelEste.add(lblEste);
		contenedor.add(panelEste, BorderLayout.EAST);

		panelOeste = new JPanel();
		//panelOeste.setBorder(borderRegion);
		panelOeste.setPreferredSize(new Dimension(25, 25));
		JLabel lblOeste = new JLabel("Texto panel OESTE");
		panelOeste.add(lblOeste);
		contenedor.add(panelOeste, BorderLayout.WEST);

		panelNorte = new JPanel();
		//panelNorte.setBorder(borderRegion);
		JLabel lblNorte = new JLabel("Texto panel NORTE");
		panelNorte.add(lblNorte);
		contenedor.add(panelNorte, BorderLayout.NORTH);
		
		panelSur = new JPanel();
		//panelSur.setBorder(borderRegion);
		JLabel lblSur = new JLabel("Texto panel SUR");
		panelSur.add(lblSur);
		contenedor.add(panelSur, BorderLayout.SOUTH);

		tablerin = new Tablero_v3((int) contenedor.getSize().getWidth()/10, (int) contenedor.getSize().getHeight()/10);
		
		panelCentral = new JPanel();		
		panelCentral.add(tablerin.getContentPane());
		contenedor.add(panelCentral, BorderLayout.CENTER);
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void setFonts() {
		UIManager.put("Label.font", fuenteEtiquetas);
	}
	public static void main(String[] args)
	{

		PanelContenedores prueba = new PanelContenedores();
		prueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
