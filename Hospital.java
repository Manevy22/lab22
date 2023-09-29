import ArrayL.Array;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        Doctores doctor1= new Doctores("Fernanda", 45103146, "12/12/1980","Pediatría");
        Doctores doctor2= new Doctores("Natalia", 79586123,"10/4/2003","Obstetricia");
        ArrayList<Doctores> doctores=new ArrayList <>();
        doctores.add(doctor1);
        doctores.add(doctor2);
        ArrayList<String> historialVirginia=new ArrayList <>();
        String texto1="29/08/2023- Ingreso al Hospital";
        historialVirginia.add(texto1);
        ArrayList<String> historialDaniel=new ArrayList <>();
        String texto2="25/09/2023- Ingreso al Hospital";
        historialDaniel.add(texto2);
        Pacientes pacientesuno=new Pacientes("Virginia",45654456,"22/10/2003",364758,1,historialVirginia);
        Pacientes pacientedos=new Pacientes("Daniel", 89987678, "22/5/2013",198769,2,historialDaniel);
        GestionPacientes gestionPacientes=new GestionPacientes();
        gestionPacientes.nuevoPaciente(pacientesuno);
        gestionPacientes.nuevoPaciente(pacientedos);
        while (true){
            System.out.println("Menú:\n" +
                    "1. Listar Doctores.\n" +
                    "2. Registrar un nuevo paciente.\n" +
                    "3. Actualizar información personal de un paciente.\n" +
                    "4. Consultar el historial médico de un paciente.\n" +
                    "5. Nuevo historial para un paciente. \n" +
                    "6. Guardar Historial de pacientes en archivo \n" +
                    "7. Cargar Historial de pacientes desde archivo \n" +
                    "8. Salir.\n");
            int op=scanner.nextInt();
            switch (op){
                case 1:
                    for(int i=0;i<doctores.size();i++){
                        System.out.println(doctores.get(i).toString());
                    }
                    break;
                case 2:
                    System.out.println("Ingrese nombre del paciente");
                    String nombre=scanner.next();
                    System.out.println("Ingrese dni");
                    int dni= scanner.nextInt();
                    System.out.println("Ingrese fecha de nacimiento en formato  dd/MM/yyyy");
                    String fechaNac=scanner.next();
                    System.out.println("Ingrese nro de teléfono");
                    int nrotel=scanner.nextInt();
                    System.out.println("Ingrese tipo de Sangre");
                    int tiposan=scanner.nextInt();
                    System.out.println("Ingrese la fecha actual");
                    String fechaactual="\n"+scanner.next();
                    String ob1=fechaactual+"- Inicio como paciente del Perrando\n";
                    ArrayList<String> historial=new ArrayList <>();
                    historial.add(ob1);
                    Pacientes paciente1=new Pacientes(nombre,dni,fechaNac,nrotel,tiposan,historial);
                    gestionPacientes.nuevoPaciente(paciente1);
                    break;
                case 3:
                    System.out.println("Ingrese dni");
                    int dni1= scanner.nextInt();
                    System.out.println("Ingrese nuevo nombre del paciente");
                    String newnombre=scanner.next();
                    System.out.println("Ingrese la nueva fecha de nacimiento en formato  dd/MM/yyyy");
                    String newfechaNac=scanner.next();
                    System.out.println("Ingrese nuevo nro de teléfono");
                    int newnrotel=scanner.nextInt();
                    System.out.println("Ingrese nuevo tipo de Sangre");
                    int newtiposan=scanner.nextInt();
                    gestionPacientes.actualizarInfoPaciente(dni1,newnombre,newfechaNac,newnrotel,newtiposan);
                    break;
                case 4:
                    System.out.println("Ingrese dni");
                    int dni2= scanner.nextInt();
                    gestionPacientes.consultarHistorial(dni2);
                    break;
                case 5:
                    System.out.println("Ingrese dni");
                    int dni3= scanner.nextInt();
                    System.out.println("Ingrese la fecha actual");
                    String fechaactual1=scanner.next();
                    System.out.println("Ingrese observación");
                    String obs=scanner.next();
                    String his=fechaactual1+obs;
                    gestionPacientes.nuevoHistorial(dni3,his);
                    break;
                case 6: gestionPacientes.guardarHistorialPacientes();
                    break;
                case 7:gestionPacientes=GestionPacientes.cargarHistorialPacientes();
                    break;
                case 8:scanner.close();
                    break;
                case 9:default:System.out.println("Error");
                break;

            }
        }
    }
}

