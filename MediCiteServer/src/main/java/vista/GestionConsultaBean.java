package vista;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.primefaces.event.SelectEvent;

import modelo.Consulta;
import modelo.Detalle;
import modelo.Diagnostico;
import modelo.Factura;
import modelo.Medicamento;
import modelo.Receta;
import modelo.Usuario;
import negocio.GestionConsultaLocal;
import negocio.GestionDetalleLocal;
import negocio.GestionDiagnosticoLocal;
import negocio.GestionFacturaLocal;
import negocio.GestionMedicamentoLocal;
import negocio.GestionRecetaLocal;
import negocio.GestionUsuarioLocal;
import utils.Session;

@ManagedBean
@ApplicationScoped
public class GestionConsultaBean implements Serializable {

	@Inject
	private GestionConsultaLocal gcl;

	@Inject
	private GestionUsuarioLocal gul;

	@Inject
	private GestionMedicamentoLocal gml;
	
	@Inject
	private GestionFacturaLocal gfl;

	/* Beans properties */
	private Detalle det;
	private Consulta consulta;
	private Medicamento medicamento;

	private List<Consulta> consultas;
	private List<Consulta> consultasUsuario;
	private List<Usuario> medicos;
	private List<Usuario> usuarios;
	private List<Diagnostico> diagnosticos;

	private String filtro;
	private int selectedConsultaId;
	private Consulta selectedConsulta;
	private Diagnostico selectedDiagnostico;
	private Factura factura;
	private int hora;
	private int minuto;
	private int rolMed = 3;
	private int rolPac = 4;
	
	private Usuario miUsuario;

	@PostConstruct
	public void init() {
	
		miUsuario = (Usuario) Session.getSession().getAttribute("user");
		//listConsultas();
		listConsultasUsuario();
		listUsuarios();
		listMedicos();
		consulta = new Consulta();
	}

	public List<Consulta> getConsultasUsuario() {
		listUsuarios();
		listMedicos();
		return consultasUsuario;
	}

	public void setConsultasUsuario(List<Consulta> consultasUsuario) {
		this.consultasUsuario = consultasUsuario;
	}

	public Usuario getMiUsuario() {
		return miUsuario;
	}

	public void setMiUsuario(Usuario miUsuario) {
		this.miUsuario = miUsuario;
	}

	public GestionFacturaLocal getGfl() {
		return gfl;
	}

	public void setGfl(GestionFacturaLocal gfl) {
		this.gfl = gfl;
	}

	public GestionMedicamentoLocal getGml() {
		return gml;
	}

