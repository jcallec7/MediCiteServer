package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
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

	public List<Usuario> getUsuariosPorNombre(String filtro) {
		String jpql = "SELECT a FROM Usuario a WHERE mc_usr_nombre LIKE ?1 OR mc_usr_apellido LIKE ?1";
		Query q = em.createQuery(jpql, Usuario.class);
		q.setParameter(1, "%" + filtro + "%");

		List<Usuario> Usuarios = q.getResultList();

		return Usuarios;
	}

	public List<Usuario> getUsuarioPorId(String filtro) {
		String jpql = "SELECT a FROM Usuario a WHERE mc_usr_id LIKE ?1";
		Query q = em.createQuery(jpql, Usuario.class);
		q.setParameter(1, "%" + filtro + "%");

		List<Usuario> Usuarios = q.getResultList();

		return Usuarios;

	}

	public List<Usuario> getUsuarioPorRol(int filtro) {
		String jpql = "SELECT a FROM Usuario a WHERE mc_usr_rol LIKE ?1";
		Query q = em.createQuery(jpql, Usuario.class);
		q.setParameter(1, "%" + filtro + "%");

		List<Usuario> Usuarios = q.getResultList();

		return Usuarios;

	}

	public Usuario getUsuarioPorCorreo(String filtro, String filtro2) {
		
		String jpql = "SELECT a FROM Usuario a WHERE mc_usr_correo LIKE ?1 AND mc_usr_preguntaSeguridad LIKE ?2";
		Query q = em.createQuery(jpql, Usuario.class);
		q.setParameter(1, "%" + filtro + "%");
		q.setParameter(2, "%" + filtro2 + "%");
		
		try{
			Usuario usuario = (Usuario) q.getSingleResult();
			System.out.print(usuario);

			return usuario;
			
		}catch(NonUniqueResultException nure){
			
		}catch(NoResultException nre) {
			
		}
		
		return null;
		
	}

}
