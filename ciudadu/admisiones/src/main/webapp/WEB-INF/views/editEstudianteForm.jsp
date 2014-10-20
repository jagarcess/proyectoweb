<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>

<title>Editar estudiante</title>
</head>
<body>

<form:form commandName="editableEstudiante"
		name="editEstudianteForm" method="POST"
		action="${pageContext.request.contextPath}/estudiante/edit.htm">
        
          
	
	<c:out value="${editableEstudiante.idestudiante}"/>
						
         <form:input path="documento" /><font style="color: #C11B17;"><form:errors path="documento"/></font>
         <form:input path="tipodoc" /><font style="color: #C11B17;"><form:errors path="tipodoc"/></font>
          <form:input path="fecha" /><font style="color: #C11B17;"><form:errors path="fecha"/></font>
         <input type="submit" value="Guardar" />
 </form:form> 
</body>
</html>