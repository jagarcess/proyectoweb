<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
  <head><title>Hello :: Spring Application</title></head>
  <body>
    <h1>Hello - Spring Application</h1>
    <p>Lista 2</p>
    <table border = 1>
    
   <c:forEach items="${model.estudiantes}" var="est">
     <tr>
     <td><c:out value="${est.idestudiante}"/> <td> <c:out value="${est.tipodoc}"/></td><td> <i> <c:out value="${est.documento}"/></i></td>
     <td><c:out value="${est.fecha}"/> <td>
     <td> 
        <a href="${pageContext.request.contextPath}/estudiante/view.htm?estudianteId=${est.idestudiante}">Edit</a>
	</td>
     <td> 
        <a href="${pageContext.request.contextPath}/estudiante/erase.htm?estudianteId=${est.idestudiante}">Borra</a>
	</td>
     
     
     </tr>
    </c:forEach>
   </table> 
 <!--   <a href="${pageContext.request.contextPath}/new.htm"
								style="color: green"><b>Adicionar estudiante</b></a>
		 -->						
	<form name="listestudiante" method="POST"action="${pageContext.request.contextPath}/estudiante/new.htm?fdAction=new" >
		
		<input type="submit" value="Crear estudiante" />
   </form>									
								
  </body>
</html>