package ejercicio1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class FilmModel {
	private BaseDatos bd;

	public FilmModel() throws SQLException {
		super();
		bd = new BaseDatos();
	}

	public Pelicula getById(int id) throws SQLException {
		String sql = "SELECT * FROM films WHERE id=?";
		Object[] params = new Object[1];
		params[0] = id;
		ResultSet film = bd.query(sql, params);

		Pelicula peli = null;
		if (film.next()) {
			peli = new Pelicula(film.getInt("id"), film.getString("title"), film.getInt("year"),
					film.getInt("duration"));
		}
		return peli;
	}

	public Set<Pelicula> getAll() throws SQLException {
		String sql = "SELECT * FROM films";
		Object[] params = new Object[0];
		ResultSet film = bd.query(sql, params);

		Pelicula peli = null;
		Set<Pelicula> peliculas = new HashSet<>();
		while (film.next()) {
			peli = new Pelicula(film.getInt("id"), film.getString("title"), film.getInt("year"),
					film.getInt("duration"));
			peliculas.add(peli);
		}
		return peliculas;
	}

	public int create(Pelicula pelicula) throws SQLException {
		String sql = "INSERT INTO films (title, year, duration) VALUES(?,?,?)";
		Object[] params = new Object[3];
		params[0] = pelicula.getTitulo();
		params[1] = pelicula.getAnio();
		params[2] = pelicula.getDuracion();
		int n = bd.execute(sql, params);
		return n;
	}

	public int updateById(Pelicula pelicula) throws SQLException {
		String sql = "UPDATE films SET title=?, year=?, duration=? WHERE id=?";
		Object[] params = new Object[4];
		params[0] = pelicula.getTitulo();
		params[1] = pelicula.getAnio();
		params[2] = pelicula.getDuracion();
		params[3] = pelicula.getId();
		int n = bd.execute(sql, params);
		return n;
	}

	public int deleteById(int id) throws SQLException {
		String sql = "DELETE FROM films WHERE id=?";
		Object[] params = new Object[1];
		params[0] = id;
		int n = bd.execute(sql, params);
		return n;
	}
}
