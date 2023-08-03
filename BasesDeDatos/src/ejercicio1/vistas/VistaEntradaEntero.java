package ejercicio1.vistas;

public class VistaEntradaEntero {
	private int entero;

	public VistaEntradaEntero(String etiqueta) {

	}

	public int getEntero() {
		return entero;
	}

	public void visualizar() {
		boolean seguir = true;
		do {
			try {
				entero = Consola.getInt("Id. de la pelicula: ");
				seguir = false;
			} catch (NumberFormatException e) {
				Consola.error("No v�lido. Intentalo de nuevo.");
			}
		} while (seguir);
	}

}
