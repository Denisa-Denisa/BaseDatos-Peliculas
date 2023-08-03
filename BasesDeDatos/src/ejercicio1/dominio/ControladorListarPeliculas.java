package ejercicio1.dominio;

import java.sql.SQLException;
import java.util.Set;

import ejercicio1.datos.FilmModel;
import ejercicio1.vistas.Consola;
import ejercicio1.vistas.VistaListaPeliculas;

public class ControladorListarPeliculas extends Controlador {

	public ControladorListarPeliculas(Logica logica) {
		super(logica);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void controlar() {
		try {
			Set<Pelicula> peliculas = new FilmModel().getAll();
			new VistaListaPeliculas("Listado de peliculas", peliculas).visualizar();
		} catch (SQLException e) {
			Consola.error("No se ha podido obtener la informaci�n. Int�ntalo mas tarde.");
			e.printStackTrace();
		}
		setEstado(Estado.INICIO);
	}

}
