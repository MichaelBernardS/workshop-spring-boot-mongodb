package com.uniondata.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL { // Classe utilitária URL com um método para decoficiar parâmetro de URL;
	
	public static String decodeParam(String text) { // Estático para não precisar instanciar um objeto URL;
		try {
			return URLDecoder.decode(text, "UTF-8"); // O texto que vai decodificar, e qual o padrão de decodificação usado;
		} catch (UnsupportedEncodingException e) {
			return ""; // Ou ele retorna a String decodificada, ou um String vazio caso dê algum problema;
		}
	}
}