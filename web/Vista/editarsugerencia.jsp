
<%@page import="Modelo.sugerencia"%>
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
            <%
                sugerenciaDAO sugerenciaDAO = new sugerenciaDAO();
                int s_idsugerencia = Integer.valueOf(request.getParameter("f_idsugerencia"));
                sugerencia sugerencia = (sugerencia)sugerenciaDAO.buscarsugerencia(s_idsugerencia);
            %>
            <form name="EditarsugerenciaForm" action="Controladorsugerencia" method="get">
                <table  class="table">
                    <thead>
                        <tr>
                            <th class="text-center" colspan="2">Editar sugerencia</th>                            
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="text-right">Persona</td>
                            <td><input class="form-control" type="text" name="f_idpersona" value="<% out.println(sugerencia.getIdpersona()); %>" maxlength="12" size="12" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Area</td>
                            <td><input class="form-control" type="text" name="f_idarea" value="<% out.println(sugerencia.getIdarea()); %>" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Rol</td>
                            <td><input class="form-control" type="text" name="f_idrol" value="<% out.println(sugerencia.getIdrol()); %>" maxlength="40" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Sugerencia</td>
                            <td><input class="form-control" type="text" name="f_sugerencia" value="<% out.println(sugerencia.getSugerencia()); %>" maxlength="8" size="8" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Estado</td>
                            <td><input class="form-control" type="text" name="f_estado" value="<% out.println(sugerencia.getEstado()); %>" maxlength="1" size="2" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="text-center">
                                <input class="btn btn-success" type="submit" value="Editar sugerencia" name="editar" />
                                <input type="hidden" value="editarsugerencia02" name="f_accion"/>
                                <input type="hidden" value="<% out.print(sugerencia.getIdsugerencia()); %>" name="f_idsugerencia">
                                <a class="btn btn-success"href="index.html"><FONT COLOR="white">REGRESAR</a>
                            </td>
                        </tr>

                    </tbody>
                </table>


            </form>
        </div>
    </body>
</html>
