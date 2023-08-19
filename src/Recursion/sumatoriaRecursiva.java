package Recursion;



import java.util.Scanner;

public class sumatoriaRecursiva {
    public static void main(String[] args){//Clase principal.
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese un valor para calcular su sumatoria");//Se pide al usuario que ingrese un valor.
        int val=scanner.nextInt();
        System.out.println("La sumatoria del valor ingresado es: "+sumatoria(val));//Se llama al método que aplica recursión y se muestra el resultado por pantalla.
    }
    public static int sumatoria(int val){
        if(val==1)return 1;//Condición de salida.
        return val+sumatoria(val-1);//Se llama a la función nuevamente.
        //Se suma el valor actual con su antecesor, y así sucesivamente, hasta llegar a 1.
    }
}
