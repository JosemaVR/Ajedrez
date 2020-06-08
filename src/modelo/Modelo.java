package modelo;

import java.awt.Choice;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;


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

	public void consultaJugadoresRanking(TextArea consulta) {
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
							"  - Derrotas: "+rs.getInt("derrotas") + "\n");
				}
				else
				{
					i++;
					consulta.setText(consulta.getText() + "\n" + i +
							"º - Nombre: "+rs.getString("nombreUsuario")+
							" // Victorias: "+rs.getInt("victorias")+
							"  - Tablas: "+rs.getInt("tablas")+
							"  - Derrotas: "+rs.getInt("derrotas") + "\n");
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][Error al consultar]");
			ex.printStackTrace();
		}
	} 

	public void consultaJugador1(Choice usuario) {
		Connection con = conectar();
		String sqlSelect = "SELECT * FROM usuarios";
		try {
			// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) 
			{
				usuario.add(rs.getInt("idUsuario")+
						"-"+rs.getString("nombreUsuario"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("ERROR: al consultar");
			ex.printStackTrace();
		}
	} 

	public void consultaJugador2(Choice usuario, String jugador1) {
		Connection con = conectar();
		String sqlSelect = "SELECT * FROM usuarios WHERE idUsuario <> " + jugador1;
		try {
			// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) 
			{
				usuario.add(rs.getInt("idUsuario")+
						"-"+rs.getString("nombreUsuario"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("ERROR: al consultar");
			ex.printStackTrace();
		}
	} 

	public Integer[][] movimientoCaballo(Pieza caballo) {
		Integer[][] i = new Integer[8][2];
		i[0][0] = caballo.getX()+1;
		i[0][1] = caballo.getY()+2;
		i[1][0] = caballo.getX()-1;
		i[1][1] = caballo.getY()+2;
		i[2][0] = caballo.getX()+1;
		i[2][1] = caballo.getY()-2;
		i[3][0] = caballo.getX()-1;
		i[3][1] = caballo.getY()-2;
		i[4][0] = caballo.getX()+2;
		i[4][1] = caballo.getY()+1;
		i[5][0] = caballo.getX()-2;
		i[5][1] = caballo.getY()+1;
		i[6][0] = caballo.getX()+2;
		i[6][1] = caballo.getY()-1;
		i[7][0] = caballo.getX()-2;
		i[7][1] = caballo.getY()-1;
		return i;
	}



	public String iconoPieza(JButton casilla) {
		Pieza torreN = new Pieza(ColorPieza.NEGRO, TipoPieza.TORRE, 0, 0);
		Pieza caballoN = new Pieza(ColorPieza.NEGRO, TipoPieza.CABALLO, 1, 0);
		Pieza alfilN = new Pieza(ColorPieza.NEGRO, TipoPieza.ALFIL, 2, 0);
		Pieza reinaN = new Pieza(ColorPieza.NEGRO, TipoPieza.REINA, 3, 0);
		Pieza reyN = new Pieza(ColorPieza.NEGRO, TipoPieza.REY, 4, 0);
		Pieza peonN = new Pieza(ColorPieza.NEGRO, TipoPieza.PEON, 0, 1);
		Pieza torreB = new Pieza(ColorPieza.BLANCO, TipoPieza.TORRE, 0, 7);
		Pieza caballoB = new Pieza(ColorPieza.BLANCO, TipoPieza.CABALLO, 1, 7);
		Pieza alfilB = new Pieza(ColorPieza.BLANCO, TipoPieza.ALFIL, 2, 7);
		Pieza reinaB = new Pieza(ColorPieza.BLANCO, TipoPieza.REINA, 3, 7);
		Pieza reyB = new Pieza(ColorPieza.BLANCO, TipoPieza.REY, 4, 7);
		Pieza peonB = new Pieza(ColorPieza.BLANCO, TipoPieza.PEON, 0, 6);
		String res = "Vacío";
		if(casilla.getIcon()==null) {
			res = "Vacío";
		}
		else if(casilla.getIcon().toString() == torreN.getIcono().toString() 
				|| casilla.getIcon().toString() == torreB.getIcono().toString()) {
			res = "Torre";
		}
		else if(casilla.getIcon().toString() == caballoN.getIcono().toString() 
				|| casilla.getIcon().toString() == caballoB.getIcono().toString()) {
			res = "Caballo";
		}
		else if(casilla.getIcon().toString() == alfilN.getIcono().toString() 
				|| casilla.getIcon().toString() == alfilB.getIcono().toString()) {
			res = "Alfil";
		}
		else if(casilla.getIcon().toString() == reinaN.getIcono().toString() 
				|| casilla.getIcon().toString() == reinaB.getIcono().toString()) {
			res = "Reina";
		}
		else if(casilla.getIcon().toString() == reyN.getIcono().toString() 
				|| casilla.getIcon().toString() == reyB.getIcono().toString()) {
			res = "Rey";
		}
		else if(casilla.getIcon().toString() == peonN.getIcono().toString()) {
			res = "Peon";
		}
		else if(casilla.getIcon().toString() == peonB.getIcono().toString()) {
			res = "Peon";
		}
		return res;
	}

	public String numeroLetra(Integer x) {
		String res = "";
		if(x == 0) {
			res = "A";
		}
		else if(x == 1) {
			res = "B";
		}
		else if(x == 2) {
			res = "C";
		}
		else if(x == 3) {
			res = "D";
		}
		else if(x == 4) {
			res = "E";
		}
		else if(x == 5) {
			res = "F";
		}
		else if(x == 6) {
			res = "G";
		}
		else if(x == 7) {
			res = "H";
		}
		return res;
	}

	public void crearJugador(JTextField txtNombreNuevoJugador) {
		Connection con = conectar();
		try 
		{
			Statement sta2 = con.createStatement();

			String cadenaSQL = "INSERT INTO usuarios (nombreUsuario) VALUES ('" + txtNombreNuevoJugador.getText() + "')";
			sta2.executeUpdate(cadenaSQL);
			sta2.close();
			System.out.println("[" + LocalDate.now() + "][" + LocalTime.now() + "][Creado nuevo usuario: "+ txtNombreNuevoJugador.getText() +"]");
		} 
		catch (SQLException ex) 
		{
			System.out.println("ERROR al hacer un Insert");
			ex.printStackTrace();
		}
	}

	public void escribirLog(String mensaje) {

		Logger logger = Logger.getLogger("MyLog");
		FileHandler fh;
		String textoAnterior = "";
		try {

			fh = new FileHandler("log.txt", true);
			logger.addHandler(fh);

			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

			try { 
				//Origen de los datos en el proyecto anterior 
				FileReader fr = new FileReader("log.txt"); 
				//Buffer de lectura BufferedReader 
				BufferedReader entrada = new BufferedReader(fr); 
				String s; 
				//Bucle para sacar la información del archivo 
				while((s=entrada.readLine())!=null) { 
					textoAnterior = textoAnterior + s;
				} 
				//Cerrar el objeto entrada
				entrada.close(); 
				fr.close(); 
			} catch(FileNotFoundException e) { 
				System.out.println("Archivo NO encontrado"); 
			} catch(IOException i) { 
				System.out.println("Se produjo un error de Archivo"); 
			} 

			logger.info("[" + mensaje + "] \n");

			fh.close();
		} catch (SecurityException e) {
			System.out.println("error 1");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("error 2");
			e.printStackTrace();
		}
	}

	public ColorPieza colorPieza(JButton casilla) {
		ColorPieza res = ColorPieza.VACIO;
		if(casilla.getIcon() == null) {
			res = ColorPieza.VACIO;
		}
		else {
			if(casilla.getIcon().toString().contains("negr")) {
				res = ColorPieza.NEGRO;
			}
			else if(casilla.getIcon().toString().contains("blanc")) {
				res = ColorPieza.BLANCO;
			}
		}
		return res;
	}
}