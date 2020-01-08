package negocio;

import modelo.Rol;

public interface GestionRolLocal {
	
	public void createRol(int id, String descripcion);
	public Rol readRol(int id);

}
