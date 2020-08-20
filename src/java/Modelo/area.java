package Modelo;

public class area {
    public int idarea;
    public String nombre;
    public String estado;

    public area(int idarea, String nombre, String estado) {
        this.idarea = idarea;
        this.nombre = nombre;
        this.estado = estado;
    }

    public area(){
        
    }
    
    public int getIdarea() {
        return idarea;
    }

    public void setIdarea(int idarea) {
        this.idarea = idarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
