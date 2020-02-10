package vista;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import modelo.Rol;
import modelo.Usuario;
import negocio.GestionRolLocal;
import negocio.GestionUsuarioLocal;
import utils.Session;

@ManagedBean
@ViewScoped
public class GestionAdminBean {


	
	@Inject
	private GestionUsuarioLocal gul;
	@Inject
	private GestionRolLocal grl;
	
	private String id;
	private String nombre;
	private String apellido;
	private String genero;
	private String especialidad;
	private String correo;
	private String direccion;
	private String telf1;
	private String telf2;
	private String peso = "N/A";
	private String estatura = "N/A";
	private Date fechaNac;
	private String contrasena;
	private String filtro;
	private String preguntaSeguridad;
	private int rolId = 2;
	private Rol rol;
	
	private HttpSession session = Session.getSession();
	private Usuario miUsuario = (Usuario) session.getAttribute("user");
			
	private List<Usuario> admins = new ArrayList<Usuario>();
	private Usuario adminEdit;
	
	

	public GestionUsuarioLocal getGul() {
		return gul;
	}


	public void setGul(GestionUsuarioLocal gul) {
		this.gul = gul;
	}


	public GestionRolLocal getGrl() {
		return grl;
	}


	public void setGrl(GestionRolLocal grl) {
		this.grl = grl;
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


	public String getFiltro() {
		return filtro;
	}


	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


	public int getRolId() {
		return rolId;
	}


	public void setRolId(int rolId) {
		this.rolId = rolId;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}


	public List<Usuario> getAdmins() {
		return admins;
	}


	public void setAdmins(List<Usuario> admins) {
		this.admins = admins;
	}


	public Usuario getAdminEdit() {
		return adminEdit;
	}


	public void setAdminEdit(Usuario adminEdit) {
		this.adminEdit = adminEdit;
	}


	public HttpSession getSession() {
		return session;
	}


	public void setSession(HttpSession session) {
		this.session = session;
	}


	public Usuario getMiUsuario() {
		return miUsuario;
	}


	public void setMiUsuario(Usuario miUsuario) {
		this.miUsuario = miUsuario;
	}


	public String getPreguntaSeguridad() {
		return preguntaSeguridad;
	}


	public void setPreguntaSeguridad(String preguntaSeguridad) {
		this.preguntaSeguridad = preguntaSeguridad;
	}


	public String guardarAdmin() {
		
		rol = grl.readRol(rolId);
		gul.guardarUsuario(id, nombre, apellido, genero, fechaNac, correo, especialidad, contrasena, telf1, telf2, direccion, peso, estatura, preguntaSeguridad.toLowerCase(), rol);
		admins = gul.getUsuarios();
		
		
		return "login";
	}
	
	
	public String editarAdmin(String id) {
		
		this.adminEdit = gul.readUsuario(id);
		
		this.setId(adminEdit.getId());
		this.setNombre(adminEdit.getNombre());
		this.setApellido(adminEdit.getApellido());
		this.setGenero(adminEdit.getGenero());
		this.setEspecialidad(adminEdit.getEspecialidad());
		this.setCorreo(adminEdit.getCorreo());
		this.setDireccion(adminEdit.getDireccion());
		this.setTelf1(adminEdit.getTelf1());
		this.setTelf2(adminEdit.getTelf2());
		this.setEstatura(adminEdit.getEstatura());
		this.setPeso(adminEdit.getPeso());
		this.setFechaNac(adminEdit.getFecha_nac());
		this.setContrasena(adminEdit.getContrasena());
		this.setPreguntaSeguridad(adminEdit.getPreguntaSeguridad());
		
		return "../admin/profileAdmin.xhtml";
	}
	
	public String actualizarAdmin() {
		
		rol = grl.readRol(rolId);
		gul.updateUsuario(id, nombre, apellido, genero, fechaNac, correo, especialidad, contrasena, telf1, telf2, direccion, peso, estatura, preguntaSeguridad.toLowerCase(), rol);
		return "../admin/profileAdmin.xhtml";
	}
	
	public String eliminarAdmin(String id) {
		
		gul.deleteUsuario(id);	
		return "listAdmin";
	}
	
	public List<Usuario> buscarAdmin() {
		
		admins = gul.getUsuariosPorNombre(filtro);
		return admins;
	}
	
	public List<Usuario> buscarAdminPorId() {
		
		admins = gul.getUsuarioPorId(filtro);
		return admins;
	}
	
}


