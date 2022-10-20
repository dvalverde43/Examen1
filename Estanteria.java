public class Estanteria {
    private Medicamento [][] estanteria;
    private int filas;
    private int columnas;
    private int cantidad;

    //Recibe la cantidad de filas y columnas de la estanteria
    public Estanteria(int Fila, int Columna){
        estanteria = new Medicamento[Fila][Columna];
        filas = Fila;
        columnas = Columna;
        cantidad = 0;
        for(int i = 0;i<Fila;i++){
            for(int j=0;j<Columna;j++){
                estanteria[i][j] = null;
            }
        }
    }

    //Imprime la estanteria, recorre la matriz y si lo que tiene es un null imprime un espacio y sino imprime el medicamento
    public void MostrarEstanteria(){
        for(int i = 0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                if(estanteria[i][j] != null) {
                    System.out.print(estanteria[i][j]); System.out.print("          ");
                }
                else{
                    System.out.print("             ");
                }
            }
            System.out.print("\n");
        }
    }

    //insertar un medicamento en la estanteria y valida que la fila y columna ingresada este dentro de los limites y que el espacio no este ocupado, ademas aumenta cantidad cuando ingresa 1
    public void InsertarElemento(Medicamento med, int F, int C){
        if(F < filas && C < columnas){
            if(estanteria[F][C] == null){
                estanteria[F][C] = med;
                cantidad++;
            }
            else{
                System.out.println("Ese espacio ya tiene un medicamento");
            }
        }else{
            System.out.println("Ese espacio no existe");
        }
    }

    //Saca el medicamento en la posicion ingresada, le setea la fecha y la persona que lo retira y quita el medicamento de la matriz
    public Medicamento Entregar(String per,int F,int C,String Fech){
        if(F < filas && C < columnas){
            if(estanteria[F][C] != null){
                Medicamento m = estanteria[F][C];
                m.setNomPersonaQueRetira(per);
                m.setRetiro(Fech);
                estanteria[F][C] = null;
                cantidad--;
                return m;
            }
            else{
               return null;
            }
        }else {
            return null;
        }
    }

    //Recorre la matriz en busca de que tipo de medicamentos hay, con tres contadores para cada tipo que existe, si el espacio en la matriz != null aumenta el contador del tipo de medicamento
    public void ImprimirEstatdisticas(){
        double Cre = 0, Jar = 0, pas = 0;
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                if(estanteria[i][j] != null){
                    if(estanteria[i][j].getTipo().equals("Pastillas")){
                        pas++;
                    }
                    if(estanteria[i][j].getTipo().equals("Crema")){
                        Cre++;
                    }
                    if(estanteria[i][j].getTipo().equals("Jarabe")){
                        Jar++;
                    }
                }
            }
        }
        System.out.println("\tEstadisticas: ");
        double pstat = (pas/cantidad)*100;
        double cstat = (Cre/cantidad)*100;
        double jstat = (Jar/cantidad)*100;
        System.out.println("Pastillas: "+pstat+" Cremas: "+cstat+" Jarabes: "+ jstat);
    }
}