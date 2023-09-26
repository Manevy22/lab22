package EJERCICIOS1ERPARCIAL;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

abstract class Vehiculo implements Serializable {
    protected String marca;
    protected String modelo;
    protected double precio;

    public abstract double calcularImpuesto();
    public abstract String mostrarInformacion();

    public String getMarca() {
        return marca;
    }


    public String getModelo() {
        return modelo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
class Coche extends Vehiculo implements java.io.Serializable {
    public Coche(String marca, String modelo,double precio){
        super.marca=marca;
        super.modelo=modelo;
        super.precio=precio;
    }

    @Override
    public double calcularImpuesto() {
        return super.precio*0.5;
    }

    @Override
    public String mostrarInformacion() {
        return "[marca: "+super.marca+", modelo: "+super.modelo+",precio: "+super.precio+", impuesto: "+calcularImpuesto()+"]";
    }
}
class Moto extends Vehiculo implements java.io.Serializable {
    public Moto(String marca, String modelo,double precio){
        super.marca=marca;
        super.modelo=modelo;
        super.precio=precio;
    }

    @Override
    public double calcularImpuesto() {
        return super.precio*0.2;
    }

    @Override
    public String mostrarInformacion() {
        return "[marca: "+super.marca+", modelo: "+super.modelo+",precio: "+super.precio+", impuesto: "+calcularImpuesto()+"]";
    }

}
class Concesionaria implements Serializable{
    ArrayList<Vehiculo> Vehiculo1;
    public Concesionaria(){
        Vehiculo1=new ArrayList<>();
    }
    public void agregarVehiculo(Vehiculo vehiculo){
        Vehiculo1.add(vehiculo);
    }
    public void eliminarVehiculo(String marca, String modelo){
        for (int i = 0; i < Vehiculo1.size(); i++) {
            if ((Objects.equals(Vehiculo1.get(i).getMarca(), marca)) && (Objects.equals(Vehiculo1.get(i).getModelo(), modelo))) {
                Vehiculo1.remove(i);
                break;
            }
        }
    }
    public void editarPrecio(String marca, String modelo, double nuevoPrecio) {
        for (Vehiculo vehiculo : Vehiculo1) {
            if (Objects.equals(vehiculo.getMarca(), marca) && Objects.equals(vehiculo.getModelo(), modelo)) {
                    vehiculo.setPrecio(nuevoPrecio);
                    break;
                }
            }
        }

    public void mostrarInventario(){
        for (Vehiculo vehiculo : Vehiculo1) {
            System.out.println(vehiculo.mostrarInformacion());
        }
    }

    public void guardar(Concesionaria concesionaria) {//serializar
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("C:"+File.separator+"Users"+File.separator+"Usuario"+File.separator+"vehiculos.txt");
            //Primero se define el archivo en el cual vamos a escribir.
            ObjectOutputStream flujosalida= new ObjectOutputStream(fileOutputStream);
            //Segundo se abre un fujo por el cual vamos a pasar el objeto a escibir.
            flujosalida.writeObject(concesionaria);//Escribimos el objeto.
            flujosalida.close();//Cerramos el flujo de salida.
        }catch (IOException e){
            System.out.println("Error en realizar la acción");
            e.printStackTrace();
        }
    }
    public void cargar() {
        try{
            FileInputStream fileInputStream=new FileInputStream("C:"+File.separator+"Users"+File.separator+"Usuario"+File.separator+"vehiculos.txt");
            //Primero se define el archivo que vamos a leer.
            ObjectInputStream flujodeentrada=new ObjectInputStream(fileInputStream);
            //Segundo se abre un fujo por el cual vamos a pasar el objeto a leer.
            Concesionaria concesionaria1 = (Concesionaria) flujodeentrada.readObject();//Se lee el contenido del objeto.
            System.out.println("Contenido del archivo: "+concesionaria1);
            concesionaria1.mostrarInventario();
            flujodeentrada.close();
        }catch (IOException e){
            System.out.println("Error en realizar la acción");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Error en realizar la acción");
            throw new RuntimeException(e);
        }
    }
}
class mainConcesionaria {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Concesionaria concesionaria= new Concesionaria();
        while (true){
            System.out.println("1.Agregar Vehículo; 2.Eliminar Vehículo; 3.Editar Precio; 4.Mostrar Inventario; 5. Salir");
            int op=scanner.nextInt();
            switch (op){
                case 1:
                    System.out.println("1.Agregar Coche; 2.Agregar Moto");
                    int op2=scanner.nextInt();
                    if(op2==1){
                        System.out.println("Ingrese la marca:");
                        String marca=scanner.next();
                        System.out.println("Ingrese el modelo: ");
                        String modelo=scanner.next();
                        System.out.println("Ingrese el precio");
                        double precio=scanner.nextDouble();
                        Coche coche= new Coche(marca,modelo,precio);
                        concesionaria.agregarVehiculo(coche);
                    }
                    else{
                        System.out.println("Ingrese la marca:");
                        String marca1=scanner.next();
                        System.out.println("Ingrese el modelo: ");
                        String modelo1=scanner.next();
                        System.out.println("Ingrese el precio");
                        double precio1=scanner.nextDouble();
                        Moto moto= new Moto(marca1,modelo1,precio1);
                        concesionaria.agregarVehiculo(moto);
                    }
                    break;
                case 2:
                    System.out.println("Para eliminar el vehículo: ");
                    System.out.println("Ingrese la marca...");
                    String marca2=scanner.next();
                    System.out.println("Ingrese el modelo...");
                    String modelo2=scanner.next();
                    concesionaria.eliminarVehiculo(marca2,modelo2);
                    break;
                case 3:
                    System.out.println("Para editar el precio: ");
                    System.out.println("Ingrese la marca...");
                    String marca3=scanner.next();
                    System.out.println("Ingrese el modelo...");
                    String modelo3=scanner.next();
                    System.out.println("Ingrese el nuevo precio");
                    double nuevoprecio= scanner.nextDouble();
                    concesionaria.editarPrecio(marca3,modelo3,nuevoprecio);
                    break;
                case 4:
                    concesionaria.mostrarInventario();
                    break;
                case 5:
                    concesionaria.guardar(concesionaria);
                    concesionaria.cargar();
                    scanner.close();return;
                case 6: default: System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }
    }
}
//Todas las clases que van a estar involucadras deben implementar la interfaz Serializable.
