package ejercicio1.vistas;

import ejercicio1.dominio.Pelicula;

public class VistaDatosPelicula {
	private Pelicula pelicula;

	public VistaDatosPelicula(Pelicula pelicula) {
		super();
		this.pelicula = pelicula;
	}

	public void visualizar() {
		if (pelicula != null) {
			System.out.printf("Id.......: %d%n", pelicula.getId());
			System.out.printf("Titulo...: %s%n", pelicula.getTitulo());
			System.out.printf("Año......: %d%n", pelicula.getAnio());
			System.out.printf("Duraciin.: %d min.%n", pelicula.getDuracion());
		} else {
			Consola.error("Pel�cula no encontrada.");
		}
	}

}
