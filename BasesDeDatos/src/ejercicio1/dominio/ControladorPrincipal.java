package ejercicio1.dominio;

import java.util.Map;

import ejercicio1.vistas.VistaPrincipal;

public class ControladorPrincipal extends Controlador {

	private final Map<Integer, Estado> estados = Map.of(1, Estado.LISTAR_PELICULA, 2, Estado.NUEVA_PELICULA, 3,
			Estado.EDITAR_PELICULA, 4, Estado.ELIMINAR_PELICULA, 5, Estado.CONSULTAR_PELICULA, 0, Estado.FIN);

	public ControladorPrincipal(Logica logica) {
		super(logica);
	}

	@Override
	public void controlar() {
		VistaPrincipal menu = new VistaPrincipal("Pantalla principal");
		menu.visualizar();
		int op = menu.getOpcion();
		setEstado(estados.get(op));
	}
}
