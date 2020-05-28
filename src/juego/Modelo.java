package juego;

import java.awt.TextArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Modelo
{
	String[][] tablero = new String[8][8];
	
	public Connection conectar()
	{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ajedrez?autoReconnect=true&useSSL=false";
		String user = "ajedrez";
		String password = "Ajedrez2020;";
		Connection con = null;
		try {
			// Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			// Establecer la conexión con la BD empresa
			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][Conectando a la base de datos]");
			}
		} catch (SQLException ex) {
			System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][ERROR:La dirección no es válida o el usuario y clave]");
			ex.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error 1-" + cnfe.getMessage());
		}
		return con;
	}
	
	public void nuevoJuego(JButton[][] casillas) {
		
		
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				tablero[i][j] = null;
			}
		}
		
		tablero[0][0] = "Tn1";
		tablero[0][1] = "Cn1";
		tablero[0][2] = "An1";
		tablero[0][3] = "Qn1";
		tablero[0][4] = "Kn1";
		tablero[0][5] = "An2";
		tablero[0][6] = "Cn2";
		tablero[0][7] = "Tn2";
		tablero[1][0] = "Pn1";
		tablero[1][1] = "Pn2";
		tablero[1][2] = "Pn3";
		tablero[1][3] = "Pn4";
		tablero[1][4] = "Pn5";
		tablero[1][5] = "Pn6";
		tablero[1][6] = "Pn7";
		tablero[1][7] = "Pn8";
		
		
		tablero[7][0] = "Tb1";
		tablero[7][1] = "Cb1";
		tablero[7][2] = "Ab1";
		tablero[7][3] = "Qb1";
		tablero[7][4] = "Kb1";
		tablero[7][5] = "Ab2";
		tablero[7][6] = "Cb2";
		tablero[7][7] = "Tb2";
		tablero[6][0] = "Pb1";
		tablero[6][1] = "Pb2";
		tablero[6][2] = "Pb3";
		tablero[6][3] = "Pb4";
		tablero[6][4] = "Pb5";
		tablero[6][5] = "Pb6";
		tablero[6][6] = "Pb7";
		tablero[6][7] = "Pb8";
		
		setIcons(tablero, casillas);
	}
	
	public static void setIcons(String[][] tablero, JButton[][] casillas) {
		ImageIcon pn = new ImageIcon("./imagenes/sin_fondo/Peon_negro.png");
		ImageIcon pb = new ImageIcon("./imagenes/sin_fondo/Peon_blanco.png");
		
		ImageIcon cn = new ImageIcon("./imagenes/sin_fondo/Caballo_negro.png");
		ImageIcon tn = new ImageIcon("./imagenes/sin_fondo/Torre_negra.png");
		ImageIcon an = new ImageIcon("./imagenes/sin_fondo/Alfil_negro.png");
		ImageIcon qn = new ImageIcon("./imagenes/sin_fondo/Reina_negra.png");
		ImageIcon kn = new ImageIcon("./imagenes/sin_fondo/Rey_negro.png");
		
		ImageIcon cb = new ImageIcon("./imagenes/sin_fondo/Caballo_blanco.png");
		ImageIcon tb = new ImageIcon("./imagenes/sin_fondo/Torre_blanca.png");
		ImageIcon ab = new ImageIcon("./imagenes/sin_fondo/Alfil_blanco.png");
		ImageIcon qb = new ImageIcon("./imagenes/sin_fondo/Reina_blanca.png");
		ImageIcon kb = new ImageIcon("./imagenes/sin_fondo/Rey_blanco.png");
		
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				casillas[i][j].setIcon(null);
			}
		}
		
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (tablero[i][j].equals("Pn1")) {
					casillas[i][j].setIcon(pn);
				}
				if (tablero[i][j].equals("Pn2")) {
					casillas[i][j].setIcon(pn);
				}
				if (tablero[i][j].equals("Pn3")) {
					casillas[i][j].setIcon(pn);
				}
				if (tablero[i][j].equals("Pn4")) {
					casillas[i][j].setIcon(pn);
				}
				if (tablero[i][j].equals("Pn5")) {
					casillas[i][j].setIcon(pn);
				}
				if (tablero[i][j].equals("Pn6")) {
					casillas[i][j].setIcon(pn);
				}
				if (tablero[i][j].equals("Pn7")) {
					casillas[i][j].setIcon(pn);
				}
				if (tablero[i][j].equals("Pn8")) {
					casillas[i][j].setIcon(pn);
				}
				
				if (tablero[i][j].equals("Pb1")) {
					casillas[i][j].setIcon(pb);
				}
				if (tablero[i][j].equals("Pb2")) {
					casillas[i][j].setIcon(pb);
				}
				if (tablero[i][j].equals("Pb3")) {
					casillas[i][j].setIcon(pb);
				}
				if (tablero[i][j].equals("Pb4")) {
					casillas[i][j].setIcon(pb);
				}
				if (tablero[i][j].equals("Pb5")) {
					casillas[i][j].setIcon(pb);
				}
				if (tablero[i][j].equals("Pb6")) {
					casillas[i][j].setIcon(pb);
				}
				if (tablero[i][j].equals("Pb7")) {
					casillas[i][j].setIcon(pb);
				}
				if (tablero[i][j].equals("Pb8")) {
					casillas[i][j].setIcon(pb);
				}
				
				if (tablero[i][j].equals("Tn1")) {
					casillas[i][j].setIcon(tn);
				}
				if (tablero[i][j].equals("Cn1")) {
					casillas[i][j].setIcon(cn);
				}
				if (tablero[i][j].equals("An1")) {
					casillas[i][j].setIcon(an);
				}
				if (tablero[i][j].equals("Qn1")) {
					casillas[i][j].setIcon(qn);
				}
				if (tablero[i][j].equals("Kn1")) {
					casillas[i][j].setIcon(kn);
				}
				if (tablero[i][j].equals("An2")) {
					casillas[i][j].setIcon(an);
				}
				if (tablero[i][j].equals("Cn2")) {
					casillas[i][j].setIcon(cn);
				}
				if (tablero[i][j].equals("Tn2")) {
					casillas[i][j].setIcon(tn);
				}
				
				if (tablero[i][j].equals("Tb1")) {
					casillas[i][j].setIcon(tb);
				}
				if (tablero[i][j].equals("Cb1")) {
					casillas[i][j].setIcon(cb);
				}
				if (tablero[i][j].equals("Ab1")) {
					casillas[i][j].setIcon(ab);
				}
				if (tablero[i][j].equals("Qb1")) {
					casillas[i][j].setIcon(qb);
				}
				if (tablero[i][j].equals("Kb1")) {
					casillas[i][j].setIcon(kb);
				}
				if (tablero[i][j].equals("Ab2")) {
					casillas[i][j].setIcon(ab);
				}
				if (tablero[i][j].equals("Cb2")) {
					casillas[i][j].setIcon(cb);
				}
				if (tablero[i][j].equals("Tb2")) {
					casillas[i][j].setIcon(tb);
				}
			}
		}
	}

	public boolean esMovimValido(int i, int j, int linea, int columna)
	{
		int lineaPosicion = Math.abs(i - linea);
		int columnaPosicion = Math.abs(j - columna);

		if ((lineaPosicion == 1) && (columnaPosicion == 2))
		{
			return true;
		}
		if ((columnaPosicion == 1) && (lineaPosicion == 2))
		{
			return true;
		}
		return false;
	}

	public void procesoClic(int i, int j, int linea, int columna, ImageIcon pieza)
	{
		JButton casillas[][] = new  JButton[8][8];
		if (esMovimValido(i, j, linea, columna) == false)
		{
			return;
		}
		casillas[linea][columna].setIcon(null);
		casillas[i][j].setIcon(pieza);
		linea = i;
		columna = j;
	}

	public void botonAccion(Object fuente,  int linea, int columna, JButton[][] casillas, ImageIcon pieza)
	{
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (fuente == casillas[i][j])
				{
					procesoClic(i, j, linea, columna, pieza);
				}
			}
		}
	}
	public boolean seleccionPieza (JButton[][] casillas, ImageIcon pieza) {
				
		boolean focus = false;
		
		
		return focus;
		
	}
	
	public void consultaJugadores(TextArea consulta) {
		System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][Consultando ranking]");
		Connection con = conectar();
		String sqlSelect = "SELECT * FROM usuarios, partidas WHERE "
				+ "usuarios.idUsuario = partidas.idGanadorFK "
				+ "ORDER BY usuarios.victorias DESC, usuarios.tablas DESC, usuarios.nombreUsuario ASC";
		int i = 0;
		try {
			// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) 
			{
				if(consulta.getText().length()==0)
				{
					i++;
					consulta.setText(i +
							"º - Nombre: "+rs.getString("nombreUsuario")+
							" // Victorias: "+rs.getInt("victorias")+
							"  - Tablas: "+rs.getInt("tablas")+
							"  - Derrotas: "+rs.getInt("derrotas"));
				}
				else
				{
					i++;
					consulta.setText(consulta.getText() + "\n" + i +
							"º - Nombre: "+rs.getString("nombreUsuario")+
							" // Victorias: "+rs.getInt("victorias")+
							"  - Tablas: "+rs.getInt("tablas")+
							"  - Derrotas: "+rs.getInt("derrotas"));
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][Error al consultar]");
			ex.printStackTrace();
		}
	} 
}
