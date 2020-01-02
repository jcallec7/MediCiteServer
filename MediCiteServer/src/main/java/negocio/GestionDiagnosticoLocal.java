package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import modelo.Diagnostico;
import modelo.Receta;

@Local
public interface GestionDiagnosticoLocal {
	
	public void guardarDiagnostico(int id, String detalle, Receta receta);
	
	public List<Diagnostico> getDiagnostico();
	public List<Diagnostico> getDiagnosticoPorNombre(int filtro);
	public void deleteDiagnostico(int id);
}