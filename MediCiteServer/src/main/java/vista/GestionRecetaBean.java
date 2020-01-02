package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import datos.RecetaDAO;
import modelo.Medicamento;
import modelo.Medico;
import modelo.Receta;
import negocio.GestionMedicamentoLocal;
import negocio.GestionRecetaLocal;



@ManagedBean
public class GestionRecetaBean {

	
	@Inject
	private GestionRecetaLocal grl;
	
	private RecetaDAO dao;
	private int id;
	private String descr;
	private String filtro;

	private List<Receta> recetas;
	private Receta recetaEdit;

	
	
	public GestionRecetaLocal getGrl() {
		return grl;
	}


	public void setGrl(GestionRecetaLocal grl) {
		this.grl = grl;
	}


	public RecetaDAO getDao() {
		return dao;
	}


	public void setDao(RecetaDAO dao) {
		this.dao = dao;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescr() {
		return descr;
	}


	public void setDescr(String descr) {
		this.descr = descr;
	}


	public String getFiltro() {
		return filtro;
	}


	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


	public List<Receta> getRecetas() {
		return recetas;
	}


	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}


	

	public Receta getRecetaEdit() {
		return recetaEdit;
	}


	public void setRecetaEdit(Receta recetaEdit) {
		this.recetaEdit = recetaEdit;
	}


	public String guardarReceta() {
		grl.guardarReceta(id, descr);
		recetas = grl.getReceta();
		return null;
	}
	
	public String editarReceta(int id) {
		this.recetaEdit = grl.leerReceta(id);
		return "UpdateReceta";
	}
	
	
	public List<Receta> buscarReceta() {
		recetas = grl.getRecetasPorNombre(filtro); 
		return recetas;
	}
	
	public List<Receta> buscarRecetaPorId() {
		recetas = grl.getRecetasPorId(filtro); 
		return recetas;
	}
	
	public String actualizarReceta() {
		grl.editarReceta(id, descr);
		return "listReceta";
		
	}
	

	
}
