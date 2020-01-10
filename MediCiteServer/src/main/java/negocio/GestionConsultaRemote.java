package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import modelo.Consulta;
import modelo.Diagnostico;
import modelo.Usuario;

@Remote	
public interface GestionConsultaRemote {
	
	public void guardarConsulta(int id, Usuario paciente, Usuario medico, Date fecha, Diagnostico diagnostico);
	
	public List<Consulta> getConsultas();

}
