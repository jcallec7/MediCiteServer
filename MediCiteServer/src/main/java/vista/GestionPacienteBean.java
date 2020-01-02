package vista;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import modelo.Paciente;
import negocio.GestionPacienteLocal;

@ManagedBean
public class GestionPacienteBean {

	@Inject
	private GestionPacienteLocal gpl;

	/* Beans properties */
	private String id;
	private String nombre;
	private String apellido;
	private String genero;
	private Date fecha_nac;
	private String correo;
	private String contrasena;
	private String telf1;
	private String telf2;
	private String direccion;
	private String peso;
	private String estatura;

	private List<Paciente> pacientes;
	
	private String filtro;
	private String selectedPacienteId;
	private String selectedPacienteId2;
	
	@PostConstruct
	public void init() {
		listPaciente();
	}

	public GestionPacienteLocal getGpl() {
		return gpl;
	}

	public void setGpl(GestionPacienteLocal gpl) {
		this.gpl = gpl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTelf1() {
		return telf1;
	}

	public void setTelf1(String telf1) {
		this.telf1 = telf1;
	}

	public String getTelf2() {
		return telf2;
	}

	public void setTelf2(String telf2) {
		this.telf2 = telf2;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getEstatura() {
		return estatura;
	}

	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public String getSelectedPacienteId() {
		return selectedPacienteId;
	}

	public void setSelectedPacienteId(String selectedPacienteId) {
		this.selectedPacienteId = selectedPacienteId;
	}
	
	public String getSelectedPacienteId2() {
		return selectedPacienteId2;
	}

	public void setSelectedPacienteId2(String selectedPacienteId2) {
		this.selectedPacienteId2 = selectedPacienteId2;
	}

	public String guardarPaciente() {
		
		gpl.guardarPaciente(id, nombre, apellido, genero, fecha_nac, correo, contrasena, telf1, telf2, direccion, peso, estatura);
		pacientes = gpl.getPacientes();
		return null;
		
	}
	
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Paciente> buscarPaciente() {
		
		pacientes = gpl.getPacientesPorNombre(filtro);
		
		return pacientes;
	}
	
	public String editPacienteById() {
		
		selectedPacienteId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedPacienteId");
		System.out.println(selectedPacienteId);
		return "updatePaciente";
		
	}
	
	public String deletePaciente() {
		
		selectedPacienteId2 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedPacienteId2");
		System.out.println(selectedPacienteId2);
		gpl.deletePaciente(selectedPacienteId2);
		return null;
		
	}
	
	public void listPaciente() {
		this.pacientes = this.gpl.getPacientes();
	}

}
