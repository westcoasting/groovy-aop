package com.domain.messaging;

public class MessageCommunicator {

    public void deliver(String message) {
        System.out.println(message);
    }
    public void deliver(String person, String message) {
        System.out.println(person + ", " + message);
    }

    public static void main (String[] args) {
        System.out.println("Printing");
    }
}
