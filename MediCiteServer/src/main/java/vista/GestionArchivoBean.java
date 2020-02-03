package vista;

import java.io.File;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import negocio.GestionArchivoLocal;
import datos.ArchivoDAO;
import modelo.Archivo;


@ManagedBean
public class GestionArchivoBean {
	
	@Inject
	private GestionArchivoLocal gml;
	
	private ArchivoDAO dao;
	private int id;
	private String nombre;
	private File archivo;
	private String filtro;
	
	private List<Archivo> archivos;
	private Archivo archivoEdit;
	public GestionArchivoLocal getGml() {
		return gml;
	}
	public void setGml(GestionArchivoLocal gml) {
		this.gml = gml;
	}
	public ArchivoDAO getDao() {
		return dao;
	}
	public void setDao(ArchivoDAO dao) {
		this.dao = dao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public File getArchivo() {
		return archivo;
	}
	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}
	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	public List<Archivo> getArchivos() {
		return archivos;
	}
	public void setArchivos(List<Archivo> archivos) {
		this.archivos = archivos;
	}
	public Archivo getArchivoEdit() {
		return archivoEdit;
	}
	public void setArchivoEdit(Archivo archivoEdit) {
		this.archivoEdit = archivoEdit;
	}
	
	public String guardarArchivo() {
		
		gml.guardarArchivo(id, nombre, archivo);
		archivos = gml.getArchivo();
		return "listArchivo";
	}
	
	public String editarArchivo(int id) {
		this.archivoEdit = gml.leerArchivo(id);
		return "updateArchivo";
	}
	
	public List<Archivo> buscarArchivoPorNombre() {
		
		archivos = gml.getArchivoPorNombre(filtro);
		return archivos;
	}
	
	public String eliminarArchivo(int id) {
		gml.eliminarArchivo(id);
		return "listArchivo";
	}
	
	public String actualizarArchivo() {
		gml.editarArchivo(id, nombre, archivo);
		return "listArchivo";
		
	}
	

}
