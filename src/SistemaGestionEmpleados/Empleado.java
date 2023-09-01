package SistemaGestionEmpleados;

public abstract class Empleado{
    //Atributos
    protected String nombre;
    protected int id;
    protected double sueldoBase;
//Constructor de Empleado
    public Empleado(double sueldoBase, String nombre) {
        this.sueldoBase=sueldoBase;
        this.nombre=nombre;
        this.id+=1;
    }

    public abstract double calcularSueldo();

    public int getId() {//Método que define la ID de cada empleado.
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

}
