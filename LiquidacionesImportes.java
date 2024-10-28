import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LiquidacionesImportes{
private String codCliente;  
private String nomCliente;
private int nroVencimiento;
private String fechaVencimiento;
private String nombreLiquidacion;
private float importeLiquidacion;
static private ArrayList< LiquidacionesImportes > listaDeImportes = new ArrayList();

//METODO CONSTRUCTOR
public LiquidacionesImportes(String nombre, String codigo, String vencimiento, String cCliente, String nCliente, int nVencimiento, float importe){
    this.codCliente = cCliente;  
    this.nomCliente = nCliente;
    this.nroVencimiento = nVencimiento;    
	this.fechaVencimiento =  vencimiento;
    this.nombreLiquidacion = nombre;
    this.importeLiquidacion = importe; 
}



    //DESPLIEGO MENÚ DE OPCIONES EN VENCIMIENTOS.

    public static void opcionesLiquidacionesImportes(){
        //Con la clase scanner recibo lo que el usuario escribe por teclado en sn.
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guerdo la opción del usuario
        while (!salir)
        {

            System.out.println("====================================");
            System.out.println("MENÚ DE OPCIONES DE Vencimiento");
            System.out.println("");
            System.out.println("1. Agregar importe");
            System.out.println("2. Modificar importe");
            System.out.println("3. Quitar importe");
            System.out.println("4. Enviar e-mail"); 
            System.out.println("5. Mostrar Clientes, Vencimientos e Importes"); 
            System.out.println("6. Salir");
            System.out.println("");
            System.out.println("====================================");

            try {

                System.out.println("Escribe una de las opciones: \n");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        LiquidacionesImportes.agregarImporte();
                        break;
                    case 2:
                        LiquidacionesImportes.modificarImporte();
                        break;
                    case 3:
                        LiquidacionesImportes.quitarImporte();
                        break;
                    case 4:
                        LiquidacionesImportes.enviaremail();
                        break;
                    case 5:    
                    	LiquidacionesImportes.mostrarImportesVencimientos();
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }


    public static void agregarImporte() {
        try{
   
            //Instancio la clase Vencimientos con parametros en blanco.
            LiquidacionesImportes importes = new LiquidacionesImportes("","","","","",0,0);
            // Muestro el arraylist creada en la clase Cliente al usuario.
            Cliente.mostrarCliente();
            //Pido al usuario que ingrese los datos necesarios para buscar el Cliente.            
            String codigo_Cliente = JOptionPane.showInputDialog("Ingrese el código de Cliente para cargar el importe: ");
            String codigoCliDevuelto = Cliente.buscarCliente_Cod(codigo_Cliente);
            String NombreCliDevuelto = Cliente.buscarCliente_Nombre(codigoCliDevuelto);
            // Muestro el arraylist creada en la clase LiquidacionesVencimientos al usuario.
            LiquidacionesVencimientos.mostrarVencimientos();
            //Pido al usuario que ingrese los datos necesarios para buscar el vencimiento.
            int codigo_Vencimiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nùmero de la LiquidaciónVencimiento para cargar el importe: "));
            int codigoVencDevuelto = LiquidacionesVencimientos.buscarVencimientos_Cod(codigo_Vencimiento);
            String nombreVencDevuelto = LiquidacionesVencimientos.buscarVencimientos_Nombre(codigoVencDevuelto);
            String fechaVencDevuelto = LiquidacionesVencimientos.buscarVencimientos_Nombre(codigoVencDevuelto);
            Float importeLiq = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el Importe: "));

            //Seteo las variables en los atributos del objeto de tipo LiquidacionesImportes.
            importes.setCodigoCli(codigoCliDevuelto);
            importes.setNombreCli(NombreCliDevuelto);
            importes.setNroLiq(codigoVencDevuelto);
            importes.setNombreLiq(nombreVencDevuelto);
            importes.setVencimientoLiq(fechaVencDevuelto);            
            importes.ImpLiq(importeLiq);

            //Agrego el objeto vencimiento al arraylist listaDeVencimientos con el metodo add.
            listaDeImportes.add(importes);
            JOptionPane.showMessageDialog(null, "El importe se agrego exitosamente");
        }catch(IllegalArgumentException e){
            System.out.println("No se pudo agregar el importe");
        }// fin del catch
    }// fin del metodo agregar Vencimientos

    //MOSTRAR VENCIMIENTOS
    public static void mostrarImportesVencimientos(){
        System.out.println("Lista de vencimientos, importes y clientes: ");
        // EN caso de que no se hayan agregado vencimientos, este condicional mostrara un mensaje al usuario.
        if(listaDeImportes.size() == 0){
            System.out.println("No hay vencimientos agregados actualmente");
        }

        // Con un ciclo for recorro el arraylist listaDeImportes y muestro los datos de cada cliente, vencimiento e importes agregados.
        for(int i = 0;i< listaDeImportes.size();i++){
            System.out.println("================================");
            System.out.println("Importe numero: " + (i + 1) 
            		+ "\nCod Cliente: " + listaDeImportes.get(i).getCodigoCli()
            		+ "\nCliente: " + listaDeImportes.get(i).getNombreCli()
            		+ "\nLiquidación: " + listaDeImportes.get(i).getNombreLiq()
            		+ "\nVencimiento: " + listaDeImportes.get(i).getVencimientoLiq()
            		+ "\nImporte: " + listaDeImportes.get(i).ImpLiq()
            );
        }
    }

    

    

    public static void modificarImporte(){
    }



    public static void quitarImporte(){
    }


    public static void enviaremail(){
    }


    //Metodo setter y getter
    
    public void setCodigoCli(String cCliente) {
        this.codCliente = cCliente;      	
    } 

    public void setNombreCli(String nCliente) {
        this.nomCliente = nCliente;      	
    } 
    
    
    public void setNroLiq(int lcodigo) {
        this.nroVencimiento = lcodigo;      	
    } 
    
    
    public void setNombreLiq(String nombreLiqVenc) {
        this.nombreLiquidacion = nombreLiqVenc;      	
    } 
    
    
    public void setVencimientoLiq(String fechaVenc) {
        this.fechaVencimiento = fechaVenc;      	
    } 
    
    //como set
    public void ImpLiq(float importe) {
        this.importeLiquidacion = importe;      	
    } 

    //como get
    public Float ImpLiq() {
        return importeLiquidacion;      	
    } 

    public String getCodigoCli() {
        return codCliente;      	
    } 

    public String getNombreCli() {
        return nomCliente;      	
    } 
    
    
    public int getNroLiq() {
        return nroVencimiento;      	
    } 
    
    
    public String getNombreLiq() {
        return nombreLiquidacion;      	
    } 
    
    
    public String getVencimientoLiq() {
        return fechaVencimiento;      	
    } 
    
    

}
    