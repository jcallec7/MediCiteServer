package vista;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import modelo.Consulta;
import modelo.Diagnostico;
import modelo.Medico;
import modelo.Paciente;
import negocio.GestionConsultaLocal;
import negocio.GestionMedicoLocal;
import negocio.GestionPacienteLocal;

@ManagedBean
@SessionScoped
public class GestionConsultaBean {

	@Inject
	private GestionConsultaLocal gcl;
	
	@Inject
	private GestionPacienteLocal gpl;
	
	@Inject
	private GestionMedicoLocal gml;
	
	/* Beans properties */
	private int id;
	private Paciente paciente;
	private Medico medico;
	private Date fecha;
	private Diagnostico diagnostico;

	private List<Consulta> consultas;
	private List<Medico> medicos;
	private List<Paciente> pacientes;

	private String filtro;
	private Paciente selectedPaciente;
	private Medico selectedMedico;
	private Consulta editedConsulta;
	private Diagnostico selectedDiagnostico;

	@PostConstruct
	public void init() {
		//listConsultas();
		listPacientes();
		listMedicos();
	}
	
	public GestionPacienteLocal getGpl() {
		return gpl;
	}

	public void setGpl(GestionPacienteLocal gpl) {
		this.gpl = gpl;
	}

	public GestionMedicoLocal getGml() {
		return gml;
	}

	public void setGml(GestionMedicoLocal gml) {
		this.gml = gml;
	}

	public Paciente getSelectedPaciente() {
		return selectedPaciente;
	}

	public void setSelectedPaciente(Paciente selectedPaciente) {
		this.selectedPaciente = selectedPaciente;
	}

	public Medico getSelectedMedico() {
		return selectedMedico;
	}

	public void setSelectedMedico(Medico selectedMedico) {
		this.selectedMedico = selectedMedico;
	}

	public Diagnostico getSelectedDiagnostico() {
		return selectedDiagnostico;
	}

	public void setSelectedDiagnostico(Diagnostico selectedDiagnostico) {
		this.selectedDiagnostico = selectedDiagnostico;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
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
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}	

	public Consulta getEditedConsulta() {
		return editedConsulta;
	}

	public void setEditedConsulta(Consulta editedConsulta) {
		this.editedConsulta = editedConsulta;
	}

	public String guardarConsulta() {
		
		System.out.println(selectedPaciente);
		System.out.println(selectedMedico);
		gcl.guardarConsulta(id, selectedPaciente, selectedMedico, fecha, diagnostico);
		consultas = gcl.getConsultas();
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

		return null;

	}

	public String deleteConsulta() {

		return null;

	}

	public void listConsultas() {
		this.consultas = this.gcl.getConsultas();
	}
	
	public void listPacientes() {
		this.pacientes = this.gpl.getPacientes();
	}
	
	public void listMedicos() {
		this.medicos = this.gml.getMedico();
	}

	public String updateConsulta() {
		gcl.updateConsulta(id, paciente, medico, fecha, diagnostico);
		return "listConsulta";
	}

}
