package clase9_10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ficherosyDirectorios {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Desea crear una carpeta? 1:Si");
        int op=scanner.nextInt();
        scanner.nextLine();
        if(op==1) {
            System.out.println("Ingrese el nombre de la carpeta que quiere crear");
            String direc = scanner.next();
            crearDirectorio direct1 = new crearDirectorio(direc);
            direct1.crear();
        }

        System.out.println("Desea crear un archivo y agregarle contenido?1: Si");
        op= scanner.nextInt();
        scanner.nextLine();
        if(op==1){
            System.out.println("Ingrese el nombre de su archivo");
            String nombre=scanner.next();
            scanner.nextLine();
            crearArchivoConContenido v1=new crearArchivoConContenido(nombre);
            System.out.println("Ingrese el contenido del texto");
            String contenido=scanner.nextLine();
            v1.anadirTexto(contenido);
        }
        System.out.println("Vamos a comprobar la exitencia de un archivo");
        System.out.println("Ingrese el nombre de su archivo");
        String nombrearchivo=scanner.next();
        comprobarExsArchivo ar1=new comprobarExsArchivo(nombrearchivo);
        ar1.comprobar();
        //RECORRER EL CONTENIDO DE UNA CARPETA.
        System.out.println("Vamos a recorrer el contenido de una carpeta");
        File carpeta= new File("C:"+File.separator+"Users"+File.separator+"Usuario"+File.separator+"manevy");
        String[] nombrecontenido=carpeta.list();
        for(int i=0;i<nombrecontenido.length;i++){
            System.out.println(nombrecontenido[i]);
        }
    }
}
class crearDirectorio{

    String nombre;
    public crearDirectorio(String nombre){
        this.nombre=nombre;

    }
    public void crear(){
        File carpeta= new File("C:"+File.separator+"Users"+File.separator+"Usuario"+File.separator+"manevy"+File.separator+this.nombre);//Direccion del directorio.
        try {
            if(carpeta.mkdir())System.out.println("Se creó la carpeta");//mkdir nos devuelve un booleano si se creo la carpeta.
            else System.out.println("No se pudo crear la carpeta");
        }catch (SecurityException e){
            System.out.println("Permiso denegado para crear carpeta");//Se abre una exception en caso de que nos hayan denegado el acceso a la creación de la carpeta.
            e.printStackTrace();
        }
    }
}
class crearArchivoConContenido{
    String nombreArchivo;
    public crearArchivoConContenido(String nombreArchivo){
        this.nombreArchivo=nombreArchivo;
    }
    public void anadirTexto(String texto){
        try {
            FileWriter newArchivo= new FileWriter("C:"+File.separator+"Users"+File.separator+"Usuario"+File.separator+"manevy"+File.separator+"lab22"+File.separator+nombreArchivo+".txt",true);
            newArchivo.write(texto);//Se añade contenido al archivo.
            newArchivo.close();//Se cierra el archivo.
        } catch(IOException e) {
            e.printStackTrace();//Excepcion en el caso de no poder crearlo.
        }
    }
}
class comprobarExsArchivo{
    String nombrearchivo;
    public comprobarExsArchivo(String nombrearchivo){
        this.nombrearchivo=nombrearchivo;
    }
    public void comprobar(){
        File archivo=new File(this.nombrearchivo);
        System.out.println("Ruta: "+archivo.exists());
        System.out.println("Ruta: "+archivo.getAbsolutePath());
    }
}


