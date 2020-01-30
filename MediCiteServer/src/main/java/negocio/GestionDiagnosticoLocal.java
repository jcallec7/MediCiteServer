package negocio;

import java.util.List;

import javax.ejb.Local;

import modelo.Diagnostico;
import modelo.Receta;

@Local
public interface GestionDiagnosticoLocal {
	public void guardarDiagnostico(int id, String detalle, Receta receta, String tipo);
	public List<Diagnostico> getDiagnosticos();
	public List<Diagnostico> getDiagnosticosPorId(String filtro);
	public void deleteDiagnostico(int id);
	public Diagnostico readDiagnostico(int id);
	public void updateDiagnostico(int id, String detalle, Receta receta, String tipo);
	public int getLastId();
}
