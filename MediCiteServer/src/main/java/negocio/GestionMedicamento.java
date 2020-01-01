package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.MedicamentoDAO;
import modelo.Medicamento;
import modelo.Medico;

@Stateless
public class GestionMedicamento implements GestionMedicamentoLocal, GestionMedicamentoRemote{
	
	@Inject
	private MedicamentoDAO dao;
	
	private List<Medicamento> medicamento = new ArrayList<Medicamento>();
	
	public void guardarMedicamento(int id, String nombre, String concentracion) {
		Medicamento m = new Medicamento();
		m.setId(id);
		m.setnombre(nombre);
		m.setConcentracion(concentracion);
		System.out.println(m);
		dao.insert(m);
	}
	
	public List<Medicamento> getMedicamento(){
		System.out.println(medicamento);
		return dao.getmedicamento(); 
	}
	
	
	public List<Medicamento> getMedicamentoPorNombre(String filtro){
		
		return dao.getMedicamentoXNombre(filtro);
	}

}


