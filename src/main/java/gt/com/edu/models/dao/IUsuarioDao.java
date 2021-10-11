package gt.com.edu.models.dao;

import org.springframework.data.repository.CrudRepository;

import gt.com.edu.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}
