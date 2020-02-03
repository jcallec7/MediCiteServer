package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Archivo;

@Stateless
public class ArchivoDAO {
	
	@Inject
	private EntityManager em;
	
	
	public void insert(Archivo archivo) {
		em.persist(archivo);
		
	}
	
	public void update(Archivo archivo) {
		em.merge(archivo);
		
	}
	
	public void remove(int id) {
		
		Archivo archivo = this.read(id);
		em.remove(archivo);
		
	}
	
	public Archivo read(int id) {
		
		Archivo m = em.find(Archivo.class, id);
		
		return m;
		
	}
	
	public List<Archivo> getArchivo() {
		
		String jpql = "SELECT m FROM Archivo m";
		Query q = em.createQuery(jpql, Archivo.class);
		
		List<Archivo> Archivos = q.getResultList();	
		
		return Archivos;
	}
	
	
	public List<Archivo> getArchivoXNombre(String filtro){
		String jpql = "SELECT m FROM Archivo m WHERE mc_arc_nombre LIKE ?1";
		Query q = em.createQuery(jpql, Archivo.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Archivo> Archivos = q.getResultList();
		
		return Archivos;
	}
}
