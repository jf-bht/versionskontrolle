package org.example;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    private Socket s;
    private OutputStreamWriter writer;
    public Client() throws IOException {
        s = new Socket("127.0.0.1", 8080);
        writer = new OutputStreamWriter(s.getOutputStream(), "UTF-8");

        writer.write("Hallo, Welt");
        writer.flush();   // Sehr wichtig!
        writer.close();
        s.close();
    }

    int a;
    public static void main(String[] args) {
        try {
            new Client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
