package org.pruden.Hilos.elJefe;

public class Empleado extends Thread {
    String nombre;
    Saludo saludo;
    boolean esJefe;

    public Empleado(String nombre, Saludo saludo, boolean esJefe) {
        this.nombre = nombre;
        this.saludo = saludo;
        this.esJefe = esJefe;
    }

    @Override
    public void run() {
        System.out.println("ENTRA --- "+nombre);

        this.saludo.saludar(this);
    }
}
