package com.moreiraf7.workshopmongo.resource;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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
}
