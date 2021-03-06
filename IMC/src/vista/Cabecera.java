package vista;

import java.io.PrintWriter;

import model.entidad.Usuario;
/**
 * Clase que tiene el codigo html de las diferentes cabeceras
 * @author horabaixa
 *
 */
public class Cabecera {

	/**
	 * Muestra la cabecera estandar de un usuario logged
	 * @param out printwriter que sirve para mostrar
	 * @param user usuario logeado
	 */
	public static void mostrarLogged(PrintWriter out, Usuario user) {
		String imagen;
		if(user.getImagen() == null) {
			imagen = "estandar.png";
		}else {
			imagen = user.getImagen();
		}
		String html = "<!DOCTYPE html>\n" + "<html>\n" + "    <head>\n" + "        <title>IMC</title>\n"

				+ "        <meta charset=\"UTF-8\">\n"
				+ "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "        <link rel=\"stylesheet\" type=\"text/css\" href=\"imc.css\"/>\n" + "\n"
				+ "    </head>\n" + "    <body>\n" + "        <div class=\"nav\">\n"
				+ "            <div class=\"header\">  \n"
				+ "                <div class=\"logoHeader\"></div><h1>IMC</h1>\n"
				+ "                <div class=\"nodoInvisibleHeader\"></div>\n"
				+ "                <div class=\"usuario\">\n" + "                    <div>\n"
				+ "                        <p class=\"nombreUsuario\">" + user.getNombre()
				+ "</p> <div class=\"fotoUsuario\" style='background-image: url(imagenes/"+imagen+")'></div>\n" + "                    </div>\n"
				+ "                    <div>            \n"
				+ "                        <a href=\"Login?logout=1\">Log Out</a> <p>" + " </div>\n"
				+ "                </div>\n" + "            </div>\n" ;

		//Pinta el html
		out.append(html);
	};
	/**
	 * Muestra la cabecera para usuarios no logeados
	 * @param out printwriter que sirve para mostrar
	 */
	public static void mostrarNoLogged(PrintWriter out) {
		String html = "<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<title>IMC</title>\n" + 
				"<meta charset=\"UTF-8\">\n" + 
				"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + 
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"imc.css\" />\n" + 
				"\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"	<div class=\"nav\">\n" + 
				"		<div class=\"header\">\n" + 
				"			<div class=\"logoHeader\"></div>\n" + 
				"			<h1>IMC</h1>\n" + 
				"			<div class=\"nodoInvisibleHeader\"></div>\n" + 
				"			<div class=\"usuario\">\n" + 
				"				<div>\n" + 
				"					<p class=\"nombreUsuario\">Usuario</p>\n" + 
				"					<div class=\"fotoUsuario\"  style='background-image: url(imagenes/estandar.png)' ></div>\n" + 
				"				</div>\n" + 
				"				<div>\n" + 
				"					<a href=\"Login\">LogIn</a>\n" + 
				"					<p>|</p>\n" + 
				"					<a href=\"Register\"> Register</a>\n" + 
				"				</div>\n" + 
				"			</div>\n" + 
				"		</div>" ;

		//Pinta el html
		out.append(html);
	};

}
