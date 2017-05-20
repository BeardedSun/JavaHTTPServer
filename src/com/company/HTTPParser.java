package com.company;

import java.util.TreeMap;
import java.util.Map;

/**
 * Created by Boradatoe_Solntse on 17.05.2017.
 */
public class HTTPParser {
    private String path = "";
    private Map<String, String> headers = new TreeMap<>();

    public void parse(String req){
        int i = req.indexOf(" ");
        int j = req.indexOf(" ", i);
        path += req.substring(i + 1, j);
       // [a;b)
    }
    public String getPath(){
        return path;
    }
}
