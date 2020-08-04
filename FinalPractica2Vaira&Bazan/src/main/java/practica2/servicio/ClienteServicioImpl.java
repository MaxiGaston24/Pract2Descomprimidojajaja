package practica2.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import practica2.dao.IClienteDao;
import practica2.entidad.Cliente;

@Service // Unico punto de acceso, y podemos operar con muchas clases dao
public class ClienteServicioImpl implements IClienteServicio{

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly=true) // Marcamos el metodo como transaccional y lo colocamos solamente de lectura
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional // Metodo de escritura, es para insertar un nuevo registro
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);	
	}


}
