package SistemaGestionEmpleados;

public abstract class Empleado{
    protected String nombre;
    protected int id;
    protected double sueldoBase;

    public Empleado(double sueldoBase, String nombre) {
        this.sueldoBase=sueldoBase;
        this.nombre=nombre;
        this.id+=1;
    }

    public abstract double calcularSueldo();

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

}
