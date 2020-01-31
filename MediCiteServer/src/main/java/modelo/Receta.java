package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Receta implements Serializable {

	private static final long serialVersionUID = -20336965027624681L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "mc_rec_id")
	private int id;

	@Column(name = "mc_rec_descr")
	private String descr;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "mc_rec_id")
	private List<Detalle> detalle;

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

	public List<Detalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<Detalle> detalle) {
		this.detalle = detalle;
	}

	public void addDetalle(Detalle det) {
		if(detalle == null)
			detalle = new ArrayList<>();
		detalle.add(det);
	}
	
	@Override
	public String toString() {
		return "Receta= Motivo:" + descr + ", " + detalle + "";
	}
	
	

}
