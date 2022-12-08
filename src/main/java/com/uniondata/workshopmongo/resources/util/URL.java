package com.uniondata.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL { // Classe utilitária URL com um método para decodificar parâmetro de URL e para tratar datas recebidas;
	
	public static String decodeParam(String text) { // Estático para não precisar instanciar um objeto URL;
		try {
			return URLDecoder.decode(text, "UTF-8"); // O texto que vai decodificar, e qual o padrão de decodificação usado;
		} catch (UnsupportedEncodingException e) {
			return ""; // Ou ele retorna a String decodificada, ou um String vazio caso dê algum problema;
		}
	}
	
	public static Date convertDate(String textDate, Date defaultValue) { // Método para converter uma data, recebendo um String como arg, que vai ser uma data na forma de String, e uma data padrão caso a conversão falhe;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return sdf.parse(textDate);
		} catch (ParseException e) {
			return defaultValue;
		}
	}
}