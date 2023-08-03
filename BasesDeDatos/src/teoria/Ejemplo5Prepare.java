package teoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo5Prepare {

	public static void main(String[] args) {
		String  str1 = "1";
		String  str2 = "4 OR 1=1";
		badSelect(str1);
		// select(str1);
		
		//insert("Predator", 1987, 102);
	}

	
	public static void badSelect(String id) {
		try {
			// Creamos la conexión con la base de datos.
			String url = "jdbc:mysql://localhost:3306/peliculas";
			Connection conn = DriverManager.getConnection(url, "root", "root");
			
			// Crea un comando y lo ejecuta
			String sql = "SELECT * FROM films WHERE id=" + id;
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			// Procesamos los datos recibidos
			while(rs.next()) {
				System.out.printf("%2d - %-45s - %4d - %3d min.%n", rs.getInt("id"), rs.getString("title"), rs.getInt("year"), rs.getInt("duration"));
			}
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void select(String id) {
		try {
			// Creamos la conexión con la base de datos.
			String url = "jdbc:mysql://localhost:3306/peliculas";
			Connection conn = DriverManager.getConnection(url, "root", "root");
			
			// Crea un comando y lo ejecuta
			String sql = "SELECT * FROM films WHERE id = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, id);
			ResultSet rs = stm.executeQuery();
			
			// Procesamos los datos recibidos
			while(rs.next()) {
				System.out.printf("%2d - %-45s - %4d - %3d min.%n", rs.getInt("id"), rs.getString("title"), rs.getInt("year"), rs.getInt("duration"));
			}
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert(String title, int year, int duration) {
		try {
			// Creamos la conexión con la base de datos.
			String url = "jdbc:mysql://localhost:3306/peliculas";
			Connection conn = DriverManager.getConnection(url, "root", "root");
			
			// Crea un comando y lo ejecuta
			String sql = "INSERT INTO films (title, year, duration) VALUES (?, ?, ?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, title);
			stm.setInt(2, year);
			stm.setInt(3, duration);
			int n = stm.executeUpdate();
			if (n>0) {
				System.out.println("Película creada.");
			}
			System.out.println("n="+n);
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
