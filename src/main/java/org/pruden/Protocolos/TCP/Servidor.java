package org.pruden.Protocolos.TCP;

import org.pruden.Protocolos.Persona;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static org.pruden.Pausa.pausa;

public class Servidor {

    static final int Puerto = 2025;

    public static void main(String[] args) {
        System.out.println("Servidro abierto, esperando al cliente...");

        try{
            ServerSocket servidor = new ServerSocket(Puerto);
            Socket cliente = servidor.accept();
            System.out.println("\nCliente encontrado: " + cliente.getInetAddress().getHostName());

            pausa();

            ObjectInputStream leerPersona = new ObjectInputStream(cliente.getInputStream());
            Persona persona = (Persona) leerPersona.readObject();
            System.out.println("\nPersona recibida: " + persona.getNombre());

            pausa();

            persona.setNombre(persona.getNombre().toUpperCase()+"__MODIFICADO");
            persona.setEdad(persona.getEdad()+10000);
            System.out.println("\nPersona actualizada: " + persona);

            pausa();

            System.out.println("\n\nDevolviendo persona actualizada...\n");
            ObjectOutputStream devolverPersona = new ObjectOutputStream(cliente.getOutputStream());
            devolverPersona.writeObject(persona);
            devolverPersona.flush();

            pausa();

            System.out.println("\nPersona enviada al cliente");

            System.out.println("\nServidor cerrado...");

            devolverPersona.close();
            leerPersona.close();
            cliente.close();
            servidor.close();


        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
