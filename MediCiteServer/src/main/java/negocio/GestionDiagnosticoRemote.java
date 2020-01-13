package negocio;

import java.util.List;

import javax.ejb.Remote;

import modelo.Diagnostico;
import modelo.Receta;

@Remote
public interface GestionDiagnosticoRemote {
	public void guardarDiagnostico(int id, String detalle, Receta receta, String tipo);
	public List<Diagnostico> getDiagnosticos();
	public List<Diagnostico> getDiagnosticosPorId(String filtro);
	public void deleteDiagnostico(int id);
	public Diagnostico readDiagnostico(int id);
	public void updateDiagnostico(int id, String detalle, Receta receta, String tipo);
}
