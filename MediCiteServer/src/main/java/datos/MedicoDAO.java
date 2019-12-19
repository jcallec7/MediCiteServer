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
		
		String jpql = "SELECT c FROM Cliente c";
		Query q = em.createQuery(jpql, Medico.class);
		
		List<Medico> clientes = q.getResultList();	
		
		return clientes;
	}
	
	public List<Medico> getMedicoXNombre(String filtro){
		String jpql = "SELECT a FROM Cliente a WHERE bib_cli_nombre LIKE ?1";
		Query q = em.createQuery(jpql, Medico.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Medico> clientes = q.getResultList();
		
		return clientes;
	}

}

