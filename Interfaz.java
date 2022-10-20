import java.util.Scanner;

public class Interfaz {
    private Scanner sc;
    private Estanteria mueble;

    //Se maneja con un mueble y una estanteria 
    Interfaz(int F, int C){
        sc = new Scanner(System.in);
        mueble = new Estanteria(F,C);
        MainMenu();
    }

    //Menu principal
    public void MainMenu(){
        int opc = 0;
        do {
            System.out.println("\tFarmacia UCR");
            System.out.println("1) Imprimir el estante");
            System.out.println("2) Guardar Medicamento");
            System.out.println("3) Entrega Medicamento");
            System.out.println("4) Imprimir Estadisticas");
            System.out.println("5) Terminar Programa");
            opc = sc.nextInt();
            switch(opc){
                case 1: mueble.MostrarEstanteria();
                    break;
                case 2: GuardarMedicamento();
                    break;
                case 3: EntregaMedicamento();
                    break;
                case 4: mueble.ImprimirEstatdisticas();
                    break;
                case 5: System.out.println("Saliendo");
                    break;
                default:  System.out.println("Opcion incorrecta");
            }
        }while(opc != 5);
    }

    //Menu a la hora de elegir la opcion de guardar el medicamento
    public void GuardarMedicamento(){
        String nom = " ",tam = " ",ins = " ";
        char tipo = ' ';
        int f,c;
        boolean bandera = false;
        System.out.println("\t Ingreso del medicamento ");

        System.out.println("Digite el Nombre del medicamento: ");
        nom = sc.next();
        System.out.println("Digite la cantidad en mg del medicamento: ");
        tam = sc.next();
        System.out.println("Digite las instrucciones del medicamento: ");
        ins = sc.next();

        while(bandera == false) {
            System.out.println("Digite el tipo de medicamento P(pastilla) / C(crema) / J(jarabe): ");
            tipo = sc.next().charAt(0);
            if(tipo == 'P' || tipo == 'C' || tipo == 'J') {
                bandera = true;
            }else{
                System.out.println("Tipo Incorrecto, Debe Ingresar P o C o J segun el tipo del medicamento");
            }

        }
        System.out.println("Digite la fila donde desea guardar el medicamento: ");
        f = sc.nextInt();
        System.out.println("Digite la columna donde desea guardar el medicamento: ");
        c = sc.nextInt();

        Medicamento med = new Medicamento(nom,tam,ins,tipo);
        mueble.InsertarElemento(med,f,c);

    }

    //Menu a la hora de elegir la opcion de entregar medicamento
    public void EntregaMedicamento(){
        int f = 0,c = 0;
        String nom = " ",Fech = " ";
        Medicamento m = null;
        System.out.println("Digite la fila del medicamento a remover: ");
        f = sc.nextInt();
        System.out.println("Digite la columna del medicamento a remover: ");
        c = sc.nextInt();
        System.out.println("Digite el nombre de la persona que retira: ");
        nom = sc.next();
        System.out.println("Digite la la fecha de retiro(dia/mes/anio): ");
        Fech = sc.next();

        m = mueble.Entregar(nom,f,c,Fech);
        if(m != null){
            System.out.println(nom+" - "+Fech);
            System.out.println(m.getInstrucciones());
            System.out.println(m + " "+m.getTipo());
        }
        else{
            System.out.println("Datos Erroneos");
        }


    }


}