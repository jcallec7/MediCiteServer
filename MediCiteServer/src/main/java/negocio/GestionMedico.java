package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.MedicoDAO;
import modelo.Medico;

import java.util.ArrayList;

@Stateless
public class GestionMedico{
	
	@Inject
	private MedicoDAO dao;

	private List<Medico> medico = new ArrayList<Medico>();
	
	public void guardarMedico(int id, String nombre, String apellido, String genero, String correo, String direccion, String fechaNac){
		Medico c = new Medico();  
		c.setId(id);  
		c.setNombre(nombre);
		c.setApellido(apellido);
		c.setGenero(genero);
		c.setCorreo(correo);
		c.setDireccion(direccion);
		c.setFechaNac(fechaNac);
		System.out.println(c);
		dao.insert(c);
	}
	
	public List<Medico> getMedico(){
		System.out.println(medico);
		return dao.getMedico();
	}
	
	
	public List<Medico> getMedicoPorNombre(String filtro){
		
		return dao.getMedicoXNombre(filtro);
	}

	
}
