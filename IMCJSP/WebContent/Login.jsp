<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>IMC - Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%
//Recupero el modo visual estipulado
	HttpSession sesion = request.getSession(true);
	String modo = (String) sesion.getAttribute("color");

	if (modo == null) {
		out.print("<link rel='stylesheet' type='text/css' href='imc.css' />");

	}else{
		
	
	if (modo.equals("l")) {
		out.print("<link rel='stylesheet' type='text/css' href='imc.css' />");
	} else {
		out.print("<link rel='stylesheet' type='text/css' href='imcDark.css' />");
	}}
%>

</head>
<body>
	<div class="nav">
		<div class="header">
			<div class="logoHeader"></div>
			<h1>IMC</h1>
			<div class="nodoInvisibleHeader"></div>
			<div class="usuario">
				<div>
					<p class="nombreUsuario">Usuario</p>
					<div class="fotoUsuario" style='background-image: url(imagenes/estandar.png)'></div>
				</div>
				<div>
					<a href="Login">LogIn</a>
					<p>|</p>
					<a href="Register"> Register</a>
				</div>
			</div>
		</div>
		<div class="tab">
			<ul>
				<li><a href='Main'>HOME</a></li>
								<li><a href='ChangeMode'>Cange Mode</a></li>
				
			</ul>
		</div>
	</div>
	<div class="container">
		<form method="POST" action="Login">
			<div>
				<p>Usuario</p>
				<input type="text" name="user" />
			</div>
			<div>
				<p>Contraseña</p>
				<input type="password" name="pass" />
			</div>
			<input type="submit" value="Log In" />
		</form>
	</div>
	<div class="footer">
		<p>Web creada por XENOTECK INDUSTRIES copyright 2019</p>
	</div>
</body>
</html>