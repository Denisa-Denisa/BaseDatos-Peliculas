package ejercicio1.dominio;

import java.sql.SQLException;

import ejercicio1.datos.FilmModel;
import ejercicio1.vistas.Consola;
import ejercicio1.vistas.VistaDatosPelicula;
import ejercicio1.vistas.VistaEncabezado;
import ejercicio1.vistas.VistaEntradaEntero;

public class ControladorEliminarPelicula extends Controlador {
	public ControladorEliminarPelicula(Logica logica) {
		super(logica);
		// TODO Auto-generated constructor stub
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void controlar() {
		new VistaEncabezado("Eliminar pelicula").visualizar();
		VistaEntradaEntero v = new VistaEntradaEntero("Id. pelicula: ");
		v.visualizar();
		int id = v.getEntero();
		Consola.escribir();
		try {
			FilmModel film = new FilmModel();
			Pelicula pelicula = film.getById(id);
			new VistaDatosPelicula(pelicula).visualizar();
			Consola.escribir();
			boolean ok = Consola.confirmar("Estas seguro");
			if (ok) {
				int n = film.deleteById(id);
				if (n > 0) {
					Consola.escribir("Pelicula eliminada.", Consola.ANSI_GREEN);
				}
			}
		} catch (SQLException e) {
			Consola.error("Algo ha ido mal con la base de datos.");
			e.printStackTrace();
		}

		Consola.pausar();
		setEstado(Estado.INICIO);

	}

}
