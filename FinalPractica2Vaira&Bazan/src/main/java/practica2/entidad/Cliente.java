package practica2.entidad; // Paquete de entidades

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable { 

	private static final long serialVersionUID = 1L;
	
	@Id // Clave Primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementa
	private Long id;

	@NotEmpty  // Campo que no este vacio
	private String nombre; // Campo nombre
	
	@NotEmpty 
	private String apellido; // Campo apellido
	
	@NotEmpty 
	@Email
	private String email; // Campo email

	@NonNull // Fecha sea no nula
	@Column(name = "create_at") // Nombrar columna
	@Temporal(TemporalType.DATE) // Indicar formato de la fecha
	@DateTimeFormat(pattern = "yyyy-MM-dd") // Formato de Fecha y Hora
	private Date createAt;

	
	// Creacion de getter and setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
