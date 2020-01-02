package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.MedicamentoDAO;
import modelo.Medicamento;
import modelo.Receta;

@Stateless
public class GestionMedicamento implements GestionMedicamentoLocal, GestionMedicamentoRemote {

	
	@Inject
	private MedicamentoDAO dao;
	
	private List<Medicamento> medicamentos = new ArrayList<Medicamento>();

	public void guardarMedicamento(int id, String nombre, String concentracion, List<Receta> recetas) {
		Medicamento m = new Medicamento();
		m.setId(id);
		m.setnombre(nombre);
		m.setConcentracion(concentracion);
		m.setRecetas(recetas);
		System.out.println(m);
		
		medicamentos.add(m);
		dao.insert(m);
	}
	
	public List<Medicamento> getMedicamento(){
		System.out.println(medicamentos);
		return dao.getmedicamento(); 
	}
	
	
	public List<Medicamento> getMedicamentoPorNombre(String filtro){
		
		return dao.getMedicamentoXNombre(filtro);
	}
	
	public void deleteMedicamento(int id) {
		dao.remove(id);
	}

}
