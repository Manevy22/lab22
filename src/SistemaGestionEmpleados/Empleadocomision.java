package SistemaGestionEmpleados;

public class Empleadocomision extends Empleado implements Impuesto {
    protected double VentasRealizadas;//Atributo especial del EmpleadoComision.
    public Empleadocomision(double sueldoBase, String nombre, double VentasRealizadas, double Comision){
        super(sueldoBase,nombre);
       this.VentasRealizadas=VentasRealizadas*Comision;
    }

    @Override
    public double calcularSueldo() {
        return sueldoBase+VentasRealizadas;
        //Para calcular su sueldo se le suma al sueldo base la comision por venta. 
    }
    public double calcularImpuesto() {    //Los impuestos a pagar de cada Empleado es un 35% de su suelo. 
        return this.calcularSueldo()*0.35;
    }

    @Override
    public String toString() {//Devuelve la información del empleado. 
        return "Nombre: "+nombre+",sueldo: "+calcularSueldo()+",impuestos:"+calcularImpuesto();
    }
}
