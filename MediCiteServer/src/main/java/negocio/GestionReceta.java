package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.RecetaDAO;
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
	}

	
	public List<Receta> getReceta() {
		System.out.println(recetas);
		return dao.getReceta();
	}

	public List<Receta> getRecetasPorNombre(String filtro) {
		return dao.getRecetaXNombre(filtro);
	}

}
