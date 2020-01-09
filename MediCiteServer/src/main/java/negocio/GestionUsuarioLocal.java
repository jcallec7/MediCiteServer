package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import modelo.Usuario;
import modelo.Rol;

@Local
public interface GestionUsuarioLocal {
	
	public void guardarUsuario(String id, String nombre, String apellido, String genero, 
								Date fecha_nac, String correo, String contrasena, String telf1, 
								String telf2, String direccion, String peso, String estatura, Rol rol);
	
	public List<Usuario> getUsuarios();
	
	public List<Usuario> getUsuariosPorNombre(String filtro);
	
	public void deleteUsuario(String id);
	
	public Usuario readUsuario(String id);
	
	public void updateUsuario(String id, String nombre, String apellido, String genero,
			Date fecha_nac, String correo, String contrasena, String telf1, String telf2, String direccion,
			String peso, String estatura);
	
}
	
