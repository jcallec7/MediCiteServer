package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Detalle;
import modelo.Diagnostico;
import modelo.Receta;

@Stateless
public class DetalleDAO {

	@Inject
	private EntityManager em;

	public void insert(Detalle detalle) {
		em.persist(detalle);
	}

	public void update(Detalle detalle) {
		em.merge(detalle);
	}

	public void remove(int id) {

		Detalle detalle = this.read(id);
		em.remove(detalle);

	}

	public Detalle read(int id) {
		Detalle d = em.find(Detalle.class, id);
		return d;

	}

	public List<Detalle> getDetalles() {

		String jpql = "SELECT c FROM Detalle c";
		Query q = em.createQuery(jpql, Detalle.class);
		List<Detalle> detalles = q.getResultList();

		return detalles;
	}

	public List<Detalle> getDetallesXNombre(String filtro) {
		String jpql = "SELECT a FROM Detalle a WHERE mc_det_id LIKE ?1";
		Query q = em.createQuery(jpql, Detalle.class);
		q.setParameter(1, "%" + filtro + "%");

		List<Detalle> detalles = q.getResultList();

		return detalles;
	}

	public int getLastId() {
		String jpql = "SELECT r FROM Detalle r";
		Query q = em.createQuery(jpql, Detalle.class);
		
		List<Diagnostico> detalles = q.getResultList();
		if(detalles.size() == 0) {
			return 0;
		} else {
			return detalles.get(detalles.size() - 1).getId();
		}
	}
	
}
