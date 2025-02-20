package org.pruden.Hilos.elJefe;

public class Main {
    public static void main(String[] args) {
        Saludo saludo = new Saludo();

        Empleado e1 = new Empleado("paco",saludo, false);
        Empleado e2 = new Empleado("manolo",saludo, false);
        Empleado e3 = new Empleado("pepe",saludo, false);
        Empleado e4 = new Empleado("JEFE",saludo, true);
        Empleado e5 = new Empleado("luis",saludo, false);

        e1.start();
        e2.start();
        e3.start();
        e4.start();
        e5.start();
    }
}
