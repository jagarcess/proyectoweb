<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Create a new Estudeiante</title>
</head>
<body>

		<form name="createFixedDepositForm" method="POST" action="${pageContext.request.contextPath}/create.htm">
		<input type="text" name="documento" value="${requestScope.estudiante.documento}"/>  
	    <input type="text" name="tipodoc" value="${requestScope.estudiante.tipodoc}"/> 
	    <input type="submit" value="Save" />
		</form>

  caracoles de cilores
</body>
</html>