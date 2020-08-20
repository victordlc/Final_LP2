<%@page import="Modelo.rol"%>
<%@page import="ModeloDAO.rolDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar rol</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%
                rolDAO rolDAO = new rolDAO();
                int s_idrol = Integer.valueOf(request.getParameter("f_idrol"));
                rol rol = (rol)rolDAO.buscarrol(s_idrol);                
            %>
            <form name="EditarrolsForm" action="Controlador" method="get">
                <table  class="table">
                    <thead>
                        <tr>
                            <th class="text-center" colspan="2">Editar rols</th>                            
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="text-right">Nombres: </td>
                            <td><input type="text" name="f_nombres" value="<% out.print(rol.getNombre()); %>" maxlength="30" size="20" /></td>
                        </tr>
                      
                        <tr>
                            <td class="text-right">Estado</td>
                            <td><input type="text" name="f_estado" value="<% out.print(rol.getEstado()); %>" maxlength="1" size="2" /></td>
                        </tr>
                        <tr>
                            <td class="text-center" colspan="2">
                                <input class="btn-primary" type="submit" name="editar" value="Editar rol" />
                                <input type="hidden" name="f_accion" value="editarrol02" />
                                <input type="hidden" name="f_idrol" value="<% out.print(rol.getIdrol()); %>" />
                            </td>
                        </tr>
                    </tbody>
                </table>

            </form>
            
        </div>
    </body>
</html>