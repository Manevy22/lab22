package SistemaGestionEmpleados;

public class Empleadocomision extends Empleado implements Impuesto {
    protected double VentasRealizadas;
    public Empleadocomision(double sueldoBase, String nombre, double VentasRealizadas, double Comision){
        super(sueldoBase,nombre);
       this.VentasRealizadas=VentasRealizadas*Comision;
    }

    @Override
    public double calcularSueldo() {
        return sueldoBase+VentasRealizadas;
    }
    public double calcularImpuesto() {
        return this.calcularSueldo()*0.35;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+",sueldo: "+calcularSueldo()+",impuestos:"+calcularImpuesto();
    }
}
