package vista;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import modelo.Usuario;
import modelo.Rol;
import negocio.GestionUsuarioLocal;
import utils.Session;
import negocio.GestionRolLocal;

@ManagedBean
@ViewScoped
public class GestionUsuarioBean {

	@Inject
	private GestionUsuarioLocal gul;
	@Inject
	private GestionRolLocal grl;

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
	private String preguntaSeguridad;
	private int rolId = 4;
	private Rol rol;

	private HttpSession session = Session.getSession();
	private Usuario miUsuario = (Usuario) session.getAttribute("user");

	private List<Usuario> usuarios;

	private String filtro;
	private Usuario editUsuario;
	private Usuario recuperado = null;
	private UIComponent mybutton;

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

	public Usuario getEditUsuario() {
		return editUsuario;
	}

	public void setEditUsuario(Usuario editedUsuario) {
		this.editUsuario = editedUsuario;
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

	public void listUsuario() {
		this.usuarios = this.gul.getUsuarios();
	}

	public Usuario getUsuarioEdit() {
		return editUsuario;
	}

	public void setUsuarioEdit(Usuario editUsuario) {
		this.editUsuario = editUsuario;
	}

	public Usuario getRecuperado() {
		return recuperado;
	}

	public void setRecuperado(Usuario recuperado) {
		this.recuperado = recuperado;
	}
	

	public UIComponent getMybutton() {
		return mybutton;
	}

	public void setMybutton(UIComponent mybutton) {
		this.mybutton = mybutton;
	}

	public String guardarUsuario() {

		rol = grl.readRol(rolId);
		gul.guardarUsuario(id, nombre, apellido, genero, fecha_nac, correo, especialidad, contrasena, telf1, telf2,
				direccion, peso, estatura, preguntaSeguridad.toLowerCase(), rol);
		usuarios = gul.getUsuarios();
		return "login";

	}

	public String editarUsuario(String id) {

		this.editUsuario = gul.readUsuario(id);

		this.setId(editUsuario.getId());
		this.setNombre(editUsuario.getNombre());
		this.setApellido(editUsuario.getApellido());
		this.setGenero(editUsuario.getGenero());
		this.setEspecialidad(editUsuario.getEspecialidad());
		this.setCorreo(editUsuario.getCorreo());
		this.setDireccion(editUsuario.getDireccion());
		this.setTelf1(editUsuario.getTelf1());
		this.setTelf2(editUsuario.getTelf2());
		this.setEstatura(editUsuario.getEstatura());
		this.setPeso(editUsuario.getPeso());
		this.setFecha_nac(editUsuario.getFecha_nac());
		this.setContrasena(editUsuario.getContrasena());
		this.setPreguntaSeguridad(editUsuario.getPreguntaSeguridad());

		return "../paciente/profilePaciente.xhtml";
	}
	
	public String comprobarRespuesta() {
		
		recuperado = gul.getUsuarioPorCorreo(this.getCorreo(), this.getPreguntaSeguridad().toLowerCase());
		
		if(recuperado != null) {
			
			FacesMessage message = new FacesMessage("¡Datos correctos!");
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(mybutton.getClientId(context), message);
	        
			return null;
			
		}
		 
		FacesMessage message = new FacesMessage("¡Pregunta o correo incorrecto!");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(mybutton.getClientId(context), message);
		return "recuperarContraseña";
	}

	public String recuperarContraseña() {
		
		rol = grl.readRol(rolId);

		gul.updateUsuario(recuperado.getId(), recuperado.getNombre(), recuperado.getApellido(),
				recuperado.getGenero(), recuperado.getFecha_nac(), recuperado.getCorreo(),
				recuperado.getEspecialidad(), this.getContrasena(), recuperado.getTelf1(),
				recuperado.getTelf2(), recuperado.getDireccion(), recuperado.getPeso(),
				recuperado.getEstatura(), recuperado.getPreguntaSeguridad(), rol);
		
		return "login.xhtml";
		
	}
	
	public String eliminarUsuario(String id) {
		
		gul.deleteUsuario(id);	
		return "listPaciente";
	}

	public String updateUsuario() {

		rol = grl.readRol(rolId);
		gul.updateUsuario(id, nombre, apellido, genero, fecha_nac, correo, especialidad, contrasena, telf1, telf2,
				direccion, peso, estatura, preguntaSeguridad.toLowerCase(), rol);

		return "../paciente/profilePaciente.xhtml";
	}
}
