package com.tcp.file;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9000);
        OutputStream os = socket.getOutputStream();

        //文件流传输
        FileInputStream fis = new FileInputStream(new File("backend.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }

        //告知服务端传输完成
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        byte[] buffer2 = new byte[1024];
        while ((len=inputStream.read(buffer2))!=-1){
            byteArrayOutputStream.write(buffer2,0,len);
        }
        System.out.println(byteArrayOutputStream.toString());


        fis.close();
        os.close();
        socket.close();

    }

}
