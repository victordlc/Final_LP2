package ModeloDAO;

import Config.bd.ConectaBd;
import Interfaces.areaCRUD;
import Modelo.area;
import Modelo.area;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class areaDAO implements areaCRUD{

    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    area a = new area();
        
    @Override
    public List listararea() {
        ArrayList<area> areas = new ArrayList<>();
        String consulta = " select * "
                        + " from area ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                area area = new area();
                area.setIdarea(rs.getInt("idarea"));
                area.setNombre(rs.getString("nombre"));
                area.setEstado(rs.getString("estado"));
                areas.add(area);
            }
        } catch (Exception e) {
        }
        return areas;
    }

    @Override
    public area buscararea(int idarea) {
        String consulta = " Select * "
                        + " from area  "
                        + " where idarea = "+ idarea +" ; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                a.setIdarea(rs.getInt("idarea"));
                a.setNombre(rs.getString("nombre"));
                a.setEstado(rs.getString("estado"));                
            }
        } catch (Exception e) {
        }
        return a;
    }

    @Override
    public boolean agregararea(area area) {
        String consulta = " insert into area(nombre, estado) "
                        + " values(  "
                        + "'"+ area.getNombre() +"',  "
                        + "'"+ area.getEstado() +"'); ";

        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editararea(area area) {
        String consulta =   " update area  "
                        +   " set "
                        +   " nombre = '"+ area.getNombre() +"',"
                        +   " estado = '"+ area.getEstado() +"'  "
                        +   " where "
                        +   " idarea = "+ area.getIdarea() +" ; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminararea(int idarea) {
        String consulta =   " delete from area "
                        +   " where " 
                        +   " idarea = "+ idarea +" ; ";

        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
