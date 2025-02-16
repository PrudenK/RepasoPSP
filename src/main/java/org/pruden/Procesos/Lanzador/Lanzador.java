package org.pruden.Procesos.Lanzador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Lanzador {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        String dir = System.getProperty("user.dir");

        System.out.println("Introduce el número 1");
        int num1 = sc.nextInt();

        System.out.println("Introduce el número 2");
        int num2 = sc.nextInt();

        String numeros = num1 +"@"+ num2;

        System.out.println(dir);
                                                        //package org.pruden.Procesos.Lanzador;
        ProcessBuilder pb = new ProcessBuilder("java", "org.pruden.Procesos.Lanzador.Sumador" ,numeros);
        File directorio =  new File(dir+"/target/classes");

        pb.directory(directorio);

        Process p = pb.start();

        OutputStream os = p.getOutputStream();
        os.write(numeros.getBytes());
        os.flush();
        os.close();

        try{
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }
            is.close();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
