package ejercicio1.dominio;

import java.sql.SQLException;

import ejercicio1.datos.FilmModel;
import ejercicio1.vistas.Consola;
import ejercicio1.vistas.VistaDatosPelicula;
import ejercicio1.vistas.VistaEncabezado;
import ejercicio1.vistas.VistaEntradaEntero;

public class ControladorConsultarPelicula extends Controlador {

	public ControladorConsultarPelicula(Logica logica) {
		super(logica);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void controlar() {
		new VistaEncabezado("Consultar película").visualizar();
		VistaEntradaEntero v = new VistaEntradaEntero("Id. de la película:");
		v.visualizar();
		int id = v.getEntero();
		Consola.escribir();

		Pelicula peli;
		try {
			peli = new FilmModel().getById(id);
			new VistaDatosPelicula(peli).visualizar();
		} catch (SQLException e) {
			Consola.error("Problemas al pedir los datos.");
			e.printStackTrace();
		}

		Consola.pausar();
		setEstado(Estado.INICIO);
	}

}
