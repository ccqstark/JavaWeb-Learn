package com.udp.sc;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {
    public static void main(String[] args) throws Exception {

        //建立socket
        DatagramSocket socket = new DatagramSocket();

        //数据内容
        String msg = "你好呀";

        //建个包，写上地址和端口
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 9090;
        DatagramPacket packet = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,inetAddress,port);

        //发送包
        socket.send(packet);

        //关闭socket
        socket.close();

    }
}
