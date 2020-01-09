package vista;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import modelo.Usuario;
import modelo.Rol;
import negocio.GestionUsuarioLocal;
import negocio.GestionRolLocal;

@ManagedBean
public class GestionUsuarioBean {

	@Inject
	private GestionUsuarioLocal gpl;
	@Inject
	private GestionRolLocal grl;

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
	private int rolId = 4;
	private Rol rol;

	private List<Usuario> usuarios;
	
	private String filtro;
	private String selectedUsuarioId;
	private String selectedUsuarioId2;
	private Usuario editedUsuario;
	
	@PostConstruct
	public void init() {
		listUsuario();
	}

	public GestionUsuarioLocal getGpl() {
		return gpl;
	}

	public void setGpl(GestionUsuarioLocal gpl) {
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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getSelectedUsuarioId() {
		return selectedUsuarioId;
	}

	public void setSelectedUsuarioId(String selectedUsuarioId) {
		this.selectedUsuarioId = selectedUsuarioId;
	}
	
	public String getSelectedUsuarioId2() {
		return selectedUsuarioId2;
	}

	public void setSelectedUsuarioId2(String selectedUsuarioId2) {
		this.selectedUsuarioId2 = selectedUsuarioId2;
	}
	
	public Usuario geteditedUsuario() {
		return editedUsuario;
	}

	public void seteditedUsuario(Usuario editedUsuario) {
		this.editedUsuario = editedUsuario;
	}

	public String guardarUsuario() {
		
		rol = grl.readRol(rolId);
		gpl.guardarUsuario(id, nombre, apellido, genero, fecha_nac, correo, contrasena, telf1, telf2, direccion, peso, estatura, rol);
		usuarios = gpl.getUsuarios();
		return null;
		
	}
	
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Usuario> buscarUsuario() {
		
		usuarios = gpl.getUsuariosPorNombre(filtro);
		
		return usuarios;
	}
	
	public String editUsuarioById() {
		
		selectedUsuarioId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedUsuarioId");
		System.out.println(selectedUsuarioId);
		editedUsuario = gpl.readUsuario(selectedUsuarioId);
		return "updateUsuario";
		
	}
	
	public String deleteUsuario() {
		
		selectedUsuarioId2 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedUsuarioId2");
		System.out.println(selectedUsuarioId2);
		gpl.deleteUsuario(selectedUsuarioId2);
		return null;
		
	}
	
	public void listUsuario() {
		this.usuarios = this.gpl.getUsuarios();
	}

	public String updateUsuario() {
		gpl.updateUsuario(id, nombre, apellido, genero, fecha_nac, correo, contrasena, telf1, telf2, direccion, peso, estatura);
		return "listUsuario";
		
	}
	
}
