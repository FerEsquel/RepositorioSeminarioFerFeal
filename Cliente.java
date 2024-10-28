import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.SQLClientInfoException;
import java.util.*;
import javax.swing.*;
import javax.swing.JOptionPane;


public class Cliente implements Cliente_Interface {

    //Defino los atributos de la clase cliente

    private String codigoCliente;
    private String razonSocial;
    private String nombreFantasia;
    String[] liquidacionesContratadas = {"IIBB", "IVA", "SUELDO", "PRODUCTOS"};
    static protected ArrayList< Cliente > listaDeClientes = new ArrayList();
    private String email;
    private int cuitPrefijo;
    private int cuitMedio;
    private int cuitSufijo;


    //Método constructor
    public Cliente() {

        //Inicializo las variables del método constructor

        this.codigoCliente = "";
        this.razonSocial = "";
        this.nombreFantasia = "";
        this.email = "";
        this.cuitPrefijo = 0;
        this.cuitMedio = 0;
        this.cuitSufijo = 0;

    }

    //===============================métodoS===================================

    //DESPLIEGO EÑ MENÚ DE OPCIONES DE CLIENTE
    public static void opcionesCliente(){

        //Con la clase escanner recibo lo que el usuario escribe por teclado en sn.
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardo la opción del usuario

        while (!salir)
        {

            System.out.println("====================================");
            System.out.println("MENÚ DE OPCIONES DE CLIENTE");
            System.out.println("");
            System.out.println("1. Crear nuevo Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Buscar Cliente por codigo");
            System.out.println("4. Modificar clientes");
            System.out.println("5. Eliminar cliente"); 
            System.out.println("6. Guardar Clientes en archivo");
            System.out.println("0. Salir");
            System.out.println("");
            System.out.println("====================================");

            try {

                System.out.println("Escribe una de las opciones: \n");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        Cliente.agregarCliente();
                        break;
                    case 2:
                        Cliente.mostrarCliente();
                        break;
                    case 3:
                        Cliente.buscarClientes();
                        break;
                    case 4:
                        Cliente.modificarCliente();
                        break;
                    case 5:
                        Cliente.eliminarCliente();
                        break;
                    case 6:
                        Cliente.GuardarClientesArchivo();
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 6 o 0 para salir, intente nuevamente");
                }
            } catch (InputMismatchException e) {
                System.out.println("Tipeó un caracter incorrecto, intente nuevamente");
                sn.next();
            }// fin del catch
            
        }// fin del ciclo while
    }// fin del método opcionesCliente

    //método para agregar una nueva instancia de la clase Cliente.
    public static void agregarCliente(){
    	boolean lb_existe;
        try{
            // creo el objeto cliente.
            Cliente cliente = new Cliente();

            // Tomo los valores ingresados por el usuario con JOptionPane y el método showInputDialog.
            String codigo_Cliente = JOptionPane.showInputDialog("Ingrese el codigo del nuevo cliente: ");
            
            String nombre_Fantasia = JOptionPane.showInputDialog("Ingrese el Nombre completo: ");

            String razon_social = JOptionPane.showInputDialog("Ingrese la Razon social: ");

            String _email = JOptionPane.showInputDialog("Ingrese el correo electronico: ");

            int cuit_Prefijo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el prefijo del Cuit: "));

            int cuit_Medio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el termino medio del Cuit: "));

            int cuit_Sufijo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el sufijo del Cuit: "));

            // Con los métodos set, establezco los valores de los atributos luego de que el usuario ingresa los datos.
            cliente.setCodigoCliente(codigo_Cliente);
            cliente.gNombre(nombre_Fantasia);
            cliente.gEmail(_email);
            cliente.gRazonSocial(razon_social);
            cliente.setCuitPrefijo(cuit_Prefijo);
            cliente.setCuitMedio(cuit_Medio);
            cliente.setCuitSufijo(cuit_Sufijo);

            // Añado al nuevo cliente a la array de listaDeClientes.
            listaDeClientes.add(cliente);

            //Muestro un mensaje al usuario.
            JOptionPane.showMessageDialog(null,"El Cliente ha sido agregado exitosamente!");
        }catch(IllegalArgumentException e){
            System.out.println("No se pudo agregar el cliente");
        }// fin del catch
    }// fin del método agregar cliente


    //MOSTRAR CLIENTES.
    public static void mostrarCliente(){
    System.out.println("Lista de clientes: ");
    // EN caso de que no se hayan agregado clientes, este condicional mostrara un mensaje al usuario.
        if(listaDeClientes.size() == 0){
            System.out.println("No hay clientes agregados actualmente");
        }

        // Con un ciclo for recorro el arraylist listaDeClientes y muestro los datos de cada cliente agregado.
        for(int i = 0;i< listaDeClientes.size();i++){
            System.out.println("================================");
            System.out.println("Cliente Código: " + listaDeClientes.get(i).obtenerCodigoCliente() + "\nNombre: " + listaDeClientes.get(i).gNombre() + "\n" + "Email: " + listaDeClientes.get(i).gEmail() + "\n" + "Razon social: " + listaDeClientes.get(i).gRazonSocial() + "\n" + "CUIT: " + listaDeClientes.get(i).obtenerCuitPrefijo()+"-"+listaDeClientes.get(i).obtenerCuitMedio()+"-"+listaDeClientes.get(i).obtenerCuitSufijo());
        }
    }// fin método mostrar clientes

    //MODIFICAR CLIENTES
    public static void modificarCliente(){
        Cliente.mostrarCliente();
        try{
            //Guardamos en una variable codigo el valor ingresado por el usuario
            String codigo = JOptionPane.showInputDialog("Ingrese el código de el cliente que desea modificar: ");
            int position = -1;

            //recorro el array list listaDeVencimientos y encuentro un objeto cuyo codigo coincida con el ingresado.
            for(int i = 0; i < listaDeClientes.size();i++){
                if(listaDeClientes.get(i).obtenerCodigoCliente().equals(codigo)){
                    position = i;
                    //Con la clase escanner recibo lo que el usuario escribe por teclado en sn.
                    Scanner sn = new Scanner(System.in);
                    boolean salir = false;
                    int opcion; //Guardo la opción del usuario

                    while (!salir)
                    {

                        System.out.println("====================================");
                        System.out.println("QUE DESEA MODIFICAR?");
                        System.out.println("");
                        System.out.println("1. Nombre completo de cliente");
                        System.out.println("2. Razon social");
                        System.out.println("3. Email");
                        System.out.println("4. Prefijo Cuit");
                        System.out.println("5. Cuit Medio");
                        System.out.println("6. Sufijo Cuit");
                        System.out.println("7. Salir");
                        System.out.println("");
                        System.out.println("====================================");

                        try {

                            System.out.println("Escribe una de las opciones: \n");
                            opcion = sn.nextInt();

                            switch (opcion) {
                                case 1:
                                    String nombreCompleto = JOptionPane.showInputDialog("Ingrese el nuevo nombre: ");
                                    listaDeClientes.get(i).gNombre(nombreCompleto);
                                    //Muestro un mensaje al usuario.
                                    JOptionPane.showMessageDialog(null,"El Cliente ha sido modificado exitosamente!");
                                    break;
                                case 2:
                                    String razonSocial = JOptionPane.showInputDialog("Ingrese la nueva razon social: ");
                                    listaDeClientes.get(i).gRazonSocial(razonSocial);
                                    //Muestro un mensaje al usuario.
                                    JOptionPane.showMessageDialog(null,"El Cliente ha sido modificado exitosamente!");
                                    break;
                                case 3:
                                    String emailCliente = JOptionPane.showInputDialog("Ingrese el nuevo email: ");
                                    listaDeClientes.get(i).gEmail(emailCliente);
                                    //Muestro un mensaje al usuario.
                                    JOptionPane.showMessageDialog(null,"El Cliente ha sido modificado exitosamente!");
                                    break;
                                case 4:
                                    int prefijoCuit = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo prefijo: "));
                                    listaDeClientes.get(i).setCuitPrefijo(prefijoCuit);
                                    //Muestro un mensaje al usuario.
                                    JOptionPane.showMessageDialog(null,"El Cliente ha sido modificado exitosamente!");
                                    break;
                                case 5:
                                    int medioCuit = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo cuit medio: "));
                                    listaDeClientes.get(i).setCuitMedio(medioCuit);
                                    //Muestro un mensaje al usuario.
                                    JOptionPane.showMessageDialog(null,"El Cliente ha sido modificado exitosamente!");
                                    break;
                                case 6:
                                    int sufijoCuit = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo sufijo: "));
                                    listaDeClientes.get(i).setCuitSufijo(sufijoCuit);
                                    //Muestro un mensaje al usuario.
                                    JOptionPane.showMessageDialog(null,"El Cliente ha sido modificado exitosamente!");
                                    break;
                                case 7:
                                    salir = true;
                                    break;
                                default:
                                    System.out.println("Solo números entre 1 y 7");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Debes insertar un número");
                            sn.next();
                        }
                    }
                }
            }



            //manejo  el error en el caso de que haya ingresado un código incorrecto.
            if(position != -1){
                System.out.println("");
            }else{
                throw new IllegalArgumentException(
                        "No se ha encontrado un vencimiento que coincida con el codigo ingresado"
                );
            }
        }catch(IllegalArgumentException e){
            System.out.printf("Exception: %s\n\n", e.getMessage());
        }// fin del catch
    }// fin del método modificar clientes

    //BUSCAR CLIENTE
    public static void buscarClientes(){

        try{
            //Guardo en una variable código el valor ingresado por el usuario
            String codigo = JOptionPane.showInputDialog("Ingrese el código el codigo del cliente que desea buscar: ");
            int position = -1;

            //recorro el array list listaDeVencimientos y encuentro un objeto cuyo codigo coincida con el ingresado.
            for(int i = 0; i < listaDeClientes.size();i++){
                if(listaDeClientes.get(i).obtenerCodigoCliente().equals(codigo)){
                    System.out.println("================================");
                    System.out.println("Resultado de la busqueda: ");
                    System.out.println("Cliente numero: " + i + "\nCodigo de cliente: " + listaDeClientes.get(i).obtenerCodigoCliente() + "\nNombre Completo: " + listaDeClientes.get(i).gNombre() + "\n" + "Email: " + listaDeClientes.get(i).gEmail() + "\n" + "Razon social: " + listaDeClientes.get(i).gRazonSocial() + "\n" + "CUIT: " + listaDeClientes.get(i).obtenerCuitPrefijo()+"-"+listaDeClientes.get(i).obtenerCuitMedio()+"-"+listaDeClientes.get(i).obtenerCuitSufijo());
                    position = i;
                }
            }

            //manejo  el error en el caso de que haya ingresado un codigo incorrecto.
            if(position != -1){
                System.out.println("");
            }else{
                throw new IllegalArgumentException(
                        "No se ha encontrado un cliente que coincida con el código ingresado"
                );
            }
        }catch(IllegalArgumentException e){
            System.out.printf("Exception: %s\n\n", e.getMessage());
        }// fin del catch
    }// fin del método buscar cliente

    //ELIMINAR UN CLIENTE
    public static void eliminarCliente(){
        Cliente.mostrarCliente();
        try{
            //Guardo en una variable codigo el valor ingresado por el usuario
            String codigo = JOptionPane.showInputDialog("Ingrese el código de el cliente que desea eliminar: ");
            int position = -1;

            //recorro el array list listaDeVencimientos y encuentro un objeto cuyo codigo coincida con el ingresado.
            for(int i = 0; i < listaDeClientes.size();i++){
                if(listaDeClientes.get(i).obtenerCodigoCliente().equals(codigo)){
                    position = i;
                    // quito el objeto de la arrayList usando el método remove().
                    listaDeClientes.remove(position);
                    JOptionPane.showMessageDialog(null,"El Cliente ha sido eliminado exitosamente!");
                }
            }


            //manejo  el error en el caso de que haya ingresado un codigo incorrecto.
            if(position != -1){
                System.out.println("");
            }else{
                throw new IllegalArgumentException(
                        "No se ha encontrado un  cliente que coincida con el codigo ingresado"
                );
            }
        }catch(IllegalArgumentException e){
            System.out.printf("Exception: %s\n\n", e.getMessage());
        }// fin del catch
    }// fin del método eliminar cliente

 
    //BUSCAR CLIENTES POR CODIGO PARA CODIGO
    public static String buscarCliente_Cod(String codigo){

            //String codigo = JOptionPane.showInputDialog("Ingrese el código de la liquidación que desea buscar: ");
            String codigoDevuelto = "--1";

            for(int i = 0; i < listaDeClientes.size();i++){
                if(listaDeClientes.get(i).obtenerCodigoCliente().equals(codigo)){
                    codigoDevuelto = listaDeClientes.get(i).obtenerCodigoCliente();
                }
            }
            return codigoDevuelto;
    }    

    
    //BUSCAR CLIENTES POR CODIGO PARA NOMBRE
    public static String buscarCliente_Nombre(String codigo){

            //String codigo = JOptionPane.showInputDialog("Ingrese el código de la liquidación que desea buscar: ");
            String NombreDevuelto = "--1";

            for(int i = 0; i < listaDeClientes.size();i++){
                if(listaDeClientes.get(i).gNombre().equals(codigo)){
                	NombreDevuelto = listaDeClientes.get(i).gNombre() + " - " + listaDeClientes.get(i).gRazonSocial();
                }
            }
            return NombreDevuelto;
    }    
    
    
    
    
    public static void GuardarClientesArchivo() {
    	
	    FileWriter archivoTXT = null;
	    PrintWriter PrntW1 = null;
	    try {
	    	File directorio = new File("c:/temp");
	        if (!directorio.exists()) {
	            if (directorio.mkdirs()) {
	            } else {
	                System.out.println("Error al crear directorio c:\temp");
	            }
	        }
	    	archivoTXT = new FileWriter("c:/temp/clientes.txt");
	    	PrntW1 = new PrintWriter(archivoTXT);
	    	PrntW1.println("Lista de clientes: ");
		    // EN caso de que no se hayan agregado clientes, este condicional mostrará un mensaje en el archivo.
		    if(listaDeClientes.size() == 0){
		    	PrntW1.println("No hay clientes agregados actualmente");
		    } else {
		        // Con un ciclo for recorro el arraylist listaDeClientes y muestro los datos de cada cliente agregado.
		        for(int i = 0;i< listaDeClientes.size();i++){
		        	//PrntW1.println("================================");
		        	PrntW1.println("Cliente Código: " + listaDeClientes.get(i).obtenerCodigoCliente() + " - Nombre: " + listaDeClientes.get(i).gNombre() + "" + " - Email: " + listaDeClientes.get(i).gEmail() + "" + " - Razon social: " + listaDeClientes.get(i).gRazonSocial() + "" + " - CUIT: " + listaDeClientes.get(i).obtenerCuitPrefijo()+"-"+listaDeClientes.get(i).obtenerCuitMedio()+"-"+listaDeClientes.get(i).obtenerCuitSufijo());
		        }//fin for
		    } //Fin if/else
		    System.out.println("Archivo c:/temp/clientes.txt creado");
	    } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Aprovecho el finally para asegurame que se cierra el fichero.
           if (null != archivoTXT)
        	   archivoTXT.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           } 
    }// fin método GuardarClientesArchivo
		
 }
    
    //métodos settler:



    public void gNombre(String NombreFantasia){
        this.nombreFantasia = NombreFantasia;
    }


    public void gRazonSocial(String RazonSocial){
        this.razonSocial = RazonSocial;
    }


    public void setCodigoCliente(String CodigoCliente){
        this.codigoCliente = CodigoCliente;
    }


    public void gEmail(String Email){
        this.email = Email;
    }

    public void setCuitPrefijo(int CuitPre){
        this.cuitPrefijo = CuitPre;
    }

    public void setCuitMedio(int CuitMedio){
        this.cuitMedio = CuitMedio;
    }

    public void setCuitSufijo(int CuitSufijo){
        this.cuitSufijo = CuitSufijo;
    }

    //métodos getter:


    public String obtenerCodigoCliente(){

        return codigoCliente;
    }
    public  String gNombre(){

        return nombreFantasia;
    }
    public String gRazonSocial(){

        return razonSocial;
    }
    public String gEmail(){

        return email;
    }
    public int obtenerCuitPrefijo(){

        return cuitPrefijo;
    }
    public int obtenerCuitMedio(){
        return cuitMedio;
    }
    public int obtenerCuitSufijo(){
        return cuitSufijo;
    }

} // fin de clase Cliente
