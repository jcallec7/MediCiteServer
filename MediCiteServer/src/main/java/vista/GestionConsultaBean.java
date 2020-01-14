package vista;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import modelo.Consulta;
import modelo.Diagnostico;
import modelo.Usuario;
import negocio.GestionConsultaLocal;
import negocio.GestionUsuarioLocal;

@ManagedBean
@SessionScoped
public class GestionConsultaBean {

	@Inject
	private GestionConsultaLocal gcl;
	
	@Inject
	private GestionUsuarioLocal gul;
	
	/* Beans properties */
	private int id;
	private Usuario usuario;
	private Usuario medico;
	private Date fecha;
	private Diagnostico diagnostico;

	private List<Consulta> consultas;
	private List<Usuario> medicos;
	private List<Usuario> usuarios;

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
		
		System.out.println("Entroooo");
		System.out.println(selectedUsuario);
		System.out.println(selectedMedico);
		fecha.setHours(hora);
		fecha.setMinutes(minuto);
		gcl.guardarConsulta(id, selectedUsuario, selectedMedico, fecha, diagnostico);
		consultas = gcl.getConsultas();
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

	public String editConsultaById() {

		gcl.getConsultas();
		selectedConsultaId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedConsultaId"));
		System.out.println(selectedConsultaId);
		selectedConsulta = gcl.readConsulta(selectedConsultaId);
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

	public String updateConsulta() {
		gcl.updateConsulta(id, usuario, medico, fecha, diagnostico);
		return "listConsulta";
	}

}
