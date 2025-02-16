package org.pruden.Procesos.LeerDeUnTerminal;

import java.io.InputStream;
import java.util.Scanner;

public class LeerDeUnTerminal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe un comando para ver su manual:");
        String comando = sc.nextLine();

        ProcessBuilder pb = new ProcessBuilder("man", comando);

        try {
            Process p = pb.start();
            InputStream is = p.getInputStream();
            int c;

            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
