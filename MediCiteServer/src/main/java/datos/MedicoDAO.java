package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Medico;



@Stateless
public class MedicoDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Medico medico) {
		em.persist(medico);
		
	}
	
	public void update(Medico medico) {
		em.merge(medico);
		
	}
	
	public void remove(int id) {
		
		Medico medico = this.read(id);
		
		em.remove(medico);
		
	}
	
	public Medico read(int id) {
		
		Medico m = em.find(Medico.class, id);
		
		return null;
		
	}
	
	public List<Medico> getMedico() {
		
		String jpql = "SELECT c FROM Medico c";
		Query q = em.createQuery(jpql, Medico.class);
		
		List<Medico> Medicos = q.getResultList();	
		
		return Medicos;
	}
	
	
	public List<Medico> getMedicoXNombre(String filtro){
		String jpql = "SELECT a FROM Medico a WHERE mc_med_nombre LIKE ?1 OR mc_med_apellido LIKE ?1 OR mc_med_especialidad LIKE ?1";
		Query q = em.createQuery(jpql, Medico.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Medico> Medicos = q.getResultList();
		
		return Medicos;
		
	}

}

