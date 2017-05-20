package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9000);

        Socket s = ss.accept();
        InputStream is = s.getInputStream();

        System.out.println("Connection is established");

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String request = "";
        while (true) {
            String cur = br.readLine();
            if (cur.trim().length() == 0) break;
            System.out.println(cur);
            request = request + cur;
        }
        HTTPParser parser = new HTTPParser();
        parser.parse(request);
        System.out.println(parser.getPath());
        OutputStream os = s.getOutputStream();

        HTTPMessageBuilder message = new HTTPMessageBuilder();
        message.setReturnString("HTTP/1.1 200 OK");
        message.setHeader("Connection", "close");
        message.setHeader("Content-Type", "text/html");
        message.setBody("<html><body><h1>It worksasasasas!</h1></body></html>".getBytes());
        os.write(message.getBytes());
        os.flush();
        /*
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        s.close();
    }
}
