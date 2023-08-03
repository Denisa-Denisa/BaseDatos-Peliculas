package ejercicio1.dominio;

public class Logica {
	private Estado estado;

	public Logica(Estado estado) {
		super();
		this.estado = estado;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Controlador getControlador() {
		if (estado == Estado.INICIO) {
			return new ControladorPrincipal(this);
		} else if (estado == Estado.LISTAR_PELICULA) {
			return new ControladorListarPeliculas(this);
		} else if (estado == Estado.EDITAR_PELICULA) {
			return new ControladorEditarPelicula(this);
		} else if (estado == Estado.CONSULTAR_PELICULA) {
			return new ControladorConsultarPelicula(this);
		} else if (estado == Estado.ELIMINAR_PELICULA) {
			return new ControladorEliminarPelicula(this);
		} else if (estado == Estado.NUEVA_PELICULA) {
			return new ControladorNuevaPelicula(this);
		} else if (estado == Estado.FIN) {
			return new ControladorFinalizacion(this);
		} else {
			return null;
		}
	}

}
