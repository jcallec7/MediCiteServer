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
		
		return null;
		
	}
	
	public List<Certificado> getCertificado() {
		
		String jpql = "SELECT c FROM Cliente c";
		Query q = em.createQuery(jpql, Certificado.class);
		
		List<Certificado> certificado = q.getResultList();	
		
		return certificado;
	}
	
	
	public List<Certificado> getCertificadoXNombre(String filtro){
		String jpql = "SELECT a FROM Cliente a WHERE bib_cli_nombre LIKE ?1";
		Query q = em.createQuery(jpql, Certificado.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Certificado> certificado = q.getResultList();
		
		return certificado;
	}

}

