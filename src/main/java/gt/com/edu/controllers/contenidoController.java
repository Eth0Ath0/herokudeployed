package gt.com.edu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gt.com.edu.model.services.IContenidoService;
import gt.com.edu.models.entity.Contenido;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins={"http://localhost:4200","*"})
public class contenidoController {
	
	@Autowired
	private IContenidoService contenidoService;
	
	@GetMapping("/contenidos")
	public List<Contenido> index(){
		return contenidoService.findAll();
	
		
	}
	

	@GetMapping("/contenidos/{id}")
	public Contenido show(@PathVariable Long  id) {
		return contenidoService.findById(id);
		
	}
	
	@PostMapping("/contenidos")
	@ResponseStatus(HttpStatus.CREATED)
	public Contenido create(@RequestBody Contenido contenido) {
		return contenidoService.save(contenido);
		
	}
	
	@PutMapping("/contenidos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Contenido update(@RequestBody Contenido contenido, @PathVariable Long id) {
		
		
		Contenido contenidoActual=contenidoService.findById(id);
		
		contenidoActual.setId(contenido.getId());
		contenidoActual.setNombre_contenido(contenido.getNombre_contenido());
		contenidoActual.setFecha_creacion(contenido.getFecha_creacion());
		contenidoActual.setArchivo(contenido.getArchivo());
		
		return contenidoService.save(contenidoActual);
	}
	
	@DeleteMapping("/contenidos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
    contenidoService.delete(id);
		
		
		
	}
	
	

}
