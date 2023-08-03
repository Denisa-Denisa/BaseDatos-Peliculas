package ejercicio1.vistas;

public class VistaPrincipal {
	private final String[] opciones = { "1. Listar.", "2. Nueva.", "3. Editar.", "4. Eliminar.", "5. Consultar.", "",
			"0. Salir" };

	private int opcion;
	private String encabezado;

	public VistaPrincipal(String encabezado) {
		this.encabezado = encabezado;
	}

	public int getOpcion() {
		return opcion;
	}

	public void visualizar() {
		new VistaEncabezado(encabezado).visualizar();
		escribirMenu();
		Consola.escribir();
		opcion = Consola.getIntInRange(0, 5, "Elige una opcion: ");
	}

	private void escribirMenu() {
		Consola.escribir("PELICULAS");
		for (String op : opciones) {
			Consola.escribir(op);
		}
	}

}
