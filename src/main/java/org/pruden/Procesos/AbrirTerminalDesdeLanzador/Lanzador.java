package org.pruden.Procesos.AbrirTerminalDesdeLanzador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Lanzador {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String dir = System.getProperty("user.dir");

        System.out.println("Introduce un comando");
        String comando = sc.nextLine();

        ProcessBuilder pb = new ProcessBuilder("java", "org.pruden.Procesos.AbrirTerminalDesdeLanzador.Terminal");
        File direc = new File(dir+"/target/classes");

        pb.directory(direc);
        Process p = pb.start();

        OutputStream os = p.getOutputStream();

        os.write(comando.getBytes());
        os.flush();
        os.close();

        InputStream e = p.getErrorStream();
        int c;
        while ((c = e.read()) != -1) {
            System.out.print((char) c);
        }
        e.close();
    }
}
