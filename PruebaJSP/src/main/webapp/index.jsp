<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ejercicio JSP</title>
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
		
	</head>
	<body>
		<%! List<String> paises = new ArrayList<>(); %>

		<%
			if(!paises.isEmpty()){
				paises.clear();
			}
			paises.add("Honduras");
			paises.add("El Salvador");
			paises.add("Guatemala");
			paises.add("Nicaragua");
			paises.add("Costa Rica");
			paises.add("Panamá");
			
			String usuario = (String)session.getAttribute("USUARIO_LOGIN");
			if(usuario==null || "".equals(usuario)){
						session.setAttribute("LISTA_PAISES", paises);
						
						if("POST".equalsIgnoreCase(request.getMethod())){
							out.print("<h2>Usuario ingreso correctamente!</h2>");
						}
					%>
			 	<div class="container-md">
			        <div class="row justify-content-center">
			            <div class="col-md-4">
			                <div class="card">
			                    <div class="card-header text-center">
			                        <h3>Inicio de Sesión</h3>
			                    </div>
			                    <div class="card-body">
			                        <form method="post" action="home.jsp">
			                            <div class="mb-3">
			                                <label for="username" class="form-label">Usuario</label>
			                                <input type="text" class="form-control" id="username" name="username" required>
			                            </div>
			                            <div class="mb-3">
			                                <label for="password" class="form-label">Clave</label>
			                                <input type="password" class="form-control" id="password" name="password" required>
			                            </div>
			
			                            <div class="input-group mb-3">
			                                <label class="input-group-text" for="inputGroupSelect">País</label>
			                                <select class="form-select" if="inputGroupSelect" id="idpais" name="idpais">
			                                	<option selected>Seleccione un País...</option>
			                                	<% 
			                                		int contador = 0;
			                                		for(String pais: paises){
			                                			contador++;
			                                	%>
				                                		<option value="<%= contador %>"><%= pais %></option>
			                                	<% } %>
			                                </select>
			                            </div>
			                            <button type="submit" class="btn btn-outline-primary w-100">Ingresar</button>
			                        </form>
			                    </div>
			                </div>
			            </div>
			        </div>
			    </div>
    
    	<%
    
				}else{
					%>		
					<p>Ya iniciaste sesión</p>	
				<%}
    	%>
			
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
	</body>
</html>
