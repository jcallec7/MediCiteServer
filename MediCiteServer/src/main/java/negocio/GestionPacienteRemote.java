package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import modelo.Paciente;

@Remote	
public interface GestionPacienteRemote {
	
	public void guardarPaciente(String id, String nombre, String apellido, String genero, 
								Date fecha_nac, String correo, String contrasena, String telf1, 
								String telf2, String direccion, String peso, String estatura);
	
	public List<Paciente> getPacientes();

}
