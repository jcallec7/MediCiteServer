package negocio;

import java.util.List;

import javax.ejb.Remote;

import modelo.Medico;

@Remote	
public interface GestionMedicoRemote {
	
	public void guardarMedico(int id, String nombre, String apellido, String genero, String especialidad, String correo, String direccion, String fechaNac);
	public List<Medico> getMedico();
	public List<Medico> getMedicoPorNombre(String filtro);

}
