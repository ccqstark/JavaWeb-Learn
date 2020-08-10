package com.udp.chat2;

public class Teacher {
    public static void main(String[] args) {
        new Thread(new TalkerSend(5555,"localhost",8888)).start();
        new Thread(new TalkerReceive(9999,"学生")).start();
    }
}
