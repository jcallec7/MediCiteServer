package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Paciente;
import negocio.GestionPacienteLocal;

@ManagedBean
public class GestionPacienteBean {

	
	@Inject
	private GestionPacienteLocal gpl;
	
	/*Beans properties*/
	private String id;
	private String nombre;
	private String apellido;
	private String cedula;
	private String genero;
	private String fecha_nac; 
	private String correo;
	private String contrasena;
	private String telf1;
	private String telf2;
	private String direccion; 
	private String peso; 
	private String estatura;
	
	private List<Paciente> Pacientes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setgpl(GestionPacienteLocal gpl) {
		this.gpl = gpl;
	}

	public GestionPacienteLocal getgpl() {
		return gpl;
	}

	public void setGa(GestionPacienteLocal gpl) {
		this.gpl = gpl;
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

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public List<Paciente> getPacientes() {
		return Pacientes;
	}

	public void setPacientes(List<Paciente> Pacientes) {
		this.Pacientes = Pacientes;
	}

	public String guardarPaciente() {
		
		gpl.guardarPaciente(id, nombre, apellido, cedula, genero, 
							fecha_nac, correo, contrasena, telf1, 
							telf2, direccion, peso, estatura);
		Pacientes = gpl.getPacientes();
		
		//return "listadoAutores";
		return null;
	}
	
}

