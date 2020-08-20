package ModeloDAO;

import Config.bd.ConectaBd;
import Interfaces.rolCRUD;
import Modelo.rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class rolDAO implements rolCRUD{

    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    rol r = new rol();
    
    public List listarrol() {
        ArrayList<rol> roles = new ArrayList<>();
        String consulta = " select * "
                        + " from rol ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                rol rol = new rol();
                rol.setIdrol(rs.getInt("idrol"));
               
                rol.setEstado(rs.getString("estado"));
                roles.add(rol);
            }
        } catch (Exception e) {
        }
        return roles;
    }

    public rol buscarrol(int idrol) {
        String consulta = " Select * "
                        + " from rol  "
                        + " where idrol = "+ idrol +" ; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                r.setIdrol(rs.getInt("idrol"));
                r.setNombre(rs.getString("nombre"));
                r.setEstado(rs.getString("estado"));                
            }
        } catch (Exception e) {
        }
        return r;
    }

    public boolean agregarrol(rol rol) {
        String consulta = " insert into rol(nombres, apellidos, dni, direccion, estado) "
                        + " values(  "
                        + "'"+ rol.getNombre() +"',  "
                        + "'"+ rol.getEstado() +"'); ";

        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean editarrol(rol rol) {
        String consulta =   " update rol  "
                        +   " set "
                        +   " nombre = '"+ rol.getNombre() +"',"
                        +   " estado = '"+ rol.getEstado() +"'  "
                        +   " where "
                        +   " idrol = "+ rol.getIdrol() +" ; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean eliminarrol(int idrol) {
        String consulta =   " delete from rol "
                        +   " where " 
                        +   " idrol = "+ idrol +" ; ";

        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
        
    }
    
}
