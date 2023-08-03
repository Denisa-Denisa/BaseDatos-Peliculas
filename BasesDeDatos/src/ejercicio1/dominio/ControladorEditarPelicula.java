package ejercicio1.dominio;

import java.sql.SQLException;

import ejercicio1.datos.FilmModel;
import ejercicio1.vistas.Consola;
import ejercicio1.vistas.VistaDatosPelicula;
import ejercicio1.vistas.VistaEncabezado;
import ejercicio1.vistas.VistaEntradaEntero;
import ejercicio1.vistas.VistaEntradaPelicula;

public class ControladorEditarPelicula extends Controlador {

	public ControladorEditarPelicula(Logica logica) {
		super(logica);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void controlar() {
		new VistaEncabezado("Editar pelicula").visualizar();
		VistaEntradaEntero v = new VistaEntradaEntero("Id. pelicula: ");
		v.visualizar();
		int id = v.getEntero();
		Consola.escribir();

		Pelicula peli;
		try {
			peli = new FilmModel().getById(id);
			new VistaDatosPelicula(peli).visualizar();
			Consola.escribir();
			boolean ok = Consola.confirmar("Estas seguro");
			if (ok) {
				Consola.escribir();
				new VistaEntradaPelicula(peli).visualizar();
				// TODO: Validar peli
				int n = new FilmModel().updateById(peli);
				if (n > 0) {
					Consola.escribir("Pelicula actualizada.", Consola.ANSI_GREEN);
				}
			}
		} catch (SQLException e) {
			Consola.error("Problemas al pedir los datos.");
			e.printStackTrace();
		}
		Consola.pausar();
		setEstado(Estado.INICIO);
	}

}
