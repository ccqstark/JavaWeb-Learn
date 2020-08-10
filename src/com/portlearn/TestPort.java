package com.portlearn;

import java.net.InetSocketAddress;

public class TestPort {

    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
        System.out.println(socketAddress);
        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress.getPort());
    }
}
