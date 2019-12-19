package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medicamento {
	
	@Id
	@Column(name="mc_medic_id")
	private int id;
	
	@Column(name="mc_medic_nombre")
	private String nombreMed;
	
	@Column(name="mc_medic_concentr")
	private String concentracion;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreMed() {
		return nombreMed;
	}
	public void setNombreMed(String nombreMed) {
		this.nombreMed = nombreMed;
	}
	public String getConcentracion() {
		return concentracion;
	}
	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}
	
	
	@Override
	public String toString() {
		return "Medicamento [id=" + id + ", nombreMed=" + nombreMed + ", concentracion=" + concentracion + "]";
	}
	
	
	
	
	
	

}
