package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AnyadirJuego
 */
@WebServlet("/AnyadirJuego")
public class AnyadirJuego extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AnyadirJuego() {
		super();
	}

	/**
	 * Muestra el formulario de anyadir juego o te reenvia a main si no es admin
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean logged = false;
		String user = "";
		boolean admin = false;

		/*
		 * Creamos la sesion
		 */
		HttpSession sesion = request.getSession(true);

		/*
		 * Coge el atributo usuario de la sesion
		 */
		user = (String) sesion.getAttribute("user");

		/*
		 * Si encuentra hay algo que se guarde en user significa que hay un usuario
		 * Logged y ademas comprueba que sea admin
		 */
		if (user != null && !user.contentEquals("")) {
			logged = true;
			admin = query.Mantenimiento.esAdministrador(user);

		}

		/*
		 * Si esta logged muestra la pagina para usuarios loggeados y si no la busqueda
		 * normal. En caso de ser un admin mostrara su html
		 */
		if (logged == true && admin == true) {

			response.getWriter().print(mostrarAdmin(user));

		} else if (logged) {

			response.sendRedirect("Main");
		} else {

			response.sendRedirect("Main");
		}
	}

	/**
	 * Muestra el html para el admin
	 * 
	 * @param user nick de usuario
	 * @return html
	 */
	public String mostrarAdmin(String user) {

		String html = "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<title>Gameland - Login</title>\n"
				+ "<meta charset=\"UTF-8\">\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"gameland.css\" />\n" + "\n" + "</head>\n"
				+ "<body>\n" + "	<div class=\"nav\">\n" + "		<div class=\"header\">\n"
				+ "			<div class=\"logoHeader\"></div>\n" + "			<h1>Gameland</h1>\n"
				+ "			<div class=\"nodoInvisibleHeader\"></div>\n" + "			<div class=\"usuario\">\n"
				+ "				<div>\n" + "					<p class=\"nombreUsuario\">" + user + "</p>\n"
				+ "					<a class=\"fotoUsuario\">imagen</a>\n" + "				</div>\n"
				+ "				<div>\n" + "<a href=\"Logout\">Log Out</a>"

				+ "				</div>\n" + "			</div>\n" + "		</div>\n" + "		<div class=\"tab\">\n"
				+ "			<ul>\n" + "				<li><a href=\"Main\">SEARCH</a></li>\n"
				+ "				<li><a href=\"#\">TOP Games</a></li>\n"
				+ "				<li><a href=\"MostarPorGenero\">By Genre</a></li>\n" + "				<li>|</li>\n"
				+ "				<li><a href=\"MostrarPorPlataforma\">By Platform</a></li>\n" + "			</ul>\n"
				+ "		</div>\n" + "	</div>\n" + crearFicha() + "	<div class=\"footer\">\n"
				+ "		<p>Web creada por XENOTECK INDUSTRIES copyright 2019</p>\n" + "	</div>\n" + "</body>\n"
				+ "</html>";

		return html;

	}

	/**
	 * Crea la ficha para anyadir un juego
	 * 
	 * @return string con la ficha
	 */
	public String crearFicha() {

		String html = "	<div class=\"container\">\n" + "	<form method=\"POST\" action=\"AnyadirJuego\">\n"
				+ "		<div>\n" + "			<h1>Añadir Juego</h1>\n" + "		</div>\n" + "		<div>\n"
				+ "			<p>Titulo</p>\n" + "			<input type=\"text\" name=\"titulo\" value='" + "'>\n"
				+ "		</div>\n" + "		<div>\n" + "			<p>Genero</p>\n"
				+ "			<select name=\"genero\">\n" + "				<option value=\"1\">SHOOTER</option>\n"
				+ "				<option value=\"2\" selected>DEPORTE</option>\n"
				+ "				<option value=\"3\">ESTRATEGIA</option>\n"
				+ "				<option value=\"4\">PUZZLE</option>\n" + "\n" + "			</select>\n"
				+ "		</div>\n" + "		<div>\n" + "			<p>Plataforma</p>\n"
				+ "			<select name=\"plataforma\">\n" + "				<option value=\"1\">PS4</option>\n"
				+ "				<option value=\"2\" selected>XBOX</option>\n"
				+ "				<option value=\"3\">SWITCH</option>\n"
				+ "				<option value=\"4\">PC</option>\n" + "\n" + "			</select>\n"
				+ "		</div>\n" + "<input style='display: none' name='id' value='" + "'/>" + "		<div>\n"
				+ "			<p>Año</p>\n" + "			<input type=\"number\" name=\"anyo\" value='" + "' />\n"
				+ "		</div>\n" + "		<div>\n" + "			<p>Descripcion</p>\n"
				+ "			<input type=\"text\" name=\"descripcion\" value='" + "'>\n" + "		</div>\n"
				+ "		<div>\n" + "			<p>Foto</p>\n"
				+ "			<input type=\"file\" name=\"img\" value=\"examinar\">\n" + "		</div>\n"
				+ "		<div>\n" + "			<input type=\"submit\" value=\"Editar\" />\n" + "		</div>\n"
				+ "	</form>\n" + "	</div>";

		return html;

	}

	/**
	 * Comprueba que no este vacio ningun campo y hace el insert
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String titulo = "";
		int year = 0;
		String desc = "";
		int plataforma = 0;
		int genero = 0;
		String foto = "";

		try {
			titulo = request.getParameter("titulo");
			year = Integer.parseInt(request.getParameter("anyo"));
			desc = request.getParameter("descripcion");
			plataforma = Integer.parseInt(request.getParameter("plataforma"));
			genero = Integer.parseInt(request.getParameter("genero"));
			foto = "prueba";
		} catch (Exception e) {
			// Logger
		}
		foto = "prueba";

		if (titulo.equals("") || year == 0 || desc.equals("") || plataforma <= 0 || plataforma > 4 || genero <= 0
				|| genero > 4 || foto.equals("")) {

			response.sendRedirect("GameManagement");

		} else {
			query.Mantenimiento.addGame(titulo, year, desc, plataforma, genero, foto);
			response.sendRedirect("GameManagement");

		}
	}

}
