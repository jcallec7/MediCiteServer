package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Factura {
	
	@Id
	@Column(name="mc_fact_id")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "mc_cons_id")
	private Consulta consulta;
	
	@Column(name="mc_fact_subtotal")
	private double subtotal;
	
	@Column(name="mc_fact_total")
	private double total;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="mc_fact_date")
	private Date fecha;
	
	
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", consulta=" + consulta + ", subtotal=" + subtotal + ", total=" + total
				+ ", fecha=" + fecha + "]";
	}

}