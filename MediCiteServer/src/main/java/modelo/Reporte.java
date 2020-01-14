package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reporte implements Serializable {

	private static final long serialVersionUID = 3378357312263882518L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "mc_rep_id")
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "mc_rep_fecha_desde")
	private Date fechaDesde;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "mc_rep_fecha_hasta")
	private Date fechaHasta;
	
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "mc_rep_id")
	private List<Caja> cajas;

	@Column(name = "mc_caja_ingresos")
	private double ingresos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public List<Caja> getCajas() {
		return cajas;
	}

	public void setCajas(List<Caja> cajas) {
		this.cajas = cajas;
	}

	public double getIngresos() {
		return ingresos;
	}

	public void setIngresos(double ingresos) {
		this.ingresos = ingresos;
	}	
	
}
