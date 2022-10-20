public class Medicamento {
    
    //Esto seria para la fecha de retiro
    public String getRetiro() {
        return Retiro;
    }

    public void setRetiro(String retiro) {
        Retiro = retiro;
    }

    private String Retiro;

    //Se utiliza para obtener el nombre de la persona que retira pero cuando no hay medicamento esta en null
    public String getNomPersonaQueRetira() {
        return NomPersonaQueRetira;
    }

    public void setNomPersonaQueRetira(String nomPersonaQueRetira) {
        NomPersonaQueRetira = nomPersonaQueRetira;
    }

    private String NomPersonaQueRetira;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    private String tamanio;

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    private String instrucciones;


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    private String tipo;

    public Medicamento(String nom,String tam,String Ins,char tip){
        nombre = nom;
        tamanio = tam;
        instrucciones = Ins;
        if(tip == 'P' || tip == 'C' ||tip == 'J') {
            if (tip == 'P') {
                tipo = "Pastillas";
            }
            if (tip == 'C') {
                tipo = "Crema";
            }
            if (tip == 'J') {
                tipo = "Jarabe";
            }
        }else{
            tipo = "Desconocido";
        }
        Retiro = null;
        NomPersonaQueRetira = " ";
    }
    public String toString(){
        return nombre+": "+tamanio+" mg";
    }
}
