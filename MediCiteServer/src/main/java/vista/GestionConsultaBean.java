package vista;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import modelo.Consulta;
import modelo.Detalle;
import modelo.Diagnostico;
import modelo.Medicamento;
import modelo.Receta;
import modelo.Usuario;
import negocio.GestionConsultaLocal;
import negocio.GestionDetalleLocal;
import negocio.GestionDiagnosticoLocal;
import negocio.GestionRecetaLocal;
import negocio.GestionUsuarioLocal;

@ManagedBean
@SessionScoped
public class GestionConsultaBean {

	@Inject
	private GestionConsultaLocal gcl;
	
	@Inject
	private GestionUsuarioLocal gul;
	
	@Inject
	private GestionDiagnosticoLocal gdl;
	
	@Inject
	private GestionRecetaLocal grl;
	
	@Inject
	private GestionDetalleLocal gdetl;
	
	/* Beans properties */
	private int id;
	private Usuario usuario;
	private Usuario medico;
	private Date fecha;
	private Diagnostico diagnostico;
	private Receta receta;
	private Detalle detalle;
	private Consulta consulta;
	private Medicamento medicamento;

	private List<Consulta> consultas;
	private List<Usuario> medicos;
	private List<Usuario> usuarios;
	private List<Detalle> detalles;
	private List<Receta> recetas;

	private String filtro;
	private Usuario selectedUsuario;
	private Usuario selectedMedico;
	private int selectedConsultaId;
	private int selectedConsultaId2;
	private Consulta selectedConsulta;
	private Diagnostico selectedDiagnostico;
	private int hora;
	private int minuto;
	private int rolMed = 3;
	private int rolPac = 4;

	@PostConstruct
	public void init() {
		listConsultas();
		listUsuarios();
		listMedicos();
		receta = new Receta();
		receta.addDetalle(new Detalle());
		listRecetas();
	}
	
	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	public GestionDiagnosticoLocal getGdl() {
		return gdl;
	}

	public void setGdl(GestionDiagnosticoLocal gdl) {
		this.gdl = gdl;
	}

	public GestionRecetaLocal getGrl() {
		return grl;
	}

	public void setGrl(GestionRecetaLocal grl) {
		this.grl = grl;
	}

	public GestionDetalleLocal getGdetl() {
		return gdetl;
	}

	public void setGdetl(GestionDetalleLocal gdetl) {
		this.gdetl = gdetl;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public int getSelectedConsultaId2() {
		return selectedConsultaId2;
	}

	public void setSelectedConsultaId2(int selectedConsultaId2) {
		this.selectedConsultaId2 = selectedConsultaId2;
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

	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}

	public void setSelectedUsuario(Usuario selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}

	public Usuario getSelectedMedico() {
		return selectedMedico;
	}

	public void setSelectedMedico(Usuario selectedMedico) {
		this.selectedMedico = selectedMedico;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getMedico() {
		return medico;
	}

	public void setMedico(Usuario medico) {
		this.medico = medico;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
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

	public String guardarConsulta() {
		
		fecha.setHours(hora);
		fecha.setMinutes(minuto);
		gcl.guardarConsulta(id, selectedUsuario, selectedMedico, fecha, diagnostico);
		consultas = gcl.getConsultas();
		return "listConsulta";

	}
	
	public String addDiagnostico() {
		
		id = selectedConsulta.getId();
		usuario = selectedConsulta.getUsuario();
		medico = selectedConsulta.getMedico();
		fecha = selectedConsulta.getFecha();
		gdl.guardarDiagnostico(diagnostico.getId(), diagnostico.getDetalle(), diagnostico.getReceta(), diagnostico.getTipo());
		selectedConsulta.setDiagnostico(diagnostico);
		gcl.addDiagnostico(id, usuario, medico, fecha, diagnostico);
		
		return null;
		
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

	public String editConsultaById() {

		gcl.getConsultas();
		selectedConsultaId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedConsultaId"));
		System.out.println(selectedConsultaId);
		selectedConsulta = gcl.readConsulta(selectedConsultaId);
		diagnostico = new Diagnostico();
		receta = diagnostico.getReceta();
		
		return "updateConsulta";

	}

	public String deleteConsulta() {

		selectedConsultaId2 = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedConsultaId2"));
		System.out.println(selectedConsultaId2);
		gcl.deleteConsulta(selectedConsultaId2);
		return "return alert('Consulta Eliminada Exitosamente')";

	}

	public void listConsultas() {
		this.consultas = this.gcl.getConsultas();
	}
	
	public void listUsuarios() {
		this.usuarios = this.gul.getUsuarioPorRol(rolPac);
	}
	
	public void listMedicos() {
		this.medicos = this.gul.getUsuarioPorRol(rolMed);
	}
	
	private void listRecetas() {
		this.detalles = this.gdetl.getDetalles();
		this.recetas = this.grl.getRecetas();
	}

	public String updateConsulta() {
		gcl.updateConsulta(id, usuario, medico, fecha, diagnostico);
		return "listConsulta";
	}

}
