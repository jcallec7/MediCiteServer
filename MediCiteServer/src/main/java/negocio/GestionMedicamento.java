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

	public void guardarMedicamento(int id, String nombre, String concentracion) {
		Medicamento m = new Medicamento();
		m.setId(id);
		m.setnombre(nombre);
		m.setConcentracion(concentracion);
		System.out.println(m);
		
		medicamentos.add(m);
		dao.insert(m);
	}
	
	public List<Medicamento> getMedicamento(){
		System.out.println(medicamentos);
		return dao.getmedicamento(); 
	}
	
	public Medicamento leerMedicamento(int id){
		
		Medicamento medicamento = dao.read(id);
		System.out.print(medicamento);
		
		return medicamento;
		
	}
	
	public void editarMedicamento(int id, String nombre, String concentracion) {
		Medicamento m = new Medicamento();
		m.setId(id);
		m.setnombre(nombre);
		m.setConcentracion(concentracion);
		System.out.println(m);
		
		medicamentos.add(m);
		dao.update(m);
	}
	
	public void eliminarMedicamento(int id){
		
		System.out.print("******************************Usuario Eliminado*******************************");
		dao.remove(id);
	}
	
	public List<Medicamento> getMedicamentoPorNombre(String filtro){
		
		return dao.getMedicamentoXNombre(filtro);
	}
	



}
