package Controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JLabel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import Modelo.Colaboracion;
import Modelo.Colaborador;
import Modelo.MetricaContenido;

public class Funcionalidad {

	public static void main(String[]args) throws Exception {

		Funcionalidad lanzador=new Funcionalidad();
		
		try {
			//EJERCICIO 1
			//LEER CSV
			System.out.println("---CSV---");
			List<MetricaContenido> misMetricasDeContenido;
			misMetricasDeContenido = lanzador.abrirCSV("files/metricas_contenido.csv");
			lanzador.mostrarMetricasContenido(misMetricasDeContenido);
			//LEER JSON
			System.out.println("---JSON---");
			ArrayNode creadores=lanzador.obtenerListaCreadores("files/creadores.json");
			lanzador.mostrarJson(creadores);
			
			
			

		}catch(IOException e) {
			e.printStackTrace();
			throw e;
		}//catch
			
	}//FIN MAIN
	
	//LEER ARCHIVO CSV
	public List<MetricaContenido> abrirCSV(String rutaCSV) throws Exception{
		List<MetricaContenido> misMetricasDeContenido = null;
		
		FileReader fr = new FileReader(rutaCSV);
		
		CsvToBeanBuilder<MetricaContenido> csvBuilder = new CsvToBeanBuilder<MetricaContenido>(fr);
		CsvToBean<MetricaContenido> csv = csvBuilder.withType(MetricaContenido.class).withIgnoreLeadingWhiteSpace(true).build();
		
		misMetricasDeContenido = csv.parse();
		
		return misMetricasDeContenido;
	}//abrirCSV
	
	//MOSTRAR METRICAS CONTENIDO
	public void mostrarMetricasContenido(List<MetricaContenido> metricasDeContenido) {
		for(MetricaContenido metrica:metricasDeContenido) {
			System.out.println("-----------(SIGUIENTE CREADOR)-----------");
			System.out.println("ID_CREADOR: " + metrica.getCreador_id() + "\n"
							   + "PLATAFORMA: " + metrica.getPlataforma() + "\n"
							   + "FECHA: " + metrica.getFecha() + "\n"
							   + "CONTENIDO: " + metrica.getContenido() + "\n"
							   + "TIPO: " + metrica.getTipo() + "\n"
							   + "VISTAS: " + metrica.getVistas() + "\n" 
							   + "ME GUSTA: " + metrica.getMe_gusta() + "\n"
							   + "COMENTARIOS: " + metrica.getComentarios() + "\n"
							   + "COMPARTIDOS: " + metrica.getCompartidos() + "\n");
		}//for
	}//mostrarMetricasContenido
	
	//OBTENER LISTA JSON
	public ArrayNode obtenerListaCreadores(String rutaJSON) throws JsonProcessingException, IOException {
		ArrayNode creadores = null;
		try {
			File archivo = new File(rutaJSON);
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode raiz = objectMapper.readTree(archivo);
			creadores = (ArrayNode) raiz;
		}catch(IOException e) {
			e.printStackTrace();
			throw e;
		}
		return creadores;
		
	}//obtenerListaCreadores
	
