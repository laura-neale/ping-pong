package com.github.lauraneale.pingpong;

public class Main {

    public static void main(String[] args) {
        PingPongCoordinator monitor = new PingPongCoordinator();
        Thread ping = new Thread(new SynchronizedMessenger(monitor, "ping"));
        Thread pong = new Thread(new SynchronizedMessenger(monitor, "pong"));
        ping.start();
        pong.start();
    }
}
