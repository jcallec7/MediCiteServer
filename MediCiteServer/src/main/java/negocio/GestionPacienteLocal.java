package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import modelo.Paciente;

@Local
public interface GestionPacienteLocal {
	
	public void guardarPaciente(String id, String nombre, String apellido, String genero, 
								Date fecha_nac, String correo, String contrasena, String telf1, 
								String telf2, String direccion, String peso, String estatura);
	
	public List<Paciente> getPacientes();
	
	public List<Paciente> getPacientesPorNombre(String filtro);
	
	public void deletePaciente(String id);
	
	public Paciente readPaciente(String id);
	
	public void updatePaciente(String id, String nombre, String apellido, String genero,
			Date fecha_nac, String correo, String contrasena, String telf1, String telf2, String direccion,
			String peso, String estatura);
	
}
	
