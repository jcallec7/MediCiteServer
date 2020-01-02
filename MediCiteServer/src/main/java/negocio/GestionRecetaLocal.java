package negocio;

import java.util.List;

import modelo.Medicamento;
import modelo.Receta;

public interface GestionRecetaLocal {
	
	public void guardarReceta(int id, String descr);
	public List<Receta> getReceta();
	public List<Receta> getRecetasPorNombre(String filtro);

}