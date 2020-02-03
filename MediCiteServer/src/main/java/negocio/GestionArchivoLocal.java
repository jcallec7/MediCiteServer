package negocio;

import java.io.File;
import java.util.List;

import javax.ejb.Local;

import modelo.Archivo;

@Local
public interface GestionArchivoLocal {

	public void guardarArchivo(int id, String nombre, File archivo);
	public List<Archivo> getArchivo();
	public Archivo leerArchivo(int id);
	public void editarArchivo(int id, String nombre, File archivo);
	public void eliminarArchivo(int id);
	public List<Archivo> getArchivoPorNombre(String filtro);
	
}
