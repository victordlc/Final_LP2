<%@page import="Modelo.area"%>
<%@page import="ModeloDAO.areaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Area</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%
                areaDAO areaDAO = new areaDAO();
                int s_idarea = Integer.valueOf(request.getParameter("f_idarea"));
                area area = (area)areaDAO.buscararea(s_idarea);                
            %>
            <form name="EditarareasForm" action="Controlador" method="get">
                <table  class="table">
                    <thead>
                        <tr>
                            <th class="text-center" colspan="2">Editar areas</th>                            
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="text-right">Nombre: </td>
                            <td><input type="text" name="f_nombre" value="<% out.print(area.getNombre()); %>" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Estado</td>
                            <td><input type="text" name="f_estado" value="<% out.print(area.getEstado()); %>" maxlength="1" size="2" /></td>
                        </tr>
                        <tr>
                            <td class="text-center" colspan="2">
                                <input class="btn-primary" type="submit" name="editar" value="Editar area" />
                                <input type="hidden" name="f_accion" value="editararea02" />
                                <input type="hidden" name="f_idarea" value="<% out.print(area.getIdarea()); %>" />
                            </td>
                        </tr>
                    </tbody>
                </table>

            </form>
            
        </div>
    </body>
</html>
