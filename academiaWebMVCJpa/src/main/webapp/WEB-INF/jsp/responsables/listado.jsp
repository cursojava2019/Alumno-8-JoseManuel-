<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:if test="${param.mensaje eq 'correcto'}">
 <c:set var="mensajeOK" value="true" ></c:set>
</c:if>

<c:if test="${param.mensaje=='errorId'}">
 <c:set var="mensajeError" value="true" ></c:set>
</c:if>

     <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Responsables</h1>
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
                               Operaci�n realizada correctamente
                        </div>
                   </c:if>
                   <c:if test="${mensajeError}">
                        <div class="alert alert-danger" id="mensaje">
                            Id no encontrado. No es posible realizar la operaci�n.
                        </div>
				  </c:if>
                        <div class="panel-heading">
                            Listado de Responsables
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        <div style="float:right;">
	                          <button class="btn btn-default"  onclick="location.href='${ruta}/admin/responsables/nuevo.html';" type="button">
	                          	<i class="fa fa-user"> Nuevo Responsable</i>
	                          </button>
	                    </div>
	                        
                        <!-- /. buscador -->
                        <form name="buscador" action="./listado.html" method="post" >
                        	<div class="col-6" style="float:right; margin:2px;">
		                        <div class="col-3">
		                        		<label>Buscar Responsable
		                        		   	<input class="" name="patron" type="text" value="${patron}" />
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
                                        <th>Correo</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                  <c:forEach var="responsable" items="${listado}">   
                                    <tr class="odd gradeX">
                                        <td>${responsable.nombre}</td>
                                        <td>${responsable.apellido1} ${responsable.apellido2}</td>
                                        <td>${responsable.nif}</td>
                                        <td >${responsable.telefono}</td>
                                        <td >${responsable.correo}</td>
                                        <td >
                                        	<button class="btn btn-default" onclick="location.href='${ruta}/admin/responsables/modificar.html?id=${responsable.id}';" type="button">
                                        	  <b>Modificar</b>	
                                        	</button>
                                        	<button class="btn btn-default" onclick="confirmarEliminacion(${responsable.id})" type="button">
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
	 <script>
    $(document).ready(function() {	
        $('#dataTables-example').DataTable({
            responsive: true,
            "searching": false
        });
    });
    </script>
