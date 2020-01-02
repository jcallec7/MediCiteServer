package negocio;

import java.util.List;

import modelo.Medicamento;
import modelo.Receta;

public interface GestionMedicamentoRemote {
	public void guardarMedicamento(int id, String nombre, String concentracion, List<Receta> recetas);
	public List<Medicamento> getMedicamento();
	public List<Medicamento> getMedicamentoPorNombre(String filtro);
	public void deleteMedicamento(int id);
}
