package vista;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import modelo.Medico;
import negocio.GestionMedicoLocal;

@ManagedBean
@SessionScoped
public class GestionLoginBean {
	
	@Inject
	private GestionMedicoLocal gml;
	
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
		
		Medico medico=this.validarLoginMedico();
		
		if(medico != null) {
			
			return "indexMedico";
		}
		
		return "loginFailed";
	}
	
	public Medico validarLoginMedico() {
		
		List<Medico> medicos =new ArrayList<Medico>();
		medicos= this.gml.getMedico();
		for(Medico m: medicos) {
			if(m.getCorreo().equals(this.getCorreo()) && m.getContrasena().equals(this.getContrasena())) {
				return m;
			}
		}
		return null;
	}
	
	

}
