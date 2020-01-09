package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Certificado implements Serializable {
	
	private static final long serialVersionUID = -6594217200682507286L;

	@Id
	@Column(name = "mc_cert_id")
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "mc_cert_fecha")
	private Date fecha;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "mc_cons_id")
	private Consulta consulta;
	
	@Column(name = "mc_cert_detalle")
	private String detalle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Certificado [id=" + id + ", fecha=" + fecha + ", consulta=" + consulta + ", detalle=" + detalle + "]";
	}
	
	
	
	
	
}
