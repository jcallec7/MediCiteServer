package modelo;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Certificado
{
	@Id
	@Column(name="mc_cert_Id")
	private int id;
	
	@Column(name= "mc_cert_paciente")
	Paciente paciente;
	
	@Column(name="mc_cert_fecha")
	private Date fecha;
	
	@Column(name="mc_cert_consulta")
	Consulta consulta;
	
	@Column(name="mc_cert_detalle")
	private String detalle;	
	
	
	
}
