package ejercicio1.vistas;

public class VistaEncabezado {
	private String nombre;

	public VistaEncabezado(String titulo) {
		super();
		this.nombre = titulo;
	}

	public void visualizar() {
		String fila = Consola.repeat("*", nombre.length());
		Consola.escribir(fila, Consola.ANSI_BLUE);
		Consola.escribir(nombre.toUpperCase(), Consola.ANSI_BLUE);
		Consola.escribir(fila, Consola.ANSI_BLUE);
		Consola.escribir();
	}

}
