package teoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo4Delete {

	public static void main(String[] args) {
		try {
			// Creamos la conexión con la base de datos.
			String url = "jdbc:mysql://localhost:3306/peliculas";
			Connection conn = DriverManager.getConnection(url, "root", "Printesa28");

			// Crea un comando y lo ejecuta
			String sql = "DELETE FROM films WHERE id=8";

			Statement stm = conn.createStatement();
			int n = stm.executeUpdate(sql);
			if (n > 0) {
				System.out.println("Película eliminada.");
			}
			System.out.println("n=" + n);
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
