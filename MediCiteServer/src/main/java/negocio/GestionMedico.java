package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.MedicoDAO;
import modelo.Medico;

import java.util.ArrayList;

@Stateless
public class GestionMedico implements GestionMedicoLocal, GestionMedicoRemote{
	
	@Inject
	private MedicoDAO dao;

	private List<Medico> medico = new ArrayList<Medico>();
	
	public void guardarMedico(int id, String nombre, String apellido, String genero, String especialidad, String correo, String direccion, String fechaNac){
		Medico m = new Medico();  
		m.setId(id);  
		m.setNombre(nombre);
		m.setApellido(apellido);
		m.setGenero(genero);
		m.setEspecialidad(especialidad);
		m.setCorreo(correo);
		m.setDireccion(direccion);
		m.setFechaNac(fechaNac);
		System.out.println(m);
		dao.insert(m);
	}
	
	public List<Medico> getMedico(){
		System.out.println(medico);
		return dao.getMedico();
	}
	
	
	public List<Medico> getMedicoPorNombre(String filtro){
		
		return dao.getMedicoXNombre(filtro);
	}

	
}
