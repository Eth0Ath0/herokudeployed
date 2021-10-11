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

import gt.com.edu.model.services.ICalificacionService;

import gt.com.edu.models.entity.Calificacion;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins={"http://localhost:4200","*"})
public class calificacionController {
	
	@Autowired
	public ICalificacionService calificacionService;
	
	
	@GetMapping("/calificaciones")
	public List<Calificacion> index(){
		return calificacionService.findAll();
	
		
	}
	

	@GetMapping("/calificaciones/{id}")
	public Calificacion show(@PathVariable Long  id) {
		return calificacionService.findById(id);
		
	}
	
	@PostMapping("/calificaciones")
	@ResponseStatus(HttpStatus.CREATED)
	public Calificacion create(@RequestBody Calificacion calificacion) {
		return calificacionService.save(calificacion);
		
	}
	
	@PutMapping("/calificaciones/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Calificacion update(@RequestBody Calificacion calificacion, @PathVariable Long id) {
		
		
		Calificacion calificacionActual=calificacionService.findById(id);
		
		calificacionActual.setId(calificacion.getId());
		calificacionActual.setNota_bim1(calificacion.getNota_bim1());
		calificacionActual.setNota_bim2(calificacion.getNota_bim2());
		calificacionActual.setNota_bim3(calificacion.getNota_bim3());
		calificacionActual.setNota_bim4(calificacion.getNota_bim4());
		calificacionActual.setPromedio_final(calificacion.getPromedio_final());
		
		return calificacionService.save(calificacionActual);
	}
	
	@DeleteMapping("/calificaciones/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
    calificacionService.delete(id);
		
		
		
	}
	

}
