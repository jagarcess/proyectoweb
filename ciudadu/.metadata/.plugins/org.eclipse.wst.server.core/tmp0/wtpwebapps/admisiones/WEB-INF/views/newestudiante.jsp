<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>

<title>Insert title here</title>
</head>
<body>
<form:form commandName="newEstudiante"
		name="createFixedDepositForm" method="POST"
		action="${pageContext.request.contextPath}/estudiante/create.htm?prueba=12345">
         
         <form:input path="documento" /><font style="color: #C11B17;"><form:errors path="documento"/></font>
         <form:input path="tipodoc" /><font style="color: #C11B17;"><form:errors path="tipodoc"/></font>
          <form:input path="fecha" /><font style="color: #C11B17;"><form:errors path="fecha"/></font>
         <input type="submit" value="${model.x}" />
 </form:form> 
  caracoles de colores
</body>
</html>