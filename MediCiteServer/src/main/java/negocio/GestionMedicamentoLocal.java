package negocio;

import java.util.List;

import javax.ejb.Local;
import modelo.Medicamento;

@Local
public interface GestionMedicamentoLocal {
	public void guardarMedicamento(int id, String nombre, String concentracion);
	public List<Medicamento> getMedicamento();
	public Medicamento leerMedicamento(int id);
	public void editarMedicamento(int id, String nombre, String concentracion);
	public void eliminarMedicamento(int id);
	public List<Medicamento> getMedicamentoPorNombre(String filtro);
}
