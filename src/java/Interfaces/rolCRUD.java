package Interfaces;

import Modelo.rol;
import java.util.List;

public interface rolCRUD {
    public List listarrol();
    public rol buscarrol(int idrol);
    public boolean agregarrol(rol rol);
    public boolean editarrol(rol rol);
    public boolean eliminareol(int idrol);
}
