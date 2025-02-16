package org.pruden.Procesos.Lanzador;

public class Sumador {
    public static void main(String[] args) {
        String[] vector = args[0].split("@");

        int num1 = Integer.parseInt(vector[0]);
        int num2 = Integer.parseInt(vector[1]);

        System.out.println("La suma de "+num1+" e "+num2+" son iguales a "+(num1+num2));
    }
}
