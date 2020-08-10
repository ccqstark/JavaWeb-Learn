package com.udp.chat2;

import sun.security.mscapi.CPublicKey;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TalkerSend implements Runnable {

    DatagramSocket socket = null;
    BufferedReader bufferedReader = null;
    private int fromPort;
    private String toIP;
    private int toPort;

    public TalkerSend(int fromPort, String toIP, int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;
        try {
            socket = new DatagramSocket(this.fromPort);
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            try {

                String data = bufferedReader.readLine();
                byte[] datas = data.getBytes();

                DatagramPacket datagramPacket = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.toIP, this.toPort));

                socket.send(datagramPacket);

                if (data.equals("bye")) {
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        socket.close();
    }


}
