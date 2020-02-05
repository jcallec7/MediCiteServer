package vista;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import modelo.Usuario;
import modelo.Rol;
import negocio.GestionUsuarioLocal;
import utils.Session;
import negocio.GestionRolLocal;


@ManagedBean
public class GestionUsuarioBean {

	@Inject
	private GestionUsuarioLocal gul;
	@Inject
	private GestionRolLocal grl;
	@Inject
	private GestionConsultaBean gcb;

	/* Beans properties */
	private String id;
	private String nombre;
	private String apellido;
	private String genero;
	private Date fecha_nac;
	private String correo;
	private String especialidad;
	private String contrasena;
	private String telf1;
	private String telf2;
	private String direccion;
	private String peso;
	private String estatura;
	private int rolId = 4;
	private Rol rol;
	
	private HttpSession session = Session.getSession();
	private Usuario miUsuario = (Usuario) session.getAttribute("user");

	private List<Usuario> usuarios;
	
	private String filtro;
	private String selectedUsuarioId;
	private String selectedUsuarioId2;
	private Usuario editedUsuario;
	
	@PostConstruct
	public void init() {
		listUsuario();
	}

	public GestionUsuarioLocal getGul() {
		return gul;
	}

	public void setGul(GestionUsuarioLocal gul) {
		this.gul = gul;
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

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public GestionRolLocal getGrl() {
		return grl;
	}

	public void setGrl(GestionRolLocal grl) {
		this.grl = grl;
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

	public Usuario getEditedUsuario() {
		return editedUsuario;
	}

	public void setEditedUsuario(Usuario editedUsuario) {
		this.editedUsuario = editedUsuario;
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

	public String guardarUsuario() {
		
		rol = grl.readRol(rolId);
		gul.guardarUsuario(id, nombre, apellido, genero, fecha_nac, correo, especialidad, contrasena, telf1, telf2, direccion, peso, estatura, rol);
		usuarios = gul.getUsuarios();
		return null;
		
	}
	
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Usuario> buscarUsuario() {
		
		usuarios = gul.getUsuariosPorNombre(filtro);
		
		return usuarios;
	}
	
	public String editUsuarioById() {
		
		selectedUsuarioId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedUsuarioId");
		System.out.println(selectedUsuarioId);
		editedUsuario = gul.readUsuario(selectedUsuarioId);
		return "updateUsuario";
		
	}
	
	public String deleteUsuario() {
		
		selectedUsuarioId2 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedUsuarioId2");
		System.out.println(selectedUsuarioId2);
		gul.deleteUsuario(selectedUsuarioId2);
		return null;
		
	}
	
	public void listUsuario() {
		this.usuarios = this.gul.getUsuarios();
	}

	public String updateUsuario() {
		gul.updateUsuario(id, nombre, apellido, genero, fecha_nac, correo, especialidad, contrasena, telf1, telf2, direccion, peso, estatura, rol);
		return "listUsuario";
		
	}
	
	public String Pages() {
		
		gcb.setMiUsuario(miUsuario);
		return "createConsultaPaciente.xhtml";
	}
	
}
