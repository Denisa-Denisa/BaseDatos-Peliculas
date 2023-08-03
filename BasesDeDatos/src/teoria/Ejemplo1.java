package teoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo1 {

	public static void main(String[] args) {
		// Conectar con MySql

		try {
			// Creamos la conexión con la base de datos.
			String url = "jdbc:mysql://localhost:3306/pelicula";
			final String USUARIO = "root";
			final String CONTRASEÑA = "contaseña";
			Connection conn = DriverManager.getConnection(url, "root", "Printesa28");

			// Crea un comando y lo ejecuta
			String sql = "SELECT * FROM films LIMIT 10"; // el asterisco significa que se cogen todos los campos,. si
															// quiere uno concreto quitarlo y poner el nombre del campo
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			// Procesamos los datos recibidos
			while (rs.next()) {
				System.out.printf("%2d - %-45s - %4d - %3d min.%n", rs.getInt("id"), rs.getString("title"),
						rs.getInt("year"), rs.getInt("duration"));
			}
			stm.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
