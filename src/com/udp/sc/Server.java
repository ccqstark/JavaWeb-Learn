package com.udp.sc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
//也是要等待客户端连接
public class Server {
    public static void main(String[] args) throws IOException {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        //建立接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
        //接受包，阻塞
        socket.receive(packet);
        //关闭socket
        socket.close();

        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(new String(packet.getData()));

    }
}
