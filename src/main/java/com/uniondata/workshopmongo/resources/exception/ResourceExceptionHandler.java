package com.uniondata.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.uniondata.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice // Annotation para indicar que esta classe é responsável por tratar possíveis erros nas requisições;
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class) // Padrão do framework para funcionar e identificar que qnd ocorrer esta exceção, na vdd é p fzer este tratamento;
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) { // Como parâmetro é o tipo da exceção que vai tratar, e uma exigência do framework que é o httpServlet;

		HttpStatus status = HttpStatus.NOT_FOUND; // Erro 404
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI()); // error = colocar direto uma String (Não encontrado);	;
		return ResponseEntity.status(status).body(err);
	}
}

// Manipulador de exceções na camada de Resource;