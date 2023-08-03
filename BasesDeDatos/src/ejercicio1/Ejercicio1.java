package ejercicio1;

import java.sql.SQLException;
import java.util.Set;

import ejercicio1.datos.FilmModel;
import ejercicio1.dominio.Controlador;
import ejercicio1.dominio.Estado;
import ejercicio1.dominio.Logica;
import ejercicio1.dominio.Pelicula;
import ejercicio1.vistas.Consola;

public class Ejercicio1 {
	/*
	 * CRUD - Create Read Update Delete
	 * 
	 * Realiza las operaciones básicas sobre la tabla films de la BBDD peliculas.
	 * 
	 * Crea un menu: =========== PELICULAS =========== 1. Listar. 2. Nueva. 3.
	 * Editar. 4. Eliminar. 5. Consultar.
	 * 
	 * 0. Salir.
	 * 
	 * Aplicar POO.
	 */

	private Logica logica;

	public Ejercicio1() {
		logica = new Logica(Estado.INICIO);
	}

	public void lanzar() {
		Controlador controlador;
		do {
			controlador = logica.getControlador();
			if (controlador != null) {
				try {
					controlador.controlar();
				} catch (SQLException e) {
					Consola.error("MALO: " + e.getMessage());
					e.printStackTrace();
				}
			}
		} while (controlador != null);
	}

	public static void main(String[] args) {
		new Ejercicio1().lanzar();
	}

	public static void testCrud() {
		try {
			FilmModel film = new FilmModel();
			Pelicula peli = film.getById(3);
			if (peli != null) {
				System.out.println(peli);
			}

			System.out.println();
			System.out.println("LISTADO DE PELICULAS");
			Set<Pelicula> peliculas = film.getAll();
			for (Pelicula p : peliculas) {
				System.out.println(p);
			}

			System.out.println();
			System.out.println("CREAR PELICULA");
			int n = film.create(new Pelicula("La vida de Brian", 1980, 94));
			if (n > 0) {
				System.out.println("Pelicula creada.");
			}

			System.out.println();
			System.out.println("ACTUALIZAR PELICULA");
			Pelicula oldPeli = film.getById(7);
			if (oldPeli != null) {
				oldPeli.setAnio(2022);
				oldPeli.setDuracion(222);
				int nn = film.updateById(oldPeli);
				if (nn > 0) {
					System.out.println("Pelicula actualizada.");
				}
			}
			System.out.println();
			System.out.println("ELIMINAR PELICULA");
			int nn = film.deleteById(6);
			if (nn > 0) {
				System.out.println("Pelicula eliminada.");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
