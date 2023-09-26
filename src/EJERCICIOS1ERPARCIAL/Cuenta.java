package EJERCICIOS1ERPARCIAL;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Cuenta{
    protected int nroCuenta;
    protected double Saldo;
    public abstract void depositar(double cantidad);
    public abstract void retirar(double cantidad);
    public abstract String mostrarInformacion();

    public int getNroCuenta() {
        return nroCuenta;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double saldo) {
        Saldo = saldo;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }
}
class cuentaPersona extends Cuenta{

    private String nombre;
    private String apellido;

    public cuentaPersona(String nombre, String apellido, int nroCuenta, double Saldo) {
        this.nombre=nombre;
        this.apellido=apellido;
        this.nroCuenta=nroCuenta;
        this.Saldo=Saldo;
    }
    @Override
    public void depositar(double cantidad) {
        super.Saldo+=cantidad;
    }

    @Override
    public void retirar(double cantidad) {
        if(super.Saldo>=cantidad)
            super.Saldo-=cantidad;
        else System.out.println("Saldo Insuficiente");
    }

    @Override
    public String mostrarInformacion() {
        return "[Cuenta: "+super.nroCuenta+"; Usuario: "+this.apellido+" "+this.nombre+"; Saldo: "+super.Saldo+"]";
    }

}
class cuentaSociedad extends Cuenta{
    private String nombreEmpresa;
    private String tipoEmpresa;

    public cuentaSociedad(String nombreEmpresa, String tipoEmpresa, int nroCuenta, double Saldo) {
        this.nombreEmpresa=nombreEmpresa;
        this.tipoEmpresa=tipoEmpresa;
        this.nroCuenta=nroCuenta;
        this.Saldo=Saldo;
    }
    @Override
    public void depositar(double cantidad) {
        super.Saldo+=cantidad;
    }

    @Override
    public void retirar(double cantidad) {
        if(super.Saldo>=cantidad) {
            super.Saldo-=cantidad;
        } else System.out.println("Saldo Insuficiente");
    }

    @Override
    public String mostrarInformacion() {
        return "[Cuenta: "+super.nroCuenta+";nombre de la Empresa: "+this.nombreEmpresa+";Tipo de Empresa: "+this.tipoEmpresa+";Saldo: "+super.Saldo+"]";
    }
}
 class GestorCuentas {
     ArrayList<cuentaPersona> cuentaIndv;
     ArrayList<cuentaSociedad> cuentaGrupal;

     GestorCuentas() {
         cuentaIndv = new ArrayList<cuentaPersona>();
         cuentaGrupal = new ArrayList<cuentaSociedad>();
     }

     public void agregarCuentaPersona(cuentaPersona p1) {
         cuentaIndv.add(p1);
     }
     public void agregarCuentaSociedad(cuentaSociedad p1){
         cuentaGrupal.add(p1);
     }
     public void EliminarCuentaPersona(int nroCuenta){
         for(int i=0;i<cuentaIndv.size();i++){
             if(cuentaIndv.get(i).getNroCuenta()==nroCuenta){
                 cuentaIndv.remove(i);
                 break;
             }
         }
     }
     public void EliminarCuentaSociedad(int nroCuenta){
         for(int i=0;i<cuentaGrupal.size();i++){
             if(cuentaGrupal.get(i).getNroCuenta()==nroCuenta){
                 cuentaGrupal.remove(i);
                 break;
             }
         }
     }
     public void editarCuentaPersona(int nroCuenta, double nuevoSaldo){
         for(int i=0;i<cuentaIndv.size();i++){
             if(cuentaIndv.get(i).getNroCuenta()==nroCuenta){
                 cuentaIndv.get(i).setSaldo(nuevoSaldo);
                 break;
             }
         }
     }
     public void editarCuentaSociedad(int nroCuenta, double nuevoSaldo){
         for(int i=0;i<cuentaGrupal.size();i++){
             if(cuentaGrupal.get(i).getNroCuenta()==nroCuenta){
                 cuentaGrupal.get(i).setSaldo(nuevoSaldo);
                 break;
             }
         }
     }
     public void mostrarTodasLasCuentas(){
         System.out.println("Cuentas Personales:");
         for(int i=0; i<cuentaIndv.size();i++){
             System.out.println(cuentaIndv.get(i).mostrarInformacion());
         }
         System.out.println("Cuentas Grupales: ");
         for(int i=0; i<cuentaGrupal.size();i++){
             System.out.println(cuentaGrupal.get(i).mostrarInformacion());
         }
     }
 }
 class CuentaMain{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        GestorCuentas Gestor=new GestorCuentas();
        while (true) {
            System.out.println("1. Crear Cuenta Personal\n2. Crear Cuenta en Sociedad\n3. Editar Saldo de cuenta Personas\n4. Editar Saldo de Cuenta en Sociedad\n5. Eliminar Cuenta Personal\n6. Eliminar Cuenta en Sociedad\n7. Mostrar Información\n8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del Usuario: ");
                    String nombrePersonal = scanner.next();
                    System.out.print("Ingrese apellido del Usuario: ");
                    String apellidoPersonal = scanner.next();
                    System.out.print("Ingrese el nro de Cuenta: ");
                    int nroCuenta = scanner.nextInt();
                    //TRYCATCH
                    System.out.print("Ingrese el saldo de la Cuenta: ");
                    double saldoCuenta = scanner.nextDouble();

                    cuentaPersona p1 =new cuentaPersona(nombrePersonal,apellidoPersonal,nroCuenta,saldoCuenta);
                    Gestor.agregarCuentaPersona(p1);
                    break;
                case 2:
                    System.out.print("Ingrese nombre de la Empresa: ");
                    String nombreEmpresa = scanner.next();
                    System.out.print("Ingrese el tipo de Empresa: ");
                    String tipoEmpresa = scanner.next();
                    System.out.print("Ingrese el nro de Cuenta: ");
                    int nroCuenta1 = scanner.nextInt();
                    //TRYCATCH
                    System.out.print("Ingrese el saldo de la Cuenta: ");
                    double saldoCuenta1 = scanner.nextDouble();

                    cuentaSociedad  p2 =new cuentaSociedad(nombreEmpresa,tipoEmpresa,nroCuenta1,saldoCuenta1);
                    Gestor.agregarCuentaSociedad(p2);
                    break;
                case 3:
                    System.out.print("Ingrese el nro de Cuenta del Usuario ");
                    int nroCuenta3 = scanner.nextInt();
                    System.out.print("Ingrese el nuevo Saldo del Usuario: ");
                    double saldo3= scanner.nextDouble();
                    Gestor.editarCuentaPersona(nroCuenta3,saldo3);
                break;
                case 4:
                    System.out.print("Ingrese el nro de Cuenta de la Sociedad ");
                    int nroCuenta4 = scanner.nextInt();
                    System.out.print("Ingrese el nuevo Saldo de la Sociedad: ");
                    double saldo4= scanner.nextDouble();
                    Gestor.editarCuentaSociedad(nroCuenta4,saldo4);
                    break;
                case 5:
                    System.out.println("Ingrese el número de cuenta del Usuario a eliminar");
                    int nroCuenta5= scanner.nextInt();
                    Gestor.EliminarCuentaPersona(nroCuenta5);
                    break;
                case 6:
                    System.out.println("Ingrese el número de cuenta de la Sociedad a eliminar");
                    int nroCuenta6= scanner.nextInt();
                    Gestor.EliminarCuentaSociedad(nroCuenta6);
                    break;
                case 7:
                    Gestor.mostrarTodasLasCuentas();
                    break;
                case 8:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }
    }
    }


