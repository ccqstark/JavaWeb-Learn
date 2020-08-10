package com.udp.chat2;

public class Student {
    public static void main(String[] args) {
        new Thread(new TalkerSend(7777,"localhost",9999)).start();
        new Thread(new TalkerReceive(8888,"老师")).start();
    }
}
