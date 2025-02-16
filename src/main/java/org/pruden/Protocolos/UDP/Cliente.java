package org.pruden.Protocolos.UDP;

import org.pruden.Protocolos.Persona;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import static org.pruden.Pausa.pausa;

public class Cliente {
    static final int PUERTO = 2026;
    static final String HOST = "localhost";
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            DatagramSocket socketUDP = new DatagramSocket();
            InetAddress destino = InetAddress.getByName(HOST);

            System.out.println("Vamos a enviar una persona al servidor");

            System.out.print("Introduce su nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Introduce su edad: ");
            int edad = sc.nextInt();

            Persona persona = new Persona(nombre, edad);
            System.out.println("\nEnviando objeto persona al servidor...\n");

            pausa();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(persona);
            oos.close();

            byte[] datosPersona = baos.toByteArray();

            DatagramPacket paqueteEnvio = new DatagramPacket(datosPersona, datosPersona.length, destino, PUERTO);
            socketUDP.send(paqueteEnvio);

            System.out.println("Recibiendo persona modificada por el servidor...\n");
            pausa();

            byte[] buffer = new byte[1024];
            DatagramPacket paqueteRecepcion = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(paqueteRecepcion);

            ByteArrayInputStream bais = new ByteArrayInputStream(paqueteRecepcion.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Persona personaRecibida = (Persona) ois.readObject();

            System.out.println("Persona modificada: " + personaRecibida);
            pausa();

            System.out.println("Cliente cerrado...");
            socketUDP.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
