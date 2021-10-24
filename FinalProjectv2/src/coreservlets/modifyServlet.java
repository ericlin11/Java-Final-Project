package coreservlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/modify")
public class modifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uID = "cst4713";
		String password = "password1";
		HttpSession session = request.getSession();
		//lookupservice2 service = new mapper2();
		modifyService service = new modifyMapper();
		String emplid = request.getParameter("ssn");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String date = month + "/" + day + "/" + year;
		
	    modifyBean mod1 = service.mod1(emplid,uID,password,date);
		String address;
		 
		 if(mod1.getInfo() != null){
			 address = "Modify.jsp";
		 }
		 else{
			 address = "/WEB-INF/results/failed.jsp";
		 }
		    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		    dispatcher.forward(request, response);		
}

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
	}