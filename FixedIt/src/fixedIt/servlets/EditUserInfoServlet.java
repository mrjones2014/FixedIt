package fixedIt.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fixedIt.controllers.UserInfoController;


public class EditUserInfoServlet extends HttpServlet {			
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Cache-Control","no-cache");
		resp.setHeader("Cache-Control","no-store");
		if((fixedIt.modelComponents.Session) req.getSession().getAttribute("userSession")==null){
			resp.sendRedirect("login");
			return;
		}
		String errorMessage = null;
		UserInfoController controller=new UserInfoController((fixedIt.modelComponents.Session) req.getSession().getAttribute("userSession"));
		String emailAddress="";
		String studentStatus="";
		if(controller.isSessionNull()){
			errorMessage="Error loading session.";
		}
		else{
			emailAddress=controller.getUser().getEmailAddress();
			if(controller.getUser().getStudentStatus()==0){
				studentStatus="Full Time";
			}
			else{
				studentStatus="Part Time";
			}
		}
		
		
		req.setAttribute("emailAddress", emailAddress);
		req.setAttribute("studentStatus", studentStatus);
		req.setAttribute("errorMessage", errorMessage);		
		req.getRequestDispatcher("/_view/editUserInfo.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		// Decode form parameters and dispatch to controller	
	
		
		// Add parameters as request attributes
	
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/editUserInfo.jsp").forward(req, resp);
	}

//	private String getStringFromParameter(String s) {
//		if (s == null || s.equals("")) {
//			return null;
//		} else {
//			return s;
//		}
//	}
}