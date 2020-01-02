package negocio;

import java.util.List;

import modelo.Medicamento;
import modelo.Receta;

public interface GestionMedicamentoRemote {
	public void guardarMedicamento(int id, String nombre, String concentracion);
	public List<Medicamento> getMedicamento();
	public Medicamento leerMedicamento(int id);
	public void editarMedicamento(int id, String nombre, String concentracion);
	public List<Medicamento> getMedicamentoPorNombre(String filtro);
	public void deleteMedicamento(int id);
}
