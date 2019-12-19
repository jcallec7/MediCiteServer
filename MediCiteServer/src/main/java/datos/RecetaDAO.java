package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
		
		Receta c = em.find(Receta.class, id);
		
		return null;
		
	}
	
	public List<Receta> getReceta() {
		
		String jpql = "SELECT c FROM Cliente c";
		Query q = em.createQuery(jpql, Receta.class);
		
		List<Receta> receta = q.getResultList();	
		
		return receta;
	}
	
	
	public List<Receta> getRecetaXNombre(String filtro){
		String jpql = "SELECT a FROM Cliente a WHERE bib_cli_nombre LIKE ?1";
		Query q = em.createQuery(jpql, Receta.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Receta> receta = q.getResultList();
		
		return receta;
	}

}

