package hn.uth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DivisionCuentas
 */
@WebServlet("/DivisionCuentas")
public class DivisionCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DivisionCuentas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String metodo = request.getMethod();
		if("POST".equalsIgnoreCase(metodo)) {
			int cantidadPersonas = Integer.parseInt(request.getParameter("personas"));
			double monto = Double.parseDouble(request.getParameter("monto"));
			
			double total = monto/cantidadPersonas;
			
			response.setContentType("text/html;charset=UTF-8");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().println("<!DOCTYPE html>");
	        response.getWriter().println("<head>");
	        response.getWriter().println("<meta charset='UTF-8'>");
	        response.getWriter().println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
	        response.getWriter().println("<title>Servlet de división de cuentas</title>");

	        response.getWriter().println("</head>");
	        response.getWriter().println("<html><body>");
			
			response.getWriter().append("<h2>Resultado</h2>");
			response.getWriter().append("<h4>Dividiendo la cuenta entre "+cantidadPersonas+" personas </h4>");
			response.getWriter().append("<h4>A cada persona le toca poner "+total+" lempiras </h4>");
			
			response.getWriter().println("</body>");
			response.getWriter().println("</html>");
			
		}else {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			response.getWriter().append("\nServlet DivisionCuentas llamado");
			response.getWriter().append("\nUniversidad Tecnologica de Honduras");
			response.getWriter().append("\nProgramacion Web 2");
			response.getWriter().append("\nEl metodo invocado fue: "+metodo);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
