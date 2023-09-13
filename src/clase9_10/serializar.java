package clase9_10;


import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class serializar {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo a crear");
        String nombre=scanner.next();
        scanner.nextLine();
        System.out.println("Ingrese un texto para guardarlo en un block de notas");
        String t1= scanner.nextLine();
        blocknotas n1= new blocknotas(t1);
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("C:"+File.separator+"Users"+File.separator+"Usuario"+File.separator+"manevy"+File.separator+nombre+".txt");
            //Primero se define el archivo en el cual vamos a escribir.
            ObjectOutputStream flujosalida= new ObjectOutputStream(fileOutputStream);
            //Segundo se abre un fujo por el cual vamos a pasar el objeto a escibir.
            flujosalida.writeObject(n1);//Escribimos el objeto.
        }catch (IOException e){
            System.out.println("Error en realizar la acción");
            e.printStackTrace();
        }
        try{
            FileInputStream fileInputStream=new FileInputStream("C:"+File.separator+"Users"+File.separator+"Usuario"+File.separator+"manevy"+File.separator+nombre+".txt");
            //Primero se define el archivo que vamos a leer.
            ObjectInputStream flujodeentrada=new ObjectInputStream(fileInputStream);
            //Segundo se abre un fujo por el cual vamos a pasar el objeto a leer.
            blocknotas notasenfichero=(blocknotas) flujodeentrada.readObject();//Se lee el contenido del objeto.
            System.out.println("Contenido del archivo: "+notasenfichero);
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
class blocknotas implements Serializable {
    private String texto;
    public blocknotas(String texto){
        this.texto=texto;
    }

    @Override
    public String toString() {
        return texto;
    }
}
