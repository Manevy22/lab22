package SistemaGestionEmpleados;

public class EmpleadoPorHoras extends Empleado implements Impuesto{
    protected int horasTrabajadas;//Atributo de la subclase EmpleadoPorHora
    public EmpleadoPorHoras(String nombre,int horasTrabajadas,double sueldoBase){
        super(sueldoBase,nombre);
        this.horasTrabajadas=horasTrabajadas;
    }
//En este caso el parámetro de sueldoBase me devuelve las ganancias del empleado por hora. 
    @Override
    public double calcularSueldo() {
        return horasTrabajadas*sueldoBase;
    }
    //Los impuestos a pagar de cada Empleado es un 35% de su suelo. 
    @Override
    public double calcularImpuesto() {
        return this.calcularSueldo()*0.35;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
//Se muestra la información del empleado. 
    @Override
    public String toString() {
        return "Nombre: "+nombre+",sueldo: "+calcularSueldo()+",impuestos:"+calcularImpuesto();
    }
}
