package com.github.lauraneale;

public class Main {

    public static void main(String[] args) {
        Coordinator monitor = new Coordinator();
        Thread ping = new Thread(new Pinger(monitor, "ping"));
        Thread pong = new Thread(new Pinger(monitor, "pong"));
        ping.start();
        pong.start();
    }
}
