package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.ConsultaDAO;
import datos.DiagnosticoDAO;
import datos.UsuarioDAO;
import modelo.Consulta;
import modelo.Diagnostico;
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
	private DiagnosticoDAO daoDiagnostico;

	private List<Consulta> consultas = new ArrayList<Consulta>();

	public void guardarConsulta(int id, Usuario usuario, Usuario medico, String estado, Date fecha, Diagnostico diagnostico) {

		Consulta c = new Consulta();
		c.setUsuario(usuario);
		c.setMedico(medico);
		c.setEstado(estado);
		c.setFecha(fecha);
		c.setDiagnostico(diagnostico);
		consultas.add(c);
		System.out.println(c);
		dao.insert(c);
	}

	public List<Consulta> getConsultas() {
		System.out.println(consultas);
		daoUsuario.getUsuarios();
		return dao.getConsultas();
	}

	public List<Consulta> getConsultasPorNombre(String filtro) {
		daoUsuario.getUsuarios();
		return dao.getConsultasXNombre(filtro);
	}
	
	public List<Consulta> getConsultasPorId(String filtro) {
		daoUsuario.getUsuarios();
		return dao.getConsultasXId(filtro);
	}
	
	public void deleteConsulta(int id) {
		dao.remove(id);
	}
	
	public Consulta readConsulta(int id) {
		Consulta consulta = dao.read(id);
		daoUsuario.getUsuarios();
		//consulta.getMedico();
		//consulta.getUsuario();
		daoDiagnostico.getDiagnostico();
		consulta.getDiagnostico();
		return consulta;
	}
	
	public void updateConsulta(int id, Usuario usuario, Usuario medico, String estado, Date fecha, Diagnostico diagnostico) {		
		Consulta c = new Consulta();
		c.setId(id);
		c.setUsuario(usuario);
		c.setMedico(medico);
		c.setEstado(estado);
		c.setFecha(fecha);
		c.setDiagnostico(diagnostico);
		System.out.println(c);
		consultas.add(c);
		dao.update(c);
	}
	
	public void addDiagnostico(int id, Usuario usuario, Usuario medico, String estado, Date fecha, Diagnostico diagnostico) {
		Consulta c = new Consulta();
		c.setId(id);
		c.setUsuario(usuario);
		c.setMedico(medico);
		c.setEstado(estado);
		c.setFecha(fecha);
		c.setDiagnostico(diagnostico);
		dao.update(c);
	}
	
	public boolean verificarDisponibilidad(String medId, String pacId, Date fecha) {
		
		boolean ban = false;
		//java.sql.Timestamp t = new Timestamp(Date.getTime());
		consultas = dao.getConsultasPorFechaYMedico(medId, pacId, fecha);
		
		if(consultas.size() == 0) {
			ban = true;
		}
		
		return ban;
		
	}

}
