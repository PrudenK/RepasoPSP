package org.pruden.Hilos.CincoFilosofos;

import java.util.Random;

public class Filosofo extends Thread {
    private Mesa mesa;
    private int comensal;
    private int indiceComensal;

    private Random r = new Random();

    public Filosofo(Mesa mesa, int comensal) {
        this.mesa = mesa;
        this.comensal = comensal;
        this.indiceComensal = comensal - 1;
    }

    public void run() {
        while (true) {
            this.pensando();
            this.mesa.cogerTenedores(this.indiceComensal);
            this.comiendo();
            System.out.println("Filósofo "+comensal+ " deja de comer, tenedores libres "+ (this.mesa.tenedorIzquierdo(this.indiceComensal)+1) +", "
                                 + (this.mesa.tenedorDerecho(this.indiceComensal)+1));
            this.mesa.dejarTenedores(this.indiceComensal);
        }
    }

    public void pensando(){
        block("pensando");
    }

    public void comiendo(){
       block("comiendo");
    }

    private void block(String esta){
        System.out.println("Filosofo "+ comensal + " esta "+esta);

        try {
            Thread.sleep(r.nextInt(2000)+1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
