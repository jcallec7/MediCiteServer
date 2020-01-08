package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import datos.RolDAO;
import modelo.Medico;
import modelo.Rol;

public class GestionRol implements GestionRolLocal {
	
	@Inject
	private RolDAO dao;

	private List<Rol> rol = new ArrayList<Rol>();
	
	
	
	public List<Rol> getRol() {
		return rol;
	}



	public void setRol(List<Rol> rol) {
		this.rol = rol;
	}



	public void createRol(int id, String descripcion){
		
		Rol rol = new Rol();
		
		rol.setId(id);
		rol.setDescripcion(descripcion);
		
		dao.insert(rol);
		
	}
	
	public Rol readRol(int id){
		
		Rol rol = dao.read(id);
		System.out.print(rol);
		
		return rol;
		
	}
	
	

}
