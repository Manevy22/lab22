package EJERCICIOS1ERPARCIAL;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionHotel {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int op;
        Habitaciones h1= new Habitaciones(3,3);
        Habitaciones h2= new Habitaciones(1,2);
        Habitaciones h3= new Habitaciones(5,10);
        Habitaciones h4= new Habitaciones(3,6);
        Habitaciones h5= new Habitaciones(1,1);
        ArrayList<Habitaciones> habitaciones1=new ArrayList<>();
        habitaciones1.add(h1);
        habitaciones1.add(h2);
        habitaciones1.add(h3);
        habitaciones1.add(h4);
        habitaciones1.add(h5);
        GestionDelHotel hotel= new GestionDelHotel(habitaciones1);
        System.out.println("Ingrese el nombre del Hotel");
        String nombreHotel= scanner.nextLine();
        try {
            FileWriter newArchivo= new FileWriter("C:"+File.separator+"Users"+File.separator+"Usuario"+File.separator+"nombreHotel.txt",true);
            newArchivo.write(nombreHotel);//Se añade contenido al archivo.
            newArchivo.close();//Se cierra el archivo.
        } catch(IOException e) {
            e.printStackTrace();//Excepcion en el caso de no poder crearlo.
        }
        try (Scanner entrada = new Scanner(new File("C:"+File.separator+"Users"+File.separator+"Usuario"+File.separator+"nombreHotel.txt"))) {
            String nombreHotel1 = entrada.nextLine();
            System.out.println(nombreHotel1);
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer el nombre del hotel desde el archivo: " + e.getMessage());
        }

        while (true){
            System.out.println("Menu: \n"+"1. Ver la lista de habitaciones.\n" +
                    "2. Reservar una habitación.\n" +
                    "3. Cancelar una reserva.\n" +
                    "4. Guardar reservas en un archivo.\n" +
                    "5. Cargar reservas desde un archivo.\n" +
                    "6. Salir\n");
            op=scanner.nextInt();
            switch (op){
                case 1:
                   hotel.verHoteles();
                    break;
                case 2:
                    ArrayList<Huesped> Huespedes1=new ArrayList<>();
                    System.out.println("Ingrese el nro de habitación");
                    int hab=scanner.nextInt();
                    System.out.println("Ingrese el número de húespedes");
                    int huesp=scanner.nextInt();
                    for(int i=0; i<huesp;i++){
                    System.out.println("Ingrese el nombre");
                    String nombre=scanner.next();
                    System.out.println("Ingrese el DNI");
                    int dni=scanner.nextInt();
                    System.out.println("Ingrese domicilio");
                    String dom=scanner.next();
                    System.out.println("Ingrese dias de hospedaje");
                    int dias=scanner.nextInt();
                    Huespedes1.add(new Huesped(nombre,dni,dom,dias));
                    }
                    hotel.ReservarHabitacion(hab,Huespedes1);
                    break;
                case 3:
                    System.out.println("Ingrese el número de habitación");
                    int canc=scanner.nextInt();
                    hotel.cancelarReserva(canc);
                    System.out.println("Operación realizada");
                    break;
                case 4:
                    hotel.cargarArchivo();
                    break;
                case 5: hotel=GestionDelHotel.cargarReservasDesdeArchivo();
                    break;
                case 6:
                    scanner.close();
                    return;
                case 7:default:System.out.println("Error");

            }
        }
    }
}
abstract class Persona implements Serializable{
    protected String name;
    protected int DNI;
    protected String domicilio;

    public Persona(String name, int DNI, String domicilio){
        this.name=name;
        this.DNI=DNI;
        this.domicilio=domicilio;
    }

    public int getDNI() {
        return DNI;
    }

    public String getName() {
        return name;
    }
}
class Huesped extends Persona implements MostrarInformacion , Serializable{
    private int diasHospedaje;
    public Huesped(String name, int DNI, String domicilio, int diasHospedaje){
        super(name,DNI,domicilio);
        this.diasHospedaje=diasHospedaje;
    }

