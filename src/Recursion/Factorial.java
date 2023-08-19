package Recursion;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args){//Clase principal
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese un valor para calcular su factorial");
        int fac= scanner.nextInt();
        long fac1=fac;//Para poder diferenciar a ambos métodos se crean dos variables, del mismo valor pero de distinto tipo de dato.
        if(fac<0)System.out.println("No se puede calcular el factorial de valores menores a 0");
        else {
            int res = factorial(fac);//Se llama al primer método que aplica recursión.
            long res1 = factorial(fac1);//Se llama al segundo método que aplica una estructura de iteración.
            System.out.println("Factorial de: " + fac + ", con recursión=" + res + " y con iteración es=" + res1);
        }
    }
    public static int factorial(int val){//Metodo que aplica recursión.
        if(val==1 || val==0)return 1;//Condición de salida.
       return val*factorial(val-1);//Si el valor es mayor a 1, se llama nuevamnente a la función.
    }
    public static int factorial(long val){//Método que aplica una estructura de iteración.
        if(val==0)return 1;
        else{
        int cont=1,result=1;
        while(cont<=val){
            result*=cont;
            cont++;
        }//Si el valor es mayor a 0 ingresa en un bucle while.
        return result;}
    }
    //En ambos casos métodos se aplica la fórmula n ( n − 1 ) !; siendo n>1.

}
