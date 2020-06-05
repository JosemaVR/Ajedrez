package modelo;

import java.awt.Dimension;
import java.awt.TextArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import vista.Vista;


public class Modelo
{
	private String[][] tablero = new String[8][8];
	int color = 0;

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
	/*
	public void nuevoJuego(JButton[][] casillas) {
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				getTablero()[i][j] = null;
			}
		}
		getTablero()[0][0] = "Tn1";
		getTablero()[0][1] = "Cn1";
		getTablero()[0][2] = "An1";
		getTablero()[0][3] = "Qn1";
		getTablero()[0][4] = "Kn1";
		getTablero()[0][5] = "An2";
		getTablero()[0][6] = "Cn2";
		getTablero()[0][7] = "Tn2";
		getTablero()[1][0] = "Pn1";
		getTablero()[1][1] = "Pn2";
		getTablero()[1][2] = "Pn3";
		getTablero()[1][3] = "Pn4";
		getTablero()[1][4] = "Pn5";
		getTablero()[1][5] = "Pn6";
		getTablero()[1][6] = "Pn7";
		getTablero()[1][7] = "Pn8";

		getTablero()[7][0] = "Tb1";
		getTablero()[7][1] = "Cb1";
		getTablero()[7][2] = "Ab1";
		getTablero()[7][3] = "Qb1";
		getTablero()[7][4] = "Kb1";
		getTablero()[7][5] = "Ab2";
		getTablero()[7][6] = "Cb2";
		getTablero()[7][7] = "Tb2";
		getTablero()[6][0] = "Pb1";
		getTablero()[6][1] = "Pb2";
		getTablero()[6][2] = "Pb3";
		getTablero()[6][3] = "Pb4";
		getTablero()[6][4] = "Pb5";
		getTablero()[6][5] = "Pb6";
		getTablero()[6][6] = "Pb7";
		getTablero()[6][7] = "Pb8";

		setIcons(getTablero(), casillas);
	}*/

	public Random nuevoTurno() {
		Random turno = new Random(1);
		return turno;
		//		blanco=1		negro=0
	}

	public int cambiarTurno(int turno) {
		if (turno==1) {
			turno = 0;
		}
		else {
			turno = 1;
		}
		return turno;
	}

	/*
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
	}*/

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

	public String[][] getTablero() {
		return tablero;
	}

	public void setTablero(String[][] tablero) {
		this.tablero = tablero;
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