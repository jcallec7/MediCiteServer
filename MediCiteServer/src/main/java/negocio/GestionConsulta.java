package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.ConsultaDAO;
import datos.DiagnosticoDAO;
import datos.MedicoDAO;
import datos.PacienteDAO;
import modelo.Consulta;
import modelo.Diagnostico;
import modelo.Medico;
import modelo.Paciente;

import java.util.ArrayList;
import java.util.Date;

@Stateless
public class GestionConsulta implements GestionConsultaRemote, GestionConsultaLocal{

	@Inject
	private ConsultaDAO dao;
	
	@Inject
	private PacienteDAO daoPaciente;
	
	@Inject
	private MedicoDAO daoMedico;
	
	@Inject
	private DiagnosticoDAO daoDiagnostico;

	private List<Consulta> consultas = new ArrayList<Consulta>();

	public void guardarConsulta(int id, Paciente paciente, Medico medico, Date fecha, Diagnostico diagnostico) {

		Consulta c = new Consulta();
		//c.setId(id);
		c.setPaciente(paciente);
		c.setMedico(medico);
		c.setFecha(fecha);
		//c.setDiagnostico(null);
		consultas.add(c);
		// System.out.println(c);
		dao.insert(c);
	}

	public List<Consulta> getConsultas() {
		System.out.println(consultas);
		daoPaciente.getPacientes();
		daoMedico.getMedico();
		daoDiagnostico.getDiagnostico();
		return dao.getConsultas();
	}

	public List<Consulta> getConsultasPorNombre(String filtro) {
		return dao.getConsultasXNombre(filtro);
	}
	
	public void deleteConsulta(int id) {
		dao.remove(id);
	}
	
	public Consulta readConsulta(int id) {
		Consulta consulta = dao.read(id);
		return consulta;
	}
	
	public void updateConsulta(int id, Paciente paciente, Medico medico, Date fecha, Diagnostico diagnostico) {		
		Consulta c = new Consulta();
		c.setId(id);
		
		dao.update(c);
	}

}
