package org.osgiexample.mvnbundleplugin;

public class HelloWorldThread extends Thread {
    private boolean running = true;

    public HelloWorldThread() {
        super("Hello World");
    }

    public void run() {
        while (running) {
            System.out.println("Hello World - Built by Maven Bundle Plugin!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("HelloWorldThread ERROR: " + e);
            }
        }
        System.out.println("thread stopped");
    }

    public void stopThread() {
        System.out.println("stopping thread");
        this.running = false;
    }
}
