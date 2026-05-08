
/* Simple HTTP server. It reads the request line, but doesn't do any
 * processing. It also ignores the request headers.
 */


// Version 2.0 - Updated for Push and time machine
package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String args[]) throws IOException{
        int ch;
        ServerSocket server = new ServerSocket(8080);
        for(int i=0; i<10; i++){
            System.out.println(" Connection "+i);
            Socket connection = server.accept();
            // Read HTTP request line
            InputStream is = connection.getInputStream();
            do{
                ch = is.read();
                if (ch == -1) {
                    break;
                }
                System.out.write((byte)ch); // echo
            }while (ch != '\n');
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(
                    "HTTP/1.0 200 Ok\r\n"+
                            "Content-Type: text/plain\r\n\r\n"+
                            "Hello, world!"
            );
            writer.close();
        }
        server.close();
    }
}// Login Feature
