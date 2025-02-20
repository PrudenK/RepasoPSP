package org.pruden.Protocolos.TCP;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Clientetcp {

    public static void main(String[] args) throws IOException {
        DatagramSocket socketUDP = new DatagramSocket();

        InetAddress destino = InetAddress.getByName("localhost");

        Scanner sc = new Scanner(System.in);

        while(true) {
            String mensaje = sc.nextLine();

            byte[] bytes = mensaje.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, destino, 12345);
            socketUDP.send(packet);

        }
    }
}