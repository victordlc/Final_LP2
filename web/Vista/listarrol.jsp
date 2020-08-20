<%@page import="Modelo.rol"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.rolDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Roles</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Listado de Roles</h1>
            <a class="btn btn-success" href="Controlador?f_accion=agregarrol01">Agregar Rol</a>
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
                        rolDAO rolDAO = new rolDAO();
                        List<rol> roles = rolDAO.listarrol();
                        Iterator<rol> iterator = roles.iterator();
                        rol rol = null;
                        while (iterator.hasNext()) {
                            rol = iterator.next();

                    %>
                    <tr>
                        <td class="text-center"><% out.print(rol.getIdrol()); %></td>
                        <td><% out.print(rol.getNombre()); %></td>
                        <td class="text-center"><% out.print(rol.getEstado()); %></td>                        
                        <td class="text-center">
                            <a class="btn btn-warning" href="Controlador?f_accion=editarrol01&f_idrol=<% out.print(rol.getIdrol()); %>">Editar</a>
                            <a class="btn btn-danger" href="Controlador?f_accion=eliminarrol&f_idrol=<% out.print(rol.getIdrol()); %>">Eliminar</a>
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