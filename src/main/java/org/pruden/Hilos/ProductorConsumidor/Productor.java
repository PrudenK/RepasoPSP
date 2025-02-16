package org.pruden.Hilos.ProductorConsumidor;

public class Productor extends Thread {
    private DatoCompartido datoCompartido;

    public Productor(DatoCompartido datoCompartido) {
        this.datoCompartido = datoCompartido;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (datoCompartido) {
                if(datoCompartido.getListaCompartido().size() == datoCompartido.getTama()){
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

                datoCompartido.addNumero();

                datoCompartido.notify();
            }
        }
    }
}
