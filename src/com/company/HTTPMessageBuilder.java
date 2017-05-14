package com.company;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Boradatoe_Solntse on 08.05.2017.
 */
public class HTTPMessageBuilder {
    String m_ret;
    String shift = "\r\n";
    Map<String, String> m_header = new TreeMap<>();

    public void setHeader(String header, String value){
        m_header.put(header, value);
    }

    public String toString(){
        String result = m_ret + shift;
        for (Map.Entry<String, String> kv: m_header.entrySet()) {
         //   kv.getKey();
         //   kv.getValue();
            result += kv.getKey() + ": " + kv.getValue() + shift;
        }
        result += shift;

        return result;
    }


    public void setReturnString(String ret) {
        m_ret = ret;
    }
}

//msg.setReturnString("HTTP/1.1 200 OK");
