package Vista;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import Controlador.Controlador;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.border.BevelBorder;
import java.awt.Label;
import java.awt.Choice;
import javax.swing.JSeparator;
import java.awt.Panel;
import javax.swing.JComboBox;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class InterfazApp extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JPanel panel_Cabecera;
	public JLabel lbl_TituloApp;
	public JMenuBar menuBar;
	public JMenu menuCreadores;
	public JMenuItem itemDatos;
	public JMenuItem itemAnalisisCrecimiento;
	public JMenu menuJson;
	public JMenuItem itemConversionesJson;
	public JMenuItem itemGeneracionJson;
	public JMenu menuCsv;
	public JMenuItem itemPublicacionesCsv;
	public JMenuItem itemColaboracionesCsv;
	public JMenu menuContenido;
	public JPanel panelBodyPagina;
	public JLabel lbl_FondoApp;
	public JLabel lbl_Logo;
	public JLabel lbl_textoInicial;
	public JComboBox combobox_CreadoresContenido;
	public JLabel lbFondoInformacionCreadores;
	public Panel panelInformacionCreadores;
	public JLabel lblItemSeleccionado;
	public JLabel lbl_TituloCreadoresDisponibles;
	public JSeparator separator;
	public JPanel panelInformacionPersonal;
	public JLabel lbl_SeguidoresTotales;
	public JLabel lbl_InformacionTematica;
	public JLabel lbl_NombreCreador;
	public JLabel lbl_Tematica;
	public JLabel lbl_InformacionPais;
	public JLabel lbl_InformacionSeguidoresTotales;
	public JLabel lbl_Pais;
	public JLabel lbl_InformacionNombre;
	public JLabel lbl_TituloInformacionPersonal;
	public JSeparator separator_1;
	public JPanel panel_Estadisticas;
	public JLabel lbl_TituloEstadisticas;
	public JSeparator separator_2;
	public JTextArea textArea_InformacionEstadisticas;
	public JLabel lbl_ÁmbitosDisponibles;
	public JSeparator separator_3;
	public JComboBox combobox_Ámbitos;
	public JPanel panelAmbito;
	public JButton btnTwitch;
	public JButton btnYt;
	public JButton btnInstagram;
	public JButton btnTiktok;
	public JLabel lbl_TituloÁmbitos;
	public JTable table_InformacionMetricas;
	public JScrollPane scrollPane_TablaInformacionMetricas;
	public JList listColaboraciones;
	public JLabel lbTituloList;
	public JScrollPane scrollPaneColaboraciones;
	public JPanel panelInformacionColaborador;
	public JLabel lbl_colaborador;
	public JLabel lblTematica;
	public JLabel lblEstado;
	public JLabel lblTipo;
	public JLabel lblFechaFin;
	public JLabel lblFechaInicio;
	public JLabel lbDatoColaborador;
	public JLabel lbDatoTematica;
	public JLabel lbDatoFechaInicio;
	public JLabel lbDatoFechaFin;
	public JLabel lbDatoTipo;
	public JLabel lbDatoEstado;
	public JPanel panel_InformacionPlataformas;
	public JTable table_InformacionPlataforma;
	public JLabel lbTituloHistoricoPlataforma;
	public JTable table_HistorialPlataforma;
	public JScrollPane scrollPaneHistoricoPlataformas;
	public JScrollPane scrollPaneInformacionPlataformas;
	public JLabel lbTituloInformacionPlataformas;
	public JPanel panel_RendimientoCreadores;
	public JLabel lbl_LogoYT;
	public JLabel lbl_LogoTikTok;
	public JLabel lbl_LogoTwitch;
	public JLabel lbl_LogoInstagram;
	public JLabel lbl_TituloMeGustas;
	public JLabel lbl_TituloVistas;
	public JLabel lbl_MeGustas_TikTok;
	public JLabel lbl_MeGustas_Twitch;
	public JLabel lbl_MeGustas_YT;
	public JLabel lbl_MeGustas_Instagram;
	public JLabel lbl_Vistas_TikTok;
	public JLabel lbl_Vistas_YT;
	public JLabel lbl_Vistas_Twitch;
	public JLabel lbl_Vistas_Instagram;
	public JLabel lbl_TituloContenido;
	public JLabel lbl_ContendioTikTok;
	public JLabel lbl_Contendio_YT;
	public JLabel lbl_Contendio_Twitch;
	public JLabel lbl_ContendioInstagram;
	public JPanel panelColaboracionesCsv;
	public JLabel lbfondoColaboracionesCsv;
	public JLabel lblItemSeleccionadoColaboracionesCsv;
	public Panel panelExportacionColaboracionesCsv;
	public Panel panelReporteColaboracionesCsv;
	public JLabel lbl_MensajeInfoUsuarioColaboracionesCSV;
	public JButton btn_ReportarColaboracionesCSV;
	public JButton btn_ExportacionesColaboradoresCsv;
	public Panel panelCreacionesJson;
	public JLabel lbfondoCrearColaboracionJson;
	public JComboBox comboBox_menuGeneracionJson;
	public JLabel lbTituloOpcionJsonCreacion;
	public JSeparator separator_4;
	public JPanel panelCreacionColaboracionJson;
	public JLabel lbitemMenuJsonGeneracionSeleccionado;
	public Panel panelNuevaColaboracion;
	public JComboBox comboBoxCreador;
	public JComboBox comboBoxColadoborador;
	public JLabel lbTituloNuevaColaboracion;
	public JLabel lblCreadorColaboracion;
	public JLabel lblColaboradorColaboracion;
	public JSeparator separator_5;
	public JSeparator separator_6;
	public JSeparator separator_7;
	public JLabel lblTematicaColaboracion;
	public JTextField textFieldTematica;
	public JLabel lblTipoColaboracion;
	public JTextField textFieldTipo;
	public JLabel lblEstadoColaboracion;
	public JLabel lblFechainicio;
	public JTextField textFieldFechaInicio;
	public JLabel lblFechaFinal;
	public JTextField textFieldFechaFinal;
	public JButton btnCrearColaboracion;
	public JLabel lbmensajeRetroalimentacion;
	public JRadioButton rdbtnActivo;
	public JRadioButton rdbtnInactivo;
	public ButtonGroup grupoBotones=new ButtonGroup();
	public JPanel panel_CreacionInforme;
	public JButton btnGenerarInformeJson;
	public JLabel lbl_TituloGenerarInforme;
	public JLabel lbl_MensajeInformacionUsuario;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazApp frame = new InterfazApp();
					Controlador vista = new Controlador(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1256, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ImageIcon icono = (ajustarTamañoImg("img/logoEmpresa.jpg", 64, 64));
		setIconImage(icono.getImage());
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		panelCreacionesJson = new Panel();
		panelCreacionesJson.setBounds(0, 92, 1240, 587);
		contentPane.add(panelCreacionesJson);
		panelCreacionesJson.setLayout(null);
		panelCreacionesJson.setVisible(false);
		
		lbitemMenuJsonGeneracionSeleccionado = new JLabel("");
		lbitemMenuJsonGeneracionSeleccionado.setForeground(new Color(0, 0, 128));
		lbitemMenuJsonGeneracionSeleccionado.setFont(new Font("Segoe Print", Font.BOLD, 35));
		lbitemMenuJsonGeneracionSeleccionado.setBounds(10, 513, 367, 63);
		panelCreacionesJson.add(lbitemMenuJsonGeneracionSeleccionado);
		
		panelCreacionColaboracionJson = new JPanel();
		panelCreacionColaboracionJson.setBounds(378, 47, 831, 505);
		panelCreacionesJson.add(panelCreacionColaboracionJson);
		panelCreacionColaboracionJson.setBorder(new LineBorder(new Color(255, 215, 0), 3));
		panelCreacionColaboracionJson.setLayout(null);
		
		panelNuevaColaboracion = new Panel();
		panelNuevaColaboracion.setBounds(10, 8, 811, 487);
		panelCreacionColaboracionJson.add(panelNuevaColaboracion);
		panelNuevaColaboracion.setLayout(null);
		
		comboBoxCreador = new JComboBox();
		comboBoxCreador.setBackground(new Color(255, 255, 255));
		comboBoxCreador.setForeground(new Color(0, 0, 0));
		comboBoxCreador.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		comboBoxCreador.setBounds(10, 98, 181, 43);
		panelNuevaColaboracion.add(comboBoxCreador);
		
		comboBoxColadoborador = new JComboBox();
		comboBoxColadoborador.setBackground(new Color(255, 255, 255));
		comboBoxColadoborador.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		comboBoxColadoborador.setBounds(620, 98, 181, 43);
		panelNuevaColaboracion.add(comboBoxColadoborador);
		
		lbTituloNuevaColaboracion = new JLabel("Nueva colaboración");
		lbTituloNuevaColaboracion.setForeground(new Color(0, 0, 128));
		lbTituloNuevaColaboracion.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lbTituloNuevaColaboracion.setBounds(293, 16, 251, 37);
		panelNuevaColaboracion.add(lbTituloNuevaColaboracion);
		
		lblCreadorColaboracion = new JLabel("Creador");
		lblCreadorColaboracion.setForeground(new Color(0, 0, 128));
		lblCreadorColaboracion.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblCreadorColaboracion.setBounds(60, 50, 88, 37);
		panelNuevaColaboracion.add(lblCreadorColaboracion);
		
		lblColaboradorColaboracion = new JLabel("Colaborador");
		lblColaboradorColaboracion.setForeground(new Color(0, 0, 128));
		lblColaboradorColaboracion.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblColaboradorColaboracion.setBounds(647, 50, 128, 37);
		panelNuevaColaboracion.add(lblColaboradorColaboracion);
		
		separator_5 = new JSeparator();
		separator_5.setForeground(new Color(255, 255, 255));
		separator_5.setBounds(620, 85, 167, 2);
		panelNuevaColaboracion.add(separator_5);
		
		separator_6 = new JSeparator();
		separator_6.setForeground(Color.WHITE);
		separator_6.setBounds(10, 85, 181, 2);
		panelNuevaColaboracion.add(separator_6);
		
		separator_7 = new JSeparator();
		separator_7.setForeground(Color.WHITE);
		separator_7.setBounds(264, 59, 313, 0);
		panelNuevaColaboracion.add(separator_7);
		
		lblTematicaColaboracion = new JLabel("Temática*");
		lblTematicaColaboracion.setForeground(new Color(0, 0, 128));
		lblTematicaColaboracion.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblTematicaColaboracion.setBounds(269, 104, 123, 37);
		panelNuevaColaboracion.add(lblTematicaColaboracion);
		
		textFieldTematica = new JTextField();
		textFieldTematica.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTematica.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		textFieldTematica.setBounds(402, 113, 142, 20);
		panelNuevaColaboracion.add(textFieldTematica);
		textFieldTematica.setColumns(10);
		
		lblTipoColaboracion = new JLabel("Tipo*");
		lblTipoColaboracion.setForeground(new Color(0, 0, 128));
		lblTipoColaboracion.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblTipoColaboracion.setBounds(270, 152, 122, 37);
		panelNuevaColaboracion.add(lblTipoColaboracion);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTipo.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(402, 164, 142, 20);
		panelNuevaColaboracion.add(textFieldTipo);
		
		lblEstadoColaboracion = new JLabel("Estado*");
		lblEstadoColaboracion.setForeground(new Color(0, 0, 128));
		lblEstadoColaboracion.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblEstadoColaboracion.setBounds(370, 296, 79, 37);
		panelNuevaColaboracion.add(lblEstadoColaboracion);
		
		lblFechainicio = new JLabel("Fecha inicio*");
		lblFechainicio.setForeground(new Color(0, 0, 128));
		lblFechainicio.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblFechainicio.setBounds(264, 200, 128, 37);
		panelNuevaColaboracion.add(lblFechainicio);
		
		textFieldFechaInicio = new JTextField();
		textFieldFechaInicio.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldFechaInicio.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		textFieldFechaInicio.setColumns(10);
		textFieldFechaInicio.setBounds(402, 208, 142, 20);
		panelNuevaColaboracion.add(textFieldFechaInicio);
		
		lblFechaFinal = new JLabel("Fecha final*");
		lblFechaFinal.setForeground(new Color(0, 0, 128));
		lblFechaFinal.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblFechaFinal.setBounds(264, 248, 122, 37);
		panelNuevaColaboracion.add(lblFechaFinal);
		
		textFieldFechaFinal = new JTextField();
		textFieldFechaFinal.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldFechaFinal.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		textFieldFechaFinal.setColumns(10);
		textFieldFechaFinal.setBounds(402, 256, 142, 20);
		panelNuevaColaboracion.add(textFieldFechaFinal);
		
		btnCrearColaboracion = new JButton("CREAR");
		btnCrearColaboracion.setForeground(new Color(255, 255, 255));
		btnCrearColaboracion.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnCrearColaboracion.setBackground(new Color(70, 130, 180));
		btnCrearColaboracion.setBounds(269, 364, 275, 63);
		panelNuevaColaboracion.add(btnCrearColaboracion);
		
		lbmensajeRetroalimentacion = new JLabel("");
		lbmensajeRetroalimentacion.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lbmensajeRetroalimentacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbmensajeRetroalimentacion.setBounds(218, 456, 387, 20);
		panelNuevaColaboracion.add(lbmensajeRetroalimentacion);
		
		rdbtnActivo = new JRadioButton("Nueva");
		rdbtnActivo.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		rdbtnActivo.setBounds(274, 324, 79, 23);
		panelNuevaColaboracion.add(rdbtnActivo);
		grupoBotones.add(rdbtnActivo);
		
		rdbtnInactivo = new JRadioButton("Finalizada");
		rdbtnInactivo.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		rdbtnInactivo.setBounds(447, 324, 97, 23);
		panelNuevaColaboracion.add(rdbtnInactivo);
		grupoBotones.add(rdbtnInactivo);
		
		panel_CreacionInforme = new JPanel();
		panel_CreacionInforme.setBounds(10, 8, 811, 486);
		panelCreacionColaboracionJson.add(panel_CreacionInforme);
		panel_CreacionInforme.setVisible(false);
		panel_CreacionInforme.setLayout(null);
		
		btnGenerarInformeJson = new JButton("GENERAR INFORME JSON");
		btnGenerarInformeJson.setForeground(Color.WHITE);
		btnGenerarInformeJson.setFont(new Font("Trebuchet MS", Font.BOLD, 36));
		btnGenerarInformeJson.setBackground(new Color(70, 130, 180));
		btnGenerarInformeJson.setBounds(160, 173, 514, 114);
		panel_CreacionInforme.add(btnGenerarInformeJson);
		
		lbl_TituloGenerarInforme = new JLabel("¡GENERA EL INFORME DE JSON DE LOS CREADORES!");
		lbl_TituloGenerarInforme.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lbl_TituloGenerarInforme.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TituloGenerarInforme.setBounds(53, 49, 723, 64);
		panel_CreacionInforme.add(lbl_TituloGenerarInforme);
		
		lbl_MensajeInformacionUsuario = new JLabel("");
		lbl_MensajeInformacionUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lbl_MensajeInformacionUsuario.setBounds(173, 329, 480, 87);
		panel_CreacionInforme.add(lbl_MensajeInformacionUsuario);
		panelCreacionColaboracionJson.setVisible(false);
		
		lbTituloOpcionJsonCreacion = new JLabel("Opciones de creación:");
		lbTituloOpcionJsonCreacion.setForeground(new Color(0, 0, 128));
		lbTituloOpcionJsonCreacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbTituloOpcionJsonCreacion.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lbTituloOpcionJsonCreacion.setBounds(10, 46, 326, 35);
		panelCreacionesJson.add(lbTituloOpcionJsonCreacion);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(new Color(255, 255, 255));
		separator_4.setBounds(43, 92, 259, 2);
		panelCreacionesJson.add(separator_4);
		
		comboBox_menuGeneracionJson = new JComboBox();
		comboBox_menuGeneracionJson.setFont(new Font("Trebuchet MS", Font.BOLD, 27));
		comboBox_menuGeneracionJson.setModel(new DefaultComboBoxModel(new String[] {"Selecciona una opción:", "Nueva colaboración", "Nuevo Informe", "Resumen redimiento"}));
		comboBox_menuGeneracionJson.setBounds(21, 105, 327, 47);
		panelCreacionesJson.add(comboBox_menuGeneracionJson);
		
		lbfondoCrearColaboracionJson = new JLabel("");
		lbfondoCrearColaboracionJson.setBounds(0, 0, 1240, 587);
		panelCreacionesJson.add(lbfondoCrearColaboracionJson);
		lbfondoCrearColaboracionJson.setIcon(ajustarTamañoImg("img/fondoInicioApp.jpg", lbfondoCrearColaboracionJson.getWidth(), lbfondoCrearColaboracionJson.getHeight()));
		
		panelColaboracionesCsv = new JPanel();
		panelColaboracionesCsv.setBounds(0, 92, 1240, 587);
		contentPane.add(panelColaboracionesCsv);
		panelColaboracionesCsv.setLayout(null);
		panelColaboracionesCsv.setVisible(false);
		
		lbl_MensajeInfoUsuarioColaboracionesCSV = new JLabel("");
		lbl_MensajeInfoUsuarioColaboracionesCSV.setForeground(new Color(37, 128, 28));
		lbl_MensajeInfoUsuarioColaboracionesCSV.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MensajeInfoUsuarioColaboracionesCSV.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lbl_MensajeInfoUsuarioColaboracionesCSV.setBounds(280, 11, 705, 76);
		panelColaboracionesCsv.add(lbl_MensajeInfoUsuarioColaboracionesCSV);
		
		panelReporteColaboracionesCsv = new Panel();
		panelReporteColaboracionesCsv.setBackground(new Color(0, 0, 128));
		panelReporteColaboracionesCsv.setBounds(261, 325, 764, 159);
		panelColaboracionesCsv.add(panelReporteColaboracionesCsv);
		panelReporteColaboracionesCsv.setLayout(null);
		
		btn_ReportarColaboracionesCSV = new JButton("REPORTAR COLABORACIONES");
		btn_ReportarColaboracionesCSV.setForeground(new Color(255, 255, 255));
		btn_ReportarColaboracionesCSV.setBackground(new Color(70, 130, 180));
		btn_ReportarColaboracionesCSV.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btn_ReportarColaboracionesCSV.setBounds(168, 56, 441, 61);
		btn_ReportarColaboracionesCSV.setBorder(new LineBorder(new Color(255, 215, 0), 3));
		panelReporteColaboracionesCsv.add(btn_ReportarColaboracionesCSV);
		
		panelExportacionColaboracionesCsv = new Panel();
		panelExportacionColaboracionesCsv.setBackground(new Color(0, 0, 128));
		panelExportacionColaboracionesCsv.setBounds(261, 104, 764, 159);
		panelColaboracionesCsv.add(panelExportacionColaboracionesCsv);
		panelExportacionColaboracionesCsv.setLayout(null);
		
		btn_ExportacionesColaboradoresCsv = new JButton("EXPORTAR COLABORACIONES");
		btn_ExportacionesColaboradoresCsv.setForeground(Color.WHITE);
		btn_ExportacionesColaboradoresCsv.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btn_ExportacionesColaboradoresCsv.setBorder(new LineBorder(new Color(255, 215, 0), 3));
		btn_ExportacionesColaboradoresCsv.setBackground(new Color(70, 130, 180));
		btn_ExportacionesColaboradoresCsv.setBounds(168, 56, 441, 61);
		panelExportacionColaboracionesCsv.add(btn_ExportacionesColaboradoresCsv);
		
		lblItemSeleccionadoColaboracionesCsv = new JLabel();
		lblItemSeleccionadoColaboracionesCsv.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemSeleccionadoColaboracionesCsv.setForeground(new Color(0, 0, 128));
		lblItemSeleccionadoColaboracionesCsv.setFont(new Font("Segoe Print", Font.BOLD, 60));
		lblItemSeleccionadoColaboracionesCsv.setBounds(10, 513, 497, 63);
		panelColaboracionesCsv.add(lblItemSeleccionadoColaboracionesCsv);
		
		lbfondoColaboracionesCsv = new JLabel("");
		lbfondoColaboracionesCsv.setBounds(0, 0, 1240, 587);
		panelColaboracionesCsv.add(lbfondoColaboracionesCsv);
		lbfondoColaboracionesCsv.setIcon(ajustarTamañoImg("img/fondoInicioApp.jpg", lbfondoColaboracionesCsv.getWidth(), lbfondoColaboracionesCsv.getHeight()));
		panelColaboracionesCsv.setBorder(null);
		panelColaboracionesCsv.setBorder(null);
		
		panelInformacionCreadores = new Panel();
		panelInformacionCreadores.setBounds(0, 92, 1240, 587);
		contentPane.add(panelInformacionCreadores);
		panelInformacionCreadores.setLayout(null);
		panelInformacionCreadores.setVisible(false);
		
		panel_Estadisticas = new JPanel();
		panel_Estadisticas.setBounds(706, 46, 524, 208);
		panel_Estadisticas.setBorder(new LineBorder(new Color(255, 215, 0), 2));
		panel_Estadisticas.setVisible(false);
		
		combobox_Ámbitos = new JComboBox();
		combobox_Ámbitos.setModel(new DefaultComboBoxModel(new String[] {"Elige un ámbito", "Plataformas", "Métricas", "Colaboraciones", "Rendimiento"}));
		combobox_Ámbitos.setMaximumRowCount(4);
		combobox_Ámbitos.setVisible(false);
		
		panelAmbito = new JPanel();
		panelAmbito.setBorder(new LineBorder(new Color(255, 215, 0), 2, true));
		panelAmbito.setVisible(false);
		panelAmbito.setBounds(349, 286, 881, 290);
		panelInformacionCreadores.add(panelAmbito);
		panelAmbito.setLayout(null);
		
		panel_InformacionPlataformas = new JPanel();
		panel_InformacionPlataformas.setBounds(13, 63, 858, 216);
		panel_InformacionPlataformas.setVisible(false);
		
		panel_RendimientoCreadores = new JPanel();
		panel_RendimientoCreadores.setBounds(13, 63, 858, 216);
		panelAmbito.add(panel_RendimientoCreadores);
		panel_RendimientoCreadores.setLayout(null);
		
		lbl_Contendio_YT = new JLabel("");
		lbl_Contendio_YT.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Contendio_YT.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl_Contendio_YT.setBounds(373, 167, 112, 31);
		panel_RendimientoCreadores.add(lbl_Contendio_YT);
		
		lbl_Contendio_Twitch = new JLabel("");
		lbl_Contendio_Twitch.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Contendio_Twitch.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl_Contendio_Twitch.setBounds(558, 167, 112, 31);
		panel_RendimientoCreadores.add(lbl_Contendio_Twitch);
		
		lbl_ContendioInstagram = new JLabel("");
		lbl_ContendioInstagram.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ContendioInstagram.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl_ContendioInstagram.setBounds(720, 167, 112, 31);
		panel_RendimientoCreadores.add(lbl_ContendioInstagram);
		
		lbl_ContendioTikTok = new JLabel("");
		lbl_ContendioTikTok.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ContendioTikTok.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl_ContendioTikTok.setBounds(188, 167, 112, 31);
		panel_RendimientoCreadores.add(lbl_ContendioTikTok);
		
		lbl_LogoYT = new JLabel("");
		lbl_LogoYT.setBounds(387, 0, 89, 76);
		lbl_LogoYT.setIcon(ajustarTamañoImg("img/youtube.png", lbl_LogoYT.getWidth(), lbl_LogoYT.getHeight()));
		panel_RendimientoCreadores.add(lbl_LogoYT);
		
		lbl_LogoTikTok = new JLabel("");
		lbl_LogoTikTok.setBounds(200, 0, 89, 76);
		lbl_LogoTikTok.setIcon(ajustarTamañoImg("img/tiktok.png", lbl_LogoTikTok.getWidth(), lbl_LogoTikTok.getHeight()));
		panel_RendimientoCreadores.add(lbl_LogoTikTok);
		
		lbl_LogoTwitch = new JLabel("");
		lbl_LogoTwitch.setBounds(568, 0, 89, 76);
		lbl_LogoTwitch.setIcon(ajustarTamañoImg("img/Twitch.jpg", lbl_LogoTwitch.getWidth(), lbl_LogoTwitch.getHeight()));
		panel_RendimientoCreadores.add(lbl_LogoTwitch);
		
		lbl_LogoInstagram = new JLabel("");
		lbl_LogoInstagram.setBounds(733, 0, 89, 76);
		panel_RendimientoCreadores.add(lbl_LogoInstagram);
		lbl_LogoInstagram.setIcon(ajustarTamañoImg("img/instagram.jpeg", lbl_LogoInstagram.getWidth(), lbl_LogoInstagram.getHeight()));
		
		lbl_TituloMeGustas = new JLabel("ME GUSTAS");
		lbl_TituloMeGustas.setForeground(new Color(0, 0, 128));
		lbl_TituloMeGustas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TituloMeGustas.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl_TituloMeGustas.setBounds(33, 93, 117, 40);
		panel_RendimientoCreadores.add(lbl_TituloMeGustas);
		
		lbl_TituloVistas = new JLabel("VISTAS");
		lbl_TituloVistas.setForeground(new Color(0, 0, 128));
		lbl_TituloVistas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TituloVistas.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl_TituloVistas.setBounds(18, 130, 104, 40);
		panel_RendimientoCreadores.add(lbl_TituloVistas);
		
		lbl_MeGustas_TikTok = new JLabel("");
		lbl_MeGustas_TikTok.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MeGustas_TikTok.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl_MeGustas_TikTok.setBounds(180, 93, 137, 33);
		panel_RendimientoCreadores.add(lbl_MeGustas_TikTok);
		
		lbl_MeGustas_Twitch = new JLabel("");
		lbl_MeGustas_Twitch.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MeGustas_Twitch.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl_MeGustas_Twitch.setBounds(550, 93, 129, 33);
		panel_RendimientoCreadores.add(lbl_MeGustas_Twitch);
		
		lbl_MeGustas_YT = new JLabel("");
		lbl_MeGustas_YT.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MeGustas_YT.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl_MeGustas_YT.setBounds(365, 93, 129, 33);
		panel_RendimientoCreadores.add(lbl_MeGustas_YT);
		
		lbl_MeGustas_Instagram = new JLabel("");
		lbl_MeGustas_Instagram.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MeGustas_Instagram.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl_MeGustas_Instagram.setBounds(712, 93, 129, 33);
		panel_RendimientoCreadores.add(lbl_MeGustas_Instagram);
		
		lbl_Vistas_TikTok = new JLabel("");
		lbl_Vistas_TikTok.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Vistas_TikTok.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl_Vistas_TikTok.setBounds(180, 130, 137, 33);
		panel_RendimientoCreadores.add(lbl_Vistas_TikTok);
		
		lbl_Vistas_YT = new JLabel("");
		lbl_Vistas_YT.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Vistas_YT.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl_Vistas_YT.setBounds(365, 130, 129, 33);
		panel_RendimientoCreadores.add(lbl_Vistas_YT);
		
		lbl_Vistas_Twitch = new JLabel("");
		lbl_Vistas_Twitch.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Vistas_Twitch.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl_Vistas_Twitch.setBounds(550, 130, 129, 33);
		panel_RendimientoCreadores.add(lbl_Vistas_Twitch);
		
		lbl_Vistas_Instagram = new JLabel("");
		lbl_Vistas_Instagram.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Vistas_Instagram.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl_Vistas_Instagram.setBounds(712, 130, 129, 33);
		panel_RendimientoCreadores.add(lbl_Vistas_Instagram);
		
		lbl_TituloContenido = new JLabel("CONTENIDO");
		lbl_TituloContenido.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TituloContenido.setForeground(new Color(0, 0, 128));
		lbl_TituloContenido.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl_TituloContenido.setBounds(18, 165, 149, 40);
		panel_RendimientoCreadores.add(lbl_TituloContenido);
		panelAmbito.add(panel_InformacionPlataformas);
		panel_InformacionPlataformas.setLayout(null);
		
		scrollPaneInformacionPlataformas = new JScrollPane();
		scrollPaneInformacionPlataformas.setBounds(0, 49, 464, 156);
		scrollPaneInformacionPlataformas.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 215, 0), new Color(255, 215, 0)));
		
		panel_InformacionPlataformas.add(scrollPaneInformacionPlataformas);
		
		table_InformacionPlataforma = new JTable();
		table_InformacionPlataforma.setEnabled(false);		
		table_InformacionPlataforma.setBorder(new LineBorder(new Color(255, 215, 0), 2));
		table_InformacionPlataforma.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		table_InformacionPlataforma.setRowHeight(60);
		table_InformacionPlataforma.setIntercellSpacing(new Dimension(20, 20));
		
		JTableHeader cabeceraInfoPlataforma = table_InformacionPlataforma.getTableHeader();
		cabeceraInfoPlataforma.setFont(new Font("Arial", Font.BOLD, 15));
		
		cabeceraInfoPlataforma.setBackground(Color.BLUE);
		cabeceraInfoPlataforma.setForeground(Color.WHITE);
		
		scrollPaneInformacionPlataformas.setViewportView(table_InformacionPlataforma);
		
		lbTituloHistoricoPlataforma = new JLabel("HISTÓRICO");
		lbTituloHistoricoPlataforma.setHorizontalAlignment(SwingConstants.CENTER);
		lbTituloHistoricoPlataforma.setForeground(new Color(0, 0, 128));
		lbTituloHistoricoPlataforma.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbTituloHistoricoPlataforma.setBounds(591, 11, 166, 27);
		panel_InformacionPlataformas.add(lbTituloHistoricoPlataforma);
		
		scrollPaneHistoricoPlataformas = new JScrollPane();
		scrollPaneHistoricoPlataformas.setBounds(474, 49, 384, 156);
		panel_InformacionPlataformas.add(scrollPaneHistoricoPlataformas);
		scrollPaneHistoricoPlataformas.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 215, 0), new Color(255, 215, 0)));
		
		table_HistorialPlataforma = new JTable();
		table_HistorialPlataforma.setEnabled(false);		
		table_HistorialPlataforma.setBorder(new LineBorder(new Color(255, 215, 0), 2));
		table_HistorialPlataforma.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		table_HistorialPlataforma.setRowHeight(60);
		table_HistorialPlataforma.setIntercellSpacing(new Dimension(20, 20));
		
		JTableHeader cabeceraHistoricoPlataforma = table_HistorialPlataforma.getTableHeader();
		cabeceraHistoricoPlataforma.setFont(new Font("Arial", Font.BOLD, 15));
		
		cabeceraHistoricoPlataforma.setBackground(Color.BLUE);
		cabeceraHistoricoPlataforma.setForeground(Color.WHITE);
		
		scrollPaneHistoricoPlataformas.setViewportView(table_HistorialPlataforma);
		
		lbTituloInformacionPlataformas = new JLabel("INFORMACIÓN");
		lbTituloInformacionPlataformas.setHorizontalAlignment(SwingConstants.CENTER);
		lbTituloInformacionPlataformas.setForeground(new Color(0, 0, 128));
		lbTituloInformacionPlataformas.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbTituloInformacionPlataformas.setBounds(148, 11, 166, 27);
		panel_InformacionPlataformas.add(lbTituloInformacionPlataformas);
		
		panelInformacionColaborador = new JPanel();
		panelInformacionColaborador.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		panelInformacionColaborador.setBackground(new Color(176, 196, 222));
		panelInformacionColaborador.setBounds(295, 64, 417, 203);
		panelAmbito.add(panelInformacionColaborador);
		panelInformacionColaborador.setLayout(null);
		panelInformacionColaborador.setVisible(false);
		
		lbDatoFechaInicio = new JLabel("");
		lbDatoFechaInicio.setForeground(new Color(0, 0, 128));
		lbDatoFechaInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lbDatoFechaInicio.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lbDatoFechaInicio.setBounds(176, 75, 180, 25);
		panelInformacionColaborador.add(lbDatoFechaInicio);
		
		lbDatoTematica = new JLabel("");
		lbDatoTematica.setForeground(new Color(0, 0, 128));
		lbDatoTematica.setHorizontalAlignment(SwingConstants.CENTER);
		lbDatoTematica.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lbDatoTematica.setBounds(176, 38, 180, 26);
		panelInformacionColaborador.add(lbDatoTematica);
		
		lbDatoFechaFin = new JLabel("");
		lbDatoFechaFin.setForeground(new Color(0, 0, 128));
		lbDatoFechaFin.setHorizontalAlignment(SwingConstants.CENTER);
		lbDatoFechaFin.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lbDatoFechaFin.setBounds(176, 110, 180, 25);
		panelInformacionColaborador.add(lbDatoFechaFin);
		
		lbDatoTipo = new JLabel("");
		lbDatoTipo.setForeground(new Color(0, 0, 128));
		lbDatoTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lbDatoTipo.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lbDatoTipo.setBounds(176, 140, 180, 24);
		panelInformacionColaborador.add(lbDatoTipo);
		
		lbDatoEstado = new JLabel("");
		lbDatoEstado.setForeground(new Color(0, 0, 128));
		lbDatoEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lbDatoEstado.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lbDatoEstado.setBounds(176, 172, 180, 25);
		panelInformacionColaborador.add(lbDatoEstado);
		
		lbDatoColaborador = new JLabel("");
		lbDatoColaborador.setForeground(new Color(0, 0, 128));
		lbDatoColaborador.setHorizontalAlignment(SwingConstants.CENTER);
		lbDatoColaborador.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lbDatoColaborador.setBounds(176, 0, 180, 27);
		panelInformacionColaborador.add(lbDatoColaborador);
		
		lbl_colaborador = new JLabel("COLABORADOR");
		lbl_colaborador.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl_colaborador.setBounds(21, 11, 140, 14);
		panelInformacionColaborador.add(lbl_colaborador);
		
		lblTematica = new JLabel("TEMÁTICA");
		lblTematica.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblTematica.setBounds(21, 40, 99, 24);
		panelInformacionColaborador.add(lblTematica);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblEstado.setBounds(21, 172, 80, 25);
		panelInformacionColaborador.add(lblEstado);
		
		lblTipo = new JLabel("TIPO");
		lblTipo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblTipo.setBounds(21, 140, 58, 24);
		panelInformacionColaborador.add(lblTipo);
		
		lblFechaFin = new JLabel("FECHA FIN");
		lblFechaFin.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblFechaFin.setBounds(21, 110, 111, 19);
		panelInformacionColaborador.add(lblFechaFin);
		
		lblFechaInicio = new JLabel("FECHA INICIO");
		lblFechaInicio.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblFechaInicio.setBounds(21, 75, 145, 24);
		panelInformacionColaborador.add(lblFechaInicio);
		
		scrollPaneColaboraciones = new JScrollPane();
		scrollPaneColaboraciones.setBounds(13, 64, 166, 203);
		panelAmbito.add(scrollPaneColaboraciones);
		
		listColaboraciones = new JList();
		scrollPaneColaboraciones.setViewportView(listColaboraciones);
		listColaboraciones.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		listColaboraciones.setVisibleRowCount(3);
		listColaboraciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listColaboraciones.setBackground(new Color(176, 196, 222));
		listColaboraciones.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)));
		
		lbTituloList = new JLabel("COLABORADORES");
		lbTituloList.setHorizontalAlignment(SwingConstants.CENTER);
		lbTituloList.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbTituloList.setBounds(13, 35, 166, 27);
		panelAmbito.add(lbTituloList);
		
		scrollPane_TablaInformacionMetricas = new JScrollPane();
		scrollPane_TablaInformacionMetricas.setBounds(13, 63, 858, 216);
		panelAmbito.add(scrollPane_TablaInformacionMetricas);
		
		table_InformacionMetricas = new JTable();
		table_InformacionMetricas.setBorder(new LineBorder(new Color(255, 215, 0), 2));
		table_InformacionMetricas.setEnabled(false);
		table_InformacionMetricas.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		table_InformacionMetricas.setRowHeight(60);
		table_InformacionMetricas.setIntercellSpacing(new Dimension(20, 20));
		
		JTableHeader cabecera = table_InformacionMetricas.getTableHeader();
		cabecera.setFont(new Font("Arial", Font.BOLD, 18));
		
		cabecera.setBackground(Color.BLUE);
		cabecera.setForeground(Color.WHITE);
		
		scrollPane_TablaInformacionMetricas.setViewportView(table_InformacionMetricas);
		
		lbl_TituloÁmbitos = new JLabel("");
		lbl_TituloÁmbitos.setForeground(new Color(0, 0, 128));
		lbl_TituloÁmbitos.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TituloÁmbitos.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lbl_TituloÁmbitos.setBounds(309, 12, 317, 40);
		panelAmbito.add(lbl_TituloÁmbitos);
		
		btnTwitch = new JButton("");
		btnTwitch.setBounds(3, 3, 71, 49);
		panelAmbito.add(btnTwitch);
		btnTwitch.setIcon(ajustarTamañoImg("img/Twitch.jpg", btnTwitch.getWidth(), btnTwitch.getHeight()));
		
		btnYt = new JButton("");
		btnYt.setBounds(73, 3, 71, 49);
		panelAmbito.add(btnYt);
		btnYt.setIcon(ajustarTamañoImg("img/youtube.png", btnYt.getWidth(), btnYt.getHeight()));
		
		btnInstagram = new JButton("");
		btnInstagram.setBounds(144, 3, 71, 49);
		panelAmbito.add(btnInstagram);
		btnInstagram.setIcon(ajustarTamañoImg("img/instagram.jpeg", btnInstagram.getWidth(), btnInstagram.getHeight()));
		
		btnTiktok = new JButton("");
		btnTiktok.setBounds(214, 3, 71, 49);
		panelAmbito.add(btnTiktok);
		btnTiktok.setIcon(ajustarTamañoImg("img/tiktok.png", btnTiktok.getWidth(), btnTiktok.getHeight()));
		
		combobox_Ámbitos.setFont(new Font("Trebuchet MS", Font.BOLD, 27));
		combobox_Ámbitos.setBounds(10, 311, 233, 47);
		panelInformacionCreadores.add(combobox_Ámbitos);
		
		lbl_ÁmbitosDisponibles = new JLabel("ÁMBITOS");
		lbl_ÁmbitosDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ÁmbitosDisponibles.setForeground(new Color(0, 0, 128));
		lbl_ÁmbitosDisponibles.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lbl_ÁmbitosDisponibles.setBounds(10, 244, 128, 41);
		panelInformacionCreadores.add(lbl_ÁmbitosDisponibles);
		lbl_ÁmbitosDisponibles.setVisible(false);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.WHITE);
		separator_3.setVisible(false);
		separator_3.setBounds(10, 286, 135, 8);
		panelInformacionCreadores.add(separator_3);
		panelInformacionCreadores.add(panel_Estadisticas);
		panel_Estadisticas.setLayout(null);
		
		lbl_TituloEstadisticas = new JLabel("Estadísticas");
		lbl_TituloEstadisticas.setBounds(188, 5, 140, 31);
		lbl_TituloEstadisticas.setForeground(new Color(0, 0, 128));
		lbl_TituloEstadisticas.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		panel_Estadisticas.add(lbl_TituloEstadisticas);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(new Color(255, 255, 255));
		separator_2.setBackground(new Color(0, 0, 0));
		separator_2.setBounds(56, 36, 404, 10);
		panel_Estadisticas.add(separator_2);
		
		textArea_InformacionEstadisticas = new JTextArea();
		textArea_InformacionEstadisticas.setEditable(false);
		textArea_InformacionEstadisticas.setWrapStyleWord(true);
		textArea_InformacionEstadisticas.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
		textArea_InformacionEstadisticas.setLineWrap(true);
		textArea_InformacionEstadisticas.setBounds(10, 56, 504, 152);
		textArea_InformacionEstadisticas.setOpaque(false);
		panel_Estadisticas.add(textArea_InformacionEstadisticas);
		
		panelInformacionPersonal = new JPanel();
		panelInformacionPersonal.setBackground(new Color(232, 232, 232));
		panelInformacionPersonal.setBorder(new LineBorder(new Color(255, 215, 0), 2, true));
		panelInformacionPersonal.setBounds(349, 46, 334, 208);
		panelInformacionCreadores.add(panelInformacionPersonal);
		panelInformacionPersonal.setLayout(null);
		panelInformacionPersonal.setVisible(false);
		
		lbl_SeguidoresTotales = new JLabel("SEGUIDORES");
		lbl_SeguidoresTotales.setBounds(10, 173, 114, 24);
		lbl_SeguidoresTotales.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		panelInformacionPersonal.add(lbl_SeguidoresTotales);
		
		lbl_InformacionTematica = new JLabel("");
		lbl_InformacionTematica.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InformacionTematica.setBounds(131, 97, 171, 30);
		lbl_InformacionTematica.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		panelInformacionPersonal.add(lbl_InformacionTematica);
		
		lbl_NombreCreador = new JLabel("NOMBRE");
		lbl_NombreCreador.setBounds(10, 62, 77, 24);
		lbl_NombreCreador.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NombreCreador.setForeground(new Color(64, 0, 64));
		lbl_NombreCreador.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbl_NombreCreador.setBackground(Color.WHITE);
		panelInformacionPersonal.add(lbl_NombreCreador);
		
		lbl_Tematica = new JLabel("TEMÁTICA");
		lbl_Tematica.setBounds(10, 97, 94, 30);
		lbl_Tematica.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Tematica.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		panelInformacionPersonal.add(lbl_Tematica);
		
		lbl_InformacionPais = new JLabel("");
		lbl_InformacionPais.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InformacionPais.setBounds(131, 132, 171, 30);
		lbl_InformacionPais.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		panelInformacionPersonal.add(lbl_InformacionPais);
		
		lbl_InformacionSeguidoresTotales = new JLabel("");
		lbl_InformacionSeguidoresTotales.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InformacionSeguidoresTotales.setBounds(134, 173, 168, 24);
		lbl_InformacionSeguidoresTotales.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		panelInformacionPersonal.add(lbl_InformacionSeguidoresTotales);
		
		lbl_Pais = new JLabel("PAÍS");
		lbl_Pais.setBounds(10, 132, 41, 30);
		lbl_Pais.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Pais.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		panelInformacionPersonal.add(lbl_Pais);
		
		lbl_InformacionNombre = new JLabel("");
		lbl_InformacionNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InformacionNombre.setBounds(131, 62, 171, 24);
		lbl_InformacionNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		panelInformacionPersonal.add(lbl_InformacionNombre);
		
		lbl_TituloInformacionPersonal = new JLabel("Información Personal");
		lbl_TituloInformacionPersonal.setForeground(new Color(0, 0, 128));
		lbl_TituloInformacionPersonal.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lbl_TituloInformacionPersonal.setBounds(31, 11, 271, 24);
		panelInformacionPersonal.add(lbl_TituloInformacionPersonal);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setForeground(new Color(255, 255, 255));
		separator_1.setBounds(22, 46, 296, 8);
		panelInformacionPersonal.add(separator_1);
		
		combobox_CreadoresContenido = new JComboBox();
		combobox_CreadoresContenido.setMaximumRowCount(3);
		combobox_CreadoresContenido.setFont(new Font("Trebuchet MS", Font.BOLD, 27));
		combobox_CreadoresContenido.setBounds(10, 85, 296, 47);
		panelInformacionCreadores.add(combobox_CreadoresContenido);
		
		lbl_TituloCreadoresDisponibles = new JLabel("CREADORES DISPONIBLES");
		lbl_TituloCreadoresDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TituloCreadoresDisponibles.setForeground(new Color(0, 0, 128));
		lbl_TituloCreadoresDisponibles.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lbl_TituloCreadoresDisponibles.setBounds(10, 24, 296, 47);
		panelInformacionCreadores.add(lbl_TituloCreadoresDisponibles);
		
		lblItemSeleccionado = new JLabel();
		lblItemSeleccionado.setForeground(new Color(0, 0, 128));
		lblItemSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemSeleccionado.setFont(new Font("Segoe Print", Font.BOLD, 60));
		lblItemSeleccionado.setBounds(10, 513, 222, 63);
		panelInformacionCreadores.add(lblItemSeleccionado);
		
		separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(10, 66, 296, 8);
		panelInformacionCreadores.add(separator);
		
		lbFondoInformacionCreadores = new JLabel("");
		lbFondoInformacionCreadores.setBounds(0, 0, 1240, 587);
		panelInformacionCreadores.add(lbFondoInformacionCreadores);
		
		lbFondoInformacionCreadores.setIcon(ajustarTamañoImg("img/fondoInicioApp.jpg", lbFondoInformacionCreadores.getWidth(), lbFondoInformacionCreadores.getHeight()));
		
		panelBodyPagina = new JPanel();
		panelBodyPagina.setBounds(0, 92, 1240, 587);
		contentPane.add(panelBodyPagina);
		panelBodyPagina.setLayout(null);
		
		lbl_textoInicial = new JLabel("¡Selecciona la opción que desees!");
		lbl_textoInicial.setFont(new Font("Trebuchet MS", Font.PLAIN, 55));
		lbl_textoInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_textoInicial.setBounds(186, 252, 889, 57);
		panelBodyPagina.add(lbl_textoInicial);
		
		lbl_FondoApp = new JLabel("");
		lbl_FondoApp.setBounds(0, 0, 1240, 587);
		panelBodyPagina.add(lbl_FondoApp);
		
		lbl_FondoApp.setIcon(ajustarTamañoImg("img/fondoInicioApp.jpg", lbl_FondoApp.getWidth(), lbl_FondoApp.getHeight()));
		
		panel_Cabecera = new JPanel();
		panel_Cabecera.setBorder(new LineBorder(new Color(255, 215, 0), 5));
		panel_Cabecera.setBackground(new Color(68, 68, 136));
		panel_Cabecera.setBounds(0, 0, 1240, 92);
		contentPane.add(panel_Cabecera);
		panel_Cabecera.setLayout(null);
		
		lbl_TituloApp = new JLabel("METRICMANIA");
		lbl_TituloApp.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TituloApp.setBounds(137, 11, 328, 70);
		lbl_TituloApp.setForeground(new Color(255, 255, 255));
		lbl_TituloApp.setFont(new Font("Haettenschweiler", Font.PLAIN, 72));
		panel_Cabecera.add(lbl_TituloApp);
		
		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		menuBar.setBounds(625, 5, 610, 40);
		panel_Cabecera.add(menuBar);
		
		menuCreadores = new JMenu("Creadores");
		menuCreadores.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		menuBar.add(menuCreadores);
		menuCreadores.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 215, 0), null, null, null));
		
		itemDatos = new JMenuItem("Datos");
		itemDatos.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		menuCreadores.add(itemDatos);
		
		itemAnalisisCrecimiento = new JMenuItem("Crecimiento");
		itemAnalisisCrecimiento.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		menuCreadores.add(itemAnalisisCrecimiento);
		
		menuJson = new JMenu("Json");
		menuJson.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		menuBar.add(menuJson);
		menuJson.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 215, 0), null, null, null));
		
		itemConversionesJson = new JMenuItem("Conversiones");
		itemConversionesJson.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		menuJson.add(itemConversionesJson);
		
		itemGeneracionJson = new JMenuItem("Generación");
		itemGeneracionJson.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		menuJson.add(itemGeneracionJson);
		
		menuCsv = new JMenu("Csv");
		menuCsv.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		menuBar.add(menuCsv);
		menuCsv.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 215, 0), null, null, null));
		
		itemPublicacionesCsv = new JMenuItem("Publicaciones");
		itemPublicacionesCsv.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		menuCsv.add(itemPublicacionesCsv);
		
		itemColaboracionesCsv = new JMenuItem("Colaboraciones");
		itemColaboracionesCsv.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		menuCsv.add(itemColaboracionesCsv);
		
		menuContenido = new JMenu("Análisis de contenido");
		menuContenido.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		menuBar.add(menuContenido);
		menuContenido.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 215, 0), null, null, null));
		
		lbl_Logo = new JLabel("");
		lbl_Logo.setBounds(10, 11, 111, 70);
		panel_Cabecera.add(lbl_Logo);
		lbl_Logo.setIcon(ajustarTamañoImg("img/logoEmpresa.jpg", lbl_Logo.getWidth(), lbl_Logo.getHeight()));
		
	}//InterfazApp CONSTRUCTOR
	
	private ImageIcon ajustarTamañoImg(String ruta, int ancho, int alto) {
        ImageIcon imagen = new ImageIcon((ruta));
        Image imagenOriginal = imagen.getImage();
        Image imagenAjustada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenAjustada);
	}//FIN AJUSTAR TAMAÑO IMG
}//InterfazApp CLASS