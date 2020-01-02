package negocio;

import java.util.List;

import modelo.Medicamento;
import modelo.Receta;

public interface GestionRecetaLocal {
	
	public void guardarReceta(int id, String descr);
	public void editarReceta(int id, String descr);
	public List<Receta> getReceta();
	public List<Receta> getRecetasPorNombre(String filtro);
	public List<Receta> getRecetasPorId(String filtro);
	public void delateReceta(int id);

}
