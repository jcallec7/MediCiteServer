package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Consulta;

@Stateless
public class ConsultaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Consulta Consulta) {
		em.persist(Consulta);
		
	}
	
	public void update(Consulta Consulta) {
		em.merge(Consulta);
		
	}
	
	public void remove(int id) {
		
		Consulta Consulta = this.read(id);
		
		em.remove(Consulta);
		
	}
	
	public Consulta read(int id) {
		
		Consulta a = em.find(Consulta.class, id);
		
		return null;
		
	}
	
	public List<Consulta> getConsultas() {
		
		String jpql = "SELECT c FROM Consulta c";
		Query q = em.createQuery(jpql, Consulta.class);
		
		List<Consulta> Consultas = q.getResultList();	
		
		return Consultas;
	}
	
	public List<Consulta> getConsultasXNombre(String filtro){
		String jpql = "SELECT a FROM Consulta a WHERE mc_cons_id LIKE ?1";
		Query q = em.createQuery(jpql, Consulta.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Consulta> Consultas = q.getResultList();
		
		return Consultas;
	}

}

