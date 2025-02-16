package org.pruden.Procesos;

import java.io.IOException;
import java.util.Scanner;

public class AbrirPaginaWeb {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la página web que vas a buscar");
        String pagina = sc.nextLine();

        ProcessBuilder pb = new ProcessBuilder("firefox", pagina); // kosole, kcalc

        pb.start();
    }
}
