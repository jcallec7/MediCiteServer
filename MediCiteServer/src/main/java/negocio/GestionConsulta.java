package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.ConsultaDAO;
import datos.DiagnosticoDAO;
import datos.MedicoDAO;
import datos.UsuarioDAO;
import modelo.Consulta;
import modelo.Diagnostico;
import modelo.Medico;
import modelo.Usuario;

import java.util.ArrayList;
import java.util.Date;

@Stateless
public class GestionConsulta implements GestionConsultaRemote, GestionConsultaLocal{

	@Inject
	private ConsultaDAO dao;
	
	@Inject
	private UsuarioDAO daoUsuario;
	
	@Inject
	private MedicoDAO daoMedico;
	
	@Inject
	private DiagnosticoDAO daoDiagnostico;

	private List<Consulta> consultas = new ArrayList<Consulta>();

	public void guardarConsulta(int id, Usuario usuario, Medico medico, Date fecha, Diagnostico diagnostico) {

		Consulta c = new Consulta();
		//c.setId(id);
		c.setUsuario(usuario);
		c.setMedico(medico);
		c.setFecha(fecha);
		//c.setDiagnostico(null);
		consultas.add(c);
		// System.out.println(c);
		dao.insert(c);
	}

	public List<Consulta> getConsultas() {
		System.out.println(consultas);
		daoUsuario.getUsuarios();
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
	
	public void updateConsulta(int id, Usuario usuario, Medico medico, Date fecha, Diagnostico diagnostico) {		
		Consulta c = new Consulta();
		c.setId(id);
		
		dao.update(c);
	}

}
