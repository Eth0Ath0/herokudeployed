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

import gt.com.edu.model.services.IMatriculaService;
import gt.com.edu.models.entity.Matricula;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins={"http://localhost:4200","*"})
public class matriculaController {
	
	@Autowired
	private IMatriculaService matriculaservice;
	
	@GetMapping("/matriculas")
	public List<Matricula> index(){
		return matriculaservice.findAll();
	
		
	}
	
	@GetMapping("/matriculas/{id}")
	public Matricula show(@PathVariable Long  id) {
		return matriculaservice.findById(id);
		
	}
	
	@PostMapping("/matriculas")
	@ResponseStatus(HttpStatus.CREATED)
	public Matricula create(@RequestBody Matricula matricula) {
		return matriculaservice.save(matricula);
		
	}
	
	@PutMapping("/matriculas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Matricula update(@RequestBody Matricula matricula, @PathVariable Long id) {
		
		Matricula matriculaActual=matriculaservice.findById(id);
		
		matriculaActual.setId_matricula(matricula.getId_matricula());
		matriculaActual.setFecha_matricula(matricula.getFecha_matricula());
		matriculaActual.setObservaciones(matricula.getObservaciones());
		
		return matriculaservice.save(matriculaActual);
	}
	
	@DeleteMapping("/matriculas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		matriculaservice.delete(id);
		
		
		
	}


}
