public class Desarrollador{
    private String nombre;
    private String puesto;

    public Desarrollador(String nombre, String puesto){
        this.nombre=nombre;
        this.puesto=puesto;
    }

    public Desarrollador(){

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public String getPuesto() {
        return puesto;
    }

    public String Programadores(){
        return nombre+" - "+puesto;
    }

}