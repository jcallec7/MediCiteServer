package modelo;

import javax.persistence.*;

@Entity
public class Diagnostico {
	
	@Id
	@Column(name="mc_diag_id")
	private int ID;
	
	@Column(name="mc_diag_detalle")
	private String detalle;
	
	@OneToOne
	@JoinColumn(name = "mc_rec_id")
	private Receta receta;

		public int getID() {
    	return ID;
	}

	public void setID(int iD) {
		ID = iD;
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
	
	
	
	
	
	
	
	
	

}
