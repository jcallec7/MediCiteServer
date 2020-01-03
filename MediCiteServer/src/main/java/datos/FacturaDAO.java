package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Factura;



@Stateless
public class FacturaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Factura factura) {
		em.persist(factura);
		
	}
	
	public void update(Factura factura) {
		em.merge(factura);
		
	}
	
	public void remove(int id) {
		
		Factura factura = this.read(id);
		
		em.remove(factura);
		
	}
	
	public Factura read(int id) {
		
		Factura c = em.find(Factura.class, id);
		
		return null;
		
	}
	
	public List<Factura> getFactura() {
		
		String jpql = "SELECT c FROM Factura c";
		Query q = em.createQuery(jpql, Factura.class);
		
		List<Factura> Factura = q.getResultList();	
		
		return Factura;
	}
	
	
	public List<Factura> getFacturaXNombre(String filtro){
		String jpql = "SELECT a FROM Factura a WHERE  LIKE ?1";
		Query q = em.createQuery(jpql, Factura.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Factura> Factura = q.getResultList();
		
		return Factura;
	}


}

