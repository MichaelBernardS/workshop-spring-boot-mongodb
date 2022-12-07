package com.uniondata.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniondata.workshopmongo.domain.Post;
import com.uniondata.workshopmongo.resources.util.URL;
import com.uniondata.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service; // Da mesma forma que instanciamos o repositório no serviço, estamos instanciando o serviço no repositório;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) { // @PathVariable faz casar o id do value com este do argumento;
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj); 
	}
	
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) { // Critério de busca vai ser passado por param, e o endpoint vai identificar o nome do parâmetro dado na requisição, e se esse param n for informado, vai ser um valor vazio;
		text = URL.decodeParam(text); // Decodifica o texto para nós;
		List<Post> list = service.findByTitle(text); // Recebendo esse texto como título para procurar;
		return ResponseEntity.ok().body(list);  // Retornar o corpo da resposta, cujo será esta lista;
	}
}