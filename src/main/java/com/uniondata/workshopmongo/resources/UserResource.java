package com.uniondata.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniondata.workshopmongo.domain.User;
import com.uniondata.workshopmongo.dto.UserDTO;
import com.uniondata.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service; // Da mesma forma que instanciamos o repositório no serviço, estamos instanciando o serviço no repositório;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() { // ResponseEntity objeto sofisticado, que encapsula toda a estrutura necessária para retornar resposta http já com possíveis cabeçalhos, erros, e assim por diante;
		List<User> list = service.findAll(); // Busca no BD os usuários e guarda nessa lista;
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); // Receber a conversão de cada elemento da lista original para um DTO; Conversão de lista para stream, e stream para lista; Dentro do map, ele vai pegar para cada objeto deste (x) que vai ser um usuário, vai retornar um novo usuário dto passando este x como argumento;
		return ResponseEntity.ok().body(listDto); // Ok é um método que instancia o ResponseEntity já com o código de resposta http que a resposta ocorreu com sucesso. O body define qual o corpo desta resposta, ou seja, a lista;
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) { // @PathVariable faz casar o id do value com este do argumento;
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj)); // Gerar a resposta a partir do objeto User, convertido para UserDTO; Basta chamar o objeto User como argumento pro DTO;
	}
}