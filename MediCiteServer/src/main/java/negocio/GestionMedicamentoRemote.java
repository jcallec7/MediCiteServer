package negocio;

import java.util.List;

import javax.ejb.Remote;

import modelo.Medicamento;
import modelo.Receta;

@Remote
public interface GestionMedicamentoRemote {
		public void guardarMedicamento(int id, String nombre, String concentracion);
		public List<Medicamento> getMedicamento();
		public Medicamento leerMedicamento(int id);
		public void editarMedicamento(int id, String nombre, String concentracion);
		public void eliminarMedicamento(int id);
		public List<Medicamento> getMedicamentoPorNombre(String filtro);
}
