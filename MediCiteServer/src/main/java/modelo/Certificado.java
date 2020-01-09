package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Certificado {

	@Id
	@Column(name="mc_cer_id")
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="mc_cer_fecha")
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="mc_cons_id")
	private Consulta consulta;
	
	@Column(name="mc_cer_descripcion")
	private String descripcion;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Certificado [id=" + id + ", fecha=" + fecha + ", consulta=" + consulta + ", descripcion=" + descripcion
				+ "]";
	}
	
}
