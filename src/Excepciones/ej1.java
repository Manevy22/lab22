package Excepciones;

import java.util.Scanner;

public class ej1 {
    public static void main(String[] args){
        // TODO Auto-generated method stub

        System.out.println("introducir numero");

        Scanner leer = new Scanner(System.in);

        try {
            evaluarNumero(leer.nextInt());
            System.out.println("Número ingresado válido");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("El número ingresado no es válido");
            e.printStackTrace();
        }
    }
    static void evaluarNumero(int nroEvaluar) throws Exception {

        if (nroEvaluar < 1 || nroEvaluar > 100) {
            throw new Exception("numero muy chico");
        }
    }
}
