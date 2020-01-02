package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.RecetaDAO;
import modelo.Medico;
import modelo.Receta;

@Stateless
public class GestionReceta implements GestionRecetaLocal, GestionRecetaRemote {

	@Inject
	private RecetaDAO dao;
	
	private List<Receta> recetas = new ArrayList<Receta>();
	
	public void guardarReceta(int id, String descr) {
		Receta rec = new Receta();
		rec.setId(id);
		rec.setDescr(descr);
		System.out.println(rec);
		dao.insert(rec);
		recetas.add(rec);
	}
	
	public Receta leerReceta(int id){
		
		Receta receta = dao.read(id);
		System.out.print(receta);
		
		return receta;
		
	}
	
	
	public void editarReceta(int id, String descr) {
		Receta rec = new Receta();
		rec.setId(id);
		rec.setDescr(descr);
		System.out.println(rec);
		dao.update(rec);
	}

	public List<Receta> getReceta() {
		System.out.println(recetas);
		return dao.getReceta();
	}

	public List<Receta> getRecetasPorNombre(String filtro) {
		return dao.getRecetaXNombre(filtro);
	}

	
	public List<Receta> getRecetasPorId(String filtro) {
		return dao.getRecetaXId(filtro);
	}
	
	public void delateReceta(int id) {
		dao.remove(id);
	}

}
