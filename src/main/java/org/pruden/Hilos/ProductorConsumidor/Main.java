package org.pruden.Hilos.ProductorConsumidor;

public class Main {
    public static void main(String[] args) {
        DatoCompartido dc = new DatoCompartido(5);

        Consumidor c = new Consumidor(dc);
        Productor p = new Productor(dc);

        c.start();
        p.start();
    }
}