abstract class Personaa implements Serializable{
    private String nombre;
    private int dni;
    private String fechaNacimiento;
    public Personaa(String nombre, int dni, String fechaNacimiento){
        this.nombre = nombre;
        this.dni=dni;
        this.fechaNacimiento=fechaNacimiento;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
class Doctores extends Personaa{
    private String Especialidad;
    public Doctores(String nombre, int dni, String fechaNacimiento, String Especialidad){
        super(nombre,dni,fechaNacimiento);
        this.Especialidad=Especialidad;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    @Override
    public String toString() {
        return "[Nombre: "+getNombre()+", fecha de Nacimiento: "+getFechaNacimiento()+", Especialidad: "+getEspecialidad()+"]";
    }
}
class Pacientes extends  Personaa implements Informacion, Serializable{
    private int nroTelefono;
    private int tipoDeSangre;
    ArrayList<String> HistorialMedico;
    public Pacientes(String nombre, int dni, String fechaNacimiento, int nroTelefono, int tipoSangre, ArrayList<String> Historial){
        super(nombre,dni,fechaNacimiento);
        this.nroTelefono=nroTelefono;
        this.tipoDeSangre=tipoSangre;
        this.HistorialMedico=Historial;
    }

    public void setNroTelefono(int nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public void setTipoDeSangre(int tipoDeSangre) {
        this.tipoDeSangre = tipoDeSangre;
    }

    public int getNroTelefono() {
        return nroTelefono;
    }

    public int getTipoDeSangre() {
        return tipoDeSangre;
    }

    @Override
    public void verHistorialDeEventos() {
        System.out.println("HISTORIAL MÉDICO");
        for(int i=0;i<HistorialMedico.size();i++){
            System.out.println("\n"+HistorialMedico.get(i)+"\n");
        }
    }
    public void nuevoHistorial(String historial){
        HistorialMedico.add(historial);
    }
}
interface Informacion{
    public void verHistorialDeEventos();
}
class GestionPacientes implements Serializable{
    ArrayList<Pacientes> pacientes;
    public GestionPacientes(){
        pacientes= new ArrayList <>();
    }
    public void nuevoPaciente(Pacientes p1){
        pacientes.add(p1);
    }
    public void actualizarInfoPaciente(int Dni,String nombre, String fechaNacimiento, int nroTelefono, int tipoSangre){
        for(int i=0;i<pacientes.size();i++){
            if(pacientes.get(i).getDni()==Dni){
            pacientes.get(i).setNombre(nombre);
            pacientes.get(i).setFechaNacimiento(fechaNacimiento);
            pacientes.get(i).setNroTelefono(nroTelefono);
            pacientes.get(i).setTipoDeSangre(tipoSangre);
            break;
            }
        }
    }
    public void consultarHistorial(int dni){
        for(int i=0;i<pacientes.size();i++){
            if(pacientes.get(i).getDni()==dni){
                System.out.println(pacientes.get(i).HistorialMedico);
                break;
            }
        }
    }
    public void nuevoHistorial(int dni, String newhistorial){
        for(int i=0;i<pacientes.size();i++){
            if(pacientes.get(i).getDni()==dni){
                pacientes.get(i).nuevoHistorial("\n"+newhistorial+"\n");
                break;
            }
        }
    }
    public void guardarHistorialPacientes(){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("C:"+ File.separator+"Users"+File.separator+"Usuario"+File.separator+"HistorialPaciente.txt");
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
    public static GestionPacientes cargarHistorialPacientes() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("C:"+ File.separator+"Users"+File.separator+"Usuario"+File.separator+"HistorialPaciente.txt"))) {
            return (GestionPacientes) entrada.readObject();
        }catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar  " + e.getMessage());
            return null;
        }
    }
}
