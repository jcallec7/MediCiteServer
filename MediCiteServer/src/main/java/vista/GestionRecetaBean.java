package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Medicamento;
import modelo.Receta;
import negocio.GestionMedicamentoLocal;
import negocio.GestionRecetaLocal;



@ManagedBean
public class GestionRecetaBean {

	
	@Inject
	private GestionRecetaLocal grl;
	
	@Inject
	private GestionMedicamentoLocal gmedl;
	
	  
	private int id;
	private String descr;

	private List<Receta> recetas;
	private String filtro;

	

	public GestionRecetaLocal getGrl() {
		return grl;
	}

	public void setGrl(GestionRecetaLocal grl) {
		this.grl = grl;
	}

	public GestionMedicamentoLocal getGmedl() {
		return gmedl;
	}

	public void setGmedl(GestionMedicamentoLocal gmedl) {
		this.gmedl = gmedl;
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


	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

	
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	
	public String guardarReceta() {
		grl.guardarReceta(id, descr);
		recetas = grl.getReceta();
	
		//return "listadoAutores";
		return null;
	}
	
	public String buscarReceta() {
		
		recetas = grl.getRecetasPorNombre(filtro); 
		
		return null;
	}
	
}
