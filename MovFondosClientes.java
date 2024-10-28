import java.util.ArrayList;
import java.util.Scanner;

public class MovFondosClientes {

    static private ArrayList< MovFondosClientes > MovFondosClientes = new ArrayList<>();

    public static void opcionesMovFondosClientes() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("====================================");
            System.out.println("Registro de Fondos de Terceros ");
            System.out.println("");
            System.out.println("1. Registrar ingreso de fondos de un cliente");
            System.out.println("2. Registrar egreso de fondos de un cliente");
            System.out.println("3. Consultar movimientos de fondos de un cliente");
            System.out.println("4. Envío de informe por correo electrónico a cliente");
            System.out.println("4. Volver al menú principal");
            System.out.println("====================================");

            System.out.print("Elige una opción: ");
            String opcion = scanner.next();

            switch (opcion) {
                case "1":
                    registrarIngresoFondo();
                    break;
                case "2":
                    registrarEgresoFondo();
                    break;
                case "3":
                    consultarMovFondos();
                    break;
                case "4":
                    enviarInfCliente();
                    break;
                case "0":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }
    }

    private static void registrarIngresoFondo() {

    }

    private static void registrarEgresoFondo() {

    }

    private static void consultarMovFondos() {

    }

    private static void enviarInfCliente() {
 
    }

}