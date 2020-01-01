package negocio;

import java.util.List;

import modelo.Medicamento;

public interface GestionMedicamentoRemote {
	
	public void guardarMedicamento(int id, String nombre, String concentracion);
	public List<Medicamento> getMedicamento();
	public List<Medicamento> getMedicamentoPorNombre(String filtro);


}
