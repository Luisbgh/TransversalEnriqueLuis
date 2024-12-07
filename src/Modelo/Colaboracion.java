package Modelo;

public class Colaboracion {
	
	private String creador;
	private String plataforma;
	private String colaborador;
	private String fechaInicio;
	private String fechaFin;
	
	public Colaboracion(String creador, String plataforma, String colaborador, String fechaInicio, String fechaFin) {
		this.creador = creador;
		this.plataforma = plataforma;
		this.colaborador = colaborador;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getColaborador() {
		return colaborador;
	}

	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "Colaboracion [creador=" + creador + ", plataforma=" + plataforma + ", colaborador=" + colaborador
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
}
