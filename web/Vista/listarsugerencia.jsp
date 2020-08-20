<%@page import="java.util.Iterator"%>
<%@page import="Modelo.sugerencia"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.sugerenciaDAO"%>
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
            <h1>Listado de Sugerencias</h1>
            <a class="btn btn-success" href="Controladorsugerencia?f_accion=agregarsugerencia01">Agregar Nueva Sugerencia</a>
              
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Persona</th> 
                        <th class="text-center">Area</th>
                        <th class="text-center">Rol</th>
                        <th class="text-center">Sugerencia</th>
                        <th class="text-center">Estado</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        sugerenciaDAO sugerenciaDAO = new sugerenciaDAO();
                        List<sugerencia> sugerencias =  sugerenciaDAO.listarsugerencia();
                        Iterator<sugerencia> iterator = sugerencias.iterator();
                        sugerencia sugerencia = null;
                        while (iterator.hasNext()) {
                            sugerencia = iterator.next();


                    %>
                    <tr>
                        <td><% out.print(sugerencia.getIdsugerencia()); %></td>
                        <td><% out.print(sugerencia.getIdpersona()); %></td>
                        <td><% out.print(sugerencia.getIdarea()); %></td>
                        <td><% out.print(sugerencia.getIdrol()); %></td>
                        <td><% out.print(sugerencia.getSugerencia()); %></td>
                        <td><% out.print(sugerencia.getEstado()); %></td>
                        <td>
                            <a class="btn btn-warning" href="Controladorsugerencia?f_accion=editarsugerencia01&f_idsugerencia=<% out.print(sugerencia.getIdsugerencia()); %>">
                                Editar
                            </a>
                            <a class="btn btn-danger" href="Controladorsugerencia?f_accion=eliminarsugerencia&f_idsugerencia=<% out.print(sugerencia.getIdsugerencia()); %>">
                                Eliminar
                            </a>
                        </td>
                    </tr>
                    <%    }
                    %>                    
                </tbody>
            </table>
                <table border="0" cellspacing="0" cellpagging="0" align="center">

                
                    <tr>
                        <td> </td>
                        <td colspan="2"><a class="btn btn-success"href="index.html"><FONT COLOR="white">REGRESAR</a></td>
                    </tr>
                    
            </table>
        </div>
    </body>
</html>
