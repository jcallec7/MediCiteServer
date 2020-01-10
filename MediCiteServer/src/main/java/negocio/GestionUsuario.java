package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.UsuarioDAO;
import modelo.Usuario;
import modelo.Rol;

import java.util.ArrayList;
import java.util.Date;

@Stateless
public class GestionUsuario implements GestionUsuarioRemote, GestionUsuarioLocal{

	@Inject
	private UsuarioDAO dao;

	private List<Usuario> Usuarios = new ArrayList<Usuario>();

	public void guardarUsuario(String id, String nombre, String apellido, String genero,
								Date fecha_nac, String correo, String especialidad, String contrasena, String telf1, String telf2, String direccion,
								String peso, String estatura, Rol rol) {

		Usuario c = new Usuario();
		c.setId(id);
		c.setNombre(nombre);
		c.setApellido(apellido);
		c.setGenero(genero);
		c.setFecha_nac(fecha_nac);
		c.setCorreo(correo);
		c.setEspecialidad(especialidad);
		c.setContrasena(contrasena);
		c.setTelf1(telf1);
		c.setTelf2(telf2);
		c.setDireccion(direccion);
		c.setPeso(peso);
		c.setEstatura(estatura);
		c.setRol(rol);

		Usuarios.add(c);
		// System.out.println(c);
		dao.insert(c);
	}
	
	public void updateUsuario(String id, String nombre, String apellido, String genero,
			Date fecha_nac, String correo, String especialidad, String contrasena, String telf1, String telf2, String direccion,
			String peso, String estatura, Rol rol) {		
		Usuario c = new Usuario();
		c.setId(id);
		c.setNombre(nombre);
		c.setApellido(apellido);
		c.setGenero(genero);
		c.setFecha_nac(fecha_nac);
		c.setCorreo(correo);
		c.setEspecialidad(especialidad);
		c.setContrasena(contrasena);
		c.setTelf1(telf1);
		c.setTelf2(telf2);
		c.setDireccion(direccion);
		c.setPeso(peso);
		c.setEstatura(estatura);
		c.setRol(rol);
		dao.update(c);
	}
	
	public Usuario readUsuario(String id) {
		Usuario usuario = dao.read(id);
		return usuario;
	}
	
	public void deleteUsuario(String id) {
		dao.remove(id);
	}
	

	public List<Usuario> getUsuarios() {
		System.out.println(Usuarios);
		return dao.getUsuarios();
	}

	public List<Usuario> getUsuariosPorNombre(String filtro) {
		return dao.getUsuariosPorNombre(filtro);
	}
	
	public List<Usuario> getUsuarioPorId(String filtro){
		
		return dao.getUsuarioPorId(filtro);
	}
	
	public List<Usuario> getUsuarioPorRol(String filtro){
		
		return dao.getUsuarioPorRol(filtro);
	}

}
