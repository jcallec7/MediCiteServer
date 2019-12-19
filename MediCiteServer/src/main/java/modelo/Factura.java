package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Factura {
	
	@Id
	@Column(name="mc_fact_id")
	private int id;
	
	@Column(name="mc_fact_consulta")
	Consulta consulta;
	
	@Column(name="mc_fact_subtotal")
	private double subtotal;
	
	@Column(name="mc_fact_total")
	private double total;

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
	
	
	
	
	
	
}