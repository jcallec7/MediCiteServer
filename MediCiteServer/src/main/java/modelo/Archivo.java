package modelo;

import java.io.File;
import java.io.Serializable;
//import java.sql.Time;
import java.util.Date;
//import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Archivo implements Serializable {

	private static final long serialVersionUID = 3464741529435196868L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "mc_arc_id")
	private int id;

	@Column(name = "mc_arc_nombre")
	private String nombre;
	
	@Column(name = "mc_arc_file")
	private File archivo;
	
	
}
