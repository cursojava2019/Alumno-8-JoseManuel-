<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="./WEB-INF/jsp/plantilla/head.jsp" %>
<body>

    <div id="wrapper">

        <!-- Navigation -->
        <%@include file="./WEB-INF/jsp/plantilla/cabecera.jsp" %>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Pantalla Principal Proyecto Academia</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.Incluir mi codigo -->
            <div class="row">
            <div class="col-lg-12">
            	<h3>Bienvenido a la gestión de la academia, elija una opción del menú</h3>
            </div>
            	<form action="./login.html" method="post">
					<p><label>usuario: </label><input name="usuario" type="text"></p>
					<p><label>Password: </label><input name="password" type="password"></p>
					<button type="submit">Identificar</button>
				</form>	
            
            </div>
            
            
            
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

   <%@include file="./WEB-INF/jsp/plantilla/javascriptPie.jsp" %>

</body>
</html>