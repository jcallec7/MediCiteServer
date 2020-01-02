package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.MedicoDAO;
import modelo.Medico;

import java.util.ArrayList;
import java.util.Date;

@Stateless
public class GestionMedico implements GestionMedicoLocal, GestionMedicoRemote{
	
	@Inject
	private MedicoDAO dao;

	private List<Medico> medico = new ArrayList<Medico>();
	
	public void guardarMedico(String id, String nombre, String apellido, String genero, String especialidad, String correo, String direccion, Date fechaNac, String contrasena){
		Medico m = new Medico();  
		m.setId(id);
		m.setNombre(nombre);
		m.setApellido(apellido);
		m.setGenero(genero);
		m.setEspecialidad(especialidad);
		m.setCorreo(correo);
		m.setDireccion(direccion);
		m.setFechaNac(fechaNac);
		m.setContrasena(contrasena);
		System.out.println(m);
		dao.insert(m);
	}
	
	public void editarMedico(String id){
	
		Medico m = new Medico();
		m=dao.read(id);
		System.out.print(m);
		
	}
	
	public void eliminarMedico(String id){
		
		System.out.print("******************************Usuario Eliminado*******************************");
		dao.remove(id);
		
		
	}
	
	public List<Medico> getMedico(){
		System.out.println(medico);
		return dao.getMedico();
	}
	
	
	public List<Medico> getMedicoPorNombre(String filtro){
		
		return dao.getMedicoXNombre(filtro);
	}
	
	public List<Medico> getMedicoPorId(String filtro){
		
		return dao.getMedicoXId(filtro);
	}

	
}
