package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.elon.apps.App;
import edu.elon.apps.AppDBManager;

/**
 * Servlet implementation class UpdateAppServlet
 */
@WebServlet("/UpdateAppServlet")
public class UpdateAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAppServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Retrieves the app via its appCode then read all of the 
	 * incoming request params and sets a new instance of 
	 * it into the app on the session
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *  response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
		HttpSession mySession = request.getSession();
		
		App a = (App) mySession.getAttribute("appBean");
		if(a == null){
			a = new App("","","","","","","","","");
			mySession.setAttribute("appBean", a);
		}
		RequestDispatcher rd = null;
		synchronized (mySession){
			try {
				
				String appCode = request.getParameter("appCode");
				String ac = a.getAppCode();
				AppDBManager adbm = new AppDBManager();
				ArrayList<App> foundApp = adbm.findApp(ac);
//				mySession.setAttribute("findApp", foundApp);
				
				for(App b : foundApp){
					b.setAppCode(request.getParameter("code"));
					b.setDevelopersName(request.getParameter("devN"));
					b.setAppTitle(request.getParameter("title"));
					b.setAppCatagory(request.getParameter("cata"));
					b.setPrice(request.getParameter("pr"));
					b.setRating(request.getParameter("avr"));
					b.setDateUpdated(request.getParameter("dup"));
					b.setCurrentVersion(request.getParameter("cv"));
					b.setAppDescription(request.getParameter("appD"));
					a = b;
					adbm.updateApp(a);
				}
				adbm.updateApp(a);
				if(a != null){
					adbm.insertApp(a);
				}
				
//				mySession.setAttribute("appBean", a);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		rd = request.getRequestDispatcher("/ControllerServlet?viewall=");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse 
	 * response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
		doGet(request, response);
	}

}
