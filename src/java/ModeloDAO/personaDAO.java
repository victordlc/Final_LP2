package ModeloDAO;

import Config.bd.ConectaBd;
import Modelo.persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Interfaces.personaCRUD;

public class personaDAO implements personaCRUD{

    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    persona p = new persona();
    
    @Override
    public List listarpersona() {
        ArrayList<persona> personas = new ArrayList<>();
        String consulta = " select * "
                        + " from persona ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                persona persona = new persona();
                persona.setIdpersona(rs.getInt("idpersona"));
                persona.setNombres(rs.getString("nombres"));
                persona.setApellidos(rs.getString("apellidos"));
                persona.setDni(rs.getString("dni"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setEstado(rs.getString("estado"));
                personas.add(persona);
            }
        } catch (Exception e) {
        }
        return personas;
    }

    @Override
    public persona buscarpersona(int idpersona) {
        String consulta = " Select * "
                        + " from persona  "
                        + " where idpersona = "+ idpersona +" ; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                p.setIdpersona(rs.getInt("idpersona"));
                p.setNombres(rs.getString("nombres"));
                p.setApellidos(rs.getString("apellidos"));
                p.setDni(rs.getString("dni"));
                p.setDireccion(rs.getString("direccion"));
                p.setEstado(rs.getString("estado"));                
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean agregarpersona(persona persona) {
        String consulta = " insert into persona(nombres, apellidos, dni, direccion, estado) "
                        + " values(  "
                        + "'"+ persona.getNombres() +"',  "
                        + "'"+ persona.getApellidos() +"',  "
                        + "'"+ persona.getDni() +"',  "
                        + "'"+ persona.getDireccion() +"',  "
                        + "'"+ persona.getEstado() +"'); ";

        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editarpersona(persona persona) {
        String consulta =   " update persona  "
                        +   " set "
                        +   " nombre = '"+ persona.getNombres() +"',"
                        +   " apellidos = '"+ persona.getApellidos()+"', "
                        +   " dni = '"+ persona.getDni()+"', "
                        +   " codigo = '"+ persona.getDireccion()+"', "
                        +   " estado = '"+ persona.getEstado() +"'  "
                        +   " where "
                        +   " idpersona = "+ persona.getIdpersona() +" ; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminarpersona(int idpersona) {
        String consulta =   " delete from persona "
                        +   " where " 
                        +   " idpersona = "+ idpersona +" ; ";

        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return false;
        
    }
    
}
