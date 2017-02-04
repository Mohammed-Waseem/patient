package DataPhiLabs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataPhiLabs.bean.PatientBean;


public class patientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public patientServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doWork(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doWork(request, response);
	}

	private void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String bday = request.getParameter("bday");
		String age =request.getParameter("age");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String textArea = request.getParameter("textArea");
		
		PatientBean bean = new PatientBean();
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setBady(bday);
		bean.setAge(age);
		bean.setGender(gender);
		bean.setPhone(phone);
		bean.setTextArea(textArea);
		
		if(bean.insert())
		{
			
			response.sendRedirect("Pages/PatientInformation.jsp?success=true");
		}
		else
		{
			response.sendRedirect("pages/hello.jsp?success=false");
		}
		
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(bday);
		System.out.println(age);
		System.out.println(gender);
		System.out.println(phone);
		System.out.println(textArea);
	}

}
