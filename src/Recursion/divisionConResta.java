package Recursion;

import java.util.Scanner;

public class divisionConResta {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        int dividendo,divisor;
        boolean r=false;
        do {//Inicialmente el programa ingresa en un ciclo do-while que se corta cuando el usuario ingresa valores válidos para realizar una división.
            System.out.println("Ingrese dos valores para dividirlos");
            System.out.println("Ingrese dividendo:");
            dividendo = scanner.nextInt();
            System.out.println("Ingrese divisor");
            divisor = scanner.nextInt();
            if (divisor == 0 || divisor > dividendo) {
                System.out.println("Divisor ingresado inválido");
            }else r=true;
        }while (!r);
        int res1=division(dividendo,divisor);//Se llama al método que aplica iteración con un tipo de dato int.
        System.out.println("El resultado de la división con iteración es: "+res1);
        long dividendo1=dividendo;
        long divisor1=divisor;
        int res2=division(dividendo1,divisor1);//Se llama al método que aplica rescursión con un tipo de dato long.
        System.out.println("El resultado de la división con recursión es: "+res2);

    }
    public static int division(int dividendo, int divisor){//Método que aplica iteración.
        int resultado=0;
            while(dividendo>=divisor){
                dividendo-=divisor;
                resultado++;
            }
        return resultado;
    }
    public static int division(long  dividendon, long divisorn){//Se aplica iteración.
            if(dividendon<divisorn)return 0;//Condición de salida.
            else {
                return 1+division((dividendon-divisorn),divisorn);//Se llama nuevamente a la función.
            }//Por cada vez que se llama a la recursión se suma 1 al resultado final, siendo el número de veces el que divisor puede restar al dividendo.
        }
    }


