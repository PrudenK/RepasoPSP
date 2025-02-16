package org.pruden.Streams;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    private static ArrayList<Persona> personas = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("Personas.csv"));

        String linea;
        while ((linea = br.readLine()) != null){
            if(!linea.equals("nombre,apellidos,edad,telefono,email,dinero")) procesarPersona(linea);
        }

        System.out.println("------------IMPRIMIR LISTA--------------------\n\n");

        personas.forEach(System.out::println);

        System.out.println("\n\n------------MAYORES DE 40--------------------\n\n");

        personas.stream().filter(p-> p.getEdad()>=40).forEach(System.out::println);

        System.out.println("\n\n------------SUMA DE LAS EDADES--------------------\n\n");

        System.out.println(personas.stream().mapToInt(Persona::getEdad).sum());

        System.out.println("\n\n------------SUMA DE LAS EDADES NOMBRES EMPIEZAN POR G--------------------\n\n");

        System.out.println(personas.stream().filter(p -> p.getNombre().startsWith("G")).mapToInt(Persona::getEdad).sum());

        System.out.println("\n\n-----SUMA DE LAS EDADES DE PERSONAS QUE SU NOMBRE Y APELLIDO EMPIEZAN POR LA MISMA LETRA------------\n\n");

        System.out.println(personas.stream().filter(p -> p.getNombre().charAt(0) == p.getApellidos().charAt(0)).mapToInt(Persona::getEdad).sum());

        System.out.println("\n\n------------JOIN DE LOS NOMBRES--------------------\n\n");

        System.out.println(personas.stream().map(Persona::getNombre).collect(Collectors.joining(", ", "Nombre: ",".")));

    }

    private static void procesarPersona(String linea){
        String[] v = linea.split(",");
        personas.add(new Persona(v[0], v[1], Integer.parseInt(v[2]), v[3], v[4], Double.parseDouble(v[5])));
    }
}
