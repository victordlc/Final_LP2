package Interfaces;

import Modelo.area;
import java.util.List;

public interface areaCRUD {
    public List listararea();
    public area buscararea(int idarea);
    public boolean agregararea(area area);
    public boolean editararea(area area);
    public boolean eliminararea(int idarea);
}
