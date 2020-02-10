package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import modelo.Consulta;
import modelo.Diagnostico;
import modelo.Usuario;

@Local
public interface GestionConsultaLocal {
	
	public void guardarConsulta(int id, Usuario usuario, Usuario medico, String estado, Date fecha, Diagnostico diagnostico);
	
	public List<Consulta> getConsultas();
	
	public List<Consulta> getConsultasPorNombre(String filtro);
	
	public void deleteConsulta(int id);
	
	public Consulta readConsulta(int id);
	
	public void updateConsulta(int id, Usuario paciente, Usuario medico, String estado, Date fecha, Diagnostico diagnostico);
	
	public List<Consulta> getConsultasPorId(String filtro);
	
	public boolean verificarDisponibilidad(String medId, Date fecha);
	
}
	
