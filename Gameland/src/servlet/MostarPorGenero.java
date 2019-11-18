package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostarPorGenero
 */
@WebServlet("/MostarPorGenero")
public class MostarPorGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostarPorGenero() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    /**
     * EJEMPLO QUERY POR GENERO
     * 
     * SELECT TITULO, MEDIA 
FROM JUEGO,
(
	SELECT AVG(VALORACION) as MEDIA,  IDJUEGO 
	FROM VALORACION
	GROUP BY IDJUEGO
)TVALORACION 
WHERE JUEGO.ID = TVALORACION.IDJUEGO AND IDGENERO = 1
ORDER BY MEDIA DESC;


     */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
