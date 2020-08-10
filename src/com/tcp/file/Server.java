package com.tcp.file;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("receive.jpg"));

        byte[] buffer = new byte[1024];
        int len;
        while ((len=inputStream.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        OutputStream os = socket.getOutputStream();
        os.write("接收完毕".getBytes());

        fos.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
