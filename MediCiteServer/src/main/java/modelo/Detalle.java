package modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Detalle implements Serializable {
	
	private static final long serialVersionUID = -20336965027624681L;

	@Id
	@Column(name="mc_det_id")
	private int id;
	
	@Column(name="mc_det_nombre")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Medicamento medicamento;

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

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	
	@Override
	public String toString() {
		return "Dosis=" + nombre + ", " + medicamento + "]";
	}
	
}
