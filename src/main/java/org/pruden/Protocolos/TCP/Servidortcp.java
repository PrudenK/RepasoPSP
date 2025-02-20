package org.pruden.Protocolos.TCP;

import java.net.*;

import java.io.*;


public class Servidortcp {

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(12345);

        while (true) {
            byte[] buf = new byte[1024];
            DatagramPacket recibo = new DatagramPacket(buf, buf.length);

            socket.receive(recibo);

            String mensaje = new String(recibo.getData(), 0, recibo.getLength());
            System.out.println(mensaje);
        }

    }
}