package Recursion;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese un valor para calcular su factorial");
        int fac= scanner.nextInt();
        long fac1=fac;
        if(fac<0)System.out.println("No se puede calcular el factorial de valores menores a 0");
        else {
            int res = factorial(fac);
            long res1 = factorial(fac1);
            System.out.println("Factorial de: " + fac + ", con recursión=" + res + " y con iteración es=" + res1);
        }
    }
    public static int factorial(int val){
        if(val==1 || val==0)return 1;
       return val*factorial(val-1);
    }
    public static int factorial(long val){
        if(val==0)return 1;
        else{
        int cont=1,result=1;
        while(cont<=val){
            result*=cont;
            cont++;
        }
        return result;}
    }

}
