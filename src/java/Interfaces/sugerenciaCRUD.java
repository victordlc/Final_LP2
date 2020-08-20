package Interfaces;

import Modelo.sugerencia;
import java.util.List;

public interface sugerenciaCRUD {
    public List listarsugerencia();
    public sugerencia buscarsugerencia(int isdugerencia);
    public boolean agregarsugerencia(sugerencia sugerencia);
    public boolean editarsugerencia(sugerencia sugerencia);
    public boolean eliminarsugerencia(int sugerencia);
}
