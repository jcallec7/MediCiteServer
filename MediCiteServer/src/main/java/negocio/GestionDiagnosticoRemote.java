package negocio;

import java.util.List;

import javax.ejb.Remote;

import modelo.Diagnostico;
import modelo.Receta;


@Remote
public interface GestionDiagnosticoRemote {
	public void guardarDiagnostico(int id, String detalle, Receta receta);
	public List<Diagnostico> getDiagnostico();
	public List<Diagnostico> getDiagnosticoPorNombre(int filtro);
	public void deleteDiagnostico(int id);
}
