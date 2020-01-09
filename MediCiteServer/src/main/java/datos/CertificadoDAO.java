package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Certificado;



@Stateless
public class CertificadoDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Certificado certificado) {
		em.persist(certificado);
		
	}
	
	public void update(Certificado certificado) {
		em.merge(certificado);
		
	}
	
	public void remove(int id) {
		
		Certificado certificado = this.read(id);
		
		em.remove(certificado);
		
	}
	
	public Certificado read(int id) {
		
		Certificado c = em.find(Certificado.class, id);
		
		return c;
		
	}
	
	public List<Certificado> getCertificado() {
		
		String jpql = "SELECT c FROM Certificado c";
		Query q = em.createQuery(jpql, Certificado.class);
		
		List<Certificado> certificados = q.getResultList();	
		
		return certificados;
	}
	
	
	public List<Certificado> getCertificadoXId(String filtro){
		String jpql = "SELECT c FROM Certificado a WHERE mc_cert_id LIKE ?1";
		Query q = em.createQuery(jpql, Certificado.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Certificado> certificados = q.getResultList();
		
		return certificados;
	}

}



