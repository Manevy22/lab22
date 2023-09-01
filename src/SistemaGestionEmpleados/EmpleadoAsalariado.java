package SistemaGestionEmpleados;

public class EmpleadoAsalariado extends Empleado implements Impuesto {
    public EmpleadoAsalariado(double sueldoBase, String nombre) {
        super(sueldoBase, nombre);
    }

    @Override
    public double calcularSueldo() {
        return sueldoBase;
    }
    public double calcularImpuesto() {
        return this.calcularSueldo()*0.35;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+",sueldo: "+calcularSueldo()+",impuestos:"+calcularImpuesto();
    }
}
