
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
            <form name="AgregarsugerenciaForm" action="Controladorsugerencia" method="get">
                <table  class="table">
                    <thead>
                        <tr>
                            <th class="text-center" colspan="2">Agregar Sugerencia</th>                            
                        </tr>
                    </thead>
                    <tbody>
                        <tbody>
                            <tr>
                            <td class="text-right">Persona</td>
                            <td><input class="form-control" type="text" name="f_idpersona" value="" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Area</td>
                            <td><input class="form-control" type="text" name="f_idarea" value="" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Rol</td>
                            <td><input class="form-control" type="text" name="f_idrol" value="" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Sugerencia</td>
                            <td><input class="form-control" type="text" name="f_sugerencia" value="" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Estado</td>
                            <td><input class="form-control" type="text" name="f_estado" value="" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="text-center">
                                <input class="btn btn-success" type="submit" value="Agregar sugerencia" name="agregar" />
                                <input type="hidden" value="agregarsugerencia02" name="f_accion"/>
                                <a class="btn btn-success"href="index.html"><FONT COLOR="white">REGRESAR</a>
                                    
                            </td>
                        </tr>
                        
                    </tbody>
                </table>
                
            </form>
        </div>
    </body>
</html>
