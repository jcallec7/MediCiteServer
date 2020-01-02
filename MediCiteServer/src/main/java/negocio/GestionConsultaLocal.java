package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import modelo.Consulta;
import modelo.Diagnostico;
import modelo.Medico;
import modelo.Paciente;

@Local
public interface GestionConsultaLocal {
	
	public void guardarConsulta(int id, Paciente paciente, Medico medico, Date fecha, Diagnostico diagnostico);
	
	public List<Consulta> getConsultas();
	
	public List<Consulta> getConsultasPorNombre(String filtro);
	
	public void deleteConsulta(String id);
	
	public Consulta readConsulta(String id);
	
	public void updateConsulta(int id, Paciente paciente, Medico medico, Date fecha, Diagnostico diagnostico);
	
}
	