    @Override
    public void info() {
        System.out.println("[name: "+name+", DNI:"+DNI+", domicilio: "+domicilio+", días de hospedajo: "+diasHospedaje+"]");
    }
}
interface MostrarInformacion{
    abstract void info();
}
class Habitaciones  implements MostrarInformacion, Serializable{
    private int nroCamas;
    private int capacidadHuespedes;
    private boolean ocupada;
    ArrayList <Huesped> Huespedes;

    public Habitaciones(int nroCamas, int capacidadHuespedes) {
        this.nroCamas = nroCamas;
        this.capacidadHuespedes = capacidadHuespedes;
        ocupada = false;
    }

    @Override
    public void info() {
        System.out.println("[nro Camas: "+nroCamas+", capacidad: "+capacidadHuespedes+", ocupada: "+ocupada+"]");
        if(ocupada){
            System.out.print("Huéspedes: ");
            for (Huesped huespede : Huespedes) {
                huespede.info();
            }

        }

    }

    public void agregarHuespued(ArrayList <Huesped> huespedes1) {
        Huespedes = huespedes1;
    }


    public void eliminarHuespes(int DNI) {
        for (int i = 0; i < Huespedes.size(); i++) {
            if (Huespedes.get(i).getDNI() == DNI) {
                Huespedes.remove(i);
                break;
            }
        }

    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public ArrayList <Huesped> getHuespedes() {
        return Huespedes;
    }

    public void setHuespedes(ArrayList <Huesped> huespedes) {
        Huespedes = huespedes;
    }
}

class GestionDelHotel implements Serializable {
    ArrayList <Habitaciones> habitaciones;

    public GestionDelHotel(ArrayList<Habitaciones> H1) {
        habitaciones = H1;
    }

    public void ReservarHabitacion(int nroHotel, ArrayList <Huesped> huespedes1) {
        for (int i = 0; i < habitaciones.size(); i++) {
            if (i == nroHotel) {
                if (!habitaciones.get(i).isOcupada()) {
                    habitaciones.get(i).agregarHuespued(huespedes1);
                    habitaciones.get(i).setOcupada(true);
                    System.out.println("Reserva hecha ");
                    break;
                } else {
                    System.out.println("Habitación Ocupada, se reservará otra habitación");
                    for(int j=0; j<habitaciones.size() ;j++){
                        if(!habitaciones.get(j).isOcupada()){
                           habitaciones.get(j).agregarHuespued(huespedes1);
                           habitaciones.get(j).setOcupada(true);
                           System.out.println("Reserva Hecha en habitación: "+habitaciones.get(j));
                           break;
                        }
                        if(j==habitaciones.size()-1){
                            habitaciones.add(new Habitaciones(2,3));
                            j--;
                        }
                    }


                }

            }
        }
    }

    public void cancelarReserva(int nroHotel) {
        for (int i = 0; i < habitaciones.size(); i++) {
            if (i == nroHotel) {
                habitaciones.get(i).setOcupada(false);
                habitaciones.get(i).Huespedes.clear();
            }
        }
    }
    public void verHoteles(){
        for (Habitaciones habitacione : habitaciones) {
            habitacione.info();
        }
    }
    public void cargarArchivo(){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("C:"+ File.separator+"Users"+File.separator+"Usuario"+File.separator+"Hotel.txt");
            //Primero se define el archivo en el cual vamos a escribir.
            ObjectOutputStream flujosalida= new ObjectOutputStream(fileOutputStream);
            //Segundo se abre un fujo por el cual vamos a pasar el objeto a escibir.
            flujosalida.writeObject(this);//Escribimos el objeto.
            flujosalida.close();//Cerramos el flujo de salida.
        }catch (IOException e){
            System.out.println("Error en realizar la acción");
            e.printStackTrace();
        }
    }
    public static GestionDelHotel cargarReservasDesdeArchivo() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("C:"+ File.separator+"Users"+File.separator+"Usuario"+File.separator+"Hotel.txt"))) {
            return (GestionDelHotel) entrada.readObject();
        }catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar las reservas desde el archivo: " + e.getMessage());
            return null;
        }
    }
}




