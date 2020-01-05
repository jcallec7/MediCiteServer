package negocio;

import java.util.List;

import modelo.Detalle;
import modelo.Medicamento;

public interface GestionDetalleLocal {
	public void guardarDetalle(String id, String nombre, Medicamento medicamento );
	public List<Detalle> getDetalles();
	public Detalle leerDetalle(String id);
	public void editarDetalle(String id, String nombre, Medicamento medicamento );
	public List<Detalle> getDetallesPorNombre(String filtro);
	public void deleteDetalles(String id);
	public void updateDetalle(String id, String nombre, Medicamento medicamento);
	
}