	public void setGml(GestionMedicamentoLocal gml) {
		this.gml = gml;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public List<Diagnostico> getDiagnosticos() {
		return diagnosticos;
	}

	public void setDiagnosticos(List<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Detalle getDet() {
		return det;
	}

	public void setDet(Detalle det) {
		this.det = det;
	}

	public Consulta getSelectedConsulta() {
		return selectedConsulta;
	}

	public void setSelectedConsulta(Consulta selectedConsulta) {
		this.selectedConsulta = selectedConsulta;
	}

	public int getSelectedConsultaId() {
		return selectedConsultaId;
	}

	public void setSelectedConsultaId(int selectedConsultaId) {
		this.selectedConsultaId = selectedConsultaId;
	}

	public GestionUsuarioLocal getGul() {
		return gul;
	}

	public void setGul(GestionUsuarioLocal gul) {
		this.gul = gul;
	}
	
	public int getRolMed() {
		return rolMed;
	}

	public void setRolMed(int rolMed) {
		this.rolMed = rolMed;
	}

	public int getRolPac() {
		return rolPac;
	}

	public void setRolPac(int rolPac) {
		this.rolPac = rolPac;
	}

	public Diagnostico getSelectedDiagnostico() {
		return selectedDiagnostico;
	}

	public void setSelectedDiagnostico(Diagnostico selectedDiagnostico) {
		this.selectedDiagnostico = selectedDiagnostico;
	}

	public List<Usuario> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Usuario> medicos) {
		this.medicos = medicos;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public GestionConsultaLocal getGcl() {
		return gcl;
	}

	public void setGcl(GestionConsultaLocal gcl) {
		this.gcl = gcl;
	}

	public List<Consulta> getConsultas() {
		listUsuarios();
		listMedicos();
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}


	public String crearFactura() {

		consulta.setEstado("Pendiente");
		factura = new Factura();
		factura.setConsulta(consulta);
		factura.setFecha(new Date());
		factura.setTotal(25);
		factura.setSubtotal(factura.getTotal() / 1.12);
		
		//gcl.guardarConsulta(consulta.getId(), consulta.getUsuario(), consulta.getMedico(), consulta.getEstado(), consulta.getFecha(), null);
		//consultas = gcl.getConsultas();
		
		return "createFactura";

	}
	
	public String crearFacturaPaciente() {

		/*String miUsuarioId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("miUsuario");
		miUsuario = gul.readUsuario(miUsuarioId);
		consulta.setUsuario(miUsuario);*/
		
		miUsuario = (Usuario) Session.getSession().getAttribute("user");
		
		consulta.setUsuario(miUsuario);
		
		System.out.println("Consulta recuperada para la factura:" + consulta);
		
		consulta.setEstado("Pendiente");
		factura = new Factura();
		factura.setConsulta(consulta);
		factura.setFecha(new Date());
		factura.setTotal(25);
		factura.setSubtotal(factura.getTotal() / 1.12);
		
		System.out.println("Factura recuperada:" + factura);
		
		//gcl.guardarConsulta(consulta.getId(), consulta.getUsuario(), consulta.getMedico(), consulta.getEstado(), consulta.getFecha(), null);
		//consultas = gcl.getConsultas();
		
		return "createFacturaPaciente";

	}
	
	public void usarDatosPaciente() {
		factura.setNombre(consulta.getUsuario().getNombre() + " " + consulta.getUsuario().getApellido());
		factura.setCedulaRuc(consulta.getUsuario().getId());
		factura.setDireccion(consulta.getUsuario().getDireccion());
	}
	
	public String realizarPago() {
		factura.setConsulta(consulta);
		gfl.guardarFactura(factura.getId(), factura.getNombre(), factura.getCedulaRuc(), factura.getDireccion(), factura.getConsulta(), factura.getSubtotal(), factura.getTotal(), factura.getFecha());
		init();
		return "listConsulta";
	}

	public String updateConsulta() {

		gcl.updateConsulta(selectedConsulta.getId(), selectedConsulta.getUsuario(), selectedConsulta.getMedico(), selectedConsulta.getEstado(), selectedConsulta.getFecha(), selectedConsulta.getDiagnostico());
		init();
		return "listConsulta";

	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Consulta> buscarConsulta() {

		consultas = gcl.getConsultasPorNombre(filtro);

		return consultas;
	}

	public String addDiagnosticoConsultaById() {

		//gcl.getConsultas();
		selectedConsultaId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("selectedConsultaId"));
		System.out.println(selectedConsultaId);
		selectedConsulta = gcl.readConsulta(selectedConsultaId);

		selectedConsulta.setDiagnostico(new Diagnostico());
		selectedConsulta.getDiagnostico().setReceta(new Receta());
		det = new Detalle();
		det.setMedicamento(new Medicamento());
		selectedConsulta.getDiagnostico().getReceta().setDetalle(new ArrayList<Detalle>());
		selectedConsulta.getDiagnostico().getReceta().addDetalle(det);

		return "addDiagnosticoConsulta";

	}

	public String editConsultaById() {

		selectedConsultaId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("selectedConsultaId"));
		System.out.println(selectedConsultaId);
		selectedConsulta = gcl.readConsulta(selectedConsultaId);

		return "updateConsulta";

	}

	public String deleteConsulta() {

		selectedConsultaId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("selectedConsultaId"));
		System.out.println(selectedConsultaId);
		gcl.deleteConsulta(selectedConsultaId);
		return "return alert('Consulta Eliminada Exitosamente')";

	}

	public void listConsultas() {
		this.consultas = this.gcl.getConsultas();
	}
	
	public void listConsultasUsuario() {
		this.consultasUsuario = this.gcl.getConsultasPorId(miUsuario.getId());
	}

	public void listUsuarios() {
		this.usuarios = this.gul.getUsuarioPorRol(rolPac);
	}

	public void listMedicos() {
		this.medicos = this.gul.getUsuarioPorRol(rolMed);
	}

	public String addDetalle() {
		det = new Detalle();
		det.setMedicamento(new Medicamento());
		selectedConsulta.getDiagnostico().getReceta().addDetalle(det);
		return null;
	}

	public String actualizarDiagnostico() {

		selectedConsulta.setEstado("Finalizado");
		for (Detalle d : selectedConsulta.getDiagnostico().getReceta().getDetalle()) {
			List<Medicamento> medicamentos = gml.getMedicamentoPorNombreYConcentracion(d.getMedicamento().getnombre(),
					d.getMedicamento().getConcentracion());
			if (medicamentos.size() != 0) {
				medicamento = gml.getMedicamentoPorNombreYConcentracion(d.getMedicamento().getnombre(),
						d.getMedicamento().getConcentracion()).get(0);
				d.setMedicamento(medicamento);
			}
		}
		gcl.updateConsulta(selectedConsulta.getId(), selectedConsulta.getUsuario(), selectedConsulta.getMedico(), selectedConsulta.getEstado(),
				selectedConsulta.getFecha(), selectedConsulta.getDiagnostico());
		init();
		return "listConsulta";
	}
	
	public String loadDiagnostico() {
		selectedConsultaId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("selectedConsultaId"));
		System.out.println(selectedConsultaId);
		selectedConsulta = gcl.readConsulta(selectedConsultaId);
		selectedConsulta.getDiagnostico();
		return "readDiagnostico";
	}
	
	
	
}
