public class Tarea {

    private String nombre;
    private String tipo;
    private Desarrollador desarrollador;
    private float tE;
    private float tR;
    private String estado;    

    public Tarea(String nombre, String tipo, Desarrollador desarrollador, float tE, float tR, String estado){
        this.nombre=nombre;
        this.tipo=tipo;
        this.desarrollador=desarrollador;
        this.tE=tE;
        this.tR=tR;
        this.estado=estado;
    }

    public Tarea(){
        
    } 

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }

    public void setDesarrollador(Desarrollador desarrollador) {
        this.desarrollador = desarrollador;
    }
    public Desarrollador getDesarrollador() {
        return desarrollador;
    }

    public void settE(float tE) {
        this.tE = tE;
    }
    public float gettE() {
        return tE;
    }

    public void settR(float tR) {
        this.tR = tR;
    }
    public float gettR() {
        return tR;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getEstado() {
        return estado;
    }
}
