<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<% 
request.setAttribute("ruta",request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<tiles:insertAttribute name="head" />
</head>

<body>

    <div id="wrapper">


        <tiles:insertAttribute name="cabecera" />
        <div id="page-wrapper">
            <tiles:insertAttribute name="script" />
            <tiles:insertAttribute name="content" />

        </div>


    </div>




</body>
</html>