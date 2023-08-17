package Recursion;

import java.util.Scanner;

public class divisionConResta {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        int dividendo,divisor;
        boolean r=false;
        do {
            System.out.println("Ingrese dos valores para dividirlos");
            System.out.println("Ingrese dividendo:");
            dividendo = scanner.nextInt();
            System.out.println("Ingrese divisor");
            divisor = scanner.nextInt();
            if (divisor == 0 || divisor > dividendo) {
                System.out.println("Divisor ingresado inválido");
            }else r=true;
        }while (!r);
        int res1=division(dividendo,divisor);
        System.out.println("El resultado de la división con iteración es: "+res1);
        long dividendo1=dividendo;
        long divisor1=divisor;
        int res2=division(dividendo1,divisor1);
        System.out.println("El resultado de la división con recursión es: "+res2);

    }
    public static int division(int dividendo, int divisor){//Con iteraciones.
        int resultado=0;
            while(dividendo>=divisor){
                dividendo-=divisor;
                resultado++;
            }
        return resultado;
    }
    public static int division(long  dividendon, long divisorn){
            if(dividendon<divisorn)return 0;
            else {
                return 1+division((dividendon-divisorn),divisorn);
            }
        }
    }


