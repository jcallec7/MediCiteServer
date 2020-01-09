package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import modelo.Consulta;
import modelo.Diagnostico;
import modelo.Medico;
import modelo.Usuario;

@Local
public interface GestionConsultaLocal {
	
	public void guardarConsulta(int id, Usuario paciente, Medico medico, Date fecha, Diagnostico diagnostico);
	
	public List<Consulta> getConsultas();
	
	public List<Consulta> getConsultasPorNombre(String filtro);
	
	public void deleteConsulta(int id);
	
	public Consulta readConsulta(int id);
	
	public void updateConsulta(int id, Usuario paciente, Medico medico, Date fecha, Diagnostico diagnostico);
	
}
	
