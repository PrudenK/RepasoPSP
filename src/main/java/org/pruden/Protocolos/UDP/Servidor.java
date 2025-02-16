package org.pruden.Protocolos.UDP;

import org.pruden.Protocolos.Persona;

import java.io.*;
import java.net.*;

import static org.pruden.Pausa.pausa;

public class Servidor {
    static final int PUERTO = 2026;

    public static void main(String[] args) {
        System.out.println("Servidor abierto, esperando al cliente...");

        try {
            DatagramSocket socketUDP = new DatagramSocket(PUERTO);

            byte[] buffer = new byte[1024];

            DatagramPacket paqueteRecepcion = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(paqueteRecepcion);

            ByteArrayInputStream bais = new ByteArrayInputStream(paqueteRecepcion.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Persona persona = (Persona) ois.readObject();

            System.out.println("\nPersona recibida: " + persona.getNombre());
            pausa();

            persona.setNombre(persona.getNombre().toUpperCase() + "__MODIFICADO");
            persona.setEdad(persona.getEdad() + 10000);
            System.out.println("\nPersona actualizada: " + persona);
            pausa();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(persona);
            oos.close();

            byte[] datosModificados = baos.toByteArray();

            DatagramPacket paqueteEnvio = new DatagramPacket(datosModificados, datosModificados.length,
                    paqueteRecepcion.getAddress(), paqueteRecepcion.getPort());
            socketUDP.send(paqueteEnvio);

            pausa();

            System.out.println("\nPersona enviada al cliente");
            System.out.println("\nServidor cerrado...");
            socketUDP.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
