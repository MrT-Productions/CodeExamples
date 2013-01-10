package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.elon.apps.AppDBManager;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse 
	 * response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
		HttpSession mySession = request.getSession();
		RequestDispatcher rd = null;
		synchronized (mySession) {
			try {
			String appCode = request.getParameter("appCode");
			AppDBManager adbm = new AppDBManager();
			adbm.deleteApp(appCode);
			rd = request.getRequestDispatcher("/ControllerServlet?viewall=");
			rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *  response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
		doGet(request, response);
	}

}
