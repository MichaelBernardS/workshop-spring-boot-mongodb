package com.uniondata.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniondata.workshopmongo.domain.Post;
import com.uniondata.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service; // Da mesma forma que instanciamos o repositório no serviço, estamos instanciando o serviço no repositório;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) { // @PathVariable faz casar o id do value com este do argumento;
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj); // Gerar a resposta a partir do objeto User, convertido para UserDTO; Basta chamar o objeto User como argumento pro DTO;
	}
}