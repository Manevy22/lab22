package SistemaGestionEmpleados;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GestorEmpleados {
    ArrayList <Empleado> empleados;
    public GestorEmpleados(){
        empleados=new ArrayList<Empleado>();
    }
    public void agregarEmpleado(Empleado empleado){
    empleados.add(empleado);
    }
    public void eliminarEmpleado(int id){
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getId()==id) {
                empleados.remove(i);
                break;
            }
        }
    }
    public void editarEmpleado(int Id, String nuevoNombre, double newsueldoBase) {
        for (Empleado empleados : empleados) {
            if (empleados.getId()==Id) {
                empleados.setNombre(nuevoNombre);
                empleados.setSueldoBase(newsueldoBase);
            }
        }
    }

}
