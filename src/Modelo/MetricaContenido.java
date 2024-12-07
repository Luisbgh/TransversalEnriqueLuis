package Modelo;

import java.util.Date;

import com.opencsv.bean.CsvBindByName;

public class MetricaContenido {
	
	@CsvBindByName(column = "creador_id")
	private int creador_id;
	
	@CsvBindByName(column = "plataforma")
	private String plataforma;
	
	@CsvBindByName(column = "fecha")
	private String fecha;
	
	@CsvBindByName(column = "contenido")
	private String contenido;
	
	@CsvBindByName(column = "tipo")
	private String tipo;
	
	@CsvBindByName(column = "vistas")
	private int vistas;
	
	@CsvBindByName(column = "me_gusta")
	private int me_gusta;
	
	@CsvBindByName(column = "comentarios")
	private int comentarios;

	@CsvBindByName(column = "compartidos")
	private int compartidos;

	public int getCreador_id() {
		return creador_id;
	}

	public void setCreador_id(int creador_id) {
		this.creador_id = creador_id;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getVistas() {
		return vistas;
	}

	public void setVistas(int vistas) {
		this.vistas = vistas;
	}

	public int getMe_gusta() {
		return me_gusta;
	}

	public void setMe_gusta(int me_gusta) {
		this.me_gusta = me_gusta;
	}

	public int getComentarios() {
		return comentarios;
	}

	public void setComentarios(int comentarios) {
		this.comentarios = comentarios;
	}

	public int getCompartidos() {
		return compartidos;
	}

	public void setCompartidos(int compartidos) {
		this.compartidos = compartidos;
	}

	@Override
	public String toString() {
		return "MetricaContenido [creador_id=" + creador_id + ", plataforma=" + plataforma + ", fecha=" + fecha
				+ ", contenido=" + contenido + ", tipo=" + tipo + ", vistas=" + vistas + ", me_gusta=" + me_gusta
				+ ", comentarios=" + comentarios + ", compartidos=" + compartidos + "]";
	}
	
}
