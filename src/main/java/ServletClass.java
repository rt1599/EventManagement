import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/ValidateAd")
public class ServletClass extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw= resp.getWriter();
        resp.setContentType("text/html");
        String username1="Rishabh";
        String password1="rishabh1599";
        if(username1.equals(req.getParameter("Ausername")) && password1.equals(req.getParameter("Apassword"))){
            RequestDispatcher rd= req.getRequestDispatcher("Admin.html");
            rd.forward(req,resp);
        }
        else{
            pw.println("<center><h1>Invalid Login Credentials</h1><center>");
            RequestDispatcher rd=req.getRequestDispatcher("Alogin.html");
            rd.include(req,resp);
        }
    }
}
