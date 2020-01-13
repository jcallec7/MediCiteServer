package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.DiagnosticoDAO;
import datos.RecetaDAO;
import modelo.Consulta;
import modelo.Detalle;
import modelo.Diagnostico;
import modelo.Receta;
import modelo.Usuario;

@Stateless
public class GestionDiagnostico implements GestionDiagnosticoLocal, GestionDiagnosticoRemote  {

	@Inject
	private DiagnosticoDAO dao;

	@Inject 
	private RecetaDAO daoReceta;

	private List<Diagnostico> diagnosticos = new ArrayList<Diagnostico>();
	
	public void guardarDiagnostico(int id, String detalle, Receta receta, String tipo) {
		
		Diagnostico d = new Diagnostico();
		d.setId(id);
		d.setDetalle(detalle);
		d.setReceta(receta);
		d.setTipo(tipo);
		System.out.println(d);
		diagnosticos.add(d);
		dao.insert(d);
	}
	
	public List<Diagnostico> getDiagnosticos(){
		System.out.println(diagnosticos);
		daoReceta.getReceta();
		return dao.getDiagnostico();
	}
	
	public List<Diagnostico> getDiagnosticosPorId(String filtro){
		return dao.getDiagnosticoXId(filtro);
	}
	
	public void deleteDiagnostico(int id) {
		dao.remove(id);
	}
	
	
	public Diagnostico readDiagnostico(int id){
		Diagnostico diagnostico = dao.read(id);
		return diagnostico;	
	}
	
	public void updateDiagnostico(int id, String detalle, Receta receta, String tipo) {
		Diagnostico d = new Diagnostico();
		d.setId(id);
	
		dao.update(d);
	}

}
