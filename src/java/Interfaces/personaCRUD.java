package Interfaces;
import Modelo.persona;
import java.util.List;

public interface personaCRUD {
    public List listarpersona();
    public persona buscarpersona(int idpersona);
    public boolean agregarpersona(persona persona);
    public boolean editarpersona(persona persona);
    public boolean eliminarpersona(int idpersona);
}
