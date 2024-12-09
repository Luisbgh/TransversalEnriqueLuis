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
import javax.swing.JProgressBar;

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
	public JMenu menuAnalisisComparativo;
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
	public JSeparator separator_4;
	public JPanel panelCreacionColaboracionJson;
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
	public ButtonGroup grupoBotonesCsv=new ButtonGroup();
	public JPanel panel_CreacionInforme;
	public JButton btnGenerarInformeJson;
	public JLabel lbl_TituloGenerarInforme;
	public JLabel lbl_MensajeInformacionUsuario;
	public Panel panelAnalisisRendimiento;
	public JLabel lbfondoAnalisisRendimiento;
	public JLabel lblAnalisisDeRendimiento;
	public JMenuItem itemAnalisis;
	public JLabel lbTituloAnalisis;
	public JSeparator separator_8;
	public JLabel lbfotoPlataforma;
	public JPanel panelContenedor;
	public JList listPlataformas;
	public JList listRendimiento;
	public JLabel lbPlataformaFoto;
	public JLabel lblRendimiento;
	public JSeparator separator_9;
	public JPanel panel_CreacionResumenDeRendimiento;
	public JButton btnGenerarInformeJsonRendimiento;
	public JLabel lbl_TituloGenerarInformeRendimiento;
	public JLabel lbl_MensajeInformacionUsuarioRendimiento;
	public JPanel panelConversionesColaboracionesJson;
	public JButton btnConversionColaboracionesJson;
	public JLabel lbl_TituloGenerarColaboracionesJson;
	public JLabel lbitemMenuJsonGeneracionSeleccionado;
	public JLabel lbTituloOpcionJsonCreacion;
	public JLabel lbtituloConversionesColaboraciones;
	public JLabel lbfondoConversionesJson;
	public JLabel lbRetroalimentacion;
	public JPanel panel_AnalisisSeguidoresCrecimiento;
	public JLabel lbl_FondoAnalisisSeguidores;
	public JLabel lbtituloTasaCrecimiento;
	public JComboBox combobox_CreadoresTasaCrecimiento;
	public JLabel lbl_ImgYoutube;
	public JLabel lbl_ImgTwitch;
	public JLabel lbl_ImgTikTok;
	public JLabel lbl_ImgInstagram;
	public JLabel lbcrecimientoEF;
	public JLabel lbcrecimientoFM;
	public JProgressBar progressBarYT_EF;
	public JProgressBar progressBarYT_FM;
	public JProgressBar progressBarTW_EF;
	public JProgressBar progressBarTW_FM;
	public JProgressBar progressBarTK_EF;
	public JProgressBar progressBarTK_FM;
	public JProgressBar progressBarIG_EF;
	public JProgressBar progressBarIG_FM;
	public JPanel panelPublicacionesCSV;
	public JLabel lbfondoPublicacionesCSV;
	public JComboBox comboBoxCsv;
	public JLabel lbtituloMenuCsv;
	public JSeparator separator_10;
	public JLabel lbitemSeleccionadoMenuCsv;
	public JPanel panelOpcionesCsv;
	public Panel panelNuevaPublicacionCsv;
	public JComboBox comboBoxCreadorPublicacionCsv;
	public JLabel lbTituloNuevaPublicacion;
	public JLabel lblCreadorPublicación;
	public JSeparator separator_15;
	public JSeparator separator_16;
	public JLabel lblFechaPublicacion;
	public JTextField textFieldFechaPublicacion;
	public JLabel lblTipoPublicacion;
	public JTextField textFieldTipoPublicacion;
	public JButton btnCrearPublicacion;
	public JLabel lbmensajeRetroalimentacionCsv;
	public JLabel lbPlataforma;
	public JRadioButton rdbtnPlataforma2;
	public JRadioButton rdbtnPlataforma1;
	public JRadioButton rdbtnPlataforma3;
	public JRadioButton rdbtnPlataforma4;
	public JLabel lblContenido;
	public JTextField textField_ContenidoPublicacion;
	public JButton btnGenerarInteracciones;
	public JSeparator separator_11;
	public JLabel lbVistas;
	public JLabel lbLikes;
	public JLabel lblCompartidos;
	public JLabel lblComentarios;
	public JTextField textFieldVistas;
	public JTextField textFieldLikes;
	public JTextField textFieldCompartidos;
	public JTextField textFieldComentarios;
	public JTextArea textArea;
	public JPanel panelEliminarPublicacionCsv;
	public JLabel lblEliminarPublicacin;
	public JPanel panelEditarCsv;
	public JLabel lblNewLabel;
	
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
		
		panelPublicacionesCSV = new JPanel();
		panelPublicacionesCSV.setBounds(0, 92, 1240, 587);
		contentPane.add(panelPublicacionesCSV);
		panelPublicacionesCSV.setLayout(null);
		panelPublicacionesCSV.setVisible(false);
		
		comboBoxCsv = new JComboBox();
		comboBoxCsv.setFont(new Font("Trebuchet MS", Font.BOLD, 27));
		comboBoxCsv.setModel(new DefaultComboBoxModel(new String[] {"Selecciona una opcion:", "Añadir publicación", "Eliminar publicación", "Editar publicación"}));
		comboBoxCsv.setBounds(21, 105, 327, 47);
		panelPublicacionesCSV.add(comboBoxCsv);
		
		separator_10 = new JSeparator();
		separator_10.setForeground(new Color(255, 255, 255));
		separator_10.setBounds(21, 92, 312, 2);
		panelPublicacionesCSV.add(separator_10);
		
		panelOpcionesCsv = new JPanel();
		panelOpcionesCsv.setBorder(new LineBorder(new Color(255, 215, 0), 2, true));
		panelOpcionesCsv.setBounds(378, 47, 831, 505);
		panelPublicacionesCSV.add(panelOpcionesCsv);
		panelOpcionesCsv.setLayout(null);
		
		panelEliminarPublicacionCsv = new JPanel();
		panelEliminarPublicacionCsv.setLayout(null);
		panelEliminarPublicacionCsv.setBounds(10, 8, 811, 487);
		panelOpcionesCsv.add(panelEliminarPublicacionCsv);
		
		lblEliminarPublicacin = new JLabel("Eliminar publicación");
		lblEliminarPublicacin.setForeground(new Color(0, 0, 128));
		lblEliminarPublicacin.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lblEliminarPublicacin.setBounds(293, 16, 251, 37);
		panelEliminarPublicacionCsv.add(lblEliminarPublicacin);
		panelEliminarPublicacionCsv.setVisible(false);
		
		panelNuevaPublicacionCsv = new Panel();
		panelNuevaPublicacionCsv.setBounds(10, 8, 811, 487);
		panelNuevaPublicacionCsv.setLayout(null);
		panelOpcionesCsv.add(panelNuevaPublicacionCsv);
		panelNuevaPublicacionCsv.setVisible(false);
		
		comboBoxCreadorPublicacionCsv = new JComboBox();
		comboBoxCreadorPublicacionCsv.setForeground(Color.BLACK);
		comboBoxCreadorPublicacionCsv.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		comboBoxCreadorPublicacionCsv.setBackground(Color.WHITE);
		comboBoxCreadorPublicacionCsv.setBounds(10, 98, 181, 43);
		panelNuevaPublicacionCsv.add(comboBoxCreadorPublicacionCsv);
		
		lbTituloNuevaPublicacion = new JLabel("Nueva publicación");
		lbTituloNuevaPublicacion.setForeground(new Color(0, 0, 128));
		lbTituloNuevaPublicacion.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lbTituloNuevaPublicacion.setBounds(293, 16, 251, 37);
		panelNuevaPublicacionCsv.add(lbTituloNuevaPublicacion);
		
		rdbtnPlataforma2 = new JRadioButton("YouTube");
		rdbtnPlataforma2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		rdbtnPlataforma2.setBounds(380, 110, 95, 23);
		panelNuevaPublicacionCsv.add(rdbtnPlataforma2);
		grupoBotonesCsv.add(rdbtnPlataforma2);
		
		rdbtnPlataforma1 = new JRadioButton("Tiktok");
		rdbtnPlataforma1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		rdbtnPlataforma1.setBounds(490, 110, 95, 23);
		panelNuevaPublicacionCsv.add(rdbtnPlataforma1);
		grupoBotonesCsv.add(rdbtnPlataforma1);
		
		rdbtnPlataforma3 = new JRadioButton("Twitch");
		rdbtnPlataforma3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		rdbtnPlataforma3.setBounds(584, 110, 95, 23);
		panelNuevaPublicacionCsv.add(rdbtnPlataforma3);
		grupoBotonesCsv.add(rdbtnPlataforma3);
		
		rdbtnPlataforma4 = new JRadioButton("Instagram");
		rdbtnPlataforma4.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		rdbtnPlataforma4.setBounds(685, 110, 109, 23);
		panelNuevaPublicacionCsv.add(rdbtnPlataforma4);
		grupoBotonesCsv.add(rdbtnPlataforma4);
		
		
		lblCreadorPublicación = new JLabel("Creador");
		lblCreadorPublicación.setForeground(new Color(0, 0, 128));
		lblCreadorPublicación.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblCreadorPublicación.setBounds(60, 50, 88, 37);
		panelNuevaPublicacionCsv.add(lblCreadorPublicación);
		
		separator_15 = new JSeparator();
		separator_15.setForeground(Color.WHITE);
		separator_15.setBounds(10, 85, 181, 2);
		panelNuevaPublicacionCsv.add(separator_15);
		
		separator_16 = new JSeparator();
		separator_16.setForeground(Color.WHITE);
		separator_16.setBounds(264, 59, 313, 0);
		panelNuevaPublicacionCsv.add(separator_16);
		
		lblFechaPublicacion = new JLabel("Fecha*");
		lblFechaPublicacion.setForeground(new Color(0, 0, 128));
		lblFechaPublicacion.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblFechaPublicacion.setBounds(250, 196, 74, 37);
		panelNuevaPublicacionCsv.add(lblFechaPublicacion);
		
		textFieldFechaPublicacion = new JTextField();
		textFieldFechaPublicacion.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldFechaPublicacion.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		textFieldFechaPublicacion.setColumns(10);
		textFieldFechaPublicacion.setBounds(382, 205, 142, 20);
		panelNuevaPublicacionCsv.add(textFieldFechaPublicacion);
		
		lbPlataforma = new JLabel("Plataforma*");
		lbPlataforma.setForeground(new Color(0, 0, 128));
		lbPlataforma.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbPlataforma.setBounds(250, 102, 122, 37);
		panelNuevaPublicacionCsv.add(lbPlataforma);
		
		lblTipoPublicacion = new JLabel("Tipo*");
		lblTipoPublicacion.setForeground(new Color(0, 0, 128));
		lblTipoPublicacion.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblTipoPublicacion.setBounds(250, 150, 74, 37);
		panelNuevaPublicacionCsv.add(lblTipoPublicacion);
		
		textFieldTipoPublicacion = new JTextField();
		textFieldTipoPublicacion.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTipoPublicacion.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		textFieldTipoPublicacion.setColumns(10);
		textFieldTipoPublicacion.setBounds(382, 159, 142, 20);
		panelNuevaPublicacionCsv.add(textFieldTipoPublicacion);
		
		btnCrearPublicacion = new JButton("CREAR");
		btnCrearPublicacion.setForeground(Color.WHITE);
		btnCrearPublicacion.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnCrearPublicacion.setBackground(new Color(70, 130, 180));
		btnCrearPublicacion.setBounds(250, 413, 275, 63);
		btnCrearPublicacion.setBorder(new LineBorder(new Color(255, 215, 0), 3));
		panelNuevaPublicacionCsv.add(btnCrearPublicacion);
		
		lbmensajeRetroalimentacionCsv = new JLabel("");
		lbmensajeRetroalimentacionCsv.setHorizontalAlignment(SwingConstants.CENTER);
		lbmensajeRetroalimentacionCsv.setForeground(new Color(46, 139, 87));
		lbmensajeRetroalimentacionCsv.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lbmensajeRetroalimentacionCsv.setBounds(185, 438, 453, 38);
		panelNuevaPublicacionCsv.add(lbmensajeRetroalimentacionCsv);
		
		lblContenido = new JLabel("Contenido*");
		lblContenido.setForeground(new Color(0, 0, 128));
		lblContenido.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblContenido.setBounds(250, 244, 109, 37);
		panelNuevaPublicacionCsv.add(lblContenido);
		
		textField_ContenidoPublicacion = new JTextField();
		textField_ContenidoPublicacion.setHorizontalAlignment(SwingConstants.CENTER);
		textField_ContenidoPublicacion.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		textField_ContenidoPublicacion.setColumns(10);
		textField_ContenidoPublicacion.setBounds(380, 255, 142, 20);
		panelNuevaPublicacionCsv.add(textField_ContenidoPublicacion);
		
		btnGenerarInteracciones = new JButton("GENERAR INTERACCIONES");
		btnGenerarInteracciones.setForeground(Color.WHITE);
		btnGenerarInteracciones.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnGenerarInteracciones.setBackground(new Color(70, 130, 180));
		btnGenerarInteracciones.setBounds(560, 184, 234, 63);
		panelNuevaPublicacionCsv.add(btnGenerarInteracciones);
		
		separator_11 = new JSeparator();
		separator_11.setForeground(Color.WHITE);
		separator_11.setBounds(250, 292, 544, 2);
		panelNuevaPublicacionCsv.add(separator_11);
		
		lbVistas = new JLabel("Vistas");
		lbVistas.setForeground(new Color(0, 0, 128));
		lbVistas.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbVistas.setBounds(250, 302, 68, 37);
		panelNuevaPublicacionCsv.add(lbVistas);
		
		lbLikes = new JLabel("Likes");
		lbLikes.setForeground(new Color(0, 0, 128));
		lbLikes.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lbLikes.setBounds(250, 348, 68, 37);
		panelNuevaPublicacionCsv.add(lbLikes);
		
		lblCompartidos = new JLabel("Compartidos");
		lblCompartidos.setForeground(new Color(0, 0, 128));
		lblCompartidos.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblCompartidos.setBounds(454, 305, 131, 37);
		panelNuevaPublicacionCsv.add(lblCompartidos);
		
		lblComentarios = new JLabel("Comentarios");
		lblComentarios.setForeground(new Color(0, 0, 128));
		lblComentarios.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblComentarios.setBounds(454, 348, 131, 37);
		panelNuevaPublicacionCsv.add(lblComentarios);
		
		textFieldVistas = new JTextField();
		textFieldVistas.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldVistas.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		textFieldVistas.setColumns(10);
		textFieldVistas.setBounds(316, 307, 101, 20);
		panelNuevaPublicacionCsv.add(textFieldVistas);
		
		textFieldLikes = new JTextField();
		textFieldLikes.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLikes.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		textFieldLikes.setColumns(10);
		textFieldLikes.setBounds(316, 354, 101, 20);
		panelNuevaPublicacionCsv.add(textFieldLikes);
		
		textFieldCompartidos = new JTextField();
		textFieldCompartidos.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCompartidos.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		textFieldCompartidos.setColumns(10);
		textFieldCompartidos.setBounds(584, 309, 101, 20);
		panelNuevaPublicacionCsv.add(textFieldCompartidos);
		
		textFieldComentarios = new JTextField();
		textFieldComentarios.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldComentarios.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		textFieldComentarios.setColumns(10);
		textFieldComentarios.setBounds(584, 354, 101, 20);
		panelNuevaPublicacionCsv.add(textFieldComentarios);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		textArea.setLineWrap(true);
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setBounds(560, 413, 218, 63);
		panelNuevaPublicacionCsv.add(textArea);
		
		panelEditarCsv = new JPanel();
		panelEditarCsv.setLayout(null);
		panelEditarCsv.setBounds(0, 0, 811, 487);
		panelOpcionesCsv.add(panelEditarCsv);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 46, 14);
		panelEditarCsv.add(lblNewLabel);
		
		lbitemSeleccionadoMenuCsv = new JLabel("");
		lbitemSeleccionadoMenuCsv.setForeground(new Color(0, 0, 128));
		lbitemSeleccionadoMenuCsv.setFont(new Font("Segoe Print", Font.BOLD, 40));
		lbitemSeleccionadoMenuCsv.setBounds(10, 513, 497, 67);
		panelPublicacionesCSV.add(lbitemSeleccionadoMenuCsv);
		
		lbtituloMenuCsv = new JLabel("Opciones de creación");
		lbtituloMenuCsv.setHorizontalAlignment(SwingConstants.CENTER);
		lbtituloMenuCsv.setForeground(new Color(0, 0, 128));
		lbtituloMenuCsv.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lbtituloMenuCsv.setBounds(22, 46, 326, 35);
		panelPublicacionesCSV.add(lbtituloMenuCsv);
		
		lbfondoPublicacionesCSV = new JLabel("New label");
		lbfondoPublicacionesCSV.setBounds(0, 0, 1240, 587);
		panelPublicacionesCSV.add(lbfondoPublicacionesCSV);
		lbfondoPublicacionesCSV.setIcon(ajustarTamañoImg("img/fondoInicioApp.jpg", lbfondoPublicacionesCSV.getWidth(), lbfondoPublicacionesCSV.getHeight()));
		
		panel_AnalisisSeguidoresCrecimiento = new JPanel();
		panel_AnalisisSeguidoresCrecimiento.setBounds(0, 92, 1240, 587);
		contentPane.add(panel_AnalisisSeguidoresCrecimiento);
		panel_AnalisisSeguidoresCrecimiento.setLayout(null);
		panel_AnalisisSeguidoresCrecimiento.setVisible(false);
		
		progressBarIG_EF = new JProgressBar();
		progressBarIG_EF.setStringPainted(true);
		progressBarIG_EF.setBounds(731, 465, 146, 27);
		panel_AnalisisSeguidoresCrecimiento.add(progressBarIG_EF);
		
		progressBarIG_FM = new JProgressBar();
		progressBarIG_FM.setStringPainted(true);
		progressBarIG_FM.setBounds(1009, 465, 146, 27);
		panel_AnalisisSeguidoresCrecimiento.add(progressBarIG_FM);
		
		progressBarTK_FM = new JProgressBar();
		progressBarTK_FM.setStringPainted(true);
		progressBarTK_FM.setBounds(1009, 358, 146, 27);
		panel_AnalisisSeguidoresCrecimiento.add(progressBarTK_FM);
		
		progressBarTK_EF = new JProgressBar();
		progressBarTK_EF.setStringPainted(true);
		progressBarTK_EF.setBounds(731, 358, 146, 27);
		panel_AnalisisSeguidoresCrecimiento.add(progressBarTK_EF);
		
		progressBarTW_FM = new JProgressBar();
		progressBarTW_FM.setStringPainted(true);
		progressBarTW_FM.setBounds(1009, 250, 146, 27);
		panel_AnalisisSeguidoresCrecimiento.add(progressBarTW_FM);
		
		progressBarTW_EF = new JProgressBar();
		progressBarTW_EF.setStringPainted(true);
		progressBarTW_EF.setBounds(731, 250, 146, 27);
		panel_AnalisisSeguidoresCrecimiento.add(progressBarTW_EF);
		
		progressBarYT_FM = new JProgressBar();
		progressBarYT_FM.setStringPainted(true);
		progressBarYT_FM.setBounds(1009, 115, 146, 27);
		panel_AnalisisSeguidoresCrecimiento.add(progressBarYT_FM);
		
		progressBarYT_EF = new JProgressBar();
		progressBarYT_EF.setMaximum(100);
		progressBarYT_EF.setStringPainted(true);
		progressBarYT_EF.setBounds(731, 115, 146, 27);
		panel_AnalisisSeguidoresCrecimiento.add(progressBarYT_EF);
		
		lbcrecimientoFM = new JLabel("FEBRERO-MARZO");
		lbcrecimientoFM.setHorizontalAlignment(SwingConstants.CENTER);
		lbcrecimientoFM.setForeground(new Color(0, 0, 0));
		lbcrecimientoFM.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lbcrecimientoFM.setBounds(964, 35, 218, 21);
		panel_AnalisisSeguidoresCrecimiento.add(lbcrecimientoFM);
		
		lbcrecimientoEF = new JLabel("ENERO-FEBRERO");
		lbcrecimientoEF.setHorizontalAlignment(SwingConstants.CENTER);
		lbcrecimientoEF.setForeground(new Color(0, 0, 0));
		lbcrecimientoEF.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lbcrecimientoEF.setBounds(698, 35, 218, 21);
		panel_AnalisisSeguidoresCrecimiento.add(lbcrecimientoEF);
		
		JLabel lbtextoCrecimiento = new JLabel("CRECIMIENTO");
		lbtextoCrecimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lbtextoCrecimiento.setForeground(new Color(0, 0, 0));
		lbtextoCrecimiento.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lbtextoCrecimiento.setBounds(490, 35, 168, 21);
		panel_AnalisisSeguidoresCrecimiento.add(lbtextoCrecimiento);
		
		lbl_ImgInstagram = new JLabel("");
		lbl_ImgInstagram.setBounds(531, 440, 89, 76);
		panel_AnalisisSeguidoresCrecimiento.add(lbl_ImgInstagram);
		lbl_ImgInstagram.setIcon((ajustarTamañoImg("img/instagram.jpeg", lbl_ImgInstagram.getWidth(), lbl_ImgInstagram.getHeight())));
		
		lbl_ImgTikTok = new JLabel("");
		lbl_ImgTikTok.setBounds(531, 328, 89, 76);
		panel_AnalisisSeguidoresCrecimiento.add(lbl_ImgTikTok);
		lbl_ImgTikTok.setIcon((ajustarTamañoImg("img/tiktok.png", lbl_ImgTikTok.getWidth(), lbl_ImgTikTok.getHeight())));
		
		lbl_ImgTwitch = new JLabel("");
		lbl_ImgTwitch.setBounds(531, 218, 89, 76);
		panel_AnalisisSeguidoresCrecimiento.add(lbl_ImgTwitch);
		lbl_ImgTwitch.setIcon((ajustarTamañoImg("img/Twitch.jpg", lbl_ImgTwitch.getWidth(), lbl_ImgTwitch.getHeight())));
		
		lbl_ImgYoutube = new JLabel("");
		lbl_ImgYoutube.setBounds(529, 87, 89, 76);
		panel_AnalisisSeguidoresCrecimiento.add(lbl_ImgYoutube);
		lbl_ImgYoutube.setIcon((ajustarTamañoImg("img/youtube.png", lbl_ImgYoutube.getWidth(), lbl_ImgYoutube.getHeight())));
		
		lbtituloTasaCrecimiento = new JLabel("");
		lbtituloTasaCrecimiento.setForeground(new Color(0, 0, 128));
		lbtituloTasaCrecimiento.setFont(new Font("Segoe Print", Font.BOLD, 40));
		lbtituloTasaCrecimiento.setBounds(10, 513, 323, 63);
		panel_AnalisisSeguidoresCrecimiento.add(lbtituloTasaCrecimiento);
		
		combobox_CreadoresTasaCrecimiento = new JComboBox();
		combobox_CreadoresTasaCrecimiento.setMaximumRowCount(3);
		combobox_CreadoresTasaCrecimiento.setFont(new Font("Trebuchet MS", Font.BOLD, 27));
		combobox_CreadoresTasaCrecimiento.setBounds(115, 85, 296, 47);
		panel_AnalisisSeguidoresCrecimiento.add(combobox_CreadoresTasaCrecimiento);
		
		lbl_FondoAnalisisSeguidores = new JLabel("");
		lbl_FondoAnalisisSeguidores.setBounds(-10, 0, 1240, 587);
		panel_AnalisisSeguidoresCrecimiento.add(lbl_FondoAnalisisSeguidores);
		lbl_FondoAnalisisSeguidores.setIcon(ajustarTamañoImg("img/fondoInicioApp.jpg", lbl_FondoAnalisisSeguidores.getWidth(), lbl_FondoAnalisisSeguidores.getHeight()));
		
		panelCreacionesJson = new Panel();
		panelCreacionesJson.setBounds(0, 92, 1240, 587);
		contentPane.add(panelCreacionesJson);
		panelCreacionesJson.setLayout(null);
		panelCreacionesJson.setVisible(false);
		
		lbitemMenuJsonGeneracionSeleccionado = new JLabel();
		lbitemMenuJsonGeneracionSeleccionado.setBounds(10, 513, 497, 63);
		panelCreacionesJson.add(lbitemMenuJsonGeneracionSeleccionado);
		lbitemMenuJsonGeneracionSeleccionado.setHorizontalAlignment(SwingConstants.LEFT);
		lbitemMenuJsonGeneracionSeleccionado.setForeground(new Color(0, 0, 128));
		lbitemMenuJsonGeneracionSeleccionado.setFont(new Font("Segoe Print", Font.BOLD, 30));
		
		lbTituloOpcionJsonCreacion = new JLabel("Opciones de creación:");
		lbTituloOpcionJsonCreacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbTituloOpcionJsonCreacion.setForeground(new Color(0, 0, 128));
		lbTituloOpcionJsonCreacion.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lbTituloOpcionJsonCreacion.setBounds(22, 46, 326, 35);
		panelCreacionesJson.add(lbTituloOpcionJsonCreacion);
		
		panelCreacionColaboracionJson = new JPanel();
		panelCreacionColaboracionJson.setBounds(378, 47, 831, 505);
		panelCreacionesJson.add(panelCreacionColaboracionJson);
		panelCreacionColaboracionJson.setBorder(new LineBorder(new Color(255, 215, 0), 3));
		panelCreacionColaboracionJson.setLayout(null);
		
		panel_CreacionResumenDeRendimiento = new JPanel();
		panel_CreacionResumenDeRendimiento.setBounds(10, 8, 811, 487);
		panelCreacionColaboracionJson.add(panel_CreacionResumenDeRendimiento);
		panel_CreacionResumenDeRendimiento.setLayout(null);
		
		btnGenerarInformeJsonRendimiento = new JButton("GENERAR INFORME JSON");
		btnGenerarInformeJsonRendimiento.setForeground(Color.WHITE);
		btnGenerarInformeJsonRendimiento.setFont(new Font("Trebuchet MS", Font.BOLD, 36));
		btnGenerarInformeJsonRendimiento.setBackground(new Color(70, 130, 180));
		btnGenerarInformeJsonRendimiento.setBounds(160, 173, 514, 114);
		panel_CreacionResumenDeRendimiento.add(btnGenerarInformeJsonRendimiento);
		
		lbl_TituloGenerarInformeRendimiento = new JLabel("¡GENERA EL INFORME DE JSON DE RENDIMIENTO!");
		lbl_TituloGenerarInformeRendimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TituloGenerarInformeRendimiento.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lbl_TituloGenerarInformeRendimiento.setBounds(53, 49, 723, 64);
		panel_CreacionResumenDeRendimiento.add(lbl_TituloGenerarInformeRendimiento);
		
		lbl_MensajeInformacionUsuarioRendimiento = new JLabel("");
		lbl_MensajeInformacionUsuarioRendimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MensajeInformacionUsuarioRendimiento.setForeground(new Color(46, 139, 87));
		lbl_MensajeInformacionUsuarioRendimiento.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lbl_MensajeInformacionUsuarioRendimiento.setBounds(173, 329, 480, 87);
		panel_CreacionResumenDeRendimiento.add(lbl_MensajeInformacionUsuarioRendimiento);
		
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
		lbmensajeRetroalimentacion.setForeground(new Color(46, 139, 87));
		lbmensajeRetroalimentacion.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lbmensajeRetroalimentacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbmensajeRetroalimentacion.setBounds(185, 438, 453, 38);
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
		lbl_MensajeInformacionUsuario.setForeground(new Color(46, 139, 87));
		lbl_MensajeInformacionUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MensajeInformacionUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lbl_MensajeInformacionUsuario.setBounds(173, 329, 480, 87);
		panel_CreacionInforme.add(lbl_MensajeInformacionUsuario);
		panelCreacionColaboracionJson.setVisible(false);
		
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
		
		panelAnalisisRendimiento = new Panel();
		panelAnalisisRendimiento.setBounds(0, 92, 1240, 587);
		contentPane.add(panelAnalisisRendimiento);
		panelAnalisisRendimiento.setVisible(false);
		panelAnalisisRendimiento.setLayout(null);
		
		panelContenedor = new JPanel();
		panelContenedor.setBounds(109, 93, 1017, 353);
		panelAnalisisRendimiento.add(panelContenedor);
		panelContenedor.setVisible(true);
		panelContenedor.setBorder(new LineBorder(new Color(255, 215, 0), 2, true));
		panelContenedor.setLayout(null);
		
		listPlataformas = new JList();
		listPlataformas.setBounds(42, 128, 158, 169);
		listPlataformas.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		listPlataformas.setBorder(new LineBorder(new Color(255, 215, 0), 2, true));
		panelContenedor.add(listPlataformas);
		
		separator_8 = new JSeparator();
		separator_8.setBounds(42, 102, 158, 2);
		panelContenedor.add(separator_8);
		separator_8.setForeground(new Color(255, 255, 255));
		
		lbTituloAnalisis = new JLabel("Plataformas");
		lbTituloAnalisis.setBounds(49, 55, 151, 36);
		panelContenedor.add(lbTituloAnalisis);
		lbTituloAnalisis.setForeground(new Color(0, 0, 128));
		lbTituloAnalisis.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		
		listRendimiento = new JList();
		listRendimiento.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		listRendimiento.setBorder(new LineBorder(new Color(255, 215, 0), 2, true));
		listRendimiento.setBounds(617, 128, 364, 169);
		panelContenedor.add(listRendimiento);
		listRendimiento.setVisible(false);
		
		lbPlataformaFoto = new JLabel("");
		lbPlataformaFoto.setBounds(307, 128, 219, 169);
		panelContenedor.add(lbPlataformaFoto);
		
		lblRendimiento = new JLabel("Rendimiento");
		lblRendimiento.setForeground(new Color(0, 0, 128));
		lblRendimiento.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblRendimiento.setBounds(712, 68, 151, 36);
		panelContenedor.add(lblRendimiento);
		lblRendimiento.setVisible(false);
		
		separator_9 = new JSeparator();
		separator_9.setForeground(new Color(255, 255, 255));
		separator_9.setBounds(690, 102, 189, 2);
		panelContenedor.add(separator_9);
		separator_9.setVisible(false);
		
		lblAnalisisDeRendimiento = new JLabel("Analisis de rendimiento");
		lblAnalisisDeRendimiento.setForeground(new Color(0, 0, 128));
		lblAnalisisDeRendimiento.setFont(new Font("Segoe Print", Font.BOLD, 35));
		lblAnalisisDeRendimiento.setBounds(10, 513, 413, 63);
		panelAnalisisRendimiento.add(lblAnalisisDeRendimiento);
		
		lbfondoAnalisisRendimiento = new JLabel("");
		lbfondoAnalisisRendimiento.setBounds(0, 0, 1240, 587);
		panelAnalisisRendimiento.add(lbfondoAnalisisRendimiento);
		panelAnalisisRendimiento.setVisible(false);
		lbfondoAnalisisRendimiento.setIcon(ajustarTamañoImg("img/fondoInicioApp.jpg", lbfondoAnalisisRendimiento.getWidth(), lbfondoAnalisisRendimiento.getHeight()));
		
		panelColaboracionesCsv = new JPanel();
		panelColaboracionesCsv.setBounds(0, 92, 1240, 587);
		contentPane.add(panelColaboracionesCsv);
		panelColaboracionesCsv.setLayout(null);
		panelColaboracionesCsv.setVisible(false);
		
		lbl_MensajeInfoUsuarioColaboracionesCSV = new JLabel("");
		lbl_MensajeInfoUsuarioColaboracionesCSV.setForeground(new Color(37, 128, 28));
		lbl_MensajeInfoUsuarioColaboracionesCSV.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_MensajeInfoUsuarioColaboracionesCSV.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lbl_MensajeInfoUsuarioColaboracionesCSV.setBounds(184, 11, 886, 76);
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
		
		menuAnalisisComparativo = new JMenu("Análisis de contenido");
		menuAnalisisComparativo.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		menuBar.add(menuAnalisisComparativo);
		menuAnalisisComparativo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 215, 0), null, null, null));
		
		itemAnalisis = new JMenuItem("Analisis");
		itemAnalisis.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		menuAnalisisComparativo.add(itemAnalisis);
		
		lbl_Logo = new JLabel("");
		lbl_Logo.setBounds(10, 11, 111, 70);
		panel_Cabecera.add(lbl_Logo);
		lbl_Logo.setIcon(ajustarTamañoImg("img/logoEmpresa.jpg", lbl_Logo.getWidth(), lbl_Logo.getHeight()));
		
		panelConversionesColaboracionesJson = new JPanel();
		panelConversionesColaboracionesJson.setBounds(0, 92, 1240, 587);
		contentPane.add(panelConversionesColaboracionesJson);
		panelConversionesColaboracionesJson.setLayout(null);
		panelConversionesColaboracionesJson.setVisible(false);
		
		lbRetroalimentacion = new JLabel("");
		lbRetroalimentacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbRetroalimentacion.setForeground(new Color(46, 139, 89));
		lbRetroalimentacion.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lbRetroalimentacion.setBounds(325, 375, 606, 105);
		panelConversionesColaboracionesJson.add(lbRetroalimentacion);
		
		btnConversionColaboracionesJson = new JButton("COLABORACIONES JSON");
		btnConversionColaboracionesJson.setForeground(Color.WHITE);
		btnConversionColaboracionesJson.setFont(new Font("Trebuchet MS", Font.BOLD, 36));
		btnConversionColaboracionesJson.setBackground(new Color(70, 130, 180));
		btnConversionColaboracionesJson.setBounds(365, 225, 514, 114);
		panelConversionesColaboracionesJson.add(btnConversionColaboracionesJson);
		
		lbl_TituloGenerarColaboracionesJson = new JLabel("¡CONVIERTE LAS COLABORACIONES A JSON!");
		lbl_TituloGenerarColaboracionesJson.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TituloGenerarColaboracionesJson.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		lbl_TituloGenerarColaboracionesJson.setBounds(242, 110, 777, 80);
		panelConversionesColaboracionesJson.add(lbl_TituloGenerarColaboracionesJson);
		
		lbtituloConversionesColaboraciones = new JLabel("Conversiones");
		lbtituloConversionesColaboraciones.setForeground(new Color(0, 0, 128));
		lbtituloConversionesColaboraciones.setFont(new Font("Segoe Print", Font.BOLD, 40));
		lbtituloConversionesColaboraciones.setBounds(10, 513, 323, 63);
		panelConversionesColaboracionesJson.add(lbtituloConversionesColaboraciones);
		
		lbfondoConversionesJson = new JLabel("");
		lbfondoConversionesJson.setBounds(0, 0, 1240, 587);
		panelConversionesColaboracionesJson.add(lbfondoConversionesJson);
		lbfondoConversionesJson.setIcon(ajustarTamañoImg("img/fondoInicioApp.jpg", lbfondoConversionesJson.getWidth(), lbfondoConversionesJson.getHeight()));
		
	}//InterfazApp CONSTRUCTOR
	
	public static ImageIcon ajustarTamañoImg(String ruta, int ancho, int alto) {
        ImageIcon imagen = new ImageIcon((ruta));
        Image imagenOriginal = imagen.getImage();
        Image imagenAjustada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenAjustada);
	}//FIN AJUSTAR TAMAÑO IMG
}//InterfazApp CLASS