import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet("/NewLogin")
public class LoginServletClass extends HttpServlet {
    DAOLayer conn;
    LoginServletClass(){
        String url = "jdbc:oracle:thin:@//localhost:1521/XE";
        String userName = "system";
        String pass = "1234";
        conn = new DAOLayer();
        conn.registration(url, userName, pass);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        String emailId=req.getParameter("email");
        String user=req.getParameter("Aname");
        String usern=req.getParameter("Ausername");
        String pass=req.getParameter("Apassword");
        String passc=req.getParameter("Aconfirmpassword");
        if(pass.equals(passc)){
            try {
                PreparedStatement m2=conn.obj.prepareStatement("insert into Participants(emailId,name ,username,password ,confirmpassword) values(?,?,?,?,?)");
                m2.setString(1,emailId);
                m2.setString(2,user);
                m2.setString(3,usern);
                m2.setString(4,pass);
                m2.setString(5,passc);
                m2.executeUpdate();
                System.out.println("Values are inserted using prepared statement");
//                RequestDispatcher dispatcher= req.getRequestDispatcher("ParticipantsDatails.html");
//                dispatcher.forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else {
            out.println("<h3 style='text-align:center' id='common'>Invalid Input</h3><br>");
            RequestDispatcher rd=req.getRequestDispatcher("Psignup.html");
            rd.include(req,resp);

        }
    }
}
