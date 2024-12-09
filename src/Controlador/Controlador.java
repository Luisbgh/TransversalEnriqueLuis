package Controlador;

import Vista.InterfazApp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
	private ArrayList<String>listaPlataformas=new ArrayList<String>();
	private ArrayNode creadores;
	private ArrayNode colaboraciones;
	private ArrayNode plataformas;
	private DefaultListModel modeloColaboraciones=new DefaultListModel();
	private DefaultListModel modeloAnalisis=new DefaultListModel();
	private DefaultListModel modeloRendimiento=new DefaultListModel();
	private DefaultTableCellRenderer centrar=new DefaultTableCellRenderer();
	private DefaultTableModel modeloPlataformas = new DefaultTableModel();
	private DefaultTableModel modeloHistorial = new DefaultTableModel();
	private DefaultTableModel tablaAnalisis=new DefaultTableModel();
	private int idCreador;
	private ObjectMapper objectMapper;
	
    public Controlador(InterfazApp frame) throws JsonProcessingException, IOException {
        this.vista=frame;
        //LISTENERS
        this.vista.itemDatos.addActionListener(this);
        this.vista.itemColaboracionesCsv.addActionListener(this);
        this.vista.combobox_CreadoresContenido.addActionListener(this);
        this.vista.combobox_Ámbitos.addActionListener(this);
        this.vista.combobox_CreadoresTasaCrecimiento.addActionListener(this);
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
        this.vista.itemAnalisis.addActionListener(this);
        this.vista.btnGenerarInformeJsonRendimiento.addActionListener(this);
        this.vista.itemConversionesJson.addActionListener(this);
        this.vista.btnConversionColaboracionesJson.addActionListener(this);
        this.vista.itemAnalisisCrecimiento.addActionListener(this);
        this.vista.itemPublicacionesCsv.addActionListener(this);
        this.vista.comboBoxCsv.addActionListener(this);
        this.vista.btnGenerarInteracciones.addActionListener(this);
        this.vista.btnCrearPublicacion.addActionListener(this);
        this.vista.comboBoxCreadorPublicacionCsv.addActionListener(this);
        //MOUSE LISTENERS
        this.vista.listColaboraciones.addMouseListener(this);
        this.vista.listPlataformas.addMouseListener(this);
        //RELLENO COMBOBOX
        rellenarComboboxCreadoresContenido();
        
    }//FIN CONSTRUCTOR CONTROLADOR

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==vista.itemDatos) {
			vista.panelBodyPagina.setVisible(false);
			vista.panelConversionesColaboracionesJson.setVisible(false);
			vista.panelPublicacionesCSV.setVisible(false);
			vista.panelInformacionCreadores.setVisible(true);
			vista.panelCreacionesJson.setVisible(false);
			vista.panelColaboracionesCsv.setVisible(false);
			vista.panelAnalisisRendimiento.setVisible(false);
			vista.lblItemSeleccionado.setText(vista.itemDatos.getText());
			vista.combobox_CreadoresContenido.setSelectedIndex(0);
			vista.lbRetroalimentacion.setText("");
			vista.panel_AnalisisSeguidoresCrecimiento.setVisible(false);
		}///ITEM DATOS
		if(e.getSource()==vista.combobox_CreadoresContenido) {
			if(vista.combobox_CreadoresContenido.getSelectedIndex()==0) {
				vista.panelInformacionPersonal.setVisible(false);
				vista.panelConversionesColaboracionesJson.setVisible(false);
				vista.panel_Estadisticas.setVisible(false);
				vista.lbl_ÁmbitosDisponibles.setVisible(false);
				vista.separator_3.setVisible(false);
				vista.combobox_Ámbitos.setVisible(false);
				vista.panelAmbito.setVisible(false);
				vista.panelAnalisisRendimiento.setVisible(false);
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
				vista.panelAnalisisRendimiento.setVisible(false);
				vista.panelConversionesColaboracionesJson.setVisible(false);
			}else {
				setearCampos();
				vista.panelConversionesColaboracionesJson.setVisible(false);
				if(vista.combobox_Ámbitos.getSelectedIndex()==1) {
					vista.panelAmbito.setVisible(true);
					vista.lbl_TituloÁmbitos.setText("PLATAFORMAS");
					vista.scrollPaneColaboraciones.setVisible(false);
					vista.lbTituloList.setVisible(false);
					vista.btnTwitch.setVisible(true);
					vista.panelAnalisisRendimiento.setVisible(false);
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
					vista.panelAnalisisRendimiento.setVisible(false);
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
					vista.panelAnalisisRendimiento.setVisible(false);
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
					vista.panelAnalisisRendimiento.setVisible(false);
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
					vista.panelAnalisisRendimiento.setVisible(false);
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
			vista.panelAnalisisRendimiento.setVisible(false);
			vista.panelConversionesColaboracionesJson.setVisible(false);
			vista.panelColaboracionesCsv.setVisible(true);
			vista.panelExportacionColaboracionesCsv.setVisible(true);
			vista.panelReporteColaboracionesCsv.setVisible(true);
			vista.panelPublicacionesCSV.setVisible(false);
			vista.panelCreacionesJson.setVisible(false);
			vista.lblItemSeleccionadoColaboracionesCsv.setText(vista.itemColaboracionesCsv.getText());
			vista.panel_AnalisisSeguidoresCrecimiento.setVisible(false);
		}///ITEM DATOS
		
		if(e.getSource()==vista.btn_ReportarColaboracionesCSV) {
			File archivo=new File("exportacionesCSV/reporteColaboraciones.csv");
			if(archivo.exists()) {
				vista.lbl_MensajeInfoUsuarioColaboracionesCSV.setText("EL FICHERO DE REPORTE YA EXISTE");
				vista.lbl_MensajeInfoUsuarioColaboracionesCSV.setForeground(Color.RED);
			}else {
				try {
					funcionalidad.generarReporteColaboraciones("files/creadores.json", "exportacionesCSV/reporteColaboraciones.csv");
				} catch (Exception e1) {
					e1.printStackTrace();
				}//catch
				vista.lbl_MensajeInfoUsuarioColaboracionesCSV.setText("REPORTE DE COLABORACIONES REALIZADO");
				vista.lbl_MensajeInfoUsuarioColaboracionesCSV.setForeground(new Color(46, 139, 87));
			}//else
		}//if
		
		if(e.getSource()==vista.btn_ExportacionesColaboradoresCsv) {
			File archivo=new File("exportacionesCSV/colaboraciones.csv");
			if(archivo.exists()) {
				vista.lbl_MensajeInfoUsuarioColaboracionesCSV.setText("EL FICHERO DE EXPORTACIÓN YA EXISTE");
				vista.lbl_MensajeInfoUsuarioColaboracionesCSV.setForeground(Color.RED);
			}else {
				try {
					funcionalidad.exportarColaboracionesCSV(creadores);
				} catch (Exception e1) {
					e1.printStackTrace();
				}//catch
				vista.lbl_MensajeInfoUsuarioColaboracionesCSV.setText("EXPORTACIÓN DE COLABORACIONES REALIZADO");
				vista.lbl_MensajeInfoUsuarioColaboracionesCSV.setForeground(new Color(46, 139, 87));
			}//else
		}//if
		
		if(e.getSource()==vista.itemGeneracionJson) {
			vista.panelBodyPagina.setVisible(false);
			vista.panelInformacionCreadores.setVisible(false);
			vista.panelColaboracionesCsv.setVisible(false);
			vista.panelAnalisisRendimiento.setVisible(false);
			vista.panelConversionesColaboracionesJson.setVisible(false);
			vista.panel_AnalisisSeguidoresCrecimiento.setVisible(false);
			vista.panelCreacionesJson.setVisible(true);
			vista.panelCreacionColaboracionJson.setVisible(true);
			vista.lbitemMenuJsonGeneracionSeleccionado.setText(vista.itemGeneracionJson.getText());
			vista.comboBox_menuGeneracionJson.setSelectedIndex(0);
		}//if
		
		if(e.getSource()==vista.comboBox_menuGeneracionJson) {
			setearCampos();
			if(vista.comboBox_menuGeneracionJson.getSelectedIndex()==0) {
				vista.panelCreacionesJson.setVisible(true);
				vista.panelAnalisisRendimiento.setVisible(false);
				vista.panelCreacionColaboracionJson.setVisible(false);
				vista.panel_CreacionInforme.setVisible(false);
				vista.panel_CreacionResumenDeRendimiento.setVisible(false);
				vista.lbl_MensajeInformacionUsuarioRendimiento.setText("");
				vista.lbl_MensajeInformacionUsuario.setText("");
				vista.lbRetroalimentacion.setText("");
				vista.panelConversionesColaboracionesJson.setVisible(false);
				vista.lbitemMenuJsonGeneracionSeleccionado.setText(vista.itemGeneracionJson.getText());
			}else {
				vista.lbl_MensajeInformacionUsuarioRendimiento.setText("");
				vista.lbl_MensajeInformacionUsuario.setText("");
				vista.lbRetroalimentacion.setText("");
				vista.panelConversionesColaboracionesJson.setVisible(false);
				if(vista.comboBox_menuGeneracionJson.getSelectedIndex()==1) {
					vista.lbitemMenuJsonGeneracionSeleccionado.setText(vista.comboBox_menuGeneracionJson.getSelectedItem().toString());
					vista.panelCreacionesJson.setVisible(true);
					vista.panelNuevaColaboracion.setVisible(true);
					vista.panelAnalisisRendimiento.setVisible(false);
					vista.panelCreacionColaboracionJson.setVisible(true);
					vista.panel_CreacionInforme.setVisible(false);
					vista.panel_CreacionResumenDeRendimiento.setVisible(false);
				}else if(vista.comboBox_menuGeneracionJson.getSelectedIndex()==2){
					vista.lbitemMenuJsonGeneracionSeleccionado.setText(vista.comboBox_menuGeneracionJson.getSelectedItem().toString());
					vista.panelCreacionesJson.setVisible(true);
					vista.panel_CreacionInforme.setVisible(true);
					vista.panelCreacionColaboracionJson.setVisible(true);
					vista.panelAnalisisRendimiento.setVisible(false);
					vista.panelNuevaColaboracion.setVisible(false);
					vista.panel_CreacionResumenDeRendimiento.setVisible(false);
				}else if(vista.comboBox_menuGeneracionJson.getSelectedIndex()==3){
					vista.lbitemMenuJsonGeneracionSeleccionado.setText(vista.comboBox_menuGeneracionJson.getSelectedItem().toString());
					vista.panelCreacionColaboracionJson.setVisible(true);
					vista.panel_CreacionInforme.setVisible(false);
					vista.panelNuevaColaboracion.setVisible(true);
					vista.panel_CreacionResumenDeRendimiento.setVisible(true);
				}
			}//else
		}//COMBOBOX MENU GENERACION JSON
		
		if(e.getSource()==vista.btnCrearColaboracion) {
			int id=0;
			if(!vista.textFieldFechaFinal.getText().isBlank() && !vista.textFieldFechaInicio.getText().isBlank() &&
				!vista.textFieldTematica.getText().isBlank() && !vista.textFieldTipo.getText().isBlank() && 
				(vista.rdbtnActivo.isSelected() || vista.rdbtnInactivo.isSelected())) {
					if(vista.comboBoxCreador.getSelectedIndex()==vista.comboBoxColadoborador.getSelectedIndex()) {
						vista.lbmensajeRetroalimentacion.setForeground(Color.RED);
						vista.lbmensajeRetroalimentacion.setText("ERROR, MISMO COLABORADOR");
					}else {
						String creador=vista.comboBoxCreador.getSelectedItem().toString();
						Colaborador colaborador=new Colaborador();
						colaborador=crearColaborador(colaborador);
						ObjectNode colaboracion=funcionalidad.crearColaboracionJson(colaborador);
						try {
							 id=añadirColaboracion(creadores, colaboracion, creador, "files/creadores.json");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						List<MetricaContenido> metricas = null;
						try {
							metricas = funcionalidad.abrirCSV("files/metricas_contenido.csv");
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						añadirMetrica(metricas, colaborador, id); 
						vista.lbmensajeRetroalimentacion.setForeground(new Color(46, 139, 87));
						vista.lbmensajeRetroalimentacion.setText("COLABORACIÓN CREADA");
					}//else
			}else {
				vista.lbmensajeRetroalimentacion.setForeground(Color.RED);
				vista.lbmensajeRetroalimentacion.setText("ERROR, COMPLETE TODOS LOS CAMPOS");
			}//else
		}//if
		
		//BOTON INFORME JSON
		if(e.getSource()==vista.btnGenerarInformeJson) {
			File archivo=new File("informesJSON/reporte_creadores.json");
			if(archivo.exists()) {
				vista.lbl_MensajeInformacionUsuario.setText("EL FICHERO YA EXISTE");
				vista.lbl_MensajeInformacionUsuario.setForeground(Color.RED);
			}else {
				try {
					funcionalidad.generarInformeCreadoresJSON("files/creadores.json");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				vista.lbl_MensajeInformacionUsuario.setForeground(new Color(46, 139, 87));
				vista.lbl_MensajeInformacionUsuario.setText("INFORME JSON CREADO");
			}//else
		}//if
		
		if(e.getSource()==vista.itemAnalisis) {
			vista.lblAnalisisDeRendimiento.setText(vista.menuAnalisisComparativo.getText());
			vista.panelCreacionColaboracionJson.setVisible(false);
			vista.panelExportacionColaboracionesCsv.setVisible(false);
			vista.panelInformacionCreadores.setVisible(false);
			vista.panelBodyPagina.setVisible(false);
			vista.panelAnalisisRendimiento.setVisible(true);
			vista.panelCreacionesJson.setVisible(false);
			vista.panelConversionesColaboracionesJson.setVisible(false);
			vista.lbRetroalimentacion.setText("");
			vista.panel_AnalisisSeguidoresCrecimiento.setVisible(false);
			vista.panelPublicacionesCSV.setVisible(false);
			//centrarLista
			DefaultListCellRenderer renderer = (DefaultListCellRenderer) vista.listPlataformas.getCellRenderer();
			renderer.setHorizontalAlignment(JLabel.CENTER);
			//RELLENAR LISTA
			rellenarListaPlataformas();
		}//if
		
		if(e.getSource()==vista.btnGenerarInformeJsonRendimiento) {
			File archivo = new File("informesJSON/resumen_rendimiento_creadores.json");
			
			if(archivo.exists()) {
				vista.lbl_MensajeInformacionUsuarioRendimiento.setText("EL FICHERO YA EXISTE");
				vista.lbl_MensajeInformacionUsuarioRendimiento.setForeground(Color.RED);
			}else {
				try {
					funcionalidad.calcularResumenRendimiento("files/creadores.json");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				vista.lbl_MensajeInformacionUsuarioRendimiento.setText("INFORME JSON DE RENDIMIENTO CREADO");
				vista.lbl_MensajeInformacionUsuarioRendimiento.setForeground(new Color(46, 139, 87));
			}//else
		}//if
		
		if(e.getSource()==vista.itemConversionesJson) {
			vista.lbitemMenuJsonGeneracionSeleccionado.setText(vista.itemConversionesJson.getText());
			vista.panelConversionesColaboracionesJson.setVisible(true);
			vista.panelCreacionesJson.setVisible(false);
			vista.panelBodyPagina.setVisible(false);
			vista.panelInformacionCreadores.setVisible(false);
			vista.panelCreacionesJson.setVisible(false);
			vista.panelColaboracionesCsv.setVisible(false);
			vista.panelAnalisisRendimiento.setVisible(false);
			vista.panel_AnalisisSeguidoresCrecimiento.setVisible(false);
			vista.panelPublicacionesCSV.setVisible(false);
		}//if
		
		if(e.getSource()==vista.btnConversionColaboracionesJson) {
			File archivo = new File("informesJSON/colaboraciones.json");
			
			if(archivo.exists()) {
				vista.lbRetroalimentacion.setText("EL FICHERO YA EXISTE");
				vista.lbRetroalimentacion.setForeground(Color.RED);
			}else {
				try {
					funcionalidad.convertirColaboraciones("files/creadores.json");
				} catch (IOException e1) {
					e1.printStackTrace();
				}//
				vista.lbRetroalimentacion.setText("COLABORACIONES CONVERTIDAS A JSON");
				vista.lbRetroalimentacion.setForeground(new Color(46, 139, 87));
			}//else
		}//if
		
		if(e.getSource()==vista.itemAnalisisCrecimiento) {
			vista.lbtituloTasaCrecimiento.setText(vista.itemAnalisisCrecimiento.getText());
			vista.panel_AnalisisSeguidoresCrecimiento.setVisible(true);
			vista.panelCreacionesJson.setVisible(false);
			vista.panelBodyPagina.setVisible(false);
			vista.panelInformacionCreadores.setVisible(false);
			vista.panelCreacionesJson.setVisible(false);
			vista.panelColaboracionesCsv.setVisible(false);
			vista.panelAnalisisRendimiento.setVisible(false);
			vista.panelConversionesColaboracionesJson.setVisible(false);
			vista.panelPublicacionesCSV.setVisible(false);
			vista.combobox_CreadoresTasaCrecimiento.setSelectedIndex(0);
		}
		
		if(e.getSource()==vista.combobox_CreadoresTasaCrecimiento) {
			if(vista.combobox_CreadoresTasaCrecimiento.getSelectedIndex() > 0) {
				String creadorSeleccionado = vista.combobox_CreadoresTasaCrecimiento.getSelectedItem().toString();
				idCreador = Integer.parseInt(creadorSeleccionado.split(" - ") [0]);
				try {
					funcionalidad.calcularYMostrarTasaCrecimiento("files/creadores.json", idCreador, vista.progressBarYT, vista.progressBarTK, vista.progressBarTW, vista.progressBarIG);
				} catch (IOException e1) {
					e1.printStackTrace();
				}//catch
			}else {
				vista.progressBarIG.setValue(0);
				vista.progressBarTW.setValue(0);
				vista.progressBarTK.setValue(0);
				vista.progressBarYT.setValue(0);
			}//else
		}//if
		
		if(e.getSource()==vista.itemPublicacionesCsv) {
			vista.panelPublicacionesCSV.setVisible(true);
			vista.panelConversionesColaboracionesJson.setVisible(false);
			vista.panelCreacionesJson.setVisible(false);
			vista.panelOpcionesCsv.setVisible(false);
			vista.panelBodyPagina.setVisible(false);
			vista.panelInformacionCreadores.setVisible(false);
			vista.panelCreacionesJson.setVisible(false);
			vista.panelColaboracionesCsv.setVisible(false);
			vista.panelAnalisisRendimiento.setVisible(false);
			vista.panel_AnalisisSeguidoresCrecimiento.setVisible(false);
			vista.panelPublicacionesCSV.setVisible(false);
			vista.lbitemSeleccionadoMenuCsv.setText(vista.itemPublicacionesCsv.getText());
			vista.comboBoxCsv.setSelectedIndex(0);
			setearCampos();
		}//if
		
		if(e.getSource()==vista.comboBoxCsv) {
			setearCampos();
			if(vista.comboBoxCsv.getSelectedIndex()==0) {
				vista.panelPublicacionesCSV.setVisible(true);
				vista.panelCreacionesJson.setVisible(false);
				vista.panelOpcionesCsv.setVisible(false);
				vista.panelAnalisisRendimiento.setVisible(false);
				vista.panelCreacionColaboracionJson.setVisible(false);
				vista.panelColaboracionesCsv.setVisible(false);
				vista.panelEditarCsv.setVisible(false);
				vista.panel_CreacionInforme.setVisible(false);
				vista.panel_CreacionResumenDeRendimiento.setVisible(false);
				vista.lbl_MensajeInformacionUsuarioRendimiento.setText("");
				vista.lbl_MensajeInformacionUsuario.setText("");
				vista.lbRetroalimentacion.setText("");
				vista.panelConversionesColaboracionesJson.setVisible(false);
				vista.panelNuevaPublicacionCsv.setVisible(false);
				vista.panelEliminarPublicacionCsv.setVisible(false);
				vista.lbitemSeleccionadoMenuCsv.setText(vista.itemPublicacionesCsv.getText());
				vista.comboBoxCsv.setSelectedIndex(0);
				vista.textFieldFechaPublicacion.setText("");
				vista.textFieldTipoPublicacion.setText("");
				vista.textField_ContenidoPublicacion.setText("");
				vista.textFieldVistas.setText("");
				vista.textFieldLikes.setText("");
				vista.textFieldComentarios.setText("");
				vista.textFieldCompartidos.setText("");
				vista.rdbtnPlataforma1.setSelected(false);
				vista.rdbtnPlataforma2.setSelected(false);
				vista.rdbtnPlataforma3.setSelected(false);
				vista.rdbtnPlataforma4.setSelected(false);
			}else {
				vista.panelPublicacionesCSV.setVisible(true);
				if(vista.comboBoxCsv.getSelectedIndex()==1) {
					vista.lbitemSeleccionadoMenuCsv.setText(vista.comboBoxCsv.getSelectedItem().toString());
					vista.panelCreacionesJson.setVisible(false);
					vista.panelNuevaColaboracion.setVisible(false);
					vista.panelOpcionesCsv.setVisible(true);
					vista.panelEditarCsv.setVisible(false);
					vista.panelPublicacionesCSV.setVisible(true);
					vista.panelAnalisisRendimiento.setVisible(false);
					vista.panelCreacionColaboracionJson.setVisible(false);
					vista.panelNuevaPublicacionCsv.setVisible(true);
					vista.panel_CreacionInforme.setVisible(false);
					vista.panel_CreacionResumenDeRendimiento.setVisible(false);
					vista.panelEliminarPublicacionCsv.setVisible(false);
					vista.textFieldFechaPublicacion.setText("");
					vista.textFieldTipoPublicacion.setText("");
					vista.textField_ContenidoPublicacion.setText("");
					vista.textFieldVistas.setText("");
					vista.textFieldLikes.setText("");
					vista.textFieldComentarios.setText("");
					vista.textFieldCompartidos.setText("");
					vista.rdbtnPlataforma1.setSelected(false);
					vista.rdbtnPlataforma2.setSelected(false);
					vista.rdbtnPlataforma3.setSelected(false);
					vista.rdbtnPlataforma4.setSelected(false);
				}else if(vista.comboBoxCsv.getSelectedIndex()==2){
					vista.lbitemSeleccionadoMenuCsv.setText(vista.comboBoxCsv.getSelectedItem().toString());
					vista.panelCreacionesJson.setVisible(false);
					vista.panelNuevaColaboracion.setVisible(false);
					vista.panelPublicacionesCSV.setVisible(true);
					vista.panelAnalisisRendimiento.setVisible(false);
					vista.panelOpcionesCsv.setVisible(true);
					vista.panelEditarCsv.setVisible(false);
					vista.panelCreacionColaboracionJson.setVisible(false);
					vista.panelNuevaPublicacionCsv.setVisible(false);
					vista.panel_CreacionInforme.setVisible(false);
					vista.panel_CreacionResumenDeRendimiento.setVisible(false);
					vista.panelEliminarPublicacionCsv.setVisible(true);
					vista.textFieldFechaPublicacion.setText("");
					vista.textFieldTipoPublicacion.setText("");
					vista.textField_ContenidoPublicacion.setText("");
					vista.textFieldVistas.setText("");
					vista.textFieldLikes.setText("");
					vista.textFieldComentarios.setText("");
					vista.textFieldCompartidos.setText("");
					vista.rdbtnPlataforma1.setSelected(false);
					vista.rdbtnPlataforma2.setSelected(false);
					vista.rdbtnPlataforma3.setSelected(false);
					vista.rdbtnPlataforma4.setSelected(false);
				}else if(vista.comboBoxCsv.getSelectedIndex()==3){
					vista.lbitemSeleccionadoMenuCsv.setText(vista.comboBoxCsv.getSelectedItem().toString());
					vista.panelNuevaPublicacionCsv.setVisible(false);
					vista.panelPublicacionesCSV.setVisible(true);
					vista.panelOpcionesCsv.setVisible(true);
					vista.panelEditarCsv.setVisible(true);
					vista.textFieldFechaPublicacion.setText("");
					vista.textFieldTipoPublicacion.setText("");
					vista.textField_ContenidoPublicacion.setText("");
					vista.textFieldVistas.setText("");
					vista.textFieldLikes.setText("");
					vista.textFieldComentarios.setText("");
					vista.textFieldCompartidos.setText("");
					vista.rdbtnPlataforma1.setSelected(false);
					vista.rdbtnPlataforma2.setSelected(false);
					vista.rdbtnPlataforma3.setSelected(false);
					vista.rdbtnPlataforma4.setSelected(false);
				}//else if
			}//else
		}//COMBOBOX MENU GENERACION JSON
		
		if(e.getSource()==vista.btnGenerarInteracciones) {
			vista.textFieldVistas.setText(String.valueOf((int)(5+Math.random()*100)*1000));
			vista.textFieldLikes.setText(String.valueOf((int)(5+Math.random()*100)*1000));
			vista.textFieldComentarios.setText(String.valueOf((int)(5+Math.random()*100)*1000));
			vista.textFieldCompartidos.setText(String.valueOf((int)(5+Math.random()*100)*1000));
		}
		
		if(e.getSource()==vista.btnCrearPublicacion) {
			try {
				agregarPublicacion();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}//ACTION PERFORMED
	
	//METODO CARGAR COMBOBOX NOMBRE CREADORES CONTENIDO
	public void rellenarComboboxCreadoresContenido() throws JsonProcessingException, IOException {
			creadores = funcionalidad.obtenerListaCreadores("files/creadores.json");
			vista.combobox_CreadoresContenido.addItem("Elige un creador");
			vista.combobox_CreadoresTasaCrecimiento.addItem("Elige un creador");
			
			for(JsonNode creador:creadores) {
				vista.combobox_CreadoresContenido.addItem(creador.get("id").asInt() + " - " +  creador.get("nombre").asText());
				vista.comboBoxCreador.addItem(creador.get("id").asInt() + " - " +  creador.get("nombre").asText());
				vista.comboBoxColadoborador.addItem(creador.get("id").asInt() + " - " +  creador.get("nombre").asText());
				vista.combobox_CreadoresTasaCrecimiento.addItem(creador.get("id").asInt() + " - " +  creador.get("nombre").asText());
				vista.comboBoxCreadorPublicacionCsv.addItem(creador.get("id").asInt() + " - " +  creador.get("nombre").asText());
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
		modeloColumnas.getColumn(0).setPreferredWidth(130);
		modeloColumnas.getColumn(1).setPreferredWidth(75);
		modeloColumnas.getColumn(2).setPreferredWidth(140);
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
		vista.textFieldFechaFinal.setText("");
		vista.textFieldFechaInicio.setText("");
		vista.textFieldTematica.setText("");
		vista.textFieldTipo.setText("");
		vista.rdbtnActivo.setSelected(false);
		vista.rdbtnInactivo.setSelected(false);
		vista.lbmensajeRetroalimentacion.setText("");
		vista.comboBoxCreador.setSelectedIndex(0);
		vista.comboBoxColadoborador.setSelectedIndex(0);
		vista.comboBoxCreadorPublicacionCsv.setSelectedIndex(0);
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
	
	public void añadirMetrica(List<MetricaContenido> metricas, Colaborador colaborador, int id) {
		
		MetricaContenido nuevaMetrica=new MetricaContenido();
		for(MetricaContenido metrica: metricas) {
			nuevaMetrica.setCreador_id(id);
			String[]opciones={"TikTok", "Instagram", "Youtube", "Twitch"};
				nuevaMetrica.setPlataforma(opciones[(int)(Math.random()*opciones.length)]);
			nuevaMetrica.setContenido("Contenido " + String.valueOf((int)(100+Math.random()*200)));
			nuevaMetrica.setFecha(colaborador.getFechaInicio());
			int tipo=(int)(0+Math.random()*2);
			if(tipo==0) {
				nuevaMetrica.setTipo("Imagen");
			}else if(tipo==1) {
				nuevaMetrica.setTipo("Video");
			}//else
			nuevaMetrica.setComentarios((int)(5000+ Math.random()*10000));
			nuevaMetrica.setCompartidos((int)(5000+ Math.random()*10000));
			nuevaMetrica.setVistas((int)(5000+ Math.random()*10000));
			nuevaMetrica.setMe_gusta((int)(5000+ Math.random()*10000));
			//
		}//for
		metricas.add(nuevaMetrica);
		funcionalidad.crearNuevoCSVMetricas(metricas, "files/metricas_contenido.csv");
	}//añadirMetrica
	
	//EJERCICIO 9
	public void rellenarListaPlataformas() {	
		for(JsonNode creador: creadores) {
			ArrayNode plataformas=(ArrayNode) creador.get("plataformas");
			for(JsonNode plataforma: plataformas) {
				modeloAnalisis.removeAllElements();
				if(!listaPlataformas.contains(plataforma.get("nombre").asText())) {
					listaPlataformas.add(plataforma.get("nombre").asText());
				}//if
				for(int i=0; i<listaPlataformas.size(); i++) {
					modeloAnalisis.addElement(listaPlataformas.get(i));
				}//for
				vista.listPlataformas.setModel(modeloAnalisis);
			}//for
		}//for
		
	}//rellenarListaPlataformas
	
	public void informacionPlataforma() throws Exception {
		String tipo=null;
		
		for(JsonNode creador: creadores) {
			ArrayNode plataformas=(ArrayNode) creador.get("plataformas");
			for(JsonNode plataforma: plataformas) {
				if(plataforma.get("nombre").asText().equals(vista.listPlataformas.getSelectedValue())) {
					vista.listRendimiento.setVisible(true);
					vista.separator_9.setVisible(true);
					vista.lblRendimiento.setVisible(true);
					switch(plataforma.get("nombre").asText()) {
					case "Instagram":
						tipo="Instagram";
						vista.lbPlataformaFoto.setIcon(InterfazApp.ajustarTamañoImg("img/instagram.jpeg", vista.lbPlataformaFoto.getWidth(), vista.lbPlataformaFoto.getHeight()));
						break;
					case "YouTube":
						tipo="YouTube";
						vista.lbPlataformaFoto.setIcon(InterfazApp.ajustarTamañoImg("img/youtube.png", vista.lbPlataformaFoto.getWidth(), vista.lbPlataformaFoto.getHeight()));
						break;
					case "TikTok":
						tipo="TikTok";
						vista.lbPlataformaFoto.setIcon(InterfazApp.ajustarTamañoImg("img/tiktok.png", vista.lbPlataformaFoto.getWidth(), vista.lbPlataformaFoto.getHeight()));
						break;
					case "Twitch":
						tipo="Twitch";
						vista.lbPlataformaFoto.setIcon(InterfazApp.ajustarTamañoImg("img/Twitch.jpg", vista.lbPlataformaFoto.getWidth(), vista.lbPlataformaFoto.getHeight()));
						break;
					}//swtich
					//
					modeloRendimiento.removeAllElements();
					compararRendimiento(tipo, "Imagen");
					compararRendimiento(tipo, "Video");
				}//if
			}//for
		}//for
	}//informacionPlataforma
	
	public void compararRendimiento(String plataforma, String contenido) throws Exception {
		int promedioVistas=0;
		int promedioLikes=0;
		int contador=0;
		List<MetricaContenido>lista=funcionalidad.abrirCSV("files/metricas_contenido.csv");
		
		for(MetricaContenido metrica: lista) {
			if(metrica.getPlataforma().equalsIgnoreCase(plataforma)) {
				if(metrica.getTipo().equalsIgnoreCase(contenido)) {
					promedioVistas=promedioVistas + metrica.getVistas();
					promedioLikes=promedioLikes + metrica.getMe_gusta();
					contador++;
				}//if
			}//if
		}//for
		//
		if(contador>0) {
			modeloRendimiento.addElement("Vistas: " + " - " + contenido + " - " + promedioVistas/contador);
			modeloRendimiento.addElement("Likes: " + " - " + contenido + " - " +  promedioLikes/contador);
		}//if
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) vista.listRendimiento.getCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		vista.listRendimiento.setModel(modeloRendimiento);
	}//comprarRendimiento
	//FIN EJERCICIO 9
	
	//EJERCICIO 11
	public void agregarPublicacion() throws IOException {
		String nombreCreador = vista.comboBoxCreadorPublicacionCsv.getSelectedItem().toString();
		
		idCreador = Integer.parseInt(nombreCreador.split( " - ")[0]);

		String contenido = vista.textField_ContenidoPublicacion.getText();
		String tipo = vista.textFieldTipoPublicacion.getText();
		String fecha = vista.textFieldFechaPublicacion.getText();
		String meGustas = vista.textFieldLikes.getText();
		String compartidos = vista.textFieldCompartidos.getText();
		String comentarios = vista.textFieldComentarios.getText();
		String vistas = vista.textFieldVistas.getText();
		
		boolean plataformaSeleccionada = vista.rdbtnPlataforma1.isSelected() || vista.rdbtnPlataforma2.isSelected() || vista.rdbtnPlataforma3.isSelected() || vista.rdbtnPlataforma4.isSelected();
		boolean camposRellenados = !contenido.isEmpty() && !tipo.isEmpty() && !fecha.isEmpty() && !meGustas.isEmpty() && !compartidos.isEmpty() && !comentarios.isEmpty() && !vistas.isEmpty();
		
		if(!plataformaSeleccionada && !camposRellenados) {
			vista.textArea.setText("SELECCIONA UNA PLATAFORMA Y RELLENA TODOS LOS CAMPOS");
			vista.textArea.setForeground(Color.RED);
		}else if (!plataformaSeleccionada) {
			vista.textArea.setText("SELECCIONA UNA PLATAFORMA");
			vista.textArea.setForeground(Color.RED);
		}else if (!camposRellenados) {
			vista.textArea.setText("RELLENA TODOS LOS CAMPOS");
			vista.textArea.setForeground(Color.RED);
		}else {
			MetricaContenido nuevaPublicacion = new MetricaContenido();
			nuevaPublicacion.setContenido(contenido);
			nuevaPublicacion.setTipo(tipo);
			nuevaPublicacion.setCreador_id(idCreador);
			nuevaPublicacion.setMe_gusta(Integer.parseInt(meGustas));
			nuevaPublicacion.setVistas(Integer.parseInt(vistas));
			nuevaPublicacion.setComentarios(Integer.parseInt(comentarios));
			nuevaPublicacion.setCompartidos(Integer.parseInt(compartidos));
			nuevaPublicacion.setPlataforma(obtenerPlataformaSeleccionada());
			
			List<MetricaContenido> publicaciones = new ArrayList<>();
			publicaciones.add(nuevaPublicacion);
			
			funcionalidad.agregarPublicacionACsv(nuevaPublicacion);
			
			vista.textArea.setText("PUBLICACIÓN AÑADIDA AL CSV");
			vista.textArea.setForeground(new Color(46, 139, 87));
		}
		
	}//FIN AGREGAR PUBLICACION
	
	public String obtenerPlataformaSeleccionada() {
		String plataformaSeleccionada = null;
		if(vista.rdbtnPlataforma1.isSelected()) {
			plataformaSeleccionada="TikTok";
		}else if (vista.rdbtnPlataforma2.isSelected()) {
			plataformaSeleccionada = "Youtube";
		}else if (vista.rdbtnPlataforma3.isSelected()) {
			plataformaSeleccionada = "Twitch";
		}else if (vista.rdbtnPlataforma4.isSelected()) {
			plataformaSeleccionada = "Instagram";
		}
		
		return plataformaSeleccionada;
	}//FIN OBTENER PLATAFORMA SELECCIONADA
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource()==vista.listColaboraciones) {
			informacionColaboradores();
		}//if
		
		if(e.getSource()==vista.listPlataformas) {
			 try {
				informacionPlataforma();
			} catch (Exception e1) {
				e1.printStackTrace();
			}//catch
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