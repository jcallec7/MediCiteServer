package negocio;

import java.util.List;

import javax.ejb.Remote;

import modelo.Detalle;
import modelo.Medicamento;

@Remote
public interface GestionDetalleRemote {
	public void guardarDetalle(int id, String nombre, Medicamento medicamento );
	public List<Detalle> getDetalles();
	public Detalle leerDetalle(int id);
	public void editarDetalle(int id, String nombre, Medicamento medicamento );
	public List<Detalle> getDetallesPorNombre(String filtro);
	public void eliminarDetalles(int id);
	public void updateDetalle(int id, String nombre, Medicamento medicamento);
}
