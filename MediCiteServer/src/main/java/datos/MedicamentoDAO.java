package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Medicamento;



@Stateless
public class MedicamentoDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Medicamento medicamento) {
		em.persist(medicamento);
		
	}
	
	public void update(Medicamento medicamento) {
		em.merge(medicamento);
		
	}
	
	public void remove(int id) {
		
		Medicamento medicamento = this.read(id);
		
		em.remove(medicamento);
		
	}
	
	public Medicamento read(int id) {
		
		Medicamento c = em.find(Medicamento.class, id);
		
		return null;
		
	}
	
	public List<Medicamento> getmedicamento() {
		
		String jpql = "SELECT c FROM Cliente c";
		Query q = em.createQuery(jpql, Medicamento.class);
		
		List<Medicamento> medicamento = q.getResultList();	
		
		return medicamento;
	}
	
	
	public List<Medicamento> getmedicamentoXNombre(String filtro){
		String jpql = "SELECT a FROM Cliente a WHERE bib_cli_nombre LIKE ?1";
		Query q = em.createQuery(jpql, Medicamento.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Medicamento> medicamento = q.getResultList();
		
		return medicamento;
	}

}

