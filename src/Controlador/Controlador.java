package Controlador;

import Vista.InterfazApp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.swing.table.DefaultTableCellRenderer;

import Modelo.Colaborador;
import Modelo.MetricaContenido;
import Vista.InterfazApp;

public class Controlador implements ActionListener, MouseListener {
	
	//INTEFAZZ
	private InterfazApp vista=new InterfazApp();
	//FUNCIONALIDAD
	private Funcionalidad funcionalidad=new Funcionalidad();
    	
    //VARIABLES
	private String plataforma=null;
	private ArrayList<String>listaCreadores=new ArrayList<String>();
	private ArrayNode creadores;
	private ArrayNode colaboraciones;
	private ArrayNode plataformas;
	private DefaultListModel modeloColaboraciones=new DefaultListModel();
	private DefaultTableCellRenderer centrar=new DefaultTableCellRenderer();
	private DefaultTableModel modeloPlataformas = new DefaultTableModel();
	private DefaultTableModel modeloHistorial = new DefaultTableModel();
	private int idCreador;
	private ObjectMapper objectMapper;
	
    public Controlador(InterfazApp frame) throws JsonProcessingException, IOException {
        this.vista=frame;
        //LISTENERS
        this.vista.itemDatos.addActionListener(this);
        this.vista.itemColaboracionesCsv.addActionListener(this);
        this.vista.combobox_CreadoresContenido.addActionListener(this);
        this.vista.combobox_Ámbitos.addActionListener(this);
        this.vista.comboBox_menuGeneracionJson.addActionListener(this);
        this.vista.btnInstagram.addActionListener(this);
        this.vista.btnYt.addActionListener(this);
        this.vista.btnTiktok.addActionListener(this);
        this.vista.btnTwitch.addActionListener(this);
        this.vista.btn_ReportarColaboracionesCSV.addActionListener(this);
        this.vista.btn_ExportacionesColaboradoresCsv.addActionListener(this);
        this.vista.itemGeneracionJson.addActionListener(this);
        this.vista.btnCrearColaboracion.addActionListener(this);
        this.vista.btnGenerarInformeJson.addActionListener(this);
        //MOUSE LISTENERS
        this.vista.listColaboraciones.addMouseListener(this);
        //RELLENO COMBOBOX
        rellenarComboboxCreadoresContenido();
        
    }//FIN CONSTRUCTOR CONTROLADOR

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==vista.itemDatos) {
			vista.panelBodyPagina.setVisible(false);
			vista.panelInformacionCreadores.setVisible(true);
			vista.panelCreacionesJson.setVisible(false);
			vista.panelColaboracionesCsv.setVisible(false);
			vista.lblItemSeleccionado.setText(vista.itemDatos.getText());
		}///ITEM DATOS
		if(e.getSource()==vista.combobox_CreadoresContenido) {
			if(vista.combobox_CreadoresContenido.getSelectedIndex()==0) {
				vista.panelInformacionPersonal.setVisible(false);
				vista.panel_Estadisticas.setVisible(false);
				vista.lbl_ÁmbitosDisponibles.setVisible(false);
				vista.separator_3.setVisible(false);
				vista.combobox_Ámbitos.setVisible(false);
				vista.panelAmbito.setVisible(false);
				vista.combobox_Ámbitos.setSelectedIndex(0);
			}else {
				try {
					mostrarInformacionCreador();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}//COMBOBOX CREADORES CONTENIDO
		
		if(e.getSource()==vista.combobox_Ámbitos) {
			if(vista.combobox_CreadoresContenido.getSelectedIndex()==0) {
				vista.panelAmbito.setVisible(false);
			}else {
				setearCampos();
				if(vista.combobox_Ámbitos.getSelectedIndex()==1) {
					vista.panelAmbito.setVisible(true);
					vista.lbl_TituloÁmbitos.setText("PLATAFORMAS");
					vista.scrollPaneColaboraciones.setVisible(false);
					vista.lbTituloList.setVisible(false);
					vista.btnTwitch.setVisible(true);
					vista.btnInstagram.setVisible(true);
					vista.btnTiktok.setVisible(true);
					vista.btnYt.setVisible(true);
					vista.panelInformacionColaborador.setVisible(false);
					vista.scrollPane_TablaInformacionMetricas.setVisible(false);
					vista.scrollPaneHistoricoPlataformas.setVisible(true);
					vista.scrollPaneInformacionPlataformas.setVisible(true);
					vista.panel_InformacionPlataformas.setVisible(true);
					vista.panel_RendimientoCreadores.setVisible(false);
					vista.panelCreacionesJson.setVisible(false);
					vista.panelColaboracionesCsv.setVisible(false);
				}else if(vista.combobox_Ámbitos.getSelectedIndex()==2){
					vista.panelAmbito.setVisible(true);
					vista.lbl_TituloÁmbitos.setText("MÉTRICAS");
					vista.btnTwitch.setVisible(false);
					vista.btnInstagram.setVisible(false);
					vista.btnTiktok.setVisible(false);
					vista.btnYt.setVisible(false);
					vista.panel_InformacionPlataformas.setVisible(false);
					vista.scrollPaneColaboraciones.setVisible(false);
					vista.lbTituloList.setVisible(false);
					vista.panelInformacionColaborador.setVisible(false);
					vista.scrollPane_TablaInformacionMetricas.setVisible(true);
					vista.panel_RendimientoCreadores.setVisible(false);
					vista.panelCreacionesJson.setVisible(false);
					vista.panelColaboracionesCsv.setVisible(false);
				}else if(vista.combobox_Ámbitos.getSelectedIndex()==3){
					vista.panelAmbito.setVisible(true);
					vista.lbl_TituloÁmbitos.setText("COLABORACIONES");
					vista.panel_InformacionPlataformas.setVisible(false);
					vista.scrollPaneColaboraciones.setVisible(true);
					vista.lbTituloList.setVisible(true);
					vista.btnTwitch.setVisible(false);
					vista.btnInstagram.setVisible(false);
					vista.btnTiktok.setVisible(false);
					vista.btnYt.setVisible(false);
					vista.panelInformacionColaborador.setVisible(true);
					vista.scrollPane_TablaInformacionMetricas.setVisible(false);
					vista.panel_RendimientoCreadores.setVisible(false);
					vista.panelCreacionesJson.setVisible(false);
					vista.panelColaboracionesCsv.setVisible(false);
				}else if(vista.combobox_Ámbitos.getSelectedIndex()==4){
					vista.panel_RendimientoCreadores.setVisible(true);
					vista.panelAmbito.setVisible(true);
					vista.lbl_TituloÁmbitos.setText("RENDIMIENTO");
					vista.panel_InformacionPlataformas.setVisible(false);
					vista.btnTwitch.setVisible(false);
					vista.btnInstagram.setVisible(false);
					vista.btnTiktok.setVisible(false);
					vista.btnYt.setVisible(false);
					vista.scrollPaneColaboraciones.setVisible(false);
					vista.lbTituloList.setVisible(false);
					vista.panelInformacionColaborador.setVisible(false);
					vista.panelCreacionesJson.setVisible(false);
					vista.panelColaboracionesCsv.setVisible(false);
				}else {
					vista.panelAmbito.setVisible(false);
					vista.panelCreacionesJson.setVisible(false);
					vista.panelColaboracionesCsv.setVisible(false);
				}//else
			}//else
		}//COMBOBOX AMBITOS
		
		if(e.getSource()==vista.btnInstagram) {
			plataforma="Instagram";
			mostrarInformacionPlataformas(plataformas, plataforma, modeloPlataformas, modeloHistorial);
		}else if(e.getSource()==vista.btnTiktok) {
			plataforma="TikTok";
			mostrarInformacionPlataformas(plataformas, plataforma, modeloPlataformas, modeloHistorial);
		}else if(e.getSource()==vista.btnYt) {
			plataforma="Youtube";
			mostrarInformacionPlataformas(plataformas, plataforma, modeloPlataformas, modeloHistorial);
		}else if(e.getSource()==vista.btnTwitch) {
			plataforma="Twitch";
			mostrarInformacionPlataformas(plataformas, plataforma, modeloPlataformas, modeloHistorial);
		}//else if
		
		if(e.getSource()==vista.itemColaboracionesCsv) {
			vista.panelBodyPagina.setVisible(false);
			vista.panelInformacionCreadores.setVisible(false);
			vista.panelColaboracionesCsv.setVisible(true);
			vista.lblItemSeleccionadoColaboracionesCsv.setText(vista.itemColaboracionesCsv.getText());
		}///ITEM DATOS
		
		if(e.getSource()==vista.btn_ReportarColaboracionesCSV) {
			try {
				funcionalidad.generarReporteColaboraciones("files/creadores.json", "exportacionesCSV/reporteColaboraciones.csv");
			} catch (Exception e1) {
				e1.printStackTrace();
			}//catch
			vista.lbl_MensajeInfoUsuarioColaboracionesCSV.setText("REPORTE DE COLABORACIONES REALIZADO");
		}//if
		
		if(e.getSource()==vista.btn_ExportacionesColaboradoresCsv) {
			//funcionalidad.exportarColaboracionesCSV(creadores, metricas);
		}//if
		
		if(e.getSource()==vista.itemGeneracionJson) {
			vista.panelBodyPagina.setVisible(false);
			vista.panelInformacionCreadores.setVisible(false);
			vista.panelColaboracionesCsv.setVisible(false);
			vista.panelCreacionesJson.setVisible(true);
			vista.lbitemMenuJsonGeneracionSeleccionado.setText(vista.itemGeneracionJson.getText());
		}//if
		
		if(e.getSource()==vista.comboBox_menuGeneracionJson) {
			if(vista.comboBox_menuGeneracionJson.getSelectedIndex()==0) {
				vista.panelCreacionesJson.setVisible(true);
				vista.panelCreacionColaboracionJson.setVisible(false);
				vista.panel_CreacionInforme.setVisible(false);
				vista.lbitemMenuJsonGeneracionSeleccionado.setText(vista.itemGeneracionJson.getText());
			}else {
				if(vista.comboBox_menuGeneracionJson.getSelectedIndex()==1) {
					vista.lbitemMenuJsonGeneracionSeleccionado.setText(vista.comboBox_menuGeneracionJson.getSelectedItem().toString());
					vista.panelCreacionesJson.setVisible(true);
					vista.panelNuevaColaboracion.setVisible(true);
					vista.panelCreacionColaboracionJson.setVisible(true);
					vista.panel_CreacionInforme.setVisible(false);
				}else if(vista.comboBox_menuGeneracionJson.getSelectedIndex()==2){
					vista.lbitemMenuJsonGeneracionSeleccionado.setText(vista.comboBox_menuGeneracionJson.getSelectedItem().toString());
					vista.panelCreacionesJson.setVisible(true);
					vista.panel_CreacionInforme.setVisible(true);
					vista.panelCreacionColaboracionJson.setVisible(true);
					vista.panelNuevaColaboracion.setVisible(false);
				}else if(vista.comboBox_menuGeneracionJson.getSelectedIndex()==3){
					vista.lbitemMenuJsonGeneracionSeleccionado.setText(vista.comboBox_menuGeneracionJson.getSelectedItem().toString());
					vista.panel_CreacionInforme.setVisible(false);
					vista.panelCreacionColaboracionJson.setVisible(false);
				}else {
					vista.panelCreacionesJson.setVisible(false);
					vista.lbitemMenuJsonGeneracionSeleccionado.setText(vista.comboBox_menuGeneracionJson.getSelectedItem().toString());
				}//else
			}//else
		}//COMBOBOX MENU GENERACION JSON
		
		if(e.getSource()==vista.btnCrearColaboracion) {
			if(!vista.textFieldFechaFinal.getText().isBlank() && !vista.textFieldFechaInicio.getText().isBlank() &&
				!vista.textFieldTematica.getText().isBlank() && !vista.textFieldTipo.getText().isBlank() && 
				(vista.rdbtnActivo.isSelected() || vista.rdbtnInactivo.isSelected())) {
				//
					if(vista.comboBoxCreador.getSelectedIndex()==vista.comboBoxColadoborador.getSelectedIndex()) {
						vista.lbmensajeRetroalimentacion.setForeground(Color.RED);
						vista.lbmensajeRetroalimentacion.setText("ERROR, MISMO COLABORADOR");
					}else {
						String creador=vista.comboBoxCreador.getSelectedItem().toString();
						Colaborador colaborador=new Colaborador();
						colaborador=crearColaborador(colaborador);
						ObjectNode colaboracion=funcionalidad.crearColaboracionJson(colaborador);
						try {
							int id=añadirColaboracion(creadores, colaboracion, creador, "files/creadores.json");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						List<MetricaContenido> metricas = null;
						try {
							metricas = funcionalidad.abrirCSV("files/metricas_contenido.csv");
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						añadirMetrica(metricas, colaborador); 
						vista.lbmensajeRetroalimentacion.setForeground(Color.BLUE);
						vista.lbmensajeRetroalimentacion.setText("COLABORACION CREADA");
					}//else
			}else {
				vista.lbmensajeRetroalimentacion.setForeground(Color.RED);
				vista.lbmensajeRetroalimentacion.setText("ERROR, COMPLETE TODOS LOS CAMPOS");
			}//else
		}//if
		
		//BOTON INFORME JSON
		if(e.getSource()==vista.btnGenerarInformeJson) {
			try {
				funcionalidad.generarInformeCreadoresJSON("files/creadores.json", "informesJSON/reporte_creadores.json");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			vista.lbl_MensajeInformacionUsuario.setText("INFORME JSON CREADO");
		}
		
	}//ACTION PERFORMED
	
	//METODO CARGAR COMBOBOX NOMBRE CREADORES CONTENIDO
	public void rellenarComboboxCreadoresContenido() throws JsonProcessingException, IOException {
			creadores = funcionalidad.obtenerListaCreadores("files/creadores.json");
			vista.combobox_CreadoresContenido.addItem("Elige un creador");
			
			for(JsonNode creador:creadores) {
				vista.combobox_CreadoresContenido.addItem(creador.get("id").asInt() + " - " +  creador.get("nombre").asText());
				vista.comboBoxCreador.addItem(creador.get("id").asInt() + " - " +  creador.get("nombre").asText());
				vista.comboBoxColadoborador.addItem(creador.get("id").asInt() + " - " +  creador.get("nombre").asText());
			}//for
			
		}//RELLENAR COMBOBOX CREADORES DE CONTENIDO
	
	public void mostrarInformacionCreador() throws Exception {
		
		for(JsonNode creador:creadores) {
			if((creador.get("id").asInt() + " - " +  creador.get("nombre").asText()).equalsIgnoreCase(vista.combobox_CreadoresContenido.getSelectedItem().toString())) {
				 idCreador = creador.get("id").asInt();
				//PLATAFORMA RENOVADA
				limpiarTabla(modeloPlataformas, vista.table_InformacionPlataforma);
				limpiarTabla(modeloHistorial, vista.table_HistorialPlataforma);
				//PANEL INFORMACION PERSONAL
				vista.panelInformacionPersonal.setVisible(true);
				vista.lbl_InformacionNombre.setText(creador.get("nombre").asText());
				vista.lbl_InformacionPais.setText(creador.get("pais").asText());
				vista.lbl_InformacionTematica.setText(creador.get("tematica").asText());
				vista.lbl_InformacionSeguidoresTotales.setText(String.valueOf(creador.get("seguidores_totales").asInt()));
				//PANEL INFORMACION ESTADISTICAS
				vista.panel_Estadisticas.setVisible(true);
				vista.textArea_InformacionEstadisticas.setText("Interacciones Totales: " + creador.get("estadisticas").get("interacciones_totales").asInt() + "\n" + "\n"
															  + "Vistas Mensuales: " + creador.get("estadisticas").get("promedio_vistas_mensuales").asInt() + "\n" + "\n"
															  + "Crecimiento de Seguidores: " + creador.get("estadisticas").get("tasa_crecimiento_seguidores").asDouble());
				//OPCIONES DE ÁMBITOS
				vista.lbl_ÁmbitosDisponibles.setVisible(true);
				vista.separator_3.setVisible(true);
				vista.combobox_Ámbitos.setVisible(true);
				vista.combobox_Ámbitos.setSelectedIndex(0);
				//MÉTRICAS
				mostrarMetricasCreador(idCreador);
				//COLABORACIONES
				colaboraciones = (ArrayNode) creador.get("colaboraciones");
				controlColaboraciones();
				//PLATAFORMAS
				plataformas = (ArrayNode) creador.get("plataformas");	
				
				//CALCULAR PROMEDIO VISTAS Y ME GUSTAS
				List<MetricaContenido> metricasDeContenido = funcionalidad.abrirCSV("files/metricas_contenido.csv");
				
				List<MetricaContenido> metricasCreador = new ArrayList<>();
				for(MetricaContenido metrica : metricasDeContenido) {
					if(metrica.getCreador_id() == idCreador) {
						metricasCreador.add(metrica);
					}//if
				}//for
				funcionalidad.calcularPromedioVistasYMeGustas(metricasCreador, vista.lbl_MeGustas_Instagram, vista.lbl_Vistas_Instagram, vista.lbl_MeGustas_TikTok, vista.lbl_Vistas_TikTok, vista.lbl_MeGustas_YT, vista.lbl_Vistas_YT, vista.lbl_MeGustas_Twitch, vista.lbl_Vistas_Twitch, vista.lbl_ContendioTikTok, vista.lbl_Contendio_YT, vista.lbl_Contendio_Twitch, vista.lbl_ContendioInstagram);
				//
			}//if
		}//for
		
	}//MOSTRAR INFORMACION CREADOR
	
	public void mostrarMetricasCreador(int idCreador) throws Exception {
		try {
			List<MetricaContenido> metricasDeContenido = funcionalidad.abrirCSV("files/metricas_contenido.csv");
			
			ArrayList<MetricaContenido> metricasCreador = new ArrayList<>();
			for(MetricaContenido metrica : metricasDeContenido) {
				if(metrica.getCreador_id() == idCreador) {
					metricasCreador.add(metrica);
				}//if
			}//for
			cargarMetricasTabla(metricasCreador, centrar);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}//MOSTRAR METRICAS CREADOR
	
	public void cargarMetricasTabla(List<MetricaContenido> metricas, DefaultTableCellRenderer centrar) {
		String [] nombresColumnas = {"Plataforma", "Fecha", "Contenido", "Tipo", "Vistas", "Me gusta", "Comentarios", "Compartidos"};
		
		DefaultTableModel modeloTabla = new DefaultTableModel(null, nombresColumnas);
		
		for(MetricaContenido metrica: metricas) {
			Object [] fila = {metrica.getPlataforma(), metrica.getFecha(), metrica.getContenido(), metrica.getTipo(), metrica.getVistas(), metrica.getMe_gusta(), metrica.getComentarios(), metrica.getCompartidos()};
			
			modeloTabla.addRow(fila);
		}
		
		vista.table_InformacionMetricas.setModel(modeloTabla);
		
		TableColumnModel modeloColumnas = vista.table_InformacionMetricas.getColumnModel();
		modeloColumnas.getColumn(0).setPreferredWidth(100);
		modeloColumnas.getColumn(1).setPreferredWidth(110);
		modeloColumnas.getColumn(2).setPreferredWidth(130);
		modeloColumnas.getColumn(3).setPreferredWidth(80);
		modeloColumnas.getColumn(4).setPreferredWidth(75);
		modeloColumnas.getColumn(5).setPreferredWidth(80);
		modeloColumnas.getColumn(6).setPreferredWidth(120);
		modeloColumnas.getColumn(7).setPreferredWidth(120);
		vista.table_InformacionMetricas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		centrar.setHorizontalAlignment(SwingConstants.CENTER);
		vista.table_InformacionMetricas.getColumnModel().getColumn(0).setCellRenderer(centrar);
		vista.table_InformacionMetricas.getColumnModel().getColumn(1).setCellRenderer(centrar);
		vista.table_InformacionMetricas.getColumnModel().getColumn(2).setCellRenderer(centrar);
		vista.table_InformacionMetricas.getColumnModel().getColumn(3).setCellRenderer(centrar);
		vista.table_InformacionMetricas.getColumnModel().getColumn(4).setCellRenderer(centrar);
		vista.table_InformacionMetricas.getColumnModel().getColumn(5).setCellRenderer(centrar);
		vista.table_InformacionMetricas.getColumnModel().getColumn(6).setCellRenderer(centrar);
		vista.table_InformacionMetricas.getColumnModel().getColumn(7).setCellRenderer(centrar);
		
	}//CARGAR METRICAS TABLA
	
	public void visualizarColaboraciones(ArrayNode colaboraciones) {
		//CARGAR EN LA LISTA EL NOMBRE DEL COLABORADOR DE LA COLABORACION
		limpiarModelo(modeloColaboraciones);
		
		for(JsonNode colaboracion: colaboraciones) {
			modeloColaboraciones.addElement(colaboracion.get("colaborador").asText());
		}
		vista.listColaboraciones.setModel(modeloColaboraciones);
		 
	}//visualizarColaboraciones
	
	public void limpiarModelo(DefaultListModel modelo) {
		modelo.removeAllElements();
	}//limpiarModelo
	
	public void centrarModelo() {
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) vista.listColaboraciones.getCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
	}//centrarModelo
	
	public void informacionColaboradores() {
		setearCampos();
		for(JsonNode colaboracion: colaboraciones) {
			if(colaboracion.get("colaborador").asText().equals(vista.listColaboraciones.getSelectedValue())) {
				vista.lbDatoColaborador.setText(colaboracion.get("colaborador").asText());
				vista.lbDatoTematica.setText(colaboracion.get("tematica").asText());
				vista.lbDatoFechaInicio.setText(colaboracion.get("fecha_inicio").asText());
				vista.lbDatoFechaFin.setText(colaboracion.get("fecha_fin").asText());
				vista.lbDatoTipo.setText(colaboracion.get("tipo").asText());
				vista.lbDatoEstado.setText(colaboracion.get("estado").asText());
			}//if
		}//for
	
	}//informacionColaboradores

	public void setearCampos() {
		vista.lbDatoTematica.setText("");
		vista.lbDatoFechaInicio.setText("");
		vista.lbDatoFechaFin.setText("");
		vista.lbDatoTipo.setText("");
		vista.lbDatoEstado.setText("");
		vista.lbDatoColaborador.setText("");
	}//setearCampos
	
	public void mostrarInformacionPlataformas(ArrayNode plataformas, String plataforma, DefaultTableModel modeloPlataformas, DefaultTableModel modeloHistorial) {
		//LIMPIAR TABLAS
		limpiarTabla(modeloPlataformas, vista.table_InformacionPlataforma);
		limpiarTabla(modeloHistorial, vista.table_HistorialPlataforma);
		String [] nombresColumnas = {"Nombre", "Usuario", "Seguidores", "Fecha creación"};
		modeloPlataformas.setColumnIdentifiers(nombresColumnas);
		vista.table_InformacionPlataforma.setModel(modeloPlataformas);
		//CREACION TABLA DE HISTORIAL PLATAFORMA
		String [] nombresColumna2 = {"Fecha", "Nuevos Seguidores", "Interacciones"};
		modeloHistorial.setColumnIdentifiers(nombresColumna2);
		vista.table_HistorialPlataforma.setModel(modeloHistorial);
		for(JsonNode red: plataformas) {
			if(red.get("nombre").asText().equalsIgnoreCase(plataforma)) {
				//FILA DE TABLA INFORMACION PLATAFORMA
				modeloPlataformas.addRow(new Object[] {red.get("nombre").asText(), red.get("usuario").asText(), red.get("seguidores").asText(), red.get("fecha_creacion").asText()});
				//FILA TABLA HISTORIAL PLATAFORMA
				ArrayNode historial=(ArrayNode)red.get("historico");
				for(JsonNode recorrer: historial) {
					modeloHistorial.addRow(new Object[] {recorrer.get("fecha").asText(), recorrer.get("nuevos_seguidores").asText(), recorrer.get("interacciones").asText()});
				}//for
			}//if
		}//for

		TableColumnModel modeloColumnasInformacion = vista.table_InformacionPlataforma.getColumnModel();
		modeloColumnasInformacion.getColumn(0).setPreferredWidth(95);
		modeloColumnasInformacion.getColumn(1).setPreferredWidth(145);
		modeloColumnasInformacion.getColumn(2).setPreferredWidth(77);
		modeloColumnasInformacion.getColumn(3).setPreferredWidth(110);
		
		TableColumnModel modeloColumnasHistorial = vista.table_HistorialPlataforma.getColumnModel();
		modeloColumnasHistorial.getColumn(0).setPreferredWidth(80);
		modeloColumnasHistorial.getColumn(1).setPreferredWidth(118);
		modeloColumnasHistorial.getColumn(2).setPreferredWidth(62);
		
		//centrartablas
		centrar.setHorizontalAlignment(SwingConstants.CENTER);
		vista.table_HistorialPlataforma.getColumnModel().getColumn(0).setCellRenderer(centrar);
		vista.table_HistorialPlataforma.getColumnModel().getColumn(1).setCellRenderer(centrar);
		vista.table_HistorialPlataforma.getColumnModel().getColumn(2).setCellRenderer(centrar);
		vista.table_InformacionPlataforma.getColumnModel().getColumn(0).setCellRenderer(centrar);
		vista.table_InformacionPlataforma.getColumnModel().getColumn(1).setCellRenderer(centrar);
		vista.table_InformacionPlataforma.getColumnModel().getColumn(2).setCellRenderer(centrar);
		vista.table_InformacionPlataforma.getColumnModel().getColumn(3).setCellRenderer(centrar);
	}//mostrarInformacionPlataformas
	
	public void limpiarTabla(DefaultTableModel modelo, JTable tabla) {
		while(tabla.getRowCount()>0) {
			modelo.removeRow(0);
		}
	}//limpiar
	
	public void controlColaboraciones() {
		centrarModelo();
		visualizarColaboraciones(colaboraciones);
		setearCampos();
	}//controlColaboraciones
	
	public Colaborador crearColaborador(Colaborador colaborador) {
		
		colaborador.setColaborador(vista.comboBoxColadoborador.getSelectedItem().toString());
		if(vista.rdbtnActivo.isSelected()) {
			colaborador.setEstado(vista.rdbtnActivo.getText());
		}else {
			colaborador.setEstado(vista.rdbtnInactivo.getText());
		}//else
		colaborador.setFechaFin(vista.textFieldFechaFinal.getText());
		colaborador.setFechaInicio(vista.textFieldFechaInicio.getText());
		colaborador.setTematica(vista.textFieldTematica.getText());
		colaborador.setTipo(vista.textFieldTipo.getText());
		//
		return colaborador;
	}//crearColaborador
	
	public int añadirColaboracion(ArrayNode creadores, ObjectNode objeto, String creadorColaboracion, String archivoJSON) throws IOException {
		int id=0;
		File archivo = new File(archivoJSON);
		objectMapper = new ObjectMapper();
		
		try {
			for(JsonNode creador:creadores) {
				if((creador.get("id").asInt() + " - " +  creador.get("nombre").asText()).equalsIgnoreCase(creadorColaboracion)) {
					ArrayNode historial=(ArrayNode) creador.get("colaboraciones");
					for(JsonNode colaborador:creadores) {
						if((colaborador.get("id").asInt() + " - " +  colaborador.get("nombre").asText()).equalsIgnoreCase(objeto.get("colaborador").asText())) {
							objeto.set("colaborador", colaborador.get("nombre"));
						}//if
					}//for
					historial.add(objeto);
					id=creador.get("id").asInt();
				}//if
			}//for
			
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(archivo, creadores);
		}catch(IOException e) {
			e.printStackTrace();
			throw e;
		}
		
		return id;
	}//añadirColaboracion
	
	public void añadirMetrica(List<MetricaContenido> metricas, Colaborador colaborador) {
		
		MetricaContenido nuevaMetrica=new MetricaContenido();
		for(MetricaContenido metrica: metricas) {
			nuevaMetrica.setCreador_id(idCreador);
			int plataforma=(int)(1+Math.random()*3);
			if(plataforma==1) {
				nuevaMetrica.setPlataforma("TikTok");
			}else if(plataforma==2) {
				nuevaMetrica.setPlataforma("Twitch");
			}else if(plataforma==3) {
				nuevaMetrica.setPlataforma("Instagram");
			}else {
				nuevaMetrica.setPlataforma("Youtube");
			}//else
			nuevaMetrica.setContenido(String.valueOf("Contenido " + (int) 1+ Math.random()*100));
			nuevaMetrica.setFecha(colaborador.getFechaInicio());
			int tipo=(int)(0+Math.random()*2);
			if(tipo==0) {
				nuevaMetrica.setTipo("Imagen");
			}else if(tipo==1) {
				nuevaMetrica.setTipo("Video");
			}//else
			nuevaMetrica.setComentarios((int)(1+ Math.random()*10.000));
			nuevaMetrica.setCompartidos((int)(1+ Math.random()*10.000));
			nuevaMetrica.setVistas((int)(1+ Math.random()*10.000));
			nuevaMetrica.setMe_gusta((int)(1+ Math.random()*10.000));
			//
		}//for
		metricas.add(nuevaMetrica);
	
	}//añadirMetrica
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource()==vista.listColaboraciones) {
			informacionColaboradores();
		}//if
		
	}//mouseClicked

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
}//CONTROLADOR