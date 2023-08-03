package ejercicio1.vistas;

import ejercicio1.dominio.Pelicula;

public class VistaEntradaPelicula {
	private Pelicula pelicula;

	public VistaEntradaPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public void visualizar() {
		pelicula.setTitulo(Consola.getString("Titulo: "));
		pelicula.setAnio(Consola.getInt("Año: "));
		pelicula.setDuracion(Consola.getInt("Duracion: "));
	}

}
