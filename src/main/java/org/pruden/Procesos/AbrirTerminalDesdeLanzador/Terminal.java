package org.pruden.Procesos.AbrirTerminalDesdeLanzador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Terminal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String comando = br.readLine();

        ProcessBuilder pb = new ProcessBuilder("konsole","-e", "bash", "-c", comando+ "; exec bash");
        pb.start();


    }
}
