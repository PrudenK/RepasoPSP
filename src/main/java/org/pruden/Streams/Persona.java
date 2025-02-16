package org.pruden.Streams;

class Persona {
    private String nombre;
    private String apellidos;
    private int edad;
    private String telefono;
    private String email;
    private double dinero;

    public Persona(String nombre, String apellidos, int edad, String telefono, String email, double dinero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.dinero = dinero;
    }

    public String toCSV() {
        return String.format("%s,%s,%d,%s,%s,%.2f", nombre, apellidos, edad, telefono, email, dinero);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", dinero=" + dinero +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public double getDinero() {
        return dinero;
    }
}