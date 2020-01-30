package modelo;

import javax.persistence.*;

@Entity
public class Diagnostico {

	@Id
	@Column(name = "mc_diag_id")
	private int id;

	@Column(name = "mc_diag_detalle")
	private String detalle;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "mc_rec_id")
	private Receta receta;
	
	@Column(name = "mc_diag_tipo")
	private String tipo;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		id = id;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Diagnostico [id=" + id + ", detalle=" + detalle + ", receta=" + receta + ", tipo=" + tipo + "]";
	}

	
}
