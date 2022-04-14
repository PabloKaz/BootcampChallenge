package com.company;

public class EmpleadoMuni {
    ///TODO: Realmente no manejo nada de SQL todavía, es la tecnología que estoy por cursar en el ultimo cuatrimestre en la UTN
    ///TODO: Pero realmente me encantaría y quiero aprender, busqué tutoríales pero no encontre la información (Por lo menos no de manera gratuita).
    ///TODO: En su defecto, tengo conocimientos para guardar datos de manera LOCAL con JSON.

    static final int CANT_MIN_SALARIO = 70000;

        private String nombre;
        private String apellido;
        private String telefono;
        private String email;
        private int Antiguedad;
        private int Salario;
        private String puesto;
        private String muniPerteneciente;

    public EmpleadoMuni(String nombre, String apellido, String telefono, String email, int antiguedad, int salario, String puesto, String muniPerteneciente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        Antiguedad = antiguedad;
        Salario = salario;
        this.puesto = puesto;
        this.muniPerteneciente = muniPerteneciente;
    }

    public EmpleadoMuni(){

    }

    ///TODO Getters

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public int getAntiguedad() {
        return Antiguedad;
    }

    public int getSalario() {
        return Salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public String getMuniPerteneciente() {
        return muniPerteneciente;
    }

    /// TODO Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAntiguedad(int antiguedad) {
        Antiguedad = antiguedad;
    }

    public void setSalario(int salario) {
        Salario = salario;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setMuniPerteneciente(String muniPerteneciente) {
        this.muniPerteneciente = muniPerteneciente;
    }

    private boolean empleadoIdeal(){
        boolean flag= false;

        if (this.Salario > CANT_MIN_SALARIO && this.Antiguedad<=15 && this.Antiguedad>=10){
            flag = true;
        }

        return flag;
    }

}
