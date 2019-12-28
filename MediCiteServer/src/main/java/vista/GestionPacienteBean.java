package vista;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
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

	private List<Paciente> Pacientes;

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
		return Pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		Pacientes = pacientes;
	}

	public String guardarPaciente() {

		gpl.guardarPaciente(id, nombre, apellido, genero, fecha_nac, correo, contrasena, telf1, telf2, direccion, peso, estatura);
		Pacientes = gpl.getPacientes();

		// return "listadoAutores";
		return null;
	}

}
