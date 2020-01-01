package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import modelo.Medicamento;

@Local
public interface GestionMedicamentoLocal {
		
	public void guardarMedicamento(int id, String nombre, String concentracion);
	public List<Medicamento> getMedicamento();
	public List<Medicamento> getMedicamentoPorNombre(String filtro);

}
