package com.uniondata.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniondata.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() { // ResponseEntity objeto sofisticado, que encapsula toda a estrutura necessária para retornar resposta http já com possíveis cabeçalhos, erros, e assim por diante;
			User maria = new User("1", "Maria Brown", "maria@gmail.com"); // Teste para saber se está instanciando direitinho os usuários;
			User alex = new User("2", "Alex Green", "alex@gmail.com");
			List <User> list = new ArrayList<>();
			list.addAll(Arrays.asList(maria, alex));
			return ResponseEntity.ok().body(list); // Ok é um método que instancia o ResponseEntity já com o código de resposta http que a resposta ocorreu com sucesso. O body define qual o corpo desta resposta, ou seja, a lista.
	}
}