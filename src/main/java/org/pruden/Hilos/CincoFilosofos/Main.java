package org.pruden.Hilos.CincoFilosofos;

public class Main {
    public static void main(String[] args) {
        int numTenedores = 5;
        Mesa m = new Mesa(numTenedores);


        for (int i = 1; i <= numTenedores; i++) {
            Filosofo filosofo = new Filosofo(m, i);
            filosofo.start();
        }
    }
}