	//LEER LISTA JSON
	public void mostrarJson(ArrayNode creadores) {
		
		try {
			for(JsonNode creador: creadores) {
				System.out.println("-----SIGUIENTE CREADOR-----");
				//
				System.out.println("ID# " + creador.get("id").asInt());
				System.out.println("NOMBRE# " + creador.get("nombre").asText());
				System.out.println("PAIS# " + creador.get("pais").asText());
				System.out.println("TEMATICA# " + creador.get("tematica").asText());
				System.out.println("SEGUIDORES TOTALES# " + creador.get("seguidores_totales").asInt());
				System.out.println("---------------Estadisticas--------------");
				JsonNode estadisticas=creador.get("estadisticas");
					System.out.println("	INTERACCIONES_TOTALES# " + estadisticas.get("interacciones_totales"));
					System.out.println("	PROMEDIO_VISTAS_MENSUALES# " + estadisticas.get("promedio_vistas_mensuales"));
					System.out.println("	TASA_CRECIMIENTO_SEGUIDORES# " + estadisticas.get("tasa_crecimiento_seguidores"));
					System.out.println("------------Fin Estadisticas-------------");
					System.out.println("------------Plataformas------------------");
				ArrayNode plataformas= (ArrayNode) creador.get("plataformas");
				for(JsonNode plataforma: plataformas) {
					System.out.println("-----------SIGUIENTE PLATAFORMA");
					System.out.println("		NOMBRE# " + plataforma.get("nombre").asText());
					System.out.println("		USUARIO# " + plataforma.get("usuario").asText());
					System.out.println("		SEGUIDORES# " + plataforma.get("seguidores").asInt());
					System.out.println("		FECHA_CREACION# " + plataforma.get("fecha_creacion").asText());
					System.out.println("			HISTORICO#");
					ArrayNode historico=(ArrayNode) plataforma.get("historico");
						for(JsonNode historial: historico) {
							System.out.println("			FECHA# " + historial.get("fecha"));
							System.out.println("			NUEVOS_SEGUIDORES# " + historial.get("nuevos_seguidores"));
							System.out.println("			INTERACCIONES# " + historial.get("interacciones"));
						}//for
				}//for
					System.out.println("-------------Fin Plataformas-----------------");
				System.out.println("--------Colaboraciones-------");
				ArrayNode colaboradores= (ArrayNode) creador.get("colaboraciones");
				for(JsonNode colaboracion: colaboradores) {
					System.out.println("------------------SIGUIENTE COLABORADOR");
					System.out.println("	COLABORADOR# " + colaboracion.get("colaborador"));
					System.out.println("	TEMATICA# " + colaboracion.get("tematica"));
					System.out.println("	FECHA_INICIO# " + colaboracion.get("fecha_inicio"));
					System.out.println("	FECHA_FIN# " + colaboracion.get("fecha_fin"));
					System.out.println("	TIPO# " + colaboracion.get("tipo"));
					System.out.println("	ESTADO# " + colaboracion.get("estado"));
				}//for
			}//for
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}//catch
			
	}//mostrarJson
	
