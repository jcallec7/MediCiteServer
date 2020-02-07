package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import datos.MedicamentoDAO;
import modelo.Medicamento;
import negocio.GestionMedicamentoLocal;

@ManagedBean
@ViewScoped
public class GestionMedicamentoBean {
	
	@Inject
	private GestionMedicamentoLocal gml;
	
	
	private MedicamentoDAO dao;
	private int id;
	private String nombre;
	private String concentracion;
	private String filtro;
	
	private List<Medicamento> medicamentos;
	private Medicamento mediEdit;

	public GestionMedicamentoLocal getGml() {
		return gml;
	}

	public void setGml(GestionMedicamentoLocal gml) {
		this.gml = gml;
	}

	public MedicamentoDAO getDao() {
		return dao;
	}

	public void setDao(MedicamentoDAO dao) {
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

	public String getConcentracion() {
		return concentracion;
	}

	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public Medicamento getMediEdit() {
		return mediEdit;
	}

	public void setMediEdit(Medicamento mediEdit) {
		this.mediEdit = mediEdit;
	}

	public String guardarMedicamento() {
		
		gml.guardarMedicamento(id, nombre, concentracion);
		//System.out.print(id+"," +nombre+"," +apellido+"," +genero+"," +especialidad+"," + correo+"," +direccion+"," +fechaNac+"," +contrasena);
		medicamentos = gml.getMedicamento();
		
		
		//return "listadoAutores";
		return "listMedicamento";
	
	}
	
	public String editarMedicamento(int id) {
		this.mediEdit = gml.leerMedicamento(id);
		return "updateMedicamento";
	}
	
	public List<Medicamento> buscarMedicamentoPorId() {
		
		medicamentos = gml.getMedicamentoPorNombre(filtro);
		return medicamentos;
	}
	
	public String eliminarMedicamento(int id) {
		gml.eliminarMedicamento(id);
		return "listMedicamento";
	}
	
	
	public String actualizarMedicamento() {
		gml.editarMedicamento(id, nombre, concentracion);
		return "listMedicamento";
		
	}
}
