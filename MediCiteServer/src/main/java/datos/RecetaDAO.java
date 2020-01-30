package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Diagnostico;
import modelo.Receta;



@Stateless
public class RecetaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Receta receta) {
		em.persist(receta);
		
	}
	
	public void update(Receta receta) {
		em.merge(receta);
		
	}
	
	public void remove(int id) {
		
		Receta receta = this.read(id);
		
		em.remove(receta);
		
	}
	
	public Receta read(int id) {
		
		Receta r = em.find(Receta.class, id);
		r.getDetalle().size();
		return r;
		
	}
	
	public List<Receta> getReceta() {
		
		String jpql = "SELECT r FROM Receta r";
		Query q = em.createQuery(jpql, Receta.class);
		
		List<Receta> Recetas = q.getResultList();	
		
		
		return Recetas;
	}
	
	
	public List<Receta> getRecetaXNombre(String filtro){
		String jpql = "SELECT a FROM Receta a WHERE mc_rec_descr LIKE ?1";
		Query q = em.createQuery(jpql, Receta.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Receta> Recetas = q.getResultList();
		
		return Recetas;
	}
	
	public List<Receta> getRecetaXId(String filtro){
		String jpql = "SELECT a FROM Receta a WHERE mc_rec_id LIKE ?1";
		Query q = em.createQuery(jpql, Receta.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Receta> Recetas = q.getResultList();
		
		return Recetas;
	}
	
	public int getLastId() {
		String jpql = "SELECT r FROM Receta r";
		Query q = em.createQuery(jpql, Receta.class);
		
		List<Diagnostico> recetas = q.getResultList();
		if(recetas.size() == 0) {
			return 0;
		} else {
			return recetas.get(recetas.size() - 1).getId();
		}			
		
	}

}