	//EJERCICIO 2
	public void calcularPromedioVistasYMeGustas(List<MetricaContenido> metricasDeContenido, JLabel lblPromedioMeGustasInstagram, JLabel lblPromedioVistasInstagram, JLabel lblPromedioMeGustasTikTok, 
			JLabel lblPromedioVistasTikTok, JLabel lblPromedioMeGustasYT, JLabel lblPromedioVistasYT, JLabel lblPromedioMeGustasTwitch, JLabel lblPromedioVistasTwitch,
			JLabel lblcontenidoTk, JLabel lblcontenidoYt, JLabel lblcontenidoTw, JLabel lblcontenidoIg) {
		
		double totalVistasInstagram = 0, totalMeGustaInstagram = 0, contadorInstagram = 0;
		double totalVistasTikTok = 0, totalMeGustaTiktok = 0, contadorTikTok = 0;
		double totalVistasYouTube = 0, totalMeGustaYouTube = 0, contadorYouTube = 0;
		double totalVistasTwitch = 0, totalMeGustaTwitch = 0, contadorTwitch = 0;
		double renImagenYT = 0, renVideoYT = 0, renImagenIg = 0, renVideoIg = 0, renImagenTk = 0, renVideoTk = 0, renImagenTw = 0, renVideoTw = 0;
		
		for(MetricaContenido metrica : metricasDeContenido) {
			double promedio = (metrica.getComentarios() + metrica.getCompartidos() + metrica.getVistas() + metrica.getMe_gusta())/4;
			switch(metrica.getPlataforma()) {
				case "Instagram":
					totalVistasInstagram = totalVistasInstagram + metrica.getVistas();
					totalMeGustaInstagram = totalMeGustaInstagram + metrica.getMe_gusta();
					contadorInstagram++;
					
					if(metrica.getTipo().equals("imagen")) {
						renImagenIg = renImagenIg + promedio;
					}else {
						renVideoIg = renVideoIg + promedio;
					}//else
					break;
				case "TikTok":
					totalVistasTikTok = totalVistasTikTok + metrica.getVistas();
					totalMeGustaTiktok = totalMeGustaTiktok + metrica.getMe_gusta();
					contadorTikTok++;
					
					if(metrica.getTipo().equals("imagen")) {
						renImagenTk = renImagenTk + promedio;
					}else {
						renVideoTk = renVideoTk + promedio;
					}//else
					break;
				case "YouTube":
					totalVistasYouTube = totalVistasYouTube + metrica.getVistas();
					totalMeGustaYouTube = totalMeGustaYouTube + metrica.getMe_gusta();
					contadorYouTube++;
					
					if(metrica.getTipo().equals("imagen")) {
						renImagenYT = renImagenYT + promedio;
					}else {
						renVideoYT = renVideoYT + promedio;
					}//else
					break;
				case "Twitch":
					totalVistasTwitch = totalVistasTwitch + metrica.getVistas();
					totalMeGustaTwitch = totalMeGustaTwitch + metrica.getMe_gusta();
					contadorTwitch++;
					
					if(metrica.getTipo().equals("imagen")) {
						renImagenTw = renImagenTw + promedio;
					}else {
						renVideoTw = renVideoTw + promedio;
					}//else
					break;
				default:
					break;
			}//switch
		}//for
		
		actualizarResultados(lblPromedioMeGustasInstagram, lblPromedioVistasInstagram, lblcontenidoIg, totalVistasInstagram, totalMeGustaInstagram, contadorInstagram, renImagenIg, renVideoIg);
		actualizarResultados(lblPromedioMeGustasTikTok, lblPromedioVistasTikTok, lblcontenidoTk, totalVistasTikTok, totalMeGustaTiktok, contadorTikTok, renImagenTk, renVideoTk);
		actualizarResultados(lblPromedioMeGustasYT, lblPromedioVistasYT, lblcontenidoYt, totalVistasYouTube, totalMeGustaYouTube, contadorYouTube, renImagenYT, renVideoYT);
		actualizarResultados(lblPromedioMeGustasTwitch, lblPromedioVistasTwitch, lblcontenidoTw, totalVistasTwitch, totalMeGustaTwitch, contadorTwitch, renImagenTw, renVideoTw);
		
	}//CALCULAR PROMEDIO VISTAS Y ME GUSTAS
	
	public void actualizarResultados(JLabel lblPromedioMeGustas, JLabel lblPromedioVistas, JLabel lblContenido, double totalVistas, double totalMegustas, double contadorPlataforma, double renImagen, double renVideo) {
		if(contadorPlataforma>0) {
			lblPromedioMeGustas.setText(String.valueOf(totalMegustas/contadorPlataforma));
			lblPromedioVistas.setText(String.valueOf(totalVistas/contadorPlataforma));
			
			if(renImagen > renVideo) {
				lblContenido.setText("Imagen");
			}else {
				lblContenido.setText("Video");
			}//else
		}else {
			lblPromedioMeGustas.setText("");
			lblPromedioVistas.setText("");
			lblContenido.setText("");
		}//else
		
	}//ACTUALIZAR RESULTADOS
	
	
	//EJERCICIO 3
		public void crearNuevoCSVMetricas(List<MetricaContenido> metricas, String nuevaRutaCSV){
			try {
				FileWriter fw = new FileWriter(nuevaRutaCSV);
				
				StatefulBeanToCsv<MetricaContenido> beanToCsv = new StatefulBeanToCsvBuilder<MetricaContenido>(fw).build();
				beanToCsv.write(metricas);
				fw.flush();
				
			}catch(Exception e) {
				e.printStackTrace();
			}//catch
		}//crearNuevoCSV
	
	//EJERICIO 4
	public void exportarColaboracionesCSV(ArrayNode creadores, List<MetricaContenido> misMetricasDeContenido) {
			
			try {
				for(JsonNode creador: creadores) {
					ArrayNode colaboraciones= (ArrayNode) creador.get("colaboraciones");
					for(JsonNode colaboracion: colaboraciones) {
						for(MetricaContenido metricas: misMetricasDeContenido){
							
						}//for
					}//for
				}//for
			}catch(Exception e) {
				e.printStackTrace();
				throw e;
			}//catch
			
	}//exportarColaboracionesCSV
		
