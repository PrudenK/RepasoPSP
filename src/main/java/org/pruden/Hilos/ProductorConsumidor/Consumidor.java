package org.pruden.Hilos.ProductorConsumidor;

public class Consumidor extends Thread {

    private DatoCompartido datoCompartido;

    public Consumidor(DatoCompartido datoCompartido) {
        this.datoCompartido = datoCompartido;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (datoCompartido) {
                if(datoCompartido.getListaCompartido().isEmpty()){
                    try {
                        datoCompartido.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                datoCompartido.removeNumero();

                datoCompartido.notify();
            }
        }
    }
}
