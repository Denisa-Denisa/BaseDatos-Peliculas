package ejercicio1.dominio;

public class Pelicula {
	private int id;
	private String titulo;
	private int anio;
	private int duracion;

	public Pelicula() {
		this(0, "", 0, 0);
	}

	public Pelicula(int id, String titulo, int anio, int duracion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anio = anio;
		this.duracion = duracion;
	}

	public Pelicula(String titulo, int anio, int duracion) {
		super();
		this.titulo = titulo;
		this.anio = anio;
		this.duracion = duracion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", anio=" + anio + ", duracion=" + duracion + "]";
	}

}
