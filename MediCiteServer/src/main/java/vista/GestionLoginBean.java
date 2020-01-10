package vista;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import modelo.Usuario;
import negocio.GestionUsuarioLocal;

@ManagedBean
@SessionScoped
public class GestionLoginBean {
	
	@Inject
	private GestionUsuarioLocal gul;
	
	private String correo;
	private String contrasena;
	
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
	
	
	public String iniciarSesion() {
		
		Usuario usuario=this.validarLogin();
		
		if(usuario != null) {
			
			int rol = usuario.getRol().getId();
			
			switch(rol){
			
				case 1:
					
					return "indexAdmin";
					
				case 2:
							
					return "indexSecretario";
					
				case 3:
					
					return "indexMedico";			
					
				case 4:
							
					return "indexPaciente";	
					
				default:
					break;
			}
		}
		
		return "loginFailed";
	}
	
	public Usuario validarLogin() {
		
		List<Usuario> usuarios =new ArrayList<Usuario>();
		usuarios= this.gul.getUsuarios();
		for(Usuario m: usuarios) {
			if(m.getCorreo().equals(this.getCorreo()) && m.getContrasena().equals(this.getContrasena())) {
				return m;
			}
		}
		return null;
	}
	
	

}
