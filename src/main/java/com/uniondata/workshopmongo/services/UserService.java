package com.uniondata.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniondata.workshopmongo.domain.User;
import com.uniondata.workshopmongo.dto.UserDTO;
import com.uniondata.workshopmongo.repository.UserRepository;
import com.uniondata.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired // Spring instancia este objeto automaticamente;
	private UserRepository repo; // Pelo sistema de camadas, o serviço tem que conversar com o repositório;
	
	public List<User> findAll() {
		return repo.findAll(); // Método já existente no repository, que puxa tds os usuários do banco de dados;
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) { // Este obj que vai vir como argumento, vai ser os dados que o usuário vai mandar na requisição;
		User newObj = findById(obj.getId()); // O dado que o usuário passa não está no BD, portanto, iremos buscar esse dado original lá no BD;
		updateData(newObj, obj); // Método responsável por copiar os novos dados do obj, para o newObj, ou seja, pegar os dados que foram passados como arg (obj), e atualizar o newObj (novo usuário q estamos atualizando);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDTO) { // Método que pega um DTO e instancia um usuário, caminho inverso que foi feito no DTO; Foi colocada essa classe no UserService pois dependendo da situação, para instanciar um User, podemos querer acessar o banco de dados, e quem tem a dependência é o UserService. Com isto, ajuda na manutenção futura, caso tenha acesso a dados; Viola o princípio da responsabilidade única (SRP); 
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}

// Serviço responsável por trabalhar com usuários;