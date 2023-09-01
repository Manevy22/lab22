package SistemaGestionEmpleados;

public class EmpleadoPorHoras extends Empleado implements Impuesto{
    protected int horasTrabajadas;
    public EmpleadoPorHoras(String nombre,int horasTrabajadas,double sueldoBase){
        super(sueldoBase,nombre);
        this.horasTrabajadas=horasTrabajadas;
    }

    @Override
    public double calcularSueldo() {
        return horasTrabajadas*sueldoBase;
    }

    @Override
    public double calcularImpuesto() {
        return this.calcularSueldo()*0.35;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+",sueldo: "+calcularSueldo()+",impuestos:"+calcularImpuesto();
    }
}
