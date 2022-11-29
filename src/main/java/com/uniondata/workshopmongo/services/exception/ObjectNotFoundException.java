package com.uniondata.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L; // Usando runtime para fzer um macete para criar uma classe auxiliar para tratar a exceção;

	public ObjectNotFoundException(String msg) {
		super(msg); // Repassar a chamada para a superclasse RuntimeException passando esta mensagem;
	}	
}