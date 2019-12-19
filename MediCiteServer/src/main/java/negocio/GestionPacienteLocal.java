package negocio;

import java.util.List;

import javax.ejb.Local;

import modelo.Paciente;

@Local
public interface GestionPacienteLocal {
	
	public void guardarPaciente(String id, String nombre, String apellido, String cedula, String genero, 
								String fecha_nac, String correo, String contrasena, String telf1, 
								String telf2, String direccion, String peso, String estatura);
	
	public List<Paciente> getPacientes();
	
	public List<Paciente> getPacientesPorId(String filtro);
	
}
	
