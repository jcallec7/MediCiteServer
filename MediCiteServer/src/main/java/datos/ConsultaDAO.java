package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Consulta;

@Stateless
public class ConsultaDAO {

	@Inject
	private EntityManager em;

	public void insert(Consulta consulta) {
		em.persist(consulta);

	}

	public void update(Consulta consulta) {
		em.merge(consulta);
	}

	public void remove(int id) {

		Consulta consulta = this.read(id);
		em.remove(consulta);

	}

	public Consulta read(int id) {

		Consulta a = em.find(Consulta.class, id);
		a.getMedico();
		a.getUsuario();
		return a;

	}

	public List<Consulta> getConsultas() {

		String jpql = "SELECT c FROM Consulta c";
		Query q = em.createQuery(jpql, Consulta.class);

		List<Consulta> consultas = q.getResultList();

		return consultas;
	}

	public List<Consulta> getConsultasXNombre(String filtro) {
		String jpql = "SELECT a FROM Consulta a WHERE mc_med_id LIKE ?1 OR mc_pa_id LIKE ?1";
		Query q = em.createQuery(jpql, Consulta.class);
		q.setParameter(1, "%" + filtro + "%");

		List<Consulta> consultas = q.getResultList();

		return consultas;
	}

	public List<Consulta> getConsultasXId(String filtro) {
		String jpql = "SELECT c FROM Consulta c WHERE mc_pa_id LIKE ?1 OR mc_med_id LIKE ?1";
		Query q = em.createQuery(jpql, Consulta.class);
		q.setParameter(1, "%" + filtro + "%");

		List<Consulta> consultas = q.getResultList();
		
		System.out.println("consultas recuperadas" + consultas);

		return consultas;
	}
	
}
