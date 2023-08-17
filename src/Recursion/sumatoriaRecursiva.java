package Recursion;



import java.util.Scanner;

public class sumatoriaRecursiva {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese un valor para calcular su sumatoria");
        int val=scanner.nextInt();
        System.out.println("La sumatoria del valor ingresado es: "+sumatoria(val));
    }
    public static int sumatoria(int val){
        if(val==1)return 1;
        return val+sumatoria(val-1);
    }
}
