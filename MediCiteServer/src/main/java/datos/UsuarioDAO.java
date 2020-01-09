package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Usuario;

@Stateless
public class UsuarioDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Usuario Usuario) {
		em.persist(Usuario);
		
	}
	
	public void update(Usuario Usuario) {
		em.merge(Usuario);	
	}
	
	public void remove(String id) {
		
		Usuario Usuario = this.read(id);
		
		em.remove(Usuario);
		
	}
	
	public Usuario read(String id) {
		
		Usuario a = em.find(Usuario.class, id);
		
		return a;
		
	}
	
	public List<Usuario> getUsuarios() {
		
		String jpql = "SELECT c FROM Usuario c";
		Query q = em.createQuery(jpql, Usuario.class);
		
		List<Usuario> Usuarios = q.getResultList();	
		
		return Usuarios;
	}
	
	public List<Usuario> getUsuariosXNombre(String filtro){
		String jpql = "SELECT a FROM Usuario a WHERE mc_pa_nombre LIKE ?1 OR mc_pa_apellido LIKE ?1";
		Query q = em.createQuery(jpql, Usuario.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Usuario> Usuarios = q.getResultList();
		
		return Usuarios;
	}

}

