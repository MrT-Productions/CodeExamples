package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.elon.apps.App;
import edu.elon.apps.AppDBManager;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * This servlet reads the request params then directs to the 
	 * correct page via a request dispatcher
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *  response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
		HttpSession mySession = request.getSession();
		RequestDispatcher rd = null;
		String appCode = request.getParameter("appCode");
//		String companyName = request.getParameter("menu");
		synchronized (mySession) {
			App a = (App) mySession.getAttribute("appBean");
			AppDBManager adbm = new AppDBManager();
			if(a == null){
				a = new App("","","","","","","","","");
				
				a.setAppCode("");
				a.setDevelopersName("");
				a.setAppTitle("");
				a.setAppCatagory("Business");
				a.setPrice("");
				a.setRating("");
				a.setDateUpdated("");
				a.setCurrentVersion("");
				a.setAppDescription("");
				mySession.setAttribute("appBean", a);
//				mySession.getAttribute("appBean");
			}
//		
//			mySession.getAttribute("appBean");
//			a.setAppCode("");
//			a.setDevelopersName("");
//			a.setAppTitle("");
//			a.setAppCatagory("Business");
//			a.setPrice("");
//			a.setRating("");
//			a.setDateUpdated("");
//			a.setCurrentVersion("");
//			a.setAppDescription("");
		
		if(request.getParameter("viewall") != null){
			try {
				mySession.getAttribute("appBean");
				ArrayList<App> allApps = adbm.getAllApps();
				mySession.setAttribute("viewAllApps", allApps);
				for(App b : allApps){
					a.setAppCode(b.getAppCode());
				}
				rd = request.getRequestDispatcher("/WEB-INF/app_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(request.getParameter("addapp") != null){
			mySession.getAttribute("appBean");
			a.setAppCode("");
			a.setDevelopersName("");
			a.setAppTitle("");
			a.setAppCatagory("Business");
			a.setPrice("");
			a.setRating("");
			a.setDateUpdated("");
			a.setCurrentVersion("");
			a.setAppDescription("");
			rd = request.getRequestDispatcher("/WEB-INF/app.jsp");
			rd.forward(request, response);
		}
		else if(request.getParameter("updateApp") != null){
			rd = request.getRequestDispatcher("/UpdateAppServlet");
			rd.forward(request, response);
		}
		else if(request.getParameter("editLink") != null){
			try {
				mySession.getAttribute("appBean");
				ArrayList<App> foundApp = adbm.findApp(appCode);
				mySession.setAttribute("findApp", foundApp);
				for(App b : foundApp){
					a.setAppCode(b.getAppCode());
					a.setDevelopersName(b.getDevelopersName());
					a.setAppTitle(b.getAppTitle());
					a.setAppCatagory(b.getAppCatagory());
					a.setPrice(b.getPrice());
					a.setRating(b.getRating());
					a.setDateUpdated(b.getDateUpdated());
					a.setCurrentVersion(b.getCurrentVersion());
					a.setAppDescription(b.getAppDescription());
				}
				rd = request.getRequestDispatcher("/WEB-INF/app.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		else if(request.getParameter("menu") != null){
//			mySession.getAttribute("companyName");
//			mySession.getAttribute(companyName);
//			ServletConfig config = getServletConfig();
//			ServletContext context = getServletContext(); 
//		    if(companyName == null){companyName = "No Company Name";}
//			context.setAttribute("companyName", companyName);
			rd = request.getRequestDispatcher("/WEB-INF/elonapp.jsp");
			rd.forward(request, response);
		}
		else{
			rd = request.getRequestDispatcher("/DeleteServlet");
			rd.forward(request, response);
		}
	}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse 
	 * response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
		doGet(request,response);
	}

}
