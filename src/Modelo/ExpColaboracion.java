package Modelo;

public class ExpColaboracion {

	private String creador, colaborador, fecha;
	private int visualizaciones, seguidores;
	
	public ExpColaboracion() {
		
	}//ExpColaboracion

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public String getColaborador() {
		return colaborador;
	}

	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getVisualizaciones() {
		return visualizaciones;
	}

	public void setVisualizaciones(int visualizaciones) {
		this.visualizaciones = visualizaciones;
	}

	public int getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(int seguidores) {
		this.seguidores = seguidores;
	}

	@Override
	public String toString() {
		return "ExpColaboracion [creador=" + creador + ", colaborador=" + colaborador + ", fecha=" + fecha
				+ ", visualizaciones=" + visualizaciones + ", seguidores=" + seguidores + "]";
	}//toString
	
}//ExpColaboracion
