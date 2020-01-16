package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import modelo.Consulta;
import modelo.Diagnostico;
import modelo.Usuario;

@Local
public interface GestionConsultaLocal {
	
	public void guardarConsulta(int id, Usuario usuario, Usuario medico, Date fecha, Diagnostico diagnostico);
	
	public List<Consulta> getConsultas();
	
	public List<Consulta> getConsultasPorNombre(String filtro);
	
	public void deleteConsulta(int id);
	
	public Consulta readConsulta(int id);
	
	public void updateConsulta(int id, Usuario paciente, Usuario medico, Date fecha, Diagnostico diagnostico);
	
	public void addDiagnostico(int id, Usuario usuario, Usuario medico, Date fecha, Diagnostico diagnostico);
	
}
	
