package ejercicio1.vistas;

import java.util.Set;

import ejercicio1.dominio.Pelicula;

public class VistaListaPeliculas {
	private String encabezado;
	private Set<Pelicula> peliculas;

	public VistaListaPeliculas(String encabezado, Set<Pelicula> peliculas) {
		this.encabezado = encabezado;
		this.peliculas = peliculas;
	}

	public void visualizar() {
		new VistaEncabezado(encabezado).visualizar();

		System.out.printf("%5s %-30s %4s %8s%n", "ID.", "TITULO", "AÑO", "DURACION");
		System.out.printf("%5s %30s %4s %8s%n", Consola.repeat("-", 5), Consola.repeat("-", 30), Consola.repeat("-", 4),
				Consola.repeat("-", 8));
		for (Pelicula p : peliculas) {
			System.out.printf("%5d %-30s %4d %3d min.%n", p.getId(), p.getTitulo(), p.getAnio(), p.getDuracion());
		}

		Consola.pausar();
	}
}
