package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import modelo.Consulta;
import modelo.Diagnostico;
import modelo.Usuario;

@Remote
public interface GestionConsultaRemote {

	public void guardarConsulta(int id, Usuario paciente, Usuario medico, String estado, Date fecha, Diagnostico diagnostico);

	public List<Consulta> getConsultas();

	public List<Consulta> getConsultasPorNombre(String filtro);

	public void deleteConsulta(int id);

	public Consulta readConsulta(int id);

	public void updateConsulta(int id, Usuario paciente, Usuario medico, String estado, Date fecha, Diagnostico diagnostico);

}
