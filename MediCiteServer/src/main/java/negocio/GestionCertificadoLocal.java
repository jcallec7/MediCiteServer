
package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import modelo.Certificado;
import modelo.Consulta;

@Local
public interface GestionCertificadoLocal {
	
	public void guardarCertificado(int id, Date fecha, Consulta consulta, String descripcion);
	public List<Certificado> getCertificados();
	public List<Certificado> getCertificadoPorId(String filtro);
	public void deleteCertificado(int id);
	public Certificado readCertificado(int id);
	public void updateCertificado(int id, Date fecha, Consulta consulta, String descripcion);

}
