package com.uniondata.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.uniondata.workshopmongo.domain.Post;
import com.uniondata.workshopmongo.domain.User;
import com.uniondata.workshopmongo.dto.AuthorDTO;
import com.uniondata.workshopmongo.repository.PostRepository;
import com.uniondata.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository; // Salvando estes usuários no banco de dados;
	
	@Autowired
	private PostRepository postRepository; // Salvando estes posts também no banco de dados;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // Qnd criar uma data, passando o String, vai instanciar essa data, considerando que seja o horário de Greenwich (Londres);
		
		userRepository.deleteAll(); // Zera a coleção lá no MongoDB antes de incluir outros novos;
		postRepository.deleteAll(); // Limpando também a coleção de posts ao rodar o programa;
		
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob)); // Persistindo os usuários primeiro, antes de relacionar com o DTO, pois no BD n vai achar e vai ficar id nulo;
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços", new AuthorDTO(maria)); // Desta forma que instancia um DTO;
		Post post2 = new Post(null, sdf.parse("23/08/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
}