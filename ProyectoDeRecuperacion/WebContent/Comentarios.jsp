<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="ec.edu.ups.entidades.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Cliente cliente = (Cliente) request.getAttribute("cliente"); %>
	<% List<Comentario> comentarios = (List<Comentario>) request.getAttribute("comentarios"); %>
	<form action="/ProyectoDeRecuperacion/loguin.xhtml" method="post">
		<input type="submit" value="Inicio">
	</form>
	<form action="/ProyectoDeRecuperacion/ControladorComentario" method="post">
		<input type="hidden" name="idCli" value="<%=cliente.getCodigo()%>">
		<%= cliente.getNombre()+" "+cliente.getApellido() %>
		<input type="text" name="comentario">
		<input type="submit" name="agregar" value="Agregar">
	</form>
	<table class='tg' style='width:25%'>
		<tr>
	        <th class='tg-46ru'>Cliente</th>
	        <th class='tg-46ru'>Comentario</th>
	    </tr>
	    <% for (int i=0;i<comentarios.size();i++){
	    		Comentario comentario=comentarios.get(i);
	    		out.println("<tr><td class='tg-y698'>"+comentario.getCliente().getNombre()+" "+comentario.getCliente().getApellido()+
	    					"</td><td class='tg-y698'>"+comentario.getComentario()+"</td>");
	       }
	    %>
	</table>
</body>
</html>