package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.DetalleDAO;
import datos.MedicamentoDAO;
import modelo.Detalle;
import modelo.Diagnostico;
import modelo.Medicamento;
import modelo.Usuario;

@Stateless
public class GestionDetalle implements GestionDetalleLocal, GestionDetalleRemote{

	@Inject
	private MedicamentoDAO daoMedicamento;
	
	@Inject
	private DetalleDAO dao;
	
	private List<Detalle> detalles = new ArrayList<Detalle>();

	public void guardarDetalle(int id, String nombre, Medicamento medicamento ) {

		Detalle d = new Detalle();
		d.setId(id);
		d.setNombre(nombre);
		d.setMedicamento(medicamento);
		System.out.println(d);
		dao.insert(d);
	}
	
	public List<Detalle> getDetalles() {
		System.out.println(detalles);
		daoMedicamento.getmedicamento();
		return dao.getDetalles();
	}
	
	public Detalle leerDetalle(int id){
		
		Detalle detalle = dao.read(id);
		System.out.print(detalle);
		
		return detalle;
		
	}
	
	public void editarDetalle(int id, String nombre, Medicamento medicamento ) {

		Detalle d = new Detalle();
		//c.setId(id);
		d.setId(id);
		d.setNombre(nombre);
		d.setMedicamento(medicamento);
		
		//c.setDiagnostico(null);
		detalles.add(d);
		// System.out.println(c);
		dao.update(d);
	}
	
	
	public void eliminarDetalles(int id){
		
		System.out.print("******************************Usuario Eliminado*******************************");
		dao.remove(id);
	}
	
	
	public List<Detalle> getDetallesPorNombre(String filtro) {
		return dao.getDetallesXNombre(filtro);
	}

	
	
	public void updateDetalle(int id, String nombre, Medicamento medicamento) {		
		Detalle d = new Detalle();
		d.setId(id);
		
		dao.update(d);
	}

}
