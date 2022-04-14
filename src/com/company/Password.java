package com.company;
import java.util.Random;

public class Password {
    private int longitud;
    private String contraseña;

    public Password(String contraseña){
        this.longitud = contraseña.length();
        this.contraseña = contraseña;
    }

    public Password(int longitud) {
        this.longitud = longitud;
        contraseña = generarPassword(longitud);
    }

    private String generarPassword(int longitud){
        int random; int ayuda = 0;
        String password = new String();
        Random aleatorio = new Random();


        for (int i = 0; i < longitud; i++){
            random = (int) (Math.random()*3+1); ///Los valorese estaran entre 3 y 1
                                                ///De esta manera la contraseña será random pero no asegura que será siempre SEGURA
                                                ///Si quisiera hacer que siempre sea segura haría que hasta cierta longitud la contraseña respete un orden
                                                ///Ese orden sería: 2 mayus, 1 minus, 3 numeros.
            if(random == 1){
                password += (aleatorio.nextInt(10)); ///Los valores estaran entre 0 y 9
            } else if (random == 2){
                ayuda = (int) Math.floor(Math.random()*(90-65+1)+65); ///Los valores estaran entre 90 y 65
                password += (char) ayuda ;                            ///Que en ascii representan A-Z
            } else {
                ayuda = (int) Math.floor(Math.random()*(122-97+1)+97); ///Los valores estaran entre 122 y 97
                password += (char) ayuda;                              ///Que en ascii representan a-z
            }
        }

        return password;
    }


    /* Codigo para que siempre sea segura la contraseña:

        private String generarPassword(int longitud){
        int random; int ayuda = 0;
        String password = new String();
        Random aleatorio = new Random();


        for (int i = 0; i < longitud; i++){
            if(i >6){ ///Esto hará que hasta que no se cumpla hasta que se de el orden requerido para ser "fuerte".
                      ///Una vez se alcanza este valor la contraseña ya será fuerte, pero si la longitud es mayor
                      ///Entonces realizará un intercalado de los valores (ya sean mayus, minus o numeros) posterior a la posicion de STRING [5].
            random = (int) (Math.random()*3+1); ///Los valorese estaran entre 3 y 1
            }

            if(i<3 || random == 1){
                password += (aleatorio.nextInt(10)); ///Los valores estaran entre 0 y 9
            } else if ( i<4 || random == 2){
                ayuda = (int) Math.floor(Math.random()*(90-65+1)+65); ///Los valores estaran entre 90 y 65
                password += (char) ayuda ;                            ///Que en ascii representan A-Z
            } else if (i<6 || random == 3) {
                ayuda = (int) Math.floor(Math.random()*(122-97+1)+97); ///Los valores estaran entre 122 y 97
                password += (char) ayuda;                              ///Que en ascii representan a-z
            }
        }

        return password;
    }

     */



    protected boolean esFuerte(){
        int mayus = 0; int minus = 0; int num = 0;

        for (int i = 0; i < this.contraseña.length(); i++){
            if (Character.isUpperCase(this.contraseña.charAt(i))) mayus++; ///Cuenta las mayusculas
            else if (Character.isLowerCase(this.contraseña.charAt(i))) minus++; /// Cuenta las minusculas
            else if (Character.isDigit(this.contraseña.charAt(i))) num++; ///Cuenta los numeros
        }

        if (mayus >= 2 && minus >=1 && num >=3){ ///Si cumple con los requisitos entonces es fuerte
            return true;
        }else{ ///Sino, no
            return false;
        }
    }

    public int getLongitud() {
        return longitud;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Password{" +
                "contraseña='" + contraseña + '\'' +
                '}';
    }

}
