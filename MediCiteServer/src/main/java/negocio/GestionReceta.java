package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.DetalleDAO;
import datos.MedicamentoDAO;
import datos.RecetaDAO;
import modelo.Detalle;
import modelo.Medicamento;
import modelo.Receta;

@Stateless
public class GestionReceta implements GestionRecetaLocal, GestionRecetaRemote {


	@Inject
	private RecetaDAO dao;
	
	@Inject
	private DetalleDAO daoDetalle;
	
	@Inject
	private MedicamentoDAO daoMedicamento;
	
	private List<Receta> recetas = new ArrayList<Receta>();
	
	public void guardarReceta(int id, String descr, List<Detalle> detalles ) {

		Receta r = new Receta();
		//c.setId(id);
		r.setId(id);
		r.setDescr(descr);
		r.setDetalle(detalles);
		
		recetas.add(r);
		dao.insert(r);
	}
	
	public List<Receta> getRecetas(){
		System.out.println(recetas);
		daoMedicamento.getmedicamento();
		daoDetalle.getDetalles();
		return dao.getReceta();
	}
	
	public List<Receta> getRecetaPorNombre(String filtro) {
		return dao.getRecetaXNombre(filtro);
	}
	
	public void deleteRecetas(int id) {
		dao.remove(id);
	}
	
	public Receta readReceta(int id) {
		daoMedicamento.getmedicamento();
		daoDetalle.getDetalles();
		Receta receta = dao.read(id);
		return receta;
	}
	
	public void updateReceta(int id, String descr, Detalle detalle) {		
		Receta r = new Receta();
		r.setId(id);
		dao.update(r);
	}

	public int getLastId() {
		return dao.getLastId();
	}
}

