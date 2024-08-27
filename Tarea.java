//  @ Ejercicio 2
//  @ File Name : Tarea.java
//  @ Date : 27/08/2024
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//

public class Tarea {
    //Atributos
    private String nombre;
    private String tipo;
    private Desarrollador desarrollador;
    private float tE;
    private float tR;
    private String estado;    

    //Constructor
    /**
     * 
     * @param nombre String
     * @param tipo String
     * @param desarrollador Desarrollador
     * @param tE float
     * @param tR float
     * @param estado String
     */
    public Tarea(String nombre, String tipo, Desarrollador desarrollador, float tE, float tR, String estado){
        this.nombre=nombre;
        this.tipo=tipo;
        this.desarrollador=desarrollador;
        this.tE=tE;
        this.tR=tR;
        this.estado=estado;
    }

    //Constructor vacio
    /**
     * 
     */
    public Tarea(){
        
    } 
    
    /**
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * 
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * 
     * @param desarrollador
     */
    public void setDesarrollador(Desarrollador desarrollador) {
        this.desarrollador = desarrollador;
    }
    /**
     * 
     * @return desarrollador
     */
    public Desarrollador getDesarrollador() {
        return desarrollador;
    }

    /**
     * 
     * @param tE
     */
    public void settE(float tE) {
        this.tE = tE;
    }
    /**
     * 
     * @return tE
     */
    public float gettE() {
        return tE;
    }

    /**
     * 
     * @param tR
     */
    public void settR(float tR) {
        this.tR = tR;
    }
    /**
     * 
     * @return tR
     */
    public float gettR() {
        return tR;
    }

    /**
     * 
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    /**
     * 
     * @return estado
     */
    public String getEstado() {
        return estado;
    }
}
