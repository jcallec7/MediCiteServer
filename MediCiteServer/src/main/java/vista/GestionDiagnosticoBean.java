package vista;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import modelo.Diagnostico;
import modelo.Receta;
import negocio.GestionDiagnosticoLocal;
import negocio.GestionRecetaLocal;


@ManagedBean
public class GestionDiagnosticoBean {
	
    @Inject
	private GestionDiagnosticoLocal gml;
	
	@Inject
	private GestionRecetaLocal grl;
	
	private int id;
	private String detalle;
	private Receta receta;
	private List<Diagnostico> diagnosticos;
	private int filtro;
	private List<Receta> recetas;
	private SelectItem recetaSeleccionada;

	@PostConstruct
	public void init() {
		this.listarRecetas();
	}

	public GestionDiagnosticoLocal getGml() {
		return gml;
	}

	public void setGml(GestionDiagnosticoLocal gml) {
		this.gml = gml;
	}

	public GestionRecetaLocal getGrl() {
		return grl;
	}

	public void setGrl(GestionRecetaLocal grl) {
		this.grl = grl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public List<Diagnostico> getDiagnosticos() {
		return diagnosticos;
	}

	public void setDiagnosticos(List<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

	public int getFiltro() {
		return filtro;
	}

	public void setFiltro(int filtro) {
		this.filtro = filtro;
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

	public SelectItem getRecetaSeleccionada() {
		return recetaSeleccionada;
	}

	public void setRecetaSeleccionada(SelectItem recetaSeleccionada) {
		this.recetaSeleccionada = recetaSeleccionada;
	}
	
public String guardarDiagnostico() {
		
		gml.guardarDiagnostico(id, detalle, receta);
		//System.out.print(id+"," +nombre+"," +apellido+"," +genero+"," +especialidad+"," + correo+"," +direccion+"," +fechaNac+"," +contrasena);
		diagnosticos = gml.getDiagnostico();
		
		//return "listadoAutores";
		return null;
	}
public String buscardiagnostico() {
	
	diagnosticos = gml.getDiagnosticoPorNombre(filtro);
	
	return null;
}

public void listarRecetas() {
	this.recetas = this.grl.getRecetas();
}

}
