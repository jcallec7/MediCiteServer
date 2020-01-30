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
		
		Medicamento m = em.find(Medicamento.class, id);
		
		return m;
		
	}
	
	public List<Medicamento> getmedicamento() {
		
		String jpql = "SELECT m FROM Medicamento m";
		Query q = em.createQuery(jpql, Medicamento.class);
		
		List<Medicamento> Medicamentos = q.getResultList();	
		
		return Medicamentos;
	}
	
	
	public List<Medicamento> getMedicamentoXNombre(String filtro){
		String jpql = "SELECT m FROM Medicamento m WHERE mc_medic_nombre LIKE ?1";
		Query q = em.createQuery(jpql, Medicamento.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Medicamento> Medicamentos = q.getResultList();
		
		return Medicamentos;
	}

	public List<Medicamento> getMedicamentoXNombreYConcentracion(String nombre, String concentracion){
		String jpql = "SELECT m FROM Medicamento m WHERE mc_medic_nombre = ?1 AND mc_medic_concentr = ?2";
		Query q = em.createQuery(jpql, Medicamento.class);
		q.setParameter(1, nombre);
		q.setParameter(2, concentracion);
		
		List<Medicamento> Medicamentos = q.getResultList();
		
		return Medicamentos;
	}
	
}

