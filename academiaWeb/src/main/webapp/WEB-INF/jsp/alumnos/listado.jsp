<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList"%>
<%@page import="es.indra.academia.model.entities.Alumno"%>
<%@page import="java.util.List"%>

<c:if test="${param.mensaje eq 'correcto'}">
 <c:set var="mensajeOK" value="true" ></c:set>
</c:if>

<c:if test="${param.mensaje=='errorId'}">
 <c:set var="mensajeError" value="true" ></c:set>
</c:if>
    
<!DOCTYPE html>
<html>
<c:import url="../plantilla/head.jsp"></c:import>
<body>
<c:out value=""></c:out>
    <div id="wrapper">

        <!-- Navigation -->
        <c:import url="../plantilla/cabecera.jsp"></c:import>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Alumnos</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.Incluir mi codigo -->
            <div class="row">
            <div class="col-lg-12">
            	<div class="panel panel-default">
            	<!-- Mensaje de todo correcto -->
            	   <c:if test="${mensajeOK}">
                        <div class="alert alert-success" id="mensaje">
                               Operación realizada correctamente
                        </div>
                   </c:if>
                   <c:if test="${mensajeError}">
                        <div class="alert alert-danger" id="mensaje">
                            Id no encontrado. No es posible realizar la operación.
                        </div>
				  </c:if>
                        <div class="panel-heading">
                            Listado de Alumnos
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        <div style="float:right;">
	                          <button class="btn btn-default"  onclick="location.href='${ruta}/admin/alumnos/nuevo.html';" type="button">
	                          	<i class="fa fa-user"> Nuevo Alumno</i>
	                          </button>
	                    </div>
	                        
                        <!-- /. buscador -->
                        <form name="buscador" action="./listado.html" method="post">
	                        <div class="col-6" style="float:right; margin:2px;">
		                        <div class="col-3">
		                        		<label>Buscar Alumno
		                                	<input class="" name="patron" type="text" value="${param.patron}">
		                                    <span class="">
			                                    <button class="btn btn-default" type="submit">
			                                    	<i class="fa fa-search"></i>
			                                    </button>
			                                </span>
		                                   
		                               </label>
		                       </div>
		                        <c:if test="${not empty param.patron}">
                                  <span>Busqueda filtrada por <strong>${param.patron} </strong></span>                       
							  </c:if> 
	                       </div>    
                         </form>
                         <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Apellidos</th>
                                        <th>DNI</th>
                                        <th>Telefono</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
	                                <c:forEach var="alumno" items="${listado}">                              
	                                    <tr class="odd gradeX">
	                                        <td>${alumno.nombre}</td>
	                                        <td>${alumno.apellido1} ${alumno.apellido2}</td>
	                                        <td>${alumno.nif}</td>
	                                        <td>${alumno.telefono}</td>
	                                       	<td >
	                                        	<button class="btn btn-default" onclick="location.href='${ruta}/admin/alumnos/modificar.html?id=${alumno.id}';" type="button">
	                                        	  <b>Modificar</b>	
	                                        	</button>
	                                        	<button class="btn btn-default" onclick="confirmarEliminacion(${alumno.id})" type="button">
	                                         	  <b>Eliminar</b>	
	                                         	</button>
											</td>
	                                    </tr>
									</c:forEach>    
                                </tbody>
                                
                            </table>  
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
            </div>
            
            
            </div>
            
            
            
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
	<c:import url="../plantilla/javascriptPie.jsp"></c:import>
 
	 <script>
    $(document).ready(function() {	
        $('#dataTables-example').DataTable({
            responsive: true,
            "searching": false
        });
     
    });
    </script>
	
</body>
</html>