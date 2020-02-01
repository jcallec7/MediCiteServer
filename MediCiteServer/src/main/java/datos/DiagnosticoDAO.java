package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Diagnostico;
import modelo.Receta;



@Stateless
public class DiagnosticoDAO{
	
	@Inject
	private EntityManager em;
	
	public void insert(Diagnostico diagnostico) {
		em.persist(diagnostico);
		
	}
	
	public void update(Diagnostico diagnostico) {
		em.merge(diagnostico);
		
	}
	
	public void remove(int id) {
		
		Diagnostico diagnostico = this.read(id);
		
		em.remove(diagnostico);
		
	}
	
	public Diagnostico read(int id) {
		
		Diagnostico c = em.find(Diagnostico.class, id);
		return null;
		
	}
	
	public List<Diagnostico> getDiagnostico() {
		
		String jpql = "SELECT d FROM Diagnostico d";
		Query q = em.createQuery(jpql, Diagnostico.class);
		
		List<Diagnostico> diagnostico = q.getResultList();	
		
		return diagnostico;
	}
	
	
	public List<Diagnostico> getDiagnosticoXId(String filtro){
		String jpql = "SELECT d FROM Diagnostico d WHERE mc_diag_id LIKE ?1";
		Query q = em.createQuery(jpql, Diagnostico.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Diagnostico> diagnostico = q.getResultList();
		
		return diagnostico;
	}
	
	public int getLastId() {
		String jpql = "SELECT r FROM Diagnostico r";
		Query q = em.createQuery(jpql, Diagnostico.class);
		
		List<Diagnostico> Diagnosticos = q.getResultList();
		if(Diagnosticos.size() == 0) {
			return 0;
		} else {
			return Diagnosticos.get(Diagnosticos.size() - 1).getId();
		}			
		
	}

}

