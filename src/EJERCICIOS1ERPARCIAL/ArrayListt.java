package EJERCICIOS1ERPARCIAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayListt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> miLista = new ArrayList<>(Arrays.asList(13, 41, 25, 76, 4));
        try {
            System.out.println("Ingrese un valor para agregarlo a la lista");
            miLista.add(scanner.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Sólo se admiten números enteros");
        }
        try {
            try {
                System.out.println("Ingrese una posicion para buscar al elemento correspondiente");
                int posicion = scanner.nextInt();
                System.out.println(miLista.get(posicion));
            } catch (InputMismatchException a) {
                System.out.println("Sólo se permiten números enteros");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No se encuentra disponible esa posición en el array");
        }
        try {
            try {
                System.out.println("Ingrese una posicion para eliminar al elemento correspondiente");
                int indice = scanner.nextInt();
                miLista.remove(indice);
            } catch (InputMismatchException a) {
                System.out.println("Sólo se permiten números enteros");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No se encuentra disponible esa posición en el array");
        }

        for (Integer integer : miLista) {
            System.out.println(integer);
        }
    }
}
