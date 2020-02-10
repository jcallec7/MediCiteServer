package vista;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import modelo.Usuario;
import negocio.GestionUsuarioLocal;
import utils.Session;

import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class GestionLoginBean {
	
	@Inject
	private GestionUsuarioLocal gul;
	
	private String correo;
	private String contrasena;
	private String userName;
	private Usuario usuario = null;
	
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String iniciarSesion() {
		
		usuario=this.validarLogin();
		
		if(usuario != null) {
			
			int rol = usuario.getRol().getId();
			HttpSession session = Session.getSession();
			
			switch(rol){
			
				case 2:
					
					session.setAttribute("user", usuario);
					session.setAttribute("rol", rol);
					this.userName = usuario.getNombre()+" "+usuario.getApellido();
					return "/admin/indexAdmin";
					
				case 3:
					
					session.setAttribute("user", usuario);
					session.setAttribute("rol", rol);
					this.userName = usuario.getNombre()+" "+usuario.getApellido();
					return "/medico/indexMedico";			
					
				case 4:
				
					session.setAttribute("user", usuario);
					session.setAttribute("rol", rol);
					this.userName = usuario.getNombre()+" "+usuario.getApellido();		
					return "/paciente/indexPaciente";	
					
				default:
					break;
			}
		}
		
		return "loginFailed";
	}
	
	public Usuario validarLogin() {
		
		List<Usuario> usuarios =new ArrayList<Usuario>();
		usuarios= this.gul.getUsuarios();
		for(Usuario u: usuarios) {
			if(u.getCorreo().equals(this.getCorreo()) && u.getContrasena().equals(this.getContrasena())) {
				return u;
			}
		}
		return null;
	}
	
	public String cerrarSesion() {
		HttpSession session = Session.getSession();
		session.invalidate();
		return "/publicas/principal.xhtml";
	}
	
}
