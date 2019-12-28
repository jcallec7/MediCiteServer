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
	private String nombre;
	
	@Column(name="mc_medic_concentr")
	private String concentracion;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getnombre() {
		return nombre;
	}
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	public String getConcentracion() {
		return concentracion;
	}
	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}
	
	
	@Override
	public String toString() {
		return "Medicamento [id=" + id + ", nombre=" + nombre + ", concentracion=" + concentracion + "]";
	}

}
