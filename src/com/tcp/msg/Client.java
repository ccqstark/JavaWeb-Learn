package com.tcp.msg;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import static java.lang.Thread.sleep;

//客户端
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {

        Socket socket = null;
        OutputStream os = null;

        //确定服务器的地址和端口
        InetAddress serveIP = InetAddress.getByName("127.0.0.1");
        int port = 9999;


        while (true) {
            try {
                //建立一个socket连接
                socket = new Socket(serveIP, port);
                //发送消息的IO流
                os = socket.getOutputStream();
                os.write("ccq学习javaWeb的socket".getBytes());

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
            sleep(1000);
        }
    }
}
