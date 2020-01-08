package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import modelo.Paciente;
import modelo.Rol;

@Remote	
public interface GestionPacienteRemote {
	
	public void guardarPaciente(String id, String nombre, String apellido, String genero, 
								Date fecha_nac, String correo, String contrasena, String telf1, 
								String telf2, String direccion, String peso, String estatura, Rol rol);
	
	public List<Paciente> getPacientes();

}
