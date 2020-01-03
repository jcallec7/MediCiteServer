package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.DetalleDAO;
import modelo.Detalle;
import modelo.Diagnostico;
import modelo.Medicamento;
import modelo.Medico;
import modelo.Paciente;

@Stateless

public class GestionDetalle implements GestionDetalleLocal, GestionDetalleRemote{

	@Inject
	private DetalleDAO dao;
	
	private List<Detalle> detalles = new ArrayList<Detalle>();

	public void guardarDetalle(String id, String nombre, Medicamento medicamento ) {

		Detalle d = new Detalle();
		//c.setId(id);
		d.setId(id);
		d.setNombre(nombre);
		d.setMedicamento(medicamento);
		
		//c.setDiagnostico(null);
		detalles.add(d);
		// System.out.println(c);
		dao.insert(d);
	}
	
	public List<Detalle> getDetalles() {
		System.out.println(detalles);
		return dao.getDetalles();
	}
	
	public List<Detalle> getDetallesPorNombre(String filtro) {
		return dao.getDetallesXNombre(filtro);
	}
	
	public void deleteDetalles(String id) {
		dao.remove(id);
	}
	
	public Detalle readDetalle(String id) {
		Detalle detalle = dao.read(id);
		return detalle;
	}
	
	public void updateDetalle(String id, String nombre, Medicamento medicamento) {		
		Detalle d = new Detalle();
		d.setId(id);
		
		dao.update(d);
	}
	
}
