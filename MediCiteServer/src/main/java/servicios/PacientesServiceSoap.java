package servicios;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.Paciente;
import negocio.GestionPacienteLocal;

@WebService
public class PacientesServiceSoap {

	@Inject
	private GestionPacienteLocal gpl;
	
	@WebMethod
	public Respuesta crearPaciente(Paciente paciente) {
		
		Respuesta respuesta = new Respuesta();
		try {
			gpl.guardarPaciente(paciente.getId(), paciente.getNombre(), paciente.getApellido(), paciente.getGenero(), paciente.getFecha_nac(), paciente.getCorreo(), paciente.getContrasena(), paciente.getTelf1(), paciente.getTelf2(), paciente.getDireccion(), paciente.getPeso(), paciente.getEstatura(), paciente.getRol());
			respuesta.setCodigo(1);
			respuesta.setMensaje("AL PELOO");
		} catch(Exception e) {
			respuesta.setCodigo(99);
			respuesta.setMensaje("ERROR ALV");
		}
		
		return respuesta;	
	}
	
	@WebMethod
	public List<Paciente> listadoPacientes() {
		return gpl.getPacientes();
	}
	
	
}
