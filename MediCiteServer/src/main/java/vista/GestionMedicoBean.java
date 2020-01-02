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
	private String filtro;
	
	private List<Medico> medicos;
	private Medico medicoEdit;
	

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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	

	public Medico getMedicoEdit() {
		return medicoEdit;
	}

	public void setMedicoEdit(Medico medicoEdit) {
		this.medicoEdit = medicoEdit;
	}

	public String guardarMedico() {
		
		gml.guardarMedico(id, nombre, apellido, genero, especialidad, correo, direccion, fechaNac, contrasena);
		medicos = gml.getMedico();
		return "listMedico";
	}
	
	
	public String editarMedico(String id) {
		
		this.medicoEdit = gml.leerMedico(id);
		return "updateMedico";
	}
	
	public String actualizarMedico() {
		
		gml.editarMedico(id, nombre, apellido, genero, especialidad, correo, direccion, fechaNac, contrasena);
		return "listMedico";
	}
	
	public String eliminarMedico(String id) {
		
		gml.eliminarMedico(id);	
		return "listMedico";
	}
	
	public List<Medico> buscarMedico() {
		
		medicos = gml.getMedicoPorNombre(filtro);
		return medicos;
	}
	
	public List<Medico> buscarMedicoPorId() {
		
		medicos = gml.getMedicoPorId(filtro);
		return medicos;
	}
	
}

