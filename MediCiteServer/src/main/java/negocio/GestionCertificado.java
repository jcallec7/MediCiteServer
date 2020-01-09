package negocio;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CertificadoDAO;
import datos.ConsultaDAO;
import modelo.Certificado;
import modelo.Consulta;
import modelo.Diagnostico;
import modelo.Medico;
import modelo.Paciente;

@Stateless
public class GestionCertificado implements GestionCertificadoLocal, GestionCertificadoRemote{
	
	@Inject
	private CertificadoDAO dao;
	
	@Inject
	private ConsultaDAO daoConsulta;
	
	private List<Certificado> certificados = new ArrayList<Certificado>();
	
	
	public void guardarCertificado(int id, Date fecha, Consulta consulta, String descripcion) {
		Certificado c = new Certificado();
		c.setId(id);
		c.setFecha(fecha);
		c.setConsulta(consulta);
		c.setDescripcion(descripcion);
		System.out.println(c);
		certificados.add(c);
		dao.insert(c);
	}
	
	public List<Certificado> getCertificados(){
		System.out.println(certificados);
		daoConsulta.getConsultas();
		return dao.getCertificado();
	}
	
	public List<Certificado> getCertificadoPorId(String filtro) {
		return dao.getCertificadoXId(filtro);
	}
	
	public void deleteCertificado(int id) {
		dao.remove(id);
	}
	
	public Certificado readCertificado(int id) {
		Certificado certificado = dao.read(id);
		System.out.println(certificado);
		return certificado;
	}
	
	public void updateCertificado(int id, Date fecha, Consulta consulta, String descripcion) {
		Certificado c = new Certificado();
		c.setId(id);
		c.setFecha(fecha);
		c.setConsulta(consulta);
		c.setDescripcion(descripcion);
		System.out.println(c);
		dao.update(c);
	}

	
	
}




