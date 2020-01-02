package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Paciente;

@Stateless
public class PacienteDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Paciente Paciente) {
		em.persist(Paciente);
		
	}
	
	public void update(Paciente Paciente) {
		em.merge(Paciente);	
	}
	
	public void remove(String id) {
		
		Paciente Paciente = this.read(id);
		
		em.remove(Paciente);
		
	}
	
	public Paciente read(String id) {
		
		Paciente a = em.find(Paciente.class, id);
		
		return a;
		
	}
	
	public List<Paciente> getPacientes() {
		
		String jpql = "SELECT c FROM Paciente c";
		Query q = em.createQuery(jpql, Paciente.class);
		
		List<Paciente> Pacientes = q.getResultList();	
		
		return Pacientes;
	}
	
	public List<Paciente> getPacientesXNombre(String filtro){
		String jpql = "SELECT a FROM Paciente a WHERE mc_pa_nombre LIKE ?1 OR mc_pa_apellido LIKE ?1";
		Query q = em.createQuery(jpql, Paciente.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Paciente> Pacientes = q.getResultList();
		
		return Pacientes;
	}

}

