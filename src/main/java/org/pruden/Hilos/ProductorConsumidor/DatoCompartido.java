package org.pruden.Hilos.ProductorConsumidor;

import java.util.ArrayList;
import java.util.Random;

public class DatoCompartido {
    private Random r = new Random();
    private int tama;
    private ArrayList<Integer> compartido = new ArrayList<>();

    public DatoCompartido(int tama) {
        this.tama = tama;
    }

    public synchronized void addNumero() {
        int random = r.nextInt(tama)+1;

        compartido.add(random);

        System.out.println("Dato añadido :"+random+" lista: "+compartido);
    }

    public synchronized void removeNumero() {
        System.out.println("Dato borrado :"+compartido.removeLast()+" lista: "+compartido);
    }

    public ArrayList<Integer> getListaCompartido() {
        return compartido;
    }

    public int getTama() {
        return tama;
    }
}
