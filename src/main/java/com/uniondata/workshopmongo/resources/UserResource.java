package com.uniondata.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniondata.workshopmongo.domain.User;
import com.uniondata.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service; // Da mesma forma que instanciamos o repositório no serviço, estamos instanciando o serviço no repositório;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() { // ResponseEntity objeto sofisticado, que encapsula toda a estrutura necessária para retornar resposta http já com possíveis cabeçalhos, erros, e assim por diante
			List <User> list = service.findAll(); // BUsca no BD os usuários e guarda nessa lista;
			return ResponseEntity.ok().body(list); // Ok é um método que instancia o ResponseEntity já com o código de resposta http que a resposta ocorreu com sucesso. O body define qual o corpo desta resposta, ou seja, a lista.
	}
}