package negocio;

import java.util.List;

import modelo.Detalle;
import modelo.Medicamento;

public interface GestionDetalleRemote {

	public void guardarDetalle(String id, String nombre, Medicamento medicamento ) ;
	public List<Detalle> getDetalles(); 
	public List<Detalle> getDetallesPorNombre(String filtro);
	public void deleteDetalles(String id);
	public Detalle readDetalle(String id);
	public void updateDetalle(String id, String nombre, Medicamento medicamento);
	

	
	
}
