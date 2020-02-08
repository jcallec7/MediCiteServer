package vista;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import modelo.Rol;
import negocio.GestionRolLocal;

@ManagedBean
@ViewScoped
public class GestionRolBean {
	
	@Inject
	private GestionRolLocal grl;
	
	private String id;
	private String descripcion;
	private Rol rol;
	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Rol readRol(int id) {
		
		rol = grl.readRol(id);
		return rol;
		
	}
	
	public String createRol() {
		
		grl.createRol(Integer.parseInt(id), descripcion);
		return "createRol";
			
	}

}
