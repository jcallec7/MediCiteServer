package negocio;

import java.util.List;

import javax.ejb.Local;

import modelo.Medico;

@Local
public interface GestionMedicoLocal {
	
	public void guardarMedico(int id, String nombre, String apellido, String genero, String especialidad, String correo, String direccion, String fechaNac);
	public List<Medico> getMedico();
	public List<Medico> getMedicoPorNombre(String filtro);

}
