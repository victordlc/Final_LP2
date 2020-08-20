package ModeloDAO;

import Config.bd.ConectaBd;
import Interfaces.sugerenciaCRUD;
import Modelo.sugerencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class sugerenciaDAO implements sugerenciaCRUD
{
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    sugerencia s = new sugerencia();

    @Override
    public List listarsugerencia() {
        ArrayList<sugerencia> sugerencias = new ArrayList<>();
        String consulta = "Select su.idsugerencia, pe.nombre, ar.nombre, r.nombre, su.sugerencia, su.estado "
                + "from sugerencia su, persona pe, area ar, rol r"
                + "where pe.idpersona = su.idpersona and ar.idarea = su.idarea and r.idrol = su.idrol order by idsugerencia";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                sugerencia sugerencia = new sugerencia();
                sugerencia.setIdsugerencia(rs.getInt("su.idsugerencia")); 
                sugerencia.setIdpersona(rs.getString("pe.nombre"));
                sugerencia.setIdrol(rs.getString("r.nombre")); 
                sugerencia.setIdarea(rs.getString("ar.nombre"));
                sugerencia.setSugerencia(rs.getString("su.sugerencia"));
                sugerencia.setEstado(rs.getString("su.estado"));
                sugerencias.add(sugerencia);
            }
        } catch (Exception e) {
            
        }
        return sugerencias;
    }

    public sugerencia buscarsugerencia(int idsugerencia) {
        String consulta = " select *  "
                        + " from sugerencia  "
                        + " where idsugerencia= " + idsugerencia + " ;";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                s.setIdsugerencia(rs.getInt("idsugerencia"));
                s.setSugerencia(rs.getString("sugerencia"));
                s.setEstado(rs.getString("estado"));
                s.setIdpersona(rs.getString("idpersona"));
                s.setIdarea(rs.getString("idarea"));
                s.setIdrol(rs.getString("idrol"));
            }
        } catch (Exception e) {
        }
        
        return s;
    }

    public boolean agregarsugerencia(sugerencia sugerencia) {
        String consulta = " insert into sugerencia(idpersona, idarea, idrol, sugerencia, estado)  "
                        + " values( "
                        + "'"+ sugerencia.getIdpersona() +"', "
                        + "'"+ sugerencia.getIdarea() +"', "
                        + "'"+ sugerencia.getIdrol() +"', "
                        + "'"+ sugerencia.getSugerencia() +"', "
                        + "'"+ sugerencia.getEstado() +"') ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean editarsugerencia(sugerencia sugerencia) {
         String consulta = " update sugerencia"
                        + " set "
                        + " idpersona = '"+ sugerencia.getIdpersona() +"', "
                        + " idarea= '"+ sugerencia.getIdarea() +"', "
                        + " idrol= '"+ sugerencia.getIdrol() +"', "
                        + " sugerencia= '"+ sugerencia.getSugerencia() +"', "
                        + " estado = '"+ sugerencia.getEstado() +"' "
                        + " where "
                        + " idsugerencia = " + sugerencia.getIdsugerencia() + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

   
    public boolean eliminarsugerencia(int idsugerencia) {
        String consulta = " delete from sugerencia"
                        + " where "
                        + " idsugerencia = " + idsugerencia + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception m) {
        }
        return false;
    }
    
    
}
