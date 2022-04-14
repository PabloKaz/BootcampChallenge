package com.company;
import java.util.ArrayList;
import java.util.Scanner;


public class Funciones {

    static final int NUMERO_MAX_INTENTOS = 7; ///! Punto 2
    static final int CANT_MIN_AÑOS = 11;///Punto 3
    static final int CANT_POR_AÑOS = 30;///Punto 3

    // TODO: PRIMER MODULO (ALGORITMOS)

    // ! Primer Punto

    //Revisa si un numero entero es primo o no.
    private boolean decidirPrimo(int n) {
        //revisa si n es multiplo de 2
        if (n%2==0 && n!=2) return false; //si es par, por ende sera divisible por 2 y por si mismo. La unica excepcion es el 2 mismo.
        //si no, solo revisa los impares
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)  ///evalua por cada numero impar antes de llegar al numero en cuestion, si existe una coincidencia donde el resto sea igual a 0, automaticamente lo vuelve no primo
                return false;
        }
        return true;
    }

    void esPrimo (int n){
        boolean prueba = decidirPrimo(n); ///llama a la funcion y devuelve por sout si es primo o no
        if (prueba){
            System.out.println("Es primo");
        } else {
            System.out.println("NO es primo");
        }
    }

    // ! Segundo Punto

    private boolean complementoPunto2(String contraseñaOriginal, String contraseñaPrueba){ /// para evitar scans en la funcion
                                                                                    /// esta funcion solo evalua si son iguales
        boolean esContraseña = false;

        if (contraseñaOriginal.equals(contraseñaPrueba)){
            esContraseña = true;
        }

        return esContraseña;
    }

     public void comprobarContraseña(){
        ///Creamos las variables necesarias
        int i = 0; boolean flag = false;
        Scanner scan = new Scanner(System.in);
        String contraseña; String comprobación;

        ///Hacemos que el user introduzca su contraseña
        System.out.println("Ingrese su contraseña");
        contraseña = scan.nextLine();

        ///Hacemos que la introduzca hasta que le atine o se acaben sus intentos
        while(!flag && i<=NUMERO_MAX_INTENTOS){
            System.out.println("Ahora ingrese nuevamente su contraseña, tiene "+(NUMERO_MAX_INTENTOS-i)+" intentos restantes");
            comprobación = scan.nextLine();
            flag = complementoPunto2(contraseña,comprobación); /// Llamamos a la funcion complementaria que evalua y devuelve el boolean
            i++;                                               /// Si son iguales la flag se volverá true
        }


        if (i==3) ///Sería lo mismo poner como condición flag == false, cualquiera de los dos es valido.
        {
            System.out.println("No recordaste tu contraseña");
        }else {
            System.out.println("Felicidades, recordaste tu contraseña!");
        }
    }

    // ! Tercer Punto


    public void importe(){
        ///Declaramos las variables necesarias
        Scanner scan = new Scanner(System.in); double valorxHora; String nombre; int antiguedadAños; int cantHoras; double importe;
        ///Obtenemos los datos necesarios para resolver
        System.out.println("Ingrese el nombre del empleado ");
        nombre = scan.nextLine();
        System.out.println("Ingrese cuanto es el valor x Hora del empleado ");
        valorxHora = scan.nextDouble();
        System.out.println("Ingrese la antiguedad del empleado expresada en años ");
        antiguedadAños = scan.nextInt();
        System.out.println("Ingrese la cantidad de horas trabajadas en el mes ");
        cantHoras = scan.nextInt();

        ///Llamamos a la funcion que calcula el importe
        importe = importeACobrar(valorxHora,cantHoras,antiguedadAños);
        ///Llamamos a la funcion que muestra por pantalla dicho importe
        mostrarImporte(importe,nombre);

    }

    private double importeACobrar (double vxH, int cantHoras, int antiguedad){
        double imp;

        imp = (double) vxH * cantHoras;

        if (antiguedad >= CANT_MIN_AÑOS){
            imp = imp + (antiguedad * CANT_POR_AÑOS);
        }

        return imp;
    }

    private void mostrarImporte (double importeACobrar, String nombre){
        System.out.println("El importe que el empleado "+ nombre +" cobrará es de "+ importeACobrar);
    }

    /// ! Cuarto Punto

    public void adivinarNumero(){
        ///declaramos las variables
        Scanner scan = new Scanner(System.in);
        int numeroGanador = (int) (Math.random()*1001);
        int nUser = -1; ///lo inicializamos en -1 de esta manera evitaremos que por coincidencia se adivine el numero sin haber empezado

        //Encerramos en un bucle al usuario hasta que adivine o cierre el programa.
        while (nUser != numeroGanador){
            System.out.println("Ingrese el numero");
            nUser = scan.nextInt();

            if(nUser > numeroGanador){
                System.out.println("El numero ingresado es MAYOR que el numero ganador");
            } else if (nUser < numeroGanador){ /// Si es el numero ganador no entrará en ningun if y saldrá directamente para decirle que gano.
                System.out.println("El numero ingresado es MENOR que el numero ganador");
            }
        }

        System.out.println("FELICIDADES, GANASTE!");
    }

    /// ! Quinto Punto

    public void listaNum (){
        int num;Scanner scan = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();
        int mayor; int menor; int sumaTodo; int sumaPar;
        do{
            System.out.println("Ingrese el numero a añadir");
            num = scan.nextInt();
            numeros.add(num);
        }while (num != -1);

        mayor = buscarMayor(numeros);
        menor = buscarMenor(numeros);
        sumaTodo = sumarTodo(numeros);
        sumaPar = sumarPares(numeros);

        System.out.println("El numero mayor es: "+mayor);
        System.out.println("El numero menor es: "+menor);
        System.out.println("La suma de todos los numeros es: "+ sumaTodo);
        System.out.println("La suma de los numeros pares es: "+ sumaPar);
    }

    private int buscarMayor (ArrayList<Integer> numeros){ ///Toda esta funcion se podría reducir simplemente con la libreria Collections
        int mayor = numeros.get(0);
        for (int i = 1; i<numeros.size();i++){
            if (mayor< numeros.get(i)){
                mayor = numeros.get(i);
            }
        }
        return mayor;
    }

    private int buscarMenor(ArrayList<Integer> numeros){ ///Podria simplificar este codigo con la libreria Collections
        int menor = numeros.get(0);

        for (int i = 1; i<numeros.size();i++){
            if (menor > numeros.get(i)){
                menor = numeros.get(i);
            }
        }

        return menor;
    }

    private int sumarTodo (ArrayList<Integer> numeros){
        int total = 0;

        for (Integer numero : numeros) {
            total += numero;
        }

        return total;
    }

    private int sumarPares (ArrayList<Integer> numeros){
        int total = 0;

        for (Integer numero : numeros) {
            if (numero % 2 == 0) {
                total += numero;
            }
        }

        return total;
    }
}
