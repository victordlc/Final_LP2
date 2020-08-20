package Modelo;

public class sugerencia {
    public int idsugerencia;
    public String idpersona;
    public String idarea;
    public String idrol;
    public String sugerencia;
    public String estado;

    public sugerencia(int idsugerencia, String idpersona, String idarea, String idrol, String sugerencia, String estado) {
        this.idsugerencia = idsugerencia;
        this.idpersona = idpersona;
        this.idarea = idarea;
        this.idrol = idrol;
        this.sugerencia = sugerencia;
        this.estado = estado;
    }

    public sugerencia() {
    }

    public int getIdsugerencia() {
        return idsugerencia;
    }

    public void setIdsugerencia(int idsugerencia) {
        this.idsugerencia = idsugerencia;
    }

    public String getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(String idpersona) {
        this.idpersona = idpersona;
    }

    public String getIdarea() {
        return idarea;
    }

    public void setIdarea(String idarea) {
        this.idarea = idarea;
    }

    public String getIdrol() {
        return idrol;
    }

    public void setIdrol(String idrol) {
        this.idrol = idrol;
    }

    public String getSugerencia() {
        return sugerencia;
    }

    public void setSugerencia(String sugerencia) {
        this.sugerencia = sugerencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

}
