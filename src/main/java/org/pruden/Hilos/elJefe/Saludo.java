package org.pruden.Hilos.elJefe;

public class Saludo {
    private static boolean haEntrado = false;


    public synchronized void saludar(Empleado empleado) {
        if(empleado.esJefe){
            saludoJefe();
        }else saludoEmpleado(empleado.nombre);
    }

    private synchronized void saludoEmpleado(String nombre) {
        if(!haEntrado){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Buenos días: ---"+nombre);
        }else{
            System.out.println("Perdon por el retraso "+nombre);
        }
    }

    private synchronized void saludoJefe(){
        System.out.println("El jefe ha entrado");
        haEntrado = true;
        notifyAll();
    }
}
