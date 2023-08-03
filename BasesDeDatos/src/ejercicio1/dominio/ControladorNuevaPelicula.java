package ejercicio1.dominio;

import java.sql.SQLException;

import ejercicio1.datos.FilmModel;
import ejercicio1.vistas.Consola;
import ejercicio1.vistas.VistaEncabezado;
import ejercicio1.vistas.VistaEntradaPelicula;

public class ControladorNuevaPelicula extends Controlador {

	public ControladorNuevaPelicula(Logica logica) {
		super(logica);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void controlar() {
		new VistaEncabezado("Nueva pelicula").visualizar();
		Pelicula pelicula = new Pelicula();
		new VistaEntradaPelicula(pelicula).visualizar();
		try {
			int n = new FilmModel().create(pelicula);
			if (n > 0) {
				Consola.escribir("Pelicula creada.", Consola.ANSI_GREEN);
			}
		} catch (SQLException e) {
			Consola.error("No se ha podido guardar la pelicula.");
			e.printStackTrace();
		}

		Consola.pausar();
		setEstado(Estado.INICIO);
	}

}
