package ejercicio1.dominio;

import java.sql.SQLException;

import ejercicio1.vistas.Consola;

public class ControladorFinalizacion extends Controlador {

	public ControladorFinalizacion(Logica logica) {
		super(logica);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void controlar() throws SQLException {
		Consola.escribir("FIN", Consola.ANSI_GREEN);
		System.exit(0);
	}

}
