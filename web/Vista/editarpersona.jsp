<%@page import="Modelo.persona"%>
<%@page import="ModeloDAO.personaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar persona</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%
                personaDAO personaDAO = new personaDAO();
                int s_idpersona = Integer.valueOf(request.getParameter("f_idpersona"));
                persona persona = (persona)personaDAO.buscarpersona(s_idpersona);                
            %>
            <form name="EditarpersonasForm" action="Controlador" method="get">
                <table  class="table">
                    <thead>
                        <tr>
                            <th class="text-center" colspan="2">Editar personas</th>                            
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="text-right">Nombres: </td>
                            <td><input type="text" name="f_nombres" value="<% out.print(persona.getNombres()); %>" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Apellidos: </td>
                            <td><input type="text" name="f_apellidos" value="<% out.print(persona.getApellidos()); %>" maxlength="40" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">DNI: </td>
                            <td><input type="text" name="f_dni" value="<% out.print(persona.getDni()); %>" maxlength="8" size="8" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Direccion</td>
                            <td><input type="text" name="f_direccion" value="<% out.print(persona.getDireccion()); %>" maxlength="12" size="12" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Estado</td>
                            <td><input type="text" name="f_estado" value="<% out.print(persona.getEstado()); %>" maxlength="1" size="2" /></td>
                        </tr>
                        <tr>
                            <td class="text-center" colspan="2">
                                <input class="btn-primary" type="submit" name="editar" value="Editar persona" />
                                <input type="hidden" name="f_accion" value="editarpersona02" />
                                <input type="hidden" name="f_idpersona" value="<% out.print(persona.getIdpersona()); %>" />
                            </td>
                        </tr>
                    </tbody>
                </table>

            </form>
            
        </div>
    </body>
</html>
