package ejercicio1.dominio;

import java.sql.SQLException;

public abstract class Controlador {
	private Logica logica;

	public Controlador(Logica logica) {
		this.logica = logica;
	}

	public void setEstado(Estado estado) {
		logica.setEstado(estado);
	}

	public Estado getEstado() {
		return logica.getEstado();
	}

	public abstract void controlar() throws SQLException;
}
