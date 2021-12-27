import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/EnterPage")
public class ParticipantsDetails extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        String username=req.getParameter("Ausername");
        String password=req.getParameter("Apassword");
        try {
            if(LoginValidate.Validation(username,password)){
                RequestDispatcher rd=req.getRequestDispatcher("ParticipantEvent.html");
                rd.forward(req,resp);
            }
            else{
                RequestDispatcher rd=req.getRequestDispatcher("plogin.html");
                rd.include(req,resp);
                out.println("<h3 style='text-align:center' id='common'>Invalid Login Credential</h3><br>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
