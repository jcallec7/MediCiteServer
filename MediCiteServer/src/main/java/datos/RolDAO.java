package datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelo.Rol;

@Stateless
public class RolDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Rol rol) {
		em.persist(rol);
		
	}
	
	public void update(Rol rol) {
		em.merge(rol);
		
	}
	
	public void remove(int id) {
		
		Rol rol = this.read(id);
		
		em.remove(rol);

	}
	
	public Rol read(int id) {
		
		Rol m = em.find(Rol.class, id);
		
		return m;
		
	}

}
