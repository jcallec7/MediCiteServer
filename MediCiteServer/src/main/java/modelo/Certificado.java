package modelo;

import java.util.Date;

import javax.persistence.*;
@Entity
public class Certificado {
	
	@Id
	@Column(name="mc_cert_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mc_pa_id")
	Paciente paciente;
	
	@Column(name="mc_cert_fecha")
	private Date fecha;
	
	@OneToOne()
	@JoinColumn(name = "mc_cons_id")
	Consulta consulta;
	
	@Column(name="mc_cert_detalle")
	private String detalle;	
	
}
