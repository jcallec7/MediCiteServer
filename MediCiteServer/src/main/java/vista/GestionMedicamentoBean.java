package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Medicamento;
import negocio.GestionMedicamentoLocal;

@ManagedBean
public class GestionMedicamentoBean {
	
	@Inject
	private GestionMedicamentoLocal gml;
	
	private int id;
	private String nombre;
	private String concentracion;
	
	private List<Medicamento> medicamentos;
	private String filtro;

	public GestionMedicamentoLocal getGml() {
		return gml;
	}
	public void setGml(GestionMedicamentoLocal gml) {
		this.gml = gml;
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
	public String getConcentracion() {
		return concentracion;
	}
	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}
	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	
	
	
	public String guardarMedicamento() {
		
		gml.guardarMedicamento(id, nombre, concentracion);
		//System.out.print(id+"," +nombre+"," +apellido+"," +genero+"," +especialidad+"," + correo+"," +direccion+"," +fechaNac+"," +contrasena);
		medicamentos = gml.getMedicamento();
		
		
		//return "listadoAutores";
		return null;
	}
	
	public String buscarMedicamento() {
		
		medicamentos = gml.getMedicamentoPorNombre(filtro);
		
		return null;
	}
}
