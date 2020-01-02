package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.PacienteDAO;
import modelo.Paciente;

import java.util.ArrayList;
import java.util.Date;

@Stateless
public class GestionPaciente implements GestionPacienteRemote, GestionPacienteLocal{

	@Inject
	private PacienteDAO dao;

	private List<Paciente> Pacientes = new ArrayList<Paciente>();

	public void guardarPaciente(String id, String nombre, String apellido, String genero,
								Date fecha_nac, String correo, String contrasena, String telf1, String telf2, String direccion,
								String peso, String estatura) {

		Paciente c = new Paciente();
		c.setId(id);
		c.setNombre(nombre);
		c.setApellido(apellido);
		c.setGenero(genero);
		c.setFecha_nac(fecha_nac);
		c.setCorreo(correo);
		c.setContrasena(contrasena);
		c.setTelf1(telf1);
		c.setTelf2(telf2);
		c.setDireccion(direccion);
		c.setPeso(peso);
		c.setEstatura(estatura);

		Pacientes.add(c);
		// System.out.println(c);
		dao.insert(c);
	}

	public List<Paciente> getPacientes() {
		System.out.println(Pacientes);
		return dao.getPacientes();
	}

	public List<Paciente> getPacientesPorNombre(String filtro) {
		return dao.getPacientesXNombre(filtro);
	}
	
	public void deletePaciente(String id) {
		dao.remove(id);
	}

}
