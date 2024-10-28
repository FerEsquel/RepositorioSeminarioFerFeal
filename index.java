import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class index {
    public static void main( String[] args) {

        //Cliente cliente = new Cliente();
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        String opcion; //Guardaré la opción del usuario

        System.out.println("Bienvenido");
        System.out.println("");
        System.out.println("");

        //Inicio las tres liquidaciones base.
        Liquidacion.liquidacionesBase();

        while (!salir)
        {
            System.out.println("====================================");
            System.out.println("MENU DE OPCIONES");
            System.out.println("");
            System.out.println("1. Clientes (Alta Baja Modificaciones y Consulta)");
            System.out.println("2. Tipos de Liquidaciones (Alta Baja Modificaciones y Consulta)");
            System.out.println("3. Vencimientos de Liquidaciones (Alta Baja Modificaciones y Consulta)"); 
            System.out.println("4. Liquidaciones (Carga de Importes en Clientes, Envío de Mail, consultas)"); 
            System.out.println("5. Movmientos de Fondos de Clientes");             
            System.out.println("0. Salir");
            System.out.println("");
            System.out.println("====================================");


            try {
                System.out.print("Escribe una de las opciones: ");
                opcion = sn.next();

                switch (opcion) {
                    case "1":
                        Cliente.opcionesCliente();
                        break;
                    case "2":
                        Liquidacion.opcionesLiquidacion();
                        break;
                    case "3":
                        LiquidacionesVencimientos.opcionesVencimiento();
                        break;
                    case "4":
                        LiquidacionesImportes.opcionesLiquidacionesImportes();
                        break;
                    case "5":
                        MovFondosClientes.opcionesMovFondosClientes();
                        break;                        
                    case "0":
                        salir = true;
                        break;
                    default:
                        System.out.println("Eligió opción no válida, intente nuevamente");
                        sn.next();
                }
            } catch (InputMismatchException e) {
                System.out.println("tipeo un caracter no válido, intente nuevamente");
                sn.next();
            }
        }


    }



    }

