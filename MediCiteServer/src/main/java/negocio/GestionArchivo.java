package negocio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.ArchivoDAO;
import modelo.Archivo;

@Stateless
public class GestionArchivo implements GestionArchivoLocal, GestionArchivoRemote{

	
	@Inject
	private ArchivoDAO dao;
	
	private List<Archivo> archivos = new ArrayList<Archivo>();
	
	public void guardarArchivo(int id, String nombre, File archivo) {
		Archivo a = new Archivo();
		a.setId(id);
		a.setNombre(nombre);
		a.setArchivo(archivo);
		System.out.println(a);
		
		archivos.add(a);
		dao.insert(a);
	}
	
	public List<Archivo> getArchivo() {
		System.out.println(archivos);
		archivos = dao.getArchivo();
		return archivos;
	}

	public Archivo leerArchivo(int id) {

		Archivo archivo = dao.read(id);
		System.out.print(archivo);

		return archivo;
	}
	
	public void editarArchivo(int id, String nombre, File archivo) {
		Archivo a = new Archivo();
		a.setId(id);
		a.setNombre(nombre);
		a.setArchivo(archivo);
		System.out.println(a);
		
		archivos.add(a);
		dao.update(a);
	}
	
	public void eliminarArchivo(int id) {

		System.out.print("******************************Archivo Eliminado*******************************");
		dao.remove(id);
	}
	
	public List<Archivo> getArchivoPorNombre(String filtro) {

		return dao.getArchivoXNombre(filtro);
	}
}
