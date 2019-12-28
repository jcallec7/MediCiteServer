package vista;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import modelo.Medico;
import negocio.GestionMedicoLocal;

@ManagedBean
public class GestionMedicoBean {

	
	@Inject
	private GestionMedicoLocal gml;
	
	
	private String id;
	private String nombre;
	private String apellido;
	private String genero;
	private String especialidad;
	private String correo;
	private String direccion;
	private Date fechaNac;
	private String contrasena;

	private List<Medico> Medicos;

	public GestionMedicoLocal getGml() {
		return gml;
	}

	public void setGml(GestionMedicoLocal gml) {
		this.gml = gml;
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

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public List<Medico> getMedicos() {
		return Medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		Medicos = medicos;
	}
	

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	
	
	public String guardarMedico() {
		
		gml.guardarMedico(id, nombre, apellido, genero, especialidad, correo, direccion, fechaNac, contrasena);
		//System.out.print(id+"," +nombre+"," +apellido+"," +genero+"," +especialidad+"," + correo+"," +direccion+"," +fechaNac+"," +contrasena);
		Medicos = gml.getMedico();
		
		
		//return "listadoAutores";
		return null;
	}
	
}

