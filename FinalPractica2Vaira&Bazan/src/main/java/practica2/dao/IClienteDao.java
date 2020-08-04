package practica2.dao; // Paquetes de Acceso a datos

import org.springframework.data.repository.CrudRepository;

import practica2.entidad.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{ // Implementar Crud

}
