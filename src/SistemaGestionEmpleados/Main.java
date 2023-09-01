package SistemaGestionEmpleados;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        GestorEmpleados grupoEmpleados= new GestorEmpleados();//Se declara un ArrayList de empleados. 
        while (true) {//Una estructura iterativa para que el usuario haga las operaciones que desee. 
            System.out.println("1. Asignar Empleado\n2. Editar Empleado\n3. Eliminar empleado\n4.Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del Empleado: ");
                    String nombreEmpleado = scanner.next();
                    System.out.println("1.Empleado por hora 2.Empleado asalariado 3.Empleado por comisión");
                //Se indica que tipo de empleado se desea añadir. 
                    int option2= scanner.nextInt();
                    switch (option2){
                        case 1:
                            System.out.println("Ingrese las horas trabajadas");
                            int horas= scanner.nextInt();
                            System.out.println("Ingrese la ganancia por hora");
                            double gan= scanner.nextDouble();
                            try {//Se evalúa si los datos ingresados son válidos.
                                evaluarEmpleadoxhora(horas,gan);
                                EmpleadoPorHoras em1=new EmpleadoPorHoras(nombreEmpleado,horas,gan);
                                System.out.println(em1.toString());
                                grupoEmpleados.agregarEmpleado(em1);
                            }catch (Exception e){//En caso de no ser válidos, el programa no los guarda y se prosigue con la sig. iteración. 
                                System.out.println("El número ingresado no es válido");
                            }
                            break;
                        case 2:
                            System.out.println("Ingrese el sueldo base");
                            double gan2= scanner.nextDouble();
                            try{
                                evaluarEmpleadoAs(gan2);
                                EmpleadoAsalariado em2=new EmpleadoAsalariado(gan2,nombreEmpleado);
                                System.out.println(em2.toString());
                                grupoEmpleados.agregarEmpleado(em2);
                            }catch (Exception e){
                                System.out.println("El número ingresado no es válido");

                            }
                            break;
                        case 3:
                            System.out.println("Ingrese el sueldo base");
                            double gan3= scanner.nextDouble();
                            System.out.println("Ingrese la comisión por venta");
                            double com= scanner.nextDouble();
                            System.out.println("Ingrese la cantidad de ventas");
                            double vent= scanner.nextDouble();
                            try{
                                evaluarEmpleadoxcomision(gan3,com,vent);
                                Empleadocomision em3=new Empleadocomision(gan3,nombreEmpleado,vent,com);
                                System.out.println(em3.toString());
                                grupoEmpleados.agregarEmpleado(em3);
                            }catch (Exception e){
                                System.out.println("El número ingresado no es válido");
                            }
                            break;
                        default:System.out.println("Error");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese la ID del empleado a editar: ");
                    int IDeditar= scanner.nextInt();
                    System.out.print("Ingrese nuevo nombre del empleado: ");
                    String nuevoNombre = scanner.next();
                    System.out.print("Ingrese nuevo sueldo del empleado: ");
                    double newsueldo= scanner.nextDouble();
                    grupoEmpleados.editarEmpleado(IDeditar,nuevoNombre,newsueldo);
                    //Se llama al método que modifica los datos del empleado. 
                    break;
                case 3:
                    System.out.print("Ingrese la ID del empleado a eliminar: ");
                    //Se llama al método que elimina los datos de un empleado a través de su ID. 
                    int IDEliminar= scanner.nextInt();
                    grupoEmpleados.eliminarEmpleado(IDEliminar);
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }
    }
    static void evaluarEmpleadoxhora(int horaEvaluar, double ganaciaxhora) throws Exception {
//Se evalúa que se ingresen datos coherentes de horas trabajadas y de ganancia por hora. 
        if (horaEvaluar<3 || ganaciaxhora<200) {
            throw new Exception("VALORES INGRESADOS NO VÁLIDOS");
        }
    }
    static void evaluarEmpleadoAs(double sueldoBase) throws Exception {
//Método que evalúa que el sueldo de los empleados asalariados sea de un monton considerable. 
        if (sueldoBase<90000) {
            throw new Exception("Sueldo ingresado inválido");
        }
    }
    static void evaluarEmpleadoxcomision(double sueldo, double comisionxventa, double nroventas) throws Exception {
//Este método controla el sueldo base, junto con la comisión por venta y el nro de ventas. 
        if (sueldo<40000 || comisionxventa<=0 || nroventas<=0 ) {
            throw new Exception("VALORES INGRESADOS NO VÁLIDOS");
        }
    }

}
