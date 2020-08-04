package practica2.servicio;

import java.util.List;

import practica2.entidad.Cliente;

public interface IClienteServicio {
	
	public List<Cliente> findAll(); // Metodo que tiene que implementar toda la clase que implementan la interfaz

	public void save(Cliente cliente); // Metodo para guardar un nuevo cliente

	public Cliente findOne(Long id); // Metodo buscar 1 solo por ID

	public void delete(Long id); // Metodo eliminar
}
