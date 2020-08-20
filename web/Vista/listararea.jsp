<%@page import="java.util.Iterator"%>
<%@page import="Modelo.area"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.areaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Listado de Areas</h1>
            <a class="btn btn-success" href="Controlador?f_accion=agregararea01">Agregar Area</a>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Estado</th>
                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        areaDAO areaDAO = new areaDAO();
                        List<area> areas = areaDAO.listararea();
                        Iterator<area> iterator = areas.iterator();
                        area area = null;
                        while (iterator.hasNext()) {
                            area = iterator.next();

                    %>
                    <tr>
                        <td class="text-center"><% out.print(area.getIdarea()); %></td>
                        <td><% out.print(area.getNombre()); %></td>
                        <td class="text-center"><% out.print(area.getEstado()); %></td>                        
                        <td class="text-center">
                            <a class="btn btn-warning" href="Controlador?f_accion=editararea01&f_idarea=<% out.print(area.getIdarea()); %>">Editar</a>
                            <a class="btn btn-danger" href="Controlador?f_accion=eliminararea&f_idarea=<% out.print(area.getIdarea()); %>">Eliminar</a>
                        </td>
                    </tr>
                    <% 
                        }
                    %>
                </tbody>
            </table>

        </div>
    </body>
</html>
