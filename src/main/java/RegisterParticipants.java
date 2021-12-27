import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/Registered")
public class RegisterParticipants extends HttpServlet {
    DAOLayer conn;
    RegisterParticipants(){
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String userName = "system";
        String pass = "1234";
        conn = new DAOLayer();
        conn.registration(url, userName, pass);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        String a1=req.getParameter("AeName");
        String a2=req.getParameter("AeNumber");
        String a3=req.getParameter("cNumber");
        String a4=req.getParameter("cname");
        try{
            PreparedStatement m2 = conn.obj.prepareStatement("insert into card (EventName,EventNo,coordinatorName,cardHolderName)values(?,?,?,?)");
            m2.setString(1,a1);
            m2.setString(2,a2);
            m2.setString(3,a3);
            m2.setString(4,a4);
            m2.executeUpdate();
            System.out.println("Values are inserted using prepared statement");
            RequestDispatcher rd=req.getRequestDispatcher("Registerforevents.html");
            rd.include(req,resp);
            out.println("<center><h1>Participants Registered Sucessfully</h1></center>");
        }catch(Exception exe){System.out.println("Exception caught"+exe);
        }
    }
}
