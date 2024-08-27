import java.util.Date;

public class Proyecto {

    private String nombre;
    private String codigo;
    private String categoria;
    private Desarrollador dJ;
    private Desarrollador dS;
    private Date fecha;
    Tarea []tareas=new Tarea[3];
    int tareaCount=0;



    public Proyecto(String nombre, String codigo, String categoria, Desarrollador dJ, Desarrollador dS, Date fecha){
        this.nombre=nombre;
        this.codigo=codigo;
        this.categoria=categoria;
        this.dJ=dJ;
        this.dS=dS;
        this.fecha=fecha;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getCategoria() {
        return categoria;
    }

    public void setdJ(Desarrollador dJ) {
        this.dJ = dJ;
    }
    public Desarrollador getdJ() {
        return dJ;
    }

    public void setdS(Desarrollador dS) {
        this.dS = dS;
    }
    public Desarrollador getdS() {
        return dS;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Date getFecha() {
        return fecha;
    }

    // Método para agregar una tarea al arreglo
    public boolean agregarTarea(Tarea tarea) {
        if (tareaCount < tareas.length) {
            tareas[tareaCount] = tarea;
            tareaCount++;
            return true;  // Tarea agregada exitosamente
        } else {
            return false;  // No hay espacio disponible
        }
    }

    public boolean tieneTareas(){
        return tareaCount>0;
    }

    // Método para obtener la lista de tareas
    public Tarea[] getTareas() {
        return tareas;
    }

}
