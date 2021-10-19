package gt.com.edu.models.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Data
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public Boolean enabled;
	public String nombre_usuario;
	public String contraseña_usuario;
	
	 //relación entre usuarios y roles
	    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	    @JoinColumn(name="rol_id")
	    @ManyToMany(fetch =FetchType.LAZY,cascade = CascadeType.ALL)
	    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
	    inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"),
	    uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id","rol_id"})})
	   // private Set<Rol> roles = new HashSet<>();
        private List<Rol>roles;	 
	  
	 
	  
	  
	//relación entre usuarios y estudiantes
	  //@JsonIgnoreProperties({"usuario","hibernateLazyInitializer","handler"})
	  //@OneToOne(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
	  //private Estudiante estudiante;
	
	//relación entre usuarios y profesores
	  //@JsonIgnoreProperties({"usuario","hibernateLazyInitializer","handler"})
	  //@OneToOne(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
	  //private Profesor profesor;

}
