package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8965);

        Socket s = ss.accept();
        InputStream is = s.getInputStream();

        System.out.println("Connection is established");

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while (true) {
            String cur = br.readLine();
            if (cur.trim().length() == 0) break;
            System.out.println(cur);
        }

        OutputStream os = s.getOutputStream();

        String msg = "HTTP/1.1 200 OK\r\n" +
                "Date: Sun, 18 Oct 2009 08:56:53 GMT\r\n" +
                "Server: Apache/2.2.14 (Win32)\r\n" +
                "Last-Modified: Sat, 20 Nov 2004 07:16:26 GMT\r\n" +
                "ETag: \"10000000565a5-2c-3e94b66c2e680\"\r\n" +
                "Accept-Ranges: bytes\r\n" +
                "Content-Length: 44\r\n" +
                "Connection: close\r\n" +
                "Content-Type: text/html\r\n" +
                "X-Pad: avoid browser bug\r\n" +
                "\r\n" +
                "<html><body><h1>It works!</h1></body></html>";

     /*   Message msg;
        msg.setReturnCode(200);
        msg.addHeader("Content-type", "text/html");
        msg.setHeader("Content-type", "image/jpeg");
        msg.setBody(byte[] b);

        msg.getBytes();*/

        String msg1 = "";
        HTTPMessageBuilder message = new HTTPMessageBuilder();
        message.setReturnString("HTTP/1.1 200 OK");
        message.setHeader("Connection", "close");
        message.setHeader("Content-Type", "text/html");
        msg1 = message.toString();
        System.out.println(msg1);
        os.write(msg.getBytes());
        os.flush();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
