<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home App</title>
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
	</head>
	<body>
		<%
			String usuario = request.getParameter("username");
			String pais = request.getParameter("idpais");
		
			if(usuario != null && !"".equals(usuario)){
				int idPais = Integer.valueOf(pais);
				List<String> paises = (List<String>)session.getAttribute("LISTA_PAISES");
				
				String nombrePais = paises.get(idPais-1);
				session.setAttribute("USUARIO_LOGIN", usuario);
				
				
		%>
			<img alt="Login Successful"
			width="150px"
			 src="https://ethical-leader.blog/wp-content/uploads/2020/08/success-1.jpg">
			 <p>Hola <%= usuario %></p>
			<p>El pais seleccionado es: <%= nombrePais %></p>

		<%
			}else{
				out.print("<h3>Favor inicia sesión para acceder!</h3>");
				out.print("<p>No se encontró el usuario en el sistema!</p>");
				
		%> 
				<a href="index.jsp" target="_blank">Regresar al Login</a>

			<% 	
			}
		
		%>
		
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
	</body>
</html>