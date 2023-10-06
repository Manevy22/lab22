package BaseDeDatos;
import java.sql.*;
import java.util.Scanner;


public class familiaayala {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/familiaayala";
        String usuario = "root";
        String pass = "";
        try {
            // Establecer la conexi�n a la base de datos
            Connection conexion = DriverManager.getConnection(url, usuario, pass);
            while(true){
                System.out.println("Ingrese la opción que desea realiza: 1.Mostrar integrantes, 2.Agregar integrante, 3.Editar Integrante, 4.Eliminar estudiante, 5.Salir");
                int op=scanner.nextInt();
                scanner.nextLine();
                switch (op){
                    case 1:SELECT_todo(conexion);
                        break;
                    case 2:INSERT(conexion,scanner);
                        break;
                    case 3:UPDATE(conexion,scanner);
                        break;
                    case 4: DELETE(conexion,scanner);
                        break;
                    case 5:
                        System.out.println("Hasta luego!");
                        conexion.close();
                        scanner.close();
                        System.exit(0);
                        break;
                    case 6:System.out.println("Opción inválida");
                        break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void SELECT_todo(Connection conexion) throws SQLException{
        Statement statement = conexion.createStatement();//creo la consulta.
        String consulta="SELECT * FROM `integrantes`";//defino la consulta.
        ResultSet resultado = statement.executeQuery(consulta);//guardo los datos de la consulta.
        System.out.println("ID\tNombre\tGenero\tfechaNacimiento\tOcupación");

        while (resultado.next()) {
            int id = resultado.getInt("ID");
            String Nombre = resultado.getString("Nombre");
            String  Genero= resultado.getString("Genero");
            String fechaNacimiento = resultado.getString("fechaNacimiento");
            String Ocupacion = resultado.getString("Ocupación");
            // Imprime los datos del estudiante con tabulaciones para formatear como una tabla.
            System.out.println(id + "\t" + Nombre + "\t" + Genero + "\t" + fechaNacimiento + "\t" + Ocupacion);
        }
        resultado.close();
        statement.close();
    }
    public static void INSERT(Connection conexion, Scanner scanner) throws SQLException{
            System.out.println("Ingrese nombre");
            String nombre=scanner.nextLine();
            System.out.println("Ingrese género: 1: femenino, 2:masculino, 3: otro");
            String genero;
            int gen= scanner.nextInt();
            scanner.nextLine();
            switch (gen){
                case 1: genero="femenino";
                    break;
                case 2:genero="masculino";
                    break;
                case 3:genero="otro";
                    break;
                case 4: default:
                    System.out.println("Error, género predeterminado: otro");
                    genero="otro";break;
            }
            System.out.println("Ingrese fecha de nacimiento (YYYY-MM-DD):");
            String fechaNacimiento = scanner.nextLine();
            System.out.println("Ingrese ocupación");
            String ocupacion= scanner.nextLine();
            String INSERT = "INSERT INTO `integrantes`(`Nombre`, `Genero`, `fechaNacimiento`, `Ocupación`) " +
                    "VALUES (?, ?, ?, ?)";
            // Crea un PreparedStatement para ejecutar la consulta SQL con valores reales.
            PreparedStatement preparedStatement = conexion.prepareStatement(INSERT);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, genero);
            preparedStatement.setString(3, fechaNacimiento);
            preparedStatement.setString(4, ocupacion);
            // Ejecuta la consulta y obtiene el n�mero de filas afectadas.
            int filasAfectadas = preparedStatement.executeUpdate();
            // Verifica si la inserci�n fue exitosa y muestra un mensaje apropiado.
            if (filasAfectadas > 0) {
                System.out.println("Integrante agregado exitosamente.");
            } else {
                System.out.println("No se pudo agregar al familiar.");
            }
                // Cierra el PreparedStatement para liberar recursos.
            preparedStatement.close();
        }
        public static void UPDATE(Connection conexion, Scanner scanner)throws SQLException{
            System.out.print("ID del integrante a editar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva l�nea despu�s de leer un entero.
            // Verificar si el integrante con el ID especificado existe en la base de datos.
            String consultaExistencia = "SELECT * FROM integrantes WHERE ID = ?";
            PreparedStatement preparedStatementExistencia =conexion.prepareStatement(consultaExistencia);
            preparedStatementExistencia.setInt(1, id); // Establece el valor del marcador de posici�n.
            ResultSet resultadoExistencia = preparedStatementExistencia.executeQuery();
            // Si no se encuentra ning�n integrante con el ID proporcionado, muestra un mensaje y sale de la funci�n.
            if (!resultadoExistencia.next()) {
                System.out.println("El integrante con el ID ingresado no existe.");
                preparedStatementExistencia.close();
                return;
            }
            System.out.print("Nuevo nombre: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Nuevo Genero: ");
            String nuevoGenero = scanner.nextLine();
            System.out.print("Nueva fecha de nacimiento (YYYY-MM-DD): ");
            String nuevaFechaNacimiento = scanner.nextLine();
            System.out.print("Nueva ocupación: ");
            String nuevaOcupacion = scanner.nextLine();

            // Consulta SQL para actualizar los datos del estudiante en la base de datos.
            String consulta = "UPDATE integrantes SET Nombre=?,Genero=?,fechaNacimiento=?,Ocupación=? WHERE id = ?";

            // Crea un PreparedStatement para ejecutar la consulta SQL con valores reales.
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
            preparedStatement.setString(1, nuevoNombre);
            preparedStatement.setString(2, nuevoGenero);
            preparedStatement.setString(3, nuevaFechaNacimiento);
            preparedStatement.setString(4, nuevaOcupacion);
            preparedStatement.setInt(5, id);

            // Ejecuta la consulta SQL y obtiene el n�mero de filas afectadas.
            int filasAfectadas = preparedStatement.executeUpdate();

            // Verifica si la edici�n fue exitosa y muestra un mensaje apropiado.
            if (filasAfectadas > 0) {
                System.out.println("Integrante editado exitosamente.");
            } else {
                System.out.println("No se pudo editar al integrante.");
            }

            // Cierra el PreparedStatement para liberar recursos.
            preparedStatement.close();
        }
        public static void DELETE(Connection conexion, Scanner scanner) throws SQLException{
            System.out.print("ID del integrante a eliminar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva l�nea despu�s de leer un entero.
            // Verificar si el integrante con el ID especificado existe en la base de datos.
            String consultaExistencia = "SELECT * FROM integrantes WHERE ID = ?";
            PreparedStatement preparedStatementExistencia =conexion.prepareStatement(consultaExistencia);
            preparedStatementExistencia.setInt(1, id); // Establece el valor del marcador de posici�n.
            ResultSet resultadoExistencia = preparedStatementExistencia.executeQuery();
            // Si no se encuentra ning�n integrante con el ID proporcionado, muestra un mensaje y sale de la funci�n.
            if (!resultadoExistencia.next()) {
                System.out.println("El integrante con el ID ingresado no existe.");
                preparedStatementExistencia.close();
                return;
            }
            String consulta = "DELETE FROM integrantes WHERE id = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
            preparedStatement.setInt(1, id); // Establece el valor del marcador de posici�n.
            // Ejecuta la consulta SQL y obtiene el n�mero de filas afectadas.
            int filasAfectadas = preparedStatement.executeUpdate();
            // Verifica si la eliminaci�n fue exitosa y muestra un mensaje apropiado.
            if (filasAfectadas > 0) {
                System.out.println("Estudiante eliminado exitosamente.");
            } else {
                System.out.println("No se pudo eliminar el estudiante.");
            }
            // Cierra el PreparedStatement para liberar recursos.
            preparedStatement.close();
        }
    }

