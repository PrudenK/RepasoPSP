package org.pruden.Protocolos.TCP;

import org.pruden.Protocolos.Persona;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import static org.pruden.Pausa.pausa;

public class Cliente {

    static final int Puerto = 2025;
    static final String Host = "localhost";
    static final Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        try{
            Socket sCliente = new Socket(Host, Puerto);
            System.out.println("Vamos a enviar una persona al servidor");
            System.out.println("Introduce su nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Introduce su edad: ");
            int edad = sc.nextInt();
            Persona persona = new Persona(nombre, edad);
            System.out.println("\nEnviando objeto persona al servidor...\n");

            pausa();

            ObjectOutputStream oos = new ObjectOutputStream(sCliente.getOutputStream());
            oos.writeObject(persona);
            oos.flush();

            System.out.println("Recibiendo persona modifcada por el servidor...\n");

            pausa();

            ObjectInputStream recibirPersona = new ObjectInputStream(sCliente.getInputStream());
            Persona personaRecibida = (Persona) recibirPersona.readObject();
            System.out.println("Persona modificada: "+personaRecibida);

            pausa();

            System.out.println("Cliente cerrado...");

            oos.close();
            recibirPersona.close();
            sCliente.close();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
