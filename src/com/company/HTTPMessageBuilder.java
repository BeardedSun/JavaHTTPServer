package com.company;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Boradatoe_Solntse on 08.05.2017.
 */
public class HTTPMessageBuilder {
    private String m_ret;
    private String shift = "\r\n";
    private Map<String, String> m_header = new TreeMap<>();
    private byte[] m_body;

    public void setHeader(String header, String value){
        m_header.put(header, value);
    }

    public void setBody(byte[] body){
        m_body = body;
    }

    public byte[] getBytes(){
        byte[] byte_headers = toString().getBytes();
        byte[] b_msg = new byte[byte_headers.length + m_body.length];
        System.arraycopy(byte_headers, 0, b_msg, 0, byte_headers.length);
        System.arraycopy(m_body, 0, b_msg, byte_headers.length, m_body.length);
        return b_msg;
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


