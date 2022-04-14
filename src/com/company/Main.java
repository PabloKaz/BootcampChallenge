package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            Funciones funciones = new Funciones();
            Password password;
            Scanner scan = new Scanner(System.in);
            mostrarMenu();


        switch (scan.nextInt()){

                case 1:
                    seraPrimo(funciones);
                    break;
                case 2:
                    funciones.comprobarContraseña();
                    break;
                case 3:
                    funciones.importe();
                    break;
                case 4:
                    funciones.adivinarNumero();
                    break;
                case 5:
                    funciones.listaNum();
                    break;
                case 6:
                    crearPassword();
                    break;
            }


    }


    public static void seraPrimo(Funciones funcion){ //Funcion auxiliar para saber si un numro es primo
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el numero para saber si es primo");
        funcion.esPrimo(scan.nextInt());
    }

    public static void crearPassword(){
        Scanner scan = new Scanner(System.in); int length;
        System.out.println("Ingrese la longitud que quiere que tenga su contraseña ALEATORIA");
        length = scan.nextInt();
        Password contra = new Password(length);
        System.out.println("Su contraseña es: "+ contra.getContraseña());

        if (contra.esFuerte()){
            System.out.println("Su contraseña es fuerte!");
        } else {
            System.out.println("Su contraseña es debil!");
        }
    }

    public static void mostrarMenu(){
        System.out.println("Presione 1 para acceder al punto numero 1 (N Primo)");
        System.out.println("Presione 2 para acceder al punto numero 2 (Contraseña)");
        System.out.println("Presione 3 para acceder al punto numero 3 (Empleado/Importe)");
        System.out.println("Presione 4 para acceder al punto numero 4 (Juego Advinanza)");
        System.out.println("Presione 5 para acceder al punto numero 5 (Lista Numeros )");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Presione 6 para acceder al SEGUNDO MODULO e Ingresar una longitud para obtener su contraseña random");
    }

}