	public ObjectNode crearColaboracionJson(Colaborador colaborador) {
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode nuevaColaboracion = mapper.createObjectNode();
			
			nuevaColaboracion.put("colaborador", colaborador.getColaborador());
			nuevaColaboracion.put("tematica", colaborador.getTematica());
			nuevaColaboracion.put("fecha_inicio", colaborador.getFechaInicio());
			nuevaColaboracion.put("fecha_fin", colaborador.getFechaFin());
			nuevaColaboracion.put("tipo", colaborador.getTipo());
			nuevaColaboracion.put("estado", colaborador.getEstado());
			//
			return nuevaColaboracion;
	}//crearColaboracionJson
		
	
	//EJERCICIO 6
	public void generarInformeCreadoresJSON(String rutaJSON, String rutaInformeJSON) throws JsonProcessingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode creadores = objectMapper.readTree(new File(rutaJSON));
		
		ArrayNode reporteCreadores = objectMapper.createArrayNode();
		
		for(JsonNode creador : creadores) {
			String nombreCreador = creador.get("nombre").asText();
			int totalSeguidores = 0;
			double promedioInteracciones = 0, maxPromedioInteracciones = 0;
			String mejorPlataforma = null;
			
			for(JsonNode plataforma : creador.get("plataformas")) {
				totalSeguidores = totalSeguidores + plataforma.get("seguidores").asInt();
				
				int totalInteracciones = 0, contador = 0;
				
				for(JsonNode historial : plataforma.get("historico")) {
					totalInteracciones = totalInteracciones + historial.get("interacciones").asInt();
					contador++;
				}
				
				if(contador > 0) {
					promedioInteracciones = totalInteracciones / contador;
				}else {
					promedioInteracciones = 0;
				}
				
				if(promedioInteracciones>maxPromedioInteracciones) {
					maxPromedioInteracciones = promedioInteracciones;
					mejorPlataforma = plataforma.get("nombre").asText();
				}
			}
			
			ObjectNode creadorReporte = objectMapper.createObjectNode();
			creadorReporte.put("nombre", nombreCreador);
			creadorReporte.put("total_seguidores", totalSeguidores);
			creadorReporte.put("mejor_plataforma", mejorPlataforma);
			
			reporteCreadores.add(creadorReporte);
		}
		ObjectNode rootNode=objectMapper.createObjectNode();
		rootNode.set("Creadores", reporteCreadores);
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(rutaInformeJSON), rootNode);
	}//FIN GENERAR INFORME CREADORES
	
	//EJERCICIO 8
	public void generarReporteColaboraciones(String rutaJSON, String rutaCSV) throws Exception {	
		try {
			File archivoJSON = new File(rutaJSON);
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode creadores = objectMapper.readTree(archivoJSON);
			
			List<Colaboracion> colaboraciones = new ArrayList<>();
			
			for(JsonNode creador : creadores) {
				String nombreCreador = creador.get("nombre").asText();
				
				if(creador.has("plataformas") && creador.has("colaboraciones")) {
					for(JsonNode colaboracion : creador.get("colaboraciones")) {
						String colaborador = colaboracion.get("colaborador").asText();
						String fechaInicio = colaboracion.get("fecha_inicio").asText();
						String fechaFin = colaboracion.get("fecha_fin").asText();
						
						for(JsonNode plataforma: creador.get("plataformas")) {
							String nombrePlataforma = plataforma.get("nombre").asText();
							
							Colaboracion nuevaColaboracionCSV = new Colaboracion(nombreCreador, nombrePlataforma, colaborador, fechaInicio, fechaFin);
							colaboraciones.add(nuevaColaboracionCSV);
						}//for3
					}//for2
				}//if1
			}//for1
			crearNuevoCSV(colaboraciones, rutaCSV);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}//catch
		
	}//GENERAR REPORTE COLABORACIONES JSON A CSV
	
	public void crearNuevoCSV(List<Colaboracion> colaboraciones, String nuevaRutaCSV){
		try {
			FileWriter fw = new FileWriter(nuevaRutaCSV);
			
			StatefulBeanToCsv<Colaboracion> beanToCsv = new StatefulBeanToCsvBuilder<Colaboracion>(fw).build();
			beanToCsv.write(colaboraciones);
			fw.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}//catch
	}//crearNuevoCSV
	
	//EJERCICIO 10
	public void calcularResumenRendimiento(String rutaJSON) throws JsonProcessingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode creadores = objectMapper.readTree(new File(rutaJSON));
		
		ArrayNode resumenRendimiento = objectMapper.createArrayNode();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		for(JsonNode creador : creadores) {
			String nombreCreador = creador.get("nombre").asText();
			
			String plataformaMasVistas = null, plataformaMasInteracciones = null;
			int maxVistas = 0;
			double maxPromedioInteracciones = 0;
			
			for(JsonNode plataforma : creador.get("plataformas")) {
				String nombrePlataforma = plataforma.get("nombre").asText();
				int totalVistas = 0, totalInteracciones = 0, contador = 0;
				
				for(JsonNode historico : plataforma.get("historico")) {
					LocalDate fecha = LocalDate.parse(historico.get("fecha").asText(), formatoFecha);
				
					if(fecha.getYear()==2023) {
						totalVistas = totalVistas + historico.get("nuevos_seguidores").asInt();
						totalInteracciones = totalInteracciones + historico.get("interacciones").asInt();
						contador++;
					}
				}
				
				if(totalVistas>maxVistas) {
					maxVistas = totalVistas;
					plataformaMasVistas = nombrePlataforma;
				}
				
				if(contador>0) {
					double promedioInteracciones = totalInteracciones / contador;
					if(promedioInteracciones > maxPromedioInteracciones) {
						maxPromedioInteracciones = promedioInteracciones;
						plataformaMasInteracciones = nombrePlataforma;
					}
				}
			}
			
			ObjectNode resultadoCreador = objectMapper.createObjectNode();
			resultadoCreador.put("nombre", nombreCreador);
			resultadoCreador.put("plataformaMasVistas2023", plataformaMasVistas);
			resultadoCreador.put("plataformaMasInteraccionesPromedio2023", plataformaMasInteracciones);
			
			resumenRendimiento.add(resultadoCreador);
		}
		ObjectNode rootNode=objectMapper.createObjectNode();
		rootNode.set("ResumenRendimientoCreadores2023", resumenRendimiento);
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("informesJSON/resumen_rendimiento_creadores.json"), rootNode);
		
	}//FIN CALCULAR RESUMEN RENDIMIENTO
	
	//EJERCICO 12
	
	public void convertirColaboraciones(String rutaJSON) throws JsonProcessingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode creadores = mapper.readTree(new File(rutaJSON));
		ArrayNode conversiones=(ArrayNode)mapper.createArrayNode();
		
		try {	
			for(JsonNode creador : creadores) {
				ArrayNode colaboraciones=(ArrayNode)creador.get("colaboraciones");
				for(JsonNode colaboracion: colaboraciones) {
					ObjectNode colaborador=mapper.createObjectNode();
					colaborador.put("colaboracion", colaboracion.get("colaborador").asText());
					colaborador.put("tematica", colaboracion.get("tematica").asText());
					colaborador.put("fecha_inicio", colaboracion.get("fecha_inicio").asText());
					colaborador.put("fecha_fin", colaboracion.get("fecha_fin").asText());
					colaborador.put("tipo", colaboracion.get("tipo").asText());
					colaborador.put("estado", colaboracion.get("estado").asText());
					//
					conversiones.add(colaborador);
				}//for
			}//for
			ObjectNode rootNode=mapper.createObjectNode();
			rootNode.set("Colaboraciones", conversiones);
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("informesJSON/colaboraciones.json"), rootNode);

		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}//catch
		
	}//convertirColaboraciones
	
	
	
	
}//FIN FUNCIONALIDAD