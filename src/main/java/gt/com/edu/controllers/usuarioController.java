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
import gt.com.edu.model.services.IUsuarioService;
import gt.com.edu.models.entity.Usuario;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins={"http://localhost:4200","*"})
public class usuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/listar")
	public List<Usuario> index(){
		return usuarioService.findAll();
	
		
	}
	
	@GetMapping("/buscar/{id}")
	public Usuario show(@PathVariable Long  id) {
		return usuarioService.findById(id);
		
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
		
	}
	
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		
		Usuario usuarioActual=usuarioService.findById(id);
		
		usuarioActual.setId(usuario.getId());
		usuarioActual.setEnabled(usuario.getEnabled());
		usuarioActual.setNombre_usuario(usuario.getNombre_usuario());
		usuarioActual.setContraseña_usuario(usuario.getContraseña_usuario());
		return usuarioService.save(usuarioActual);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
	usuarioService.delete(id);
		
		
		
	}


}
