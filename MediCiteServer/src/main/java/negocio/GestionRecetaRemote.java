package negocio;

import java.util.List;

import javax.ejb.Remote;

import modelo.Detalle;
import modelo.Receta;


@Remote
public interface GestionRecetaRemote {

	
	public void guardarReceta(int id, String descr, List<Detalle> detalles);
	public List<Receta> getRecetas();
	public List<Receta> getRecetaPorNombre(String filtro);
	public void deleteRecetas(int id);
	public Receta readReceta(int id);
	public void updateReceta(int id, String descr, Detalle detalle);
}
