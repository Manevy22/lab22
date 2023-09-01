package SistemaGestionEmpleados;

public class EmpleadoAsalariado extends Empleado implements Impuesto {
    //Constructor de la sub-clase.
    public EmpleadoAsalariado(double sueldoBase, String nombre) {
        super(sueldoBase, nombre);
    }
    //Sobreescritura del método abstracto calcularSueldo.
    @Override
    public double calcularSueldo() {
        return sueldoBase;
    }
    //Los impuestos a pagar de cada Empleado es un 35% de su suelo. 
    public double calcularImpuesto() {
        return this.calcularSueldo()*0.35;
    }
//El método toString me devuelve la información del empleado. 
    @Override
    public String toString() {
        return "Nombre: "+nombre+",sueldo: "+calcularSueldo()+",impuestos:"+calcularImpuesto();
    }
}
