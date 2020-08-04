package practica2.controlador;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
 
import practica2.entidad.Cliente;
import practica2.servicio.IClienteServicio;

@Controller // Para marcar y configurar la clase como un controlador
@SessionAttributes("cliente") 
public class ClienteControlador {

	@Autowired // Busca un componente resgistrado en el contenedor implemente la Interfaz IClienteDao
	private IClienteServicio clienteServicio;
	
	@GetMapping("/listar") // Indicamos el tipo de peticion
	public String listar(Model model) { 
		model.addAttribute("titulo", "Listado de clientes"); // Para pasar datos a la lista
		model.addAttribute("clientes", clienteServicio.findAll()); //Pasamos Lista de clientes a la vista
		return "listar";
	}
	
	@GetMapping("/form")
	public String crear(Map<String, Object> model) {  //Metodo crear
		
		Cliente cliente = new Cliente(); // Creamos la intancia de un objeto bidireccional, mapeado en la tabla de la base de datos y al formulario
		model.put("cliente", cliente); // Mostrar el formulario al usuario
		model.put("titulo", "Formulario de Cliente"); // Para pasar datos a la lista
		return "form"; 
	}
	
	@GetMapping("/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) { // Para que nos traiga el valor del parametro de la ruta
		Cliente cliente = null;
		if (id>0) {
			cliente = clienteServicio.findOne(id); // Si el cliente de la base de datos es mayor a 0 que nos traiga el valor
		} else {
			return "redirect:/listar";  // Redirecciona a /listar
		}
		model.put("cliente", cliente); // Mostrar el formulario al usuario
		model.put("titulo", "Editar Cliente"); // Para pasar datos a la lista
		return "form";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST) // Metodo donde recibe datos del formulario
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) { // Habilitamos la validacion y argumentar error si se encuentra
		if (result.hasErrors()) { // Si contiene errores
			model.addAttribute("titulo", "Formulario de Cliente"); //Que vuelva el titulo
			return "form"; // Que vuelva al formulario
		}
		 
		clienteServicio.save(cliente); //Guardamos al objeto
		status.setComplete(); // Eliminar el objeto cliente de la Sección
		return "redirect:listar"; //Se redirije al Listado de Cliente
	}
	
	@GetMapping("/eliminar/{id}") // Metodo donde vamos a eliminar clientes
	public String eliminar(@PathVariable(value = "id") Long id) { // Obtenemos el ID de la ruta.
		if (id>0) { // Si la ID es mayor que 0
			clienteServicio.delete(id); // Se elimina
		} 
		return "redirect:/listar"; //Se redirije al Listado de Cliente
	}
}
