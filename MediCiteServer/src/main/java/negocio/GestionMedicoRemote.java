package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import modelo.Medico;

@Remote	
public interface GestionMedicoRemote {
	
	public void guardarMedico(String id, String nombre, String apellido, String genero, String especialidad, String correo, String direccion,  Date fechaNac, String contrasena);
	public void editarMedico(String id);
	public void eliminarMedico(String id);
	public List<Medico> getMedico();
	public List<Medico> getMedicoPorNombre(String filtro);
	public List<Medico> getMedicoPorId(String filtro);

}
