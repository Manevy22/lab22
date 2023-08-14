import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        int[] vec = new int[3];
        int aux;
        System.out.println("Ingrese el primer número: ");
        vec[0] = scanner.nextInt();
        System.out.println("Ingrese el segundo número: ");
        vec[1] = scanner.nextInt();
        System.out.println("Ingrese el tercer número: ");
        vec[2] = scanner.nextInt();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (vec[i] > vec[j]) {
                    aux = vec[i];
                    vec[i] = vec[j];
                    vec[j] = aux;
                }
            }
        }
        System.out.println("Los valores ingresados ordenados son: ");
        for(int k=0;k<3;k++){
            System.out.println(vec[k]+"-");
        }
    }
    }
