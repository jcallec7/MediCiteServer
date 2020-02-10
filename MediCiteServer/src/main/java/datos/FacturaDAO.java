package datos;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Consulta;
import modelo.Factura;
import negocio.GestionConsultaLocal;


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
		c.getConsulta();
		c.getConsulta().getMedico();
		c.getConsulta().getUsuario();
		return c;
		
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

	public List<Factura> getFacturasXId(String filtro) {
		
		String jpql = "SELECT f FROM Factura f";
		Query q = em.createQuery(jpql, Factura.class);
		//q.setParameter(1, "%" + filtro + "%");
		

		List<Factura> facturas = q.getResultList();
		
		List<Factura> facturas2 = new ArrayList<Factura>();
		
		List<Consulta> consultas = new ArrayList<Consulta>();
		
		for(Factura f: facturas) {
			consultas.add(f.getConsulta());
			if(consultas.get(consultas.size() - 1).getMedico().getId().equals(filtro) || consultas.get(consultas.size() - 1).getUsuario().getId().equals(filtro)) {
				facturas2.add(f);
			}
		}
				
		
		//List<Factura> facturas2 = new ArrayList<Factura>();
		
		System.out.println("consultas recuperadas" + facturas2);

		return facturas2;
	}
	

}

