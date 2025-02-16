package org.pruden.Hilos.CincoFilosofos;

public class Mesa {
    private boolean[] tenedores;

    public Mesa(int numTenedores) {
        this.tenedores = new boolean[numTenedores];
    }

    public int tenedorIzquierdo(int i){
        return i;
    }

    public int tenedorDerecho(int i){
        return (i == 0) ? this.tenedores.length - 1 : i - 1;
    }

    public synchronized void cogerTenedores(int comensal){
        while(tenedores[tenedorIzquierdo(comensal)] || tenedores[tenedorDerecho(comensal)]){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        tenedores[tenedorIzquierdo(comensal)] = true;
        tenedores[tenedorDerecho(comensal)] = true;
    }

    public synchronized void dejarTenedores(int comensal){
        tenedores[tenedorIzquierdo(comensal)] = false;
        tenedores[tenedorDerecho(comensal)] = false;

        notifyAll();
    }
}
