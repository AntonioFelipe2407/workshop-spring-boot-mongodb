package com.moreiraf7.workshopmongo.resource;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL implements Serializable {


    /*
    CLASSE AUXILIAR PARA DECODIFICAR PARAMETROS PASSADOS NA URL
     */

    public static String decodeParam(String text){
        try {
        return URLDecoder.decode(text, "UTF-8");
        }
        catch (UnsupportedEncodingException e){
            return "";
        }
    }

    public static LocalDate converterDate(String textDate, LocalDate defaultValue){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Formatacao da data
        try {
        return LocalDate.parse(textDate, fmt); // retorna o textDate convertido em LocalDate
        }
        catch (DateTimeParseException e){
            return defaultValue; // Retorna o valor default se nao for passado a data ou se tiver dato problema
        }
    }
}
