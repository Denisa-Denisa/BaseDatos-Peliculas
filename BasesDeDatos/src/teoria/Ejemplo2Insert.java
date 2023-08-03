package teoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo2Insert {
	public static void main(String[] args) {
		// Conectar con MySql

		try {
			// Creamos la conexión con la base de datos.
			String url = "jdbc:mysql://localhost:3306/pelicula";
			Connection conn = DriverManager.getConnection(url, "root", "Printesa28");

			// Crea un comando y lo ejecuta
			String sql1 = "INSERT INTO films (title, year, duration) VALUES('Predator', 1987, 102)";
			String sql2 = "INSERT INTO films (title, year, duration) VALUES('Terminator', 1984, 107)";
			String sql3 = "INSERT INTO films (title, year, duration) VALUES('aaaaaaa', 1984, 107)";
			Statement stm = conn.createStatement();
			int n = stm.executeUpdate(sql3);
			if (n > 0) {
				System.out.println("Película creada.");
			}
			System.out.println("n=" + n);
			stm.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
